package com.example.NoteSharingSystem.controller;

import com.example.NoteSharingSystem.model.Note;
import com.example.NoteSharingSystem.repository.NoteRepository;
import com.example.NoteSharingSystem.service.EmailService;
import com.example.NoteSharingSystem.util.OTPGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.mail.MessagingException;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private EmailService emailService;

    @PostMapping("/create")
    public ResponseEntity<String> createNote(
            @RequestParam(value = "content", required = true) String content,
            @RequestParam(value = "recipientEmail", required = true) String email) throws MessagingException {

        // Generate a unique link ID and an OTP
        String uniqueLinkId = UUID.randomUUID().toString();
        String otp = OTPGenerator.generateOTP(6);

        // Create a new Note object and save it to the repository
        Note note = new Note();
        note.setContent(content);
        note.setOtp(otp);
        note.setUniqueLinkId(uniqueLinkId);
        note.setAccessed(false);
        noteRepository.save(note);

        // Create the link to access the note
        String accessLink = "http://localhost:8080/notes/access/" + uniqueLinkId;

        // Send the OTP and access link via email
        emailService.sendOtpEmail(email, otp, accessLink);

        return ResponseEntity.ok("Note created. OTP sent to " + email + ". Access it via the provided link.");
    }

    @PostMapping("/access/{uniqueLinkId}")
    public ResponseEntity<String> accessNote(
            @PathVariable("uniqueLinkId") String uniqueLinkId,
            @RequestParam("otp") String otp) {

        // Find the note by its unique link ID
        Optional<Note> noteOptional = noteRepository.findByUniqueLinkId(uniqueLinkId);

        if (noteOptional.isPresent()) {
            Note note = noteOptional.get();
            // Check if the note has already been accessed
            if (note.isAccessed()) {
                return ResponseEntity.status(410).body("This note has already been accessed.");
            }

            // Validate the OTP
            if (note.getOtp().equals(otp)) {
                note.setAccessed(true);
                noteRepository.save(note);
                return ResponseEntity.ok("Note content: " + note.getContent());
            } else {
                return ResponseEntity.status(403).body("Incorrect OTP.");
            }
        } else {
            return ResponseEntity.status(404).body("Note not found.");
        }
    }
}

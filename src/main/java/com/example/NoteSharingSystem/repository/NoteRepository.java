package com.example.NoteSharingSystem.repository;

import com.example.NoteSharingSystem.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Long> {
    Optional<Note> findByUniqueLinkId(String uniqueLinkId);
}
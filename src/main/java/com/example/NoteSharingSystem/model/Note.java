package com.example.NoteSharingSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String otp; // Assuming these are the fields you need
    private String uniqueLinkId; // Assuming this is also a field
    private boolean accessed;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getUniqueLinkId() {
        return uniqueLinkId;
    }

    public void setUniqueLinkId(String uniqueLinkId) {
        this.uniqueLinkId = uniqueLinkId;
    }

    public boolean isAccessed() {
        return accessed;
    }

    public void setAccessed(boolean accessed) {
        this.accessed = accessed;
    }
}
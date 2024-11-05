# OTP-PROTECTED NOTE SHARING SYSTEM

## OVERVIEW
The **OTP-Protected Note Sharing System** is a secure platform that allows users to share notes and messages that self-destruct after being viewed once. Each message is accessed through a unique link that requires the recipient to enter a password and an OTP (One-Time Password). This system ensures confidentiality and security of the shared information, making it ideal for sensitive data transmission.

## FEATURES
- **One-Time Access**: Each shared note can only be accessed once through a unique link.
- **OTP Verification**: The recipient must enter an OTP sent via email to access the note, ensuring that only the intended recipient can view it
- **Self-Destructing Messages**: After being accessed, the message is automatically deleted from the server, ensuring it cannot be retrieved later
- **Email Notifications**: Users receive notifications upon successful sharing of notes
- **Backend Implementation Only**: No frontend UI at this time

## TECHNOLOGIES USED
- **Java**: The core programming language for backend development
- **Spring Boot**: Framework for building the application
- **Jakarta Mail (formerly JavaMail)**: For sending emails with OTP
- **Maven**: Dependency management and build tool
- **H2 Database**: For development purposes, particularly in-memory databases for testing
- **HTML/CSS**: For frontend design

## PREREQUISITES
To run this project, you will need:
- **Java Development Kit (JDK)**: Version 11 or higher
- **Maven**: For building and managing the project dependencies

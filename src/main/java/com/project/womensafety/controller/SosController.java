package com.project.womensafety.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.womensafety.service.EmailService;

@RestController
@RequestMapping("/api/sos")
public class SosController {
    private final EmailService emailService;

    public SosController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendSos(@RequestBody Sos) {
        emailService.sendSosEmail(email, latitude, longitude);
        return ResponseEntity.ok("SOS email sent to " + email);
    }
}


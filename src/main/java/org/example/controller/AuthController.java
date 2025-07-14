package org.example.controller;
import org.example.dto.SignupRequest;
import org.example.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // Signup Endpoint
    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody SignupRequest request) {
        String message = authService.registerUser(request);
        return ResponseEntity.ok(message);
    }

    // Login Endpoint (For Basic Auth only)
    @PostMapping("/login")
    public ResponseEntity<String> login() {
        // If HTTP Basic Auth is used, login is handled by Spring Security
        return ResponseEntity.ok("Login successful!");
    }
}

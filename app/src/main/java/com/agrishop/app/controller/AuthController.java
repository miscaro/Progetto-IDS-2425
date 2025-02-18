package com.agrishop.app.controller;

import com.agrishop.app.entity.Ruoli;
import com.agrishop.app.entity.Utente;
import com.agrishop.app.service.AuthService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/registrazione")
    public ResponseEntity<UtenteResponse> registrazione(@RequestBody RegistrazioneRequest request) {
        Utente utente = authService.registrazione(
                request.username(),
                request.password(),
                request.ruolo()
        );
        return ResponseEntity.ok(new UtenteResponse(utente));
    }

    public record RegistrazioneRequest(
            String username,
            String password,
            Ruoli ruolo
    ) {}

    public record LoginRequest(String username, String password) {}

    public record UtenteResponse(
            Long id,
            String username,
            @JsonProperty("ruolo") Ruoli role) {

        public UtenteResponse(Utente utente) {
            this(utente.getId(), utente.getUsername(), utente.getRuolo());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<UtenteResponse> login(@RequestBody LoginRequest request) {
        Utente utente = authService.login(
                request.username(),
                request.password()
        );
        return ResponseEntity.ok(new UtenteResponse(utente));
    }

}

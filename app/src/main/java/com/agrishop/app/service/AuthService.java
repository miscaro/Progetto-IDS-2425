package com.agrishop.app.service;

import com.agrishop.app.entity.Ruoli;
import com.agrishop.app.entity.Utente;
import com.agrishop.app.repository.FakeAuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final FakeAuthRepository utenteRepository;

    public AuthService(FakeAuthRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    public Utente registrazione(String username, String password, Ruoli ruolo) {
        if(utenteRepository.existsByUsername(username)) {
            throw new RuntimeException("Username già esistente");
        }

        Utente nuovoUtente = new Utente();
        nuovoUtente.setUsername(username);
        nuovoUtente.setPassword(password);
        nuovoUtente.setRuolo(ruolo);

        return utenteRepository.save(nuovoUtente);
    }

    public Utente login(String username, String password) {
        return utenteRepository.findByUsername(username)
                .filter(u -> u.getPassword().equals(password))
                .orElseThrow(() -> new RuntimeException("Credenziali non valide"));
    }
}
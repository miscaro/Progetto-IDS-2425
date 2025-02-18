package com.agrishop.app.repository;

import com.agrishop.app.entity.Utente;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class FakeAuthRepository {
    private final Map<String, Utente> utenti = new ConcurrentHashMap<>();

    public Utente save(Utente utente) {
        utenti.put(utente.getUsername(), utente);
        return utente;
    }

    public Optional<Utente> findByUsername(String username) {
        return Optional.ofNullable(utenti.get(username));
    }

    public boolean existsByUsername(String username) {
        return utenti.containsKey(username);
    }
}


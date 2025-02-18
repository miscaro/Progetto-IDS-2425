package com.agrishop.app.entity;

public enum Ruoli {
    PRODUTTORE(true),
    DISTRIBUTORE(true),
    TRASFORMATORE(true),
    CURATORE,
    GESTORE_PIATTAFORMA,
    ANIMATORE_FILIERA,
    ACQUIRENTE;

    private final boolean venditore;

    Ruoli() {
        this(false);
    }

    Ruoli(boolean venditore) {
        this.venditore = venditore;
    }

    public boolean isVenditore() {
        return venditore;
    }
}
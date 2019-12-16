package com.nis.banque.metier;

import com.nis.banque.entities.Compte;

public interface CompteMetier {
    public Compte saveCompte(Compte compte);
    public Compte getCompte(String codeCompte);
}

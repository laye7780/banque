package com.nis.banque.metier;

import com.nis.banque.dao.CompteRepository;
import com.nis.banque.entities.Compte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CompteMetierImpl implements CompteMetier {
    @Autowired
    private CompteRepository compteRepository;
    @Override
    public Compte saveCompte(Compte compte) {
        compte.setDatecreation(new Date());
        return compteRepository.save(compte);
    }

    @Override
    public Compte getCompte(String codeCompte) {
        Compte compte= compteRepository.findById(codeCompte).get();
        if(compte==null) throw new RuntimeException("Compte Introuvable");
        return compte;
    }
}

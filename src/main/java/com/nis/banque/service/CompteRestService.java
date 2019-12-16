package com.nis.banque.service;

import com.nis.banque.entities.Compte;
import com.nis.banque.metier.CompteMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CompteRestService {
    @Autowired
    private CompteMetier compteMetier;

    @RequestMapping(value = "/comptes",method = RequestMethod.POST)
    public Compte saveCompte(@RequestBody Compte compte) {
        return compteMetier.saveCompte(compte);
    }
    @RequestMapping(value = "/comptes/{code}",method = RequestMethod.GET)
    public Compte getCompte(@PathVariable("code") String codeCompte) {
        return compteMetier.getCompte(codeCompte);
    }


}

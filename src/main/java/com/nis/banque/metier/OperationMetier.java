package com.nis.banque.metier;

import com.nis.banque.entities.Compte;

public interface OperationMetier {
    public boolean Verser(String codeCompte,double montant, Long codeEmploye);
    public boolean Retirer(String codeCompte,double montant, Long codeEmploye);
    public boolean Virement(String codeCompte1, String codeCompte2, double montant, Long codeEmploye);
    public PageOperation getOperations(String codeCompte,int page,int size);

}

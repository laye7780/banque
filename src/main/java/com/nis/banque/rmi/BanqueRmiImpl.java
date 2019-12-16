package com.nis.banque.rmi;

import com.nis.banque.entities.Compte;
import com.nis.banque.metier.CompteMetier;
import com.nis.banque.metier.OperationMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.rmi.RemoteException;
@Component("myRmiService")
public class BanqueRmiImpl implements BanqueRmiRemote {
    @Autowired
    private CompteMetier compteMetier;
    @Autowired
    private OperationMetier operationMetier;

    @Override
    public Compte saveCompte(Compte compte) throws RemoteException {
        return compteMetier.saveCompte(compte);
    }

    @Override
    public Compte getCompte(String codeCompte) throws RemoteException {
        return compteMetier.getCompte(codeCompte);
    }

    @Override
    public boolean Verser(String codeCompte, double montant, Long codeEmploye) throws RemoteException {
        return operationMetier.Verser(codeCompte,montant,codeEmploye);
    }

    @Override
    public boolean Retirer(String codeCompte, double montant, Long codeEmploye) throws RemoteException {
        return operationMetier.Retirer(codeCompte,montant,codeEmploye);
    }

    @Override
    public boolean Virement(String codeCompte1, String codeCompte2, double montant, Long codeEmploye) throws RemoteException {
        return operationMetier.Virement(codeCompte1,codeCompte2,montant,codeEmploye);
    }
}

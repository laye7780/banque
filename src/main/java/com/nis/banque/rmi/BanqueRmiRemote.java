package com.nis.banque.rmi;

import com.nis.banque.entities.Compte;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BanqueRmiRemote extends Remote {
    public Compte saveCompte(Compte compte) throws RemoteException;
    public Compte getCompte(String codeCompte) throws RemoteException;
    public boolean Verser(String codeCompte,double montant, Long codeEmploye) throws RemoteException;
    public boolean Retirer(String codeCompte,double montant, Long codeEmploye) throws RemoteException;
    public boolean Virement(String codeCompte1, String codeCompte2, double montant, Long codeEmploye) throws RemoteException;
}

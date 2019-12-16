package com.nis.banque.service;

import com.nis.banque.dao.CompteRepository;
import com.nis.banque.dao.OperationRepository;
import com.nis.banque.entities.Compte;
import com.nis.banque.metier.CompteMetier;
import com.nis.banque.metier.OperationMetier;
import com.nis.banque.metier.PageOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
@Component
@WebService
public class BanqueSoapService {


    @Autowired
    private CompteMetier compteMetier;

    @Autowired
    private OperationMetier operationMetier;
    @WebMethod
    public Compte getCompte(@WebParam(name="codeCompte") String codeCompte) {
        return compteMetier.getCompte(codeCompte);
    }

    @WebMethod
    public boolean Verser(@WebParam(name="codeCompte") String codeCompte,@WebParam(name="montant") double montant,@WebParam(name="codeEmploye") Long codeEmploye) {
        return operationMetier.Verser(codeCompte, montant, codeEmploye);
    }
    @WebMethod
    public boolean Retirer(@WebParam(name="codeCompte") String codeCompte,@WebParam(name="montant") double montant,@WebParam(name="codeEmploye") Long codeEmploye) {
        return operationMetier.Retirer(codeCompte, montant, codeEmploye);
    }
    @WebMethod
    public boolean Virement(@WebParam(name="codeCompte1") String codeCompte1,@WebParam(name="codeCompte2") String codeCompte2,@WebParam(name="montant") double montant,@WebParam(name="codeEmploye") Long codeEmploye) {
        return operationMetier.Virement(codeCompte1, codeCompte2, montant, codeEmploye);
    }
    @WebMethod
    public PageOperation getOperations(@WebParam(name="codeCompte") String codeCompte,@WebParam(name="page") int page,@WebParam(name="size") int size) {
        return operationMetier.getOperations(codeCompte, page, size);
    }

}

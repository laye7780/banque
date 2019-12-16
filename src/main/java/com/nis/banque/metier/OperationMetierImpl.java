package com.nis.banque.metier;

import com.nis.banque.dao.CompteRepository;
import com.nis.banque.dao.EmployeRepository;
import com.nis.banque.dao.OperationRepository;
import com.nis.banque.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class OperationMetierImpl implements OperationMetier {
    @Autowired
    private OperationRepository operationRepository;
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private EmployeRepository employeRepository;


    @Override
    @Transactional
    public boolean Verser(String codeCompte, double montant, Long codeEmploye) {
        Compte compte=compteRepository.findById(codeCompte).get();
        Employe employe=employeRepository.findById(codeEmploye).get();
        Operation operation=new Versement();
        operation.setDateOperation(new Date());
        operation.setMontant(montant);
        operation.setCompte(compte);
        operation.setEmploye(employe);
        operationRepository.save(operation);
        compte.setSolde(compte.getSolde()+montant);
        return true;
    }

    @Override
    @Transactional
    public boolean Retirer(String codeCompte, double montant, Long codeEmploye) {

        Compte compte=compteRepository.findById(codeCompte).get();
        if(compte.getSolde()<montant) throw new RuntimeException("Solde insuffisant");
        Employe employe=employeRepository.findById(codeEmploye).get();
        Operation operation=new Retrait();
        operation.setDateOperation(new Date());
        operation.setMontant(montant);
        operation.setCompte(compte);
        operation.setEmploye(employe);
        operationRepository.save(operation);
        compte.setSolde(compte.getSolde() - montant);
        return true;
    }

    @Override
    @Transactional
    public boolean Virement(String codeCompte1, String codeCompte2, double montant, Long codeEmploye) {
        Retirer(codeCompte1,montant,codeEmploye);
        Verser(codeCompte2,montant,codeEmploye);
        return true;
    }

    @Override
    public PageOperation getOperations(String codeCompte, int page, int size) {
        Page<Operation>ops=operationRepository.getOperations(codeCompte, PageRequest.of(page,size));
        PageOperation pOp=new PageOperation();
        pOp.setOperations(ops.getContent());
        pOp.setNombreOperations(ops.getNumberOfElements());
        pOp.setPage(ops.getNumber());
        pOp.setTotalPages(ops.getTotalPages());
        pOp.setTotalOperations((int)ops.getTotalElements());
        return pOp;
    }


}

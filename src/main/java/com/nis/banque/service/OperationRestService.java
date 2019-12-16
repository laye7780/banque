package com.nis.banque.service;

import com.nis.banque.metier.OperationMetier;
import com.nis.banque.metier.PageOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationRestService {
    @RequestMapping(value = "/versement",method = RequestMethod.PUT)
    public boolean Verser(@RequestParam String codeCompte, @RequestParam double montant, @RequestParam Long codeEmploye) {
        return operationMetier.Verser(codeCompte, montant, codeEmploye);
    }
    @RequestMapping(value = "/retrait",method = RequestMethod.PUT)
    public boolean Retirer(@RequestParam String codeCompte, @RequestParam double montant, @RequestParam Long codeEmploye) {
        return operationMetier.Retirer(codeCompte, montant, codeEmploye);
    }
    @RequestMapping(value = "/virement",method = RequestMethod.PUT)
    public boolean Virement(@RequestParam String codeCompte1,@RequestParam String codeCompte2,@RequestParam double montant, @RequestParam Long codeEmploye) {
        return operationMetier.Virement(codeCompte1, codeCompte2, montant, codeEmploye);
    }
    @RequestMapping(value = "/operations",method = RequestMethod.GET)
    public PageOperation getOperations(@RequestParam String codeCompte, @RequestParam int page, @RequestParam int size) {
        return operationMetier.getOperations(codeCompte, page, size);
    }

    @Autowired
    OperationMetier operationMetier;
}

package com.nis.banque.service;

import com.nis.banque.entities.Employe;
import com.nis.banque.metier.EmployeMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeRestService {
    @RequestMapping(value = "/employes",method = RequestMethod.POST)
    public Employe saveEmploye(@RequestBody Employe employe) {
        return employeMetier.saveEmploye(employe);
    }
    @RequestMapping(value = "/employes",method = RequestMethod.GET)
    public List<Employe> listEmploye() {
        return employeMetier.listEmploye();
    }

    @Autowired
    private EmployeMetier employeMetier;
}

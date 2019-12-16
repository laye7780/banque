package com.nis.banque.metier;

import com.nis.banque.dao.EmployeRepository;
import com.nis.banque.entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeMetierImpl implements EmployeMetier {
    @Autowired
    private EmployeRepository employeRepository;
    @Override
    public Employe saveEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public List<Employe> listEmploye() {
        return employeRepository.findAll();
    }
}

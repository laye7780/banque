package com.nis.banque.metier;

import com.nis.banque.entities.Employe;

import java.util.List;

public interface EmployeMetier {
    public Employe saveEmploye(Employe employe);
    public List<Employe> listEmploye();
}

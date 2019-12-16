package com.nis.banque.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Employe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeEmploye;
    private String nomEmploye;
    @ManyToOne
    @JoinColumn(name = "code_emp_sup")
    private Employe employeSup;
    @ManyToMany
    @JoinTable(name="EMP_GR")
    private Collection<Groupe>groupes;

    public Long getCodeEmploye() {
        return codeEmploye;
    }

    public void setCodeEmploye(Long codeEmploye) {
        this.codeEmploye = codeEmploye;
    }

    public String getNomEmploye() {
        return nomEmploye;
    }

    public void setNomEmploye(String nomEmploye) {
        this.nomEmploye = nomEmploye;
    }
    @JsonIgnore
    public Employe getEmployeSup() {
        return employeSup;
    }
    @JsonSetter
    public void setEmployeSup(Employe employeSup) {
        this.employeSup = employeSup;
    }
    @JsonIgnore
    public Collection<Groupe> getGroupes() {
        return groupes;
    }

    public void setGroupes(Collection<Groupe> groupes) {
        this.groupes = groupes;
    }

    public Employe(String nomEmploye) {

        this.nomEmploye = nomEmploye;
    }

    public Employe() {

    }
}

package com.nis.banque.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@Entity
@DiscriminatorValue("CC")
@XmlType(name = "CC")
public class CompteCourant  extends Compte{
    private double decouvert;

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }

    public CompteCourant(String codeCompte, Date datecreation, double solde, double decouvert) {

        super(codeCompte, datecreation, solde);
        this.decouvert = decouvert;
    }

    public CompteCourant() {

    }
}

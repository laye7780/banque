package com.nis.banque.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

@Entity
@DiscriminatorValue("CE")
@XmlType(name = "CE")
public class CompteEpargne extends Compte {
    private double taux;

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    public CompteEpargne(String codeCompte, Date datecreation, double solde, double taux) {

        super(codeCompte, datecreation, solde);
        this.taux = taux;
    }

    public CompteEpargne() {

    }
}

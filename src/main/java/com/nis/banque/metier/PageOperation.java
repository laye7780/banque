package com.nis.banque.metier;

import com.nis.banque.entities.Operation;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;

public class PageOperation implements Serializable {
    private List<Operation>operations;
    private int page;
    private int nombreOperations;
    private int totalOperations;
    private int totalPages;

    public int getTotalOperations() {
        return totalOperations;
    }

    public void setTotalOperations(int totalOperations) {
        this.totalOperations = totalOperations;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getNombreOperations() {
        return nombreOperations;
    }

    public void setNombreOperations(int nombreOperations) {
        this.nombreOperations = nombreOperations;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}

package com.nis.banque.metier;

import com.nis.banque.entities.Client;

import java.util.List;

public interface ClientMetier {
    public Client saveClient(Client client);
    public List<Client> listClient();
}

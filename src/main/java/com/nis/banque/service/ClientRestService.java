package com.nis.banque.service;

import com.nis.banque.entities.Client;
import com.nis.banque.metier.ClientMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientRestService {
    @RequestMapping(value = "/clients",method = RequestMethod.POST)
    public Client saveClient(@RequestBody Client client) {
        return clientMetier.saveClient(client);
    }
    @RequestMapping(value = "/clients",method = RequestMethod.GET)
    public List<Client> listClient() {
        return clientMetier.listClient();
    }

    @Autowired
    private ClientMetier clientMetier;
}

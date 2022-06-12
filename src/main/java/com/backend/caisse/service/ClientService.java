package com.backend.caisse.service;

import java.util.List;

import com.backend.caisse.entities.Client;

public interface ClientService {
    
    Client chercherClient(Long refCli);

    void ajouterClients(List<Client> clients);

}

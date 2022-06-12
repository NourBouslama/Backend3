package com.backend.caisse.serviceImp;

import java.util.List;

import com.backend.caisse.entities.Client;
import com.backend.caisse.repos.ClientRepository;
import com.backend.caisse.service.ClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public Client chercherClient(Long refCli) {
      
        return clientRepository.findByReferenceClient(refCli);
    }

    @Override
    public void ajouterClients(List<Client> clients) {
       for(Client c:clients){
        clientRepository.save(c);
       }   
    }
    
}

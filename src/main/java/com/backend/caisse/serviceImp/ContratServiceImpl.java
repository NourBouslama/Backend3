package com.backend.caisse.serviceImp;

import java.util.List;

import com.backend.caisse.entities.Contrat;
import com.backend.caisse.repos.ContratRepository;
import com.backend.caisse.service.ContratService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContratServiceImpl implements ContratService {
    
    @Autowired
    ContratRepository contratRepository;

    @Override
    public void ajouterContrats(List<Contrat> contrats) {
        for(Contrat c:contrats){
            contratRepository.save(c);
        }   
    }
    
}

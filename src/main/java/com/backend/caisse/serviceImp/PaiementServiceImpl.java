package com.backend.caisse.serviceImp;


import java.util.ArrayList;

import java.util.List;

import com.backend.caisse.entities.Encaissement;

import com.backend.caisse.entities.Paiement;

import com.backend.caisse.repos.PaiementRepository;
import com.backend.caisse.service.EncaissementService;

import com.backend.caisse.service.PaiementService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaiementServiceImpl implements PaiementService {


    @Autowired
    PaiementRepository paiementRepository;

    @Autowired
    EncaissementService encaissementService;


    @Override
    public List<Paiement> ListerPaiements(Long numS) {

        List<Paiement> paiements = new ArrayList<>();
        List<Encaissement> lEncaissements = encaissementService.listerEncaissementsParSession(numS);
        for (Encaissement e : lEncaissements) {
            paiements.add(paiementRepository.findByEncaissementIdE(e.getIdE()));

        }
        return paiements;
    }


    @Override
    public List<Paiement> ListerTousPaiements() {
        // TODO Auto-generated method stub
        return paiementRepository.findAll();
    }

  
 
}
package com.backend.caisse.service;

import java.util.List;

import com.backend.caisse.entities.Facture;
import com.backend.caisse.entities.Paiement;

public interface PaiementService {

  List<Paiement> ListerPaiements(Long numS);

  List<Paiement> ListerTousPaiements();
  
}

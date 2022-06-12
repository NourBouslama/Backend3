package com.backend.caisse.service;

import java.util.List;

import com.backend.caisse.entities.Facture;
import com.backend.caisse.entities.PaiementAvecFacture;

public interface PaiementAFactureService {

    PaiementAvecFacture AnnulerPaiementFactures(List<Facture> fact);

    PaiementAvecFacture AnnulerPaiementFactures3(List<Facture> fact);
  //PaiementAvecFacture PaiementFactureAgent(List<Facture> factures, Long p);
  
    PaiementAvecFacture ajouterPaiement(PaiementAvecFacture p);
  
    PaiementAvecFacture modifierFactures(List<Facture> factures);

    void payerFactureAgent(List<PaiementAvecFacture> paiement);
    
}

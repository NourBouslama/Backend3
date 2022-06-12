package com.backend.caisse.serviceImp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.backend.caisse.entities.Encaissement;
import com.backend.caisse.entities.Facture;
import com.backend.caisse.entities.PaiementAvecFacture;
import com.backend.caisse.repos.PaiementAvecFactureRepository;
import com.backend.caisse.repos.PaiementSansFactureRepos;
import com.backend.caisse.service.EncaissementService;
import com.backend.caisse.service.FactureService;
import com.backend.caisse.service.PaiementAFactureService;
import com.backend.caisse.service.SessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.solr.SolrProperties;
import org.springframework.stereotype.Service;

@Service
public class PaiementAvecFactServiceImpl implements PaiementAFactureService {

    @Autowired
    PaiementAvecFactureRepository paiementAvecFactureRepository;

    @Autowired
    FactureService factureService;

    @Autowired
    EncaissementService encaissementService;

    @Autowired
    SessionService sessionService;

    @Override
    public PaiementAvecFacture AnnulerPaiementFactures(List<Facture> fact) {
        PaiementAvecFacture p = new PaiementAvecFacture();
        boolean test = false;
        for (Facture f : fact) {
            p = f.getPaiement();

            if (factureService.chercherPaiementFacture(p) > 1) {
               
                Encaissement encaissement = encaissementService.ajouterEncaissement(new Encaissement(null, new Date(),
                        f.getMontant(), "annulé", null, p.getEncaissement().getSession()));
                paiementAvecFactureRepository.save(
                        new PaiementAvecFacture(null, new Date(), p.getModePaiement(), "annulé", encaissement, null,
                                null));
           
                test = true;
            }

            factureService.annulerPaiementFacture(f.getReferenceFact());

            sessionService.annulerSession(f.getMontant(), p.getEncaissement().getSession().getNumS());

        }
        if (test == false) {

            paiementAvecFactureRepository.annulerPaiement(p.getIdP());
            encaissementService.modifierEncaissement("annulé", 0, p.getEncaissement().getIdE());
        }

        return p;
    }

    @Override
    public PaiementAvecFacture AnnulerPaiementFactures3(List<Facture> fact) {
        PaiementAvecFacture p = new PaiementAvecFacture();
        double mts = 0;
        boolean test = false;

        if (factureService.chercherPaiementFacture(fact.get(0).getPaiement()) == fact.size()) {
            test = true;
        } else if (factureService.chercherPaiementFacture(fact.get(0).getPaiement()) > fact.size()) {
            test = false;
        }

        for (Facture f : fact) {
            p = f.getPaiement();
            mts += f.getMontant();
            factureService.annulerPaiementFacture(f.getReferenceFact());
            sessionService.annulerSession(f.getMontant(), p.getEncaissement().getSession().getNumS());

        }
        if (test) {

            paiementAvecFactureRepository.annulerPaiement(p.getIdP());
            encaissementService.modifierEncaissement("annulé", 0, p.getEncaissement().getIdE());
        }
        if (!test) {
            Encaissement encaissement = encaissementService.ajouterEncaissement(new Encaissement(null, new Date(),
                    mts, "annulé", null, p.getEncaissement().getSession()));
            paiementAvecFactureRepository.save(
                    new PaiementAvecFacture(null, new Date(), p.getModePaiement(), "annulé", encaissement, null,
                            null));
            encaissementService.modifierEncaissement("payé", mts, p.getEncaissement().getIdE());

        }

        return p;
    }

    @Override
    public PaiementAvecFacture ajouterPaiement(PaiementAvecFacture p) {
        return paiementAvecFactureRepository.save(p);

    }

   /* @Override
    public PaiementAvecFacture payerFactures(List<Facture> factures) {

        PaiementAvecFacture paiement = new PaiementAvecFacture();

        for (Facture f : factures) {
            paiement = f.getPaiement();
            factureService.modifierFacture(paiement, f.getReferenceFact());

        }

        return paiement;
    }*/

    @Override
    public PaiementAvecFacture modifierFactures(List<Facture> factures) {
//
        PaiementAvecFacture paiement = new PaiementAvecFacture();

        for (Facture f : factures) {
            paiement=f.getPaiement();
            factureService.modifierFacture(paiement, f.getReferenceFact());

        }

    return paiement;
    }
    @Override
    public void payerFactureAgent(List<PaiementAvecFacture> paiements) {
        List<Facture> facts = new ArrayList<>();
        for (PaiementAvecFacture paie : paiements) {
             facts = paie.getFactures();
       
            PaiementAvecFacture p = paiementAvecFactureRepository.save(paie);
      
        }
       
    }
}

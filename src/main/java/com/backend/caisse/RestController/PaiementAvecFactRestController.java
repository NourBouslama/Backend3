package com.backend.caisse.RestController;

import java.util.List;

import com.backend.caisse.entities.Facture;
import com.backend.caisse.entities.PaiementAvecFacture;
import com.backend.caisse.service.PaiementAFactureService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paiementAvecFacture")
@CrossOrigin
public class PaiementAvecFactRestController {

    @Autowired
    PaiementAFactureService paiementAvecFactureService;

    @RequestMapping(path = "/annuler", method = RequestMethod.PUT)
    public ResponseEntity<Object> annulerPaiementListFactures(@RequestBody List<Facture> factures) {

        try {
            return new ResponseEntity<Object>(paiementAvecFactureService.AnnulerPaiementFactures3(factures),
                    HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

  

    @RequestMapping(path = "/payer", method = RequestMethod.PUT)
    public ResponseEntity<Object> PaiementFactures(@RequestBody List<Facture> factures) {

        try {
            return new ResponseEntity<Object>(paiementAvecFactureService.modifierFactures(factures), HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(path = "/paiementAgent", method = RequestMethod.POST)
    public void PaiementAgent(@RequestBody List<PaiementAvecFacture> paiement) {
     paiementAvecFactureService.payerFactureAgent(paiement);
      
    }

    @RequestMapping(path = "/ajouterPaiement", method = RequestMethod.POST)
    public ResponseEntity<Object> ajouterPaiement(@RequestBody PaiementAvecFacture paiement) {
        try {
            return new ResponseEntity<Object>(paiementAvecFactureService.ajouterPaiement(paiement), HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}

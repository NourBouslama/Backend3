package com.backend.caisse.RestController;

import java.util.List;
import com.backend.caisse.entities.Facture;
import com.backend.caisse.entities.Paiement;
import com.backend.caisse.service.PaiementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paiement")
@CrossOrigin

public class PaiementRestController {
    @Autowired
    PaiementService paiementService;

    @RequestMapping(value = "/listerPaiement/{numS}", method = RequestMethod.GET)
    public ResponseEntity<Object> listerPaiements(@PathVariable("numS") Long numS) {
        try {
            return new ResponseEntity<Object>(paiementService.ListerPaiements(numS), HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/ListerTousPaiements", method = RequestMethod.GET)
    public ResponseEntity<Object> ListerTousPaiements() {
        try {
            return new ResponseEntity<Object>(paiementService.ListerTousPaiements(), HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

package com.backend.caisse.RestController;

import com.backend.caisse.entities.PaiementSansFacture;
import com.backend.caisse.service.PaiementSFactureService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paiementSansFacture")
@CrossOrigin
public class PaiementSansFactRestController {
    @Autowired
    PaiementSFactureService paiementSansFactService;

    @RequestMapping(path = "/saisirAvance", method = RequestMethod.POST)
    public ResponseEntity<Object> saisirAvance(@RequestBody PaiementSansFacture paiement) {
        try {
            return new ResponseEntity<Object>(paiementSansFactService.saisirAvance(paiement), HttpStatus.OK);
        } catch (Exception e) {

            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }   
}

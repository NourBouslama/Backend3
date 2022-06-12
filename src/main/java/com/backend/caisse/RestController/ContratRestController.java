package com.backend.caisse.RestController;
import java.util.List;

import com.backend.caisse.entities.Contrat;
import com.backend.caisse.service.ContratService;

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
@RequestMapping("/contrat")
@CrossOrigin(origins = "*")
public class ContratRestController {
    
    @Autowired
    ContratService contratService;

    @RequestMapping(path = "/ajouterContrats",method = RequestMethod.POST)
    public void  ajouterContrats(@RequestBody List<Contrat> contrats) {
        contratService.ajouterContrats(contrats);
       
    }


}

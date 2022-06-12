package com.backend.caisse.RestController;

import com.backend.caisse.entities.Utilisateur;
import com.backend.caisse.service.UtilisateurService;

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
@RequestMapping("/utilisateur")
@CrossOrigin
public class UtilisateurRestController {

    @Autowired
    UtilisateurService utilisateurService;

    
    @RequestMapping(value ="/chercherParEmail/{email}", method = RequestMethod.GET)
    public ResponseEntity<Object> chercherParEmail(@PathVariable("email") String email) {
        try{
            return new ResponseEntity<Object>( utilisateurService.chercherParEmail(email),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
     
    }

    @RequestMapping(path = "/modifierUtilisateur",method = RequestMethod.PUT)
    public ResponseEntity<Object> modifierUtilisateur(@RequestBody Utilisateur utilisateur) {
        try{
            return new ResponseEntity<Object>(utilisateurService.modifierUtilisateur(utilisateur),HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}

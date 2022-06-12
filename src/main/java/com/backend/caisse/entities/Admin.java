package com.backend.caisse.entities;
import java.util.List;

import javax.persistence.Entity;

import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Admin extends Utilisateur {
    
    public Admin(Long idU, String matricule, String nom, String prenom, String email, String adresse, String etat,
            String motDePasse, Role role) {
        super(idU, matricule, nom, prenom, email, adresse, etat, motDePasse, role);
    }
    
}

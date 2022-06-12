package com.backend.caisse.service;

import javax.transaction.Transactional;


import com.backend.caisse.entities.Role;
import com.backend.caisse.entities.Utilisateur;

@Transactional
public interface UtilisateurService {
    Utilisateur AjouterUtilisateur(Utilisateur u);
    
    Utilisateur chercherParPrenom (String prenom);

    
    
    Utilisateur chercherParEmail (String email);
    Role AjoueterRole(Role role);
    Utilisateur AjouterRoleUtilisateur(String email, String role);

    Utilisateur modifierUtilisateur(Utilisateur u);
}

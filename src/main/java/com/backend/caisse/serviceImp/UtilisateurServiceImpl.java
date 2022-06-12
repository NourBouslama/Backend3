package com.backend.caisse.serviceImp;

import javax.transaction.Transactional;


import com.backend.caisse.entities.Role;
import com.backend.caisse.entities.Utilisateur;

import com.backend.caisse.repos.RoleRepository;
import com.backend.caisse.repos.UtilisateurRepository;
import com.backend.caisse.service.UtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    UtilisateurRepository utilisateurRep;

   

    @Autowired
    RoleRepository roleRep;
    
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public Utilisateur AjouterUtilisateur(Utilisateur u) {
        u.setMotDePasse(bCryptPasswordEncoder.encode(u.getMotDePasse()));
        return utilisateurRep.save(u);
        
    }

    @Override
    public Utilisateur chercherParPrenom(String prenom) {
        return utilisateurRep.findByPrenom(prenom);
        
    }

    

   

    @Override
    public Utilisateur chercherParEmail(String email) {
        // TODO Auto-generated method stub
        return utilisateurRep.findByEmail(email);
    }

    @Override
    public Role AjoueterRole(Role role) {
        // TODO Auto-generated method stub
        return roleRep.save(role);
    }

    @Override
    public Utilisateur AjouterRoleUtilisateur(String email, String role) {
        Utilisateur usr = utilisateurRep.findByEmail(email);
        Role r = roleRep.findByRole(role);
        usr.setRole(r);
        //usr.getRole().add(r);
        return usr;
    }

    @Override
    public Utilisateur modifierUtilisateur(Utilisateur u) {
        u.setMotDePasse(bCryptPasswordEncoder.encode(u.getMotDePasse()));
        return utilisateurRep.save(u);
    }
    
}

package com.backend.caisse.serviceImp;

import com.backend.caisse.entities.Admin;
import com.backend.caisse.repos.AdminRepository;
import com.backend.caisse.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class AdminServiceImpl implements AdminService{


    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Admin ajouterAdmin(Admin a) {
            a.setMotDePasse(bCryptPasswordEncoder.encode(a.getMotDePasse()));

        return adminRepository.save(a);
    }

    @Override
    public Admin modifierAdmin(Admin a) {
        a.setMotDePasse(bCryptPasswordEncoder.encode(a.getMotDePasse()));
        return adminRepository.save(a);
    }
    
}

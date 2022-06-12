package com.backend.caisse.repos;

import com.backend.caisse.entities.PaiementSansFacture;

import org.springframework.data.jpa.repository.JpaRepository;
public interface PaiementSansFactureRepos extends JpaRepository<PaiementSansFacture, Long> {
    
}

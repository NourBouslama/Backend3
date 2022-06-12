package com.backend.caisse.repos;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.backend.caisse.entities.Agent;
import com.backend.caisse.entities.Encaissement;
import com.backend.caisse.entities.Paiement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
    
    Paiement findByEncaissementIdE(Long ide);
    
}

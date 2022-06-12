package com.backend.caisse.repos;

import com.backend.caisse.entities.Admin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    
}

package com.backend.caisse.repos;

import com.backend.caisse.entities.Agent;
import com.backend.caisse.entities.Encaissement;
import com.backend.caisse.entities.PaiementAvecFacture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PaiementAvecFactureRepository extends JpaRepository<PaiementAvecFacture, Long> {
    PaiementAvecFacture findByIdP(Long idP);
    
    PaiementAvecFacture findByEncaissementIdE(Long ide);

    @Transactional
    @Modifying
    @Query("update PaiementAvecFacture p set p.etat='Annuler' where p.idP=?1")
    void annulerPaiement(long ff);


    @Transactional
    @Modifying
    @Query("update PaiementAvecFacture p set p.encaissement=?1 where p.idP=?2")
    void updateEncaissementPaiement(Encaissement enc, long idp);

    // peut changer pr faire une modification pr encaissement tab
    @Transactional
    @Modifying
    @Query("update PaiementAvecFacture p set p.agent=?1 where p.idP=?2")
    void updatePaiement(Agent agent, long idp); 
    
}

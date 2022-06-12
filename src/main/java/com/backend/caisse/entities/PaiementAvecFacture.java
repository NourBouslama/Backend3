package com.backend.caisse.entities;

import java.util.Date;
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
@NoArgsConstructor
@Getter
@Setter
@Entity
public class PaiementAvecFacture extends Paiement {
    public PaiementAvecFacture(Long idP, Date dateP,String modePaiement,String etat,Encaissement encaissement,Agent agent, List<Facture> factures){
        super(idP, dateP, modePaiement, etat, encaissement, agent);
        this.factures=factures;
    }
    @JsonIgnore
    @OneToMany(mappedBy = "paiement")
    private List<Facture> factures;
    
}

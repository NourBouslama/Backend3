package com.backend.caisse.entities;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdF;

    @Column(unique = true)
    private Long referenceFact;

    private Double montant;

    private Date periodeCons; // Période de Consommation
    private String etat;
    private LocalDate dateF; // date finale pour payer la facture

    @ManyToOne
    private PaiementAvecFacture paiement;

    @ManyToOne
    private Contrat contrat;

    @ManyToOne
    private Client client;

}

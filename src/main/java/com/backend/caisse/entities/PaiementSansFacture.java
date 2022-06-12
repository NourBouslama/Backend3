package com.backend.caisse.entities;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;



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
public class PaiementSansFacture extends Paiement{
    
    @ManyToOne
    private Client cli;
}
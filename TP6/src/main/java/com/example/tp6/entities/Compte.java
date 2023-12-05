package com.example.tp6.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table
public class Compte {
    //Identifiant du compte, généré automatiquement.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;
    //Solde du compte.
    @Column
        double solde;
    //Date de création du compte
    @Temporal(TemporalType.DATE)
    @Column
    Date dateCreation;
    //Type de compte, qui peut être soit COURANT soit EPARGNE.
    @Enumerated(EnumType.ORDINAL)
    @Column
    TypeCompte type;
    //Type de compte, qui peut être CREE, ACTIVE, SUSPENDU, BLOQUE.
    @Enumerated(EnumType.ORDINAL)
    @Column
    EtatCompte etat;

    // EtatCompte.java
    public enum EtatCompte {
        CREE, ACTIVE, SUSPENDU, BLOQUE
    }


}

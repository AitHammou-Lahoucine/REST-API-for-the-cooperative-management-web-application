package com.example.projetv1spring.Consomme;

import com.example.projetv1spring.Panier.*;
import com.example.projetv1spring.Produit.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class consomme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_consomme;
    private Integer quantite_consomme;

    @ManyToOne
    private panier panier;
    @ManyToOne
    private produit produit;
}

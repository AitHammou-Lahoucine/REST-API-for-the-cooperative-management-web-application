package com.example.projetv1spring.Composition;

import com.example.projetv1spring.Matiere1er.*;
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
public class composition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_composition;
    private Double percent_composition;
    @ManyToOne
    private produit produit;
    @ManyToOne
    private matiere1er matiere1er;
}

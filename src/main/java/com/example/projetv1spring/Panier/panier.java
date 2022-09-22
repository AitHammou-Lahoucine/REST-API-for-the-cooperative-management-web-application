package com.example.projetv1spring.Panier;

import com.example.projetv1spring.Client.*;
import com.example.projetv1spring.Consomme.consomme;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class panier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_panier;
    private String date_de_validation_panier;
    @JsonIgnore
    @OneToMany(mappedBy = "panier")
    private List<consomme> consommes;
    @ManyToOne
    private client client;
}

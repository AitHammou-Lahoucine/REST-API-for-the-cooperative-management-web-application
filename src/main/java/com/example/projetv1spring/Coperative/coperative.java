package com.example.projetv1spring.Coperative;

import com.example.projetv1spring.Produit.*;
import com.example.projetv1spring.Region.*;
import com.example.projetv1spring.Secteur.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
@Entity
@Table(name = "coperative")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class coperative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_coperative;
    private String name_copeartive;
    private String email_coperative;
    private String password_coperative;
    private String date_creation_coperative;
    @JsonIgnore
    //@JsonProperty("region")
    @OneToMany(mappedBy = "coperative")
    private List<produit> produits;
    @ManyToOne
    private region region;
    @ManyToOne
    private secteur secteur;
}

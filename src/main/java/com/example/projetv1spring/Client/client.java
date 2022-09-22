package com.example.projetv1spring.Client;


import com.example.projetv1spring.Panier.panier;
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
public class client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_client;
    private String name_client;
    private String family_name_client;
    private String email_client;
    private String password;
    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<panier> paniers;
}

package com.example.projetv1spring.Matiere1er;

import com.example.projetv1spring.Composition.*;
import com.example.projetv1spring.Origine.*;
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
public class matiere1er {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_matiere1er;
    private String name_matiere1er;
    @ManyToOne
    private origine origine;
    @JsonIgnore
    @OneToMany(mappedBy = "matiere1er")
    private List<composition> compositions;
}

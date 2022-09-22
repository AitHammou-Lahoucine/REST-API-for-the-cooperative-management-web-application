package com.example.projetv1spring.Origine;

import com.example.projetv1spring.Matiere1er.matiere1er;
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
public class origine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_origine;
    private String name_origine;
    @JsonIgnore
    @OneToMany(mappedBy = "origine")
    private List<matiere1er> matiere1ers;
}

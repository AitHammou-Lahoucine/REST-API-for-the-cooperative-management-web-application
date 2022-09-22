package com.example.projetv1spring.Composition;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RepoCompostion extends JpaRepository<composition, Integer> {
    @Query("SELECT matiere1er.id_matiere1er from composition where produit.id_produit=?1 ")
    List<Integer> findCompositionByproduit1(Integer id);

    @Query("select count(id_composition) from composition where produit.id_produit=?1 and matiere1er.id_matiere1er=?2")
    Integer findCompositionByproduit(Integer idp,Integer idm);

    @Query("select c from composition as c where c.produit.id_produit=?1 ")
    List<composition> getcompositionByproduit(Integer id);

}

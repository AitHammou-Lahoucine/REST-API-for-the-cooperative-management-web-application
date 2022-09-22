package com.example.projetv1spring.Matiere1er;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RepoMatiere1er extends JpaRepository<matiere1er, Integer> {
    @Query("SELECT count(name_matiere1er) from matiere1er where name_matiere1er =?1 ")
    int countfindByname(String name);

    @Query("SELECT id_matiere1er from matiere1er where name_matiere1er =?1 ")
    int findIDByname(String name);
    @Query("SELECT count(id_matiere1er) from matiere1er where name_matiere1er=?1 and origine.id_origine=?2")
    int countMatiereByNom(String name,Integer i);
}

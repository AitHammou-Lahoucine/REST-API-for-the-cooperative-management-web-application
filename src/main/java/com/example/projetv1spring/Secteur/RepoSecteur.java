package com.example.projetv1spring.Secteur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RepoSecteur extends JpaRepository<secteur, Integer> {

    @Query("SELECT count(name_secteur) from secteur where name_secteur =?1 ")
    int countfindByname(String name);

    @Query("SELECT id_secteur from secteur where name_secteur =?1 ")
    int findIDByname(String name);
}

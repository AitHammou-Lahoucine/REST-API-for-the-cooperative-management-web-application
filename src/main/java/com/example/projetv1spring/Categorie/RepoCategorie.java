package com.example.projetv1spring.Categorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RepoCategorie extends JpaRepository<categorie, Integer> {

    @Query("SELECT count(name_categorie) from categorie where name_categorie =?1 ")
    int countfindByname(String name);

    @Query("SELECT id_categorie from categorie where name_categorie =?1 ")
    int findIDByname(String name);
}

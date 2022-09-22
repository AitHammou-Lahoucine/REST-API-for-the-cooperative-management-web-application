package com.example.projetv1spring.Origine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RepoOrigine extends JpaRepository<origine, Integer> {
    @Query("SELECT count(name_origine) from origine where name_origine =?1 ")
    int countfindByname(String name);

    @Query("SELECT id_origine from origine where name_origine =?1 ")
    int findIDByname(String name);
}

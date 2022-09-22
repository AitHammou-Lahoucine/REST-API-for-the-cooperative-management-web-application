package com.example.projetv1spring.Region;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Reporegion extends JpaRepository<region, Integer> {

    @Query("SELECT count(name_region) from region where name_region =?1 ")
    int countfindByname(String name);

    @Query("SELECT id_region from region where name_region =?1 ")
    int findIDByname(String name);
}

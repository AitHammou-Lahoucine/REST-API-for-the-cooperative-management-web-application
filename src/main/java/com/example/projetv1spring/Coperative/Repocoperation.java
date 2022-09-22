package com.example.projetv1spring.Coperative;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Repocoperation extends JpaRepository<coperative, Integer> {

    @Query("SELECT count(name_copeartive) from coperative where name_copeartive=?1 ")
    int countfindByname(String name);

    @Query("SELECT id_coperative from coperative where name_copeartive =?1 ")
    int findIDByname(String name);

    @Query("select c from coperative c where c.region.id_region=?1")
    public List<coperative> getCoperativesByregion(Integer id);

    @Query("select c from coperative c where c.secteur.id_secteur=?1")
    public List<coperative> getCoperativesBysecteur(Integer id);

    @Query("SELECT count(email_coperative) from coperative where email_coperative=?1 ")
    int countfindByemail(String email);
}

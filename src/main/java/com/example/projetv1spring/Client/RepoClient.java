package com.example.projetv1spring.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RepoClient extends JpaRepository<client, Integer> {
    @Query("select  count(c) from client as c where c.email_client = ?1 and c.name_client=?2 and c.family_name_client=?3 and c.password=?4")
    public int findclient(String email,String nom,String prenom,String password);

    @Query("select  c.id_client from client as c where c.email_client = ?1 and c.name_client=?2 and c.family_name_client=?3 and c.password=?4")
    Integer findIdByclient(String email,String nom,String prenom,String password);

    @Query("select  id_client from client where email_client=?1")
    int findclientByemail(String email);

    @Query("select  count(id_client) from client where email_client=?1")
    int countclientByemail(String email);
}

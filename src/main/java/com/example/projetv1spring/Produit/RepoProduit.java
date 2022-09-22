package com.example.projetv1spring.Produit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepoProduit extends JpaRepository<produit, Integer> {
    @Query("SELECT count(name_produit) from produit where name_produit =?1 ")
    int countfindByname(String name);

    @Query("SELECT id_produit from produit where name_produit =?1 ")
    int findIDByname(String name);

    @Query("select p from produit as p where p.categorie.id_categorie = ?1 ")
    public List<produit> getProduitsBycategorie(int id);

    @Query("select p from produit as p where p.coperative.id_coperative = ?1 ")
    public List<produit> getProduitsBycoperative(int id);

   @Query("select p from produit as p " +
            "inner join p.coperative as pc " +
            "on pc.region.name_region = :r")
    public List<produit> getProduitsByregion(@Param("r") String r);

    @Query("select p from produit p inner join p.compositions as c on c.matiere1er.name_matiere1er=:m")
    public List<produit> getProduitsBymatiere1er(@Param("m") String m);


   @Query("select c.produit from composition as c inner join c.matiere1er as cm on c.matiere1er.origine.name_origine=:o")
   public List<produit> getProduitsByOriginematiere1er(@Param("o") String o);
}

package com.example.projetv1spring.Produit;

import java.util.List;

public interface produitService {
    int countfindname(String p);
    int findIDByname(String p);
    produit saveproduit(produit p);
    void deleteproduit(produit p);
    void deleteproduitById(Integer id);
    produit getproduit(Integer id);
    List<produit> getAllproduits();
    List<produit> getProduitsBycategorie(int id);
    List<produit> getProduitsBycoperative(int id);
    List<produit> getProduitsByregion( String r);
    List<produit> getProduitsBymatiere1er(String m);
    List<produit> getProduitsByOriginematiere1er(String o);
}

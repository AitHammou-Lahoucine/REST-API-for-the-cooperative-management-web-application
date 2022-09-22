package com.example.projetv1spring.Produit;


import com.example.projetv1spring.Composition.RepoCompostion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class produitServiceIMPL implements produitService{
    @Autowired
    RepoProduit repoproduit;

    @Autowired
    RepoCompostion repocomposition;


    @Override
    public int countfindname(String p) {
        return repoproduit.countfindByname(p);
    }

    @Override
    public int findIDByname(String p) {
        return repoproduit.findIDByname(p);
    }

    @Override
    public produit saveproduit(produit p) {return repoproduit.save(p);}

    @Override
    public void deleteproduit(produit p) {

        repoproduit.delete(p);}

    @Override
    public void deleteproduitById(Integer id) {
        repoproduit.deleteById(id);}

    @Override
    public produit getproduit(Integer id) {
        return repoproduit.findById(id).get();}

    @Override
    public List<produit> getAllproduits() {return repoproduit.findAll();}

    @Override
    public List<produit> getProduitsBycategorie(int id) {
        return repoproduit.getProduitsBycategorie(id);
    }

    @Override
    public List<produit> getProduitsBycoperative(int id) {
        return repoproduit.getProduitsBycoperative(id);
    }

    @Override
    public List<produit> getProduitsByregion(String r) {
        return repoproduit.getProduitsByregion(r);
    }

    @Override
    public List<produit> getProduitsBymatiere1er(String m) {
        return repoproduit.getProduitsBymatiere1er(m);
    }

    @Override
    public List<produit> getProduitsByOriginematiere1er(String o) {
        return repoproduit.getProduitsByOriginematiere1er(o);
    }
}

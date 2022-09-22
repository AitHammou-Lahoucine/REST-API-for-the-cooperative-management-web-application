package com.example.projetv1spring.Panier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class panierServiceIMPL implements panierService{
    @Autowired
    RepoPanier repopanier;
    @Override
    public panier savepanier(panier p) {
        return repopanier.save(p);
    }

    @Override
    public void deletepanier(panier p) {
        repopanier.delete(p);
    }

    @Override
    public void deletepanierById(Integer id) {
        repopanier.deleteById(id);
    }

    @Override
    public panier getpanier(Integer id) {
        return repopanier.findById(id).get();
    }

    @Override
    public List<panier> getAllpaniers() {
        return repopanier.findAll();
    }
}

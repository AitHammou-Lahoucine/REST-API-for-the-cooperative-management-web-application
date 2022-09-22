package com.example.projetv1spring.Panier;

import java.util.List;

public interface panierService {
    panier savepanier(panier p);
    void deletepanier(panier p);
    void deletepanierById(Integer id);
    panier getpanier(Integer id);
    List<panier> getAllpaniers();
}

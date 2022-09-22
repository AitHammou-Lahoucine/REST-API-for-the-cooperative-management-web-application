package com.example.projetv1spring.Consomme;

import java.util.List;

public interface consommeService {
    consomme saveconsomme(consomme c);
    void deleteconsomme(consomme c);
    void deleteconsommeById(Integer id);
    consomme getconsomme(Integer id);
    List<consomme> getAllconsommes();
}

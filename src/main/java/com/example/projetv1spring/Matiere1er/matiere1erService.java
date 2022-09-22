package com.example.projetv1spring.Matiere1er;

import java.util.List;

public interface matiere1erService {
    int countfindname(String s);
    int findIDByname(String s);
    matiere1er savematiere1er(matiere1er m);
    void deletematiere1er(matiere1er m);
    void deletematiere1erById(Integer id);
    matiere1er getmatiere1er(Integer id);
    List<matiere1er> getAllmatiere1ers();
    int countMatiereByNom(String name,Integer i);
}

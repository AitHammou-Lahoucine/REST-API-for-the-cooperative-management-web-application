package com.example.projetv1spring.Secteur;

import java.util.List;

public interface secteurService {
    int countfindname(String s);
    int findIDByname(String s);
    secteur savesecteur(secteur s);
    void deletesecteur(secteur s);
    void deletesecteurById(Integer id);
    secteur getsecteur(Integer id);
    List<secteur> getAllsecteurs();
}

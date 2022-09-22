package com.example.projetv1spring.Coperative;

import java.util.List;

public interface coperativeService {
    int countfindname(String c);
    int findIDByname(String c);
    coperative savecoperative(coperative c);
    void deletecoperative(coperative c);
    void deletecoperativeById(Integer id);
    coperative getcoperative(Integer id);
    List<coperative> getAllcoperatives();
    List<coperative> getCoperativesByregion(Integer id);
    List<coperative> getCoperativesBysecteur(Integer id);
    int countfindByemail(String email);
}

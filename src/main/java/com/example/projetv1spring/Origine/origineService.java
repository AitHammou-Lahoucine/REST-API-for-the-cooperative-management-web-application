package com.example.projetv1spring.Origine;



import java.util.List;

public interface origineService {
    int countfindByname(String o);
    int findIDByname(String o);
    origine saveorigine(origine o);
    void deleteorigine(origine o);
    void deleteorigineById(Integer id);
    origine getorigine(Integer id);
    List<origine> getAllorigines();
}

package com.example.projetv1spring.Composition;



import java.util.List;

public interface compositionService {
    composition savecomposition(composition c);
    void deletecomposition(composition c);
    void deletecompositionById(Integer id);
    composition getcomposition(Integer id);
    List<composition> getAllcompositions();
    List<Integer> findCompositionByproduit1(Integer id);
    Integer findCompositionByproduit(Integer idp,Integer idm);

    List<composition> getcompositionByproduit(Integer id);
}

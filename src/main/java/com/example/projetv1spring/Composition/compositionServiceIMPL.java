package com.example.projetv1spring.Composition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class compositionServiceIMPL implements compositionService{
    @Autowired
    RepoCompostion repocompostion;

    @Override
    public composition savecomposition(composition c) {return repocompostion.save(c);}

    @Override
    public void deletecomposition(composition c) {repocompostion.delete(c);}

    @Override
    public void deletecompositionById(Integer id) {repocompostion.deleteById(id);}

    @Override
    public composition getcomposition(Integer id) {return repocompostion.findById(id).get();}

    @Override
    public List<composition> getAllcompositions() {return repocompostion.findAll();}

    @Override
    public List<Integer> findCompositionByproduit1(Integer id) {
        return repocompostion.findCompositionByproduit1(id);
    }

    @Override
    public Integer findCompositionByproduit(Integer idp, Integer idm) {
        return repocompostion.findCompositionByproduit(idp,idm);
    }

    @Override
    public List<composition> getcompositionByproduit(Integer id) {
        return repocompostion.getcompositionByproduit(id);
    }
}

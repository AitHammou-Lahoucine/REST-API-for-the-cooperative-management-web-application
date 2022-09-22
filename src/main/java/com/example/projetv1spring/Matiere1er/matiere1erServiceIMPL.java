package com.example.projetv1spring.Matiere1er;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class matiere1erServiceIMPL implements matiere1erService{
    @Autowired
    RepoMatiere1er repoMatiere1er;

    @Override
    public int countfindname(String s) {
        return repoMatiere1er.countfindByname(s);
    }

    @Override
    public int findIDByname(String s) {
        return repoMatiere1er.findIDByname(s);
    }

    @Override
    public matiere1er savematiere1er(matiere1er m) {return repoMatiere1er.save(m);}

    @Override
    public void deletematiere1er(matiere1er m) {repoMatiere1er.delete(m);}

    @Override
    public void deletematiere1erById(Integer id) {repoMatiere1er.deleteById(id);}

    @Override
    public matiere1er getmatiere1er(Integer id) {return repoMatiere1er.findById(id).get();}

    @Override
    public List<matiere1er> getAllmatiere1ers() {return repoMatiere1er.findAll();}

    @Override
    public int countMatiereByNom(String name, Integer i) {
        return repoMatiere1er.countMatiereByNom(name,i);
    }
}

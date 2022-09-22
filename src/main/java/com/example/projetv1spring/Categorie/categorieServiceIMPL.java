package com.example.projetv1spring.Categorie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class categorieServiceIMPL implements categorieService{
    @Autowired
    RepoCategorie repocategorie;

    @Override
    public int countfindname(String c) {
        return repocategorie.countfindByname(c);
    }

    @Override
    public int findIDByname(String c) {
        return repocategorie.findIDByname(c);
    }

    @Override
    public categorie savecategorie(categorie c) {
        if(repocategorie.countfindByname(c.getName_categorie())==0){
            return repocategorie.save(c);
        }
        else{
            c.setId_categorie(repocategorie.findIDByname(c.getName_categorie()));
          return c;
        }
    }

    @Override
    public void deletecategorie(categorie c) { repocategorie.delete(c);}

    @Override
    public void deletecategorieById(Integer id) {repocategorie.deleteById(id);}

    @Override
    public categorie getcategorie(Integer id) {return repocategorie.findById(id).get();}

    @Override
    public List<categorie> getAllcategories() {return repocategorie.findAll();}
}

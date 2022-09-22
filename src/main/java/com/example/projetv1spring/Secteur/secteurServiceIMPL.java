package com.example.projetv1spring.Secteur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class secteurServiceIMPL implements secteurService{
    @Autowired
    RepoSecteur reposecteur;

    @Override
    public int countfindname(String s) {
        return reposecteur.countfindByname(s);
    }

    @Override
    public int findIDByname(String s) {
        return reposecteur.findIDByname(s);
    }

    @Override
    public secteur savesecteur(secteur s) {
        if(this.countfindname(s.getName_secteur())==0)
        { return reposecteur.save(s);}
        else {
            s.setId_secteur(this.findIDByname(s.getName_secteur()));
            return s;
        }
        }

    @Override
    public void deletesecteur(secteur s) {reposecteur.delete(s);}

    @Override
    public void deletesecteurById(Integer id) {reposecteur.deleteById(id);}

    @Override
    public secteur getsecteur(Integer id) {return reposecteur.findById(id).get();}

    @Override
    public List<secteur> getAllsecteurs() {return reposecteur.findAll();}
}

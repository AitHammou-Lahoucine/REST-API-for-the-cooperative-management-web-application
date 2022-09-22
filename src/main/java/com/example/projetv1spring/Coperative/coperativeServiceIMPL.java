package com.example.projetv1spring.Coperative;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class coperativeServiceIMPL implements coperativeService  {
    @Autowired
    Repocoperation repoCoperative;

    @Override
    public int countfindname(String c) {
        return repoCoperative.countfindByname(c);
    }

    @Override
    public int findIDByname(String c) {
        return repoCoperative.findIDByname(c);
    }

    @Override
    public coperative savecoperative(coperative c) {return repoCoperative.save(c);}

    @Override
    public void deletecoperative(coperative c) { repoCoperative.delete(c);}

    @Override
    public void deletecoperativeById(Integer id) {repoCoperative.deleteById(id);}

    @Override
    public coperative getcoperative(Integer id) {return repoCoperative.findById(id).get();}

    @Override
    public List<coperative> getAllcoperatives() {return repoCoperative.findAll();}

    @Override
    public List<coperative> getCoperativesByregion(Integer id) {
        return repoCoperative.getCoperativesByregion(id);
    }

    @Override
    public List<coperative> getCoperativesBysecteur(Integer id) {
        return repoCoperative.getCoperativesBysecteur(id);
    }

    @Override
    public int countfindByemail(String email) {
        return repoCoperative.countfindByemail(email);
    }
}

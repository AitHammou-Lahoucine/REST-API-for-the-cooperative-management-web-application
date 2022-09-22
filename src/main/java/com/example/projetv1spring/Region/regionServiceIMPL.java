package com.example.projetv1spring.Region;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class regionServiceIMPL implements regionService{
    @Autowired
    Reporegion reporegion;

    @Override
    public int countfindname(String s) {return reporegion.countfindByname(s);}

    @Override
    public int findIDByname(String s) {return reporegion.findIDByname(s);}

    @Override
    public region saveregion(region r) {
        if(this.countfindname(r.getName_region())==0){
            return reporegion.save(r);
        }
        else {
            r.setId_region(this.findIDByname(r.getName_region()));
            return r;
        }
    }

    @Override
    public void deleteregion(region r) {reporegion.delete(r);}

    @Override
    public void deleteregionById(Integer id) {reporegion.deleteById(id);}

    @Override
    public region getregion(Integer id) {return reporegion.findById(id).get();}

    @Override
    public List<region> getAllregions() {return reporegion.findAll();}
}

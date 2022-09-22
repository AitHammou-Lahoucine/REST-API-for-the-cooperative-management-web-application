package com.example.projetv1spring.Origine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class origineServiceIMPL implements origineService{
    @Autowired
    RepoOrigine repoorigine;

    @Override
    public int countfindByname(String o) {
        return repoorigine.countfindByname(o);
    }

    @Override
    public int findIDByname(String o) {
        return repoorigine.findIDByname(o);
    }

    @Override
    public origine saveorigine(origine o) {
        if(repoorigine.countfindByname(o.getName_origine())==0)
        {return repoorigine.save(o);}
        else{
            o.setId_origine(repoorigine.findIDByname(o.getName_origine()));
            return o;
        }

    }

    @Override
    public void deleteorigine(origine o) {
        repoorigine.delete(o);
    }

    @Override
    public void deleteorigineById(Integer id) {
        repoorigine.deleteById(id);
    }

    @Override
    public origine getorigine(Integer id) {
        return repoorigine.findById(id).get();
    }

    @Override
    public List<origine> getAllorigines() {
        return repoorigine.findAll();
    }
}

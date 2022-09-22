package com.example.projetv1spring.Consomme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class consommeServiceIMPL implements consommeService {
    @Autowired
    RepoConsomme repoconsomme;

    @Override
    public consomme saveconsomme(consomme c) {
        return repoconsomme.save(c);
    }

    @Override
    public void deleteconsomme(consomme c) {
        repoconsomme.delete(c);
    }

    @Override
    public void deleteconsommeById(Integer id) {
        repoconsomme.deleteById(id);
    }

    @Override
    public consomme getconsomme(Integer id) {
        return repoconsomme.findById(id).get();
    }

    @Override
    public List<consomme> getAllconsommes() {
        return repoconsomme.findAll();
    }
}

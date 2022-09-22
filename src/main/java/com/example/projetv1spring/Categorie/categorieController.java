package com.example.projetv1spring.Categorie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class categorieController {

    @Autowired
    categorieService service;

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('categorie:read')")
    public List<categorie> Allcategorie(){
        return service.getAllcategories();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('categorie:read')")
    public categorie categoriebyid(@PathVariable Integer id){
        return service.getcategorie(id);
    }

    @PostMapping(value="/add")
    @PreAuthorize("hasAuthority('categorie:read')")
    public categorie addcategorie(@RequestBody categorie c) {
        return service.savecategorie(c);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updatecategorie(@PathVariable("id") Integer id,@RequestBody categorie c) {
        categorie  categorierest=service.getcategorie(id);
        categorierest.setName_categorie(c.getName_categorie());
        categorierest.setProduits(c.getProduits());

        service.savecategorie(categorierest);
        return c.getName_categorie();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteCoperative(@PathVariable("id") Integer id)
    {
        categorie c= service.getcategorie(id);
        service.deletecategorie(c);
        return "delete";
    }
}

package com.example.projetv1spring.Secteur;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secteurs")
public class secteurController {
    @Autowired
    secteurService service;

    @GetMapping("/all")
    public List<secteur> Allsecteur(){
        return service.getAllsecteurs();
    }

    @GetMapping("/{id}")
    public secteur secteurbyid(@PathVariable Integer id){
        return service.getsecteur(id);
    }

    @PostMapping(value="/add")
    @PreAuthorize("hasAuthority('secteur:write')")
    public secteur addCoperative(@RequestBody secteur s) { return service.savesecteur(s); }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN_ROLE')")
    public String updateCoperative(@PathVariable("id") Integer id,@RequestBody secteur s) {
        secteur  secteurrest=service.getsecteur(id);
        //secteurrest.setId_secteur(s.getId_secteur());
        secteurrest.setName_secteur(s.getName_secteur());
        secteurrest.setCoperatives(s.getCoperatives());

        service.savesecteur(secteurrest);
        return s.getName_secteur();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN_ROLE')")
    public String deleteCoperative(@PathVariable("id") Integer id)
    {
        secteur s= service.getsecteur(id);
        service.deletesecteur(s);
        return "delete";
    }
}

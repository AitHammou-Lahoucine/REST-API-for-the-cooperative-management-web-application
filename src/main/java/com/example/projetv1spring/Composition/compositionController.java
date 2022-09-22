package com.example.projetv1spring.Composition;

import com.example.projetv1spring.Matiere1er.matiere1er;
import com.example.projetv1spring.Matiere1er.matiere1erService;
import com.example.projetv1spring.Produit.produit;
import com.example.projetv1spring.Produit.produitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compositions")
public class compositionController {
    @Autowired
    compositionService service;
    @Autowired
    produitService serviceproduit;
    @Autowired
    matiere1erService servicematiere1er;


    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<composition> Allcomposition(){
        return service.getAllcompositions();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public composition compositionbyid(@PathVariable Integer id){
        return service.getcomposition(id);
    }

    @GetMapping("/produit/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<composition> getcompositionByproduit(@PathVariable Integer id){
        return service.getcompositionByproduit(id);
    }

    @PostMapping(value="/add/{idp}/{idm}")
    @PreAuthorize("hasAuthority('composition:write')")
    public composition addcomposition(@RequestBody composition c,@PathVariable Integer idp,@PathVariable Integer idm) {
        produit produit=serviceproduit.getproduit(idp);
        matiere1er matiere=servicematiere1er.getmatiere1er(idm);
        c.setMatiere1er(matiere);
        c.setProduit(produit);
        if(service.findCompositionByproduit(idp,idm)==0)
        {
            service.savecomposition(c);
        }
        return c;
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('composition:write')")
    public Double updatecomposition(@PathVariable("id") Integer id,@RequestBody composition c) {
        composition  compositionrest=service.getcomposition(id);
        compositionrest.setPercent_composition(c.getPercent_composition());
        compositionrest.setProduit(c.getProduit());
        compositionrest.setMatiere1er(c.getMatiere1er());

        service.savecomposition(compositionrest);
        return c.getPercent_composition();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('composition:write')")
    public String deletecompositione(@PathVariable("id") Integer id)
    {   composition c= service.getcomposition(id);
        service.deletecomposition(c);
        return "delete";
    }

}

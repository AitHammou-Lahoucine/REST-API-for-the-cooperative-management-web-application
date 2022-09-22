package com.example.projetv1spring.Produit;

import com.example.projetv1spring.Categorie.categorieService;
import com.example.projetv1spring.Composition.compositionService;
import com.example.projetv1spring.Coperative.coperativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits")
public class produitController {
    @Autowired
    produitService service;
    @Autowired
    categorieService servicecategorie;
    @Autowired
    coperativeService servicecoperative;
    @Autowired
    compositionService servicecomposition;


    @GetMapping("/free/categorie/{namecategorie}")
    public List<produit>  getProduitsBycategorie(@PathVariable String namecategorie){
        return service.getProduitsBycategorie(servicecategorie.findIDByname(namecategorie));
    }

    @GetMapping("/free/coperative/{namecoperative}")
    public List<produit>  getProduitsBycoperative(@PathVariable String namecoperative){
        return service.getProduitsBycoperative(servicecoperative.findIDByname(namecoperative));
    }

    @GetMapping("/free/region/{nameregion}")
    public List<produit>  getProduitsByregion(@PathVariable String nameregion){
        return service.getProduitsByregion(nameregion);
    }

    @GetMapping("/free/matiere1er/{namem}")
    public List<produit>  getProduitsBymatiere1er(@PathVariable String namem){
        return service.getProduitsBymatiere1er(namem);
    }
    @GetMapping("/free/origine/{nameO}")
    public List<produit>  getProduitsByoriginematiere1er(@PathVariable String nameO){
        return service.getProduitsByOriginematiere1er(nameO);
    }

    @GetMapping("/free/all")
    public List<produit> Allproduit(){
        return service.getAllproduits();
    }

    @GetMapping("/free/{id}")
    public produit produitbyid(@PathVariable Integer id){
        return service.getproduit(id);
    }

    @PostMapping(value="/add/{idc}")
    @PreAuthorize("hasAuthority('produit:write')")
    public produit addproduit(@PathVariable("idc") Integer idc,@RequestBody produit p) {
        if(p.getCategorie()!=null){
            servicecategorie.savecategorie(p.getCategorie());
        }
        p.setCoperative(servicecoperative.getcoperative(idc));
        return service.saveproduit(p);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_Coperative')")
    public String updateproduit(@PathVariable("id") Integer id,@RequestBody produit p) {
        produit  produitrest=service.getproduit(id);

        produitrest.setName_produit(p.getName_produit());
        produitrest.setPrice_produit(p.getPrice_produit());
        produitrest.setStock_produit(p.getStock_produit());
        produitrest.setUnity_produit(p.getUnity_produit());
        produitrest.setDescription_produit(p.getDescription_produit());
        produitrest.setCategorie(p.getCategorie());
        produitrest.setCompositions(p.getCompositions());
        produitrest.setConsommes(p.getConsommes());
        produitrest.setCoperative(p.getCoperative());

        service.saveproduit(produitrest);
        return p.getName_produit();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_Coperative')")
    public String deleteproduit(@PathVariable("id") Integer id)
    {
        produit p= service.getproduit(id);
        service.deleteproduit(p);

        return "delete";
    }


}

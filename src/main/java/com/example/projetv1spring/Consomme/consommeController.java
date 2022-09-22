package com.example.projetv1spring.Consomme;


import com.example.projetv1spring.Client.clientService;
import com.example.projetv1spring.Panier.panier;
import com.example.projetv1spring.Panier.panierService;
import com.example.projetv1spring.Produit.produit;
import com.example.projetv1spring.Produit.produitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/consommes")
public class consommeController {
    @Autowired
    consommeService service;
    @Autowired
    produitService produiservice;
    @Autowired
    clientService clientservice;
    @Autowired
    panierService panierservice;

    private List<consomme> ListConsommer=new ArrayList<>();

    @PostMapping("/achat/{idp}/{Qte}")
    public List<consomme> ConsomerProduit(@PathVariable Integer idp, @PathVariable Integer Qte) throws Exception {
        if(produiservice.getproduit(idp).getStock_produit()>=Qte)
        {consomme c=new consomme(null,Qte,null,produiservice.getproduit(idp));
        this.ListConsommer.add(c);}
        else{
            throw new Exception("Qte est superieure au stock");
        }
        return this.ListConsommer;
    }
    @PostMapping("/valider/{idclient}")
    @PreAuthorize("hasRole('ROLE_Client')")
    public String valider(@PathVariable Integer idclient){
        if (this.ListConsommer.isEmpty()){
            return "this consomes lists is empty";
        }
        else{
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            panier p=new panier(null,dtf.format(now),this.ListConsommer,clientservice.getclient(idclient));
            panierservice.savepanier(p);
            for(int i=0;i<this.ListConsommer.size();i++){
                produit produit= produiservice.getproduit(this.ListConsommer.get(i).getProduit().getId_produit());
                produit.setStock_produit(produit.getStock_produit()-this.ListConsommer.get(i).getQuantite_consomme());
                produiservice.saveproduit(produit);
                this.ListConsommer.get(i).setPanier(p);
                service.saveconsomme(this.ListConsommer.get(i));
            }
            this.ListConsommer.clear();
            return "Panier est valider";
        }
    }
    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<consomme> Allconsome(){
        return service.getAllconsommes();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public consomme consomebyid(@PathVariable Integer id){
        return service.getconsomme(id);
    }

    @PostMapping(value="/add")
    @PreAuthorize("hasAuthority('consome:write')")
    public consomme addconsome(@RequestBody consomme c) {
        return service.saveconsomme(c);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteconsome(@PathVariable("id") Integer id)
    {   consomme c= service.getconsomme(id);
        service.deleteconsomme(c);
        return "delete";
    }
}

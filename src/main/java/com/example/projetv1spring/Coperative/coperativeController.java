package com.example.projetv1spring.Coperative;

import com.example.projetv1spring.Region.regionService;
import com.example.projetv1spring.Secteur.secteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coperatives")
public class coperativeController {

    @Autowired
    private coperativeService service;
    @Autowired
    private regionService serviceregion;
    @Autowired
    private secteurService servicesecteur;

    @GetMapping("/free/all")
    public List<coperative> AllCoperative(){
        return service.getAllcoperatives();
    }

    @GetMapping("/free/{id}")
    public coperative Coperativebyid(@PathVariable Integer id){
        return service.getcoperative(id);
    }

    @PostMapping(value="/add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public coperative addCoperative(@RequestBody coperative c) throws Exception {
        if (c.getEmail_coperative()==null || service.countfindByemail(c.getEmail_coperative())!=0)
        {
            throw new Exception("Email existe deja !!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
        if(c.getSecteur()!=null){
            servicesecteur.savesecteur(c.getSecteur());
        }
        if(c.getRegion()!=null){
            serviceregion.saveregion(c.getRegion());
        }
         service.savecoperative(c);
         return c;
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateCoperative(@PathVariable("id") Integer id,@RequestBody coperative c) {
        coperative  coperativerest=service.getcoperative(id);

        coperativerest.setName_copeartive(c.getName_copeartive());
        coperativerest.setEmail_coperative(c.getEmail_coperative());
        coperativerest.setDate_creation_coperative(c.getDate_creation_coperative());
        coperativerest.setPassword_coperative(c.getPassword_coperative());
        coperativerest.setProduits(c.getProduits());

        if(c.getRegion()!=null) {
            serviceregion.saveregion(c.getRegion());
        }
        coperativerest.setRegion(c.getRegion());

        if(c.getSecteur()!=null) {
            servicesecteur.savesecteur(c.getSecteur());
        }
        coperativerest.setSecteur(c.getSecteur());

        service.savecoperative(coperativerest);

        return c.getName_copeartive();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteCoperative(@PathVariable("id") Integer id)
    {
        coperative c= service.getcoperative(id);
        service.deletecoperative(c);
        return "delete";
    }

    @GetMapping("/free/region/{nameregion}")
    public List<coperative>  getCoperativesByregion(@PathVariable String nameregion){
        return service.getCoperativesByregion(serviceregion.findIDByname(nameregion));
    }

    @GetMapping("/free/secteur/{namesecteur}")
    public List<coperative>  getCoperativesBysecteur(@PathVariable String namesecteur){
        return service.getCoperativesBysecteur(servicesecteur.findIDByname(namesecteur));
    }
}

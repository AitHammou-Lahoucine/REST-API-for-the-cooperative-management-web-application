package com.example.projetv1spring.Panier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paniers")
public class panierController {
    @Autowired
    panierService service;

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN_ROLE')")
    public List<panier> Allpanier(){
        return service.getAllpaniers();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN_ROLE')")
    public panier panierbyid(@PathVariable Integer id){
        return service.getpanier(id);
    }

    @PostMapping(value="/add")
    @PreAuthorize("hasRole('ADMIN_ROLE')")
    public panier addpanier(@RequestBody panier p) {
        return service.savepanier(p);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN_ROLE')")
    public String deletepanier(@PathVariable("id") Integer id)
    {   panier p= service.getpanier(id);
        service.deletepanier(p);
        return "delete";
    }
}

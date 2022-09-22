package com.example.projetv1spring.Origine;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/origines")
public class origineController {
    @Autowired
    origineService service;

    @GetMapping("/all")
    public List<origine> Allorigine(){
        return service.getAllorigines();
    }

    @GetMapping("/{id}")
    public origine originebyid(@PathVariable Integer id){
        return service.getorigine(id);
    }

    @PostMapping(value="/add")
    @PreAuthorize("hasAuthority('origine:write')")
    public origine addmatiere1er(@RequestBody origine s) { return service.saveorigine(s); }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateorigine(@PathVariable("id") Integer id, @RequestBody origine o) {
        origine  originerest=service.getorigine(id);

        originerest.setName_origine(o.getName_origine());
        originerest.setMatiere1ers(o.getMatiere1ers());

        service.saveorigine(originerest);
        return o.getName_origine();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deletematiere1er(@PathVariable("id") Integer id)
    {
        origine o= service.getorigine(id);
        service.deleteorigine(o);
        return "delete";
    }
}

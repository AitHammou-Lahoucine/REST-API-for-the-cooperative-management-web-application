package com.example.projetv1spring.Matiere1er;

import com.example.projetv1spring.Origine.origineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matiere1ers")
public class matiere1erController {
    @Autowired
    matiere1erService service;
    @Autowired
    origineService serviceorigine;

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_Client','ROLE_Coperative')")
    public List<matiere1er> Allmatiere1er(){
        return service.getAllmatiere1ers();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_Client','ROLE_Coperative')")
    public matiere1er matiere1erbyid(@PathVariable Integer id){
        return service.getmatiere1er(id);
    }

    @PostMapping(value="/add")
    @PreAuthorize("hasAuthority('matiere:write')")
    public matiere1er addmatiere1er(@RequestBody matiere1er m) {

        if(m.getOrigine()!=null){
            if(serviceorigine.countfindByname(m.getOrigine().getName_origine())==0)
            {
                serviceorigine.saveorigine(m.getOrigine());
                service.savematiere1er(m);
            }
            else{
                m.getOrigine().setId_origine(serviceorigine.findIDByname(m.getOrigine().getName_origine()));
                if(service.countMatiereByNom(m.getName_matiere1er(),serviceorigine.findIDByname(m.getOrigine().getName_origine()))==0)
                {
                    service.savematiere1er(m);
                    System.out.println("KAYNA ORIGIN MAIS MATIERE MAKAYNACH");
                }
                else{
                    System.out.println("KAYNA ORIGIN ET MATIERE ");
                }
            }
        }

        return m; }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updatematiere1er(@PathVariable("id") Integer id, @RequestBody matiere1er m) {
        matiere1er  matiere1errest=service.getmatiere1er(id);

        matiere1errest.setName_matiere1er(m.getName_matiere1er());
        matiere1errest.setCompositions(m.getCompositions());
        matiere1errest.setOrigine(m.getOrigine());

        service.savematiere1er(matiere1errest);
        return m.getName_matiere1er();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deletematiere1er(@PathVariable("id") Integer id)
    {
        matiere1er s= service.getmatiere1er(id);
        service.deletematiere1er(s);
        return "delete";
    }
}

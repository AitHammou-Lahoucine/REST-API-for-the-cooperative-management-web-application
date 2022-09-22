package com.example.projetv1spring.Region;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/regions")
public class regionContoller {
    @Autowired
    private regionService service;

    @GetMapping("/all")
    public List<region> AllCoperative(){
        return service.getAllregions();
    }

    @GetMapping("/{id}")
    public region Coperativebyid(@PathVariable Integer id){
        return service.getregion(id);
    }

    @PostMapping(value="/add")
    @PreAuthorize("hasAuthority('region:write')")
    public region addCoperative(@RequestBody region c) { return service.saveregion(c); }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String updateCoperative(@PathVariable("id") Integer id,@RequestBody region r) {
        region  regionrest=service.getregion(id);
        //regionrest.setId_region(r.getId_region());
        regionrest.setName_region(r.getName_region());
        regionrest.setCoperatives(r.getCoperatives());
        service.saveregion(regionrest);
        return r.getName_region();
    }

    @DeleteMapping("/{id}")
    public String deleteCoperative(@PathVariable("id") Integer id)
    {
        region r= service.getregion(id);
        service.deleteregion(r);
        return "delete";
    }
}

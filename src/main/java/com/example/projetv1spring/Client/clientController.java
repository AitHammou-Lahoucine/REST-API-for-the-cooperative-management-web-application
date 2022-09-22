package com.example.projetv1spring.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class clientController {
    @Autowired
    clientService service;

    public static Integer the_user_id;

    @PostMapping("sign_in")
    public void sign_in(@RequestBody client c){
        service.saveclient(c);
        the_user_id=service.findIdByclient(c);
    }

    @GetMapping("/all")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<client> Allclient(){
        return service.getAllclients();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public client clientbyid(@PathVariable Integer id){
        return service.getclient(id);
    }

    @PostMapping(value="/add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public client addclient(@RequestBody client c) throws Exception {
        if(c.getEmail_client()!=null) { service.saveclient(c); }
        else{ throw new Exception("Essayer de saisir votre email "); }
        return c;
    }

   /* @PutMapping("/{id}")
   @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateclient(@PathVariable("id") Integer id,@RequestBody client c) throws Exception {
        client clientrest=service.getclient(id);
        clientrest.setName_client(c.getName_client());
        if(service.findclientByemail(c.getEmail_client())==0)
        {  clientrest.setEmail_client(c.getEmail_client());}
        else{
            throw new Exception("Email existe deja ou bien null");
        }
        clientrest.setEmail_client(c.getEmail_client());
        clientrest.setFamily_name_client(c.getFamily_name_client());
        clientrest.setPassword_client(c.getPassword_client());
        clientrest.setPaniers(c.getPaniers());

        service.saveclient(clientrest);
        return c.getName_client();
    }*/

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteCoperative(@PathVariable("id") Integer id)
    {
        client c= service.getclient(id);
        service.deleteclient(c);
        return "delete";
    }
}

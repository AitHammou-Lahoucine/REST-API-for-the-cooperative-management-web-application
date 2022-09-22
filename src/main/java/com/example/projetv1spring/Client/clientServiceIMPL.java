package com.example.projetv1spring.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class clientServiceIMPL implements clientService{
    @Autowired
    RepoClient repoclient;

    @Override
    public client saveclient(client c) {
        if (this.findclient(c) == 0) {
            return repoclient.save(c);
        } else {
            c.setId_client(this.findIdByclient(c));
            return c;
        }
    }

    @Override
    public void deleteclient(client c) {repoclient.delete(c);}

    @Override
    public void deleteclientById(Integer id) {repoclient.deleteById(id);}

    @Override
    public client getclient(Integer id) {return repoclient.findById(id).get();}

    @Override
    public List<client> getAllclients() {return repoclient.findAll();}

    @Override
    public int findclient(client c) {
        return repoclient.findclient(c.getEmail_client(),c.getName_client(),c.getFamily_name_client(),c.getPassword());
    }

    @Override
    public int findclientByemail(String email) {
        return repoclient.findclientByemail(email);
    }

    @Override
    public Integer findIdByclient(client c) {
        return repoclient.findIdByclient(c.getEmail_client(),c.getName_client(),c.getFamily_name_client(), c.getPassword());
    }
}

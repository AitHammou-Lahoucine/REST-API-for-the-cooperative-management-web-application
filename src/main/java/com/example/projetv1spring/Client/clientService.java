package com.example.projetv1spring.Client;

import java.util.List;

public interface clientService {
    client saveclient(client c);
    void deleteclient(client c);
    void deleteclientById(Integer id);
    client getclient(Integer id);
    List<client> getAllclients();
    int findclient(client c);
    int findclientByemail(String email);
    Integer findIdByclient(client c);
}

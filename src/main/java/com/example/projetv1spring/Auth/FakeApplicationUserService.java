package com.example.projetv1spring.Auth;

import com.example.projetv1spring.Admin.Admin;
import com.example.projetv1spring.Admin.RepoAdmin;
import com.example.projetv1spring.Client.RepoClient;
import com.example.projetv1spring.Client.client;
import com.example.projetv1spring.Coperative.Repocoperation;
import com.example.projetv1spring.Coperative.coperative;
import com.example.projetv1spring.Security.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.projetv1spring.Client.clientController.the_user_id;

@Repository("fake")
public class FakeApplicationUserService implements ApplicationUserDao {
    private PasswordEncoder passwordEncoder;
    @Autowired
    public RepoClient repo;
    @Autowired
    public Repocoperation repocoperation;
    @Autowired
    public RepoAdmin repoAdmin;

    public FakeApplicationUserService(PasswordEncoder passwordEncoder){
        this.passwordEncoder=passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserEmail(String email) {
        if(repo.countclientByemail(email)!=0){
            the_user_id=repo.findclientByemail(email);
            System.out.println("the id of client is : "+the_user_id);
        }
        return this.getUsers()
                .stream()
                .filter(applicationUser -> email.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getUsers() {
        List<ApplicationUser> application_user_list = new ArrayList<>();
        List<coperative> result = repocoperation.findAll();
        List<Admin> result1 = repoAdmin.findAll();
        List<client> result2= repo.findAll();
        if (!result.isEmpty()) {
            for (int i = 0; i < result.size(); i++) {
                ApplicationUser a = new ApplicationUser(
                        result.get(i).getEmail_coperative(),
                        passwordEncoder.encode(result.get(i).getPassword_coperative()),
                        Role.Coperative.getGrantedAuthority(),
                        true,
                        true,
                        true,
                        true);
                application_user_list.add(a);
                System.out.println(a.toString());
            }
            for (int i = 0; i < result1.size(); i++) {
                ApplicationUser a = new ApplicationUser(
                        result1.get(i).getEmail_admin(),
                        passwordEncoder.encode(result1.get(i).getPassword_admin()),
                        Role.ADMIN.getGrantedAuthority(),
                        true,
                        true,
                        true,
                        true);
                application_user_list.add(a);
                System.out.println(a.toString());
            }
            for (int i = 0; i < result2.size(); i++) {
                ApplicationUser a = new ApplicationUser(
                        result2.get(i).getEmail_client(),
                        passwordEncoder.encode(result2.get(i).getPassword()),
                        Role.Client.getGrantedAuthority(),
                        true,
                        true,
                        true,
                        true);
                application_user_list.add(a);
                System.out.println(a.toString());
            }
        }
        return application_user_list;
    }
}

package com.example.projetv1spring.Auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService implements UserDetailsService {
    private ApplicationUserDao applicationUserDao;
    @Autowired
    public ApplicationUserService(ApplicationUserDao applicationUserDao){
        this.applicationUserDao=applicationUserDao;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return applicationUserDao.selectApplicationUserEmail(email)
                .orElseThrow(()->new UsernameNotFoundException("user with this email is not found :: "+email));
    }
}

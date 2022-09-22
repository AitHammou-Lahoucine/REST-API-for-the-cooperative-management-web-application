package com.example.projetv1spring.Auth;

import java.util.Optional;

public interface ApplicationUserDao {
    Optional<ApplicationUser>selectApplicationUserEmail(String email);
}

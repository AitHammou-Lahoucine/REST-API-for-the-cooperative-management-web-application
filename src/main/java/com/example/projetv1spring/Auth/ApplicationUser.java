package com.example.projetv1spring.Auth;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
@Data
@NoArgsConstructor
public class ApplicationUser implements UserDetails {
    private String username;
    private String password;
    private Set<? extends GrantedAuthority> grantedAuthorities;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;
    public ApplicationUser(
            String username,
            String password,
            Set<?extends GrantedAuthority> grantedAuthorities,
            boolean isAccountNonExpired,
            boolean isAccountNonLocked,
            boolean isCredentialsNonExpired,
            boolean isEnabled
    ){
        this.grantedAuthorities = grantedAuthorities;
        this.password = password;
        this.username = username;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.grantedAuthorities;
    }

    @Override
    public String getUsername() {
        return this.username;
    }
}

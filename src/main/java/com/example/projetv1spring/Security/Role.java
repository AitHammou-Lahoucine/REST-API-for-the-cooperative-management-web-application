package com.example.projetv1spring.Security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    Client(Sets.newHashSet( permission.CONSOME_READ,permission.CONSOME_WRITE,
                            permission.ORIGINE_READ,
                            permission.PANIER_READ,permission.PANIER_WRITE,
                            permission.COMPOSITION_READ,
                            permission.MATIERE_READ,
                            permission.CATEGORIE_READ,
                            permission.PRODUIT_READ,
                            permission.SECTEUR_READ,
                            permission.COPERATIVE_READ,
                            permission.REGION_READ)) ,
    ADMIN(Sets.newHashSet(  permission.CONSOME_READ,permission.CONSOME_WRITE,
                            permission.COMPOSITION_READ,permission.COMPOSITION_WRITE,
                            permission.CLIENT_WRITE,permission.CLIENT_READ,
                            permission.ORIGINE_READ,permission.ORIGINE_WRITE,
                            permission.PANIER_READ,permission.PANIER_WRITE,
                            permission.MATIERE_READ,permission.MATIERE_WRITE,
                            permission.CATEGORIE_READ,permission.CATEGORIE_WRITE,
                            permission.PRODUIT_READ,permission.PRODUIT_WRITE,
                            permission.SECTEUR_READ,permission.SECTEUR_WRITE,
                            permission.COPERATIVE_READ,permission.COPERATIVE_WRITE,
                            permission.REGION_READ,permission.REGION_WRITE)),
    Coperative(Sets.newHashSet( permission.CONSOME_READ,
                                permission.ORIGINE_READ,permission.ORIGINE_WRITE,
                                permission.COMPOSITION_READ,permission.COMPOSITION_WRITE,
                                permission.MATIERE_READ,permission.MATIERE_WRITE,
                                permission.CATEGORIE_READ,permission.CATEGORIE_WRITE,
                                permission.PRODUIT_READ,permission.PRODUIT_WRITE,
                                permission.SECTEUR_READ,permission.SECTEUR_WRITE,
                                permission.REGION_READ,permission.REGION_WRITE));
    private Set<permission> permissions;
    Role(Set<permission> pemissions) {
        this.permissions = pemissions;
    }
    public Set<permission> getPemissions() {
        return this.permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthority(){
        Set<SimpleGrantedAuthority>permissions=getPemissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return permissions;
    }

}

package com.example.projetv1spring.Security;


public enum permission {
    PRODUIT_READ("produit:read"),
    PRODUIT_WRITE("produit:write"),
    CONSOME_READ("consome:read"),
    CONSOME_WRITE("consome:write"),
    ORIGINE_READ("origine:read"),
    ORIGINE_WRITE("origine:write"),
    MATIERE_READ("matiere:read"),
    MATIERE_WRITE("matiere:write"),
    COMPOSITION_READ("composition:read"),
    COMPOSITION_WRITE("composition:write"),
    CATEGORIE_READ("categorie:read"),
    CATEGORIE_WRITE("categorie:write"),
    REGION_READ("region:read"),
    REGION_WRITE("region:write"),
    SECTEUR_READ("secteur:read"),
    SECTEUR_WRITE("secteur:write"),
    CLIENT_READ("client:read"),
    CLIENT_WRITE("client:write"),
    PANIER_READ("panier:read"),
    PANIER_WRITE("panier:write"),
    COPERATIVE_READ("coperative:read"),
    COPERATIVE_WRITE("coperative:write");
    private String permission;

    permission(String permission) {
        this.permission=permission;
    }
    public String getPermission(){
        return permission;
    }
}

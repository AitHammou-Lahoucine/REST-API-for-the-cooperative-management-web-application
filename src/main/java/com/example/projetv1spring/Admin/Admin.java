package com.example.projetv1spring.Admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_admin;
    private String email_admin;
    private String password_admin;
}

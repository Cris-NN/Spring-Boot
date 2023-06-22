package com.curso.curso.Models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Set;

@Entity
@Table(name = "usuarios")
@ToString @EqualsAndHashCode
public class Usuario {
    @Getter @Setter @Column(name = "ID") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /*@OneToMany(mappedBy = "usuario") @Getter @Setter
    private Set<Album> album;*/
    @Getter @Setter @Column(name = "name")
    private String name;
    @Getter @Setter @Column(name = "pass")
    private String password;

    @Getter @Setter @Column(name = "username")
    private String username;

}

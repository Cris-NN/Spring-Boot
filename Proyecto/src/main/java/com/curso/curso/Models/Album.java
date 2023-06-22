package com.curso.curso.Models;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString @EqualsAndHashCode
@Table(name = "album")
public class Album {
    @Getter @Setter @Column(name = "id") @Id
    private int id;
    @Getter @Setter @Column(name = "img")
    private String img;
    @Getter @Setter @Column(name = "userID")
    private String userID;
    @Getter @Setter @Column(name = "texto")
    private String texto;

}

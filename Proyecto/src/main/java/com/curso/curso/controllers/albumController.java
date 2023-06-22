package com.curso.curso.controllers;

import com.curso.curso.Models.Album;
import com.curso.curso.dao.AlbumDao;
import com.curso.curso.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class albumController {

    public albumController(){}

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private AlbumDao albumdao;

   @RequestMapping(value = "api/album/{id}")
    public List<Album> obtenerAlbum(@PathVariable int id){
        return albumdao.getAlbum(id);
    }

    @RequestMapping(value = "api/imagen/agregar", method = RequestMethod.POST)
    public String registrarUsuario(@RequestBody Album album, @RequestHeader("auth") String token){


        return albumdao.agregarImagen(album);
    }

}

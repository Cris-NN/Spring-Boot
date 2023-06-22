package com.curso.curso.controllers;

import com.curso.curso.Models.Usuario;
import com.curso.curso.dao.UsuarioDao;
import com.curso.curso.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class usuarioController {

    public usuarioController(){}

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getUsuarios(){
            return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "api/usuarios/{id}")
    public void eliminar(@PathVariable int id){
        usuarioDao.eliminar(id);
    }

    @RequestMapping(value = "api/usuarios/registrar", method = RequestMethod.POST)
    public String registrarUsuario(@RequestBody Usuario usuario){
       /* Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2i);
        String hash = argon2.hash(1,1024,1, usuario.getPassword());
        usuario.setPassword(hash);*/
        return usuarioDao.registrar(usuario);
    }

    @RequestMapping(value = "api/usuarios/iniciarSesion", method = RequestMethod.POST)
    public String iniciarSesion(@RequestBody Usuario usuario){
        Usuario usuarioLogeado = usuarioDao.verificarDatos(usuario);
        if (usuarioLogeado != null)
            return jwtUtil.create(String.valueOf(usuarioLogeado.getId()), usuarioLogeado.getName(), usuarioLogeado.getUsername());

        else return "FAIL";
    }

    @RequestMapping(value = "api/auth")
    public String validarToken(@RequestHeader("auth") String token) {
        try {
            String usuarioId = jwtUtil.getKey(token);
            return usuarioId;
        }catch(Exception e){
            return "false";
        }
    }




}

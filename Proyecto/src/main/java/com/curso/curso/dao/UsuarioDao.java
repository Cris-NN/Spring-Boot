package com.curso.curso.dao;

import com.curso.curso.Models.Usuario;

import java.util.List;

public interface UsuarioDao {
    List<Usuario> getUsuarios();

    void eliminar(int id);

    String registrar(Usuario usuario);

    Usuario verificarDatos(Usuario usuario);
}

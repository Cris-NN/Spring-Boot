package com.curso.curso.dao;

import com.curso.curso.Models.Album;
import com.curso.curso.Models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AlbumDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Album> getAlbum(int userID){
        String query = "from Album where userID =" + userID ;
        return entityManager.createQuery(query).getResultList();
    }

    public String agregarImagen(Album album) {
        entityManager.merge(album);
        return "OK";
    }

}

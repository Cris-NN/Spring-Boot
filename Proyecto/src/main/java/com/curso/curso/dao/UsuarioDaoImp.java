package com.curso.curso.dao;
import com.curso.curso.Models.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Usuario> getUsuarios(){
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();
        //return null;
    }

    public void eliminar(int id){
        Usuario usuario = entityManager.find(Usuario.class , id);
        entityManager.remove(usuario);
    }

    @Override
    public String registrar(Usuario usuario) {
        String query = "from Usuario where name = :name" ;
        List<Usuario> lista = entityManager.createQuery(query).setParameter("name", usuario.getName()).getResultList();
        if (lista.isEmpty()) {
            entityManager.merge(usuario);
            return "OK";
            }
        else return "FAIL";

    }

    public Usuario verificarDatos(Usuario usuario){
        String query = "from Usuario where name = :name and password = :password " ;
        List<Usuario> lista = entityManager.createQuery(query).setParameter("name", usuario.getName()).setParameter("password", usuario.getPassword()).getResultList();
        if (lista.isEmpty())
            return null;
        else return lista.get(0);
    }

}

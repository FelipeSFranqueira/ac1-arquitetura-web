package com.example.ac1.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ac1.model.Categoria;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class CategoriaRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Categoria inserir(Categoria categoria) {
        entityManager.merge(categoria);
        return categoria;
    }

    @Transactional
    public Categoria editar(Categoria categoria) {
        entityManager.merge(categoria);
        return categoria;
    }

    @Transactional
    public void excluir(Categoria categoria) {
        entityManager.remove(categoria);
    }

    @Transactional
    public void excluir(int id) {
        excluir(entityManager.find(Categoria.class, id));
    }

    public Categoria obterPorId(int id) {
        String jpql = " select c from Categoria c where c.id_categoria = :id";
        TypedQuery<Categoria> query = entityManager.createQuery(jpql, Categoria.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public List<Categoria> obterTodos() {
        return entityManager.createQuery("from Categoria", Categoria.class).getResultList();
    }
}

package org.example.dao;

import org.example.modelo.Cliente;
import org.example.modelo.Pedido;
import org.example.modelo.Produto;

import javax.persistence.EntityManager;

public class ClienteDao {
    private EntityManager em;

    public ClienteDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Cliente cliente) {
        this.em.persist(cliente);
    }
    public Cliente buscarPorId(Long id) {
        return em.find(Cliente.class, id);
    }
}

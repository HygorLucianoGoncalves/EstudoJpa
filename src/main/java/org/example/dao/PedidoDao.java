package org.example.dao;

import org.example.modelo.Pedido;
import org.example.modelo.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class PedidoDao {
    private EntityManager em;

    public PedidoDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Pedido pedido) {
        this.em.persist(pedido);
    }
    
    public BigDecimal valorTotalVendido(){
        String jqpl = "SELECT SUM(p.valorTotal) FROM Pedido p ";
        return em.createQuery(jqpl, BigDecimal.class).getSingleResult();
    }
    
}

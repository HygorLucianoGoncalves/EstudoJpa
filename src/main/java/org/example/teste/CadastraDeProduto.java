package org.example.teste;

import org.example.modelo.Produto;
import org.example.dao.ProdutoDao;
import org.example.util.JpaUtil;

import javax.persistence.EntityManager;

public class CadastraDeProduto {
    public static void main(String[] args) {
        var celuar = new Produto("xiami Redmun", "Muito legal", 800);
        
        EntityManager em = JpaUtil.getEntityManager();
        var dao = new ProdutoDao(em);
        
        em.getTransaction().begin();
        dao.cadastrar(celuar);
        em.getTransaction().commit();
        em.close();
    }
}

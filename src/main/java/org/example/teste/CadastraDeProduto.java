package org.example.teste;

import org.example.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CadastraDeProduto {
    public static void main(String[] args) {
        var celuar = new Produto("xiami Redmun", "Muito legal", 800);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("loja");

        EntityManager em = factory.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(celuar);
        em.getTransaction().commit();
        em.close();
    }
}

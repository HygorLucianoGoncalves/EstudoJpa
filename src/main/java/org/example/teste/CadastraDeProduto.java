package org.example.teste;

import org.example.dao.CategoriaDao;
import org.example.modelo.Categoria;
import org.example.modelo.Produto;
import org.example.dao.ProdutoDao;
import org.example.util.JpaUtil;

import javax.persistence.EntityManager;

public class CadastraDeProduto {
    public static void main(String[] args) {
        
        
        var celuar = new Produto("xiami Redmun", "Muito legal", 800);

        var celulares = new Categoria("CELULARES");
        var celularIphone = new Produto("iphone", "Muito Bom", 800,celulares);
        
        EntityManager em = JpaUtil.getEntityManager();
        var produtoDao = new ProdutoDao(em);
        var categoriaDao = new CategoriaDao(em);
        
        em.getTransaction().begin();
        
        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celuar);
        
        em.getTransaction().commit();
        em.close();
    }
}

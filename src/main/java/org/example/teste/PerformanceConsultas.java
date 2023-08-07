package org.example.teste;

import org.example.dao.CategoriaDao;
import org.example.dao.ClienteDao;
import org.example.dao.PedidoDao;
import org.example.dao.ProdutoDao;
import org.example.modelo.*;
import org.example.util.JpaUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class PerformanceConsultas {
    public static void main(String[] args) {
        popularBancoDeDados();
        EntityManager em = JpaUtil.getEntityManager();
        Pedido pedido = em.find(Pedido.class, 1L);
        PedidoDao pedidoDao = new PedidoDao(em);
        Pedido pedido1 =  pedidoDao.buscarPedidoComCliente(1l);
        em.close();
        System.out.println(pedido1.getCliente().getName());
    }
    private static void popularBancoDeDados() {
        Categoria celulares = new Categoria("CELULARES");
        Categoria videogames = new Categoria("VIDEOGAMES");
        Categoria informatica = new Categoria("INFORMATICA");
        
        Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares );
        Produto videogame = new Produto("PS5", "Playstation",new BigDecimal(5000),videogames);
        Produto macbook = new Produto("Macbook", "Macbook pro 13 polegadas",new BigDecimal(10000), informatica);

        var cliente = new Cliente("Rodrigo", "123456");

        var pedido = new Pedido(cliente);
        pedido.adicionarItem(new ItemPedido(10, pedido,celular));
        pedido.adicionarItem(new ItemPedido(40, pedido, videogame));

        Pedido pedido2 = new Pedido(cliente);
        pedido.adicionarItem(new ItemPedido(2, pedido, macbook));


        EntityManager em = JpaUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);
        ClienteDao clienteDao = new ClienteDao(em);
        PedidoDao pedidoDao = new PedidoDao(em);

        em.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        categoriaDao.cadastrar(videogames);
        categoriaDao.cadastrar(informatica);

        produtoDao.cadastrar(celular);
        produtoDao.cadastrar(videogame);
        produtoDao.cadastrar(macbook);

        clienteDao.cadastrar(cliente);
        
        pedidoDao.cadastrar(pedido);
        pedidoDao.cadastrar(pedido2);
        
        em.getTransaction().commit();
        em.close();
    }
}

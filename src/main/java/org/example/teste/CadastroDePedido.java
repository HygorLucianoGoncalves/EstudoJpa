package org.example.teste;

import org.example.dao.CategoriaDao;
import org.example.dao.ClienteDao;
import org.example.dao.PedidoDao;
import org.example.dao.ProdutoDao;
import org.example.modelo.*;
import org.example.util.JpaUtil;
import org.example.vo.RelatorioDeVendasVo;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroDePedido {
    public static void main(String[] args) {
        popularBancoDeDados();
        EntityManager em = JpaUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        ClienteDao clienteDao = new ClienteDao(em);
        
        Produto produto = produtoDao.buscarPorId(1l);
        Produto produto2 = produtoDao.buscarPorId(2l);
        Produto produto3 = produtoDao.buscarPorId(3l);
        Cliente cliente = clienteDao.buscarPorId(1l);
        
        em.getTransaction().begin();
        
        
        var pedido = new Pedido(cliente);
        pedido.adicionarItem(new ItemPedido(10, pedido, produto));
        pedido.adicionarItem(new ItemPedido(40, pedido, produto2));
        
        Pedido pedido2 = new Pedido(cliente);
        pedido.adicionarItem(new ItemPedido(2, pedido, produto3));
        
        var pedidoDao = new PedidoDao(em);
        pedidoDao.cadastrar(pedido);
        pedidoDao.cadastrar(pedido2);
        
        em.getTransaction().commit();
        
        BigDecimal totalVendido = pedidoDao.valorTotalVendido();
        System.out.println("VALOR TOTAL = "+totalVendido);

        List<RelatorioDeVendasVo> relatorio = pedidoDao.relatorioDeVendas();
        relatorio.forEach(System.out::println);
    }

    private static void popularBancoDeDados() {
        Categoria celulares = new Categoria("CELULARES");
        Categoria videogames = new Categoria("VIDEOGAMES");
        Categoria informatica = new Categoria("INFORMATICA");
        
        
        Produto celular = new Produto("Xiaomi Redmi", "Muito legal", new BigDecimal("800"), celulares );
        Produto videogame = new Produto("PS5", "Playstation",new BigDecimal(5000),videogames);
        Produto macbook = new Produto("Macbook", "Macbook pro 13 polegadas",new BigDecimal(10000), informatica);

        var cliente = new Cliente("Rodrigo", "123456");
        
        EntityManager em = JpaUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);
        ClienteDao clienteDao = new ClienteDao(em);
        
        em.getTransaction().begin();

        categoriaDao.cadastrar(celulares);
        categoriaDao.cadastrar(videogames);
        categoriaDao.cadastrar(informatica);
        
        produtoDao.cadastrar(celular);
        produtoDao.cadastrar(videogame);
        produtoDao.cadastrar(macbook);
        
        clienteDao.cadastrar(cliente);

        em.getTransaction().commit();
        em.close();
    }
}

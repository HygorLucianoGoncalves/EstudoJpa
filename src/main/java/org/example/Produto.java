package org.example;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String nome;
    private String descricao;
    private Integer preco;
    
    public Produto() {
    }

    public Produto(String nome, String descricao,  Integer preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    

    public  Integer getPreco() {
        return preco;
    }

    public void setPreco( Integer preco) {
        this.preco = preco;
    }

  
}

package org.example.modelo;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "produtos")
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String nome;
    private String descricao;
    private Integer preco;
    private LocalDate  dataCadastro = LocalDate.now();
    @ManyToOne
    private Categoria categoria;
    
    public Produto() {
    }

    public Produto(String nome, String descricao,  Integer preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }
    public Produto(String nome, String descricao, Integer preco, Categoria categoria) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.categoria = categoria;
    }

    
//    GET AND SET 
    
    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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

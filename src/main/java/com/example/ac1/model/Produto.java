package com.example.ac1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_produto;

    @Column(length = 255, columnDefinition = "TINYTEXT")
    private String prod_nome;

    private int prod_qtd;

    @ManyToOne
    @JoinColumn(name = "id_categoria")
    @JsonIgnore
    private Categoria id_categoria;

    public Produto() {
    }

    public Produto(int id_produto, String prod_nome, int prod_qtd) {
        this.id_produto = id_produto;
        this.prod_nome = prod_nome;
        this.prod_qtd = prod_qtd;
    }

    public Produto(int id_produto, String prod_nome, int prod_qtd, Categoria id_categoria) {
        this.id_produto = id_produto;
        this.prod_nome = prod_nome;
        this.prod_qtd = prod_qtd;
        this.id_categoria = id_categoria;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getProd_nome() {
        return prod_nome;
    }

    public void setProd_nome(String prod_nome) {
        this.prod_nome = prod_nome;
    }

    public int getProd_qtd() {
        return prod_qtd;
    }

    public void setProd_qtd(int prod_qtd) {
        this.prod_qtd = prod_qtd;
    }

    public Categoria getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Categoria id_categoria) {
        this.id_categoria = id_categoria;
    }

    @Override
    public String toString() {
        return "produtos [id_produto=" + id_produto + ", prod_nome=" + prod_nome + ", prod_qtd=" + prod_qtd
                + ", id_categoria=" + id_categoria + "]";
    }
}

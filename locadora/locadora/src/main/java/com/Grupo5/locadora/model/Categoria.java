package com.Grupo5.locadora.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "tb_categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 255)
    private String titulo;

    @Size(min = 3, max = 255)
    private String descricao;

    @Size(min = 3, max = 255)
    private String UrlImg;

    @OneToMany(mappedBy = "categoria")
    @JsonIgnoreProperties("categoria")
    private List<Produto> produtos;


    //constructor
    //
    //
    public Categoria() {
    }

    public Categoria(String titulo, String descricao, String urlImg) {

            this.titulo = titulo;
            this.descricao = descricao;
            UrlImg = urlImg;
        }

        //setter&getters
    //
    //
    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrlImg() {
        return UrlImg;
    }

    public void setUrlImg(String urlImg) {
        UrlImg = urlImg;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}

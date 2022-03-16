package com.Grupo5.locadora.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "tb_cidades")
public class Cidades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 255)
    private String nome;

    //ver alterações no tipo
    @Size(min = 3, max = 255)
    private String pais;

    @OneToMany(mappedBy = "cidade")
    @JsonIgnoreProperties("cidades")
    private List<Produto> produtos;


    //constructor
    //
    //
    public Cidades() {
    }

    public Cidades(String nome, String pais) {
        this.nome = nome;
        this.pais = pais;
    }

    //methods
    //
    //

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}

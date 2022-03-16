package com.Grupo5.locadora.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "tb_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 255)
    private String nome;

    @Size(min = 3, max = 255)
    private String descricao;

    //aqui cria a coleção de imagens do produto
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name="imagem_produto",
            joinColumns = @JoinColumn(name = "id"))
    @Column(name="imagem_produto")
    private List<String> imagens;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categoria_id")
    @JsonIgnoreProperties("categoria")
    private Categoria categoria;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cidade_id")
    @JsonIgnoreProperties("cidade")
    private Cidades cidade;

    //constructor
    //
    //
    public Produto() {
    }

    public Produto(String nome, String descricao, List<String> imagens, Categoria categoria, Cidades cidade) {
        this.nome = nome;
        this.descricao = descricao;
        this.imagens = imagens;
        this.categoria = categoria;
        this.cidade = cidade;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<String> getImagens() {
        return imagens;
    }

    public void setImagens(List<String> imagens) {
        this.imagens = imagens;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}

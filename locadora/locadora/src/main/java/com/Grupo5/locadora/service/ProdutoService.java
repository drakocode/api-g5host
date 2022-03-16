package com.Grupo5.locadora.service;

import com.Grupo5.locadora.model.Produto;
import com.Grupo5.locadora.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;



    //constructor
    //
    //

    public ProdutoService() {
    }

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    //methods
    //
    //

    //criar produto
    public Produto cadastrarNovoProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    //listar todos os produtos
    public List<Produto> buscarTodos(){
        return produtoRepository.findAll();
    }

    //buscar produto por id
    public Produto buscarProdutoPorId(Long id){
        return produtoRepository.findById(id).get();
    }

    //editar produto
    public Produto editarCategoria(Produto produto, Long id){
        Produto produtoUpdate=produtoRepository.findById(id).get();
        produtoUpdate.setNome(produto.getNome());
        produtoUpdate.setDescricao(produto.getDescricao());
        produtoUpdate.setImagens(produto.getImagens());


        return produtoRepository.save(produtoUpdate);
    }


    //listar produtos da categoria

    //excluir produto por id
    public void excluirProduto(Long id){
        produtoRepository.deleteById(id);
    }


}

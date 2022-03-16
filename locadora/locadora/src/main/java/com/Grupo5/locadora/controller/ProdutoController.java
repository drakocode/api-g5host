package com.Grupo5.locadora.controller;

import com.Grupo5.locadora.model.Produto;
import com.Grupo5.locadora.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins = "*", allowedHeaders = "")
public class ProdutoController {

    private ProdutoService produtoService;

    //constructor
    //
    //
    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }


    //methods
    //
    //



    //criar produto
    @PostMapping
    public Produto adicionarCategoria(@RequestBody Produto produto){
        return produtoService.cadastrarNovoProduto(produto);
    }



    //listar todos os produtos
    @GetMapping("/produtos")
    public ResponseEntity<List<Produto>> buscarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.buscarTodos());
    }


    //buscar produto por id
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.buscarProdutoPorId(id));
    }


    //atualizar produto
    @PutMapping("/{id}")
    public Produto editarProduto(@RequestBody Produto produto, @PathVariable Long id){
        return produtoService.editarCategoria(produto, id);
    }

    //excluir produto
    @DeleteMapping("/{id}")
    public String excluirProduto(@PathVariable Long id){
        produtoService.excluirProduto(id);
        return "deletado";
        //pode ser void
    }
}

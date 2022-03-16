package com.Grupo5.locadora.controller;

import com.Grupo5.locadora.model.Categoria;
import com.Grupo5.locadora.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "")
public class CategoriaController {

    private CategoriaService categoriaService;

    //constructor
    //
    //
    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    //methods
    //
    //

    //cadastrar
    @PostMapping
    public Categoria adicionarCategoria(@RequestBody Categoria categoria){
        return categoriaService.cadastrarNovaCategoria(categoria);
    }

    //listar
    @GetMapping("/categorias")
    public ResponseEntity<List<Categoria>> buscarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.buscarTodos());
    }

    //atualizar
    @PutMapping("/{id}")
    public Categoria editarCategoria(@RequestBody Categoria categoria, @PathVariable Long id){
        return categoriaService.editarCategoria(categoria, id);
    }

    //excluir
    @DeleteMapping("/{id}")
    public String excluirCategoria(@PathVariable Long id){
        categoriaService.excluirCategoria(id);
        return "deletado";
        //pode ser void
    }

    //listar produtos da categoria
    @GetMapping("/categorias/{titulo}")
    public ResponseEntity <List<Categoria>> buscarProdutosDaCategoria(@PathVariable String titulo ){
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.buscarProdutosDaCategoria(titulo));
    }
}

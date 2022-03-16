package com.Grupo5.locadora.controller;

import com.Grupo5.locadora.model.Cidades;
import com.Grupo5.locadora.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidade")
@CrossOrigin(origins = "*", allowedHeaders = "")
public class CidadeController {

    private CidadeService cidadeService;

    //constructor
    //
    //
    @Autowired
    public CidadeController(CidadeService cidadeService) {
        this.cidadeService = cidadeService;
    }


    //methods
    //
    //

    //cadastrar
    @PostMapping
    public Cidades adicionarCategoria(@RequestBody Cidades cidades){
        return cidadeService.cadastrarNovaCidade(cidades);
    }

    //atualizar
    @PutMapping("/{id}")
    public Cidades editarCategoria(@RequestBody Cidades cidades, @PathVariable Long id){
        return cidadeService.editarCidade(cidades, id);
    }

    //excluir
    @DeleteMapping("/{id}")
    public String excluirCategoria(@PathVariable Long id){
        cidadeService.excluirCidade(id);
        return "deletado";
        //pode ser void
    }

    //listar todas as cidades
    @GetMapping("/cidades")
    public ResponseEntity<List<Cidades>> buscarTodos(){
        return ResponseEntity.status(HttpStatus.OK).body(cidadeService.buscarTodos());
    }

    //buscar produtos segundo cidade
    @GetMapping("/{nome}")
    public ResponseEntity <List<Cidades>> buscarProdutosDaCidade(@PathVariable String nome ){
        return ResponseEntity.status(HttpStatus.OK).body(cidadeService.buscarProdutosDaCategoria(nome));
    }


}

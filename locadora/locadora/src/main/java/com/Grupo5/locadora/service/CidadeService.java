package com.Grupo5.locadora.service;

import com.Grupo5.locadora.model.Cidades;
import com.Grupo5.locadora.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {


    @Autowired
    private CidadeRepository cidadeRepository;



    //constructor
    //
    //
    public CidadeService() {
    }

    public CidadeService(CidadeRepository cidadeRepository) {
        this.cidadeRepository = cidadeRepository;
    }


    //methods
    //
    //
    public Cidades cadastrarNovaCidade(Cidades cidade){
        return cidadeRepository.save(cidade);
    }




    public Cidades editarCidade(Cidades cidades, Long id){
        Cidades cidadeUpdate=cidadeRepository.findById(id).get();
        cidadeUpdate.setNome(cidades.getNome());
        cidadeUpdate.setPais(cidades.getPais());


        return cidadeRepository.save(cidadeUpdate);
    }

    public void excluirCidade(Long id){
        cidadeRepository.deleteById(id);
    }


    //listar todas as cidades
    public List<Cidades> buscarTodos(){
        return cidadeRepository.findAll();
    }

    //buscar produtos segundo cidade
    public List<Cidades> buscarProdutosDaCategoria(String nome) {
        return cidadeRepository.findByNomeContainingIgnoreCase(nome);
    }
}

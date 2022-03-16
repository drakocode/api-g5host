package com.Grupo5.locadora.service;

import com.Grupo5.locadora.model.Categoria;
import com.Grupo5.locadora.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;


    //constructor
    //
    //

    public CategoriaService() {
    }

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    //methods
    //
    //
    public List<Categoria> buscarTodos(){
        return categoriaRepository.findAll();
    }

    public Categoria editarCategoria(Categoria categoria, Long id){
        Categoria categoriaUpdate=categoriaRepository.findById(id).get();
        categoriaUpdate.setTitulo(categoria.getTitulo());
        categoriaUpdate.setDescricao(categoria.getDescricao());
        categoriaUpdate.setUrlImg(categoria.getUrlImg());


        return categoriaRepository.save(categoriaUpdate);
    }

    public void excluirCategoria(Long id){
        categoriaRepository.deleteById(id);
    }

    public Categoria cadastrarNovaCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }


    //metodo teste
    //buscar produtos da categoria
    public List<Categoria> buscarProdutosDaCategoria(String titulo) {
        return categoriaRepository.findByTituloContainingIgnoreCase(titulo);
    }

}

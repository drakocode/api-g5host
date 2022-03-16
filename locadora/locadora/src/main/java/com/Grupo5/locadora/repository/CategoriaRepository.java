package com.Grupo5.locadora.repository;


import com.Grupo5.locadora.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    List<Categoria> findByTituloContainingIgnoreCase(String titulo);

}

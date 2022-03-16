package com.Grupo5.locadora.repository;

import com.Grupo5.locadora.model.Cidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidades, Long> {
    List<Cidades> findByNomeContainingIgnoreCase(String nome);
}

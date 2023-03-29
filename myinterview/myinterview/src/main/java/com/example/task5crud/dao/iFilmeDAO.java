package com.example.task5crud.dao;

import com.example.task5crud.model.Categoria;
import com.example.task5crud.model.Filme;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

//Definir todos os métodos
public interface iFilmeDAO {
    Filme save(Filme filme);
    Filme update(Filme filme);
    void delete(Long id);
    List<Filme> findAll();

    //O Optional ajuda quando o usuário passa um Id que não existe
    Optional<Filme> findById(Long id) throws SQLException;

    List<Filme> findByCategoria(Categoria categoria);

}

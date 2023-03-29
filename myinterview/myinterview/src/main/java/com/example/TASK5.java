package com.example;

import com.example.model.Categoria;
import com.example.model.Filme;
import dao.FilmeDAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

/**
 * Create an implementation of a Rest API .
 * Expose an API. Feel free to explore possibilities/functionalities/capabilities following Rest standard.
 * We suggest that your implementation have at least a CRUD scenario.
 *
 */
public class TASK5 {
    public static void main(String[] args) throws SQLException {
/*        Metodo para apresentar todos os filmes
        FilmeDAO dao = new FilmeDAO();
        List<Filme> filmes = dao.findAll();

        for (Filme filme: filmes) {
            System.out.println("ID: " + filme.getId());
            System.out.println("Nome: " + filme.getNome());
            System.out.println("Duração: "+ filme.getDuracao());
            System.out.println("Categoria: " + filme.getCategoria());
            System.out.println("=================================");
        } */

        //Metodo para apresentar o filme por ID

        FilmeDAO dao = new FilmeDAO();
        Optional<Filme> filmeOptional = dao.findById(2L);
        filmeOptional.ifPresent(filme -> {
            System.out.println("ID: " + filme.getId());
            System.out.println("Nome: " + filme.getNome());
            System.out.println("Duração: "+ filme.getDuracao());
            System.out.println("Categoria: " + filme.getCategoria());
        });
                ;
    }
}
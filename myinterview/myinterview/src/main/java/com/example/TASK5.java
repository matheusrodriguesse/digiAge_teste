package com.example;

import com.example.model.Categoria;
import com.example.model.Filme;
import dao.FilmeDAO;

/**
 * Create an implementation of a Rest API .
 * Expose an API. Feel free to explore possibilities/functionalities/capabilities following Rest standard.
 * We suggest that your implementation have at least a CRUD scenario.
 *
 */
public class TASK5 {
    public static void main(String[] args) {
        FilmeDAO dao = new FilmeDAO();
        Filme filme = new Filme();
        filme.setNome("A espera de um milagre");
        filme.setDuracao(180);
        filme.setCategoria(Categoria.Suspense);

        dao.save(filme);
    }
}
package com.example.task5crud;

import com.example.task5crud.model.Categoria;
import com.example.task5crud.model.Filme;
import com.example.task5crud.dao.FilmeDAO;

public class CreateFilm {
    public static void main(String[] args) {
        FilmeDAO dao = new FilmeDAO();

        Filme filme = new Filme();
        filme.setNome("Vamo que vamo");
        filme.setDuracao(200);
        filme.setCategoria(Categoria.Aventura);
        Filme filmeInserido = dao.save(filme);
    }

}

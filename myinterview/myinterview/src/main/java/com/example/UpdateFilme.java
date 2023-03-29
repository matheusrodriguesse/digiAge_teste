package com.example;

import com.example.model.Categoria;
import com.example.model.Filme;
import dao.FilmeDAO;

import java.sql.SQLException;
import java.util.Optional;

public class UpdateFilme {
    public static void main(String[] args) throws SQLException {

        FilmeDAO dao = new FilmeDAO();
        //Precisamos recuperar o registro

        Optional<Filme> filmeOptional = dao.findById(3L);

        if (filmeOptional.isPresent()) {
            Filme filme = filmeOptional.get();
            System.out.println("ID: " + filme.getId());
            System.out.println("Nome: " + filme.getNome());
            System.out.println("Duração: "+ filme.getDuracao());
            System.out.println("Categoria: " + filme.getCategoria());

            filme.setNome("Testando");
            filme.setDuracao(180);
            filme.setCategoria(Categoria.Suspense);
            dao.update(filme);
        } else {
            System.out.println("Filme não encontrado");
        }
    }
}


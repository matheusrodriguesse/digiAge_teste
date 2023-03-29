package com.example.task5crud;

import com.example.task5crud.model.Categoria;
import com.example.task5crud.model.Filme;
import com.example.task5crud.dao.FilmeDAO;

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

            //Novos valores
            filme.setNome("Testando");
            filme.setDuracao(180);
            filme.setCategoria(Categoria.Suspense);
            dao.update(filme);
        } else {
            System.out.println("Filme não encontrado");
        }
    }
}


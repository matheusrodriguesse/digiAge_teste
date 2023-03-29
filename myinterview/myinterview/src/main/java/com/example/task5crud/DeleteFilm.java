package com.example.task5crud;

import com.example.task5crud.dao.FilmeDAO;

public class DeleteFilm {
    public static void main(String[] args) {
        FilmeDAO dao = new FilmeDAO();
        dao.delete(3L);
    }

}

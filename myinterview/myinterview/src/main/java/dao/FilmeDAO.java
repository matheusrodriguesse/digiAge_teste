package dao;

import com.example.model.Categoria;
import com.example.model.Filme;
import infra.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

//A partir da interface criamos os métodos para nossa classe
public class FilmeDAO implements iFilmeDAO {
    @Override
    public Filme save(Filme filme) {
        //Chamando a conexão
        try(Connection connection = ConnectionFactory.getConnection()) {

            String sql = "INSERT INTO FILMES (nome, duracao, categoria) VALUES(?,?,?)" ;
            //Passando a instruçãoi sql
            PreparedStatement preparedStatement = connection.prepareStatement(sql);


            preparedStatement.setString(1, filme.getNome());
            preparedStatement.setDouble(2, filme.getDuracao());
            preparedStatement.setString(3, filme.getCategoria().toString());

            //Executando instrução
            preparedStatement.executeUpdate();



        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } ;

        return filme;
    }

    @Override
    public Filme update(Filme filme) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Filme> findAll() {
        return null;
    }

    @Override
    public Optional<Filme> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Filme> findByCategoria(Categoria categoria) {
        return null;
    }
}

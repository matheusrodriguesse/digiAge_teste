package com.example.task5crud.dao;

import com.example.task5crud.model.Categoria;
import com.example.task5crud.model.Filme;
import com.example.task5crud.infra.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//A partir da interface criamos os métodos para nossa classe
public class FilmeDAO implements iFilmeDAO {
    @Override
    public Filme save(Filme filme) {
        //Chamando a conexão
        try(Connection connection = ConnectionFactory.getConnection()) {

            String sql = "INSERT INTO FILMES (nome, duracao, categoria) VALUES(?,?,?)" ;
            //Passando a instrução sql e retornando uma chave
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            //Setando na memória
            preparedStatement.setString(1, filme.getNome());
            preparedStatement.setDouble(2, filme.getDuracao());
            preparedStatement.setString(3, filme.getCategoria().toString());

            //Executando instrução
            preparedStatement.executeUpdate();

            //Recuperando a chave e gerando um Id
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();

            Long generatedId = resultSet.getLong("id");
            filme.setId(generatedId);


        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } ;

        return filme;
    }

    @Override
    public Filme update(Filme filme) {
        //Chamando a conexão
        try(Connection connection = ConnectionFactory.getConnection()) {
            String sql = "UPDATE FILMES SET nome = ?, duracao = ?, categoria = ? WHERE id = ?" ;
            //Passando a instrução sql e retornando uma chave
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //Setando na memória os novos valores
            preparedStatement.setString(1, filme.getNome());
            preparedStatement.setDouble(2, filme.getDuracao());
            preparedStatement.setString(3, filme.getCategoria().toString());
            preparedStatement.setLong(4,filme.getId());

            //Executando instrução
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return filme;
    }

    @Override
    public void delete(Long id) {
        try(Connection connection = ConnectionFactory.getConnection()) {
            String sql = "DELETE FILMES WHERE id = ?" ;
            //Passando a instrução sql e retornando uma chave
            PreparedStatement preparedStatement = connection.prepareStatement(sql);



            preparedStatement.setLong(1,id);

            //Executando instrução
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Filme> findAll() {
        String sql = "SELECT id, nome, duracao, categoria FROM Filmes";
        List<Filme> filmes = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String nome = resultSet.getString("nome");
                Double duracao = resultSet.getDouble("duracao");
                Categoria categoria = Categoria.valueOf(resultSet.getString("categoria"));
                Filme filme = new Filme(id, nome, duracao, categoria);
                filmes.add(filme);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return filmes;
    }


    @Override
    public Optional<Filme> findById(Long id) throws SQLException {
        String sql = "SELECT id, nome, duracao, categoria FROM Filmes WHERE id =?";
        Filme filme = null;

        try (Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Long pKey = resultSet.getLong("id");
                String nome = resultSet.getString("nome");
                Double duracao = resultSet.getDouble("duracao");
                Categoria categoria = Categoria.valueOf(resultSet.getString("categoria"));
                filme = new Filme(pKey, nome, duracao, categoria);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(filme);
    }



    @Override
    public List<Filme> findByCategoria(Categoria categoria) {

        String sql = "SELECT id, nome, duracao, categoria FROM Filmes WHERE categoria = ?";
        List<Filme> filmes = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1,categoria.toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Long pKey = resultSet.getLong("id");
                String nome = resultSet.getString("nome");
                Double duracao = resultSet.getDouble("duracao");
                Categoria cat = Categoria.valueOf(resultSet.getString("categoria"));
                Filme filme = new Filme(pKey, nome, duracao, cat);
                filmes.add(filme);

            }
        return filmes;
    } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }}

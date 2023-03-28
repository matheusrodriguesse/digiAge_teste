package dao;

import com.example.model.Categoria;
import com.example.model.Filme;

import java.util.List;
import java.util.Optional;

public class FilmeDAO implements iFilmeDAO {
    @Override
    public Filme save(Filme filme) {
        return null;
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

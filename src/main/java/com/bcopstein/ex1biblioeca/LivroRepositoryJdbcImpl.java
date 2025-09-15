package com.bcopstein.ex1biblioeca;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class LivroRepositoryJdbcImpl implements LivroRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public LivroRepositoryJdbcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Livro> findAll() {
        List<Livro> resp = this.jdbcTemplate.query("SELECT * from livros",
                (rs, rowNum) -> new Livro(
                        rs.getInt("id"), 
                        rs.getString("titulo"), 
                        rs.getString("autor"),
                        rs.getInt("ano")));
        return resp;
    }

    @Override
    public void save(Livro livro) {
        this.jdbcTemplate.update(
                "INSERT INTO livros (id, titulo, autor, ano) VALUES (?,?,?,?)",
                livro.getId(), 
                livro.getTitulo(), 
                livro.getAutor(), 
                livro.getAno());
    }
}
package com.bcopstein.ex1biblioeca;

import java.util.List;

public interface LivroRepository {
    List<Livro> findAll();
    void save(Livro livro);
}
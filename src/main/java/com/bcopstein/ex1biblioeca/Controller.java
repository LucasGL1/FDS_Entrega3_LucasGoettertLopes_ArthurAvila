package com.bcopstein.ex1biblioeca;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/biblioteca")
public class Controller {

    private LivroRepository acervo;

    @Autowired
    public Controller(LivroRepository acervo) {
        this.acervo = acervo;
    }

    @GetMapping("/")
    @CrossOrigin(origins = "*")
    public String getSaudacao() {
        return "Bem vindo a biblioteca central!";
    }

    @GetMapping("/livros")
    @CrossOrigin(origins = "*")
    public List<Livro> getLivros() {
        return acervo.findAll();
    }
    
    @PostMapping("/livros")
    @CrossOrigin(origins = "*")
    public void cadastraLivroNovo(@RequestBody Livro livro){
        acervo.save(livro);
    }
}
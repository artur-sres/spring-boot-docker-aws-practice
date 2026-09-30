package io.github.artur_sres.libraryapi.model;

import io.github.artur_sres.libraryapi.repository.AutorRepository;
import io.github.artur_sres.libraryapi.repository.LivroRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LivroTest {

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    AutorRepository autorRepository;

    @Test
    public void salvarTest(){
        Livro livro = new Livro();

        livro.setIsbm("1234-1234");
        livro.setTitulo("UFO");
        livro.setDataPublicacao(LocalDate.of(1980, 1, 1));
        livro.setGenero(GeneroLivro.FICÇÃO);
        livro.setPreco(BigDecimal.valueOf(100));

        Autor autor = autorRepository
                .findById(UUID.fromString("488bf000-caa7-4150-865e-6401de3c9d04"))
                .orElse(null);

        livro.setAutor(autor);

        livroRepository.save(livro);

    }
}
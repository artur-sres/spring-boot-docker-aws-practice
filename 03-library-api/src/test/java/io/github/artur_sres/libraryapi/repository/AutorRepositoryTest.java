package io.github.artur_sres.libraryapi.repository;

import io.github.artur_sres.libraryapi.model.Autor;
import io.github.artur_sres.libraryapi.model.GeneroLivro;
import io.github.artur_sres.libraryapi.model.Livro;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.security.PublicKey;
import java.time.LocalDate;
import java.util.*;

@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    AutorRepository autorRepository;

    @Autowired
    LivroRepository livroRepository;

    @Test
    public void salvarTest(){
        Autor autor = new Autor();

        autor.setNome("Maria");
        autor.setNacionalidade("Brasileiro");
        autor.setDataNascimento(LocalDate.of(19830, 3, 31));

        System.out.println("Autor salvo: " + autorRepository.save(autor));
    }

    @Test
    public void atualizarTest(){
        var id = UUID.fromString("488bf000-caa7-4150-865e-6401de3c9d04");

        Optional<Autor> autor = autorRepository.findById(id);

        if(autor.isPresent()){
            Autor autor1 = autor.get();

            System.out.println("Autor encontrado: ");
            System.out.println(autor1);

            autor1.setDataNascimento(LocalDate.of(1960, 12, 1));
            autorRepository.save(autor1);
        }
    }

    @Test
    public void listarTest(){
        autorRepository.findAll().forEach(System.out::println);
    }

    @Test
    public void countTest(){
        System.out.println("Contagem de autores: " + autorRepository.count());
    }

    @Test
    public void deletarTest(){
        autorRepository.deleteById(UUID.fromString("07f3cba8-bcaf-4c8f-8a29-cd58b72ff2d1"));

    }

    @Test
    public void salvarAutorComLivrosTest(){
        Autor autor = new Autor();
        autor.setNome("Arthur");
        autor.setDataNascimento(LocalDate.of(1998,12,12));
        autor.setNacionalidade("Americano");

        Livro livro_01 = new Livro();
        livro_01.setIsbm("1336-11134");
        livro_01.setTitulo("Livro do arthur 01");
        livro_01.setDataPublicacao(LocalDate.of(2003, 1, 1));
        livro_01.setGenero(GeneroLivro.FICÇÃO);
        livro_01.setPreco(BigDecimal.valueOf(93.20));
        livro_01.setAutor(autor);

        Livro livro_02 = new Livro();
        livro_02.setIsbm("132336-1113234");
        livro_02.setTitulo("Livro do 02 do arthur");
        livro_02.setDataPublicacao(LocalDate.of(2007, 2, 20));
        livro_02.setGenero(GeneroLivro.BIOGRAFIA);
        livro_02.setPreco(BigDecimal.valueOf(120.20));
        livro_02.setAutor(autor);


        autor.setLivros(new ArrayList<>());
        autor.getLivros().add(livro_01);
        autor.getLivros().add(livro_02);

        autorRepository.save(autor);

        // CASCADE.ALL
        // livroRepository.saveAll(autor.getLivros());

    }

    @Test
    public void listarLivrosAutorTest(){
        var id = UUID.fromString("64c8310b-b38f-4ac4-8337-a1fb9df7274b");
        Autor autor = autorRepository.findById(id).get();

        livroRepository.findByAutor(autor).forEach(System.out::println);
    }

}

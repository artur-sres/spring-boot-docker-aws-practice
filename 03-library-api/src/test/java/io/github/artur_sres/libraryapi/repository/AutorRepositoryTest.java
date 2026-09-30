package io.github.artur_sres.libraryapi.repository;

import io.github.artur_sres.libraryapi.model.Autor;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.PublicKey;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    AutorRepository autorRepository;

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

}

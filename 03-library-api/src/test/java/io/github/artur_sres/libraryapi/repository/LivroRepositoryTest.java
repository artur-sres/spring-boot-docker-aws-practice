package io.github.artur_sres.libraryapi.repository;

import io.github.artur_sres.libraryapi.model.Autor;
import io.github.artur_sres.libraryapi.model.GeneroLivro;
import io.github.artur_sres.libraryapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@SpringBootTest
class LivroRepositoryTest {
    @Autowired
    LivroRepository livroRepository;

    @Autowired
    AutorRepository autorRepository;

    @Test
    public void salvarTest(){
        Livro livro = new Livro();

        livro.setIsbm("1234-1234");
        livro.setTitulo("TESTE3");
        livro.setDataPublicacao(LocalDate.of(1980, 1, 1));
        livro.setGenero(GeneroLivro.FICÇÃO);
        livro.setPreco(BigDecimal.valueOf(100));

//        Autor autor = autorRepository
//                .findById(UUID.fromString("488bf000-caa7-4150-865e-6401de3c9d04"))
//                .orElse(null);

        Autor autor = new Autor();
        autor.setNome("Antônio");
        autor.setNacionalidade("Brasileiro");
        autor.setDataNascimento(LocalDate.of(1989,10,11));

        livro.setAutor(autor);

        livroRepository.save(livro);

    }

    @Test
    @Transactional //Pode ser usado quando houver lazy initialization
    public void buscarLivroTest(){
        UUID id = UUID.fromString("66346554-03d8-417c-b8cf-ae1ed30d9a38");
        Livro livro = livroRepository.findById(id).orElse(null);

        if (livro == null){
            System.out.println("Livro com esse ID não encontrado!");
            return;
        }
        System.out.println(livro.getTitulo());
        System.out.println(livro.getGenero());
        System.out.println(livro.getPreco());
    }

    @Test
    public void listarTodosLivrosQueryMethod(){
        System.out.println(livroRepository.listarTodos());

    }

    @Test
    public void listarByGeneroTest(){
        System.out.println(livroRepository.findByGenero(
                GeneroLivro.BIOGRAFIA,
                Sort.by("dataPublicacao")
        ));
    }

    @Test
    public void deleteByGeneroTest(){
        livroRepository.deleteByGenero(GeneroLivro.BIOGRAFIA);
    }

}

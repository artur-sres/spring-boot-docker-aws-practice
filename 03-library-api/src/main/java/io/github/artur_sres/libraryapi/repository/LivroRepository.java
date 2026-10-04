package io.github.artur_sres.libraryapi.repository;

import io.github.artur_sres.libraryapi.model.Autor;
import io.github.artur_sres.libraryapi.model.GeneroLivro;
import io.github.artur_sres.libraryapi.model.Livro;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID> {
    List<Livro> findByAutor(Autor autor);

    @Query("select l from Livro as l order by l.titulo, l.preco")
    List<Livro> listarTodos();

    List<Livro> findByGenero(GeneroLivro genero, Sort sort);

    @Modifying
    @Transactional
    @Query("delete from Livro where genero = ?1")
    void deleteByGenero(GeneroLivro genero);
}

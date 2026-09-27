package io.github.artur_sres.produtosapi.repository;

import io.github.artur_sres.produtosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, String> {
    public List<Produto> findByNome(String nome);

}

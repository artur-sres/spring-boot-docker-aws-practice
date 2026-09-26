package io.github.artur_sres.produtosapi.controller;

import io.github.artur_sres.produtosapi.model.Produto;
import io.github.artur_sres.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
    ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvar(Produto produto){
        produto.setId(UUID.randomUUID().toString());
        produtoRepository.save(produto);
        return produto;
    }
}

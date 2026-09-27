package io.github.artur_sres.produtosapi.controller;

import io.github.artur_sres.produtosapi.model.Produto;
import io.github.artur_sres.produtosapi.repository.ProdutoRepository;
import jakarta.persistence.GeneratedValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {
    ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        produto.setId(UUID.randomUUID().toString());
        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping("/{id}")
    public Produto obterPorId(@PathVariable("id") String id) {
        return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") String id) {
        produtoRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Produto editar(@PathVariable("id") String id,
                          @RequestBody Produto produto) {
        produto.setId(id);
        return produtoRepository.save(produto);

        // ciente de que ele cria um produto novo caso não exista um com aquele id
    }

    @GetMapping
    public List<Produto> buscar(@RequestParam("nome") String nome) {
        return produtoRepository.findByNome(nome);
    }

}

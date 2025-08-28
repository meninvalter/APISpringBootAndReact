package com.api.produtos_api.controller;

import com.api.produtos_api.model.Produto;
import com.api.produtos_api.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Produto> listar() { return service.listar(); }

    @PostMapping
    public Produto criar(@RequestBody Produto produto) { return service.salvar(produto); }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id) { return service.buscarPorId(id); }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto) {
        Produto existente = service.buscarPorId(id);
        existente.setNome(produto.getNome());
        existente.setPreco(produto.getPreco());
        existente.setQuantidade(produto.getQuantidade());
        return service.salvar(existente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) { service.deletar(id); }
}

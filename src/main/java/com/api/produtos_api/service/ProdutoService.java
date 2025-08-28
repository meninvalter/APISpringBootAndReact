package com.api.produtos_api.service;

import com.api.produtos_api.model.Produto;
import com.api.produtos_api.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> listar() { return repository.findAll(); }
    public Produto salvar(Produto produto) { return repository.save(produto); }
    public Produto buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }
    public void deletar(Long id) { repository.deleteById(id); }
}

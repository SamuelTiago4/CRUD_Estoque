package br.edu.aesa.service;

import br.edu.aesa.model.Produto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProdutoService {

    private Map<Integer, Produto> produtos;

    public ProdutoService() {
        produtos = new HashMap<>();
    }

    // CREATE
    public boolean cadastrar(Produto produto) {

        if (produto == null) {
            return false;
        }

        if (produto.getId() <= 0) {
            return false;
        }

        if (produtos.containsKey(produto.getId())) {
            return false;
        }

        produtos.put(produto.getId(), produto);

        return true;
    }

    // READ - Buscar por ID
    public Produto buscarPorId(int id) {
        return produtos.get(id);
    }

    // READ - Listar todos
    public List<Produto> listarTodos() {
        return new ArrayList<>(produtos.values());
    }

    // UPDATE
    public boolean atualizar(int id, String nome, String categoria,
                             double preco, int quantidade) {

        Produto produto = produtos.get(id);

        if (produto == null) {
            return false;
        }

        produto.setNome(nome);
        produto.setCategoria(categoria);
        produto.setPreco(preco);
        produto.setQuantidade(quantidade);

        return true;
    }

    // DELETE
    public boolean remover(int id) {

        if (!produtos.containsKey(id)) {
            return false;
        }

        produtos.remove(id);

        return true;
    }
}
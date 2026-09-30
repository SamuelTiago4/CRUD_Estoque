package br.edu.aesa.app;

import br.edu.aesa.model.Produto;
import br.edu.aesa.service.ProdutoService;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ProdutoService service = new ProdutoService();

        int opcao;

        do {

            System.out.println("\n==============================");
            System.out.println("     CONTROLE DE ESTOQUE");
            System.out.println("==============================");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Buscar produto por ID");
            System.out.println("4 - Atualizar produto");
            System.out.println("5 - Remover produto");
            System.out.println("0 - Sair");
            System.out.println("==============================");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:

                    System.out.println("\n--- CADASTRAR PRODUTO ---");

                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Categoria: ");
                    String categoria = scanner.nextLine();

                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();

                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine();

                    if (preco < 0 || quantidade < 0) {
                        System.out.println("Erro: preço e quantidade não podem ser negativos.");
                        break;
                    }

                    Produto produto = new Produto(
                            id,
                            nome,
                            categoria,
                            preco,
                            quantidade
                    );

                    if (service.cadastrar(produto)) {
                        System.out.println("Produto cadastrado com sucesso!");
                    } else {
                        System.out.println("Erro: não foi possível cadastrar.");
                        System.out.println("Verifique se o ID já existe ou é inválido.");
                    }

                    break;

                case 2:

                    System.out.println("\n--- LISTA DE PRODUTOS ---");

                    List<Produto> produtos = service.listarTodos();

                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                    } else {
                        for (Produto p : produtos) {
                            System.out.println(p);
                        }
                    }

                    break;

                case 3:

                    System.out.println("\n--- BUSCAR PRODUTO ---");

                    System.out.print("Digite o ID: ");
                    int idBusca = scanner.nextInt();
                    scanner.nextLine();

                    Produto encontrado = service.buscarPorId(idBusca);

                    if (encontrado != null) {
                        System.out.println("Produto encontrado:");
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Nenhum produto encontrado com o ID informado.");
                    }

                    break;

                case 4:

                    System.out.println("\n--- ATUALIZAR PRODUTO ---");

                    System.out.print("Digite o ID do produto: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine();

                    Produto produtoAtual = service.buscarPorId(idAtualizar);

                    if (produtoAtual == null) {
                        System.out.println("Nenhum produto encontrado com esse ID.");
                        break;
                    }

                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();

                    System.out.print("Nova categoria: ");
                    String novaCategoria = scanner.nextLine();

                    System.out.print("Novo preço: ");
                    double novoPreco = scanner.nextDouble();

                    System.out.print("Nova quantidade: ");
                    int novaQuantidade = scanner.nextInt();
                    scanner.nextLine();

                    if (novoPreco < 0 || novaQuantidade < 0) {
                        System.out.println("Erro: preço e quantidade não podem ser negativos.");
                        break;
                    }

                    if (service.atualizar(
                            idAtualizar,
                            novoNome,
                            novaCategoria,
                            novoPreco,
                            novaQuantidade)) {

                        System.out.println("Produto atualizado com sucesso!");

                    } else {
                        System.out.println("Não foi possível atualizar o produto.");
                    }

                    break;

                case 5:

                    System.out.println("\n--- REMOVER PRODUTO ---");

                    System.out.print("Digite o ID do produto: ");
                    int idRemover = scanner.nextInt();
                    scanner.nextLine();

                    if (service.remover(idRemover)) {
                        System.out.println("Produto removido com sucesso!");
                    } else {
                        System.out.println("Nenhum produto encontrado com esse ID.");
                    }

                    break;

                case 0:

                    System.out.println("\nPrograma encerrado.");
                    break;

                default:

                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}

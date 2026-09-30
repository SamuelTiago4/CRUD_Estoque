OBS: link do vídeo está no final, obrigado.

# 📦 Controle de Estoque

Projeto desenvolvido para o desafio prático de Estruturas de Dados em Java. O aplicativo permite cadastrar, listar, buscar, atualizar e remover produtos através de um menu no terminal.

## 🎯 Objetivo

O objetivo do projeto é colocar em prática os conhecimentos de estruturas de dados e CRUD em Java.

Foi escolhido o tema de um **Sistema de Controle de Estoque**, onde cada produto possui um ID, nome, categoria, preço e quantidade.

## 🛠️ Tecnologias utilizadas

* Java
* Scanner
* HashMap
* ArrayList
* IntelliJ IDEA
* Git
* GitHub

## 📦 Estrutura de Dados

Para armazenar os produtos foi utilizado o **HashMap**.

```java
Map<Integer, Produto> produtos = new HashMap<>();
```

O `Integer` representa o ID do produto e o `Produto` representa os dados cadastrados.

O ID foi escolhido como identificador porque cada produto possui um código próprio e o sistema utiliza esse ID para realizar as operações de busca, atualização e remoção.

Também existe uma validação para evitar o cadastro de dois produtos com o mesmo ID.

### Por que HashMap?

Escolhi o `HashMap` porque ele facilita a busca dos produtos através de uma chave.

Como o ID é utilizado como chave, é possível encontrar, atualizar e remover um produto de forma rápida.

As principais complexidades médias são:

* Cadastro: O(1)
* Busca: O(1)
* Atualização: O(1)
* Remoção: O(1)
* Listagem: O(n)

O consumo de memória é O(n), pois depende da quantidade de produtos cadastrados.

Uma desvantagem é que o `HashMap` não mantém os registros necessariamente na ordem em que foram cadastrados.

---

# 🔄 Operações CRUD

O sistema possui as quatro operações principais do CRUD:

## Create - Cadastrar

Permite cadastrar um novo produto informando:

* ID
* Nome
* Categoria
* Preço
* Quantidade

O sistema verifica se:

* O produto não é nulo.
* O ID é maior que zero.
* O ID ainda não está cadastrado.

Caso todas as condições sejam atendidas, o produto é armazenado no `HashMap`.

---

## Read - Consultar

É possível:

* Listar todos os produtos cadastrados.
* Buscar um produto através do ID.

Na busca por ID, caso o produto seja encontrado, suas informações são apresentadas no terminal.

Caso o ID não seja encontrado, o sistema informa ao usuário que nenhum produto foi localizado.

---

## Update - Atualizar

Permite informar o ID de um produto já cadastrado e alterar seus dados:

* Nome
* Categoria
* Preço
* Quantidade

O ID do produto permanece o mesmo.

Se o ID não existir, o sistema informa que nenhum produto foi encontrado.

---

## Delete - Remover

Permite remover um produto através do seu ID.

Caso o ID exista, o produto é removido do `HashMap`.

Caso o ID não exista, o sistema informa ao usuário que nenhum produto foi encontrado.

---

# 📦 Modelo Produto

A classe `Produto` representa os produtos cadastrados no sistema.

Ela possui os seguintes atributos:

* `id`
* `nome`
* `categoria`
* `preco`
* `quantidade`

A classe também possui:

* Construtor
* Getters
* Setters
* Método `toString()`

O método `toString()` é utilizado para apresentar as informações do produto de forma organizada no terminal.

Exemplo:

```text
ID: 1 | Nome: Notebook | Categoria: Informática | Preço: R$ 2500,00 | Quantidade: 10
```

---

# ⚙️ ProdutoService

A classe `ProdutoService` é responsável pelas operações do CRUD.

Ela possui um `HashMap` para armazenar os produtos:

```java
private Map<Integer, Produto> produtos;
```

Os principais métodos são:

```text
cadastrar()
buscarPorId()
listarTodos()
atualizar()
remover()
```

Dessa forma, a parte responsável pelo CRUD fica separada da classe principal.

Isso ajuda a deixar o código mais organizado e separar as responsabilidades de cada classe.

---

# 🖥️ Main

A classe `Main` é responsável por executar o programa e apresentar o menu para o usuário.

O menu possui as opções:

```text
1 - Cadastrar produto
2 - Listar produtos
3 - Buscar produto por ID
4 - Atualizar produto
5 - Remover produto
0 - Sair
```

O sistema utiliza `Scanner` para receber as informações digitadas pelo usuário.

A classe `Main` também controla as opções escolhidas através de uma estrutura `switch`.

---

# ✅ Validações

O sistema possui algumas validações para evitar entradas incorretas.

Entre elas:

* Não permite cadastrar um produto com ID menor ou igual a zero.
* Não permite cadastrar dois produtos com o mesmo ID.
* Não permite preço negativo.
* Não permite quantidade negativa.
* Informa quando um produto não é encontrado.
* Informa quando não existem produtos cadastrados.
* Informa quando uma opção inválida é escolhida.
* Informa quando não foi possível cadastrar ou atualizar um produto.

---

# 📁 Organização das pastas

O projeto foi organizado em pacotes para separar as responsabilidades:

```text
ControleEstoque/
├── README.md
└── src/
    └── br/
        └── edu/
            └── aesa/
                ├── app/
                │   └── Main.java
                │
                ├── service/
                │   └── ProdutoService.java
                │
                └── model/
                    └── Produto.java
```

### app

Contém a classe `Main`, que executa o programa e apresenta o menu para o usuário.

### service

Contém a classe `ProdutoService`, responsável pelas operações do CRUD e pelo gerenciamento do `HashMap`.

### model

Contém a classe `Produto`, que representa os produtos cadastrados no sistema.

---

# ▶️ Como executar

Para executar o projeto é necessário ter o **Java** instalado.

Depois de abrir o projeto na IDE, execute a classe:

```text
Main.java
```

O programa será iniciado no terminal e apresentará o menu de opções.

---

# 🎥 Demonstração em vídeo

No vídeo será apresentada a aplicação funcionando e serão demonstradas as principais operações do sistema.

Entre elas:

* Cadastro de pelo menos 3 produtos.
* Listagem dos produtos.
* Busca de um produto existente pelo ID.
* Busca de um ID que não existe.
* Atualização de um produto.
* Remoção de um produto.
* Listagem após a alteração e remoção.
* Encerramento do programa.

🔗 **Link da Apresentação em Vídeo:**

https://youtu.be/954dVfE1jew


# 📌 Conclusão

Esse projeto foi desenvolvido para praticar o uso de estruturas de dados em Java e entender melhor como funciona um CRUD.

A utilização do `HashMap` facilitou o armazenamento dos produtos e principalmente as operações que utilizam o ID como identificador.

Também foi possível praticar conceitos de **Programação Orientada a Objetos**, utilização de **estruturas de dados**, organização do código em diferentes pacotes e desenvolvimento de uma aplicação através do terminal.

O projeto permitiu aplicar na prática as operações de **Cadastrar, Consultar, Atualizar e Remover**, tornando mais fácil compreender o funcionamento de um sistema CRUD utilizando Java.
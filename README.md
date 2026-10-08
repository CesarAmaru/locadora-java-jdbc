# locadora-java-jdbc

Projeto em Java desenvolvido para aplicar conceitos fundamentais de Programação Orientada a Objetos (Herança, Polimorfismo, Encapsulamento) e persistência de dados relacional com JDBC (Java Database Connectivity) através do padrão de projeto DAO (Data Access Object).

---

## Tecnologias Utilizadas

* **Linguagem:** Java 25 (LTS)
* **Banco de Dados:** MySQL (Server / Workbench)

---

## Dependências

* **MySQL Connector/J:** Driver JDBC para conexão com o banco MySQL (`mysql-connector-j-x.x.x.jar`).

---

## Estrutura de Pastas

```text
locadora-veiculos-java/
├── lib/      # Driver JDBC (mysql-connector-j.jar)
├── sql/
│   └── DDL.sql # arquivo para criar banco de dados no padrão do projeto
├── src/
│   └── br/
│       └── treino/
│           ├── DAO/      # Camada de Acesso a Dados
│           │   ├── entities/        
│           │   │   ├── InterfaceDAO.java    # Interfaces dos DAOs
│           │   │ 
│           │   ├── ClienteDAO.java  # Implementação JDBC do Cliente
│           │   ├── DAO.java         # Conexão e métodos utilitários
│           │   └── VeiculoDAO.java  # Implementação JDBC de Veículos
│           │
│           ├── entities/            # Camada de Modelo / Entidades
│           │   ├── Carro.java
│           │   ├── Cliente.java
│           │   ├── Moto.java
│           │   └── Veiculo.java
│           │
│           └── view/                # Interface com o Usuário / Execução
│               └── Tela.java
│
├── .gitignore
├── config.properties        # Modelo para arquivo de configurações
└── README.md
```

---
## Configuração `config.properties`

É no arquivo `config.properties` que ficarão salvos os dados de acesso ao banco de dados (url, user e senha).

### Criar o arquivo `config.properties`

Crie um arquivo chamado **`config.properties`** na **raiz do projeto** (no mesmo nível da pasta `src/`).

### Passo 2: Adicionar as credenciais do banco

Insira o seguinte conteúdo com as suas configurações locais do MySQL:

```properties
db.url=jdbc:mysql://caminho/nome_banco_de_dados
db.user=seu_usuario
db.password=sua_senha

```

---

## ⚙️ Funcionalidades do Banco (Operações CRUD)

A camada DAO suporta as seguintes operações de persistência:

1. **Inserir (`salvar`)**: Persiste novos registros no banco de dados. No caso dos veículos, aplica a estratégia *Single Table Inheritance* tratando as especificidades de `Carro` e `Moto`.
2. **Busca por ID (`buscarPorID`)**: Consulta e retorna uma entidade única com base na sua chave primária (`id`).
3. **Busca Completa (`listarTodos`)**: Recupera todos os registros cadastrados, remontando objetos polimórficos de forma dinâmica na memória.
4. **Excluir (`deletar`)**: Remove do banco de dados o registro associado ao objeto informado.
5. **Update (`update`)**: Atualiza os dados no banco de dados o registro associado ao objeto informado.


# Análise de Frameworks e APIs para Gerenciamento de Dados

**Nome:** Matheus Brito Chaves  
**RA:** 926109965  
**Disciplina:** Arquitetura de Software  
**Curso:** Análise e Desenvolvimento de Sistemas - Uninove  

---

## 1. Necessidade de Persistência Eficiente
A principal função de um sistema corporativo é armazenar e gerenciar dados de forma duradoura. Implementações temporárias em memória (como listas em Java) perdem todas as informações assim que a aplicação é reiniciada.

Para garantir durabilidade e alto desempenho, utiliza-se um **SGBD (Sistema de Gerenciamento de Banco de Dados)**. Historicamente, cerca de 80% do mercado adota o modelo relacional (SQL), enquanto 20% utiliza outros modelos (como NoSQL).

---

## 2. A Evolução: ODBC, JDBC e Conectividade
- **ODBC (Open DataBase Connectivity):** Criado entre os anos 1970 e 1990, foi o primeiro padrão a separar o código da aplicação das especificidades do SGBD.
- **JDBC (Java DataBase Connectivity):** Abstração nativa do Java para execução de comandos SQL em bancos relacionais através de drivers específicos.

---

## 3. Diferença entre Framework vs. API de Persistência

Segundo a literatura da disciplina, a camada de persistência pode ser entregue de duas formas:

| Característica | Framework de Persistência | API de Persistência |
| :--- | :--- | :--- |
| **Definição** | Estrutura que determina como a camada de dados funciona, mantendo certo controle com o desenvolvedor. | Componentes estruturados onde a própria API executa o trabalho sem o programador interferir internamente. |
| **Controle de Fluxo** | O framework orquestra as chamadas SQL e o ciclo de vida dos objetos. | O programador faz chamadas diretas às rotinas da API. |
| **Exemplo no ecossistema Java** | **Spring Data JPA** / Hibernate | **JPA (Jakarta Persistence API)** puro |

---

## 4. O Desafio do Mapeamento Objeto-Relacional (ORM)
Existe um descompasso (*impedance mismatch*) entre a orientação a objetos e o modelo relacional de banco de dados:
- **Modelo Relacional:** Organizado em tabelas, linhas, colunas, chaves primárias (`PK`) e chaves estrangeiras (`FK`).
- **Modelo Orientado a Objetos:** Organizado em objetos, atributos, referências em memória e herança.

O **ORM (Object-Relational Mapping)** resolve essa diferença ao mapear automaticamente classes Java para tabelas do banco de dados, convertendo comandos em código orientado a objetos diretamente em instruções SQL (`SELECT`, `INSERT`, `UPDATE`, `DELETE`).

---

## 5. Padrão de Projeto Repository (Repository Pattern)
O **Repository Pattern** isola completamente a lógica de acesso a dados da camada de negócio (`Service`). A interface `PedidoRepository` estabelece o contrato, permitindo alternar facilmente a implementação de persistência (como trocar `PedidoRepositoryEmMemoria` por uma implementação física em banco de dados como `PedidoRepositoryJdbc`) sem precisar alterar nenhuma regra de negócio do sistema.
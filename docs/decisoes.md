# Registro de Decisões Arquiteturais - Rota Sul

- **Aluno:** Matheus Brito Chaves
- **RA:** 926109965
- **Disciplina:** Arquitetura de Software (Uninove 2026.2)
- **Aula:** 02 - Padrões de Projeto e Frameworks

---

## 1. Mapeamento de Frameworks
Decisões de reuso de infraestrutura e controle aplicadas ao projeto Rota Sul:

| Framework / Biblioteca | Papel na Arquitetura | Responsabilidade no Sistema Rota Sul |
|---|---|---|
| **Spring Boot 3.3.4** | Framework Base | Prover a estrutura da aplicação, Inversão de Controle (IoC) e servidor embutido (Tomcat). |
| **Spring Data JPA / Hibernate** | Framework de Persistência | Mapeamento Objeto-Relacional (ORM) para integrar com o banco de dados MySQL. |
| **Spring Web (MVC)** | Framework Web | Gerenciar requisições HTTP e roteamento para os serviços de pedidos e rastreamento. |

---

## 2. Mapeamento de Padrões de Projeto (Design Patterns)
Padrões conceituais adotados na modelagem do case Rota Sul:

| Padrão (Pattern) | Categoria | Aplicação Prática no Case Rota Sul |
|---|---|---|
| **MVC (Model-View-Controller)** | Arquitetural | Separação entre a camada visual (Thymeleaf), regra de negócio e modelo de dados. |
| **Repository Pattern** | Comportamental / Acesso a Dados | Abstração do acesso aos dados de entidades como `Pedido`, `Remessa` e `Volume`. |
| **Inversion of Control (IoC) / Dependency Injection** | Criação / Estrutural | O container do Spring gerencia o ciclo de vida e a injeção das instâncias de serviço. |
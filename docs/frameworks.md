# Análise de Frameworks, Inversão de Controle (IoC) e Containers

**Nome:** Matheus Brito Chaves  
**RA:** 926109965  
**Disciplina:** Arquitetura de Software  
**Curso:** Análise e Desenvolvimento de Sistemas - Uninove  

---

## 1. O que é um Framework?
Diferente de uma simples biblioteca, um **framework** é uma estrutura parcial reutilizável que dita a arquitetura e o fluxo de execução do sistema. Enquanto em uma biblioteca o nosso programa chama as funções ativamente, no framework é ele quem assume o controle e chama o nosso código quando necessário.

---

## 2. Inversão de Controle (IoC - Inversion of Control)
A **Inversão de Controle** é o princípio arquitetural onde a responsabilidade de instanciar objetos, gerenciar dependências e controlar o fluxo de execução deixa de ser do programador e passa a ser do framework.

- **Conceito "Hollywood":** *"Não nos chame, nós chamaremos você"*.
- **Na prática na Rota Sul:** Nenhuma classe do nosso projeto usa o operador `new` para instanciar serviços como `PedidoService`. O Spring detecta as anotações (`@Service`, `@Component`) e cria as instâncias sozinho.

---

## 3. Injeção de Dependências e o Container IoC
O Spring funciona através de um container IoC (`ApplicationContext`), que gerencia o ciclo de vida dos componentes chamados de **Beans**.

A configuração dessas dependências pode ser feita de duas formas:
1. **Configuração Implícita (Anotações):** Uso de anotações como `@Service`, `@Repository` e `@Autowired` para descoberta automática de componentes via escaneamento de pacotes (*component scan*).
2. **Configuração Explícita (Java Config):** Classes anotadas com `@Configuration` que possuem métodos anotados com `@Bean`, permitindo controle total sobre a instanciação de objetos complexos ou de terceiros.

---

## 4. Gerenciamento de Componentes por Perfil (`@Profile`)
Através da anotação `@Profile`, o container IoC consegue ativar e injetar beans diferentes com base no ambiente ou na regra de negócio configurada (ex: `spring.profiles.active=padrao` vs `spring.profiles.active=risco`). Isso permite mudar o comportamento completo da aplicação no arquivo `application.properties` sem precisar alterar nenhuma linha de código Java.

---

## 5. Vantagens e Desvantagens

| Vantagens | Desvantagens |
| :--- | :--- |
| **Aumento de produtividade:** Não é preciso reescrever infraestrutura básica (servidor web, segurança, banco). | **Curva de aprendizado:** Exige aprender a lógica e as convenções específicas do framework. |
| **Baixo acoplamento:** Facilita testes unitários e manutenção via Injeção de Dependência. | **Overhead de tamanho:** Adiciona dependências e tamanho ao pacote final da aplicação. |
| **Garantia de padrões:** Força a equipe a seguir uma arquitetura organizada e padronizada. | **Lock-in / Engessamento:** O código fica fortemente acoplado à estrutura do framework escolhido. |
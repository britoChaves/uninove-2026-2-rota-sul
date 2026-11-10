# Análise de Design Patterns (Padrões de Projeto)

**Nome:** Matheus Brito Chaves  
**RA:** 926109965  
**Disciplina:** Arquitetura de Software  
**Curso:** Análise e Desenvolvimento de Sistemas - Uninove  

---

## 1. O que são Design Patterns?
Design Patterns (Padrões de Projeto) são soluções reutilizáveis e testadas para problemas recorrentes que encontramos no desenvolvimento de software orientado a objetos.

A ideia principal é não precisar "reinventar a roda" a cada novo sistema. Em vez de simplesmente sair programando e depois tentar consertar a estrutura ("fazer para depois pensar"), a gente usa padrões consolidados para deixar o código mais fácil de manter, testar e evoluir.

---

## 2. Padrão de Projeto vs. Framework
É muito comum confundir esses dois conceitos, mas a diferença básica é:

- **Padrão de Projeto:** É um conceito ou modelo abstrato (uma receita/orientação de como organizar as classes). Ex: *Strategy*, *Factory Method*, *MVC*.
- **Framework:** É um conjunto de código pronto e bibliotecas executáveis que nos dá uma estrutura concreta para trabalhar. Ex: *Spring Boot*, *Hibernate*.

---

## 3. O Padrão MVC (Model-View-Controller)
Surgido em meados dos anos 1970, o MVC separa a aplicação em três camadas independentes:

1. **Model:** Contém as regras de negócio e a representação dos dados (no nosso projeto, as entidades e serviços como `Pedido` e `PedidoService`).
2. **View:** É a camada de apresentação que interage com o usuário (telas HTML, interfaces de usuário ou respostas formatadas).
3. **Controller:** Faz a ponte entre a View e o Model, recebendo as requisições e definindo para onde o fluxo de dados deve ir (como o `PedidoController`).

Essa divisão garante que alterar uma regra de banco de dados ou de negócio não quebre a interface do usuário.

---

## 4. As Três Famílias do Catálogo GoF (Gang of Four)
Os 23 padrões clássicos definidos pelo livro da "Gangue dos Quatro" são divididos em 3 categorias:

1. **Criacionais (Creational):** Lidam com a forma como os objetos são criados, escondendo a lógica de instanciação. 
   - *Exemplo aplicado na aula:* **Factory Method** (usado para criar instâncias de `Ocorrencia` sem acoplar a criação diretamente no código principal).
2. **Estruturais (Structural):** Tratam de como classes e objetos se compõem para formar estruturas maiores.
   - *Exemplo:* **Adapter**, **Decorator**.
3. **Comportamentais (Behavioral):** Tratam da comunicação e da atribuição de responsabilidades entre os objetos.
   - *Exemplo aplicado na aula:* **Strategy** (usado no cálculo de frete da Rota Sul, permitindo alternar algoritmos de cálculo de forma simples sem lotar o código de `if/else`).
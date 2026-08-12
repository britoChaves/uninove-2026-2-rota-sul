# Rota Sul, repositório-esqueleto

Case integrador da disciplina **Arquitetura de Software**, curso de graduação
da Universidade Nove de Julho (Uninove), semestre 2026.2, Prof. José Romualdo.

A Rota Sul é uma transportadora de médio porte que opera com pedidos de
lojistas, um armazém que monta remessas, frota própria na rota principal e
transportadoras parceiras na última milha. Hoje essas quatro peças se integram
por planilha e telefone, e o resultado é pedido duplicado, remessa sem rastreio
e cliente sem visibilidade. O semestre inteiro consiste em resolver isso em
código, uma decisão de arquitetura por vez.

Este repositório é o ponto de partida. Ele sobe, não faz nada, e é assim de
propósito: o primeiro código de aplicação entra na Aula 06.

## Como usar

Este é o **único** repositório do semestre. Você faz **um** fork, na Aula 01, e
ele evolui semana a semana até a Aula 20. Não existe repositório de laboratório
por aula: o entregável de uma aula é o ponto de partida da seguinte, e é o
histórico de commits do seu fork que o professor avalia.

1. Clique em **Fork**, no alto desta página, e crie o fork na sua conta
   pessoal do GitHub.
2. Clone **o seu fork**, não este repositório:

   ```bash
   git clone https://github.com/SEU_USUARIO/uninove-2026-2-rota-sul.git
   cd uninove-2026-2-rota-sul
   git remote -v
   ```

   Confira que `origin` aponta para a sua conta. Clonar o repositório original
   em vez do fork é o erro mais comum deste passo, e só aparece na hora do
   primeiro push, quando o GitHub nega a escrita.

3. Suba a aplicação:

   ```bash
   ./mvnw spring-boot:run
   ```

   A primeira execução baixa as dependências e demora. Ao final, o log imprime
   a linha com a porta em que a aplicação subiu. Abra **essa** porta no
   navegador: a resposta esperada é a página de erro padrão do Spring Boot, e
   isso é sucesso, porque ainda não existe nenhuma rota mapeada.

Mantenha o fork **público**. Os diagramas UML das Aulas 04 e 05 são renderizados
pelo proxy do `plantuml.com`, que lê o arquivo `.puml` direto do `raw` do seu
repositório; fork privado quebra a imagem.

## Estrutura

```
uninove-2026-2-rota-sul/
├── docs/                    entregáveis das aulas, começando pelo docs/ambiente.md da Aula 01
├── pom.xml                  Java 21, Spring Boot 3.3.4, artefato br.uni9:rota-sul
├── mvnw, mvnw.cmd           wrapper do Maven, use sempre este e não o mvn do sistema
├── .gitignore               já lista .env
└── src/
    ├── main/java/br/uni9/rotasul/RotaSulApplication.java
    └── main/resources/application.properties
```

## Contrato técnico

Fixado desde o fork da Aula 01 e válido até a Aula 20. Nenhuma aula inventa
nome fora deste contrato.

| Item | Valor |
|---|---|
| Linguagem | Java 21 LTS |
| Build | Maven, pelo `./mvnw` do próprio repositório |
| Framework | Spring Boot 3.3.4 |
| Pacote raiz | `br.uni9.rotasul` |
| Convenção de pacotes | `br.uni9.rotasul.<contexto>.<camada>`, com os contextos `pedido`, `expedicao` e `rastreamento`, e as camadas `web`, `service`, `repository` e `domain` |
| Persistência | MySQL 8.4 no schema `rotasul`, com Flyway e Spring Data JPA sobre Hibernate, a partir do Módulo 4 |
| Interface web | Thymeleaf, a partir da Aula 13 |
| Documentação de API | springdoc-openapi |
| Integração SOAP | Spring Web Services, no contexto do parceiro |
| Testes | JUnit 5 e Testcontainers |
| Distribuição | Docker Compose em GitHub Codespaces, no fim do semestre |

## Duas regras de código, válidas em todas as aulas

- **Nunca fixe uma porta de `localhost` como se fosse universal.** Use sempre a
  porta que o seu terminal imprimiu.
- **Senha e segredo vão para variável de ambiente**, nunca para o repositório.
  O `.env` já está no `.gitignore` e deve continuar lá.

## Entidades e atores do case

**Atores:** lojista, expedidor, motorista, atendente e transportadora parceira.

**Entidades:** `Cliente`, `Pedido`, `Remessa`, `Volume`, `Rota`, `Veiculo`,
`Motorista`, `Ocorrencia`, `Parceiro`.

Esses nomes valem o semestre inteiro e não mudam.

## Material da disciplina

Os decks e os kits de laboratório de cada aula ficam no portal do acervo:

<https://josercf.github.io/uninove-2026-2-arquitetura-software/>

---

Copyright Prof. José Romualdo. Material didático da disciplina Arquitetura de
Software, Uninove, 2026.2.

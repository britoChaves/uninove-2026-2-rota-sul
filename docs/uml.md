# Representação Arquitetural em UML - Rota Sul

- **Aluno:** Matheus Brito Chaves
- **RA:** 926109965
- **Disciplina:** Arquitetura de Software (Uninove 2026.2)
- **Aula:** 05 - Arquitetura de Software e Representação em UML

---

## 1. Fundamentação Teórica da UML
- **Origem:** Surgiu do método de Análise Orientada a Objetos proposto por Ivar Jacobson, Grady Booch e James Rumbaugh ("Os Três Amigos"), padronizado e mantido pelo OMG (Object Management Group).
- **Problema Central Atendido:** Prover uma linguagem padronizada para documentar a estrutura do software e medir o impacto que mudanças causam no sistema existente.

---

## 2. Os 5 Diagramas UML de Arquitetura de Software

| Diagrama | Tipo | Pergunta Principal que Responde |
|---|---|---|
| **Casos de Uso** | Comportamental | Quais atores interagem com o sistema e quais funcionalidades utilizam? |
| **Componentes** | Estrutural | Como o software é dividido em módulos e quais interfaces expõe? |
| **Implantação (Deployment)** | Estrutural | Em quais nós de hardware/servidores o software é executado? |
| **Classes do Domínio** | Estrutural | Quais são as entidades do negócio, seus atributos e multiplicidades? |
| **Pacotes** | Estrutural | Como o código está organizado em namespaces, módulos e camadas? |

---

## 3. Diagrama de Classes do Domínio (PlantUML)

Contrato oficial com as 9 entidades da Rota Sul:

```plantuml
@startuml
skinparam classAttributeIconSize 0

class Cliente {
  - id : Long
  - nome : String
  - cnpj : String
}

class Pedido {
  - id : Long
  - dataCriacao : LocalDateTime
  - valorTotal : BigDecimal
  - status : String
}

class Remessa {
  - id : Long
  - codigoRastreio : String
  - dataEnvio : LocalDateTime
}

class Volume {
  - id : Long
  - pesoKg : Double
  - dimensoes : String
}

class Rota {
  - id : Long
  - origem : String
  - destino : String
}

class Veiculo {
  - id : Long
  - placa : String
  - modelo : String
}

class Motorista {
  - id : Long
  - nome : String
  - cnh : String
}

class Ocorrencia {
  - id : Long
  - descricao : String
  - dataHora : LocalDateTime
}

class Parceiro {
  - id : Long
  - nomeFantasia : String
  - apiEndpoint : String
}

Cliente "1" -- "0..*" Pedido : realiza >
Pedido "1" -- "1..*" Remessa : gera >
Remessa "1" -- "1..*" Volume : contem >
Remessa "0..*" -- "1" Rota : segue >
Rota "0..*" -- "1" Veiculo : aloca >
Veiculo "0..*" -- "1" Motorista : conduz >
Remessa "1" -- "0..*" Ocorrencia : registra >
Remessa "0..*" -- "0..1" Parceiro : repassa >

@enduml

@startuml
package "br.uni9.rotasul" {
  
  package "pedido" {
    package "pedido.web" {}
    package "pedido.service" {}
    package "pedido.repository" {}
    package "pedido.domain" {}
  }
  
  package "expedicao" {
    package "expedicao.web" {}
    package "expedicao.service" {}
    package "expedicao.repository" {}
    package "expedicao.domain" {}
  }
  
  package "rastreamento" {
    package "rastreamento.web" {}
    package "rastreamento.service" {}
    package "rastreamento.repository" {}
    package "rastreamento.domain" {}
  }

}

pedido.web ..> pedido.service
pedido.service ..> pedido.repository
pedido.service ..> pedido.domain
pedido.repository ..> pedido.domain

@enduml
# Comparativo de Objetos Remotos: RMI, SOAP e REST

**Nome:** Matheus Brito Chaves  
**RA:** 926109965  
**Disciplina:** Arquitetura de Software  
**Curso:** Análise e Desenvolvimento de Sistemas - Uninove  

---

## 1. RMI (Remote Method Invocation)
O RMI é o modelo clássico do Java para chamada de procedimentos remotos (RPC). A ideia dele é fazer um método rodar em outra máquina na rede como se estivesse rodando localmente na mesma aplicação.

- **Como funciona:** O cliente chama uma interface Java e o RMI cuida da comunicação pela rede com a JVM do servidor.
- **Pontos Fortes:** Muito fácil de usar dentro do ecossistema Java, porque a sintaxe é idêntica à de uma classe comum.
- **Pontos Fracos:** Funciona apenas entre aplicações Java (pouca interoperabilidade). Além disso, qualquer instabilidade de rede exige tratamento pesado de exceções (`RemoteException`).

---

## 2. SOAP (Simple Object Access Protocol)
O SOAP veio para resolver a integração entre tecnologias diferentes (ex: Java falando com C# ou PHP). Ele é um padrão corporativo bem rígido baseado em mensagens XML.

- **Como funciona:** As requisições e respostas são envelopadas dentro de uma estrutura fixa XML (`Envelope`, `Header`, `Body` e `Fault`). O contrato do serviço é descrito formalmente por um arquivo chamado WSDL.
- **Pontos Fortes:** Altamente padronizado e seguro. Muito utilizado em sistemas legados, bancos e integrações corporativas pesadas (como o Web Service dos Correios).
- **Pontos Fracos:** Bastante verboso. O tamanho das mensagens em bytes é alto por causa do "envelope" XML, o que deixa o tráfego e o processamento mais lentos.

---

## 3. REST (Representational State Transfer)
Diferente do SOAP, o REST não é um protocolo engessado, mas sim um estilo arquitetural que aproveita diretamente o funcionamento nativo da Web (HTTP).

- **Como funciona:** Usa os verbos HTTP (`GET`, `POST`, `PUT`, `DELETE`) para manipular recursos (como `/pedidos` ou `/remessas`). Os dados trafegam de forma leve, usando JSON ou XML simples.
- **Pontos Fortes:** Muito mais leve e rápido que o SOAP. É a escolha padrão para APIs modernas, sistemas web e aplicativos móveis.
- **Pontos Fracos:** Não exige um contrato formal rígido nativo (como o WSDL do SOAP), dependendo de documentações externas como OpenAPI/Swagger.

---

## Resumo Comparativo

| Característica | RMI | SOAP | REST |
| :--- | :--- | :--- | :--- |
| **Protocolo Base** | JRMP / TCP | HTTP, SMTP, etc. | HTTP |
| **Formato dos Dados** | Objetos Java Serializados | XML com Envelope | JSON, XML, Texto |
| **Interoperabilidade** | Baixa (Só Java) | Alta (Qualquer linguagem) | Alta (Qualquer linguagem) |
| **Complexidade** | Média | Alta | Baixa |
| **Uso Principal** | Sistemas Java antigos | Integrações bancárias/corporativas | APIs Web e Mobile atuais |
# Arquitetura de Sistemas Colaborativos - Rota Sul

- **Aluno:** Matheus Brito Chaves
- **RA:** 926109965
- **Disciplina:** Arquitetura de Software (Uninove 2026.2)
- **Aula:** 04 - Arquitetura de Sistemas Colaborativos

---

## 1. Modelo de Comunicação e Concorrência

### Síncrono vs. Assíncrono
- **Síncrono:** Validação de saldo/limite de crédito do lojista e consulta de estoque do armazém (o cliente aguarda a confirmação imediata).
- **Assíncrono:** Atualização de rastreamento de entregas pela frota/parceiro e envio de notificações de status (o processamento ocorre sem bloquear a origem).

### Controle de Concorrência no Case Rota Sul
- **Pessimista:** Aplicado na alocação de itens em uma `Remessa` no armazém. O item fica bloqueado enquanto o expedidor finaliza o volume para evitar que dois expedidores aloquem o mesmo produto em remessas diferentes.
- **Otimista:** Aplicado na atualização do status da entrega pelo motorista. O sistema verifica a versão do registro antes de salvar a ocorrência.

---

## 2. Modelo de Arquitetura Adotado
- **Modelo:** **Híbrida (Centralizada + Distribuída)**
- **Justificativa:** A base de dados principal (`Pedido`, `Cliente`, `Faturamento`) opera de forma **centralizada** para garantir consistência e controle financeiro. A coleta de dados de campo (aplicativo do motorista e integração das transportadoras parceiras) opera de forma **descentralizada/distribuída**, sincronizando via mensagens e APIs REST.

---

## 3. Avaliação de Características do Sistema Distribuído

| Característica | Aplicação Prática na Rota Sul |
|---|---|
| **Transparência da Distribuição** | Para o lojista, o sistema parece único, embora integre 4 subsistemas distintos. |
| **Escalabilidade** | A API de rastreamento aceita o aumento de requisições de clientes sem degradar o painel do expedidor. |
| **Tolerância a Falhas** | Se a API de uma parceira de última milha cair, as ocorrências ficam salvas em fila local e sincronizam ao reestabelecer. |
| **Interoperabilidade** | Troca de dados entre sistemas heterogêneos utilizando metadados padronizados em JSON/REST. |
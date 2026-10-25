# Arquitetura de Sistemas Colaborativos - Rota Sul

- **Aluno:** Matheus Brito Chaves
- **RA:** 926109965
- **Disciplina:** Arquitetura de Software (Uninove 2026.2)
- **Aula:** 04 - Arquitetura de Sistemas Colaborativos

---

## 1. Visão Geral da Arquitetura Colaborativa
A arquitetura do sistema Rota Sul é estruturada para integrar 4 subsistemas centrais que colaboram na cadeia logística:
- **Subsistema de Pedidos (Lojista):** Captação e registro de pedidos dos clientes.
- **Subsistema de Armazém e Expedição:** Agrupamento de itens em remessas e volumes.
- **Subsistema de Transporte Principal:** Gestão do transporte de longa distância com frota própria.
- **Subsistema de Última Milha:** Repasse e acompanhamento das entregas com parceiros locais.

---

## 2. Estilo Arquitetural e Topologia
- **Estilo:** Cliente-Servidor centralizado na nuvem com integração orientada a serviços (SOA/REST).
- **Modo de Interação:** Híbrido (Assíncrono para eventos de rastreamento e Síncrono para validação de pedidos/estoque).
- **Topologia de Rede:** Nós distribuídos que comunicam status do pedido centralizado em um banco de dados comum.

---

## 3. Matriz de Colaboração entre Atores e Componentes

| Ator | Componente Acessado | Dados Compartilhados | Protocolo de Comunicação |
|---|---|---|---|
| **Lojista** | Web / Portal de Pedidos | `Pedido`, `Cliente` | HTTPS / REST |
| **Expedidor** | Módulo de Armazém | `Remessa`, `Volume` | HTTPS / Web |
| **Motorista** | App Rota Principal | `Rota`, `Ocorrencia` | REST / Mobile |
| **Parceiro** | API de Integração | `StatusEntrega`, `Parceiro` | REST / JSON |
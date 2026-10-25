# Análise do Sistema Colaborativo - Rota Sul

- **Aluno:** Matheus Brito Chaves
- **RA:** 926109965
- **Disciplina:** Arquitetura de Software (Uninove 2026.2)
- **Aula:** 03 - Sistemas Colaborativos

---

## 1. Classificação do Sistema
A Rota Sul enquadra-se tanto como uma **aplicação corporativa** quanto como um **sistema colaborativo (groupware)**:
- **Corporativa:** Presta o serviço específico de gestão de pedidos, frete e expedição.
- **Colaborativa:** Permite que diferentes papéis (Lojista, Expedidor, Motorista, Atendente e Parceiro) trabalhem em conjunto sobre as mesmas entidades (`Pedido`, `Remessa`, `Volume`), compartilhando estado e informação em tempo real.

---

## 2. Mapeamento no Modelo 3C de Colaboração

| Dimensão | Descrição da Atividade no Case Rota Sul | Atores Envolvidos |
|---|---|---|
| **Comunicação** | Troca de mensagens e eventos sobre alteração de status do pedido ou ocorrência na rota. | Lojista, Atendente, Motorista |
| **Coordenação** | Agendamento, atribuição de rotas e organização da montagem das remessas no armazém. | Expedidor, Transportadora Parceira |
| **Cooperação** | Execução conjunta do fluxo operacional (do pedido gerado até a entrega no destino final). | Todos os Atores |

---

## 3. Requisitos Não Funcionais Críticos
Infraestrutura e propriedades de software essenciais para sustentação da colaboração:

- **Alta Disponibilidade e Acesso Remoto:** Permitir que motoristas em rota e parceiros externos acessem o sistema via dispositivos móveis/web.
- **Integridade de Dados e Controle Transacional:** Evitar conflitos quando o atendente e o expedidor atualizam o status de um pedido simultaneamente.
- **Logs e Auditoria:** Rastrear o histórico de atualizações e trocas de responsabilidade sobre cada volume/remessa.
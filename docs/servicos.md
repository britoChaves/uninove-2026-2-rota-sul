# Arquitetura Orientada a Serviços (SOA) - Rota Sul

- **Aluno:** Matheus Brito Chaves
- **RA:** 926109965
- **Disciplina:** Arquitetura de Software (Uninove 2026.2)
- **Aula:** 07 - Arquitetura Orientada a Serviços (SOA)

---

## 1. Modelos de Comunicação Entre Componentes

| Modelo | Funcionamento no Case Rota Sul | Vantagens / Desvantagens |
|---|---|---|
| **Ponto a Ponto (Unicast)** | Comunicação direta entre o Atendente e um Motorista específico. | Simples, porém com alto acoplamento e dificuldade de escala. |
| **Cliente-Servidor** | O painel do expedidor consulta o servidor central para obter a lista de pedidos. | Centralizado, permite que clientes fiquem desconectados reduzindo uso da rede. |
| **Broadcast** | Sinalização sonora/visual no armazém informando atraso de carga para todos os expedidores. | Entrega massiva rápida, mas exige receptores conectados e prontos para processar. |

---

## 2. Os Três Componentes Principais da Arquitetura SOA

1. **Provedor de Serviço (Service Provider):** Componente que disponibiliza a funcionalidade (ex: `PedidoServicePadrao`).
2. **Consumidor de Serviço (Service Requester):** Componente que consome o serviço através de uma interface (ex: `PedidoController`).
3. **Registro de Serviço (Service Registry / Broker):** O container Inversão de Controle do Spring Boot que localiza e injeta a implementação correta no consumidor.

---

## 3. Desacoplamento via Interface na Rota Sul
A separação da interface `PedidoService` de sua implementação (`PedidoServicePadrao`) garante que novas regras de aceitação de pedidos (como fluxo de risco ou clientes corporativos) possam ser injetadas sem necessitar alterar o `PedidoController`.
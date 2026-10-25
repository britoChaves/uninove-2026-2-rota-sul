# Arquitetura em 3 Camadas e MVC - Rota Sul

- **Aluno:** Matheus Brito Chaves
- **RA:** 926109965
- **Disciplina:** Arquitetura de Software (Uninove 2026.2)
- **Aula:** 06 - Arquitetura em 3 Camadas e a Evolução do MVC

---

## 1. Mapeamento das Camadas do Contexto Pedido

| Camada | Pacote Java | Responsabilidade no Sistema |
|---|---|---|
| **Apresentação (Web)** | `br.uni9.rotasul.pedido.web` | Expor endpoints REST (`/pedidos`) com `PedidoController`. |
| **Negócio (Service)** | `br.uni9.rotasul.pedido.service` | Validações e regras do negócio com `PedidoService`. |
| **Acesso a Dados (Repository)** | `br.uni9.rotasul.pedido.repository` | Armazenamento em memória com `PedidoRepository`. |
| **Domínio (Domain)** | `br.uni9.rotasul.pedido.domain` | Modelo de dados com a entidade `Pedido`. |

---

## 2. Componentes e Independência
- **Componente:** Unidade funcional independente responsável por um domínio (ex: Pedidos).
- **Independência de Falhas:** O serviço de pedidos opera de forma autônoma e não é bloqueado por falhas em serviços externos de parceiros.
# Análise de Frameworks para Aplicativos Web

**Nome:** Matheus Brito Chaves  
**RA:** 926109965  
**Disciplina:** Arquitetura de Software  
**Curso:** Análise e Desenvolvimento de Sistemas - Uninove  

---

## 1. Evolução das Aplicações Web
A Web evoluiu de páginas estáticas em HTML puro nos anos 1990 para sistemas altamente dinâmicos e orientados a serviços (e-commerce, portais e redes sociais). 

Para permitir a interação do usuário e o processamento de regras no servidor, surgiram tecnologias como CSS (estilização), JavaScript (dinamismo no navegador) e linguagens server-side como o Java.

---

## 2. A Tríade Tradicional do Java Web vs. Spring MVC Moderno

O modelo clássico da plataforma Java EE organizava as aplicações web em três componentes principais:

| Componente Tradicional (Java EE) | Função | Equivalente no Spring Boot (Rota Sul) |
| :--- | :--- | :--- |
| **JSP (JavaServer Pages)** | Arquivos com mescla de HTML e Java para gerar a interface visual. | **Thymeleaf** (Templates HTML limpos em `resources/templates`). |
| **Servlet** | Classe Java que recebe as requisições HTTP, processa parâmetros e decide a navegação. | **Controller Spring** (`@Controller` como o `PedidoFormController`). |
| **JavaBeans** | Classes com atributos e regras de negócio/persistência de dados. | **Services e Entities** (`PedidoService`, `Pedido`). |
| **web.xml** | Descritor de deployment que mapeava manualmente URLs e Servlets. | **Anotações Spring** (`@GetMapping`, `@PostMapping`) eliminam o `web.xml`. |

---

## 3. Sincronização e Mecanismos PUSH vs. PULL

- **Mecanismo PULL (Solicitação):** O cliente (navegador) faz uma requisição HTTP explícita ao servidor e aguarda a resposta. É o padrão do nosso formulário web no Thymeleaf.
- **Mecanismo PUSH (Notificação):** O servidor envia dados atualizados ao cliente de forma proativa, sem que o cliente precise solicitar a cada momento (ex: WebSockets, notificações em tempo real).

---

## 4. Separação de Responsabilidades (View vs. Regra de Negócio)
A inclusão de uma camada visual (Thymeleaf) não altera as regras de negócio já construídas na aplicação. O `PedidoFormController` apenas recebe os dados da tela e repassa para o `PedidoService`. Isso garante que a mesma regra de negócio atenda tanto a interface Web quanto a API REST da Rota Sul sem duplicação de código.
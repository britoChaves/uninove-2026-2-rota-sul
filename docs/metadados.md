# Análise de Metadados: XML vs. JSON e Negociação de Conteúdo

**Aluno:** Matheus Brito Chaves 
**RA:** 926109965  
**Disciplina:** Arquitetura de Software  
**Instituição:** Universidade Nove de Julho - Uninove  

---

## 1. O que são Metadados
Metadados (ou metainformações) são "dados sobre dados". Na comunicação de sistemas distribuídos e arquiteturas de serviços, formatos baseados em texto simples como XML e JSON funcionam como contratos de comunicação abertos para descrever e estruturar a informação trafegada entre diferentes aplicações.

## 2. Comparativo: XML vs. JSON

### XML (eXtensible Markup Language)
- **Estrutura:** Linguagem de marcação com tags hierárquicas em pares (`<tag></tag>`).
- **Desvantagem de Overhead:** Apresenta alto consumo de bytes em rede devido ao tamanho do texto gasto apenas com os nomes das tags de abertura e fechamento em comparação ao conteúdo útil (*payload*).
- **Leitura/Processamento:** Leitura mais verbosa e processamento computacional mais pesado para *parsing*.

### JSON (JavaScript Object Notation)
- **Estrutura:** Formato leve baseado em pares chave/valor e arrays (`{ "chave": "valor" }`).
- **Eficiência:** Reduz drasticamente o consumo de bytes trafegados por não exigir tags de fechamento repetidas.
- **Leitura/Processamento:** Processamento nativo extremamente rápido e sintaxe objetiva.

## 3. Negociação de Conteúdo (Content Negotiation)
A negociação de conteúdo permite que o cliente (browser, aplicativo móvel ou outro serviço) escolha em qual formato deseja receber a resposta do servidor HTTP.

- **Cabeçalho `Accept`:**
  - `Accept: application/json` $\rightarrow$ O servidor retorna a resposta formatada em **JSON**.
  - `Accept: application/xml` $\rightarrow$ O servidor utiliza o suporte do `jackson-dataformat-xml` para retornar a resposta em **XML**.
# Análise de Empacotamento: Servidores de Aplicação vs. Spring Boot

## 1. Modelo Tradicional (Java EE / Jakarta EE)
- **Formato de Entrega:** Arquivos `.war` (Web Application Archive) ou `.ear` (Enterprise Application Archive).
- **Infraestrutura:** Requer a instalação, configuração e manutenção prévia de um Servidor de Aplicação dedicado (ex: Apache Tomcat, WildFly/JBoss, IBM WebSphere).
- **Processo de Deploy:** O artefato compilado é implantado (*deployed*) dentro do servidor já em execução na máquina ou container.

## 2. Modelo Moderno (Spring Boot / Runnable Fat JAR)
- **Formato de Entrega:** Arquivo `.jar` executável contendo todas as dependências e o servidor web embutido (*Embedded Tomcat*).
- **Infraestrutura:** Não exige servidor web pré-instalado na máquina. Requer apenas o ambiente de execução Java (JRE/JDK 21).
- **Processo de Deploy:** A aplicação é iniciada diretamente pelo comando `java -jar nome-da-aplicacao.jar`.

## 3. Conclusão e Vantagens da Abordagem Embutida
A utilização de um *Fat JAR* com servidor embutido simplifica o processo de implantação (*deploy*), reduz discrepâncias de ambiente entre desenvolvimento e produção, e facilita a conteinerização (ex: Docker) e a arquitetura de microsserviços.
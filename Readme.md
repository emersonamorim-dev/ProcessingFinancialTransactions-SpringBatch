### ProcessingFinancialTransactions - Spring Batch

Codificação de aplicação para ProcessingFinancialTransactions é uma aplicação codificada em Java com SpringBoot e Spring Batch desenvolvida para automatizar o processamento de transações financeiras. Ela lê transações de uma fonte de dados, realiza processamento e validação de cada transação e, finalmente, registra o resultado em um sistema de destino ou banco de dados.

#### Recursos
- Processamento em lote de transações financeiras.
- Validação de dados de transação.
- Registro de transações processadas em um banco de dados.
- Notificação de conclusão de job por e-mail.

#### Tecnologias Utilizadas
- Spring Boot
- Spring Batch
- PostgreSQL / H2 (para testes)
- Java Mail Sender para notificações por e-mail

#### Configuração do Ambiente
- Pré-requisitos
- Java JDK 11 ou superior
- Maven 3.6.3 ou superior
- PostgreSQL instalado e executando (opcional para produção)
- H2 Database (para desenvolvimento e testes)

#### Configuração do Banco de Dados
1. Crie um banco de dados no PostgreSQL chamado `financial_transactions_db`.
2. Execute o script SQL `schema-postgresql.sql` para criar as tabelas necessárias.
3. (Opcional) Para testes, configure o banco de dados H2 no `application.properties`.

#### Configuração de E-mail
Configure as propriedades de e-mail no `application.properties` para habilitar a notificação de conclusão do job.

### Como Executar
Para executar a aplicação, use o seguinte comando Maven:
```
mvn spring-boot:run
```


#### Conclusão
A aplicação em Java com SpringBoot e Spring Batch fornece uma visão geral da sua aplicação de ProcessingFinancialTransactions, incluindo com Banco de Dados PostgreSQL e as boas práticas adotadas durante o desenvolvimento. 


#### Autor:
Emerson Amorim [@emerson-amorim-dev](https://www.linkedin.com/in/emerson-amorim-dev/)


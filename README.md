# 📬 Messageria Java

**Descrição:**  
Este projeto implementa uma arquitetura de microsserviços em Java, focada na comunicação assíncrona entre serviços utilizando mensageria.  
A solução é composta por três microsserviços principais: `notificacao`, `processador` e `pedidos-api`, que interagem por meio de uma fila de mensagens para processar e enviar notificações de forma eficiente e escalável.

## 🛠️ Tecnologias Utilizadas

- **Java 17**: Linguagem principal do projeto, aproveitando os recursos modernos e melhorias de performance.
- **Spring Boot**: Framework que facilita a configuração e o desenvolvimento dos microsserviços.
- **RabbitMQ**: Broker de mensagens utilizado para a comunicação assíncrona entre os serviços.
- **Docker**: Containerização dos serviços para garantir portabilidade e facilidade de deploy.
- **Docker Compose**: Orquestração dos containers para simplificar o ambiente de desenvolvimento e testes.

## 🏗️ Arquitetura dos Microsserviços

1. **Pedidos API (`pedidos-api`)**: Responsável por receber e processar os pedidos dos clientes. Após a validação, publica uma mensagem na fila para que os demais serviços possam processá-la.

2. **Processador (`processador`)**: Consome as mensagens da fila, realiza o processamento necessário e encaminha as informações para o serviço de notificações.

3. **Notificação (`notificacao`)**: Recebe as informações processadas e envia notificações aos clientes, podendo ser via e-mail, SMS ou outros canais configurados.

## 🚀 Como Executar o Projeto

### Pré-requisitos:
- Docker e Docker Compose instalados na máquina.

### Passos para execução:
```bash
git clone https://github.com/augustojbe/messageria-java.git
cd messageria-java
docker-compose up

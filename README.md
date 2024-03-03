# Planner-API

Este projeto é uma API baseada Spring-Boot(Framework da linguagem Java) que simula um sistema bancário fazendo consultas e operações sobre contas bancárias fictícias construídas com base no paradigma de orientação a objeto.
A API pode ser acessada através da URL: https://locahost:8080 após ser iniciada localmente(Veja a seção "Rodando localmente")

## Stack utilizada

![Java](https://img.shields.io/badge/-Java-333333?style=for-the-badge&logo=OpenJDK)
![Spring](https://img.shields.io/badge/-Spring-333333?style=for-the-badge&logo=Spring)
![Maven](https://img.shields.io/badge/-Maven-333333?style=for-the-badge&logo=ApacheMaven)

## Rodando localmente

Clone o projeto

```bash
  git clone https://github.com/Caique27/JavaBank.git
```

Entre no diretório do projeto

```bash
  cd JavaBank
```
Inicie o projeto

```bash
  mvn spring-boot:run
```

Acesse a API através da URL:

```bash
  https://localhost:8080
```

## Documentação da API

#### Retorna todas as contas

```http
  GET /contas
```

#### Retorna uma conta específica

```http
  GET /contas/{id}
```

###### Parâmetros do corpo da requisição

| Parâmetro | Tipo     | Descrição                                          |
| :-------- | :------- | :------------------------------------------------- |
| `id`    | `int` | **Obrigatório**. O id da conta que está sendo buscada. |

#### Cria uma conta

```http
  POST /conta
```

###### Parâmetros do corpo da requisição

| Parâmetro     | Tipo     | Descrição                                                       |
| :------------ | :------- | :-------------------------------------------------------------- |
| `titular`       | `string` | **Obrigatório**. O nome do titular da conta|
| `saldo` | `float`    | **Obrigatório**. O saldo inicial da conta. |
| `tipo` | `string`    | **Obrigatório**. O tipo de pessoa titular da conta("fisica" ou juridica").|
| `cpf_cnpj` | `int`    | **Obrigatório**. O cpf/cnpj do titular da conta(sem pontos ou traços).|



#### Realiza uma transferência entre contas

```http
  PUT /transferencia
```

###### Parâmetros do corpo da requisição

| Parâmetro | Tipo  | Descrição                                              |
| :-------- | :---- | :----------------------------------------------------- |
| `idOrigem`      | `int` | **Obrigatório**. O id da conta que fará a transferência.|
| `idDestino`      | `int` | **Obrigatório**. O id da conta que receberá a transferência. |
| `valor`      | `float` | **Obrigatório**. O valor da transferência a ser feita. |

#### Realiza um depósito em uma conta
```http
  PUT /deposito
```

###### Parâmetros do corpo da requisição

| Parâmetro | Tipo  | Descrição                                                  |
| :-------- | :---- | :--------------------------------------------------------- |
| `idConta`      | `int` | **Obrigatório**. O id da conta que receberá o depósito. |
| `valor`      | `float` | **Obrigatório**. O valor a ser depositado. |
#

#### Realiza um saque de uma conta
```http
  PUT /saque
```

###### Parâmetros do corpo da requisição

| Parâmetro | Tipo  | Descrição                                                  |
| :-------- | :---- | :--------------------------------------------------------- |
| `idConta`      | `int` | **Obrigatório**. O id da conta que receberá o depósito. |
| `valor`      | `float` | **Obrigatório**. O valor a ser sacado. |

## Estrutura de Classes

- As contas fícticias da aplicação são objetos das classes 
`ContaPF` e `ContaPJ`, ambas as classes são subclasses da 
classe `Conta` construídas com base no princípio da **herança**. 
- Os métodos de saque, depósito e transferência são métodos da superclasse, porém note que o metódo de transferência é sobrescrito nas subclasses para incluir a cobrança de um imposto ficitício, esta abordagem implementa o princípio do **polimorfismo**".
- O atributo `saldo` é acompanhado da palavra reservada `protected` para que módulos externos não possam acessá-lo diretamente, este acesso deve ser feito através do getter `getSaldo()`. Esta prática de segurança é conhecida como **encapsulamento**.q


## Contato

Pesquise pelo nome de usuário ou clique nos ícones.

[![GitHub](https://img.shields.io/badge/-Caique27-333333?style=for-the-badge&logo=github)](https://github.com/Caique27)
[![LinkedIn](https://img.shields.io/badge/-Caique%20Alves-blue?style=for-the-badge&logo=LinkedIn)](https://www.linkedin.com/in/caique-alves-/)
![GitHub](https://img.shields.io/badge/-caiquealvesdesouza27@gmail.com-red?style=for-the-badge&logo=gmail&logoColor=white)
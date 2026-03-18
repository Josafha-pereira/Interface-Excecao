# 📚 Conceitos de Java — Interface e Exceção

Este repositório contém exemplos práticos de dois conceitos fundamentais da linguagem Java: **Interfaces** e **Tratamento de Exceções**.

---

## 📁 Estrutura do Repositório

```
/
├── Interface/
│   └── InterfaceJava.java
└── Excecao/
    └── Excecao.java
```

---

## 📂 Interface — `/Interface`

### O que é uma Interface em Java?

Uma **interface** em Java é um contrato que define um conjunto de métodos que uma classe deve implementar. Ela não possui implementação própria dos métodos (apenas suas assinaturas), obrigando qualquer classe que a implemente a fornecer o comportamento concreto. Isso promove o **polimorfismo** e o **baixo acoplamento** entre as partes do código.

Principais características:
- Todos os métodos declarados em uma interface são implicitamente `public` e `abstract`
- Uma classe pode implementar múltiplas interfaces (diferente de herança, que é única)
- Permite tratar objetos de classes diferentes de forma uniforme, desde que implementem a mesma interface

### O que foi feito neste código?

Foi criada a interface `Automovel`, que define o contrato para qualquer veículo:

| Método | Descrição |
|---|---|
| `AbastecerVeiculo(double litros)` | Abastece o veículo com uma quantidade de litros |
| `GetCombustivel()` | Retorna o nível atual de combustível |
| `ConsumoPorKm()` | Retorna o consumo do veículo em litros por km |
| `CombustivelGasto(double quantidade)` | Subtrai combustível após uma viagem |

Duas classes implementam essa interface:

- **`Carro`** — consome `1/15` litro por km (1 litro a cada 15 km)
- **`Moto`** — consome `1/10` litro por km (1 litro a cada 10 km)

O método estático `realizarViagem(Automovel auto, double distancia)` recebe qualquer objeto do tipo `Automovel`, calcula o combustível necessário para a distância informada e verifica se há saldo suficiente antes de realizar a viagem — demonstrando o uso do **polimorfismo** na prática.

No `main`, um array do tipo `Automovel[]` armazena instâncias de `Carro` e `Moto`, e ambos são abastecidos e testados em uma viagem de 100 km com o mesmo bloco de código, mostrando a flexibilidade que as interfaces proporcionam.

---

## 📂 Exceção — `/Excecao`

### O que é Tratamento de Exceções em Java?

O **tratamento de exceções** em Java é o mecanismo que permite ao programa lidar com erros em tempo de execução de forma controlada, evitando que o programa seja interrompido abruptamente. Ele é feito com os blocos `try`, `catch` e opcionalmente `finally`.

- **`try`**: envolve o código que pode gerar um erro
- **`catch`**: captura e trata o erro caso ele ocorra
- **`throw`**: lança manualmente uma exceção
- **`throws`**: declara que um método pode lançar uma exceção

Tipos utilizados neste código:
- `NumberFormatException` — lançada automaticamente pelo Java ao tentar converter uma `String` inválida para `int` com `Integer.parseInt()`
- `IllegalArgumentException` — lançada manualmente com `throw` quando um valor está fora do intervalo esperado (ex: idade ou matrícula negativa)

### O que foi feito neste código?

Foi criado um sistema de cadastro de alunos com validação de entradas via terminal. A classe `Aluno` armazena nome, idade e matrícula, e o método `InfoAluno()` exibe essas informações formatadas.

O fluxo do `main`:
1. O programa solicita os dados do aluno em um loop `while (true)`
2. Dentro do bloco `try`, as entradas são lidas e validadas:
   - Idade e matrícula são convertidas de `String` para `int` com `Integer.parseInt()` — caso o usuário digite letras ou símbolos, uma `NumberFormatException` é capturada
   - Se a idade ou matrícula for negativa, uma `IllegalArgumentException` é lançada manualmente com uma mensagem descritiva
3. O aluno válido é adicionado a um array de até 10 posições
4. Ao final do loop, todos os alunos cadastrados são exibidos

Esse exemplo demonstra como garantir a robustez de um programa mesmo diante de entradas inesperadas do usuário.

---

## 🛠️ Como executar

Certifique-se de ter o [JDK](https://www.oracle.com/java/technologies/downloads/) instalado. Em seguida, compile e execute cada arquivo pelo terminal:

```bash
# Interface
cd Interface
javac InterfaceJava.java
java InterfaceJava

# Exceção
cd Excecao
javac Excecao.java
java Excecao
```

---

## 🧑‍💻 Tecnologias

- Java (JDK 8+)
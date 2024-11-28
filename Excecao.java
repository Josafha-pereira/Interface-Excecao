/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package excecao;

import java.util.Scanner;


public class Excecao {

    // Classe Aluno para representar um aluno cadastrado
    public static class Aluno {
        String nome;
        int idade;
        int matricula;

        // Construtor da classe Aluno
        public Aluno(String nome, int idade, int matricula) {
            this.nome = nome;
            this.idade = idade;
            this.matricula = matricula;
        }

        // Método para exibir as informações do aluno
        void InfoAluno() {

            System.out.printf("Aluno: %s, idade %d e Matricula %d\n", this.nome, this.idade, this.matricula);
          
        }
    }

    // Metodo main
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in); // o objeto ler criado da classe scanner ira "ler" as entradas do usuario

        
        Aluno[] aluno = new Aluno[10]; // array para armazenar os alunos cadastrados, que tem 10 "vagas"
        int i = 0; // Contador

        while (true) {
            try {
                // Solicita e lê as entradas, para ter os dados do aluno
                System.out.print("Digite o nome do aluno: ");
                String nome = ler.nextLine();

                System.out.print("Digite a idade do aluno: ");
                int idade = Integer.parseInt(ler.nextLine()); // como o scanner so aceita ler string, tem que fazer a conversao
                // Verifica se a idade está dentro do intervalo válido
                if (idade < 0) {
                    throw new IllegalArgumentException("Nao existe idade negativa, escolha uma idade maior que 0!");
                }

                System.out.print("Digite o numero de matrícula do aluno: ");
                int matricula = Integer.parseInt(ler.nextLine()); //novamente, fazendo a coversao pelo scanner so ler string...
                
                // Verificar se a matrícula e positiva
                if (matricula < 0) {
                    throw new IllegalArgumentException("A matricula não pode ser negativa!");
                }

                // Cria um novo objeto (alunos) da classe Aluno e adiciona ao array
                aluno[i] = new Aluno(nome, idade, matricula);
                i++;
                System.out.println("Aluno cadastrado\n");
            } catch (NumberFormatException e) {
                // Exibe uma mensagem de erro caso o usuario digite um valor invalido para matricula e idade
                System.out.println("Erro: Entrada inválida!! Digite um numero valido!");
            } catch (IllegalArgumentException e) {
                // Exibe a mensagem de erro específica para cada exceção
                System.out.println("Erro: " + e.getMessage());
            }

            // Pergunta se o usuário deseja continuar cadastrando
            System.out.print("Deseja cadastrar outro aluno? (s/n): ");
            String resposta = ler.nextLine();
            
            // o "equalsIgnoreCase" serve para nao fazer distincao entre letras maiusculas e minusculas, ou seja, "S" == "s"..
            if (!resposta.equalsIgnoreCase("s")) {
                break; //se o usuário digitar algo diferente de "s" ou "S", entao o loop termina
            }
        }

        // Exibe a lista de alunos cadastrados
        System.out.println("\nLista de alunos cadastrados:");
        for (int j = 0; j < i; j++) {
            aluno[j].InfoAluno();
        }

}
}

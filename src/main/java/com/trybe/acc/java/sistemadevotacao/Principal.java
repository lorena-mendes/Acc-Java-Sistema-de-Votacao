package com.trybe.acc.java.sistemadevotacao;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Classe principal responsável por rodar a aplicação.
 */
public class Principal {

  /**
   * Método inicial.
   */
  public static void main(String[] args) {
    GerenciamentoVotacao gerenciamentoVotacao = new GerenciamentoVotacao();
    Scanner scan = new Scanner(System.in);
    short opcao = 0;

    System.out.println("----------- Bem-vindo ao Sistema de Votação -----------");

    while (opcao != 2) {

      System.out.println("Cadastrar pessoa candidata?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");

      System.out.println("Entre com o número correspondente à opção desejada:");
      String input1 = scan.next();
      opcao = Short.parseShort(input1);

      if (opcao == 1) {
        System.out.println("Entre com o nome da pessoa candidata: ");
        String nome = scan.next();
        System.out.println("Entre com o número da pessoa candidata: ");
        String input = scan.next();
        short numero = Short.parseShort(input);

        gerenciamentoVotacao.cadastrarPessoaCandidata(nome, numero);
      }
    }

    System.out.println("----------- Cadastre as pessoas eleitoras -----------");

    while (true) {

      System.out.println("Cadastrar pessoa eleitora?");
      System.out.println("1 - Sim");
      System.out.println("2 - Não");

      System.out.println("Entre com o número correspondente à opção desejada:");
      String input1 = scan.next();
      opcao = Short.parseShort(input1);

      if (opcao == 1) {
        System.out.println("Entre com o nome da pessoa eleitora: ");
        String nome = scan.next();
        System.out.println("Entre com o cpf da pessoa eleitora: ");
        String cpf = scan.next();

        gerenciamentoVotacao.cadastrarPessoaEleitora(nome, cpf);
      } else if (opcao == 2) {
        break;
      } else {
        System.out.println("Opção inválida. Tente novamente.");
      }
    }

    System.out.println("----------- Votação iniciada! -----------");

    Set<String> cpfVotado = new HashSet<>();

    while (true) {
      System.out.println("Entre com o número correspondente à opção desejada:");
      System.out.println("1 - Votar");
      System.out.println("2 - Resultado Parcial");
      System.out.println("3 - Resultado Votação");

      String input1 = scan.next();
      opcao = Short.parseShort(input1);

      if (opcao == 1) {
        System.out.println("Entre com o cpf da pessoa eleitora:");
        String cpf = scan.next();

        if (cpfVotado.contains(cpf)) {
          System.out.println("Pessoa eleitora já votou!");
        } else {
          System.out.println("Entre com o número da pessoa candidata:");
          String input2 = scan.next();
          short numero = Short.parseShort(input2);
          gerenciamentoVotacao.votar(cpf, numero);
          cpfVotado.add(cpf);
        }
      } else if (opcao == 2) {
        gerenciamentoVotacao.mostrarResultado();
      } else if (opcao == 3) {
        gerenciamentoVotacao.mostrarResultado();
        break;
      } else {
        System.out.println("Opção inválida. Tente novamente.");
      }
    }

    scan.close();

  }

}

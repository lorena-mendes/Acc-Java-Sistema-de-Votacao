package com.trybe.acc.java.sistemadevotacao;

import java.util.ArrayList;

/**
 * Classe gerenciamentoVotacao.
 **/
public class GerenciamentoVotacao {

  /**
   * Método inicial
   */
  private ArrayList<PessoaCandidata> pessoasCandidatas;
  private ArrayList<PessoaEleitora> pessoasEleitoras;
  private ArrayList<String> cpfComputado;
  private int totalVotos = 0;

  GerenciamentoVotacao() {
    pessoasCandidatas = new ArrayList<>();
    pessoasEleitoras = new ArrayList<>();
    cpfComputado = new ArrayList<>();
    totalVotos = 0;

  }

  public void cadastrarPessoaCandidata(String nome, int numero) {
    for (PessoaCandidata pessoa : pessoasCandidatas) {
      if (pessoa.getNumero() == numero) {
        System.out.println("Número pessoa candidata já utilizado!");
      }
    }

    PessoaCandidata novaPessoaCandidata = new PessoaCandidata(nome, numero);
    pessoasCandidatas.add(novaPessoaCandidata);
  }

  public void cadastrarPessoaEleitora(String nome, String cpf) {
    for (PessoaEleitora pessoa : pessoasEleitoras) {
      if (pessoa.getCpf() == cpf) {
        System.out.println("Pessoa eleitora já cadastrada!");
      }
    }

    PessoaEleitora novaPessoaEleitora = new PessoaEleitora(nome, cpf);
    pessoasEleitoras.add(novaPessoaEleitora);
  }

  public void votar(String cpfPessoaEleitora, int numeroPessoaCandidata) {
    for (String cpf : cpfComputado) {
      if (cpf.equals(cpfPessoaEleitora)) {
        System.out.println("Pessoa eleitora já votou!");
      }
    }

    PessoaCandidata pessoaCandidata = null;
    for (PessoaCandidata candidata : pessoasCandidatas) {
      if (candidata.getNumero() == numeroPessoaCandidata) {
        pessoaCandidata = candidata;
        break;
      }
    }

    if (pessoaCandidata != null) {
      pessoaCandidata.receberVoto();
      cpfComputado.add(cpfPessoaEleitora);
      totalVotos++;
    }

  }

  public void mostrarResultado() {
    if (totalVotos == 0) {
      System.out.println("É preciso ter pelo menos um voto para mostrar o resultado");
    }

    for (PessoaCandidata pessoa : pessoasCandidatas) {
      double percentualVotos = calculaPorcentagemVotos(pessoa);
      System.out.printf("Nome: %s - %d votos (%.1f%%)%n", pessoa.getNome(), pessoa.getVotos(),
          percentualVotos);
    }

    System.out.println("Total de votos: " + totalVotos);
  }

  private double calculaPorcentagemVotos(PessoaCandidata pessoa) {
    double percentual = (double) pessoa.getVotos() / totalVotos * 100;
    return Math.round(percentual * 10) / 10.0;
  }
}



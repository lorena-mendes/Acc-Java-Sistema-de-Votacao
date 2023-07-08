package com.trybe.acc.java.sistemadevotacao;

/**
 * Classe abstrata que representa uma pessoa.
 */
public abstract class Pessoa {
  protected String nome;

  /**
   * Construtor da classe Pessoa.
   */
  Pessoa(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

}

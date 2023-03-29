package com.example.model;

//Criando o modelo da classe Filme
public class Filme {
    private Long id;
    private String nome;
    private double duracao;

    //Criou-se um enum no intuito de subdividir a classe
    private Categoria categoria;

    public Filme(Long id, String nome, double duracao, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.duracao = duracao;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}

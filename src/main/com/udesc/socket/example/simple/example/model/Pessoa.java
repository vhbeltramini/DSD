package com.udesc.socket.example.simple.example.model;

public abstract class Pessoa {

    private Integer cpf;
    private String nome;
    private String endereco;

    protected Pessoa(Integer cpf, String nome, String endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
    }

    public Pessoa() {
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}

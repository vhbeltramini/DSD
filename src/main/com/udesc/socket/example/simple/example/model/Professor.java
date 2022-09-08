package com.udesc.socket.example.simple.example.model;

public class Professor extends Pessoa {

    private String formacao;

    public Professor(Integer cpf, String nome, String endereco, String formacao) {
        super(cpf, nome, endereco);
        this.formacao = formacao;
    }

    public Professor() {
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "cpf=" + getCpf() +
                ", nome='" + getNome() + '\'' +
                ", endereco='" + getEndereco() + '\'' +
                ", formacao='" + getFormacao() + '\'' +
                '}';
    }
}

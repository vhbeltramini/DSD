package com.udesc.socket.example.simple.example.model;

public class Professor extends Pessoa {

    public Professor(Integer cpf, String nome, String endereco) {
        super(cpf, nome, endereco);
    }

    public Professor() {
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "cpf=" + getCpf() +
                ", nome='" + getNome() + '\'' +
                ", endereco='" + getEndereco() + '\'' +
                '}';
    }
}

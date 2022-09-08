package com.udesc.socket.example.simple.example.model;

public class Aluno extends Pessoa {

    public Aluno(Integer cpf, String nome, String endereco) {
        super(cpf, nome, endereco);
    }

    public Aluno() {
        super();
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

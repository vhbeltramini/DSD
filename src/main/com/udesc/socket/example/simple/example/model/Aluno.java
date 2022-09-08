package com.udesc.socket.example.simple.example.model;

public class Aluno extends Pessoa {

    private int fase;

    public Aluno(Integer cpf, String nome, String endereco, int fase) {
        super(cpf, nome, endereco);
        this.fase = fase;
    }

    public Aluno() {
        super();
    }

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "cpf=" + getCpf() +
                ", nome='" + getNome() + '\'' +
                ", endereco='" + getEndereco() + '\'' +
                ", fase='" + getFase() + '\'' +
                '}';
    }
}

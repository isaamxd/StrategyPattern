package br.padroes.strategy.model;

import br.padroes.strategy.strategy.MediaStrategy;

public class Disciplina {
    private String nome;
    private double p1;
    private double p2;
    private double media;
    private String situacao;
    private MediaStrategy estrategia;

    public Disciplina(MediaStrategy estrategia) {
        this.estrategia = estrategia;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setP1(double p1) {
        this.p1 = validarNota(p1);
    }

    public void setP2(double p2) {
        this.p2 = validarNota(p2);
    }

    private double validarNota(double nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("A nota deve estar entre 0 e 10.");
        }
        return nota;
    }

    public void calcularMedia() {
        this.media = estrategia.calcularMedia(p1, p2);
        this.situacao = estrategia.verificarSituacao(media);
    }

    public void exibirResultado() {
        System.out.printf("Disciplina: %s%n", nome);
        System.out.printf("P1: %.2f | P2: %.2f | Média: %.2f | Situação: %s%n",
                p1, p2, media, situacao);
    }
}

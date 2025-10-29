package br.padroes.strategy.app;

import br.padroes.strategy.model.Disciplina;
import br.padroes.strategy.strategy.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Cálculo de Média (Strategy Pattern) ===");
        System.out.print("Nome da disciplina: ");
        String nome = sc.nextLine();

        System.out.print("Digite P1: ");
        double p1 = sc.nextDouble();

        System.out.print("Digite P2: ");
        double p2 = sc.nextDouble();

        System.out.println("\nEscolha o tipo de média:");
        System.out.println("1 - Aritmética");
        System.out.println("2 - Geométrica");
        System.out.print("Opção: ");
        int opcao = sc.nextInt();

        MediaStrategy estrategia;
        switch (opcao) {
            case 1 -> estrategia = new Aritmetica();
            case 2 -> estrategia = new Geometrica();
            default -> {
                System.out.println("Opção inválida! Usando média aritmética como padrão.");
                estrategia = new Aritmetica();
            }
        }

        Disciplina disciplina = new Disciplina(estrategia);
        disciplina.setNome(nome);
        disciplina.setP1(p1);
        disciplina.setP2(p2);
        disciplina.calcularMedia();
        disciplina.exibirResultado();

        sc.close();
    }
}

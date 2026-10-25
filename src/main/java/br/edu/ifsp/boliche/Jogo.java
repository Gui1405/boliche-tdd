package br.edu.ifsp.boliche;

public class Jogo {

    private int pontos;

    public void jogar(int pinos) {
        pontos += pinos;
    }

    public int pontuacao() {
        return pontos;
    }
}

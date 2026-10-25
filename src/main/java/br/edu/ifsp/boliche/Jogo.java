package br.edu.ifsp.boliche;

public class Jogo {

    private final int[] jogadas = new int[20];
    private int atual;

    public void jogar(int pinos) {
        jogadas[atual++] = pinos;
    }

    public int pontuacao() {
        int pontos = 0;
        int i = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (jogadas[i] + jogadas[i + 1] == 10) {
                pontos += 10 + jogadas[i + 2];
            } else {
                pontos += jogadas[i] + jogadas[i + 1];
            }
            i += 2;
        }
        return pontos;
    }
}

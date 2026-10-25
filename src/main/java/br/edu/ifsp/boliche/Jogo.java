package br.edu.ifsp.boliche;

public class Jogo {

    private final int[] jogadas = new int[20];
    private int atual;

    public void jogar(int pinos) {
        jogadas[atual++] = pinos;
    }

    public int pontuacao() {
        int pontos = 0;
        int inicioDoFrame = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (spare(inicioDoFrame)) {
                pontos += 10 + jogadas[inicioDoFrame + 2];
            } else {
                pontos += jogadas[inicioDoFrame] + jogadas[inicioDoFrame + 1];
            }
            inicioDoFrame += 2;
        }
        return pontos;
    }

    private boolean spare(int inicioDoFrame) {
        return jogadas[inicioDoFrame] + jogadas[inicioDoFrame + 1] == 10;
    }
}

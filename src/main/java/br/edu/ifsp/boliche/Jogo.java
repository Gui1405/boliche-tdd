package br.edu.ifsp.boliche;

public class Jogo {

    private static final int PINOS = 10;
    private static final int FRAMES = 10;

    private final int[] jogadas = new int[21];
    private int atual;

    public void jogar(int pinos) {
        if (pinos < 0) {
            throw new IllegalArgumentException("Jogada inválida: " + pinos + " pinos");
        }
        jogadas[atual++] = pinos;
    }

    public int pontuacao() {
        int pontos = 0;
        int inicioDoFrame = 0;
        for (int frame = 0; frame < FRAMES; frame++) {
            if (strike(inicioDoFrame)) {
                pontos += PINOS + bonusDoStrike(inicioDoFrame);
                inicioDoFrame++;
            } else if (spare(inicioDoFrame)) {
                pontos += PINOS + bonusDoSpare(inicioDoFrame);
                inicioDoFrame += 2;
            } else {
                pontos += somaDoFrame(inicioDoFrame);
                inicioDoFrame += 2;
            }
        }
        return pontos;
    }

    private boolean strike(int inicioDoFrame) {
        return jogadas[inicioDoFrame] == PINOS;
    }

    private boolean spare(int inicioDoFrame) {
        return somaDoFrame(inicioDoFrame) == PINOS;
    }

    private int somaDoFrame(int inicioDoFrame) {
        return jogadas[inicioDoFrame] + jogadas[inicioDoFrame + 1];
    }

    private int bonusDoStrike(int inicioDoFrame) {
        return jogadas[inicioDoFrame + 1] + jogadas[inicioDoFrame + 2];
    }

    private int bonusDoSpare(int inicioDoFrame) {
        return jogadas[inicioDoFrame + 2];
    }
}

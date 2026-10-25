package br.edu.ifsp.boliche;

public class Jogo {

    private static final int PINOS = 10;
    private static final int FRAMES = 10;

    private final int[] jogadas = new int[21];
    private int atual;
    private int pinosNoFrame;
    private int jogadasNoFrame;

    public void jogar(int pinos) {
        validar(pinos);
        jogadas[atual++] = pinos;
        pinosNoFrame += pinos;
        jogadasNoFrame++;
        if (pinosNoFrame == PINOS || jogadasNoFrame == 2) {
            proximoFrame();
        }
    }

    private void validar(int pinos) {
        if (pinos < 0 || pinos > PINOS) {
            throw new IllegalArgumentException("Jogada inválida: " + pinos + " pinos");
        }
        if (pinosNoFrame + pinos > PINOS) {
            throw new IllegalArgumentException("O frame passaria de " + PINOS + " pinos");
        }
    }

    private void proximoFrame() {
        pinosNoFrame = 0;
        jogadasNoFrame = 0;
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

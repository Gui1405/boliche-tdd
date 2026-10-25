package br.edu.ifsp.boliche;

public class Jogo {

    private static final int PINOS = 10;
    private static final int FRAMES = 10;
    private static final int MAXIMO_DE_JOGADAS = 21;

    private final int[] jogadas = new int[MAXIMO_DE_JOGADAS];
    private int totalDeJogadas;
    private int frameAtual = 1;
    private int pinosNoFrame;
    private int jogadasNoFrame;

    public void jogar(int pinos) {
        validar(pinos);
        jogadas[totalDeJogadas++] = pinos;
        pinosNoFrame += pinos;
        jogadasNoFrame++;
        if (frameAtual < FRAMES && (pinosNoFrame == PINOS || jogadasNoFrame == 2)) {
            proximoFrame();
        }
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

    public boolean encerrado() {
        if (frameAtual < FRAMES) {
            return false;
        }
        return jogadasNoFrame == 3 || jogadasNoFrame == 2 && pinosNoFrame < PINOS;
    }

    private void validar(int pinos) {
        if (encerrado()) {
            throw new IllegalStateException("A partida já terminou");
        }
        if (pinos < 0 || pinos > PINOS) {
            throw new IllegalArgumentException("Jogada inválida: " + pinos + " pinos");
        }
        if (frameAtual < FRAMES && pinosNoFrame + pinos > PINOS) {
            throw new IllegalArgumentException("O frame " + frameAtual + " passaria de " + PINOS + " pinos");
        }
    }

    private void proximoFrame() {
        frameAtual++;
        pinosNoFrame = 0;
        jogadasNoFrame = 0;
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

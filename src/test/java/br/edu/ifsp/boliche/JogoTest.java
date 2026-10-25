package br.edu.ifsp.boliche;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JogoTest {

    private Jogo jogo;

    @BeforeEach
    void novoJogo() {
        jogo = new Jogo();
    }

    private void jogarVarias(int vezes, int pinos) {
        for (int i = 0; i < vezes; i++) {
            jogo.jogar(pinos);
        }
    }

    @Test
    void nenhumPinoValeZero() {
        jogarVarias(20, 0);
        assertEquals(0, jogo.pontuacao());
    }

    @Test
    void umPinoPorJogadaValeVinte() {
        jogarVarias(20, 1);
        assertEquals(20, jogo.pontuacao());
    }

    private void jogarSpare() {
        jogo.jogar(5);
        jogo.jogar(5);
    }

    @Test
    void spareValeDezMaisAProximaJogada() {
        jogarSpare();
        jogo.jogar(3);
        jogarVarias(17, 0);
        assertEquals(16, jogo.pontuacao());
    }
}

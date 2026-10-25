package br.edu.ifsp.boliche;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class JogoTest {

    @Test
    void nenhumPinoValeZero() {
        Jogo jogo = new Jogo();
        for (int i = 0; i < 20; i++) {
            jogo.jogar(0);
        }
        assertEquals(0, jogo.pontuacao());
    }

    @Test
    void umPinoPorJogadaValeVinte() {
        Jogo jogo = new Jogo();
        for (int i = 0; i < 20; i++) {
            jogo.jogar(1);
        }
        assertEquals(20, jogo.pontuacao());
    }
}

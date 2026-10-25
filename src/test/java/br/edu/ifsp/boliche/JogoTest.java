package br.edu.ifsp.boliche;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    private void jogarStrike() {
        jogo.jogar(10);
    }

    @Test
    void strikeValeDezMaisAsDuasProximasJogadas() {
        jogarStrike();
        jogo.jogar(3);
        jogo.jogar(4);
        jogarVarias(16, 0);
        assertEquals(24, jogo.pontuacao());
    }

    @Test
    void spareEmTodosOsFramesVale150() {
        jogarVarias(21, 5);
        assertEquals(150, jogo.pontuacao());
    }

    @Test
    void jogoPerfeitoVale300() {
        jogarVarias(12, 10);
        assertEquals(300, jogo.pontuacao());
    }

    private void jogarSequencia(int... sequencia) {
        for (int pinos : sequencia) {
            jogo.jogar(pinos);
        }
    }

    @Test
    void partidaMistaVale167() {
        jogarSequencia(10, 7, 3, 9, 0, 10, 0, 8, 8, 2, 0, 6, 10, 10, 10, 8, 1);
        assertEquals(167, jogo.pontuacao());
    }

    @Test
    void jogadaNegativaLancaExcecao() {
        assertThrows(IllegalArgumentException.class, () -> jogo.jogar(-1));
    }

    @Test
    void jogadaComMaisDeDezPinosLancaExcecao() {
        assertThrows(IllegalArgumentException.class, () -> jogo.jogar(11));
    }

    @Test
    void segundaJogadaQueFazOFramePassarDeDezPinosLancaExcecao() {
        jogo.jogar(7);
        assertThrows(IllegalArgumentException.class, () -> jogo.jogar(4));
    }

    @Test
    void partidaTerminaApos20JogadasSemStrikeNemSpareNoDecimoFrame() {
        jogarVarias(19, 0);
        assertFalse(jogo.encerrado());
        jogo.jogar(0);
        assertTrue(jogo.encerrado());
    }

    @Test
    void spareNoDecimoFrameDaDireitoAUmaJogadaExtra() {
        jogarVarias(18, 0);
        jogarSpare();
        assertFalse(jogo.encerrado());
        jogo.jogar(3);
        assertTrue(jogo.encerrado());
    }

    @Test
    void strikeNoDecimoFrameDaDireitoADuasJogadasExtras() {
        jogarVarias(18, 0);
        jogarStrike();
        jogo.jogar(3);
        assertFalse(jogo.encerrado());
        jogo.jogar(4);
        assertTrue(jogo.encerrado());
    }

    @Test
    void jogoPerfeitoTerminaNaDecimaSegundaJogada() {
        jogarVarias(11, 10);
        assertFalse(jogo.encerrado());
        jogarStrike();
        assertTrue(jogo.encerrado());
    }

    @Test
    void jogadaDepoisDoFimDaPartidaLancaExcecao() {
        jogarVarias(20, 0);
        assertThrows(IllegalStateException.class, () -> jogo.jogar(0));
    }
}

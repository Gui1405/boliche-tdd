# Lista de testes

Ordem planejada, do caso mais simples ao mais completo. Cada item vira um ciclo red, green e refactor.

## Pontuação

1. [x] Nenhum pino: 20 jogadas de 0 valem 0
2. [x] Um pino por jogada: 20 jogadas de 1 valem 20
3. [x] Um spare: 5, 5, 3 e 17 jogadas de 0 valem 16
4. [x] Um strike: 10, 3, 4 e 16 jogadas de 0 valem 24
5. [x] Spare em todos os frames: 21 jogadas de 5 valem 150
6. [x] Jogo perfeito: 12 jogadas de 10 valem 300 (passou sem mudar o código)
7. [x] Partida mista: 10 · 7, 3 · 9, 0 · 10 · 0, 8 · 8, 2 · 0, 6 · 10 · 10 · 10, 8, 1 vale 167 (passou sem mudar o código)

## Validações

8. [x] V1: jogada com menos de 0 pinos lança IllegalArgumentException
9. [x] V1: jogada com mais de 10 pinos lança IllegalArgumentException
10. [x] V2: nos frames 1 a 9, segunda jogada que faz o frame passar de 10 pinos (7 e depois 4) lança IllegalArgumentException
11. [x] V3: a partida termina após 20 jogadas sem strike ou spare no décimo frame
12. [x] V3: spare no décimo frame dá direito a uma jogada extra
13. [x] V3: strike no décimo frame dá direito a duas jogadas extras
14. [x] V3: jogo perfeito só termina na 12ª jogada (incluído durante o trabalho; passou sem mudar o código)
15. [x] V3: jogada depois do fim da partida lança IllegalStateException

## O que mudou durante o trabalho

- O teste 5 falhou com ArrayIndexOutOfBoundsException: o vetor tinha 20 posições e a jogada extra do décimo frame pediu a 21ª.
- Os testes 6, 7 e 14 passaram na primeira execução, porque as regras de strike e do décimo frame já tinham sido construídas pelos testes anteriores. Ficaram como commits `test:`, sem fase green.
- O teste 14 entrou depois do 13, para garantir que o fim da partida também funciona com strikes nos frames 1 a 9.

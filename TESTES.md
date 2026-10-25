# Lista de testes

Ordem planejada, do caso mais simples ao mais completo. Cada item vira um ciclo red, green e refactor.

## Pontuação

1. [ ] Nenhum pino: 20 jogadas de 0 valem 0
2. [ ] Um pino por jogada: 20 jogadas de 1 valem 20
3. [ ] Um spare: 5, 5, 3 e 17 jogadas de 0 valem 16
4. [ ] Um strike: 10, 3, 4 e 16 jogadas de 0 valem 24
5. [ ] Spare em todos os frames: 21 jogadas de 5 valem 150
6. [ ] Jogo perfeito: 12 jogadas de 10 valem 300
7. [ ] Partida mista: 10 · 7, 3 · 9, 0 · 10 · 0, 8 · 8, 2 · 0, 6 · 10 · 10 · 10, 8, 1 vale 167

## Validações

8. [ ] V1: jogada com menos de 0 pinos lança IllegalArgumentException
9. [ ] V1: jogada com mais de 10 pinos lança IllegalArgumentException
10. [ ] V2: nos frames 1 a 9, segunda jogada que faz o frame passar de 10 pinos (7 e depois 4) lança IllegalArgumentException
11. [ ] V3: a partida termina após 20 jogadas sem strike ou spare no décimo frame
12. [ ] V3: spare no décimo frame dá direito a uma jogada extra
13. [ ] V3: strike no décimo frame dá direito a duas jogadas extras
14. [ ] V3: jogada depois do fim da partida lança IllegalStateException

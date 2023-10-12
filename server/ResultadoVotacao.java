package server;

import java.io.Serializable;
import java.util.Map;

/**
 * A classe ResultadoVotacao representa o resultado de uma votação, armazenando os votos para diferentes opções.
 * Implementa a interface Serializable para permitir a serialização de objetos desta classe.
 */
public class ResultadoVotacao implements Serializable {

    private Map<String, Integer> votos;

    /**
     * Cria uma nova instância de ResultadoVotacao com os votos fornecidos.
     *
     * @param votos Um mapa que associa as opções de voto (representadas como strings) aos números de votos recebidos.
     */
    public ResultadoVotacao(Map<String, Integer> votos) {
        this.votos = votos;
    }

    /**
     * Recupera o mapa de votos associado a este resultado de votação.
     *
     * @return Um mapa que associa as opções de voto (representadas como strings) aos números de votos recebidos.
     */
    public Map<String, Integer> getVotos() {
        return votos;
    }
}

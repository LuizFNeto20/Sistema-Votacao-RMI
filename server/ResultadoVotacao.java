package server;

import java.io.Serializable;
import java.util.Map;

public class ResultadoVotacao implements Serializable {
    private Map<String, Integer> votos;

    public ResultadoVotacao(Map<String, Integer> votos) {
        this.votos = votos;
    }

    public Map<String, Integer> getVotos() {
        return votos;
    }
}

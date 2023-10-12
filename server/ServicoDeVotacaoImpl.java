package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

/**
 * A classe ServicoDeVotacaoImpl implementa a interface ServicoDeVotacao e fornece um serviço remoto para
 * gerenciar votações. Ela mantém um registro de votos e fornece métodos para registrar votos e obter resultados.
 */
public class ServicoDeVotacaoImpl extends UnicastRemoteObject implements ServicoDeVotacao {

    private Map<String, Integer> votos = new HashMap<>();
    private int totalVotos = 0;

    /**
     * Cria uma nova instância de ServicoDeVotacaoImpl.
     *
     * @throws RemoteException se ocorrer um erro de comunicação remota.
     */
    public ServicoDeVotacaoImpl() throws RemoteException {
    }

    /**
     * Registra um voto para um candidato específico.
     *
     * @param eleitor   O nome do eleitor que está votando.
     * @param candidato O nome do candidato para o qual o voto está sendo registrado.
     * @throws RemoteException se ocorrer um erro de comunicação remota.
     */
    @Override
    public synchronized void votar(String eleitor, String candidato) throws RemoteException {
         if (votos.containsKey(candidato)) {
            int votosAtuais = votos.get(candidato);
            votos.put(candidato, votosAtuais + 1);
        } else {
            votos.put(candidato, 1);
        }

        totalVotos++;

        System.out.println("\nVoto computado. Total de votos: " + totalVotos);
    }

    /**
     * Retorna o resultado da votação, ou seja, um objeto ResultadoVotacao contendo o mapa de votos registrados.
     *
     * @return Um objeto ResultadoVotacao com os resultados da votação.
     * @throws RemoteException se ocorrer um erro de comunicação remota.
     */
    @Override
    public ResultadoVotacao getResultado() throws RemoteException {
        return new ResultadoVotacao(this.votos);
    }

    /**
     * Retorna o número total de votos registrados até o momento.
     *
     * @return O número total de votos registrados.
     * @throws RemoteException se ocorrer um erro de comunicação remota.
     */
    public int getTotalVotos() throws RemoteException {
        return totalVotos;
    }
}

package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * A interface ServicoDeVotacao é uma interface remota que define métodos para registrar votos e obter resultados de uma votação.
 */
public interface ServicoDeVotacao extends Remote {
 
    /**
     * Registra o voto de um eleitor em um candidato específico.
     *
     * @param eleitor   O nome do eleitor que está votando.
     * @param candidato O nome do candidato para o qual o voto está sendo registrado.
     * @throws RemoteException se ocorrer um erro de comunicação remota.
     */
    public void votar(String eleitor, String candidato) throws RemoteException;

    /**
     * Obtém o resultado da votação, representado como um objeto ResultadoVotacao.
     *
     * @return Um objeto ResultadoVotacao com os resultados da votação.
     * @throws RemoteException se ocorrer um erro de comunicação remota.
     */
    public ResultadoVotacao getResultado() throws RemoteException;
}

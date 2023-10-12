package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

/**
 * A interface ServicoDeResultados é uma interface remota que define um método para obter os resultados de uma votação.
 */
public interface ServicoDeResultados extends Remote {
    
    /**
     * Obtém os resultados da votação atualmente registrados no sistema.
     *
     * @return Um mapa que associa as opções de voto (representadas como strings) aos números de votos registrados.
     * @throws RemoteException se ocorrer um erro de comunicação remota.
     */
    public Map<String, Integer> getResultados() throws RemoteException;
}

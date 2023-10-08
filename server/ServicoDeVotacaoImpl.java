package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class ServicoDeVotacaoImpl extends UnicastRemoteObject implements ServicoDeVotacao {

    private Map<String, Integer> votos = new HashMap<>();
    private int totalVotos = 0;

    public ServicoDeVotacaoImpl() throws RemoteException {
    }

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

    @Override
    public ResultadoVotacao getResultado() throws RemoteException {
        return new ResultadoVotacao(this.votos);
    }

    public int getTotalVotos() throws RemoteException {
        return totalVotos;
    }
}
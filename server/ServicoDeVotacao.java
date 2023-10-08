package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServicoDeVotacao extends Remote {
 
    public void votar(String eleitor, String candidato) throws RemoteException;
    public ResultadoVotacao getResultado() throws RemoteException;

}
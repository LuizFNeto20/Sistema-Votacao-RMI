package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface ServicoDeResultados extends Remote {
    
    public Map<String, Integer> getResultados() throws RemoteException;

}

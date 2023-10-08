package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;

public class ServicoDeResultadosImpl extends UnicastRemoteObject implements ServicoDeResultados {

    protected ServicoDeResultadosImpl() throws RemoteException {
        super();
    }

    @Override
    public Map<String, Integer> getResultados() {

        Map<String, Integer> votosComputados = null;

        try {
            ServicoDeVotacao votos = (ServicoDeVotacao) Naming.lookup("rmi://localhost:2126/votacao");

            ResultadoVotacao resultadoVotacao = votos.getResultado();

            votosComputados = resultadoVotacao.getVotos();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

        return votosComputados;
    }

}

package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorRMI {

    public static void main(String args[]) {

        try {
            ServicoDeVotacao votacao = new ServicoDeVotacaoImpl();
            ServicoDeResultados resultados = new ServicoDeResultadosImpl();

            Registry r = LocateRegistry.createRegistry(2126);

            System.out.println(r);

            Naming.rebind("rmi://localhost:2126/votacao", votacao);
            Naming.rebind("rmi://localhost:2126/resultados", resultados);

            System.out.println("Servidor no ar!");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}

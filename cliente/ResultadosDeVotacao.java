package cliente;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Map;

import server.ServicoDeResultados;

public class ResultadosDeVotacao {

    public static void main(String args[]) {


        try {
            ServicoDeResultados resultadosVotacao = (ServicoDeResultados) Naming.lookup("rmi://localhost:2126/resultados");

            Map<String, Integer> resultados = resultadosVotacao.getResultados();

            System.out.println("Resultados: \n");
            for (Map.Entry<String, Integer> resultado : resultados.entrySet()) {
                System.out.println(resultado.getKey() + ": " + resultado.getValue() + " votos");
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

    }
}

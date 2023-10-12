package cliente;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Map;

import server.ServicoDeResultados;

/**
 * A classe ResultadosDeVotacao representa um cliente que obtém e exibe os resultados de uma votação por meio de uma
 * interface de linha de comando. Ela se conecta ao serviço de resultados remoto para buscar os resultados da votação.
 */
public class ResultadosDeVotacao {

    /**
     * O método principal da classe, que permite aos eleitores obter e exibir os resultados da votação.
     *
     * @param args Argumentos da linha de comando (não são utilizados neste caso).
     */
    public static void main(String args[]) {
        try {
            // Procura o serviço de resultados remoto no endereço especificado.
            ServicoDeResultados resultadosVotacao = (ServicoDeResultados) Naming.lookup("rmi://localhost:2126/resultados");

            // Obtém os resultados da votação a partir do serviço de resultados remoto.
            Map<String, Integer> resultados = resultadosVotacao.getResultados();

            // Exibe os resultados da votação.
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

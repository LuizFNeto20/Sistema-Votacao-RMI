package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;

/**
 * A classe ServicoDeResultadosImpl implementa a interface ServicoDeResultados e fornece um serviço para
 * obter os resultados de uma votação através de comunicação remota (RMI).
 */
public class ServicoDeResultadosImpl extends UnicastRemoteObject implements ServicoDeResultados {

    /**
     * Cria uma nova instância de ServicoDeResultadosImpl.
     *
     * @throws RemoteException se ocorrer um erro de comunicação remota durante a criação.
     */
    protected ServicoDeResultadosImpl() throws RemoteException {
        super();
    }

    /**
     * Retorna os resultados da votação atualmente registrados no sistema.
     *
     * @return Um mapa que associa as opções de voto (representadas como strings) aos números de votos registrados.
     */
    @Override
    public Map<String, Integer> getResultados() {
        // Para iniciar devemos deixar como null
        Map<String, Integer> votosComputados = null;

        try {
            // Procura o serviço de votação remoto no endereço especificado.
            ServicoDeVotacao votos = (ServicoDeVotacao) Naming.lookup("rmi://localhost:2126/votacao");

            // Obtém o resultado da votação a partir do serviço de votação remoto.
            ResultadoVotacao resultadoVotacao = votos.getResultado();

            // Obtém o mapa de votos computados a partir do resultado da votação.
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

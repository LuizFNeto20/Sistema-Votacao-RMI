package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * A classe ServidorRMI é responsável por iniciar e configurar o servidor RMI para oferecer serviços de votação remota e
 * consulta de resultados. Ela cria instâncias das implementações das interfaces de serviço e registra esses serviços no
 * registro RMI para torná-los acessíveis a clientes remotos.
 */
public class ServidorRMI {

    /**
     * O método principal da classe, que inicia o servidor RMI e disponibiliza os serviços para acesso remoto.
     *
     * @param args Argumentos da linha de comando (não são utilizados neste caso).
     */
    public static void main(String args[]) {
        try {
            // Cria instâncias dos serviços de votação e resultados.
            ServicoDeVotacao votacao = new ServicoDeVotacaoImpl();
            ServicoDeResultados resultados = new ServicoDeResultadosImpl();

            // Inicializa o registro RMI na porta 2126.
            Registry r = LocateRegistry.createRegistry(2126);

            // Registra os serviços no registro RMI com URLs apropriadas.
            Naming.rebind("rmi://localhost:2126/votacao", votacao);
            Naming.rebind("rmi://localhost:2126/resultados", resultados);

            // Exibe uma mensagem indicando que o servidor está ativo.
            System.out.println("Servidor no ar!");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}

package cliente;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import server.ServicoDeVotacao;

/**
 * A classe Cliente representa um cliente que interage com o sistema de votação por meio de uma interface de linha de comando.
 * Os eleitores podem votar em candidatos e obter resultados da votação usando esta aplicação.
 */
public class Cliente {

    /**
     * Verifica se um nome é válido, ou seja, contém apenas letras e espaços.
     *
     * @param nome O nome a ser validado.
     * @return true se o nome for válido, false caso contrário.
     */
    public static boolean isNomeValido(String nome) {
        return nome.matches("[a-zA-Z ]+");
    }

    /**
     * O método principal da classe, que permite aos eleitores votar em candidatos.
     *
     * @param args Argumentos da linha de comando (não são utilizados neste caso).
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String sair;
        Set<String> eleitores = new HashSet<>();

        do {
            System.out.println("\nBem-vindo ao sistema de votação!\n");
            System.out.println("Para votar, digite seu nome e escolha um candidato pelo número de votação:");

            try {
                // Procura o serviço de votação remoto no endereço especificado.
                ServicoDeVotacao votacao = (ServicoDeVotacao) Naming.lookup("rmi://localhost:2126/votacao");

                System.out.println("Digite seu nome:");
                String nome = sc.nextLine();

                while (!Cliente.isNomeValido(nome)) {
                    System.out.println("Nome inválido. Por favor, digite novamente:");
                    nome = sc.nextLine();
                }

                if (eleitores.contains(nome)) {
                    throw new RemoteException("Eleitor " + nome + " já votou.");
                }

                System.out.println("\nLista de Candidatos: \n");

                // Define os candidatos com números de votação.
                HashMap<Integer, String> candidatos = new HashMap<>();
                candidatos.put(1, "Luiz Ferreira");
                candidatos.put(2, "Marcos Silva");
                candidatos.put(3, "Pablo Ruan");

                for (Map.Entry<Integer, String> entry : candidatos.entrySet()) {
                    System.out.println(
                            "Candidato " + entry.getKey() + ": " + entry.getValue() + " (" + entry.getKey() + ")\n");
                }

                int candidatoEscolhido = 0;
                String candidato = "";
                boolean continuar = true;

                while (continuar) {
                    System.out.println("\nEscolha o candidato pelo número de votação:");
                    candidatoEscolhido = sc.nextInt();
                    sc.nextLine();

                    if (!candidatos.containsKey(candidatoEscolhido)) {
                        System.out.println("Candidato inválido!");
                    } else {
                        candidato = candidatos.get(candidatoEscolhido);
                        continuar = false;
                    }
                }

                // Registra o voto no serviço de votação remoto.
                votacao.votar(nome, candidato);

                // Adiciona o eleitor à lista de eleitores que já votaram.
                eleitores.add(nome);
                System.out.println("\nSeu voto foi computado com sucesso!\n");

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (RemoteException e) {
                System.out.println(e.getMessage());
            } catch (NotBoundException e) {
                e.printStackTrace();
            }

            System.out.println("Digite 'sair' para sair ou qualquer tecla para continuar:");
            sair = sc.nextLine();

            if (sair.equals("sair")) {
                System.out.println("Até mais!");
                break;
            }

        } while (!sair.equals("sair"));

        sc.close();
    }
}

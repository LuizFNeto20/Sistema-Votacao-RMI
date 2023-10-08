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

public class Cliente {

    public static boolean isNomeValido(String nome) {
        return nome.matches("[a-zA-Z ]+");
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        String sair;
        Set<String> eleitores = new HashSet<>();

        do {
            System.out.println("\nBem-vindo ao sistema de votação!\n");
            System.out.println("Para votar, digite seu nome e escolha um candidato pelo número de votação:");

            try {
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

                votacao.votar(nome, candidato);

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

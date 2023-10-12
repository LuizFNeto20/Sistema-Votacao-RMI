## Requisitos

- Java Development Kit (JDK) instalado na máquina.

# Sistema de Votação com RMI

Este é um sistema de votação simples que utiliza o RMI (Remote Method Invocation) para permitir que eleitores votem em candidatos e consultem os resultados da votação de forma remota. A aplicação consiste em duas partes: um servidor RMI que gerencia a votação e uma aplicação cliente que permite aos eleitores votar e consultar os resultados.

## Configuração a partir do git clone
1. Clone este repositório para o diretório desejado
2. Rode o arquivo ServidorRMI.java e a mensagem ```java Servidor no ar!``` será mostrada
3. Rode o arquivo Cliente.java e efetue a votação 
4. Rode o arquivo ResultadosDeVotacao.java para obter os resultados

## Configuração no Eclipse

1. Importe o projeto para o Eclipse:
   - No Eclipse, vá em `File -> Import...`
   - Escolha `Existing Projects into Workspace` e clique em `Next`.
   - Selecione o diretório do projeto e clique em `Finish`.

2. Compile o código:
   - Certifique-se de que o projeto foi importado com sucesso.
   - Abra o projeto no Eclipse e vá para a guia `Project` no menu.
   - Clique em `Clean...` para limpar e construir o projeto.

3. Inicie o servidor RMI:
   - Na estrutura de pastas do projeto, navegue até `src` -> `server` e encontre a classe `ServidorRMI`.
   - Clique com o botão direito do mouse na classe `ServidorRMI` e escolha `Run As -> Java Application`.

4. Inicie os clientes:
   - Navegue até `src` -> `cliente` e encontre a classe `Cliente`.
   - Clique com o botão direito do mouse na classe `Cliente` e escolha `Run As -> Java Application`.
   - Repita este passo para iniciar quantos clientes desejar.

5. Consulte os resultados da votação:
   - Para consultar os resultados da votação, vá até `src` -> `cliente` e encontre a classe `ResultadosDeVotacao`.
   - Clique com o botão direito do mouse na classe `ResultadosDeVotacao` e escolha `Run As -> Java Application`.

## Uso

1. Ao iniciar o cliente, digite seu nome e escolha um candidato pelo número de votação.

2. Consulte os resultados da votação executando a classe `ResultadosDeVotacao`.

## Exemplo

1. Iniciar o servidor RMI no Eclipse:
   - Navegue até a classe `ServidorRMI` em `src` -> `server` e execute como aplicação Java.

2. Iniciar um eleitor no Eclipse:
   - Navegue até a classe `Cliente` em `src` -> `cliente` e execute como aplicação Java.

3. Consultar resultados no Eclipse:
   - Navegue até a classe `ResultadosDeVotacao` em `src` -> `cliente` e execute como aplicação Java.

## Autores

- [Luiz Ferreira](https://github.com/LuizFNeto20)
- [Pablo Ruan](https://github.com/Iamdiaspablo)
- [Marcos Silva](https://github.com/Marcosxx1)

 

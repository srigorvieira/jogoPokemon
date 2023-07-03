package com.mycompany.pokemon;

import com.mycompany.pokemon.model.poke;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;

public class Pokemon {

    public static void main(String[] args) {
        
        //TELA INICIAL COM 4 OPÇÕES, CADASTRAR, BATALHAR, MOSTRAR POKEMON, SAIR
        JOptionPane.showMessageDialog(null, "Selecione uma das opções abaixo: \n\n"
                + "1 - Cadastrar Pokémons. \n"
                + "2 - Batalhar. \n"
                + "3 - Exibir Pokémons. \n"
                + "4 - Sair do jogo.");
    
            //AQUI O USUARIO INFORMA UMA OPÇÃO, A MESMA SERÁ CONVERTIDA E CAÍRA NO SWITCH.
            String input = JOptionPane.showInputDialog("Digite a opção: \n\n");
            int escolha = Integer.parseInt(input);
        
            //VETOR PARA ARMAZENAR AS INFORMAÇÕES DE CADA BICHO
            poke[] pokemons = new poke[2];
            
        do{    
            switch (escolha){          
                case 1 -> {                                                            
                    JOptionPane.showMessageDialog(null, "Cadastrar Pokemons!");
                    
                    //VARIAVEL PRA VALIDAR SE O VETOR TA PREENCHIDO
                    boolean tdsPokemonsCadastrados = false;
                    
                    //LOOP PARA CADASTRARA CADA UM DOS BICHO
                    for(int i = 0; i < pokemons.length; i++){
                        String nome = JOptionPane.showInputDialog("Nome: ");    
                        int forca = Integer.parseInt(JOptionPane.showInputDialog("Força: "));
                        int atk = Integer.parseInt(JOptionPane.showInputDialog("ATK: "));
                        int def = Integer.parseInt(JOptionPane.showInputDialog("DEF: "));
                        int agilidade = Integer.parseInt(JOptionPane.showInputDialog("Agilidade: "));
                        
                        //INSTANCIANDO OS BICHO
                        poke nvPokemon = new poke(nome, forca, atk, def, agilidade);
                        pokemons[i] = nvPokemon;  
                        
                        //O PRIMEIRO IF VALIDA SE FOI PREENCHIDO, O SEGUNDO INFORMA Q DEU CERTO
                       if(i == pokemons.length -1){
                           tdsPokemonsCadastrados = true;
                       } 
                       if(tdsPokemonsCadastrados){
                           JOptionPane.showMessageDialog(null, "Pokémons cadastrados com sucesso!");
                       }
                    } 
                    break;
                }

                case 2 ->{
                    //AQUI SERÁ FEITA A BATALHA COM OS POKEMONS CADASTRADOS
                    
                    //VARIAVEIS COM QUANTIDADE MAXIMA DE JOGADORES E POKEMON POR JOGADOR
                    int jogadores = 2;
                    int pokemonJogadores = 3;
                    
                    //AQUI FICA A FILA
                    Queue<poke>[] filaJogadores = new Queue[jogadores];
                    for(int i = 0; i < jogadores; i++){
                        filaJogadores[i] = new LinkedList<>();
                        
                        JOptionPane.showMessageDialog(null, "Jogador " + (i + 1)
                        + ", selecione 3 pokemons: ");
                        
                        for (int j = 0; j < pokemonJogadores; j++) {
                            String mensagemOpcoes = "Selecione um Pokémon:\n";
                            for (int k = 0; k < pokemons.length; k++) {
                                mensagemOpcoes += (k + 1) + ". " + pokemons[k].getNome() + "\n";
                            }

                            String opcaoSelecionada = JOptionPane.showInputDialog(null, mensagemOpcoes);
                            if (opcaoSelecionada != null) {
                                int indiceSelecionado = Integer.parseInt(opcaoSelecionada) - 1;

                                if (indiceSelecionado >= 0 && indiceSelecionado < pokemons.length) {
                                    poke pokemonSelecionado = pokemons[indiceSelecionado];
                                    filaJogadores[i].add(pokemonSelecionado);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Opção inválida.");
                                    j--;
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Seleção cancelada.");
                                break;
                            }
                        }                           
                    }
                    //MOSTRA OS POKEMONS ESCOLHIDOS
                    for(int i = 0; i < jogadores; i++){
                        String msgPokemon = "Jogador " + (i + 1) + ", Pokemons selecionados: \n";
                        
                        Queue<poke> filaJogador = filaJogadores[i];
                        while (!filaJogador.isEmpty()){
                            poke pokemonSelecionado = filaJogador.poll();
                            msgPokemon += pokemonSelecionado.getNome() + "\n";
                        }
                        
                        JOptionPane.showMessageDialog(null,msgPokemon);
                    }
                    
                    //ESSA PARTE TA DANDO ERRO
//                    for (int i = 0; i < jogadores; i++) {
//                        poke[]  = pokemonJogadores[i];
//                        for (int j = 0; j < pokemonJogadores - 1; j++) {
//                            int indiceMenor = j;
//                            for (int k = j + 1; k < pokemonJogadores; k++) {
//                                if (pokemonsSelecionados[k].getNome().compareTo(pokemonsSelecionados[indiceMenor].getNome()) < 0) {
//                                indiceMenor = k;
//                                }
//                            }
//                            poke temp = pokemonsSelecionados[j];
//                            pokemonsSelecionados[j] = pokemonsSelecionados[indiceMenor];
//                            pokemonsSelecionados[indiceMenor] = temp;
//                        }
//                    }
                    
                }

                case 3 ->{
                    //AQUI SERÃO EXIBIDOS TODOS OS POKEMONS QUE FORAM CADASTRADOS
                    //DA FORMA QUE O ABENÇOADO SELECIONAR
                    JOptionPane.showMessageDialog(null,"Selecione uma das opções abaixo para listar: \n\n"
                            + "1 - Exibir todos os atributos do Pokémon\n"
                            + "2 - Exibir os Pokémons ordenados pelos atributos\n"
                            + "3 - Selecionar um Pokémon\n"
                            + "4 - Sequencial do mano fibonati");

                    //LEITURA DA ESCOLHA DO USUARIO
                    String option = JOptionPane.showInputDialog("Digite a opção: ");
                    int opcao = Integer.parseInt(option);

                    switch (opcao){
                        case 1 ->{
                            //EXIBE TODOS OS ATRIBUTOS DO POKEMON
                            //NÃO ORDENEI PQ Ñ FOI DITO POR QUAL MODO DEVE SER ORDENADO
                            
                            //AQUI PEDE QNTOS POKEMONS SERAO EXIBIDOS
                            String qtdPoke = JOptionPane.showInputDialog("Quantos Pokémons devem ser exibidos?");
                            int quantidade = Integer.parseInt(qtdPoke);
                            
                            //VALIDA SE A QUANTIDADE É VALIDA, SE N FOR O COD AJUSTA
                            if(quantidade > pokemons.length){
                                quantidade = pokemons.length;
                            }
                            
                            for (int i = 0; i < quantidade; i++) {
                            if (pokemons[i] != null) {
                                poke pokemonAtual = pokemons[i];
                                JOptionPane.showMessageDialog(null,"Pokemon " + (i+1)+ ": \n"
                                + "NOME: " + pokemonAtual.getNome() + "\n"
                                + "FORÇA: " + pokemonAtual.getForca() + "\n"
                                + "ATK: " + pokemonAtual.getAtk() + "\n"
                                + "DEF: " + pokemonAtual.getDef() + "\n"
                                + "AGILIDADE: " + pokemonAtual.getAgilidade());
                            }
                        }
                            break;
                        }

                        case 2 ->{
                            //EXIBE OS POKEMONS ORDENADO PELOS ATRIBUTOS
                            //SOLICITA AO USUARIO QUAL ATRIBUTO
                            String qualStts = JOptionPane.showInputDialog("Por qual atributo deseja ordenar? \n\n"
                                    + "1 - FORÇA \n"
                                    + "2 - ATK \n"
                                    + "3 - DEF \n"
                                    + "4 - AGILIDADE");
                            int atributo = Integer.parseInt(qualStts);
                            
                            //TESTE COM BUBLE SORT
                                for(int i = 0; i < pokemons.length - 1; i++){
                                    for(int j = 0; j < pokemons.length - i -1; j++){
                                        if(pokemons[j] != null && pokemons[j+1] != null){
                                        }
                                    }
                                }          
                                
                            switch (atributo){                                                
                                case 1 ->{
                                    int j = 0;
                                    //ORDENAÇÃO PELA FORCA
                                    if(pokemons[j].getForca() < pokemons[j + 1].getForca()){
                                       //TROCA
                                       poke aux = pokemons[j];
                                       pokemons[j] = pokemons [j + 1];
                                       pokemons[j + 1] = aux;
                                    }
                                    break;
                                }
                                
                                case 2 ->{
                                    int j = 0;
                                    //ORDENAÇÃO PELO ATK
                                    if(pokemons[j].getAtk() < pokemons[j + 1].getAtk()) {
                                        //TROCA
                                        poke aux = pokemons[j];
                                        pokemons[j] = pokemons[j + 1];
                                        pokemons[j + 1] = aux;
                                    }
                                    break;
                                }

                                case 3 ->{
                                    //ORDENANDO PELA DEF
                                    int j = 0;
                                    if(pokemons[j].getDef() < pokemons[j + 1].getDef()){
                                        //TROCA
                                        poke aux = pokemons[j];
                                        pokemons[j] = pokemons[j + 1];
                                        pokemons[j + 1] = aux;
                                    }
                                    break;
                                }
                                
                                case 4 ->{
                                    //ORDENANDO PELA AGIL ---*N SEI PQ TEM Q USA A VARIAVEL J MAS TA FUNCIONANDO FILÉ*
                                    int j = 0;
                                    if(pokemons[j].getDef() < pokemons[j + 1].getDef()){
                                        //TROQUINHA DNV
                                        poke aux = pokemons[j];
                                        pokemons[j] = pokemons [j + 1];
                                        pokemons[j + 1] = aux;
                                    }
                                    break;
                                }
                            }    
                                    int i = 0;
                                    // MOSTRA OS ATRIBUTOS DOS POKEMON DO MAIOR PRO MENOR
                                    for (i = 0; i < pokemons.length; i++) {
                                        if (pokemons[i] != null) {
                                             poke pokemonAtual = pokemons[i];
                                             JOptionPane.showMessageDialog(null,
                                            "Pokemon " + (i + 1) + ": \n"
                                            + "NOME: " + pokemonAtual.getNome() + "\n"
                                            + "FORÇA: " + pokemonAtual.getForca() + "\n"
                                            + "ATK: " + pokemonAtual.getAtk() + "\n"
                                            + "DEF: " + pokemonAtual.getDef() + "\n"
                                            + "AGILIDADE: " + pokemonAtual.getAgilidade() + "\n"
                                            );
                                        }   
                                    }
                            break;
                        }
                        
                        case 3 ->{
                            //SELECIONA O POKEMON E MOSTRA ELE
                            String selecionaPokemon = JOptionPane.showInputDialog("Qual Pokémon deseja selecionar?");
                            int selecionado = Integer.parseInt(selecionaPokemon);
                            
                            boolean achou = false;
                            int indiceAchou = -1;
                            
                            //PESQUISA LINEAR                          
                            for (int i = 0; i < pokemons.length; i++){
                                if( i + 1 == selecionado){
                                    achou = true;
                                    indiceAchou = i;
                                    break;
                                }
                            }
                            
                            //VALIDA SE ACHO O POKEMON OU NAO
                            if(achou){
                                poke pokemonEncontrado = pokemons[indiceAchou];
                                String msg = "Pokemon encontrado: \n"
                                           + "NOME: " + pokemonEncontrado.getNome() + "\n"
                                           + "FORÇA: " + pokemonEncontrado.getForca() + "\n"
                                           + "ATK: " + pokemonEncontrado.getAtk() + "\n"
                                           + "DEF " + pokemonEncontrado.getDef() + "\n"
                                           + "AGILIDADE: " + pokemonEncontrado.getAgilidade();
                                JOptionPane.showMessageDialog(null, msg);
                            } else{
                                JOptionPane.showMessageDialog(null, "Pokemon não encontrado!!");
                            }                          
                            break;
                        }

                        case 4 ->{
                            //fibonacci
                            break;
                        }
                    }

                    break;
                }

                case 4 ->{
                    JOptionPane.showMessageDialog(null, "O jogo será encerrado!");
                    break;
                }
            }
            escolha = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção: \n"
                + "1 - Cadastrar Pokémons. \n"
                + "2 - Batalhar. \n"
                + "3 - Exibir Pokémons. \n"
                + "4 - Sair do jogo."));
            
            if(escolha == 4){
                break;
            }
            
        } while(true);        
    }         
}
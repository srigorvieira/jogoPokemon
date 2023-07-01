package com.mycompany.pokemon;

import com.mycompany.pokemon.model.poke;
import javax.swing.JOptionPane;

public class Pokemon {

    private static String input;

    @SuppressWarnings("empty-statement")
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
            poke[] pokemons = new poke[3];
            
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
                    JOptionPane.showMessageDialog(null,"Hora da batalha!!!");
                    break;
                }

                case 3 ->{
                    //AQUI SERÃO EXIBIDOS TODOS OS POKEMONS QUE FORAM CADASTRADOS
                    //DA FORMA QUE O ABENÇOADO DESEJAR
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
                                for(int i = 0; i < pokemons.length - 1; i ++){
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
                            //seleciona um pokemon
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
            escolha = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção: "
                + "1 - Cadastrar Pokémons. \n"
                + "2 - Batalhar. \n"
                + "3 - Exibir Pokémons. \n"
                + "4 - Sair do jogo."));
        } while(true);        
    }         
}
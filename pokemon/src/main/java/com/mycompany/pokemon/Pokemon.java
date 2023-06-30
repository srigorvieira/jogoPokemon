package com.mycompany.pokemon;

import com.mycompany.pokemon.model.poke;
import javax.swing.JOptionPane;

public class Pokemon {

    private static String input;

    public static void main(String[] args) {
        
        //TELA INICIAL COM 4 OPÇÕES, CADASTRAR, BATALHAR, MOSTRAR POKEMON, SAIR
        JOptionPane.showMessageDialog(null, "Selecione uma das opções abaixo para jogar: \n\n"
                + "1 - Cadastrar pokemons. \n"
                + "2 - Batalhar. \n"
                + "3 - Exibir pokemons. \n"
                + "4 - Encerrar");
       
        //AQUI O USUARIO INFORMA UMA OPÇÃO, A MESMA SERÁ CONVERTIDA E CAÍRA NO SWITCH.
        String input = JOptionPane.showInputDialog("Digite qual opção deseja:");
        int escolha = Integer.parseInt(input);
        
        switch (escolha){
            
            case 1 -> {
                //VETOR PARA ARMAZENAR AS INFORMAÇÕES DE CADA BICHO
                poke[] pokemons = new poke[20];
                
                //LOOP PARA CADASTRARA CADA UM DOS BICHO
                JOptionPane.showMessageDialog(null, "Cadastrar Pokemons!");
                
                for(int i = 0; i < pokemons.length; i++){
                    
                    String nome = JOptionPane.showInputDialog("Nome: ");
                    
                    int forca = Integer.parseInt(JOptionPane.showInputDialog("Força: "));
                    int atk = Integer.parseInt(JOptionPane.showInputDialog("ATK: "));
                    int def = Integer.parseInt(JOptionPane.showInputDialog("DEF: "));
                    int agilidade = Integer.parseInt(JOptionPane.showInputDialog("Agilidade: "));
                    break;
                } 
            }
            
            case 2 ->{
                //AQUI SERÁ FEITA A BATALHA COM OS POKEMONS CADASTRADOS
                JOptionPane.showMessageDialog(null,"Hora da batalha!!!");
                break;
            }
            
            case 3 ->{
                //AQUI SERÃO EXIBIDOS TODOS OS POKEMONS QUE FORAM CADASTRADOS
                //DA FORMA QUE O ABENÇOADO DESEJAR
                JOptionPane.showMessageDialog(null,"Selecione como deseja listar os pokémons: \n"
                        + "1 - Exibir todos os atributos\n"
                        + "2 - Exibis os poke ordenados pelos atributos\n"
                        + "3 - Selecionar um pokemon\n"
                        + "4 - Sequencial do mano fibonati");
                
                //LEITURA DA ESCOLHA DO USUARIO
                
                break;
            }
            
            case 4 ->{
                JOptionPane.showMessageDialog(null, "O jogo será encerrado!");
                break;
            }
        }
            
    }
}
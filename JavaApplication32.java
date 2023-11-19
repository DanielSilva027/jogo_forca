/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication32;

import java.util.Scanner;

/**
 *
 * @author samue
 */
public class JavaApplication32 {
    public static Scanner in = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here      
        String dicionarioPalavras[] = {"IFES", "MARCOS","PROGRAMAÇAO","DANIEL","AUTOMAÇAO","ELETRICA","PORTOS","GHITHUB","JAVA","MECANICA"};
        
        char resultadoAtual[];
        char entradaUser;
        
        int errosUser = 5;
        int escolha = 0;
        
        
        System.out.print("Escolha um numero de 1 a 10 para ser direcionada uma"
                + " palvra: ");
        escolha = in.nextInt() - 1;
        
        System.out.println("");
        
        resultadoAtual = new char[dicionarioPalavras[escolha].length()];
        
        for(int i = 0; i < resultadoAtual.length; i++) resultadoAtual[i] = '_';
        
        do{
            printResultado(resultadoAtual, errosUser);
            entradaUser = getUserInput();
            
            if (!existChar(dicionarioPalavras[escolha], resultadoAtual, entradaUser)) errosUser--;
            
        }while(conferindoResultado(resultadoAtual) && errosUser != 0);
        
        if (errosUser == 0){
            System.out.println("\nVoce perdeu! '_'");
            
        } else{
            printResultado(resultadoAtual, errosUser);
            System.out.println("Voce ganhou!!");
        }
    }
    
    
    public static void printResultado (char resultadoAtual[], int erro){
        String text = "";
        
        for (int i = 0; i < resultadoAtual.length; i++) {
            text = text + resultadoAtual[i] + ' ';
        }
        
        System.out.println("chances restantes: " + erro);
        System.out.println("palavra: " + text + "\n");
    }
    
    public static boolean conferindoResultado (char resultadoAtual[]){
        boolean resp = false;
        
        for(int i = 0; i < resultadoAtual.length; i++){
            if (resultadoAtual[i] == '_'){
                resp = true;
                break;
            }
        }
        
        return resp;
    }
    
    public static char getUserInput (){
        String inputUser;
        char result;
        
        System.out.print("digite uma letra: ");
        inputUser = in.next();

        inputUser = inputUser.toUpperCase();
        result = inputUser.charAt(0);
        
        return result;
    }
    
    public static boolean existChar(String palavra, char lista[], char letra){
        boolean verificacao = false;
        
        for(int i = 0; i < palavra.length(); i++){
            if (palavra.charAt(i) == letra){
               lista[i] = letra;
               verificacao = true;
            }
        }
            
        return verificacao;
    }     
}
package com.example;
//Recurso necessário para usar o Scanner, muito importante pra que possamos
//"passear" pelos caracteres da palavra.
import java.util.Scanner;
/**
 * 
 *
 * Task here is to implement a function that says if a given string is
 * palindrome.
 * 
 * 
 * 
 * Definition=> A palindrome is a word, phrase, number, or other sequence of
 * characters which reads the same backward as forward, such as madam or
 * racecar.
 */
public class TASK1 {
     //Pode ser criado um booleano, pois, nesse caso "Ou é ou não é"
     public static void main (String[] args) {
        //Instanciando um objeto do tipo Scanner para ler a entrada que é fornecida pelo usuário.
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite uma palavra: ");

        //Após a lida de entrada, iremos armazenar a próxima linha
        String palavra = scanner.nextLine();

        //Agora precisamos de uma função para mudar a posição das letras

        if (isPalindrome(palavra)){
         System.out.println("A palavra: " + palavra + " é um palindromo!");
        }
        else {
         System.out.println("A palavra '" + palavra + "' não é um palindromo!");
        }

     }

    //Função criada com o intuito de verificar se é ou não.
     public static boolean isPalindrome (String varredura) {
         /*Uma variável criada para controlar/modificar todos os caracteres que não são letras ou números e retirar
         os espaços  e colocar tudo em letras minúsculas.*/

      varredura = varredura.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

      //Método para percorrer a palavra de trás pra frente. Indo com o 'i' e voltando na ultima posição com 'j'.
      for(int i = 0, j = varredura.length() - 1; i < j; i++,j--) {
          //Caso o caracter seja diferente ela já retorna falso
          if(varredura.charAt(i) != varredura.charAt(j)){
              return false ;
          }
      }

      return true;
  }
  

}
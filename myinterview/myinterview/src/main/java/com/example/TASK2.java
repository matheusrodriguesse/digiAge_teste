package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Task here is to write a list. Each element must know the element before and
 * after it. Print out your list and them remove the element in the middle of
 * the list. Print out again.
 *
 */


public class TASK2 {
    public static void main(String[] args) {
        //Instanciando um objeto do tipo Scanner para ler a entrada que é fornecida pelo usuário.
        Scanner scanner = new Scanner(System.in);

        //Criando uma lista vazia
        List<String> lista = new ArrayList<>();

        //O usuário vai acrescentar o número de itens que quiser
        while (true){
            System.out.println("Digite um elemento ou 'fim' para sair: ");
            //Momento que armazena o item do usuário
            String item = scanner.nextLine();

            //Comando para encerrar a lista
            if (item.equals("fim")){
                break;
            }
            //Adiciona as palavras a lista
            lista.add(item);

        }

        //Um print para mostrar os itens gerados
        System.out.println("Lista original é: ");

        //Para imprimir cada elemento da lista
        for (String item : lista){

            System.out.println(item);
        }
        //Iniciamos uma variável com o tamanho original da lista
        int itens = lista.size();
        //Caso a lista seja impar
        if (itens %2 == 1) {
            //Remove o item que está na posição específica
            lista.remove(itens / 2);
        }
        //Caso seja par, é necessário retirar dois elementos
        else {
            int centroDireito = (itens/2);
            lista.remove(centroDireito);
            int centroEsquerdo = (itens/2) - 1;
            lista.remove(centroEsquerdo);

        }

        //Apresentação da nova lista com os itens retirados;
        System.out.println("A nova lista é: ");

        //Impressão dos itens que sobraram
        for (String item : lista) {
            System.out.println(item);
        }
    }
}
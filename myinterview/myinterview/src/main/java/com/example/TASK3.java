package com.example;
import java.util.ArrayList;
import java.util.*;

/**
 * Write a list and add an aleatory number of Strings. In the end, print out how
 * many distinct itens exists on the list.
 *
 */
public class TASK3 {
    public static void main(String[] args) {

        //Criando um objeto para gerar um número aleatório para gerar uma quantidade aleatória de itens
        Random random = new Random();
        //Criando uma lista onde os itens serão futuramente incluídos
        List<String> lista = new ArrayList<>();
        //Gerando a quantidade randômica. Esse 2 é caso o número seja 0 ou 1 e não haja comparação.
        int n = random.nextInt(9) +2;
        //Instanciando um objeto do tipo Scanner para ler a entrada que é fornecida pelo usuário.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite " + n + " nomes de objetos: ");

        //Para contar os itens que não se repetem, devemos armazenar num conjunto de elementos unicos, o Hashset
        Set <String> conjunto = new HashSet<>();


        //Laço para inclusão de itens
        for(int i = 0; i < n; i++){
            String nome = scanner.nextLine();
            //Verificação para remoção de espaços em branco e sem dados
            if(!nome.trim().isEmpty()) {
                //Adicionando o nome na lista
                lista.add(nome);
                //Adicionando os elementos e "filtrando" os distintos
                conjunto.add(nome);
            }
        }

        //Apresentando os resultados
        System.out.println("A lista possui "+ lista.size()+" itens. O conjunto de nomes distintos são de: " +conjunto.size()+" unidades.");
        System.out.println();
        System.out.println("Que são: ");
        System.out.println(conjunto);


    }
  
}

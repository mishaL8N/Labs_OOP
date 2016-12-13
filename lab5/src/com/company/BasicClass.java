package com.company;

import java.util.Scanner;


public class BasicClass {

    public static void main(String[] add) {
       Scanner scan = new Scanner(System.in);
        Main ma = new Main();
        String Person;
        boolean x = true;
        while(x) {
            System.out.println("1 - ВВЕСТИ ВЕРШИНУ");
            System.out.println("2 - ВВЕСТИ ЗВ'ЯЗОК");
            System.out.println("3 - ВИВЕСТИ ГРАФ");
            System.out.println("4 - ЗНАЙТИ ВЕРШИНУ ПО ID");
            System.out.println("5 - ВИЙТИ");
            int k = scan.nextInt();
            if(k==1){System.out.println("Введіть вершину");
                Person = scan.next();
                ma.addVertex(Person);
            } else {
                if (k == 2) {
                    System.out.println("Введіть першу вершину");
                    String Person1 = scan.next();
                    System.out.println("Введіть другу вершину");
                    String Person2 = scan.next();
                    ma.addEdge(Person1, Person2);
            } else {
                if (k == 3) {
                    ma.Enter();
            } else{
                    if(k==4){
                        //int Persson = scan.nextInt();
                        ma.Search();
                    } else{
                x=false;
                }
                }
                }
            }
        }
    }
}



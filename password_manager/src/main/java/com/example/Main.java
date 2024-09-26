package com.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean finish = false;
        ArrayList<Credential> credentials = new ArrayList<Credential>();
        Scanner scanner = new Scanner(System.in);

        while(!finish){

            System.out.println("""
            OPTIONS:
            1 - Get credential
            2 - Insert credential
            3 - Update credential
            4 - Delete credential
            5 - Exit
            """);
            
            int option = scanner.nextInt();

            switch(option){
                case 1, 2, 3, 4, 5 -> finish = true;
                default -> System.out.println("Insert a valid option!");
            }
        }

        scanner.close();
    }
}
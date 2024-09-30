package com.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean finish = false;
        ArrayList<Credential> credentials = new ArrayList<Credential>();
        Scanner scanner = new Scanner(System.in);
        
        enum Options{
            Get,
            Insert,
            Update,
            Delete,
            Exit,
            Invalid
        }

        while(!finish){

            System.out.println("""
            OPTIONS:
            1 - Get credential
            2 - Insert credential
            3 - Update credential
            4 - Delete credential
            5 - Exit
            """);
            
            Options option = switch( scanner.nextInt() ){
                case 1 -> Options.Get;
                case 2 -> Options.Insert;
                case 3 -> Options.Update;
                case 4 -> Options.Delete;
                case 5 -> Options.Exit;
                default -> Options.Invalid;
            };

            if(option == Options.Exit){ finish = true;}
            else if(option == Options.Insert){
                scanner.useDelimiter(System.lineSeparator());

                System.out.println("Whats the credential name?");
                String name = scanner.next();

                System.out.println("Whats the credential password?");
                String password = scanner.next();

                Credential cred = new Credential(name, password);
                credentials.add(cred);
            }
            else if(option == Options.Invalid){ System.out.println("Insert a valid option!"); }
        }

        scanner.close();
    }
}
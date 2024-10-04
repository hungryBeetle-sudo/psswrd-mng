package com.example;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        boolean finish = false;
        ArrayList<Credential> credentials = new ArrayList<Credential>();
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter(System.lineSeparator());

        enum Options {
            Get,
            Insert,
            Update,
            Delete,
            Exit,
            Invalid
        }

        while (!finish) {

            System.out.println("""
            OPTIONS:
            1 - Get credential
            2 - Insert credential
            3 - Update credential
            4 - Delete credential
            5 - Exit
            """);

            Options option = switch (scanner.nextInt()) {
                case 1 -> Options.Get;
                case 2 -> Options.Insert;
                case 3 -> Options.Update;
                case 4 -> Options.Delete;
                case 5 -> Options.Exit;
                default -> Options.Invalid;
            };

            if (option == Options.Exit) { finish = true; }
            else if (option == Options.Get) {
                System.out.println("What is the credential name?");
                String name = scanner.next();
                Credential credential = null;

                for(Credential c : credentials){
                    if(c.getName().equals(name)) {
                        credential = c;
                        break;
                    }
                }

                if (Objects.nonNull(credential)){
                    String response = "NAME: %s\nPASSWORD: %s";
                    String formattedString = String.format(response, credential.getName(), credential.getPassword());

                    System.out.println(formattedString + "\nPress ENTER to return to menu.");
                    scanner.next();
                } 
                else{
                    System.out.println("No credentials found.\nPress ENTER to return to menu.");
                }
            } 
            else if (option == Options.Insert) {
                System.out.println("What is the credential name?");
                String name = scanner.next();

                System.out.println("What is the credential password?");
                String password = scanner.next();

                Credential cred = new Credential(name, password);
                credentials.add(cred);
            }
            else if(option == Options.Update){
                System.out.println("What is the credential name?");
                String name = scanner.next();

                for(Credential c : credentials){
                    if(c.getName().equals(name)){
                        System.err.println("What's the new password?");
                        String password = scanner.next();
                        c.setPassword(password);
                        break;
                    }
                }

                System.out.println("Password updated!");
            }
            else if (option == Options.Invalid) {
                System.out.println("Insert a valid option!");
            }
        }

        scanner.close();
    }
}
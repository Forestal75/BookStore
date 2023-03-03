package com.Gabor.bookstore;

import java.util.Scanner;

public class View {

    Controller controller;

    public void mainMenu(Scanner sc) {
        String option = "abcd";
        do {
            switch (option) {
                case "i" -> controller.initBooksAndAuthorsAndStores();

                case "anb" -> {
                    System.out.println("Please give me the title of the book: ");
                    String title = sc.nextLine();
                    System.out.println("Please give me the author of the book: ");
                    String author = sc.nextLine();
                    System.out.println("Please give me the ISBN number: ");
                    String isbn = sc.nextLine();

                    controller.addBook(title, author, isbn);
                }

                case "ana" -> {
                    System.out.println("Please give me the name of the author");
                    String authorName = sc.nextLine();
                    controller.addAuthor(authorName, " ");
                }

                case "da" -> {
                    System.out.println("Please give me the author ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    controller.deleteAuthor(id);
                }

                default -> {
                    if (!option.equalsIgnoreCase("xyxy")) {
                        System.out.println("Let's get down to business!");
                    }
                }
            }

            printMenu();
            System.out.println();
            System.out.println("It's your turn!");

        } while (!"q".equalsIgnoreCase(option = sc.nextLine()));
    }

            public void printMenu() {
                System.out.println("=".repeat(30));
                System.out.println("\tInitializing - (i)");
                System.out.println("\tQuit - (q)");
                System.out.println("=".repeat(30));
            }

    }


package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ActivityJournal journal = new ActivityJournal();
        journal.initialize();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("--- Menu ---");
            System.out.println("1. Ajouter une activité");
            System.out.println("2. Afficher les activités");
            System.out.println("3. Sauvegarder en binaire");
            System.out.println("4. Lire le fichier binaire");
            System.out.println("5. Quitter");
            System.out.print("Choisissez une option : ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Entrez une description de l'activité : ");
                    String activity = scanner.nextLine();
                    journal.addActivity(activity);
                    break;
                case 2:
                    journal.displayActivities();
                    break;
                case 3:
                    journal.saveToBinary();
                    break;
                case 4:
                    journal.readFromBinary();
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Option invalide. Veuillez réessayer.");
            }
        } while (choice != 5);

        scanner.close();
    }
}

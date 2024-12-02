package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Annuaire annuaire = new Annuaire();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Ajouter un contact");
            System.out.println("2. Lister les contacts");
            System.out.println("3. Rechercher un contact");
            System.out.println("4. Quitter");
            System.out.print("Choisissez une option : ");

            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    System.out.print("Entrez le nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Entrez le numéro de téléphone : ");
                    String numero = scanner.nextLine();
                    Personne personne = new Personne(nom, numero);
                    annuaire.ajouterContact(personne);
                    System.out.println("Contact ajouté !");
                    break;

                case 2:
                    System.out.println("Liste des contacts :");
                    annuaire.listerContacts();
                    break;

                case 3:
                    System.out.print("Entrez le nom à rechercher : ");
                    String rechercheNom = scanner.nextLine();
                    Personne contactTrouve = annuaire.rechercherContactParNom(rechercheNom);
                    if (contactTrouve != null) {
                        System.out.println("Contact trouvé : " + contactTrouve);
                    } else {
                        System.out.println("Aucun contact trouvé avec ce nom.");
                    }
                    break;

                case 4:
                    System.out.println("Au revoir !");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Choix invalide, réessayez.");
            }
        }
    }
}

package org.example;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private static final String CHARACTER_FILE = "characters.dat";
    private static final String MONSTER_FILE = "monsters.txt";
    private static final String EVENT_FILE = "events.txt";
    private static final String JOURNAL_FILE = "journal.txt";

    private Character player;
    private final List<String> journal = new ArrayList<>();

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Bienvenue dans le jeu d'aventure textuelle ! ---");
        System.out.println("1. Créer un nouveau personnage");
        System.out.println("2. Charger un personnage existant");
        System.out.println("Choisissez une option : ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            createCharacter(scanner);
        } else if (choice == 2) {
            loadCharacter(scanner);
        } else {
            System.out.println("Option invalide !");
            return;
        }

        playGame(scanner);
        saveJournal();
    }

    private void createCharacter(Scanner scanner) {
        System.out.print("Entrez le nom de votre héros : ");
        String name = scanner.nextLine();
        System.out.print("Entrez la force (1-100) : ");
        int strength = scanner.nextInt();
        System.out.print("Entrez la santé (1-100) : ");
        int health = scanner.nextInt();

        player = new Character(name, strength, health);
        saveCharacter(player);
        System.out.println("Personnage créé avec succès et sauvegardé.");
    }

    private void saveCharacter(Character character) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(CHARACTER_FILE))) {
            out.writeObject(character);
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde du personnage : " + e.getMessage());
        }
    }

    private void loadCharacter(Scanner scanner) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(CHARACTER_FILE))) {
            player = (Character) in.readObject();
            System.out.println("Personnage chargé : " + player);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erreur lors du chargement du personnage : " + e.getMessage());
        }
    }

    private void playGame(Scanner scanner) {
        Random random = new Random();
        List<String> events = loadEvents();
        List<Character> monsters = loadMonsters();

        System.out.println("--- Début de l'aventure ---");

        for (int i = 0; i < 5; i++) {
            String event = events.get(random.nextInt(events.size()));
            journal.add("Événement : " + event);
            System.out.println("Événement : " + event);

            if (event.contains("monstre")) {
                Character monster = monsters.get(random.nextInt(monsters.size()));
                System.out.println("Action : Combat contre " + monster.getName());
                if (player.getStrength() > monster.getStrength()) {
                    System.out.println("Résultat : Vous avez battu le monstre !");
                    journal.add("Résultat : Victoire contre " + monster.getName());
                } else {
                    System.out.println("Résultat : Le monstre vous a blessé !");
                    player.setHealth(player.getHealth() - 20);
                    journal.add("Résultat : Blessé par " + monster.getName());
                }
            } else if (event.contains("coffre")) {
                System.out.println("Action : Ouvrir");
                System.out.println("Résultat : Le coffre était piégé !");
                player.setHealth(player.getHealth() - 10);
                journal.add("Résultat : Perte de 10 points de santé.");
            }
        }

        System.out.println("--- Fin de l'aventure ---");
        System.out.println("Votre santé restante : " + player.getHealth());
        journal.add("Santé finale : " + player.getHealth());
    }

    private List<String> loadEvents() {
        try {
            return Files.readAllLines(Paths.get(EVENT_FILE));
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement des événements : " + e.getMessage());
            return new ArrayList<>();
        }
    }

    private List<Character> loadMonsters() {
        List<Character> monsters = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(MONSTER_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                monsters.add(new Character(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
            }
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement des monstres : " + e.getMessage());
        }
        return monsters;
    }

    private void saveJournal() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(JOURNAL_FILE))) {
            for (String entry : journal) {
                writer.write(entry);
                writer.newLine();
            }
            System.out.println("Journal de l'aventure enregistré dans : " + JOURNAL_FILE);
        } catch (IOException e) {
            System.err.println("Erreur lors de l'enregistrement du journal : " + e.getMessage());
        }
    }
}

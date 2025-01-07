package org.example;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ActivityJournal {

    private static final String TEXT_FILE_PATH = "journal.txt";
    private static final String BINARY_FILE_PATH = "journal_backup.dat";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void initialize() {
        File file = new File(TEXT_FILE_PATH);
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("Fichier journal.txt créé !");
                }
            } catch (IOException e) {
                System.err.println("Erreur lors de la création du fichier : " + e.getMessage());
            }
        } else {
            System.out.println("Fichier journal.txt déjà existant.");
        }
    }

    public void addActivity(String activity) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEXT_FILE_PATH, true))) {
            String timestamp = LocalDateTime.now().format(DATE_FORMATTER);
            writer.write(timestamp + " - " + activity);
            writer.newLine();
            System.out.println("Activité ajoutée avec succès !");
        } catch (IOException e) {
            System.err.println("Erreur lors de l'ajout de l'activité : " + e.getMessage());
        }
    }

    public void displayActivities() {
        try (BufferedReader reader = new BufferedReader(new FileReader(TEXT_FILE_PATH))) {
            System.out.println("--- Journal des Activités ---");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }

    public void saveToBinary() {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(TEXT_FILE_PATH));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(BINARY_FILE_PATH))) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            System.out.println("Journal sauvegardé en binaire dans : " + BINARY_FILE_PATH);
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde binaire : " + e.getMessage());
        }
    }

    public void readFromBinary() {
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(BINARY_FILE_PATH))) {
            System.out.println("--- Contenu du Fichier Binaire ---");
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, bytesRead));
            }
            System.out.println();
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier binaire : " + e.getMessage());
        }
    }
}

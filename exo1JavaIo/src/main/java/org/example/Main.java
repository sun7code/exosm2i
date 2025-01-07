package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Exercice : Manipulation de Fichiers");

        String inputFilePath = "input.txt";
        String outputFilePath = "result.txt";
        String wordToSearch = "Java";

        FileHandler textFileHandler = new FileHandler();

        int count = textFileHandler.countLinesWithWord(inputFilePath, wordToSearch);
        System.out.println("Nombre de lignes contenant '" + wordToSearch + "' : " + count);

        String result = "Nombre de lignes contenant '" + wordToSearch + "' : " + count;
        textFileHandler.writeToFile(outputFilePath, result);
    }
}

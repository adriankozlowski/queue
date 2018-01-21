package pl.sda;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    /**
     * Kolejka zadań
     */
    private static Queue queue = new Queue();

    /**
     * Skaner dostępny we wszystkich metodach tej klasy
     * Czyta z klawiatury.
     */
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        readFile();

        showMenu();

        String choose = scanner.nextLine();

        switch (choose) {
            case "1":
                addTask();
                break;
            case "2":
                executeTask();
                break;
            case "3":
                exitProgram();
                break;
        }

    }

    private static void readFile() {

    }

    private static void exitProgram() {

    }

    private static void executeTask() {

    }

    /**
     * Pokazuje menu <br>
     * 1. Dodaj zadanie <br>
     * 2. Wykonaj zadanie <br>
     * 3. Zamknij program <br>
     */
    private static void showMenu() {
        System.out.println("1. Dodaj zadanie");
        System.out.println("2. Wykonaj zadanie.");
        System.out.println("3. Zamknij program");
    }

    /**
     * @return
     */
    private static void addTask() {
        Task task = new Task();
        DateTimeFormatter isoLocalDate = DateTimeFormatter.ISO_LOCAL_DATE;
        System.out.println("Podaj tytuł zadania");
        task.setTitle(scanner.nextLine());
        System.out.println("Podaj datę wykonania zadania (yyyy-mm-dd)");

        while (true) {
            try {
                LocalDate parse = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE);
                task.setExecuteDate(parse);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Nieprawidłowy format daty. Spróbuj YYYY-MM-DD");
            }
        }

        task.setCreationDate(LocalDate.now());


    }
}

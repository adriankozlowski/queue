package pl.sda;

import java.util.Date;
import java.util.Scanner;

public class Main {
    /**
     * Kolejka zadań
     */
    private static Queue queue = new Queue();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
        Scanner scanner = new Scanner(System.in);
        Task task = new Task();
        System.out.println("Podaj tytuł zadania");
        task.setTitle(scanner.nextLine());
        task.setCreationDate(new Date());
        task.setExecuteDate(new Date());
    }
}

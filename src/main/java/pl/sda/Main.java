package pl.sda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    /**
     * Kolejka zadań
     */
    private static Queue queue;

    /**
     * Skaner dostępny we wszystkich metodach tej klasy
     * Czyta z klawiatury.
     */
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        queue = new Queue();
        readFile();
        try {
            saveToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        do {
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
        } while (true);
    }

    /**
     * odczytuje z pliku
     */
    private static void readFile() {
        //Pobieram ścieżkę do pliku queuetask.csv
        Path path = Paths.get("queuetask.csv");
        //sprawdzam, czy plik ze ścieżki istnieje
        if (Files.exists(path)) {
            try {
                //Odczytuje wszystkie linie z tego pliku do kolekcji stringów.
                List<String> lines = Files.readAllLines(path);
                //iteruję po kolekcji
                for (String line : lines) {
                    //dzielę całą linię na fragmenty przedzielone średnikiem
                    String[] split = line.split(";");
                    //tworzę obiekt taska
                    Task task = new Task();
                    //wkładam el. 0-owy do tytułu
                    task.setTitle(split[0]);
                    task.setCreationDate(LocalDate.parse(split[1], DateTimeFormatter.ISO_LOCAL_DATE));
                    task.setExecuteDate(LocalDate.parse(split[2], DateTimeFormatter.ISO_LOCAL_DATE));
                    //dodaję do kolejki.
                    queue.offer(task);
                }
            } catch (IOException e) {
                System.out.println("problem z odczytem pliku. Kolejka zostanie usunięta i zastąpiona nową");
            }
        }
    }

    private static void exitProgram() {
        try {
            saveToFile();
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Zapis do pliku
     *
     * @throws IOException
     */
    private static void saveToFile() throws IOException {
        //pobieram iterator
        Iterator iterator = queue.iterator();
        //tworzę listę pomocniczą
        ArrayList<String> stringArrayList = new ArrayList<String>();
        //sprawdzam czy jest coś wartego przeiterowania
        while (iterator.hasNext()) {
            //pobieram następny/pierwszy
            Task next = (Task) iterator.next();
            //korzystając z toString klasy Task zapisuję element do listy pomocniczej
            stringArrayList.add(next.toString());
        }
        //linie listy pomocniczej zapisane do pliku
        Files.write(Paths.get("queuetask.csv"), stringArrayList, StandardOpenOption.CREATE);
    }

    private static void executeTask() {
        Task task = (Task) queue.poll();
        System.out.println("Zadanie " + task.getTitle() + " zostało wykonane");
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
     * Pyta uzytkownika o dane do zadania i dodaje je do kolejki
     */
    private static void addTask() {
        Task task = new Task();
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

        queue.offer(task);
        System.out.println("tutuaj");
    }
}

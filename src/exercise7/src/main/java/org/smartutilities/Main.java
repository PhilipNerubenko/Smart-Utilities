package org.smartutilities;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputPath = new Scanner(System.in);
        String path = inputPath.nextLine();
        InputStream inputStream = Main.class.getResourceAsStream("/filesForReading/" + path);
        inputPath.close();
        if (inputStream == null) {
            System.out.println("Input error. File doesn't exist");
            return;
        }

        Scanner scanner = new Scanner(inputStream).useLocale(Locale.US);

        int count = readInt(scanner);

        scanner.nextLine();

        if (count <= 0) {
            System.out.println("Input error. Size <= 0");
            scanner.close();
            return;
        }
        List<Double> numbers = new ArrayList<>();
        while (numbers.size() < count && scanner.hasNext()) {
            if (scanner.hasNextDouble()) {
                numbers.add(scanner.nextDouble());
            } else {
                scanner.next();
            }
        }

        scanner.close();

        if (numbers.size() < count) {
            System.out.println("Input error. Insufficient number of elements");
            return;
        }

        System.out.println(count);
        for (Double num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        double min = numbers.get(0);
        double max = numbers.get(0);
        for (Double num : numbers) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        System.out.println("Saving min and max values in file");
        try (OutputStream outputStream = Files.newOutputStream(Paths.get("src/main/resources/resultFiles/result.txt"))) {
            String result = min + " " + max + System.lineSeparator();
            outputStream.write(result.getBytes());
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }

    private static int readInt(Scanner scanner) {
        if (!scanner.hasNextInt()) return -1;

        return scanner.nextInt();
    }
}
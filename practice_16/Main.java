package practice_16;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CustomVector vector = new CustomVector();
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\n=== Робота з Вектором ===");
            System.out.println("1. Додати елемент в кінець");
            System.out.println("2. Додати елемент за індексом");
            System.out.println("3. Видалити елемент за індексом");
            System.out.println("4. Отримати елемент за індексом");
            System.out.println("5. Отримати кількість присутніх елементів");
            System.out.println("6. Отримати кількість елементів в буфері (ємність)");
            System.out.println("7. Вийти");
            System.out.print("Оберіть дію: ");

            String choice = scanner.nextLine();

            try {
                if (choice.equals("1")) {
                    System.out.print("Введіть рядок для додавання: ");
                    String value = scanner.nextLine();
                    vector.add(value);
                    System.out.println("-> Елемент успішно додано.");

                } else if (choice.equals("2")) {
                    System.out.print("Введіть індекс: ");
                    int index = Integer.parseInt(scanner.nextLine());
                    System.out.print("Введіть рядок для додавання: ");
                    String value = scanner.nextLine();
                    vector.add(index, value);
                    System.out.println("-> Елемент успішно додано за індексом.");

                } else if (choice.equals("3")) {
                    System.out.print("Введіть індекс для видалення: ");
                    int index = Integer.parseInt(scanner.nextLine());
                    vector.remove(index);
                    System.out.println("-> Елемент успішно видалено.");

                } else if (choice.equals("4")) {
                    System.out.print("Введіть індекс для отримання: ");
                    int index = Integer.parseInt(scanner.nextLine());
                    System.out.println("-> Елемент за індексом " + index + ": " + vector.get(index));

                } else if (choice.equals("5")) {
                    System.out.println("-> Поточна кількість елементів: " + vector.getSize());

                } else if (choice.equals("6")) {
                    System.out.println("-> Розмір буфера: " + vector.getCapacity());

                } else if (choice.equals("7")) {
                    System.out.println("Завершення роботи.");
                    isRunning = false;

                } else {
                    System.out.println("-> Невідома команда!");
                }
            } catch (NumberFormatException e) {
                System.out.println("-> Помилка: індекс має бути цілим числом!");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("-> Помилка: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
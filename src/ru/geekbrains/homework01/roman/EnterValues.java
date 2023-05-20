package ru.geekbrains.homework01.roman;

import java.util.Scanner;

/**
 * Класс ввода данных
 */
public class EnterValues {
    private static final int minValue = 1;
    private static final int maxValue = 3999;

    /**
     * Ввод числа в диапазоне от 1 до 3999
     *
     * @return Возвращает число в диапазоне от 1 до 3999
     */
    public static int GetNumberFromRange() {
        int result = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.print(String.format("Введите число в диапазоне от %d до %d: ", minValue, maxValue));
                result = scanner.nextInt();
                if (result < minValue || result > maxValue) {
                    System.out.println(String.format("Введите вне диапазона от %d до %d: ", minValue, maxValue));
                } else {
                    return result;
                }
            } catch (Exception ex) {
                System.out.println("Ошибка ввода!");
                scanner = new Scanner(System.in);
            }
        } while (1 == 1);
    }

    /**
     * Ввод строки с клавиатуры
     *
     * @return Возвращает строку введенную с клавиатуры
     */
    public static String GetString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}

package ru.geekbrains.homework01.exec;

import ru.geekbrains.homework01.roman.EnterValues;
import ru.geekbrains.homework01.roman.RomanConverter;

public class Main {
    public static void main(String[] args) {
        try {
            boolean forDocker = true;
            if (forDocker) {
                int number = 1961;
                System.out.println(String.format("Число %d в римском формате %s", number, RomanConverter.intToRoman(number)));
                String roman = "MMCCCLXXXVII";
                System.out.println(String.format("Число %s в десятичном формате %d", roman, RomanConverter.romanToInt(roman)));
            }
            else {
                System.out.println("==========Преобразование числа из арабского в римское==========");
                int number = EnterValues.GetNumberFromRange();
                System.out.println(String.format("Число %d в римском формате %s", number, RomanConverter.intToRoman(number)));
                System.out.println();
                System.out.println("==========Преобразование числа из арабского в римское==========");
                System.out.print("Введите число в римском формате: ");
                String strNumber = EnterValues.GetString();
                System.out.println(String.format("Результат преобразования %s в десятичный формат: ", strNumber));
                System.out.println(RomanConverter.romanToInt(strNumber));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

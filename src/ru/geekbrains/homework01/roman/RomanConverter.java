package ru.geekbrains.homework01.roman;

import java.util.HashMap;

/**
 * Класс передова арабских чисел от 1 до 3999 в римские и обратно
 */
public class RomanConverter {
    /**
     * Соответствие арабским числам римских
     */
    private static final HashMap<Integer, String> numRomanMap;
    /**
     * Соответствие римским числам арабских
     */
    private static final HashMap<String, Integer> romanNumMap;

    static {
        numRomanMap = new HashMap<>();
        numRomanMap.put(1, "I");
        numRomanMap.put(4, "IV");
        numRomanMap.put(5, "V");
        numRomanMap.put(9, "IX");
        numRomanMap.put(10, "X");
        numRomanMap.put(40, "XL");
        numRomanMap.put(50, "L");
        numRomanMap.put(90, "XC");
        numRomanMap.put(100, "C");
        numRomanMap.put(400, "CD");
        numRomanMap.put(500, "D");
        numRomanMap.put(900, "CM");
        numRomanMap.put(1000, "M");
        romanNumMap = new HashMap<>();
        romanNumMap.put("I", 1);
        romanNumMap.put("IV", 4);
        romanNumMap.put("V", 5);
        romanNumMap.put("IX", 9);
        romanNumMap.put("X", 10);
        romanNumMap.put("XL", 40);
        romanNumMap.put("L", 50);
        romanNumMap.put("XC", 90);
        romanNumMap.put("C", 100);
        romanNumMap.put("CD", 400);
        romanNumMap.put("D", 500);
        romanNumMap.put("CM", 900);
        romanNumMap.put("M", 1000);
    }

    /**
     * Функция перевода арабского числа в римское в диапазоне от 1 до 3999
     *
     * @param num Арабское число для перевода
     * @return Соответствующее римское число
     */
    public static String intToRoman(int num) throws Exception {
        if (num < 1 || num > 3999) {
            throw new Exception("Число не в диапазоне от 1 до 3999");
        }
        String result = "";
        int temp = num;
        int maxKey;
        while (temp > 0) {
            maxKey = 0;
            for (Integer key : numRomanMap.keySet()) {
                if (maxKey < key && temp - key >= 0) {
                    maxKey = key;
                }
            }
            result += numRomanMap.get(maxKey);
            temp -= maxKey;
        }
        return result;
    }

    /**
     * Функция перевода римское числа в арабское в диапазоне от 1 до 3999
     *
     * @param romanNum Римское число для перевода
     * @return Соответствующее арабское число
     */
    public static int romanToInt(String romanNum) throws Exception {
        String romanNumber = romanNum.toUpperCase();
        int result = 0;
        int i = 0;
        String temp;
        int tempMaxInt = 1000;
        int tempInt = 0;
        while (i < romanNumber.length()) {
            if (i < romanNumber.length() - 1) {
                temp = romanNumber.substring(i, i + 2);
                if (romanNumMap.containsKey(temp)) {
                    tempInt = romanNumMap.get(temp);
                    if (tempInt > tempMaxInt) {
                        throw new Exception("Ошибка формата числа");
                    }
                    i += 2;
                } else {
                    temp = String.valueOf(romanNumber.charAt(i));
                    if (romanNumMap.containsKey(temp)) {
                        tempInt = romanNumMap.get(temp);
                        if (tempInt > tempMaxInt) {
                            throw new Exception("Ошибка формата числа");
                        }
                        i++;
                    }
                }
            } else {
                temp = String.valueOf(romanNumber.charAt(i));
                if (romanNumMap.containsKey(temp)) {
                    tempInt = romanNumMap.get(temp);
                    if (tempInt > tempMaxInt) {
                        throw new Exception("Ошибка формата числа");
                    }
                }
                i++;
            }
            if (tempInt == 0) {
                throw new Exception("Ошибка формата числа");
            }
            if (tempInt < tempMaxInt) {
                tempMaxInt = tempInt;
            }
            result += tempInt;
            tempInt = 0;
        }
        return result;
    }
}


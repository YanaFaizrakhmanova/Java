package Forth;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        final String filename = "src/main/resources/text.txt"; // Имя файла с текстом

        // Словарь для хранения слов и их частот
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Регулярное выражение очищает строку от знаков пунктуации и сохраняет только буквы и цифры
                String cleanedLine = line.replaceAll("[^a-zA-Z0-9]", " ");
                // Деление строки на слова
                String[] words = cleanedLine.trim().toLowerCase().split("\\\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.merge(word, 1, Integer::sum); // Увеличение счётчика слова
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
            return;
        }

        // Поиск максимального значения частоты
        int maxFreq = Collections.max(wordCount.values());

        // Сбор всех слов с максимальной частотой
        List<String> mostFrequentWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == maxFreq) {
                mostFrequentWords.add(entry.getKey());
            }
        }

        // Вывод статистики
        System.out.println("Список слов в алфавитном порядке:");
        wordCount.keySet().stream()
                .sorted()
                .forEachOrdered(word -> System.out.printf("%s (%d)\n", word, wordCount.get(word)));

        System.out.println("\nСамые частые слова и их частота:");
        for (String word : mostFrequentWords) {
            System.out.printf("%s (%d)\n", word, maxFreq);
        }
    }
}


package Forth;
import java.io.FileReader;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;

public class WordFrequencyCount {

    public static void main(String[] args) throws IOException {
        // Чтение текста из файла
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/text.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                contentBuilder.append(line).append(System.lineSeparator());
            }
        }

        // Приводим текст к нижнему регистру и очищаем от знаков препинания
        String text = contentBuilder.toString().toLowerCase();
        List<String> words = Arrays.asList(text.split("[^a-zA-Z]+"));

        // Словарь для хранения частот слов
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty()) {
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
        }

        // Список уникальных слов в алфавитном порядке
        List<String> uniqueWords = new ArrayList<>(wordCounts.keySet());
        Collections.sort(uniqueWords);

        // Определение самой высокой частоты
        int maxCount = 0;
        Set<String> mostCommonWords = new LinkedHashSet<>(); // Для сохранения порядка добавления
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostCommonWords.clear();
                mostCommonWords.add(entry.getKey());
            } else if (entry.getValue() == maxCount) {
                mostCommonWords.add(entry.getKey());
            }
        }

        // Вывод результата
        System.out.println("Список слов в алфавитном порядке:");
        for (String word : uniqueWords) {
            System.out.println(word);
        }

        System.out.println("\nСтатистика появления слов:");
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\nСамые частые слова и их частота:");
        for (String word : mostCommonWords) {
            System.out.println(word + ": " + maxCount);
        }
    }
}
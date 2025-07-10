package first;
import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Task1 {
    // Строки для хранения всех русских гласных и согласных букв
    private static final String VOWELS = "аеяёуиыоэю";
    private static final String CONSONANTS = "бвгджзклмнпрстфхцчшщъь";

    public static void main(String[] args) throws IOException {

        File inputFile = new File("D:/Jmeter_Обучение/Обучение/Java/src/main/resources/introduce_java.txt");   // Исходный файл
        File outputFile = new File("output.txt"); // Новый файл

        int vowelCount = 0;           // Количество заменённых гласных
        int consonantCount = 0;       // Количество заменённых согласных

        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFile), "UTF-8"));
                PrintWriter writer = new PrintWriter(outputFile)
        ) {

            String line;
            while ((line = reader.readLine()) != null) {
                char[] chars = line.toCharArray();

                for (int i = 0; i < chars.length; i++) {
                    if (VOWELS.contains(String.valueOf(chars[i]).toLowerCase())) { // Если буква гласная
                        chars[i] = 'a';
                        vowelCount++;
                    } else if (CONSONANTS.contains(String.valueOf(chars[i]).toLowerCase())) { // Если буква согласная
                        chars[i] = 'м';
                        consonantCount++;
                    }
                }

                writer.println(new String(chars));
            }
        }

        System.out.printf("Заменено гласных: %d\\n", vowelCount);
        System.out.printf("Заменено согласных: %d\\n", consonantCount);
    }
}


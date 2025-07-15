package first;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("Введите путь к файлу input.txt: ");
            String filePath = consoleReader.readLine();

            Map<String, Object> userData = parseFile(filePath);

            if (!userData.isEmpty()) {
                // Формирование простого JSON вручную
                StringBuilder jsonOutput = new StringBuilder("{");
                boolean firstEntry = true;

                for (Map.Entry<String, Object> entry : userData.entrySet()) {
                    if (!firstEntry) {
                        jsonOutput.append(", ");
                    }
                    jsonOutput.append("\\").append(entry.getKey()).append("\\").append(entry.getValue()).append("\\");
                    firstEntry = false;
                }

                jsonOutput.append("}");
                System.out.println(jsonOutput.toString());
            }
        }
    }

    private static Map<String, Object> parseFile(String filePath) {
        Map<String, Object> userData = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length >= 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();

                    switch (key.toLowerCase()) {
                        case "name":
                            userData.put("name", value);
                            break;
                        case "surname":
                            userData.put("surname", value);
                            break;
                        case "age":
                            userData.put("age", Integer.parseInt(value));
                            break;
                    }
                }
            }
        } catch (IOException | NumberFormatException ex) {
            System.err.println("Ошибка при чтении файла: " + ex.getMessage());
            return new HashMap<>(); // пустой набор данных
        }

        return userData;
    }
}
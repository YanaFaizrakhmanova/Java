package first;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Task2 {
    public static void main(String[] args) {
        Map<String, Object> userData = loadUserDataFromResources();

        if (!userData.isEmpty()) {
            // Формирование JSON вручную
            StringBuilder jsonOutput = new StringBuilder("{\n");
            boolean firstEntry = true;

            for (Map.Entry<String, Object> entry : userData.entrySet()) {
                if (!firstEntry) {
                    jsonOutput.append(", \n ");
                }
                jsonOutput.append("\"" + entry.getKey() + "\"" + ":" + entry.getValue());

                firstEntry = false;
            }

            jsonOutput.append("\n}");
            System.out.println(jsonOutput.toString());
        } else {
            System.out.println("Файл пуст или некорректен.");
        }
    }

    private static Map<String, Object> loadUserDataFromResources() {
        Map<String, Object> userData = new HashMap<>();

        ClassLoader classLoader = Task2.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("input.txt");

        if (inputStream == null) {
            System.err.println("Файл resources/input.txt не найден!");
            return new HashMap<>();
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("="); // Меняем разделитель на '='
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
                            try {
                                int age = Integer.parseInt(value);
                                userData.put("age", age);
                            } catch (NumberFormatException e) {
                                System.err.println("Некорректный возраст: " + value);
                            }
                            break;
                    }
                }
            }
        } catch (IOException ex) {
            System.err.println("Ошибка при чтении файла: " + ex.getMessage());
            return new HashMap<>();
        }

        return userData;
    }
}

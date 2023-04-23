package exercise_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exercise_1 {

    private static final String ABSOLUTE_PATH = "/Users/evasohatskaya/IdeaProject/Modul_10_Homework/src/main/java/exercise_1/file.txt";

    public static void main(String[] args) {
        String line;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(ABSOLUTE_PATH))) {

            while ((line = bufferedReader.readLine()) != null) {
                if (chekIfFileAvailable(line)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static boolean chekIfFileAvailable(String number) {
        if (number.matches("\\(\\d{3}\\)\\s\\d{3}-\\d{4}")) {
            return true;
        } else if (number.matches("\\d{3}-\\d{3}-\\d{4}")) {
            return true;
        } else {
            return false;
        }
    }
}
package exercise_3;

import java.io.*;
import java.util.*;

public class Exercise_3 {
    private static final String ABSOLUTE_PATH = "/Users/evasohatskaya/IdeaProject/Modul_10_Homework/src/main/java/exercise_3/words.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(ABSOLUTE_PATH);
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
        String line = reader.readLine();
        Map<String, Integer> wordFreq = new HashMap<>();
        while (line != null) {
            String[] words = line.split(" ");
            for (String word : words) {
                if (wordFreq.containsKey(word)) {
                    wordFreq.put(word, wordFreq.get(word) + 1);
                } else {
                    wordFreq.put(word, 1);
                }
            }
            line = reader.readLine();
        }
        reader.close();

        for (String word : wordFreq.keySet()) {
            System.out.println(word + " " + wordFreq.get(word));
        }
    } catch (IOException e) {
        System.err.println(e.getMessage());
    }
}

}


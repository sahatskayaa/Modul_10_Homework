package exercise_3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercise_3 {
    private static final String ABSOLUTE_PATH = "words.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(ABSOLUTE_PATH);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
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

            List<String> sort = new ArrayList<>(wordFreq.keySet());
            for (int i = 0; i < sort.size() - 1; i++) {
                for (int j = 0; j < sort.size() - i - 1; j++) {
                    String firstWord = sort.get(j);
                    String secondWord = sort.get(j + 1);

                    if (wordFreq.get(firstWord) < wordFreq.get(secondWord)) {
                        sort.set(j, secondWord);
                        sort.set(j + 1, firstWord);
                    }
                }
            }

            for (String word : sort) {
                System.out.println(word + " " + wordFreq.get(word));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}


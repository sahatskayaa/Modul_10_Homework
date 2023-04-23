package exercise_2;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class User {
    private static final String ABSOLUTE_PATH = "file2.txt";
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) throws IOException {
        File file = new File(ABSOLUTE_PATH);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String s = bufferedReader.readLine();

        List<User> users = new ArrayList<User>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] vals = line.split(" ");

            if(!validation(vals[0])){
                System.out.println(line);
                continue;
            }

            User user = new User(vals[0], Integer.parseInt(vals[1]));
            users.add(user);
        }
        bufferedReader.close();

        Gson gson = new Gson();
        FileWriter writer = new FileWriter("user.json");
        writer.write(gson.toJson(users));
        writer.close();
        }

        private static boolean validation(String val){
        for (char c : val.toCharArray()){
            if(!Character.isLetter(c)){
                return false;
            }
        }
        return true;
        }
    }

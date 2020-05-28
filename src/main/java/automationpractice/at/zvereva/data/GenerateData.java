package automationpractice.at.zvereva.data;

import java.util.ArrayList;
import java.util.List;

public class GenerateData {

    public static String  generateNewRandomEmail(int emailNameLength) {
        StringBuilder emailBuilder = new StringBuilder();
        for (int i = 0; i < emailNameLength; i++) {
            emailBuilder.append((char)(97 + (int)(Math.random() * 26)));
        }
        emailBuilder.append("@gmail.com");
        return emailBuilder.toString();
    }

   public static String getNameFromList(){
   List<String> names = new ArrayList();
   names.add("Maria");names.add("Bob");names.add("Bill");names.add("Karl");names.add("Lis");names.add("Kim");
   String name = names.get((int)(Math.random() * names.size()));
   return name;
    }

    public static String getSurnameFromList(){
        List<String> names = new ArrayList();
        names.add("Jobs");names.add("Kein");names.add("Li");names.add("Lom");names.add("Shin");names.add("Koner");
        String name = names.get((int)(Math.random() * names.size()));
        return name;
    }
}



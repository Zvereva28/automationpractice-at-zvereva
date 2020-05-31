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
        System.out.println(emailBuilder.toString());
        return emailBuilder.toString();
    }

   public static String getNameFromList(){
   List<String> names = new ArrayList();
   names.add("Maria");
   names.add("Bob");
   names.add("Bill");
   names.add("Karl");
   names.add("Lis");
   names.add("Kim");
   names.add("Max");
   names.add("Jon");
   String name = names.get((int)(Math.random() * names.size()));
   return name;
    }

    public static String getLastNameFromList(){
        List<String> lastNames = new ArrayList();
        lastNames.add("Jobs");
        lastNames.add("Kein");
        lastNames.add("Li");
        lastNames.add("Lom");
        lastNames.add("Shin");
        lastNames.add("Koner");
        String lastName = lastNames.get((int)(Math.random() * lastNames.size()));
        return lastName;
    }
}



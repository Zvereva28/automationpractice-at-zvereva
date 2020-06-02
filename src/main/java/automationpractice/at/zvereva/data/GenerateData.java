package automationpractice.at.zvereva.data;
import java.util.ArrayList;
import java.util.Arrays;
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
   List<String> names = new ArrayList<>(Arrays.asList("Maria","Bob","Bill","Karl","Lis","Kim","Max","Jon"));
   String name = names.get((int)(Math.random() * names.size()));
   return name;
    }

    public static String getLastNameFromList(){
        List<String> lastNames = new ArrayList(Arrays.asList("Jobs","Kein","Li","Lom","Shin","Koner"));

        String lastName = lastNames.get((int)(Math.random() * lastNames.size()));
        return lastName;
    }
}



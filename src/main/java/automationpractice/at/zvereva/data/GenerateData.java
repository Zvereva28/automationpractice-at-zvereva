package automationpractice.at.zvereva.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateData {
    //AI = account inform for registration
    public static final Object [] AI_POSITIVE1= new Object[]{
            1, "trre123", "street 25", "NewYork", 25, "25002", "25"};
    public static final Object [] AI_POSITIVE2= new Object[]{
            2, "nhyt3698", "street 15", "Volgograd", 15, "36523", "36-96-36"};
    public static final Object [] AI_POSITIVE3= new Object[]{
            1, "gjnvd3", "street 5", "Moscow", 16, "00000", "369-96-36"};
    //AUTH= authentication inform
    public static final Object [] AUTH_POSITIVE1 = new Object[]{
            "vskstji@gmail.com", "trre123"};
    public static final Object [] AUTH_NEGATIVE1 = new Object[]{
            "vskstji@gmai.com", "123456"};
    public static final Object [] AUTH_NEGATIVE2 = new Object[]{
            "vskstji@gmai.com", "12"};
    public static final Object [] AUTH_NEGATIVE3 = new Object[]{
            "gjnvd3", "123456"};



    public static String generateNewRandomEmail(int emailNameLength) {
        StringBuilder emailBuilder = new StringBuilder();
        for (int i = 0; i < emailNameLength; i++) {
            emailBuilder.append((char) (97 + (int) (Math.random() * 26)));
        }
        emailBuilder.append("@gmail.com");
        System.out.println(emailBuilder.toString());
        return emailBuilder.toString();
    }

    public static String getNameFromList() {
        List<String> names = new ArrayList<>(Arrays.asList("Maria", "Bob", "Bill", "Karl", "Lis", "Kim", "Max", "Jon"));
        String name = names.get((int) (Math.random() * names.size()));
        return name;
    }

    public static String getLastNameFromList() {
        List<String> lastNames = new ArrayList(Arrays.asList("Jobs", "Kein", "Li", "Lom", "Shin", "Koner"));

        String lastName = lastNames.get((int) (Math.random() * lastNames.size()));
        return lastName;
    }
}



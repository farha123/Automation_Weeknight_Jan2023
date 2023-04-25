package Action_Item1;

import java.util.ArrayList;

public class Arraylist {
    public static void main(String[] arg) {
        ArrayList<String> countries = new ArrayList<>();
        countries.add("Algeria");
        countries.add("Bangladesh");
        countries.add("Albania");
        countries.add("Afghanistan");
        ArrayList<Integer> countryCodes = new ArrayList<>();
        countryCodes.add(213);
        countryCodes.add(880);
        countryCodes.add(355);
        countryCodes.add(93);
        for (int i = 0; i < countries.size(); i++){
            System.out.println("My country is " + countries.get(i) + " and my country code is " + countryCodes.get(i));
        }
    }
}

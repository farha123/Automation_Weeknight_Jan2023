package Day2_03072023;

import java.util.ArrayList;

public class T3_Forloop_ArrayList {
    public static void main(String[] args) {
//declare and define an array list of countries
        ArrayList<String> countries = new ArrayList<>();
        //add some values for countries
        countries.add("USA");//index 0
        countries.add("UK");//index 1
        countries.add("BANGLADESH");//index 2
        countries.add("INDIA");//index 3
        countries.add("PAKISTAN");//index 4
        //use a for loop to print out all the countries from the arraylist
        for (int i = 0; i < countries.size(); i++) {
            //print out the i value to see which iteration we are on
            System.out.println("Iteration number is " + i);
            //print out each country from the arraylist
            System.out.println("My countries are " + countries.get(i));
        }//end of for loop
    }//end of main
}//end of class


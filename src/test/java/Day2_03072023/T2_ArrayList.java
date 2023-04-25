package Day2_03072023;

import java.util.ArrayList;

public class T2_ArrayList {
    public static void main(String[] args) {
//declare and define an array list of countries
        ArrayList<String> countries = new ArrayList<>();
        //add some values for countries
        countries.add("USA");//index 0
        countries.add("UK");//index 1
        countries.add("BANGLADESH");//index 2
        countries.add("INDIA");//index 3
        countries.add("PAKISTAN");//index 4
        //Print out USA from the arrayList
        System.out.println("My first country is " + countries.get(0));
        //get the total size of the array list
        System.out.println("Size of the countries arraylist is " + countries.size());
        //add an additional country (Canada)
        countries.add("CANADA");
        //print out the size of the arraylist again
        System.out.println("Size of the countries arraylist is " + countries.size());
        //call an integer array list for studentGrades
        ArrayList<Integer> studentGrades = new ArrayList<>();
        //add some student grades to the array list
        studentGrades.add(90);
        studentGrades.add(80);
        studentGrades.add(70);
        System.out.println("First student grade is " + studentGrades.get(0) + " and the third student grade is " + studentGrades.get(2));
    }//end of main
}//end of class

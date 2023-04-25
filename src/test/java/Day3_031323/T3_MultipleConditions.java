package Day3_031323;

public class T3_MultipleConditions {
    public static void main(String[] args) {
        //declare three integer variables
        int a = 1;
        int b = 4;
        int c = 6;

        //print out the conditions when a+b either greater, equal, or less than c
        //you can end multiple conditions with an else if or with an else
        if(a+b > c) {
            System.out.println("a & b is greater than c");
        } else if(a+b == c) { //double equal sign is used to compare two different values
            System.out.println("a & b is equal to c");
        } else {
            System.out.println("a & b is less than c");

        }//end of multiple conditions
    }//end of main
}//end of class


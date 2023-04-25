package Day4_03142023;

public class Action_Item_2_Question_1 {
    public static void main(String[] args) {
        //declare a numeric variable
        int grade = 84;

        if (grade >= 90 && grade <= 100) {
            System.out.println(" Grade is A ");
        } else if (grade >= 80 && grade < 90) {
            System.out.println(" Grade is B ");
        } else if (grade <= 70 && grade < 80) {
            System.out.println(" Grade is C ");
        } else if (grade <= 60 && grade < 70) {
            System.out.println(" Grade is D ");
        } else {
            System.out.println(" Grade is F ");
        }//end of multiple conditions
    }//end of main
}//end of class

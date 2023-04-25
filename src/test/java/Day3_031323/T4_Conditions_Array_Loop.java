package Day3_031323;

public class T4_Conditions_Array_Loop {
    public static void main(String[] args) {
        //create a list of fruits
        String[] fruits = new String[]{"Orange","Grape","Mango","Strawberry"};

//iterate through the list of fruit but only print when fruit is either Orange or Grape
        for(int i=0; i<fruits.length;i++){
/*
            if(fruits[i] == "Orange" || fruits[i] == "Grape"){
                System.out.println("Fruit is " + fruits[i]);

            }//end of conditions

 */



            //print when it's Orange or Grape

            if(fruits[i] == "Orange"){
                System.out.println("Fruit is Orange");
            } else if(fruits[i] == "Grape"){
                System.out.println("Fruit is Grape");
            }//end of conditions



        }//end of loop
    }//end of main
}//end of class

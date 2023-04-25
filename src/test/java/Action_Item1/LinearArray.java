package Action_Item1;


public class LinearArray {
    public static void main(String[] arg) {
        String[] region;
        region = new String[]{"Alabama", "Alaska", "Arizona", "Arkansas"};
        int[] areaCode = new int[]{205,907,480,479};
        for (int i = 0; i < region.length; i++) {
            System.out.println("My region is " + region[i] + " and my area code is " + areaCode[i]);
        }
    }
}
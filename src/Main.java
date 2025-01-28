import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        File f = new File("src/input");



        Scanner s = null;
        try {
            s = new Scanner(f);
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
            System.exit(1);
        }

        String fileData = "";
        while (s.hasNextLine()){
            String currentLine = s.nextLine();
            while (s.hasNextLine()){
                fileData += s.nextLine() + "\n";
            }
        }
        String[] fileArray = fileData.split("\n");
        System.out.println(Arrays.toString(fileArray));


        int fiveOfAKind = 0;
        int fourOfAKind = 0;
        int fullHouse = 0;
        int threeOfAKind = 0;
        int twoPair = 0;
        int onePair = 0;
        int highCard = 0;

        for (int i = 0; i < fileArray.length; i++){
            String firstItem = fileArray[i].substring(0, fileArray[i].indexOf(","));
            String newString = fileArray[i].substring(fileArray[i].indexOf(",") + 1);
            String secondItem = newString.substring(0,newString.indexOf(","));
            String newString1 = newString.substring(newString.indexOf(",") + 1);
            String thirdItem = newString1.substring(0,newString1.indexOf(","));
            String newString2 = newString1.substring(newString1.indexOf(",") + 1);
            String fourthItem = newString2.substring(0, newString2.indexOf(","));
            String newString3 = newString2.substring(newString2.indexOf(",") + 1);
            String fifthItem = newString3.substring(0, newString3.indexOf("|"));

            String checkString = firstItem + secondItem + thirdItem + fourthItem + fifthItem;

            if ((firstItem.equals(secondItem)) && (secondItem.equals(thirdItem)) && (thirdItem.equals(fourthItem)) && (fourthItem.equals(fifthItem))){
                fiveOfAKind++;
            }
            checkString.replace(firstItem, "1");

        }
    }


}
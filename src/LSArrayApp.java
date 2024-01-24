import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LSArrayApp {

    private static LS[] data = new LS[2976];
    public static int countOp;

    public static void main(String[] args) {
        countOp = 0;
        int count = 0;
        try {
            Scanner scan = new Scanner(new File("Load Shedding Schedule.clean.final.txt"));
            //reading in from the text file

            while (scan.hasNextLine()) {
                Scanner scanLine = new Scanner(System.in);
                String input = scan.nextLine();
                String words[] = input.split(" ",2);
                String value = words[0];
                String area = words[1];

                data[count] = new LS(value, area);
                count++;
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
        if (args.length == 0) {
            //printAreas("9", "30", "02");
            printAllAreas();
        }
        else {
            //printAreas("9", "30", "02");
            printAreas(args[0], args[1], args[2]);
        }

        //prints total number of operations
        System.out.println("Total operations: "+countOp);

    }

    /*
     * This method searches for the arguments within the LS[] array with the same value(i.e. Stage,Day,Time) as the one
     * entered. It prints the areas matching the value entered and returns the operations count.
     * @param stage, day and start time
     * @return countOp (the operation counter)
     */
    public static int printAreas (String stage, String day, String time) {
        countOp = 0;
        String value = stage+"_"+day+"_"+time;
        String out = "No correlating areas were found"; //Displayed if the value isn't found within the text file
        for (int i = 0; i < data.length; i++) {
            countOp++;
            if (data[i].getValue().equals(value)) {
                out = data[i].toString();
                break;
            }
        }
        System.out.println(out);
        return countOp;
    }

    //prints the areas for every stage, day and start time, in any order.
    public static void printAllAreas() {
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i].toString());
        }
    }
}

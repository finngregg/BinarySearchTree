import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class LSBSTApp {

    public static BinarySearchTree<LS> bst = new BinarySearchTree<LS>();
    public static LS[] data;
    public static int num = 0;

    public LSBSTApp(LS[] data, int num){
        dataInsert(data, num);
    }

    //This method reads in from the text file and inserts data into the binary tree
    public static void dataInsert(LS[] data, int num) {
        try {
            Scanner scan = new Scanner(new File("Load Shedding Schedule.clean.final.txt"));

            while (scan.hasNextLine()) {
                Scanner scanLine = new Scanner(System.in);
                String input = scan.nextLine();
                String words[] = input.split(" ",2);
                String value = words[0];
                String area = words[1];
                bst.insert(new LS(value, area));
                num++;
            }
            scan.close();

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }

    public static void main(String[] args) {
        dataInsert(data, 2975);

        if (args.length == 0) {
            printAllAreas();
            //printAreas("3", "27", "60");
        } else {
            printAreas(args[0], args[1], args [2]);
            //printAreas("3", "27", "60");
        }

        //prints total number of operations
        System.out.println("Total operations: "+bst.countOp);

    }

    //prints out all the areas for every stage, day and start time in the tree, in any order.
    public static void printAllAreas() {
        bst.inOrder();
    }

    /*
     * This method searches for the arguments within the BST with the same value (i.e. Stage,Day,Time) as the one
     * entered. It prints the areas matching the parameters entered and returns the operations count.
     * @param stage, day and start time
     * @return countOp (the operation counter)
     */

    public static int printAreas(String stage, String day, String time) {
        bst.countOp = 0;
        String value = stage+"_"+day+"_"+time;
        LS data = new LS();
        data.setValue(value);
        BinaryTreeNode<LS> node = bst.find(data);

        String out = "No correlating areas were found";

        if(node==null){
            System.out.println(out);
        }
        else{
            LS foundData = (LS) node.getData();
            out = foundData.toString();
            System.out.println(out);
        }
        return bst.countOp;
    }

}
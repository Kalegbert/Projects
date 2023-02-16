package project2klle;

import static java.lang.Integer.parseInt;
import java.util.Scanner;
import java.io.File;  // import the File class 
import java.util.Scanner;
import java.io.FileNotFoundException; // import to handle errors
import static java.lang.Integer.parseInt;

/**
 * This is our main class. This includes the private processLine method, code that reads lines from food.txt, 
 * and where we test our methods from FoodItem and Inventory.
 * @author kylee
 */

public class Project2KLLE {
    
    /**
     * processLine realizes where each dollar sign is and separates variables given to us by food.txt
     * @param d
     * @return 
     */
    private static FoodItem processLine(String d) {

//  name, description, expdate, cat, quan - order of things in .txt file
        int dOne = d.indexOf("$");
        int dTwo = d.indexOf("$", dOne + 1);
        int dThree = d.indexOf("$", dTwo + 1);
        int dFour = d.indexOf("$", dThree + 1);

        String nam = d.substring(0, dOne);
        String descript = d.substring(dOne + 1, dTwo);
        String expDate = d.substring(dTwo + 1, dThree);
        String cat = d.substring(dThree + 1, dFour);
        int quan = parseInt(d.substring(dFour + 1));

        FoodItem methodFood = new FoodItem(cat, nam, descript, expDate, quan);

        return methodFood;
    }

    /**
     * We create a new food item here with the data from processLine and test methods from other classes
     * @param args 
     */
    public static void main(String[] args) {

        Inventory iven = new Inventory();

        try {
            File foodData = new File("C:\\Users\\kylee\\OneDrive\\Documents\\NetBeansProjects\\Project2KLLE\\src\\project2klle\\food.txt");
            Scanner scan = new Scanner(foodData);
            while (scan.hasNextLine()) {
                String data = scan.nextLine();
                FoodItem f = processLine(data);
                iven.add(f);

            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //iven.reportAll();
        System.out.println("");
        iven.reportExpiringSoon(12, 21);

        System.out.println("");
        iven.reportCategory("snack");

        System.out.println("");
        iven.reportCountCategory("snack");

    }

}

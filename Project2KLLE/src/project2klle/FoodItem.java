package project2klle;

import static java.lang.Integer.parseInt;

public class FoodItem {

    private String category;
    private String name;
    private String description;
    private String expDate; // stored as mm/dd/yy 
    private int quantity;

    /**
     * creates object FoodItem with 4 string parameters 
     * 
     * @param cat - category to be defined within method
     * @param nam - name to be defined within method
     * @param descript - description to be defined within method
     * @param exp - expiration date to be defined within method
     */
    public FoodItem(String cat, String nam, String descript, String exp) {
        quantity = 1;
        category = cat;
        name = nam;
        description = descript;
        expDate = exp;

    }

    /**
     * Same as the last one but adds an quantity parameter as well as the four strings
     * 
     * @param cat - category to be defined within method
     * @param nam - name to be defined within method
     * @param descript - description to be defined within method
     * @param exp - expiration date to be defined within method
     * @param quan - quantity of FoodItem to be defined within method
     */
    public FoodItem(String cat, String nam, String descript, String exp, int quan) {
        category = cat;
        name = nam;
        description = descript;
        expDate = exp;
        quantity = quan;

    }

    /**
     * returns category for FoodItem
     * @return category of FoodItem inputted
     */
    public String getCategory() {
        return category;
    }
    
    /**
     * returns Name for FoodItem
     * @return Name of FoodItem inputted
     */
    public String getName() {
        return name;
    }

    /**
     * returns description for FoodItem
     * @return Description of FoodItem inputted
     */
    public String getDescription() {
        return description;
    }

    /**
     * returns expiration month for FoodItem
     * @return expiration Month of FoodItem inputted
     */
    public int getExpMonth() {
        int month = parseInt(expDate.substring(0, 2));
        return month;

    }

    /**
     * returns expiration day for FoodItem
     * @return expiration Day of FoodItem inputted
     */
    public int getExpDay() {
        int day = parseInt(expDate.substring(3, 5));
        return day;
    }

    /**
     * returns expiration year for FoodItem
     * @return expiration year of FoodItem inputted
     */
    public int getExpYear() {
        int year = parseInt(expDate.substring(6, 8));
        return year;
    }

    /**
     * returns full expiration date for FoodItem
     * @return Expiration date of FoodItem inputted
     */
    public String getExpDate() {
        return expDate;
    }

    /**
     * returns quantity of FoodItem
     * @return Quantity of FoodItem inputted
     */
    public int getQuantity() {
        return quantity;
    }

    
    /**
     * returns values for FoodItem in a human readable way
     * @return A string organizing the values included in a FoodItem
     */
    public String toString() {
        return "[" + category + "] " + name + " [" + description + "] " + expDate + " Quantity: " + quantity;
    }

    
    /**
     * method that changes the quantity of specified FoodItem
     * @return Mutator method - changes quantity of FoodItem
     */
    public void setQuantity(int q) {
        if (q >= 0) {
            quantity = q;
        } else {
            System.out.println("error");
        }
    }

}

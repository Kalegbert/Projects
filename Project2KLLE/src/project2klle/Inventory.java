package project2klle;

public class Inventory {

    private Storage storage;

    /**
     * Creates new storage - Inventory
     */
    public Inventory() {
        storage = new Storage();

    }

    /**
     * Reports foodItems that expire soon. Compares expiration months and years to the current date
     * 
     * @param currM - input an int with the current Month to be read
     * @param currY - input an int with the current Year to be read
     */
    public void reportExpiringSoon(int currM, int currY) {
        storage.setStart();

        System.out.println("Food that is expiring soon: ");
        while (storage.hasNext()) {
            FoodItem temp = storage.next();
            int foodM = temp.getExpMonth();
            int foodY = temp.getExpYear();
            if ((currM == foodM && currY == foodY) || (currM + 1 == foodM && currY == foodY) || (currM == 12 && foodM == 1 && currY + 1 == foodY)) {
                System.out.println(temp);

            }

        }
    }

    /**
     * 
     * Reports the count of items with a specific category
     * 
     * @param category   -  input String category to be read
     */
    public void reportCountCategory(String category) {

        storage.setStart();
        int count = 0;

        while (storage.hasNext()) {
            FoodItem temp = storage.next();
            if (temp.getCategory().equals(category)) {
                count = count + 1;

            }

        }
        if (!storage.hasNext()) {
            System.out.println("There are " + count + " items with the category: " + category);
        }

    }
/**
 * reports items with given category
 * 
 * @param category   -  input String category to be read
 */
    public void reportCategory(String category) {

        storage.setStart();

        System.out.println("");
        System.out.println("Food with category: " + category);
        while (storage.hasNext()) {
            FoodItem temp = storage.next();
            if (temp.getCategory().equals(category)) {

                System.out.println(temp);

            }

        }

    }

    /**
     * adds food item to a storage created with our inventory method
     * 
     * @param food  -  input object FoodItem to be read
     */
    public void add(FoodItem food) {

        storage.setStart();
        boolean changedQuan = false;

        while (storage.hasNext()) {
            FoodItem temp = storage.next();
            if (temp.getName().equals(food.getName()) && temp.getCategory().equals(food.getCategory()) && temp.getExpDate().equals(food.getExpDate())) {

                temp.setQuantity(food.getQuantity() + temp.getQuantity());
                changedQuan = true;

            }

        }
        if (changedQuan == false) {
            storage.add(food);
        }

    }

    /**
     * lists all food in given storage
     * 
     */
    public void reportAll() {
        System.out.println("Food in storage");
        storage.setStart();
        while (storage.hasNext()) {
            FoodItem f = storage.next();
            System.out.println(f);
        }
    }

}
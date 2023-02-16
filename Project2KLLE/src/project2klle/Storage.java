/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project2klle;

/**
 *
 * @author johnsone
 */
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Provides inventory storage. Inventory is in no particular order
 *
 * @author johnsone
 */
public class Storage {

    private ArrayList<FoodItem> storage;
    private Iterator<FoodItem> iter;

    /**
     * Constructor for storage
     */
    public Storage() {
        storage = new ArrayList<>();
        iter = storage.iterator();
    }

    /**
     * Restarts access to storage
     */
    public void setStart() {
        iter = storage.iterator();
    }

    /**
     * Returns the next food item if one exists
     *
     * @return next food item or null if there are no more
     */
    public FoodItem next() {
        if (iter.hasNext()) {
            FoodItem f = iter.next();
            return f;
        } else {
            return null;
        }
    }

    /**
     * Returns true if there is another food item and false otherwise.
     *
     * @return true if there is another food item in storage and false otherwise
     */
    public boolean hasNext() {
        return iter.hasNext();
    }

    /**
     * Adds item to storage
     *
     * @param f food item to add to storage
     */
    public void add(FoodItem f) {
        storage.add(f);
        iter = storage.iterator(); // resets iterator to beginning
    }

    /**
     * Resets accessor to beginning of storage
     */
    public void resetToStart() {
        iter = storage.iterator(); // resets iterator to beginning
    }

}

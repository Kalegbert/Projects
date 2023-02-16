package project3klle;

import static java.lang.Integer.parseInt;

public class Visit {

    private Customer visitor;
    private String date; // mm/dd/yyyy 
    private String time; // hh:mm where hh is 24-hour time 

    /**
     *
     * Constructor for our Visit class with three parameters
     *
     * @param v visitor, a customer item. The one doing the visit
     * @param d the data of the visit
     * @param t the time of the visit
     */
    public Visit(Customer v, String d, String t) {

        visitor = v;
        date = d;
        time = t;

    }

    /**
     * Accessor method that gets the customer item, visitor
     *
     * @return visitor, instance variable that is a customer item
     */
    public Customer getVisitor() {

        return visitor;
    }

    /**
     * Access method that gets the month from our date
     *
     * @return the month from our date
     */
    public int getMonth() {

        int month = parseInt(date.substring(0, 2));
        return month;

    }

    /**
     * Access method that gets the day from our date
     *
     * @return the day from our date
     */
    public int getDay() {
        int day = parseInt(date.substring(3, 5)); //    00/00/0000
        return day;
    }

    /**
     * Accessor method that gets the year from our date
     *
     * @return the year from our date
     */
    public int getYear() {
        int year = parseInt(date.substring(6, 10));
        return year;
    }

    /**
     * Accessor method that gets the hour from our time
     *
     * @return the hour from our time
     */
    public int getHour() {
        int hour = parseInt(time.substring(0, 2));
        return hour;
    }

    /**
     * Accessor method that gets the minute from our time
     *
     * @return the minute from our time
     */
    public int getMinute() {
        int minute = parseInt(time.substring(3));
        return minute;

    }

    /**
     * Returns the visits information in a human readable way
     *
     * @return information about a visitor in a human readable way
     *
     */
    public String toString() {
        String bruh;
        bruh = date + " " + time + " " + visitor.toString();

        return bruh;

    }

}

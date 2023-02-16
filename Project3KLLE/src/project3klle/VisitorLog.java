package project3klle;

import java.util.ArrayList;
import java.util.Iterator;

public class VisitorLog {

    private ArrayList<Visit> visits;
    private Iterator<Visit> iter;

    /**
     * Constructor for our VisitorLog class containing visits and iter
     *
     */
    public VisitorLog() {

        visits = new ArrayList<Visit>();
        iter = visits.iterator();

    }

    /**
     * Mutator method that adds visit v to our arraylist
     *
     * @param v this is a visit you would like to add to the visit arraylist
     */
    public void addVisit(Visit v) {

        visits.add(v);

    }

    /**
     * Accessor method that gives you the total number of visits in the visits
     * arraylist
     *
     * @return the size of the visits arraylist
     */
    public int getNumberOfVisits() {
        int num = visits.size();
        return num;
    }

    /**
     * Accessor method that gets number of visits in a certain month and year
     *
     * @param month month of the time period you want the amount of visits for
     * @param year year of the time period you want the amount of visits for
     * @return an integer stating the number of visits within a certain time
     */
    public int getNumberOfVisits(int month, int year) {
        int count = 0;
        for (int i = 0; i < visits.size(); i++) {
            Visit q = visits.get(i);

            int m = q.getMonth();
            int yr = q.getYear();
            if (m == month && yr == year) {
                count++;
            }

        }
        return count;
    }

    /**
     * Accessor method that gets the number of visits for one customer c
     *
     * @param c customer you want to see the amount of visits for
     * @return number of visits for customer c
     */
    public int getNumberOfVisits(Customer c) {
        int count = 0;
        for (Visit v : visits) {
            Customer x = v.getVisitor();
            if (x == c) {
                if (x.getStudentID() == c.getStudentID()) {
                    count++;
                }

            }
        }
        return count;
    }

    /**
     * Reports all visits in visits arraylist in a human readable way
     */
    public void reportAllVisits() {
        System.out.println("All visits: ");
        for (Visit v : visits) {
            System.out.println(v.toString());

        }
        if (visits.size() == 0) {
            System.out.println("No visits found");
        }
    }

    /**
     * Reports all visits for customer c in visits arraylist in a human readable
     * way
     *
     * @param c customer you want to report all the visits for
     */
    public void reportAllVisits(Customer c) {
        System.out.println("Visits for customer: " + c);
        for (int i = 0; i < visits.size(); i++) {
            Visit q = visits.get(i);
            Customer y = q.getVisitor();
            if (c.getStudentID().equals(y.getStudentID())) {
                System.out.println(q.toString());
            }

        }
        if (visits.size() == 0) {
            System.out.println("No visits found");
        }
    }

    /**
     * Reports all the visits in a certain month in a human readable way
     *
     * @param month month you want to report visits for
     * @param year year you want to report visits for
     */
    public void reportVisitsInMonth(int month, int year) {
        System.out.println("Visits in month: ");
        int count = 0;
        for (int i = 0; i < visits.size(); i++) {
            Visit q = visits.get(i);

            int m = q.getMonth();
            int yr = q.getYear();
            if (m == month && yr == year) {
                System.out.println(q.toString());
                count++;
            }

        }
        System.out.println("There were " + count + " visits in this month");
    }

    /**
     * Reset the iter to the beginning so it will read from the beginning next
     * time it is called
     */
    public void setStart() {
        iter = visits.iterator();
    }

    /**
     * Reads the next object in the list
     *
     * @return
     */
    public Visit next() {
        if (iter.hasNext()) {
            Visit v = iter.next();
            return v;
        } else {
            return null;
        }
    }

    /**
     * checks to see if the list still has another object in the list based on
     * where you are in the iter
     *
     * @return a boolean, true if there is a next object, false if otherwise
     */
    public boolean hasNext() {
        return iter.hasNext();
    }

}

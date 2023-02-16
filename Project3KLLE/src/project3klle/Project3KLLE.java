package project3klle;

import java.util.ArrayList;
import java.util.Iterator;

public class Project3KLLE {

    public static void main(String[] args) {

        String cus1 = "James";
        String ID1 = "1927K5U8G";
        Customer James = new Customer(cus1, ID1);

        String cus2 = "Eli";
        String ID2 = "99EX38J"; // a non 9 digit ID to test the maskedID method
        Customer Eli = new Customer(cus2, ID2);

        String cus3 = "Geo";
        String ID3 = "000659X6D";
        Customer Geo = new Customer(cus3, ID3);

        Visit test = new Visit(James, "07/14/1992", "12:33");
        Visit test2 = new Visit(Geo, "07/22/1945", "11:34");

        ArrayList<Visit> visits = new ArrayList<Visit>();
        visits.add(test);
        visits.add(test2);
        VisitorLog vL = new VisitorLog();
        vL.addVisit(test);
        vL.addVisit(test2);
        System.out.println("Report All Visits");
        vL.reportAllVisits();
        System.out.println("The other methods");
        System.out.println("Number of visits " + vL.getNumberOfVisits());
        System.out.println("Visits in month 7, 1992" + vL.getNumberOfVisits(07, 1992));
        System.out.println("Number of visits for James " + vL.getNumberOfVisits(James));
        vL.reportVisitsInMonth(07, 1945);
        vL.reportAllVisits(Geo);

        System.out.println("");
        System.out.println("Simulation: ");

        Simulation s = new Simulation(100, 1000, 2022);
        s.doSimulation();

    }

}

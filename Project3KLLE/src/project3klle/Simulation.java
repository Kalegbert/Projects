package project3klle;

public class Simulation {

    private VisitorLog log;
    private int numCustomers;
    private int numVisits;
    private int year;

    /**
     * Constructor for the Simulation class with 3 parameters
     *
     *
     * @param nM - takes in number of customers
     * @param nV - takes in number of visits
     * @param y - takes in the year
     */
    public Simulation(int nM, int nV, int y) {
        numCustomers = nM;
        numVisits = nV;
        year = y;

        VisitorLog temp = new VisitorLog();
        log = temp;

    }

    /**
     * Accessor method that returns the year of simulation
     *
     * @return year of simulation
     */
    private int getYear() {
        return year;
    }

    /**
     * Generates a random five character set of letters beginning with a capital
     * letter
     *
     * @return returns a string to be used as a name for a customer later
     */
    private String generateName() {
        String[] alph = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        String n = alph[(int) (Math.random() * 26)];

        String n1 = n.toUpperCase();
        String n2 = alph[(int) (Math.random() * 26)];
        String n3 = alph[(int) (Math.random() * 26)];
        String n4 = alph[(int) (Math.random() * 26)];
        String n5 = alph[(int) (Math.random() * 26)];

        String Name = n1 + n2 + n3 + n4 + n5;
        return Name;
    }

    /**
     * Generates a random number beginning with three zeros and consisting of
     * only number
     *
     * @return returns a studentID at random
     */
    private String generateStudentID() {
        int s1 = (int) (Math.random() * 10);
        int s2 = (int) (Math.random() * 10);
        int s3 = (int) (Math.random() * 10);
        int s4 = (int) (Math.random() * 10);
        int s5 = (int) (Math.random() * 10);
        int s6 = (int) (Math.random() * 10);

        String StudentID = "000" + s1 + s2 + s3 + s4 + s5 + s6;
        return StudentID;
    }

    /**
     * Generates a random time of the day 00:00 - 23:59
     *
     * @return a random time to be used later
     */
    private String generateTime() {
        int h = (int) (Math.random() * 24);
        int m = (int) (Math.random() * 60);
        String hh;
        String mm;
        if (h < 10) {
            hh = "0" + h;
        } else {
            hh = Integer.toString(h);
        }
        if (m < 10) {
            mm = "0" + m;
        } else {
            mm = Integer.toString(m);
        }
        String hhmm = hh + ":" + mm;
        return hhmm;
    }

    /**
     * Generates a random date in the formate xx/xx/year where x is an integer
     * and year is the year of the simulation
     *
     * @return a random date with the simulations year
     */
    private String generateDate() {
        int month = (int) (Math.random() * 12);
        String stringMonth;
        int day;
        String stringDay;
        String date;

        int[] t1 = new int[31];
        int[] t0 = new int[30];
        int[] t8 = new int[28];

        for (int i = 1; i < 31; i++) {
            t1[i - 1] = i;
        }
        for (int i = 1; i < 30; i++) {
            t0[i - 1] = i;
        }
        for (int i = 1; i < 28; i++) {
            t8[i - 1] = i;
        }

        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            day = t1[(int) (Math.random() * 31)];
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            day = t0[(int) (Math.random() * 30)];
        } else {
            day = t8[(int) (Math.random() * 28)];
        }

        
        if (month < 9) {
            month++;
            stringMonth = "0" + month;
        } else {
            month++;
            stringMonth = Integer.toString(month);
        }

        if (day < 9) {
            day++;
            stringDay = "0" + day;
        } else {
            day++;
            stringDay = Integer.toString(day);
        }

        date = stringMonth + "/" + stringDay + "/" + year;
        return date;
    }

    /**
     * creates random customers with our previous methods and calls analyzeLog
     * on our arrays to see the data of our simulation
     *
     */
    public void doSimulation() {

        Customer[] arr = new Customer[numCustomers];

        for (int i = 0; i < numCustomers; i++) {
            String x = generateName();
            String y = generateStudentID();
            Customer c = new Customer(x, y);
            arr[i] = c;
        }
        for (int i = 0; i < numVisits; i++) {
            Customer cst = arr[(int) (Math.random() * numCustomers)];
            int yer = getYear();
            String yea = generateDate();
            Visit v = new Visit(cst, yea, generateTime());
            log.addVisit(v);
        }
        log.reportAllVisits();

        //replace reportallvisits with this
        int[] hourly = new int[24];
        int[] monthly = new int[12];
        int[] daily = new int[31];

        System.out.println("");
        analyzeLog(hourly);
        for (int i = 0; i < hourly.length; i++) {
            System.out.println("Counts for hour " + i + ": " + hourly[i]);
        }
        System.out.println("");
        analyzeLog(monthly);
        for (int i = 0; i < monthly.length; i++) {

            System.out.println("Counts for month " + i + ": " + monthly[i]);

        }
        System.out.println("");
        analyzeLog(daily);

        for (int i = 0; i < daily.length; i++) {

            System.out.println("Counts for day " + i + ": " + daily[i]);
        }
    }

    /**
     * Increments an array based on the log values
     *
     *
     * @param counts an array that will be increment one of it's sections based
     * on the data in our log(instance variable)
     */
    private void analyzeLog(int[] counts) {

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                counts[i] = 0;
            }

        }

        if (counts.length == 24) {
            log.setStart();

            while (log.hasNext()) {
                Visit v = log.next();
                int t = v.getHour();
                counts[t]++;
            }
        } else if (counts.length == 12) {
            log.setStart();

            while (log.hasNext()) {
                Visit v = log.next();
                int t = v.getMonth();
                counts[t-1]++;
            }
        } else {
            log.setStart();

            while (log.hasNext()) {
                Visit v = log.next();
                int t = v.getDay();
                counts[t-1]++;
            }

        }
    }
}

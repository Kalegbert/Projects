package project3klle;

public class Customer {

    private String name; // for purposes of this project, first name 
    private String studentID;
    private boolean isValidID;

    /**
     * Constructor for Customer object
     *
     * @param n - First name of customer
     * @param sID - Student ID of customer
     */
    public Customer(String n, String sID) {
        name = n;
        studentID = sID;
        isValidID = checkID(sID);

    }

    /**
     * Accessor method returning name of customer
     *
     * @return instance variable "name" of customer object
     */
    public String getName() {
        return name;
    }

    /**
     * Accessor method returning student ID of customer
     *
     * @return instance variable "studentID" of customer object
     */
    public String getStudentID() {
        return studentID;
    }

    /**
     * Accessor method that returns a hidden version of student ID
     *
     * @return returns studentID with the first five characters not visible
     */
    public String getMaskedStudentID() {
        String yuh = "*****" + studentID.substring(5, studentID.length());

        return yuh;
    }

    /**
     * Creates a string to print information about customer
     *
     * @return Prints each instance variable for Customer object(studentID,
     * name,) and if the ID is valid or not
     *
     */
    public String toString() {
        String bruh;
        String maskedID = getMaskedStudentID();
        if (isValidID == true) {
            bruh = name + " " + maskedID + ". ID: valid";
        } else {
            bruh = name + " " + maskedID + ". ID: invalid";
        }

        return bruh;

    }

    /**
     * Checks to see if customer object has a valid ID
     *
     * @param sID studentID of a customer
     * @return returns a boolean, true if it meets the criteria, false otherwise
     */
    private static boolean checkID(String sID) {
        boolean yuh = false;
        int iDL = sID.length();
        if (iDL == 9) {
            char a = sID.charAt(0);
            char b = sID.charAt(1);
            char c = sID.charAt(2);
            if (Character.isDigit(c) && Character.isDigit(b) && Character.isDigit(a)) {
                if (a == '0' && b == '0' && c == '0') {

                    yuh = true;

                }
            }
            for (int i = 3; i < sID.length(); i++) {  //

                if (!Character.isDigit(sID.charAt(i))) {

                    return false;
                }
            }
        }
        return yuh;
    }
}

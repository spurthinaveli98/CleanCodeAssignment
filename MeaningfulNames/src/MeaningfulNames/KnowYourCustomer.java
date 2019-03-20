package MeaningfulNames;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Logger;

/*
KnowYourCustomer is used to find the allowable date range for the form date.
 */
public class KnowYourCustomer {

    private static final Logger log = Logger.getLogger(KnowYourCustomer.class.getName());
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    static String signupDate, currentDate, allowableDateRange;
    static LocalDate signupLocalDate, currentLocalDate, anniversaryDate, startRange, endRange;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int numberOfInputs;
        log.info("Enter number of Inputs");

        try {
            numberOfInputs = sc.nextInt();
            for (int i = 0; i < numberOfInputs; i++){
                getCustomerDetails();
                calculateDateRange();
                printAllowableDateRange();
            }
        }

        catch (Exception e) {
            log.warning(e+" " + "Make sure entered date is in 'dd-mm-yyyy' format");
        }

    }


    /*
     *It gets input from the user.
     * Input information like signup date, current date.
     */
    private static void getCustomerDetails() {
        log.info("Enter signup date and current date respectively in 'dd-mm-yyyy' format");
        signupDate = sc.next();
        currentDate = sc.next();
    }

    /*
     *It holds sequence of operations that are performed to calculate date Range.
     */
    public static void calculateDateRange() {
        changeToDateTimeFormat();
        findAllowableDateRange();
    }

    /*
     *It changes input information into datetime format.
     */
    public static void changeToDateTimeFormat() {
        signupLocalDate = LocalDate.parse(signupDate, formatter);
        currentLocalDate = LocalDate.parse(currentDate, formatter);
    }

    /*
     *It calculates anniversary date based on signup date.
     */
    public static void calculateAnniversaryDate(int year) {
        anniversaryDate = LocalDate.of(year, signupLocalDate.getMonth(), signupLocalDate.getDayOfMonth());
    }

    /*
     *calculates startRange and endRange based on anniversary date.
     */
    public static void calculateStartAndEndRange() {
        startRange = anniversaryDate.minusDays(30);
        endRange = anniversaryDate.plusDays(30);
    }

    /*
     *finds if start and end Ranges is allowable date Range.
     */
    public static void findAllowableDateRange() {
        calculateAnniversaryDate(currentLocalDate.getYear());
        calculateStartAndEndRange();

        if (currentLocalDate.getYear() <= signupLocalDate.getYear()) {
            noRange();
        }

        else if (currentLocalDate.isAfter(startRange)) {
            if (currentLocalDate.isBefore(endRange))
                partialRange();
            else
                fullRange();
        }

        else {
            calculateAnniversaryDate(currentLocalDate.getYear()-1);
            calculateStartAndEndRange();
            if (currentLocalDate.getYear() - 1 == signupLocalDate.getYear()){
                noRange();
            }
            else if (currentLocalDate.isAfter(startRange)) {
                if (currentLocalDate.isBefore(endRange))
                    partialRange();
                else
                    fullRange();
            }
        }
    }

    public static void noRange() {
        allowableDateRange = "No Range";
    }

    public static void partialRange() {
         allowableDateRange = startRange.format(formatter) + " " + currentLocalDate.format(formatter);
    }

    public static void fullRange() {
        allowableDateRange = startRange.format(formatter) + " " + endRange.format(formatter);
    }

    /*
     *prints allowable date range for Form date.
     */
    private static void printAllowableDateRange(){
       log.info(allowableDateRange);
    }

    /*
     *It gets the input from TestCase.java
     */
    public void setCustomerDetails(String testSignupDate, String testCurrentDate) {
        signupDate = testSignupDate;
        currentDate = testCurrentDate;
    }

    /*
     *It returns allowable date Range to TestCase.java
     */
    public String getAllowableDateRange() {
        return allowableDateRange;
    }

}





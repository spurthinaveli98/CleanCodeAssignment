package MeaningfulNames;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Logger;

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
            log.warning("Please enter date in 'dd-mm-yyyy' format");
        }

    }

    private static void getCustomerDetails() {
        log.info("Enter signup date and current date respectively");
        signupDate = sc.next();
        currentDate = sc.next();
    }

    public static void calculateDateRange() {
        changeToDateTimeFormat();
        findAllowableDateRange();
    }

    public static void changeToDateTimeFormat() {
        signupLocalDate = LocalDate.parse(signupDate, formatter);
        currentLocalDate = LocalDate.parse(currentDate, formatter);
    }

    public static void calculateAnniversaryDate(int year) {
        anniversaryDate = LocalDate.of(year, signupLocalDate.getMonth(), signupLocalDate.getDayOfMonth());
    }

    public static void calculateStartAndEndRange() {
        startRange = anniversaryDate.minusDays(30);
        endRange = anniversaryDate.plusDays(30);
    }

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

    private static void printAllowableDateRange(){
       log.info(allowableDateRange);
    }

    public void setCustomerDetails(String testSignupDate, String testCurrentDate) {
        signupDate = testSignupDate;
        currentDate = testCurrentDate;
    }

    public String getAllowableDateRange() {
        return allowableDateRange;
    }

}





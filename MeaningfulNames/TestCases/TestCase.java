import MeaningfulNames.KnowYourCustomer;
import org.junit.Assert;
import org.junit.Test;

public class TestCase {
    @Test
    public void testcase1(){
        KnowYourCustomer test=new KnowYourCustomer();
        String testSignupDate = "04-05-2017";
        String testCurrentDate = "04-04-2017";
        test.setCustomerDetails(testSignupDate,testCurrentDate);
        String expectedOutput="No Range";
        test.calculateDateRange();
        String actualOutput=test.getAllowableDateRange() ;
        Assert.assertEquals(expectedOutput,actualOutput);
    }

    @Test
    public void testcase2(){
        KnowYourCustomer test=new KnowYourCustomer();
        String testSignupDate = "16-07-1998";
        String testCurrentDate = "27-06-2017";
        test.setCustomerDetails(testSignupDate,testCurrentDate);
        String expectedOutput="16-06-2017 27-06-2017";
        test.calculateDateRange();
        String actualOutput=test.getAllowableDateRange() ;
        Assert.assertEquals(expectedOutput,actualOutput);
    }

    @Test
    public void testcase3(){
        KnowYourCustomer test=new KnowYourCustomer();
        String testSignupDate = "04-04-2015";
        String testCurrentDate = "04-04-2016";
        test.setCustomerDetails(testSignupDate,testCurrentDate);
        String expectedOutput="05-03-2016 04-04-2016";
        test.calculateDateRange();
        String actualOutput=test.getAllowableDateRange() ;
        Assert.assertEquals(expectedOutput,actualOutput);
    }

    @Test
    public void testcase4(){
        KnowYourCustomer test=new KnowYourCustomer();
        String testSignupDate = "04-02-2016";
        String testCurrentDate = "04-04-2017";
        test.setCustomerDetails(testSignupDate,testCurrentDate);
        String expectedOutput="05-01-2017 06-03-2017";
        test.calculateDateRange();
        String actualOutput=test.getAllowableDateRange() ;
        Assert.assertEquals(expectedOutput,actualOutput);
    }

    @Test
    public void testcase5(){
        KnowYourCustomer test=new KnowYourCustomer();
        String testSignupDate = "04-04-2015";
        String testCurrentDate = "15-03-2016";
        test.setCustomerDetails(testSignupDate,testCurrentDate);
        String expectedOutput="05-03-2016 15-03-2016";
        test.calculateDateRange();
        String actualOutput=test.getAllowableDateRange() ;
        Assert.assertEquals(expectedOutput,actualOutput);
    }

    @Test
    public void testcase6(){
        KnowYourCustomer test=new KnowYourCustomer();
        String testSignupDate = "30-12-2010";
        String testCurrentDate = "01-01-2018";
        test.setCustomerDetails(testSignupDate,testCurrentDate);
        String expectedOutput="30-11-2017 01-01-2018";
        test.calculateDateRange();
        String actualOutput=test.getAllowableDateRange() ;
        Assert.assertEquals(expectedOutput,actualOutput);
    }

    @Test
    public void testcase7(){
        KnowYourCustomer test=new KnowYourCustomer();
        String testSignupDate = "30-12-2015";
        String testCurrentDate = "03-01-2016";
        test.setCustomerDetails(testSignupDate,testCurrentDate);
        String expectedOutput="No Range";
        test.calculateDateRange();
        String actualOutput=test.getAllowableDateRange() ;
        Assert.assertEquals(expectedOutput,actualOutput);
    }

    @Test
    public void testcase8(){
        KnowYourCustomer test=new KnowYourCustomer();
        String testSignupDate = "31-12-2010";
        String testCurrentDate = "03-01-2018";
        test.setCustomerDetails(testSignupDate,testCurrentDate);
        String expectedOutput="01-12-2017 03-01-2018";
        test.calculateDateRange();
        String actualOutput=test.getAllowableDateRange() ;
        Assert.assertEquals(expectedOutput,actualOutput);
    }


}

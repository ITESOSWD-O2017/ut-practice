package iteso.mx.ut_practice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestDate {

    Date dateCalculator;

    @Before
    public void setup() {
        dateCalculator = new Date();
    }

    @Test
    public void validDate() {
        dateCalculator.setDate("02/10/1996");
        Assert.assertEquals(
                dateCalculator.calculateAge(),
                "21 years, 0 months and 23 days"
        );
    }

    @Test
    public void distinctFormat() {
        dateCalculator.setDate("02-10-1996");
        Assert.assertEquals(
                dateCalculator.calculateAge(),
                "Please enter a date with a valid format"
        );
    }

    @Test
    public void invalidDay() {
        dateCalculator.setDate("33/10/1996");
        Assert.assertEquals(
                dateCalculator.calculateAge(),
                "Please enter a valid day"
        );
    }

    @Test
    public void invalidMonth() {
        dateCalculator.setDate("02/15/1996");
        Assert.assertEquals(
                dateCalculator.calculateAge(),
                "Please enter a valid month"
        );
    }

    @Test
    public void invalidYear() {
        dateCalculator.setDate("02/10/ABCD");
        Assert.assertEquals(
                dateCalculator.calculateAge(),
                "Please enter a date with a valid format"
        );
    }

    @Test
    public void futureDate() {
        dateCalculator.setDate("02/10/2096");
        Assert.assertEquals(
                dateCalculator.calculateAge(),
                "Please enter a past date"
        );
    }

    @Test
    public void emptyDate(){
        dateCalculator.ageCalc("","");
        Assert.assertEquals(
                dateCalculator.ageCalc("01/01/2000","10/07/2029"),
                "Date is empty, please enter a valid date"
        );
    }

    @Test
    public void incorrectDate(){
        dateCalculator.ageCalc("19/07/2017","19/07/1996");
        Assert.assertEquals(
                dateCalculator.ageCalc("","19/07/2017"),
                "Please enter a valid date, one of the dates is incorrect or empty"
        );
    }

    @Test
    public void validAge(){
        dateCalculator.ageCalc("19/07/1996","19/07/2017");
        Assert.assertEquals(
                dateCalculator.ageCalc("04/12/1964","04/12/1964"),
                "21 years, 0 months and 0 days"
        );
    }

}


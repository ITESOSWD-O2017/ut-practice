package iteso.mx.ut_practice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.regex.Pattern;

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
               "21 years, 0 months and 24 days",
                dateCalculator.calculateAge()
        );
    }

    @Test
    public void distinctFormat() {
        dateCalculator.setDate("02-10-1996");
        Assert.assertEquals(
                "Please enter a date with a valid format",
                dateCalculator.calculateAge()
        );
    }

    @Test
    public void invalidDay() {
        dateCalculator.setDate("33/10/1996");
        Assert.assertEquals(
               "Please enter a valid day",
                dateCalculator.calculateAge()
        );
    }

    @Test
    public void invalidMonth() {
        dateCalculator.setDate("02/15/1996");
        Assert.assertEquals(
               "Please enter a valid month",
                dateCalculator.calculateAge()
        );
    }

    @Test
    public void invalidYear() {
        dateCalculator.setDate("02/10/ABCD");
        Assert.assertEquals(
               "Please enter a date with a valid format",
                dateCalculator.calculateAge()
        );
    }

    @Test
    public void futureDate() {
        dateCalculator.setDate("02/10/2096");
        Assert.assertEquals(
             "Please enter a past date",
              dateCalculator.calculateAge()
        );
    }

    @Test
    public void hasValue(){
        Assert.assertEquals(
                "Please enter a date",
                dateCalculator.ageCalculation("","22/12/2025")
        );
    }

    @Test
    public void isNotSameDate(){
        Assert.assertEquals(
                "Please enter different dates",
                dateCalculator.ageCalculation("28/05/1994","28/05/1994")
        );
    }



}

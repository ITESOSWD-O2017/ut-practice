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
    public void wrongDates(){
        dateCalculator.ageCalculator("15/10/2000","18/12/1999");
        Assert.assertEquals(
                dateCalculator.ageCalculator("","22/12/2025"),
                "Please enter a future date than the first one"
        );
    }

    @Test
    public void dateExample(){
        dateCalculator.ageCalculator("24/05/1990","28/10/2017");
        Assert.assertEquals(
                dateCalculator.ageCalculator("28/05/1994","28/05/1994"),
                "27 years, 5 months and 4 days"
        );
    }

    @Test
    public void emptyDate(){
        dateCalculator.ageCalculator("","");
        Assert.assertEquals(
                dateCalculator.ageCalculator("","22/12/2025"),
                "Pleas enter a date"
        );
    }


}

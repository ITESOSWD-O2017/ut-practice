package iteso.mx.ut_practice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class TestDate {

    Date dateCalculator;

    @Before
    public void setup() {
        dateCalculator = new Date();
    }

    @Test
    public void validDate() {
        dateCalculator.setDate("02/10/1996");
        Assert.assertEquals("21 years, 0 months and 27 days",
                dateCalculator.calculateAge()

        );
    }

    @Test
    public void distinctFormat() {
        dateCalculator.setDate("02-10-1996");
        Assert.assertEquals("Please enter a date with a valid format",
                dateCalculator.calculateAge()

        );
    }

    @Test
    public void invalidDay() {
        dateCalculator.setDate("33/10/1996");
        Assert.assertEquals("Please enter a valid day",
                dateCalculator.calculateAge()
        );
    }

    @Test
    public void invalidMonth() {
        dateCalculator.setDate("02/15/1996");
        Assert.assertEquals("Please enter a valid month",
                dateCalculator.calculateAge()
        );
    }

    @Test
    public void invalidYear() {
        dateCalculator.setDate("02/10/ABCD");
        Assert.assertEquals("Please enter a date with a valid format",
                dateCalculator.calculateAge()
        );
    }

    @Test
    public void futureDate() {
        dateCalculator.setDate("02/10/2096");
        Assert.assertEquals("Please enter a past date",
                dateCalculator.calculateAge()
        );
    }
    @Test
    public void validDateCalculator() {
        Assert.assertEquals("29 years, 3 months and 29 days",
                dateCalculator.ageCalculation("29/06/1988", "28/10/2017")
        );
    }

}

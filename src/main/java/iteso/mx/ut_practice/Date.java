
package iteso.mx.ut_practice;

/**
 * Practice 2 software design.
 *
 * @author  Luis Fernando López Ruiz
 * @version 1.0
 * @since   2017-10-25
 */

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

/**
 * new class Date.
 */
class Date {

    /**
     * CONSTANT VALID.
     */
    private static final int VALID          = 0;
    /**
     * CONSTANT INVAID_DAY.
     */
    private static final int INVALID_DAY    = 1;
    /**
     * CONSTANT INVALID_MONTH.
     */
    private static final int INVALID_MONTH  = 2;
    /**
     * CONSTANT INVALID_YEAR.
     */
    private static final int INVALID_YEAR   = 3;

    /**
     * Variable date String.
     */
    private String date;

    /**
     * Constructor with attribute.
     * @param date1 blablabla
     */
    Date(final String date1) {
        setDate(date1);
    }

    /**
     * Setting date.
     * @param date1 blablabla
     */
    public void setDate(final String date1) {
        this.date = date1;
    }

    /**
     * This calculate the age.
     * @return regresa algo
     */
    protected String calculateAge() {
        String[] dateArr;
        LocalDate birthDay;
        LocalDate today;


        if (isCorrectFormat(date)) {
            dateArr = date.split("/");
        } else {
            return "Please enter a date with a valid format";
        }

        int validDate = isValidDate(
                Integer.parseInt(dateArr[0]),
                Integer.parseInt(dateArr[1]),
                Integer.parseInt(dateArr[2])
        );

        if (validDate == INVALID_DAY) {
            return "Please enter a valid day";
        } else if (validDate == INVALID_MONTH) {
            return "Please enter a valid month";
        } else if (validDate == INVALID_YEAR) {
            return "Please enter a valid month";
        } else {
            birthDay = LocalDate.of(
                    Integer.parseInt(dateArr[2]),
                    Integer.parseInt(dateArr[1]),
                    Integer.parseInt(dateArr[0]));
            today = LocalDate.now();
        }

        if (Period.between(birthDay, today).isNegative()) {
            return "Please enter a past date";
        }

        try {
            return Period.between(birthDay, today).getYears()
                    + " years, "
                    + Period.between(birthDay, today).getMonths()
                    + " months and "
                    + Period.between(birthDay, today).getDays()
                    + " days";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     * This check if it is correct the format.
     * @param date1 blablabla
     * @return retorna algo si...
     */
    protected boolean isCorrectFormat(final String date1) {
        // Use regex to validate
        String datePattern = "\\d{2}\\/\\d{2}\\/\\d{4}";
        return date1.matches(datePattern);
    }

    /**
     * Is it valid the date.
     * @param day blablabla
     * @param month blablabla
     * @param year blablabla
     * @return retorna algo si...
     */
    protected int isValidDate(final int day, final int month, final int year) {

        try {
            LocalDate.of(year, month, day);
        } catch (DateTimeException e) {
            if (e.getMessage().contains("DayOfMonth")) {
                return INVALID_DAY;
            } else
            if (e.getMessage().contains("MonthOfYear")) {
                return INVALID_MONTH;
            } else
            if (e.getMessage().contains("Year")) {
                return INVALID_YEAR;
            }
        }
        return VALID;
    }

}

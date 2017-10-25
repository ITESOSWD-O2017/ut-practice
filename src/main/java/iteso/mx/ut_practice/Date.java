package iteso.mx.ut_practice;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

/**
 * Clase Date.
 */
class Date {
    /**
     * atributo valid.
     */
    private static final int VALID          = 0;
    /**
     * atributo invalid day.
     */
    private static final int INVALID_DAY    = 1;
    /**
     * atributo invalid month.
     */
    private static final int INVALID_MONTH  = 2;
    /**
     * atributo invalid year.
     */
    private static final int INVALID_YEAR   = 3;
    /**
     * atributo date.
     */
    private String date;

    /**
     * Constructor Date.
     */
    Date() {

    }

    /**
     *
     * @param date1 fecha.
     */
    Date(final String date1) {
        setDate(date1);
    }

    /**
     *
     * @param date1 fecha.
     */
    public void setDate(final String date1) {
        this.date = date;
    }

    /**
     *
     * @return calculateAge.
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
            return Period.between(birthDay, today).getYears() + " years, "
                    +
                    Period.between(birthDay, today).getMonths() + " months and "
                    +
                    Period.between(birthDay, today).getDays() + " days";
        } catch (Exception e) {
            /**
             *Exception e.
             */
            return e.getMessage();
        }
    }

    /**
     *
     * @param date1 fecha.
     * @return Correctformat.
     */
    protected boolean isCorrectFormat(final String date1) {
        // Use regex to validate
        String datePattern = "\\d{2}\\/\\d{2}\\/\\d{4}";
        return date.matches(datePattern);
    }

    /**
     *
     * @param day dia.
     * @param month mes.
     * @param year año.
     * @return return.
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

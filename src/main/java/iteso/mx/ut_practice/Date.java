
package iteso.mx.ut_practice;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 */
final class Date {
    /**
     *
     */
    private static final int VALID          = 0;
    /**
     *
     */
    private static final int INVALID_DAY    = 1;
    /**
     *
     */
    private static final int INVALID_MONTH  = 2;
    /**
     *
     */
    private static final int INVALID_YEAR   = 3;
    /**
     *
     */
    private String date;

    /**
     *
     */
    private Date() {

    }

    /**
     *
     * @param datea ok
     */
    private Date(final String datea) {
        setDate(datea);
    }

    /**
     *
     * @param dateA ok
     */
    public void setDate(final String dateA) {
        this.date = dateA;
    }

    /**
     *
     * @return ok
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
                    + Period.between(birthDay, today).getMonths()
                    + " months and "
                    + Period.between(birthDay, today).getDays() + " days";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     *
     * @param dateA ok
     * @return ok
     */
    protected boolean isCorrectFormat(final String dateA) {
        // Use regex to validate
        String datePattern = "\\d{2}\\/\\d{2}\\/\\d{4}";
        return dateA.matches(datePattern);
    }
/**Javadoc Comment.
@param day  dia
 @param month mes
 @param year año
 @return retorno
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

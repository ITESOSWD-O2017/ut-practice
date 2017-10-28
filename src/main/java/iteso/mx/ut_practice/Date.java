package iteso.mx.ut_practice;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

/** Date. */
class Date {
    /** Valid. */
    private static final int VALID          = 0;
    /** Invalid day. */
    private static final int INVALID_DAY    = 1;
    /** Invalid month. */
    private static final int INVALID_MONTH  = 2;
    /** Invalid year. */
    private static final int INVALID_YEAR   = 3;
    /** Date. */
    private String date;

    /** Constructor. */
    Date() {
    }
    /** @param myDate myDate. */
    Date(final String myDate) {
        setDate(myDate);
    }

    /** @param myDate myDate. */
    public void setDate(final String myDate) {
        this.date = myDate;
    }
    /** Calculate age.
     * @return String
     * */
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
                    + " years, " + Period.between(birthDay, today).getMonths()
                    + " months and " + Period.between(birthDay, today).getDays()
                    + " days";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /** @param myDate date
     * @return date.matches(datePattern)
     * */
    protected boolean isCorrectFormat(final String myDate) {
        // Use regex to validate
        String datePattern = "\\d{2}\\/\\d{2}\\/\\d{4}";
        return myDate.matches(datePattern);
    }

    /** @param day day
     * @param month month
     * @param year year
     * @return VALID
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

    /**
     * @param birthday birthday
     * @param futureDay another day of the future
     * @return result
    */
    protected String ageCalculation(
            final String birthday, final String futureDay) {
        String[] birthdayDateArray;
        String[] futureDateArray;
        LocalDate birth;
        LocalDate future;

        if (isCorrectFormat(birthday) && isCorrectFormat(futureDay)) {
            birthdayDateArray = birthday.split("/");
            futureDateArray = futureDay.split("/");
        } else {
            return "Please enter a date with a valid format";
        }

        int birthdayValidDate = isValidDate(
                Integer.parseInt(birthdayDateArray[0]),
                Integer.parseInt(birthdayDateArray[1]),
                Integer.parseInt(birthdayDateArray[2])
        );
        int futureValidDate = isValidDate(
                Integer.parseInt(futureDateArray[0]),
                Integer.parseInt(futureDateArray[1]),
                Integer.parseInt(futureDateArray[2])
        );

        if ((birthdayValidDate == INVALID_DAY)
                || (futureValidDate == INVALID_DAY)) {
            return "Please enter a valid day";
        } else if ((birthdayValidDate == INVALID_MONTH)
                || (futureValidDate == INVALID_MONTH)) {
            return "Please enter a valid month";
        } else if ((birthdayValidDate == INVALID_YEAR)
                || (futureValidDate == INVALID_YEAR)) {
            return "Please enter a valid year";
        } else {
            birth = LocalDate.of(
                    Integer.parseInt(birthdayDateArray[2]),
                    Integer.parseInt(birthdayDateArray[1]),
                    Integer.parseInt(birthdayDateArray[0]));
            future = LocalDate.of(
                    Integer.parseInt(futureDateArray[2]),
                    Integer.parseInt(futureDateArray[1]),
                    Integer.parseInt(futureDateArray[0]));
        }

        if (Period.between(birth, future).isNegative()) {
            return "Please enter a past date";
        }

        try {
            return Period.between(birth, future).getYears()
                    + " years, " + Period.between(birth, future).getMonths()
                    + " months and " + Period.between(birth, future).getDays()
                    + " days";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}

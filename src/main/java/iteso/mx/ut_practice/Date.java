
package iteso.mx.ut_practice;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

/**.
 * Clase Date.
 */
class Date {
    /**.
     * Variable Valid.
     */
    private static final int VALID          = 0;
    /**.
     * Variable Invalid day.
     */
    private static final int INVALID_DAY    = 1;
    /**.
     * Variable Invalid month.
     */
    private static final int INVALID_MONTH  = 2;
    /**.
     * Invalid year.
     */
    private static final int INVALID_YEAR   = 3;

    /**.
     * Variable date.
     */
    private String date;


    /**
     * Constructor.
     */
    Date() {


    }

    /**
     *
     * @param date1 fecha1
     */
    Date(final String date1) {

        setDate(date);
    }

    /**
     *
     * @param date1 fecha1
     */
    public void setDate(final String date1) {
        this.date = date;
    }

    /**
     *
     * @return retorno
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
        /**
         * Validacion de fechas
         */
        try {
            return Period.between(birthDay, today).getYears() + " years, "
                    + Period.between(birthDay, today).getMonths() + "months and"
                    + Period.between(birthDay, today).getDays() + " days";
        } catch (Exception e) {
            /**
             * Exception e.
             */
            return e.getMessage();
            /**
             * Obtiene mensaje.
             */
        }
    }

    /**
     *
     * @param date1 fecha1
     * @return retorno
     */
    protected boolean isCorrectFormat(final String date1) {
        /**
         * Funcion para verificar si el formato es correcto.
         */
        // Use regex to validate
        String datePattern = "\\d{2}\\/\\d{2}\\/\\d{4}";
        return date.matches(datePattern);
    }

    /**
     *
     * @param day dia
     * @param month mes
     * @param year año
     * @return retorno
     */
    protected int isValidDate(final int day, final int month, final int year) {
        /**
         *
         *@param day recibe como parametro el dia
         *@param month recibe como parametro el mes
         *@param year recibe como parametro el año
         */

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
     *
     *
     * @param firstDate firstDate
     * @param secondDate firstDate
     * @return ret
     */
    protected String ageCalc(final String firstDate, final String secondDate) {
        LocalDate date1;
        LocalDate date2;
        String[] dateArr1;
        String[] dateArr2;


        if (isCorrectFormat(firstDate) && isCorrectFormat(secondDate)) {
            dateArr1 = firstDate.split("/");
            dateArr2 = secondDate.split("/");
        } else {
            return "Please enter a date with a correct format";
        }

        if (firstDate == "" || secondDate == "") {
            return "Date is empty, please enter a valid date";
        }

        if (firstDate == secondDate) {
            return "Dates are the same, please enter different dates";
        }

        int validDate = isValidDate(
                Integer.parseInt(dateArr1[0]),
                Integer.parseInt(dateArr1[1]),
                Integer.parseInt(dateArr1[2])
        );

        int validDate2 = isValidDate(
                Integer.parseInt(dateArr2[0]),
                Integer.parseInt(dateArr2[1]),
                Integer.parseInt(dateArr2[2])
        );

        if (validDate == INVALID_DAY || validDate2 == INVALID_DAY) {
            return "Please enter a valid day";
        } else if (validDate == INVALID_MONTH || validDate2 == INVALID_MONTH) {
            return "Please enter a valid month";
        } else if (validDate == INVALID_YEAR || validDate2 == INVALID_YEAR) {
            return "Please enter a valid month";
        } else {
            date1 = LocalDate.of(
                    Integer.parseInt(dateArr1[2]),
                    Integer.parseInt(dateArr1[1]),
                    Integer.parseInt(dateArr1[0]));

            date2 = LocalDate.of(
                    Integer.parseInt(dateArr2[2]),
                    Integer.parseInt(dateArr2[1]),
                    Integer.parseInt(dateArr2[0]));

        }

        if (Period.between(date1, date2).isNegative()) {
            return "Dates are incorrect, please enter valid dates";
        }

        try {
            return Period.between(date1, date2).getYears() + " years, "
                    + Period.between(date1, date2).getMonths()
                    + " months and "
                    + Period.between(date1, date2).getDays() + " days";
        } catch (Exception e) {
            return e.getMessage();
        }

    }


}

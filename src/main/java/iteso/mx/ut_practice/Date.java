
package iteso.mx.ut_practice;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

/**
 * Class Date.
 */
class Date {
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
     * Constructor.
     */
    Date() {

    }
    /**
     *
     * @param date2 El parametro de la fecha
     */
    public void setDate(final String date2) {
        this.date = date;
    }

    /**
     *
     * @return String.
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
            return "Please enter a valid year";
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
                    + Period.between(birthDay, today).getDays()
                    + " days";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     *
     * @param date3 El parametro de fecha
     * @return boolean Regresa si es formato correcto
     */
    protected boolean isCorrectFormat(final String date3) {
        // Use regex to validate.
        String datePattern = "\\d{2}\\/\\d{2}\\/\\d{4}";
        return date3.matches(datePattern);
    }

    /**
     *
     * @param day recibe el parametro de day
     * @param month recibe el mes
     * @param year recibe el año
     * @return int regresa un entero
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
     *
     * @param dateini recibe fecha de inicio
     * @param datefin recibe fecha final
     * @return String la fecha calculada
     */
    protected String calculYB(final String dateini, final String datefin) {
        String[] datearr;
        String[] datearr1;
        LocalDate fecha1;
        LocalDate fecha2;




        if (isCorrectFormat(dateini)) {
            datearr = dateini.split("/");
        } else {
            return "Please enter a date with a valid format";
        }

        if (isCorrectFormat(datefin)) {
            datearr1 = datefin.split("/");
        } else {
            return "Please enter a date with a valid format";
        }
        //Fecha1.
        int validDate = isValidDate(
                Integer.parseInt(datearr[0]),
                Integer.parseInt(datearr[1]),
                Integer.parseInt(datearr[2])
        );

        if (validDate == INVALID_DAY) {
            return "Please enter a valid day";
        } else if (validDate == INVALID_MONTH) {
            return "Please enter a valid month";
        } else if (validDate == INVALID_YEAR) {
            return "Please enter a valid year";
        } else {
            fecha1 = LocalDate.of(
                    Integer.parseInt(datearr[2]),
                    Integer.parseInt(datearr[1]),
                    Integer.parseInt(datearr[0]));
        }

        //Fecha2.
        validDate = isValidDate(
                Integer.parseInt(datearr1[0]),
                Integer.parseInt(datearr1[1]),
                Integer.parseInt(datearr1[2])
        );

        if (validDate == INVALID_DAY) {
            return "Please enter a valid day";
        } else if (validDate == INVALID_MONTH) {
            return "Please enter a valid month";
        } else if (validDate == INVALID_YEAR) {
            return "Please enter a valid year";
        } else {
            fecha2 = LocalDate.of(
                    Integer.parseInt(datearr1[2]),
                    Integer.parseInt(datearr1[1]),
                    Integer.parseInt(datearr1[0]));
        }

        if (Period.between(fecha1, fecha2).isNegative()) {
            return "The second date is in the past";
        }

        try {
            return Period.between(fecha1, fecha2).getYears() + " years, "
                    + Period.between(fecha1, fecha2).getMonths()
                    + " months and "
                    + Period.between(fecha1, fecha2).getDays()
                    + " days";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}

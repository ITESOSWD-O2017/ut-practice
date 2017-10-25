
package iteso.mx.ut_practice;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;

/**
 * Clase para calcular la edad dado
 * su fecha de nacimiento.
 */
class Date {

    /**
     * Estado de fecha válido.
     */
    private static final int VALID          = 0;
    /**
     * Estado de fecha invalida por numero de día.
     */
    private static final int INVALID_DAY    = 1;
    /**
     * Estado de fecha invalida por numero de mes.
     */
    private static final int INVALID_MONTH  = 2;
    /**
     * Estado de fecha invalida por numero de año.
     */
    private static final int INVALID_YEAR   = 3;

    /**
     * Cadena para guardar la fecha.
     */
    private String date;

    /**
     * Constructor default.
     */
    Date() {

    }

    /**
     * Constructor.
     * @param cdate Cadena de texto con fecha.
     */
    Date(final String cdate) {
        setDate(cdate);
    }

    /**
     * Setter.
     * @param cdate Define la cadena de la fecha en la clase.
     */
    public void setDate(final String cdate) {
        this.date = cdate;
    }

    /**
     *
     * @return El resultado en texto del calculo de edad, incluyendo errores.
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
                    +
                    Period.between(birthDay, today).getMonths()
                    + " months and "
                    +
                    Period.between(birthDay, today).getDays()
                    + " days";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    /**
     *
     * @param cdate Fecha en cadena de texto.
     * @return Si la fecha esta en un formato válido.
     */
    protected boolean isCorrectFormat(final String cdate) {
        // Use regex to validate
        String datePattern = "\\d{2}\\/\\d{2}\\/\\d{4}";
        return cdate.matches(datePattern);
    }

    /**
     *
     * @param day Día de fecha a comparar.
     * @param month Mes de fecha a comparar.
     * @param year Año de fecha a comparar.
     * @return Si la fecha es valida, incluyendo errores.
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

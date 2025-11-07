package cs112.ud3.UD2.Tools;

/**
 * A tool used to format dates with conditions preventing invalid dates.
 * 
 * @author Andrew Ibarra
 * @version 1.0
 */
public class Date {

    // INSTANCE VARIABLES //

    private String strMonth, strMonthAbbv;
    private int day, month, year;

    // DEFAULT INSTANCE VARIABLES //

    private final int DEFAULT_DAY = 1, DEFAULT_MONTH = 1, DEFAULT_YEAR = 1900;

    // CONSTRUCTORS //

    public Date() {
        setMonth(DEFAULT_MONTH);
        setDay(DEFAULT_DAY);
        setYear(DEFAULT_YEAR);
    }

    public Date(int month, int day, int year) {
        setMonth(month);
        setDay(day);
        setYear(year);
    }

    public Date(Date date) {
        setMonth(date.getMonth());
        setDay(date.getDay());
        setYear(date.getYear());
    }

    // ACCESSORS & MUTATORS //

    public boolean setDay(int day) {

        switch (month) {
            case 2:
                if ((isLeapYear(year) && day > 29) || (!isLeapYear(year) && day > 28)) {
                    this.day = 1;
                    return setMonth(3);
                } else if (day <= 0) {
                    return false;
                }
                this.day = day;
                return true;
            case 4:
            case 6:
            case 9:
            case 11:
                if (day > 30) {
                    this.day = 1;
                    return setMonth(getMonth() + 1);
                } else if (day <= 0) {
                    return false;
                }
                this.day = day;
                return true;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if (day > 31) {
                    this.day = 1;
                    return setMonth(getMonth() + 1);
                } else if (day <= 0) {
                    return false;
                }
                this.day = day;
                return true;
            default:
                return false;
        }
    }

    public int getDay() {
        return day;
    }

    public boolean setMonth(int month) {

        switch (month) {
            case 2:
                if (isLeapYear(year) && day > 29) {
                    return false;
                } else if (!isLeapYear(year) && day > 28) {
                    return false;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                if (day == 31) {
                    return false;
                }
                break;
        }
        if (1 <= month && month <= 12) {
            this.month = month;
            return updateStrMonth();
        } else if (month == 13) {
            setMonth(1);
            updateStrMonth();
            return setYear(getYear() + 1);
        }
        return false;
    }

    public int getMonth() {
        return month;
    }

    public boolean setYear(int year) {

        if (1900 <= year && year <= 2100) {
            this.year = year;
            return true;
        }
        return false;
    }

    public int getYear() {
        return year;
    }

    public String getStrMonth() {
        return strMonth;
    }

    public String getStrMonthAbbv() {
        return strMonthAbbv;
    }

    // METHODS //

    public boolean equals(Date other) {
        if (this.day == other.day && this.month == other.month && this.year == other.year) {
            return true;
        }
        return false;
    }

    public String toString() {
        return String.format("%02d/%02d/%04d", getMonth(), getDay(), getYear());
    }

    public String toStringMonth() {
        return String.format("%s %s, %d", getStrMonth(), giveSubscript(getDay()), getYear());
    }

    public String toStringMonthAbbv() {
        return String.format("%s %s, %d", getStrMonthAbbv(), giveSubscript(getDay()), getYear());
    }

    public boolean advanceDay() {
        return setDay(getDay() + 1);
    }

    private boolean isLeapYear(int year) {
        return ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
    }

    private String giveSubscript(int num) {

        if (11 <= num % 100 && num % 100 <= 13) {
            return num + "th";
        }

        switch (num % 10) {
            case 1:
                return num + "st";
            case 2:
                return num + "nd";
            case 3:
                return num + "rd";
            default:
                return num + "th";
        }
    }

    private boolean updateStrMonth() {
        switch (month) {
            case 1:
                strMonth = "January";
                strMonthAbbv = "Jan";
                return true;
            case 2:
                strMonth = "February";
                strMonthAbbv = "Feb";
                return true;
            case 3:
                strMonth = "March";
                strMonthAbbv = "Mar";
                return true;
            case 4:
                strMonth = "April";
                strMonthAbbv = "Apr";
                return true;
            case 5:
                strMonth = "May";
                strMonthAbbv = "May";
                return true;
            case 6:
                strMonth = "June";
                strMonthAbbv = "Jun";
                return true;
            case 7:
                strMonth = "July";
                strMonthAbbv = "Jul";
                return true;
            case 8:
                strMonth = "August";
                strMonthAbbv = "Aug";
                return true;
            case 9:
                strMonth = "September";
                strMonthAbbv = "Sep";
                return true;
            case 10:
                strMonth = "October";
                strMonthAbbv = "Oct";
                return true;
            case 11:
                strMonth = "November";
                strMonthAbbv = "Nov";
                return true;
            case 12:
                strMonth = "December";
                strMonthAbbv = "Dec";
                return true;
            default:
                strMonth = null;
                strMonthAbbv = null;
        }
        return false;
    }

}

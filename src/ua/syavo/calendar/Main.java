package ua.syavo.calendar;

import java.time.*;

public class Main {

    public static void main(String[] args) {

        YearMonth yearMonth = YearMonth.of(2015, 11);
        Calendar calendar = new Calendar();
        calendar.printCalendar(yearMonth);

    }
}

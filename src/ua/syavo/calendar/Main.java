package ua.syavo.calendar;

import java.time.*;

public class Main {

    public static void main(String[] args) {

        YearMonth yearMonth = YearMonth.of(2016, 12);
        MyCalendarClass myCalendarClass = new MyCalendarClass();
        myCalendarClass.printYearMonth(yearMonth);
        
    }
}

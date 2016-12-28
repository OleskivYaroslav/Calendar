package ua.syavo.calendar;

import java.time.*;
import java.time.format.*;
import java.util.*;

/**
 * Created by Syavo on 28.12.2016.
 */

public class MyCalendarClass {

    private final LocalDate today = LocalDate.now();
    private final int firstDayOfMonth = 1;
    private YearMonth yearMonthOfToday = YearMonth.of(today.getYear(), today.getMonth());
    private ArrayList<LocalDate> monthsDays = new ArrayList<LocalDate>();


    public void printMyCalendar(YearMonth yearMonth){
        printingYearAndMonth(yearMonth);
        printingShortDaysOfWeek();
        tabbingForFirstDayOfMonthInWeek(yearMonth);
        creatingDaysListOfMonth(yearMonth);
        printingDaysOfMonth();
    }

    public void printMyCalendar(){
        printMyCalendar(this.yearMonthOfToday);
    }

    private void tabbingForFirstDayOfMonthInWeek(YearMonth yearMonth){
        LocalDate firstDayOfMonth = LocalDate.of(yearMonth.getYear(), yearMonth.getMonth(), this.firstDayOfMonth);
        DayOfWeek firstDayOfMonthInWeek = firstDayOfMonth.getDayOfWeek();
        String temp = "";
        for(int i = DayOfWeek.MONDAY.getValue(); i<firstDayOfMonthInWeek.getValue(); i++)
            temp +="     ";
        System.out.println();
        System.out.print(temp);
    }

    private void printingShortDaysOfWeek(){
        for (DayOfWeek i : DayOfWeek.values()){
            System.out.print(i.getDisplayName(TextStyle.SHORT , Locale.ENGLISH)+"  ");
        }
    }

    private void printingYearAndMonth(YearMonth yearMonth){
        System.out.println(yearMonth.getMonth() + " of "+yearMonth.getYear());
    }

    private void creatingDaysListOfMonth(YearMonth yearMonth){
        for(int i = this.firstDayOfMonth; i <= yearMonth.lengthOfMonth(); i++){
            LocalDate someDay = LocalDate.of(yearMonth.getYear(), yearMonth.getMonth(), i);
            this.monthsDays.add(someDay);
        }
    }

    private void printingDaysOfMonth(){

        for (LocalDate i: this.monthsDays) {
            System.out.printf(gettingColorOfDay(i), i.getDayOfMonth());
        }
    }

    private String gettingColorOfDay(LocalDate day){
        String temp;
        if(day.getDayOfWeek().getValue()== DayOfWeek.MONDAY.getValue()) System.out.println();
        temp = "\u001B[0m%-5d";
        if(day.getDayOfWeek().getValue()== DayOfWeek.SATURDAY.getValue()
                || day.getDayOfWeek().getValue()== DayOfWeek.SUNDAY.getValue()) {
            temp = "\u001B[0m\u001B[31m%-5d";  // doing day red color if it is SATURDAY or SUNDAY
        }
        if(day.equals(today)){
            temp = "\u001B[0m\u001B[32m%-5d";  // doing day green color if it is today
        }
        return temp;
    }

}

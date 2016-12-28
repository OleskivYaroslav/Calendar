package ua.syavo.calendar;

import java.time.*;
import java.time.format.*;
import java.util.*;

public class Calendar {

    private LocalDate today = LocalDate.now();
    private final int firstDayOfMonth = 1;
    private YearMonth yearMonthOfToday = YearMonth.of(today.getYear(), today.getMonth());
    private List<LocalDate> monthsDays = new ArrayList<>();


    public void printCalendar(YearMonth yearMonth){
        printYearAndMonth(yearMonth);
        printShortDaysOfWeek();
        printTabForFirstDayOfMonth(yearMonth);
        creatDaysListOfMonth(yearMonth);
        printDaysOfMonth();
    }

    public void printCalendar(){
        printCalendar(this.yearMonthOfToday);
    }

    private void printTabForFirstDayOfMonth(YearMonth yearMonth){
        LocalDate firstDayOfMonth = LocalDate.of(yearMonth.getYear(), yearMonth.getMonth(), this.firstDayOfMonth);
        DayOfWeek firstDayOfMonthInWeek = firstDayOfMonth.getDayOfWeek();
        String temp = "";
        for(int i = DayOfWeek.MONDAY.getValue(); i<firstDayOfMonthInWeek.getValue(); i++)
            temp +="     ";
        System.out.println();
        System.out.print(temp);
    }

    private void printShortDaysOfWeek(){
        for (DayOfWeek i : DayOfWeek.values()){
            System.out.printf(i.getDisplayName(TextStyle.SHORT , Locale.ENGLISH)+"  ");
        }
    }

    private void printYearAndMonth(YearMonth yearMonth){
        System.out.println(yearMonth.getMonth() + " of "+yearMonth.getYear());
    }

    private void creatDaysListOfMonth(YearMonth yearMonth){
        LocalDate dayInMonth;
        for(int i = this.firstDayOfMonth; i <= yearMonth.lengthOfMonth(); i++){
            dayInMonth = LocalDate.of(yearMonth.getYear(), yearMonth.getMonth(), i);
            this.monthsDays.add(dayInMonth);
        }
    }

    private void printDaysOfMonth(){

        for (LocalDate i: this.monthsDays) {
            System.out.printf(getColorOfDay(i), i.getDayOfMonth());
        }
    }

    private String getColorOfDay(LocalDate day){
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

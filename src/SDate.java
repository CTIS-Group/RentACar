
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gencturk
 */
public class SDate {
    
    int day,
            month,
            year;
    private static int dayCount[] = {31,28,31,30,31,30,31,31,30,31,30,31};
    
    public SDate()
    {
        Date date = new Date();
        day = date.getDate();
        month = date.getMonth() + 1;
        year = date.getYear() + 1900;
    }
    
    public SDate(int day, int month, int year) 
    {
        this.day = day;
        if(month < 1 || month > 12)
            month = 1;
        this.month = month;
        this.year = year;
    }
    
    public SDate(String day, String month, String year) {
        this.day = Integer.parseInt(day);
        int m = Integer.parseInt(month);
        if(m < 1 || m > 12)
            m = 1;
        this.month = m;
        this.year = Integer.parseInt(year);
    }
    
    public void passDays(int days)
    {
        day += days;
        int years = 0;
        while(day > dayCount[month - 1])
        {
            day -= dayCount[month - 1];
            month++;
            if(month == 13)
            {
                month = 1;
                years++;
            }
        }
        year += years;
    }
    
    public int differenceInDays(SDate date)
    {
        int difference = 0;
        for(int i = 1; i < month; i++)
        {
            difference += dayCount[i - 1];
        }
        for(int i = 1; i < date.getMonth(); i++)
        {
            difference -= dayCount[i - 1];
        }
        difference = difference + day - date.getDay() + (year - date.getYear()) * 365;
        return difference;
    }
    
    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }    
    
    public static int getDaysOfMonth(int month)
    {
        return dayCount[month - 1];
    }
    
    public String toString()
    {
        return day + "." + month + "." + year;
    }
    
}

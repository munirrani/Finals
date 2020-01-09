package com.company;

public class DayOfTheWeek {

    String dayOf[] = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

    DayOfTheWeek(int day, int month, int year) {
        int h, q, m, y, J, K;
        q = day;
        m = month;
        y = year;
        if (month == 1 || month == 2) {
            m += 12;
            y--;
        }

        J = y / 100;
        K = y % 100;
        h = (q + (int)Math.floor(13*(m+1)/5.) + K + (int)Math.floor(K/4) + (int)Math.floor(J/4) + 5*J) % 7;

        displayDayOfTheWeek(day,month,year,h);
    }

    private boolean isDateValid(int day, int month, int year) {
        if (day > 31) return false; // bruh
        if (month > 12) return false; // bruhh
        if (month == 2 && !isLeapYear(year) && day > 28) return false;
        if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) return false; //April, June, September and November

        return true;
    }

    private boolean isLeapYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            return true;
        }
        return false;
    }

    private void displayDayOfTheWeek(int day, int month, int year, int h) {
        System.out.print(day + "/" + month + "/" + year + " is ");
        if (isDateValid(day,month,year)) {
            System.out.print("on " + dayOf[h]);
        } else {
            System.out.print("invalid Input");
        }
        System.out.println();
    }
}

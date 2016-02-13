package com.levelup;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Denis
 * Date: 7/6/13
 * Time: 11:12 AM
 * To change this template use File | Settings | File Templates.
 */
public class DateTest {

    public static void main(String[] args){
//        Date currentDate = new Date();
//        System.out.println("System UTC = " + System.currentTimeMillis());
//
//
//        Calendar calendar = GregorianCalendar.getInstance(TimeZone.getTimeZone("GMT+3"));
//        calendar.setTimeInMillis(System.currentTimeMillis());
//        System.out.println("System UTC = " + System.currentTimeMillis());
//        currentDate = calendar.getTime();
//        System.out.println("System UTC = " + System.currentTimeMillis());
//        System.out.println("Date=" + currentDate.toString());
//        System.out.println("UTC = " +calendar.getTimeInMillis());
//
//        System.out.println("DATE = " + calendar.get(Calendar.DATE));
//        System.out.println("SEC = " + calendar.get(Calendar.SECOND));
//        System.out.println("MONTH = " + calendar.get(Calendar.MONTH));
//        System.out.println("YEAR = " + calendar.get(Calendar.YEAR));
//        System.out.println("DAY = " + calendar.get(Calendar.DAY_OF_WEEK));
//
//        System.out.println("ERA = " + calendar.get(Calendar.ERA));
//        System.out.println("AM_PM = " + calendar.get(Calendar.AM_PM));
//        System.out.println("WEEK_OF_YEAR = " + calendar.get(Calendar.WEEK_OF_YEAR));
//        System.out.println("HOUR = " + calendar.get(Calendar.HOUR));
//        System.out.println("HOUR_OF_DAY = " + calendar.get(Calendar.HOUR_OF_DAY));
//
//        System.out.println("DYSP NAME = " + calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.getDefault()));


        String a = "Test";
        System.out.println(a + " ,hashCode = " + a.hashCode());
        String b =  "Test";
        System.out.println(b + " ,hashCode = " + b.hashCode());
        if (a.equals(b)){
            System.out.println("a equals b");
        } else {
            System.out.println("a not equals b");
        }
        if (a == b){
            System.out.println("a == b");
        } else {
            System.out.println("a != b");
        }
    }
}

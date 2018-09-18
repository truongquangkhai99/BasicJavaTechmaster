package com.JavaTechmaster.app;

import org.joda.time.DateTime;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        DateTime dt = new DateTime();
        int month = dt.getMonthOfYear();
    }
}

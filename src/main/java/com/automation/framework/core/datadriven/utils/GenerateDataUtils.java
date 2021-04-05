package com.automation.framework.core.datadriven.utils;

import java.util.Date;

public class GenerateDataUtils {
    public static String getTimeStamp(){
        Date date= new Date();
        String time = String.valueOf(date.getTime());
        return time;
    }
    public static String getTimeStampWithTenDigits(){
        long timeStampSec = System.currentTimeMillis()/1000;
        return  Long.toString(timeStampSec);
    }
}


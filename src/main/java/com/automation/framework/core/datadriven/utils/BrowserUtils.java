package com.automation.framework.core.datadriven.utils;

public class BrowserUtils {
    //wait
    public void sleep(int timeToWait){
        try {
            Thread.sleep(timeToWait);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

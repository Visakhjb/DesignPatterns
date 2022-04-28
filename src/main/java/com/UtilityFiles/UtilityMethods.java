package com.UtilityFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UtilityMethods {
    WebDriver driver;

    public UtilityMethods(WebDriver driver)
    {
        this.driver = driver;
    }
    public void enterText(By element)
    {
        try
        {
            WebElement l = driver.findElement(element);
            l.getText();
        }
        catch (Exception e)
        {
            System.out.println("Exception during getText");
        }
    }
}

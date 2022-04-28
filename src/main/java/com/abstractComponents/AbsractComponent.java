package com.abstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class AbsractComponent
{

    WebElement sectionElement;
    WebDriver driver;
    public AbsractComponent(WebDriver driver, By sectionElement) {
        this.driver = driver;
        this.sectionElement = driver.findElement(sectionElement);
    }

    //creating a customized findElement which can be used by the individual Pages and this will limited to the scope of the class
    public WebElement customFindElement(By element)
    {
        WebElement e= sectionElement.findElement(element);
        return e;
    }

    public List<WebElement> customFindElements(By element)
    {
        List<WebElement> e = sectionElement.findElements(element);
        return  e;
    }

    public void clickElement(By element)
    {
        try
        {
            sectionElement.findElement(element).click();
        } catch (Exception e) {
            System.out.println("Could not find element");
            throw new RuntimeException(e);
        }
    }
}


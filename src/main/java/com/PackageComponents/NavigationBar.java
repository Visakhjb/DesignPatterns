package com.PackageComponents;

import com.abstractComponents.AbsractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar extends AbsractComponent {

    WebDriver driver;
    By flights = By.cssSelector("[title='Flights']");
    By headerLinks = By.cssSelector("a");

    public NavigationBar(WebDriver driver, By sectionElement) {
        super(driver,sectionElement);
    }

    public String selectFlight()
    {

       return customFindElement(flights).getAttribute("class");
    }

    public int numberOfLinks()
    {
        return customFindElements(headerLinks).size();
    }

}

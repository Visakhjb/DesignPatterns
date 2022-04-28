package com.abstractComponents;

import com.PackageComponents.Multitrip;
import com.PackageComponents.RoundTrip;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StrategyFactory {

    WebDriver driver;
    By sectionElement = By.id("flightSearchContainer");
    ISearchFlightAvail isearchflightavail;

    public StrategyFactory(WebDriver driver) {
        this.driver = driver;
    }

    public ISearchFlightAvail createStrategy(String strategytype)
    {
        if (strategytype.equalsIgnoreCase("multitrip"))
        {
            isearchflightavail = new Multitrip(driver,sectionElement);
        }
        if(strategytype.equalsIgnoreCase("roundtrip"))
        {
            isearchflightavail = new RoundTrip(driver,sectionElement);
        }

        return isearchflightavail;
    }
}

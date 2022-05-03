package com.PageObjects;

import com.PackageComponents.FooterNavigation;
import com.PackageComponents.NavigationBar;
import com.abstractComponents.ISearchFlightAvail;
import com.abstractComponents.StrategyFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class TravelHomePage {

    /* This class will contain only the references of all the other pages */

    By sectionElement = By.id("traveller-home");
    By  footerNavSection = By.id("buttons");
    WebDriver driver;
    ISearchFlightAvail searchavail;  //this can be used a reference for all the classes which implement this

    public TravelHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void goTo() {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public NavigationBar getNavigationBar() {
        return new NavigationBar(driver,sectionElement);
    }

    public FooterNavigation getFooterNavigation() {
        return new FooterNavigation(driver, footerNavSection);
    }

    public void setTravelType(ISearchFlightAvail searchavail)
    {
        this.searchavail = searchavail;
    }

    //factory design pattern
    public void setTravelType(String Strategytype)
    {
        this.searchavail = new StrategyFactory(driver).createStrategy(Strategytype);
    }

    public void checkAvailability(HashMap<String, String> reservationDetails)
    {
        searchavail.checkAvail(reservationDetails);
    }

}

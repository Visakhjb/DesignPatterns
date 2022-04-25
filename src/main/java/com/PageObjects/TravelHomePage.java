package com.PageObjects;

import com.PackageComponents.FooterNavigation;
import com.PackageComponents.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TravelHomePage {

    /* This class will contain only the references of all the other pages */

    By sectionElement = By.id("traveller-home");
    By  footerNavSection = By.id("buttons");
    WebDriver driver;

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

}

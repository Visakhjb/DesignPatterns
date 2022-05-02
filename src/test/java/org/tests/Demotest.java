package org.tests;

import com.PackageComponents.Multitrip;
import com.PackageComponents.OnewayTrip;
import com.PackageComponents.RoundTrip;
import com.PageObjects.TravelHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Demotest {
    WebDriver driver;

    By sectionElement = By.id("flightSearchContainer");
    @Test
    public void testFlightbooking()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        TravelHomePage homePage = new TravelHomePage(driver);
        homePage.goTo();


        //SRP Design Pattern
//        System.out.println(homePage.getNavigationBar().selectFlight());
//        System.out.println(homePage.getFooterNavigation().selectFlight());
//
//        System.out.println(homePage.getFooterNavigation().numberOfLinks()); //number of footer links
//        System.out.println(homePage.getNavigationBar().numberOfLinks()); //number of header links

        //Strategy design pattern
        homePage.setTravelType(new Multitrip(driver,sectionElement));
        homePage.checkAvailability("Chennai (MAA)","Goa (GOI)");
        homePage.setTravelType(new OnewayTrip());
        homePage.checkAvailability("Chennai (MAA)","Goa (GOI)");
        homePage.setTravelType(new RoundTrip(driver,sectionElement));
        homePage.checkAvailability("Chennai (MAA)","Goa (GOI)");

        //Factory Design Pattern
        homePage.setTravelType("roundtrip");
        homePage.checkAvailability("Chennai (MAA)","Goa (GOI)");





    }
    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }
}

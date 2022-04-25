package org.tests;

import com.PageObjects.TravelHomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Demotest {
    WebDriver driver;


    @Test
    public void testFlightbooking()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        TravelHomePage homePage = new TravelHomePage(driver);

        homePage.goTo();
        System.out.println(homePage.getNavigationBar().selectFlight());
        System.out.println(homePage.getFooterNavigation().selectFlight());

        System.out.println(homePage.getFooterNavigation().numberOfLinks()); //number of footer links
        System.out.println(homePage.getNavigationBar().numberOfLinks()); //number of header links

        driver.quit();


    }
}

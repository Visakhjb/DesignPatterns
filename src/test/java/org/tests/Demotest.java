package org.tests;

import com.PageObjects.TravelHomePage;
import com.UtilityFiles.BaseTest;
import com.sun.xml.internal.messaging.saaj.packaging.mime.util.LineInputStream;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Demotest extends BaseTest {
    WebDriver driver;
    TravelHomePage homePage;
    By sectionElement = By.id("flightSearchContainer");


    @BeforeTest
    public void Setup()
    {
        driver = initializeDriver();
        homePage = new TravelHomePage(driver);
        homePage.goTo();
        System.out.println("SETUP DONE");
    }

    @Test(dataProvider = "ReservationTestData")
    public void testFlightbooking(HashMap<String, String> reservationDetails) {



        //SRP Design Pattern
//        System.out.println(homePage.getNavigationBar().selectFlight());
//        System.out.println(homePage.getFooterNavigation().selectFlight());
//
//        System.out.println(homePage.getFooterNavigation().numberOfLinks()); //number of footer links
//        System.out.println(homePage.getNavigationBar().numberOfLinks()); //number of header links

//        //Strategy design pattern
//        homePage.setTravelType(new Multitrip(driver,sectionElement));
//        homePage.checkAvailability("Chennai (MAA)","Goa (GOI)");
//        homePage.setTravelType(new OnewayTrip());
//        homePage.checkAvailability("Chennai (MAA)","Goa (GOI)");
//        homePage.setTravelType(new RoundTrip(driver,sectionElement));
//        homePage.checkAvailability("Chennai (MAA)","Goa (GOI)");

        //Factory Design Pattern
        homePage.setTravelType("roundtrip");
        homePage.checkAvailability(reservationDetails);


    }

    @DataProvider(name = "ReservationTestData")
    public Object[][] testData_Booking() {
        //Hashmap for sending the data
        HashMap<String, String> reservationDetails = new HashMap<>();
        reservationDetails.put("Source", "Chennai (MAA)");
        HashMap<String, String> reservationDetails2 = new HashMap<>();
        reservationDetails2.put("Destination", "Goa (GOI)");

        List<HashMap<String,String>> l = new ArrayList();
        l.add(reservationDetails);
        l.add(reservationDetails2);

        return new Object[][]{
                {l.get(0)}, {l.get(1)}
        };

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        System.out.println("TEST COMPLETED");
    }
}

package com.PackageComponents;


//contains all the elements of footer section
//When selenium executes any method in this class scope of selenium should be in this footer only

import com.abstractComponents.AbsractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterNavigation extends AbsractComponent {

    WebDriver driver;

    By flights = By.cssSelector("[title='Flights']");
    By footerlinks = By.cssSelector("a");

    public FooterNavigation(WebDriver driver, By sectionElement) {
        super(driver,sectionElement); //When you inherit parent class you should invoke parent class constructor in your own child construcotr
    }

    public String selectFlight()
    {
        return customFindElement(flights).getAttribute("class");
    }

    public int numberOfLinks()
    {
        return customFindElements(footerlinks).size();
    }


}

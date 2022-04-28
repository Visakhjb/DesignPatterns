package com.PackageComponents;

import com.abstractComponents.AbsractComponent;
import com.abstractComponents.ISearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RoundTrip extends AbsractComponent implements ISearchFlightAvail {

    private By from_location = By.id("ctl00_mainContent_ddl_originStation1_CTXT");
    private By to_location = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By roundtrip_radiobutton = By.id("ctl00_mainContent_rbtnl_Trip_1");
    private By searchFlights = By.id("ctl00_mainContent_btn_FindFlights");
    private By armedForcescheckbox=By.id("ctl00_mainContent_chk_IndArm");


    public RoundTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void checkAvail(String origin, String destination) {
        customFindElement(roundtrip_radiobutton).click();
        customFindElement(from_location).click();
        selectOriginCity(origin);
        selectDestinationCity(destination);
        customFindElement(armedForcescheckbox).click();
        customFindElement(searchFlights).click();
    }

    public void selectOriginCity(String Origin)
    {
        By origincity = By.xpath("//a[text()=' "+Origin+"']");
        customFindElement(origincity).click();
    }

    public void selectDestinationCity(String destination)
    {
        By origincity = By.xpath("(//a[text()=' "+destination+"'])[2]");
        customFindElement(origincity).click();
    }
}

package com.PackageComponents;

import com.abstractComponents.AbsractComponent;
import com.abstractComponents.ISearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.function.Consumer;

public class Multitrip extends AbsractComponent implements ISearchFlightAvail {
    private By from_location = By.id("ctl00_mainContent_ddl_originStation1_CTXT");;
    private By to_location = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private By submit = By.id("ctl00_mainContent_btn_FindFlights");
    private By multitrip_radiobutton = By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By multicity_informationpopup=By.id("MultiCityModelAlert");
    private By searchFlights = By.id("ctl00_mainContent_btn_FindFlights");
    private By armedForcescheckbox=By.id("ctl00_mainContent_chk_IndArm");
    private By multitripcheckbox  =By.id("MultiCityModelAlert");
    private By destination_2= By.id("ctl00_mainContent_ddl_originStation2_CTXT");

    public Multitrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }


    @Override
    public void checkAvail(String origin, String destination) {
        executeBeforeCode(s->selectOriginCity(origin));
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

    public void executeBeforeCode(Consumer<Multitrip> consumer)
    {
        customFindElement(multitrip_radiobutton).click();
        customFindElement(multicity_informationpopup).click();
        customFindElement(from_location).click();
        System.out.println("Before Code");
        consumer.accept(this);

    }
}

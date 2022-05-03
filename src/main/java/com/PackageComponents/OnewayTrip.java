package com.PackageComponents;

import com.abstractComponents.ISearchFlightAvail;

import java.util.HashMap;

public class OnewayTrip implements ISearchFlightAvail {

    @Override
    public void checkAvail(HashMap<String, String> reservationDetails) {
        System.out.println("I am inside Oneway trip "+reservationDetails.get("Source")+" "+reservationDetails.get("Destination"));
    }
}

package com.PackageComponents;

import com.abstractComponents.ISearchFlightAvail;

public class OnewayTrip implements ISearchFlightAvail {

    @Override
    public void checkAvail(String origin, String destination) {
        System.out.println("I am inside Oneway trip");
    }
}

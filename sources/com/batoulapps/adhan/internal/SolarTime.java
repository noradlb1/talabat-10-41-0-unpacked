package com.batoulapps.adhan.internal;

import com.batoulapps.adhan.Coordinates;
import com.batoulapps.adhan.data.DateComponents;

public class SolarTime {
    private double approximateTransit;
    private final SolarCoordinates nextSolar;
    private final Coordinates observer;
    private final SolarCoordinates prevSolar;
    private final SolarCoordinates solar;
    public final double sunrise;
    public final double sunset;
    public final double transit;

    public SolarTime(DateComponents dateComponents, Coordinates coordinates) {
        DateComponents dateComponents2 = dateComponents;
        Coordinates coordinates2 = coordinates;
        double b11 = CalendricalHelper.b(dateComponents2.year, dateComponents2.month, dateComponents2.day);
        SolarCoordinates solarCoordinates = new SolarCoordinates(b11 - 1.0d);
        this.prevSolar = solarCoordinates;
        SolarCoordinates solarCoordinates2 = new SolarCoordinates(b11);
        this.solar = solarCoordinates2;
        SolarCoordinates solarCoordinates3 = new SolarCoordinates(b11 + 1.0d);
        this.nextSolar = solarCoordinates3;
        double d11 = Astronomical.d(coordinates2.longitude, solarCoordinates2.f43259c, solarCoordinates2.f43258b);
        this.approximateTransit = d11;
        this.observer = coordinates2;
        this.transit = Astronomical.g(d11, coordinates2.longitude, solarCoordinates2.f43259c, solarCoordinates2.f43258b, solarCoordinates.f43258b, solarCoordinates3.f43258b);
        SolarCoordinates solarCoordinates4 = solarCoordinates;
        SolarCoordinates solarCoordinates5 = solarCoordinates2;
        SolarCoordinates solarCoordinates6 = solarCoordinates3;
        SolarCoordinates solarCoordinates7 = solarCoordinates4;
        SolarCoordinates solarCoordinates8 = solarCoordinates5;
        this.sunrise = Astronomical.f(this.approximateTransit, -0.8333333333333334d, coordinates, false, solarCoordinates2.f43259c, solarCoordinates2.f43258b, solarCoordinates4.f43258b, solarCoordinates3.f43258b, solarCoordinates5.f43257a, solarCoordinates4.f43257a, solarCoordinates6.f43257a);
        SolarCoordinates solarCoordinates9 = solarCoordinates7;
        SolarCoordinates solarCoordinates10 = solarCoordinates6;
        this.sunset = Astronomical.f(this.approximateTransit, -0.8333333333333334d, coordinates, true, solarCoordinates8.f43259c, solarCoordinates8.f43258b, solarCoordinates9.f43258b, solarCoordinates10.f43258b, solarCoordinates8.f43257a, solarCoordinates9.f43257a, solarCoordinates10.f43257a);
    }

    public double afternoon(ShadowLength shadowLength) {
        return hourAngle(Math.toDegrees(Math.atan(1.0d / (shadowLength.getShadowLength() + Math.tan(Math.toRadians(Math.abs(this.observer.latitude - this.solar.f43257a)))))), true);
    }

    public double hourAngle(double d11, boolean z11) {
        double d12 = this.approximateTransit;
        Coordinates coordinates = this.observer;
        SolarCoordinates solarCoordinates = this.solar;
        double d13 = solarCoordinates.f43259c;
        double d14 = solarCoordinates.f43258b;
        SolarCoordinates solarCoordinates2 = this.prevSolar;
        double d15 = solarCoordinates2.f43258b;
        SolarCoordinates solarCoordinates3 = this.nextSolar;
        return Astronomical.f(d12, d11, coordinates, z11, d13, d14, d15, solarCoordinates3.f43258b, solarCoordinates.f43257a, solarCoordinates2.f43257a, solarCoordinates3.f43257a);
    }
}

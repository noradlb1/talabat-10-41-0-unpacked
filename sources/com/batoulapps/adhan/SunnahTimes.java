package com.batoulapps.adhan;

import com.batoulapps.adhan.data.CalendarUtil;
import com.batoulapps.adhan.data.DateComponents;
import java.util.Date;

public class SunnahTimes {
    public final Date lastThirdOfTheNight;
    public final Date middleOfTheNight;

    public SunnahTimes(PrayerTimes prayerTimes) {
        double time = (double) ((int) ((new PrayerTimes(prayerTimes.f43253a, DateComponents.fromUTC(CalendarUtil.add(CalendarUtil.resolveTime(prayerTimes.f43254b), 1, 5)), prayerTimes.f43255c).fajr.getTime() - prayerTimes.maghrib.getTime()) / 1000));
        this.middleOfTheNight = CalendarUtil.roundedMinute(CalendarUtil.add(prayerTimes.maghrib, (int) (time / 2.0d), 13));
        this.lastThirdOfTheNight = CalendarUtil.roundedMinute(CalendarUtil.add(prayerTimes.maghrib, (int) (time * 0.6666666666666666d), 13));
    }
}

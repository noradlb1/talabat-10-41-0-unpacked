package com.batoulapps.adhan;

public class PrayerAdjustments {
    public int asr;
    public int dhuhr;
    public int fajr;
    public int isha;
    public int maghrib;
    public int sunrise;

    public PrayerAdjustments() {
        this(0, 0, 0, 0, 0, 0);
    }

    public PrayerAdjustments(int i11, int i12, int i13, int i14, int i15, int i16) {
        this.fajr = i11;
        this.sunrise = i12;
        this.dhuhr = i13;
        this.asr = i14;
        this.maghrib = i15;
        this.isha = i16;
    }
}

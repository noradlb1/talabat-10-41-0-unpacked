package androidx.appcompat.app;

class TwilightCalculator {
    private static final float ALTIDUTE_CORRECTION_CIVIL_TWILIGHT = -0.10471976f;
    private static final float C1 = 0.0334196f;
    private static final float C2 = 3.49066E-4f;
    private static final float C3 = 5.236E-6f;
    public static final int DAY = 0;
    private static final float DEGREES_TO_RADIANS = 0.017453292f;
    private static final float J0 = 9.0E-4f;
    public static final int NIGHT = 1;
    private static final float OBLIQUITY = 0.4092797f;
    private static final long UTC_2000 = 946728000000L;
    private static TwilightCalculator sInstance;
    public int state;
    public long sunrise;
    public long sunset;

    public static TwilightCalculator a() {
        if (sInstance == null) {
            sInstance = new TwilightCalculator();
        }
        return sInstance;
    }

    public void calculateTwilight(long j11, double d11, double d12) {
        float f11 = ((float) (j11 - UTC_2000)) / 8.64E7f;
        float f12 = (0.01720197f * f11) + 6.24006f;
        double d13 = (double) f12;
        double sin = (Math.sin(d13) * 0.03341960161924362d) + d13 + (Math.sin((double) (2.0f * f12)) * 3.4906598739326E-4d) + (Math.sin((double) (f12 * 3.0f)) * 5.236000106378924E-6d) + 1.796593063d + 3.141592653589793d;
        double d14 = (-d12) / 360.0d;
        double round = ((double) (((float) Math.round(((double) (f11 - J0)) - d14)) + J0)) + d14 + (Math.sin(d13) * 0.0053d) + (Math.sin(2.0d * sin) * -0.0069d);
        double asin = Math.asin(Math.sin(sin) * Math.sin(0.4092797040939331d));
        double d15 = 0.01745329238474369d * d11;
        double sin2 = (Math.sin(-0.10471975803375244d) - (Math.sin(d15) * Math.sin(asin))) / (Math.cos(d15) * Math.cos(asin));
        if (sin2 >= 1.0d) {
            this.state = 1;
            this.sunset = -1;
            this.sunrise = -1;
        } else if (sin2 <= -1.0d) {
            this.state = 0;
            this.sunset = -1;
            this.sunrise = -1;
        } else {
            double acos = (double) ((float) (Math.acos(sin2) / 6.283185307179586d));
            this.sunset = Math.round((round + acos) * 8.64E7d) + UTC_2000;
            long round2 = Math.round((round - acos) * 8.64E7d) + UTC_2000;
            this.sunrise = round2;
            if (round2 >= j11 || this.sunset <= j11) {
                this.state = 1;
            } else {
                this.state = 0;
            }
        }
    }
}

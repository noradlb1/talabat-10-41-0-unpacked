package com.batoulapps.adhan;

public class CalculationParameters {
    public PrayerAdjustments adjustments;
    public double fajrAngle;
    public HighLatitudeRule highLatitudeRule;
    public double ishaAngle;
    public int ishaInterval;
    public Madhab madhab;
    public CalculationMethod method;
    public PrayerAdjustments methodAdjustments;

    /* renamed from: com.batoulapps.adhan.CalculationParameters$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f43249a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.batoulapps.adhan.HighLatitudeRule[] r0 = com.batoulapps.adhan.HighLatitudeRule.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f43249a = r0
                com.batoulapps.adhan.HighLatitudeRule r1 = com.batoulapps.adhan.HighLatitudeRule.MIDDLE_OF_THE_NIGHT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f43249a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.batoulapps.adhan.HighLatitudeRule r1 = com.batoulapps.adhan.HighLatitudeRule.SEVENTH_OF_THE_NIGHT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f43249a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.batoulapps.adhan.HighLatitudeRule r1 = com.batoulapps.adhan.HighLatitudeRule.TWILIGHT_ANGLE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.batoulapps.adhan.CalculationParameters.AnonymousClass1.<clinit>():void");
        }
    }

    public static class NightPortions {

        /* renamed from: a  reason: collision with root package name */
        public final double f43250a;

        /* renamed from: b  reason: collision with root package name */
        public final double f43251b;

        public /* synthetic */ NightPortions(double d11, double d12, AnonymousClass1 r52) {
            this(d11, d12);
        }

        private NightPortions(double d11, double d12) {
            this.f43250a = d11;
            this.f43251b = d12;
        }
    }

    public CalculationParameters(double d11, double d12) {
        this.method = CalculationMethod.OTHER;
        this.madhab = Madhab.SHAFI;
        this.highLatitudeRule = HighLatitudeRule.MIDDLE_OF_THE_NIGHT;
        this.adjustments = new PrayerAdjustments();
        this.methodAdjustments = new PrayerAdjustments();
        this.fajrAngle = d11;
        this.ishaAngle = d12;
    }

    public NightPortions a() {
        int i11 = AnonymousClass1.f43249a[this.highLatitudeRule.ordinal()];
        if (i11 == 1) {
            return new NightPortions(0.5d, 0.5d, (AnonymousClass1) null);
        }
        if (i11 == 2) {
            return new NightPortions(0.14285714285714285d, 0.14285714285714285d, (AnonymousClass1) null);
        }
        if (i11 == 3) {
            return new NightPortions(this.fajrAngle / 60.0d, this.ishaAngle / 60.0d, (AnonymousClass1) null);
        }
        throw new IllegalArgumentException("Invalid high latitude rule");
    }

    public CalculationParameters withMethodAdjustments(PrayerAdjustments prayerAdjustments) {
        this.methodAdjustments = prayerAdjustments;
        return this;
    }

    public CalculationParameters(double d11, int i11) {
        this(d11, 0.0d);
        this.ishaInterval = i11;
    }

    public CalculationParameters(double d11, double d12, CalculationMethod calculationMethod) {
        this(d11, d12);
        this.method = calculationMethod;
    }

    public CalculationParameters(double d11, int i11, CalculationMethod calculationMethod) {
        this(d11, i11);
        this.method = calculationMethod;
    }
}

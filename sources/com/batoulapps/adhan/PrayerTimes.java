package com.batoulapps.adhan;

import com.batoulapps.adhan.CalculationParameters;
import com.batoulapps.adhan.data.CalendarUtil;
import com.batoulapps.adhan.data.DateComponents;
import com.batoulapps.adhan.data.TimeComponents;
import com.batoulapps.adhan.internal.SolarTime;
import com.talabat.talabatcommon.views.wallet.subscription.model.WalletSubscriptionMapperKt;
import j$.util.DesugarTimeZone;
import java.util.Calendar;
import java.util.Date;
import net.bytebuddy.jar.asm.Opcodes;

public class PrayerTimes {

    /* renamed from: a  reason: collision with root package name */
    public final Coordinates f43253a;
    public final Date asr;

    /* renamed from: b  reason: collision with root package name */
    public final DateComponents f43254b;

    /* renamed from: c  reason: collision with root package name */
    public final CalculationParameters f43255c;
    public final Date dhuhr;
    public final Date fajr;
    public final Date isha;
    public final Date maghrib;
    public final Date sunrise;

    /* renamed from: com.batoulapps.adhan.PrayerTimes$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f43256a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.batoulapps.adhan.Prayer[] r0 = com.batoulapps.adhan.Prayer.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f43256a = r0
                com.batoulapps.adhan.Prayer r1 = com.batoulapps.adhan.Prayer.FAJR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f43256a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.batoulapps.adhan.Prayer r1 = com.batoulapps.adhan.Prayer.SUNRISE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f43256a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.batoulapps.adhan.Prayer r1 = com.batoulapps.adhan.Prayer.DHUHR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f43256a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.batoulapps.adhan.Prayer r1 = com.batoulapps.adhan.Prayer.ASR     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f43256a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.batoulapps.adhan.Prayer r1 = com.batoulapps.adhan.Prayer.MAGHRIB     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f43256a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.batoulapps.adhan.Prayer r1 = com.batoulapps.adhan.Prayer.ISHA     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f43256a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.batoulapps.adhan.Prayer r1 = com.batoulapps.adhan.Prayer.NONE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.batoulapps.adhan.PrayerTimes.AnonymousClass1.<clinit>():void");
        }
    }

    public PrayerTimes(Coordinates coordinates, DateComponents dateComponents, CalculationParameters calculationParameters) {
        Date date;
        Date date2;
        Date date3;
        boolean z11;
        boolean z12;
        Date date4;
        Date date5;
        Date date6;
        Date date7;
        Date date8;
        PrayerTimes prayerTimes;
        Date date9;
        Date date10;
        Date date11;
        Date date12;
        Date date13;
        CalculationParameters.NightPortions nightPortions;
        Date date14;
        int i11;
        Date date15;
        Coordinates coordinates2 = coordinates;
        DateComponents dateComponents2 = dateComponents;
        CalculationParameters calculationParameters2 = calculationParameters;
        this.f43253a = coordinates2;
        this.f43254b = dateComponents2;
        this.f43255c = calculationParameters2;
        Date resolveTime = CalendarUtil.resolveTime(dateComponents);
        Calendar instance = Calendar.getInstance(DesugarTimeZone.getTimeZone("UTC"));
        instance.setTime(resolveTime);
        int i12 = instance.get(6);
        DateComponents fromUTC = DateComponents.fromUTC(CalendarUtil.add(resolveTime, 1, 5));
        SolarTime solarTime = new SolarTime(dateComponents2, coordinates2);
        TimeComponents fromDouble = TimeComponents.fromDouble(solarTime.transit);
        if (fromDouble == null) {
            date = null;
        } else {
            date = fromDouble.dateComponents(dateComponents2);
        }
        TimeComponents fromDouble2 = TimeComponents.fromDouble(solarTime.sunrise);
        if (fromDouble2 == null) {
            date2 = null;
        } else {
            date2 = fromDouble2.dateComponents(dateComponents2);
        }
        TimeComponents fromDouble3 = TimeComponents.fromDouble(solarTime.sunset);
        if (fromDouble3 == null) {
            date3 = null;
        } else {
            date3 = fromDouble3.dateComponents(dateComponents2);
        }
        TimeComponents fromDouble4 = TimeComponents.fromDouble(new SolarTime(fromUTC, coordinates2).sunrise);
        if (date == null || date2 == null || date3 == null || fromDouble4 == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            TimeComponents fromDouble5 = TimeComponents.fromDouble(solarTime.afternoon(calculationParameters2.madhab.a()));
            if (fromDouble5 != null) {
                date10 = fromDouble5.dateComponents(dateComponents2);
            } else {
                date10 = null;
            }
            Date date16 = date;
            long time = fromDouble4.dateComponents(fromUTC).getTime() - date3.getTime();
            int i13 = i12;
            TimeComponents fromDouble6 = TimeComponents.fromDouble(solarTime.hourAngle(-calculationParameters2.fajrAngle, false));
            if (fromDouble6 != null) {
                date7 = fromDouble6.dateComponents(dateComponents2);
            } else {
                date7 = null;
            }
            CalculationMethod calculationMethod = calculationParameters2.method;
            CalculationMethod calculationMethod2 = CalculationMethod.MOON_SIGHTING_COMMITTEE;
            if (calculationMethod == calculationMethod2) {
                date11 = date2;
                if (coordinates2.latitude >= 55.0d) {
                    date7 = CalendarUtil.add(date11, ((int) (time / 7000)) * -1, 13);
                }
            } else {
                date11 = date2;
            }
            CalculationParameters.NightPortions a11 = calculationParameters.a();
            if (calculationParameters2.method == calculationMethod2) {
                date13 = date10;
                date12 = date16;
                i11 = i13;
                z12 = z11;
                nightPortions = a11;
                date14 = seasonAdjustedMorningTwilight(coordinates2.latitude, i11, dateComponents2.year, date11);
            } else {
                date12 = date16;
                date13 = date10;
                i11 = i13;
                nightPortions = a11;
                z12 = z11;
                date14 = CalendarUtil.add(date11, ((int) ((long) ((a11.f43250a * ((double) time)) / 1000.0d))) * -1, 13);
            }
            date7 = (date7 == null || date7.before(date14)) ? date14 : date7;
            int i14 = calculationParameters2.ishaInterval;
            if (i14 > 0) {
                date8 = CalendarUtil.add(date3, i14 * 60, 13);
            } else {
                TimeComponents fromDouble7 = TimeComponents.fromDouble(solarTime.hourAngle(-calculationParameters2.ishaAngle, true));
                if (fromDouble7 != null) {
                    date15 = fromDouble7.dateComponents(dateComponents2);
                } else {
                    date15 = null;
                }
                if (calculationParameters2.method == calculationMethod2 && coordinates2.latitude >= 55.0d) {
                    date15 = CalendarUtil.add(date3, (int) (time / 7000), 13);
                }
                if (calculationParameters2.method == calculationMethod2) {
                    date8 = seasonAdjustedEveningTwilight(coordinates2.latitude, i11, dateComponents2.year, date3);
                } else {
                    date8 = CalendarUtil.add(date3, (int) ((long) ((nightPortions.f43251b * ((double) time)) / 1000.0d)), 13);
                }
                if (date15 != null && !date15.after(date8)) {
                    date5 = date11;
                    date8 = date15;
                    date4 = date13;
                    date6 = date12;
                }
            }
            date5 = date11;
            date4 = date13;
            date6 = date12;
        } else {
            z12 = z11;
            date8 = null;
            date7 = null;
            date6 = null;
            date5 = null;
            date3 = null;
            date4 = null;
        }
        if (z12) {
            prayerTimes = this;
            date9 = null;
        } else if (date4 == null) {
            date9 = null;
            prayerTimes = this;
        } else {
            this.fajr = CalendarUtil.roundedMinute(CalendarUtil.add(CalendarUtil.add(date7, calculationParameters2.adjustments.fajr, 12), calculationParameters2.methodAdjustments.fajr, 12));
            this.sunrise = CalendarUtil.roundedMinute(CalendarUtil.add(CalendarUtil.add(date5, calculationParameters2.adjustments.sunrise, 12), calculationParameters2.methodAdjustments.sunrise, 12));
            this.dhuhr = CalendarUtil.roundedMinute(CalendarUtil.add(CalendarUtil.add(date6, calculationParameters2.adjustments.dhuhr, 12), calculationParameters2.methodAdjustments.dhuhr, 12));
            this.asr = CalendarUtil.roundedMinute(CalendarUtil.add(CalendarUtil.add(date4, calculationParameters2.adjustments.asr, 12), calculationParameters2.methodAdjustments.asr, 12));
            this.maghrib = CalendarUtil.roundedMinute(CalendarUtil.add(CalendarUtil.add(date3, calculationParameters2.adjustments.maghrib, 12), calculationParameters2.methodAdjustments.maghrib, 12));
            this.isha = CalendarUtil.roundedMinute(CalendarUtil.add(CalendarUtil.add(date8, calculationParameters2.adjustments.isha, 12), calculationParameters2.methodAdjustments.isha, 12));
            return;
        }
        prayerTimes.fajr = date9;
        prayerTimes.sunrise = date9;
        prayerTimes.dhuhr = date9;
        prayerTimes.asr = date9;
        prayerTimes.maghrib = date9;
        prayerTimes.isha = date9;
    }

    public static int a(int i11, int i12, double d11) {
        boolean isLeapYear = CalendarUtil.isLeapYear(i12);
        int i13 = isLeapYear ? Opcodes.LRETURN : 172;
        int i14 = isLeapYear ? 366 : WalletSubscriptionMapperKt.DAYS_IN_A_YEAR;
        if (d11 >= 0.0d) {
            int i15 = i11 + 10;
            return i15 >= i14 ? i15 - i14 : i15;
        }
        int i16 = i11 - i13;
        return i16 < 0 ? i16 + i14 : i16;
    }

    private static Date seasonAdjustedEveningTwilight(double d11, int i11, int i12, Date date) {
        double d12;
        double abs = (Math.abs(d11) * 0.46545454545454545d) + 75.0d;
        double abs2 = (Math.abs(d11) * 0.03727272727272727d) + 75.0d;
        double abs3 = 75.0d - (Math.abs(d11) * 0.16745454545454547d);
        double abs4 = (Math.abs(d11) * 0.11163636363636363d) + 75.0d;
        int a11 = a(i11, i12, d11);
        if (a11 < 91) {
            d12 = abs + (((abs2 - abs) / 91.0d) * ((double) a11));
        } else if (a11 < 137) {
            d12 = abs2 + (((abs3 - abs2) / 46.0d) * ((double) (a11 - 91)));
        } else if (a11 < 183) {
            d12 = abs3 + (((abs4 - abs3) / 46.0d) * ((double) (a11 - Opcodes.L2F)));
        } else if (a11 < 229) {
            d12 = abs4 + (((abs3 - abs4) / 46.0d) * ((double) (a11 - Opcodes.INVOKESPECIAL)));
        } else if (a11 < 275) {
            d12 = abs3 + (((abs2 - abs3) / 46.0d) * ((double) (a11 - 229)));
        } else {
            d12 = (((abs - abs2) / 91.0d) * ((double) (a11 - 275))) + abs2;
        }
        return CalendarUtil.add(date, (int) Math.round(d12 * 60.0d), 13);
    }

    private static Date seasonAdjustedMorningTwilight(double d11, int i11, int i12, Date date) {
        double d12;
        double abs = (Math.abs(d11) * 0.5209090909090909d) + 75.0d;
        double abs2 = (Math.abs(d11) * 0.35345454545454547d) + 75.0d;
        double abs3 = (Math.abs(d11) * 0.5952727272727273d) + 75.0d;
        double abs4 = (Math.abs(d11) * 0.8745454545454546d) + 75.0d;
        int a11 = a(i11, i12, d11);
        if (a11 < 91) {
            d12 = abs + (((abs2 - abs) / 91.0d) * ((double) a11));
        } else if (a11 < 137) {
            d12 = abs2 + (((abs3 - abs2) / 46.0d) * ((double) (a11 - 91)));
        } else if (a11 < 183) {
            d12 = abs3 + (((abs4 - abs3) / 46.0d) * ((double) (a11 - Opcodes.L2F)));
        } else if (a11 < 229) {
            d12 = abs4 + (((abs3 - abs4) / 46.0d) * ((double) (a11 - Opcodes.INVOKESPECIAL)));
        } else if (a11 < 275) {
            d12 = abs3 + (((abs2 - abs3) / 46.0d) * ((double) (a11 - 229)));
        } else {
            d12 = (((abs - abs2) / 91.0d) * ((double) (a11 - 275))) + abs2;
        }
        return CalendarUtil.add(date, -((int) Math.round(d12 * 60.0d)), 13);
    }

    public Prayer currentPrayer() {
        return currentPrayer(new Date());
    }

    public Prayer nextPrayer() {
        return nextPrayer(new Date());
    }

    public Date timeForPrayer(Prayer prayer) {
        switch (AnonymousClass1.f43256a[prayer.ordinal()]) {
            case 1:
                return this.fajr;
            case 2:
                return this.sunrise;
            case 3:
                return this.dhuhr;
            case 4:
                return this.asr;
            case 5:
                return this.maghrib;
            case 6:
                return this.isha;
            default:
                return null;
        }
    }

    public Prayer currentPrayer(Date date) {
        long time = date.getTime();
        if (this.isha.getTime() - time <= 0) {
            return Prayer.ISHA;
        }
        if (this.maghrib.getTime() - time <= 0) {
            return Prayer.MAGHRIB;
        }
        if (this.asr.getTime() - time <= 0) {
            return Prayer.ASR;
        }
        if (this.dhuhr.getTime() - time <= 0) {
            return Prayer.DHUHR;
        }
        if (this.sunrise.getTime() - time <= 0) {
            return Prayer.SUNRISE;
        }
        if (this.fajr.getTime() - time <= 0) {
            return Prayer.FAJR;
        }
        return Prayer.NONE;
    }

    public Prayer nextPrayer(Date date) {
        long time = date.getTime();
        if (this.isha.getTime() - time <= 0) {
            return Prayer.NONE;
        }
        if (this.maghrib.getTime() - time <= 0) {
            return Prayer.ISHA;
        }
        if (this.asr.getTime() - time <= 0) {
            return Prayer.MAGHRIB;
        }
        if (this.dhuhr.getTime() - time <= 0) {
            return Prayer.ASR;
        }
        if (this.sunrise.getTime() - time <= 0) {
            return Prayer.DHUHR;
        }
        if (this.fajr.getTime() - time <= 0) {
            return Prayer.SUNRISE;
        }
        return Prayer.FAJR;
    }
}

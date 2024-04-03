package j$.time.format;

import j$.time.chrono.n;
import j$.time.chrono.u;
import j$.time.temporal.a;
import j$.time.temporal.q;
import j$.util.concurrent.ConcurrentHashMap;
import java.text.DateFormatSymbols;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;

class x {

    /* renamed from: a  reason: collision with root package name */
    private static final ConcurrentHashMap f28399a = new ConcurrentHashMap(16, 0.75f, 2);
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Comparator f28400b = new c();

    /* renamed from: c  reason: collision with root package name */
    private static final x f28401c = new x();

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ int f28402d = 0;

    x() {
    }

    private static String b(String str) {
        return str.substring(0, Character.charCount(str.codePointAt(0)));
    }

    static x c() {
        return f28401c;
    }

    public String d(n nVar, q qVar, long j11, B b11, Locale locale) {
        if (nVar == u.f28321d || !(qVar instanceof a)) {
            return e(qVar, j11, b11, locale);
        }
        return null;
    }

    public String e(q qVar, long j11, B b11, Locale locale) {
        Object obj;
        q qVar2 = qVar;
        AbstractMap.SimpleImmutableEntry simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry(qVar2, locale);
        ConcurrentHashMap concurrentHashMap = f28399a;
        Object obj2 = concurrentHashMap.get(simpleImmutableEntry);
        if (obj2 == null) {
            HashMap hashMap = new HashMap();
            int i11 = 0;
            if (qVar2 == a.ERA) {
                DateFormatSymbols instance = DateFormatSymbols.getInstance(locale);
                HashMap hashMap2 = new HashMap();
                HashMap hashMap3 = new HashMap();
                String[] eras = instance.getEras();
                while (i11 < eras.length) {
                    if (!eras[i11].isEmpty()) {
                        long j12 = (long) i11;
                        hashMap2.put(Long.valueOf(j12), eras[i11]);
                        hashMap3.put(Long.valueOf(j12), b(eras[i11]));
                    }
                    i11++;
                }
                if (!hashMap2.isEmpty()) {
                    hashMap.put(B.FULL, hashMap2);
                    hashMap.put(B.SHORT, hashMap2);
                    hashMap.put(B.NARROW, hashMap3);
                }
                obj = new w(hashMap);
            } else if (qVar2 == a.MONTH_OF_YEAR) {
                DateFormatSymbols instance2 = DateFormatSymbols.getInstance(locale);
                HashMap hashMap4 = new HashMap();
                HashMap hashMap5 = new HashMap();
                String[] months = instance2.getMonths();
                for (int i12 = 0; i12 < months.length; i12++) {
                    if (!months[i12].isEmpty()) {
                        long j13 = ((long) i12) + 1;
                        hashMap4.put(Long.valueOf(j13), months[i12]);
                        hashMap5.put(Long.valueOf(j13), b(months[i12]));
                    }
                }
                if (!hashMap4.isEmpty()) {
                    hashMap.put(B.FULL, hashMap4);
                    hashMap.put(B.NARROW, hashMap5);
                }
                HashMap hashMap6 = new HashMap();
                String[] shortMonths = instance2.getShortMonths();
                while (i11 < shortMonths.length) {
                    if (!shortMonths[i11].isEmpty()) {
                        hashMap6.put(Long.valueOf(((long) i11) + 1), shortMonths[i11]);
                    }
                    i11++;
                }
                if (!hashMap6.isEmpty()) {
                    hashMap.put(B.SHORT, hashMap6);
                }
                obj = new w(hashMap);
            } else if (qVar2 == a.DAY_OF_WEEK) {
                DateFormatSymbols instance3 = DateFormatSymbols.getInstance(locale);
                HashMap hashMap7 = new HashMap();
                String[] weekdays = instance3.getWeekdays();
                hashMap7.put(1L, weekdays[2]);
                hashMap7.put(2L, weekdays[3]);
                hashMap7.put(3L, weekdays[4]);
                hashMap7.put(4L, weekdays[5]);
                hashMap7.put(5L, weekdays[6]);
                hashMap7.put(6L, weekdays[7]);
                hashMap7.put(7L, weekdays[1]);
                hashMap.put(B.FULL, hashMap7);
                HashMap hashMap8 = new HashMap();
                hashMap8.put(1L, b(weekdays[2]));
                hashMap8.put(2L, b(weekdays[3]));
                hashMap8.put(3L, b(weekdays[4]));
                hashMap8.put(4L, b(weekdays[5]));
                hashMap8.put(5L, b(weekdays[6]));
                hashMap8.put(6L, b(weekdays[7]));
                hashMap8.put(7L, b(weekdays[1]));
                hashMap.put(B.NARROW, hashMap8);
                HashMap hashMap9 = new HashMap();
                String[] shortWeekdays = instance3.getShortWeekdays();
                hashMap9.put(1L, shortWeekdays[2]);
                hashMap9.put(2L, shortWeekdays[3]);
                hashMap9.put(3L, shortWeekdays[4]);
                hashMap9.put(4L, shortWeekdays[5]);
                hashMap9.put(5L, shortWeekdays[6]);
                hashMap9.put(6L, shortWeekdays[7]);
                hashMap9.put(7L, shortWeekdays[1]);
                hashMap.put(B.SHORT, hashMap9);
                obj = new w(hashMap);
            } else if (qVar2 == a.AMPM_OF_DAY) {
                DateFormatSymbols instance4 = DateFormatSymbols.getInstance(locale);
                HashMap hashMap10 = new HashMap();
                HashMap hashMap11 = new HashMap();
                String[] amPmStrings = instance4.getAmPmStrings();
                while (i11 < amPmStrings.length) {
                    if (!amPmStrings[i11].isEmpty()) {
                        long j14 = (long) i11;
                        hashMap10.put(Long.valueOf(j14), amPmStrings[i11]);
                        hashMap11.put(Long.valueOf(j14), b(amPmStrings[i11]));
                    }
                    i11++;
                }
                if (!hashMap10.isEmpty()) {
                    hashMap.put(B.FULL, hashMap10);
                    hashMap.put(B.SHORT, hashMap10);
                    hashMap.put(B.NARROW, hashMap11);
                }
                obj = new w(hashMap);
            } else {
                obj = "";
            }
            concurrentHashMap.putIfAbsent(simpleImmutableEntry, obj);
            obj2 = concurrentHashMap.get(simpleImmutableEntry);
        }
        if (obj2 instanceof w) {
            return ((w) obj2).a(j11, b11);
        }
        return null;
    }
}

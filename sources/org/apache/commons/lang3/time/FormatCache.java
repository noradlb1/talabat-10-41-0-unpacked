package org.apache.commons.lang3.time;

import j$.util.concurrent.ConcurrentHashMap;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentMap;

abstract class FormatCache<F extends Format> {
    private static final ConcurrentMap<MultipartKey, String> cDateTimeInstanceCache = new ConcurrentHashMap(7);
    private final ConcurrentMap<MultipartKey, F> cInstanceCache = new ConcurrentHashMap(7);

    public static class MultipartKey {
        private int hashCode;
        private final Object[] keys;

        public MultipartKey(Object... objArr) {
            this.keys = objArr;
        }

        public boolean equals(Object obj) {
            return Arrays.equals(this.keys, ((MultipartKey) obj).keys);
        }

        public int hashCode() {
            if (this.hashCode == 0) {
                int i11 = 0;
                for (Object obj : this.keys) {
                    if (obj != null) {
                        i11 = (i11 * 7) + obj.hashCode();
                    }
                }
                this.hashCode = i11;
            }
            return this.hashCode;
        }
    }

    public static String d(Integer num, Integer num2, Locale locale) {
        DateFormat dateFormat;
        MultipartKey multipartKey = new MultipartKey(num, num2, locale);
        ConcurrentMap<MultipartKey, String> concurrentMap = cDateTimeInstanceCache;
        String str = concurrentMap.get(multipartKey);
        if (str != null) {
            return str;
        }
        if (num == null) {
            try {
                dateFormat = DateFormat.getTimeInstance(num2.intValue(), locale);
            } catch (ClassCastException unused) {
                throw new IllegalArgumentException("No date time pattern for locale: " + locale);
            }
        } else if (num2 == null) {
            dateFormat = DateFormat.getDateInstance(num.intValue(), locale);
        } else {
            dateFormat = DateFormat.getDateTimeInstance(num.intValue(), num2.intValue(), locale);
        }
        String pattern = ((SimpleDateFormat) dateFormat).toPattern();
        String putIfAbsent = concurrentMap.putIfAbsent(multipartKey, pattern);
        if (putIfAbsent != null) {
            return putIfAbsent;
        }
        return pattern;
    }

    private F getDateTimeInstance(Integer num, Integer num2, TimeZone timeZone, Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();
        }
        return getInstance(d(num, num2, locale), timeZone, locale);
    }

    public abstract F a(String str, TimeZone timeZone, Locale locale);

    public F b(int i11, TimeZone timeZone, Locale locale) {
        return getDateTimeInstance(Integer.valueOf(i11), (Integer) null, timeZone, locale);
    }

    public F c(int i11, int i12, TimeZone timeZone, Locale locale) {
        return getDateTimeInstance(Integer.valueOf(i11), Integer.valueOf(i12), timeZone, locale);
    }

    public F e(int i11, TimeZone timeZone, Locale locale) {
        return getDateTimeInstance((Integer) null, Integer.valueOf(i11), timeZone, locale);
    }

    public F getInstance() {
        return c(3, 3, TimeZone.getDefault(), Locale.getDefault());
    }

    public F getInstance(String str, TimeZone timeZone, Locale locale) {
        if (str != null) {
            if (timeZone == null) {
                timeZone = TimeZone.getDefault();
            }
            if (locale == null) {
                locale = Locale.getDefault();
            }
            MultipartKey multipartKey = new MultipartKey(str, timeZone, locale);
            F f11 = (Format) this.cInstanceCache.get(multipartKey);
            if (f11 != null) {
                return f11;
            }
            F a11 = a(str, timeZone, locale);
            F f12 = (Format) this.cInstanceCache.putIfAbsent(multipartKey, a11);
            return f12 != null ? f12 : a11;
        }
        throw new NullPointerException("pattern must not be null");
    }
}

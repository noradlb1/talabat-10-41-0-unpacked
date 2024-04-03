package org.threeten.bp.format;

import i.b;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import org.threeten.bp.temporal.TemporalField;

public abstract class DateTimeTextProvider {
    /* access modifiers changed from: private */
    public static final AtomicReference<DateTimeTextProvider> MUTABLE_PROVIDER = new AtomicReference<>();

    public static class ProviderSingleton {

        /* renamed from: a  reason: collision with root package name */
        public static final DateTimeTextProvider f63379a = a();

        public static DateTimeTextProvider a() {
            b.a(DateTimeTextProvider.MUTABLE_PROVIDER, (Object) null, new SimpleDateTimeTextProvider());
            return (DateTimeTextProvider) DateTimeTextProvider.MUTABLE_PROVIDER.get();
        }
    }

    public static DateTimeTextProvider b() {
        return ProviderSingleton.f63379a;
    }

    public static void setInitializer(DateTimeTextProvider dateTimeTextProvider) {
        if (!b.a(MUTABLE_PROVIDER, (Object) null, dateTimeTextProvider)) {
            throw new IllegalStateException("Provider was already set, possibly with a default during initialization");
        }
    }

    public abstract String getText(TemporalField temporalField, long j11, TextStyle textStyle, Locale locale);

    public abstract Iterator<Map.Entry<String, Long>> getTextIterator(TemporalField temporalField, TextStyle textStyle, Locale locale);
}

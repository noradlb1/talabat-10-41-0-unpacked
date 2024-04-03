package com.designsystem.composition;

import java.util.Calendar;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n"}, d2 = {"Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class LocalCurrentTimeKt$LocalCalendar$1 extends Lambda implements Function0<Calendar> {
    public static final LocalCurrentTimeKt$LocalCalendar$1 INSTANCE = new LocalCurrentTimeKt$LocalCalendar$1();

    public LocalCurrentTimeKt$LocalCalendar$1() {
        super(0);
    }

    public final Calendar invoke() {
        return Calendar.getInstance(Locale.getDefault());
    }
}

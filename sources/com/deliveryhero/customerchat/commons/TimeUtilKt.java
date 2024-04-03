package com.deliveryhero.customerchat.commons;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001¨\u0006\u0003"}, d2 = {"convertNanosToMillis", "", "nanoseconds", "customerchat_basicRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TimeUtilKt {
    public static final long convertNanosToMillis(long j11) {
        return TimeUnit.MILLISECONDS.convert(j11, TimeUnit.NANOSECONDS);
    }
}

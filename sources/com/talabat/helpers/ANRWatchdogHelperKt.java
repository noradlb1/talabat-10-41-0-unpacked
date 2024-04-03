package com.talabat.helpers;

import com.github.anrwatchdog.ANRError;
import com.talabat.talabatcore.logger.LogManager;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u0006\u0010\u0002\u001a\u00020\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0004"}, d2 = {"ANR_WATCH_DOG_TAG", "", "enableANRWatchdog", "", "com_talabat_talabat_talabat"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ANRWatchdogHelperKt {
    @NotNull
    private static final String ANR_WATCH_DOG_TAG = "ANRWatchDogTAG";

    public static final void enableANRWatchdog() {
    }

    /* renamed from: enableANRWatchdog$lambda-1  reason: not valid java name */
    private static final void m10623enableANRWatchdog$lambda1(ANRError aNRError) {
        Throwable cause = aNRError.getCause();
        if (cause != null) {
            LogManager.logException(cause);
        }
    }
}

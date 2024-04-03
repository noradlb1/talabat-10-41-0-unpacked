package com.adyen.checkout.util;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import java.util.Locale;

public final class LocaleUtil {
    private LocaleUtil() {
        throw new IllegalStateException("No instances.");
    }

    @NonNull
    public static Locale getLocale(@NonNull Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return context.getResources().getConfiguration().locale;
        }
        return context.getResources().getConfiguration().getLocales().get(0);
    }
}

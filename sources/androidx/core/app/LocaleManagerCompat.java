package androidx.core.app;

import android.app.LocaleManager;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.AnyThread;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.os.BuildCompat;
import androidx.core.os.LocaleListCompat;
import java.util.Locale;

public final class LocaleManagerCompat {

    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static String toLanguageTag(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static LocaleListCompat getLocales(Configuration configuration) {
            return LocaleListCompat.forLanguageTags(configuration.getLocales().toLanguageTags());
        }
    }

    @RequiresApi(33)
    public static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        public static LocaleList localeManagerGetSystemLocales(Object obj) {
            return ((LocaleManager) obj).getSystemLocales();
        }
    }

    private LocaleManagerCompat() {
    }

    @VisibleForTesting
    public static LocaleListCompat getConfigurationLocales(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 24) {
            return Api24Impl.getLocales(configuration);
        }
        return LocaleListCompat.forLanguageTags(Api21Impl.toLanguageTag(configuration.locale));
    }

    @RequiresApi(33)
    private static Object getLocaleManagerForApplication(Context context) {
        return context.getSystemService("locale");
    }

    @NonNull
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @AnyThread
    public static LocaleListCompat getSystemLocales(@NonNull Context context) {
        LocaleListCompat emptyLocaleList = LocaleListCompat.getEmptyLocaleList();
        if (!BuildCompat.isAtLeastT()) {
            return getConfigurationLocales(context.getApplicationContext().getResources().getConfiguration());
        }
        Object localeManagerForApplication = getLocaleManagerForApplication(context);
        if (localeManagerForApplication != null) {
            return LocaleListCompat.wrap(Api33Impl.localeManagerGetSystemLocales(localeManagerForApplication));
        }
        return emptyLocaleList;
    }
}

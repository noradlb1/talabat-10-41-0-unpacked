package androidx.core.os;

import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

public final class ConfigurationCompat {

    @RequiresApi(24)
    public static class Api24Impl {
        private Api24Impl() {
        }

        @DoNotInline
        public static LocaleList a(Configuration configuration) {
            return configuration.getLocales();
        }
    }

    private ConfigurationCompat() {
    }

    @NonNull
    public static LocaleListCompat getLocales(@NonNull Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 24) {
            return LocaleListCompat.wrap(Api24Impl.a(configuration));
        }
        return LocaleListCompat.create(configuration.locale);
    }
}

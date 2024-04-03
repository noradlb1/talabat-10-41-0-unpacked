package androidx.appcompat.app;

import androidx.annotation.RequiresApi;
import androidx.core.os.LocaleListCompat;
import java.util.LinkedHashSet;
import java.util.Locale;

@RequiresApi(24)
final class LocaleOverlayHelper {
    private LocaleOverlayHelper() {
    }

    public static LocaleListCompat a(LocaleListCompat localeListCompat, LocaleListCompat localeListCompat2) {
        if (localeListCompat == null || localeListCompat.isEmpty()) {
            return LocaleListCompat.getEmptyLocaleList();
        }
        return combineLocales(localeListCompat, localeListCompat2);
    }

    private static LocaleListCompat combineLocales(LocaleListCompat localeListCompat, LocaleListCompat localeListCompat2) {
        Locale locale;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (int i11 = 0; i11 < localeListCompat.size() + localeListCompat2.size(); i11++) {
            if (i11 < localeListCompat.size()) {
                locale = localeListCompat.get(i11);
            } else {
                locale = localeListCompat2.get(i11 - localeListCompat.size());
            }
            if (locale != null) {
                linkedHashSet.add(locale);
            }
        }
        return LocaleListCompat.create((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
    }
}

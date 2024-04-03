package com.google.android.gms.internal.p002firebaseauthapi;

import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.util.Locale;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabe  reason: invalid package */
public final class zzabe {
    public static String zza() {
        Locale locale = Locale.getDefault();
        StringBuilder sb2 = new StringBuilder();
        zzb(sb2, locale);
        Locale locale2 = Locale.US;
        if (!locale.equals(locale2)) {
            if (sb2.length() > 0) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
            zzb(sb2, locale2);
        }
        return sb2.toString();
    }

    private static void zzb(StringBuilder sb2, Locale locale) {
        String language = locale.getLanguage();
        if (language != null) {
            sb2.append(language);
            String country = locale.getCountry();
            if (country != null) {
                sb2.append(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE);
                sb2.append(country);
            }
        }
    }
}

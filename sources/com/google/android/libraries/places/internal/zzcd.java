package com.google.android.libraries.places.internal;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

final class zzcd {
    private final String zza;
    private final String zzb;
    @Nullable
    private Locale zzc = null;
    private Map<String, String> zzd = new HashMap();

    public zzcd(String str, String str2) {
        this.zza = str;
        zzfm.zze(!TextUtils.isEmpty(str2), "API key cannot be empty.");
        this.zzb = str2;
    }

    public final zzcd zza(@Nullable Locale locale) {
        this.zzc = locale;
        return this;
    }

    public final zzcd zzb(Map<String, String> map) {
        this.zzd = new HashMap(map);
        return this;
    }

    public final String zzc() {
        Uri.Builder buildUpon = Uri.parse("https://maps.googleapis.com/").buildUpon();
        buildUpon.appendEncodedPath("maps/api/place/");
        buildUpon.appendEncodedPath(this.zza);
        buildUpon.appendQueryParameter("key", this.zzb);
        Locale locale = this.zzc;
        if (locale != null) {
            String languageTag = locale.toLanguageTag();
            if (!TextUtils.isEmpty(languageTag)) {
                buildUpon.appendQueryParameter(ConstantsKt.ADJUST_LANGUAGE, languageTag);
            }
        }
        Map<String, String> map = this.zzd;
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
            }
        }
        return buildUpon.build().toString();
    }
}

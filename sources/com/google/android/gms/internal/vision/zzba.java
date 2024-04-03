package com.google.android.gms.internal.vision;

import android.net.Uri;
import java.util.Map;
import javax.annotation.Nullable;

public final class zzba {
    private final Map<String, Map<String, String>> map;

    public zzba(Map<String, Map<String, String>> map2) {
        this.map = map2;
    }

    @Nullable
    public final String zza(@Nullable Uri uri, @Nullable String str, @Nullable String str2, String str3) {
        if (uri != null) {
            str = uri.toString();
        } else if (str == null) {
            return null;
        }
        Map map2 = this.map.get(str);
        if (map2 == null) {
            return null;
        }
        if (str2 != null) {
            String valueOf = String.valueOf(str3);
            if (valueOf.length() != 0) {
                str3 = str2.concat(valueOf);
            } else {
                str3 = new String(str2);
            }
        }
        return (String) map2.get(str3);
    }
}

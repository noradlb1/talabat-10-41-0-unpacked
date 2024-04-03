package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.LibraryVersion;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabb  reason: invalid package */
public final class zzabb {
    private final int zza;

    public zzabb(String str) {
        int i11 = -1;
        try {
            List zzd = zzab.zzc("[.-]").zzd(str);
            if (zzd.size() == 1) {
                i11 = Integer.parseInt(str);
            } else if (zzd.size() >= 3) {
                i11 = (Integer.parseInt((String) zzd.get(0)) * 1000000) + (Integer.parseInt((String) zzd.get(1)) * 1000) + Integer.parseInt((String) zzd.get(2));
            }
        } catch (IllegalArgumentException e11) {
            if (Log.isLoggable("LibraryVersionContainer", 3)) {
                String.format("Version code parsing failed for: %s with exception %s.", new Object[]{str, e11});
            }
        }
        this.zza = i11;
    }

    public static zzabb zza() {
        String version = LibraryVersion.getInstance().getVersion("firebase-auth");
        if (TextUtils.isEmpty(version) || version.equals("UNKNOWN")) {
            version = "-1";
        }
        return new zzabb(version);
    }

    public final String zzb() {
        return String.format("X%s", new Object[]{Integer.toString(this.zza)});
    }
}

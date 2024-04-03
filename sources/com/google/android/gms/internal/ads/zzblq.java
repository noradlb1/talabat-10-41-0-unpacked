package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzt;

@Deprecated
public final class zzblq {
    public static boolean zza(@Nullable zzbly zzbly, @Nullable zzblv zzblv, String... strArr) {
        if (zzblv == null) {
            return false;
        }
        zzbly.zze(zzblv, zzt.zzA().elapsedRealtime(), strArr);
        return true;
    }
}

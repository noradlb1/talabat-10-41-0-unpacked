package com.google.android.gms.internal.auth;

import android.util.Log;
import javax.annotation.Nullable;

final class zzcv extends zzdc {
    public zzcv(zzcz zzcz, String str, Long l11, boolean z11) {
        super(zzcz, str, l11, true, (zzdb) null);
    }

    @Nullable
    public final /* bridge */ /* synthetic */ Object zza(Object obj) {
        try {
            return Long.valueOf(Long.parseLong((String) obj));
        } catch (NumberFormatException unused) {
            String zzc = super.zzc();
            Log.e("PhenotypeFlag", "Invalid long value for " + zzc + ": " + ((String) obj));
            return null;
        }
    }
}

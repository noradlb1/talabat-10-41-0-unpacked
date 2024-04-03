package com.google.android.gms.internal.auth;

import android.util.Log;
import javax.annotation.Nullable;

final class zzcx extends zzdc {
    public zzcx(zzcz zzcz, String str, Double d11, boolean z11) {
        super(zzcz, str, d11, true, (zzdb) null);
    }

    @Nullable
    public final /* bridge */ /* synthetic */ Object zza(Object obj) {
        try {
            return Double.valueOf(Double.parseDouble((String) obj));
        } catch (NumberFormatException unused) {
            String zzc = super.zzc();
            Log.e("PhenotypeFlag", "Invalid double value for " + zzc + ": " + ((String) obj));
            return null;
        }
    }
}

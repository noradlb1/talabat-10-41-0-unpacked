package com.google.android.gms.internal.measurement;

import android.util.Log;
import javax.annotation.Nullable;

final class zzhu extends zzib {
    public zzhu(zzhy zzhy, String str, Long l11, boolean z11) {
        super(zzhy, str, l11, true, (zzia) null);
    }

    @Nullable
    public final /* synthetic */ Object zza(Object obj) {
        try {
            return Long.valueOf(Long.parseLong((String) obj));
        } catch (NumberFormatException unused) {
            String str = this.zzb;
            Log.e("PhenotypeFlag", "Invalid long value for " + str + ": " + ((String) obj));
            return null;
        }
    }
}

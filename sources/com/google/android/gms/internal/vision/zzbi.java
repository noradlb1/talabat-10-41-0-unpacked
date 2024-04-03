package com.google.android.gms.internal.vision;

import android.util.Base64;
import android.util.Log;
import java.io.IOException;

final class zzbi extends zzbe {
    private final /* synthetic */ zzbh zzgg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbi(zzbk zzbk, String str, Object obj, zzbh zzbh) {
        super(zzbk, str, obj, (zzbg) null);
        this.zzgg = zzbh;
    }

    public final Object zza(Object obj) {
        if (obj instanceof String) {
            try {
                return this.zzgg.zzb(Base64.decode((String) obj, 3));
            } catch (IOException | IllegalArgumentException unused) {
            }
        }
        String zzac = super.zzac();
        String valueOf = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(String.valueOf(zzac).length() + 27 + valueOf.length());
        sb2.append("Invalid byte[] value for ");
        sb2.append(zzac);
        sb2.append(": ");
        sb2.append(valueOf);
        Log.e("PhenotypeFlag", sb2.toString());
        return null;
    }
}

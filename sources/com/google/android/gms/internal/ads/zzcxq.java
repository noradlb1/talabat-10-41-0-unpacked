package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcxq implements zzgpr<JSONObject> {
    private final zzgqe<zzfdn> zza;

    public zzcxq(zzgqe<zzfdn> zzgqe) {
        this.zza = zzgqe;
    }

    @Nullable
    public final /* bridge */ /* synthetic */ Object zzb() {
        try {
            return new JSONObject(((zzdbl) this.zza).zza().zzA);
        } catch (JSONException unused) {
            return null;
        }
    }
}

package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;
import java.util.HashSet;
import org.json.JSONObject;

public final class zzflm {
    private JSONObject zza;
    private final zzflv zzb;

    public zzflm(zzflv zzflv) {
        this.zzb = zzflv;
    }

    @VisibleForTesting
    public final JSONObject zza() {
        return this.zza;
    }

    public final void zzb() {
        this.zzb.zzb(new zzflw(this, (byte[]) null));
    }

    public final void zzc(JSONObject jSONObject, HashSet<String> hashSet, long j11) {
        this.zzb.zzb(new zzflx(this, hashSet, jSONObject, j11, (long) null));
    }

    public final void zzd(JSONObject jSONObject, HashSet<String> hashSet, long j11) {
        this.zzb.zzb(new zzfly(this, hashSet, jSONObject, j11, (long) null));
    }

    @VisibleForTesting
    public final void zze(JSONObject jSONObject) {
        this.zza = jSONObject;
    }
}

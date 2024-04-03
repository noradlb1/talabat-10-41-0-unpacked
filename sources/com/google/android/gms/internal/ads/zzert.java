package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;

public final class zzert implements zzevn<zzevm<Bundle>> {
    @Nullable
    private final zzfaj zza;

    public zzert(@Nullable zzfaj zzfaj) {
        this.zza = zzfaj;
    }

    public final /* synthetic */ void zza(Bundle bundle) {
        bundle.putString("key_schema", this.zza.zza());
    }

    public final zzfxa<zzevm<Bundle>> zzb() {
        zzfaj zzfaj = this.zza;
        zzers zzers = null;
        if (!(zzfaj == null || zzfaj.zza() == null || this.zza.zza().isEmpty())) {
            zzers = new zzers(this);
        }
        return zzfwq.zzi(zzers);
    }
}

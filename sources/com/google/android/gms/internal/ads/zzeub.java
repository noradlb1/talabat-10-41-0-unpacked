package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;

public final class zzeub implements zzevn<zzeuc> {
    private final zzfxb zza;
    private final Bundle zzb;

    public zzeub(zzfxb zzfxb, @Nullable Bundle bundle) {
        this.zza = zzfxb;
        this.zzb = bundle;
    }

    public final /* synthetic */ zzeuc zza() throws Exception {
        return new zzeuc(this.zzb);
    }

    public final zzfxa<zzeuc> zzb() {
        return this.zza.zzb(new zzeua(this));
    }
}

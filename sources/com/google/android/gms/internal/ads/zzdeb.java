package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;

public final class zzdeb {
    /* access modifiers changed from: private */
    public Context zza;
    /* access modifiers changed from: private */
    public zzfef zzb;
    /* access modifiers changed from: private */
    public Bundle zzc;
    /* access modifiers changed from: private */
    @Nullable
    public zzfea zzd;

    public final zzdeb zzc(Context context) {
        this.zza = context;
        return this;
    }

    public final zzdeb zzd(Bundle bundle) {
        this.zzc = bundle;
        return this;
    }

    public final zzdeb zze(zzfea zzfea) {
        this.zzd = zzfea;
        return this;
    }

    public final zzdeb zzf(zzfef zzfef) {
        this.zzb = zzfef;
        return this;
    }

    public final zzded zzg() {
        return new zzded(this, (zzdec) null);
    }
}

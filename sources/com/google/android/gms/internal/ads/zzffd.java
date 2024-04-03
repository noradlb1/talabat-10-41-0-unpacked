package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import java.util.HashSet;
import javax.annotation.concurrent.GuardedBy;

public final class zzffd implements zzdeu {
    @GuardedBy("this")
    private final HashSet<zzcie> zza = new HashSet<>();
    private final Context zzb;
    private final zzcio zzc;

    public zzffd(Context context, zzcio zzcio) {
        this.zzb = context;
        this.zzc = zzcio;
    }

    public final synchronized void zza(zzbew zzbew) {
        if (zzbew.zza != 3) {
            this.zzc.zzi(this.zza);
        }
    }

    public final Bundle zzb() {
        return this.zzc.zzk(this.zzb, this);
    }

    public final synchronized void zzc(HashSet<zzcie> hashSet) {
        this.zza.clear();
        this.zza.addAll(hashSet);
    }
}

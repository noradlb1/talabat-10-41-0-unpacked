package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzejy implements zzdob {
    private final zzfdn zza;
    private final zzbzo zzb;
    private final boolean zzc;
    @Nullable
    private zzdfj zzd = null;

    public zzejy(zzfdn zzfdn, zzbzo zzbzo, boolean z11) {
        this.zza = zzfdn;
        this.zzb = zzbzo;
        this.zzc = z11;
    }

    public final void zza(boolean z11, Context context, zzdfe zzdfe) throws zzdoa {
        boolean z12;
        try {
            if (this.zzc) {
                z12 = this.zzb.zzr(ObjectWrapper.wrap(context));
            } else {
                z12 = this.zzb.zzq(ObjectWrapper.wrap(context));
            }
            if (!z12) {
                throw new zzdoa("Adapter failed to show.");
            } else if (this.zzd != null) {
                if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzbg)).booleanValue() && this.zza.zzV == 2) {
                    this.zzd.zza();
                }
            }
        } catch (Throwable th2) {
            throw new zzdoa(th2);
        }
    }

    public final void zzb(zzdfj zzdfj) {
        this.zzd = zzdfj;
    }
}

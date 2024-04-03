package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import java.util.ArrayList;

final class zzddu implements zzdgf, zzdfm {
    private final Context zza;
    private final zzfdn zzb;
    private final zzcbx zzc;

    public zzddu(Context context, zzfdn zzfdn, zzcbx zzcbx, byte[] bArr) {
        this.zza = context;
        this.zzb = zzfdn;
        this.zzc = zzcbx;
    }

    public final void zzbA(@Nullable Context context) {
    }

    public final void zzbB(@Nullable Context context) {
    }

    public final void zzby(@Nullable Context context) {
    }

    public final void zzn() {
        zzcby zzcby = this.zzb.zzaa;
        if (zzcby != null && zzcby.zza) {
            ArrayList arrayList = new ArrayList();
            if (!this.zzb.zzaa.zzb.isEmpty()) {
                arrayList.add(this.zzb.zzaa.zzb);
            }
        }
    }
}

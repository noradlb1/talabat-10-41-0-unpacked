package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

public final class zzdwo implements zzdfm {
    @Nullable
    private final zzcop zza;

    public zzdwo(@Nullable zzcop zzcop) {
        this.zza = zzcop;
    }

    public final void zzbA(@Nullable Context context) {
        zzcop zzcop = this.zza;
        if (zzcop != null) {
            zzcop.onPause();
        }
    }

    public final void zzbB(@Nullable Context context) {
        zzcop zzcop = this.zza;
        if (zzcop != null) {
            zzcop.onResume();
        }
    }

    public final void zzby(@Nullable Context context) {
        zzcop zzcop = this.zza;
        if (zzcop != null) {
            zzcop.destroy();
        }
    }
}

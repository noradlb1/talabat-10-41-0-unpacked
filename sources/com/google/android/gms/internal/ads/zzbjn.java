package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdInspectorError;
import com.google.android.gms.ads.OnAdInspectorClosedListener;
import javax.annotation.Nullable;

final class zzbjn extends zzbim {
    private zzbjn() {
    }

    public final void zze(@Nullable zzbew zzbew) {
        AdInspectorError adInspectorError;
        OnAdInspectorClosedListener zzb = zzbjq.zzf().zzg;
        if (zzb != null) {
            if (zzbew == null) {
                adInspectorError = null;
            } else {
                adInspectorError = new AdInspectorError(zzbew.zza, zzbew.zzb, zzbew.zzc);
            }
            zzb.onAdInspectorClosed(adInspectorError);
        }
    }

    public /* synthetic */ zzbjn(zzbjm zzbjm) {
    }
}

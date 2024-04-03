package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public final class zzg {
    public static final zzg zza = new zzg(0, 0, 1, 1, (zzf) null);
    public static final zzj<zzg> zzb = zze.zza;
    public final int zzc = 1;
    @Nullable
    private AudioAttributes zzd;

    public /* synthetic */ zzg(int i11, int i12, int i13, int i14, zzf zzf) {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzg.class != obj.getClass()) {
            return false;
        }
        zzg zzg = (zzg) obj;
        return true;
    }

    public final int hashCode() {
        return 15699889;
    }

    @RequiresApi(21)
    public final AudioAttributes zza() {
        if (this.zzd == null) {
            AudioAttributes.Builder usage = new AudioAttributes.Builder().setContentType(0).setFlags(0).setUsage(1);
            if (zzfn.zza >= 29) {
                AudioAttributes.Builder unused = usage.setAllowedCapturePolicy(1);
            }
            this.zzd = usage.build();
        }
        return this.zzd;
    }
}

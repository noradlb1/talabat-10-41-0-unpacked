package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;

public final class zzcba {
    /* access modifiers changed from: private */
    public final NativeCustomFormatAd.OnCustomFormatAdLoadedListener zza;
    /* access modifiers changed from: private */
    @Nullable
    public final NativeCustomFormatAd.OnCustomClickListener zzb;
    @GuardedBy("this")
    @Nullable
    private NativeCustomFormatAd zzc;

    public zzcba(NativeCustomFormatAd.OnCustomFormatAdLoadedListener onCustomFormatAdLoadedListener, @Nullable NativeCustomFormatAd.OnCustomClickListener onCustomClickListener) {
        this.zza = onCustomFormatAdLoadedListener;
        this.zzb = onCustomClickListener;
    }

    /* access modifiers changed from: private */
    public final synchronized NativeCustomFormatAd zzf(zzbpc zzbpc) {
        NativeCustomFormatAd nativeCustomFormatAd = this.zzc;
        if (nativeCustomFormatAd != null) {
            return nativeCustomFormatAd;
        }
        zzcbb zzcbb = new zzcbb(zzbpc);
        this.zzc = zzcbb;
        return zzcbb;
    }

    @Nullable
    public final zzbpm zza() {
        if (this.zzb == null) {
            return null;
        }
        return new zzcax(this, (zzcaw) null);
    }

    public final zzbpp zzb() {
        return new zzcaz(this, (zzcay) null);
    }
}

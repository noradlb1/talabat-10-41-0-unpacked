package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

public final class zzbqn {
    /* access modifiers changed from: private */
    public final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener zza;
    /* access modifiers changed from: private */
    @Nullable
    public final NativeCustomTemplateAd.OnCustomClickListener zzb;
    @GuardedBy("this")
    @Nullable
    private NativeCustomTemplateAd zzc;

    public zzbqn(NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, @Nullable NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
        this.zza = onCustomTemplateAdLoadedListener;
        this.zzb = onCustomClickListener;
    }

    /* access modifiers changed from: private */
    public final synchronized NativeCustomTemplateAd zzf(zzbpc zzbpc) {
        NativeCustomTemplateAd nativeCustomTemplateAd = this.zzc;
        if (nativeCustomTemplateAd != null) {
            return nativeCustomTemplateAd;
        }
        zzbpd zzbpd = new zzbpd(zzbpc);
        this.zzc = zzbpd;
        return zzbpd;
    }

    @Nullable
    public final zzbpm zzd() {
        if (this.zzb == null) {
            return null;
        }
        return new zzbqk(this, (zzbqj) null);
    }

    public final zzbpp zze() {
        return new zzbqm(this, (zzbql) null);
    }
}

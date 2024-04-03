package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdListener;

public final class zzbey extends zzbgw {
    private final AdListener zza;

    public zzbey(AdListener adListener) {
        this.zza = adListener;
    }

    public final AdListener zzb() {
        return this.zza;
    }

    public final void zzc() {
        AdListener adListener = this.zza;
        if (adListener != null) {
            adListener.onAdClicked();
        }
    }

    public final void zzd() {
        AdListener adListener = this.zza;
        if (adListener != null) {
            adListener.onAdClosed();
        }
    }

    public final void zze(int i11) {
    }

    public final void zzf(zzbew zzbew) {
        AdListener adListener = this.zza;
        if (adListener != null) {
            adListener.onAdFailedToLoad(zzbew.zzb());
        }
    }

    public final void zzg() {
        AdListener adListener = this.zza;
        if (adListener != null) {
            adListener.onAdImpression();
        }
    }

    public final void zzh() {
    }

    public final void zzi() {
        AdListener adListener = this.zza;
        if (adListener != null) {
            adListener.onAdLoaded();
        }
    }

    public final void zzj() {
        AdListener adListener = this.zza;
        if (adListener != null) {
            adListener.onAdOpened();
        }
    }
}

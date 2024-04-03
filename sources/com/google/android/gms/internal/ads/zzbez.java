package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdLoadCallback;

public final class zzbez<AdT> extends zzbgz {
    private final AdLoadCallback<AdT> zza;
    private final AdT zzb;

    public zzbez(AdLoadCallback<AdT> adLoadCallback, AdT adt) {
        this.zza = adLoadCallback;
        this.zzb = adt;
    }

    public final void zzb(zzbew zzbew) {
        AdLoadCallback<AdT> adLoadCallback = this.zza;
        if (adLoadCallback != null) {
            adLoadCallback.onAdFailedToLoad(zzbew.zzb());
        }
    }

    public final void zzc() {
        AdT adt;
        AdLoadCallback<AdT> adLoadCallback = this.zza;
        if (adLoadCallback != null && (adt = this.zzb) != null) {
            adLoadCallback.onAdLoaded(adt);
        }
    }
}

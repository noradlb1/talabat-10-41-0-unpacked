package com.google.android.gms.internal.ads;

import androidx.annotation.RequiresApi;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;

@RequiresApi(api = 21)
public final class zzbsl extends zzbsn {
    private final OnH5AdsEventListener zza;

    public zzbsl(OnH5AdsEventListener onH5AdsEventListener) {
        this.zza = onH5AdsEventListener;
    }

    public final void zzb(String str) {
        this.zza.onH5AdsEvent(str);
    }
}

package com.google.android.gms.ads.h5;

import android.content.Context;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RequiresApi;
import com.google.android.gms.internal.ads.zzbsv;

@RequiresApi(api = 21)
public final class H5AdsRequestHandler {
    private final zzbsv zza;

    public H5AdsRequestHandler(@RecentlyNonNull Context context, @RecentlyNonNull OnH5AdsEventListener onH5AdsEventListener) {
        this.zza = new zzbsv(context, onH5AdsEventListener);
    }

    public void clearAdObjects() {
        this.zza.zza();
    }

    public boolean handleH5AdsRequest(@RecentlyNonNull String str) {
        return this.zza.zzb(str);
    }

    public boolean shouldInterceptRequest(@RecentlyNonNull String str) {
        return zzbsv.zzc(str);
    }
}

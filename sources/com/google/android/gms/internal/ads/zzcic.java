package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

public final class zzcic {
    public final zzfxa<AdvertisingIdClient.Info> zza(Context context, int i11) {
        zzcjr zzcjr = new zzcjr();
        zzbgo.zzb();
        if (zzcis.zzo(context)) {
            zzcjm.zza.execute(new zzcib(this, context, zzcjr));
        }
        return zzcjr;
    }
}

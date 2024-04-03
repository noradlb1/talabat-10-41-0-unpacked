package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final /* synthetic */ class zzdtp implements zzaya {
    public final /* synthetic */ zzcop zza;

    public /* synthetic */ zzdtp(zzcop zzcop) {
        this.zza = zzcop;
    }

    public final void zzc(zzaxz zzaxz) {
        String str;
        zzcop zzcop = this.zza;
        HashMap hashMap = new HashMap();
        if (true != zzaxz.zzj) {
            str = "0";
        } else {
            str = "1";
        }
        hashMap.put("isVisible", str);
        zzcop.zzd("onAdVisibilityChanged", hashMap);
    }
}

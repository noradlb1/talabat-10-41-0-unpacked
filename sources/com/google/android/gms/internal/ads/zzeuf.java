package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzeuf implements zzevm<Bundle> {
    private final String zza;
    private final String zzb;

    public zzeuf(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzfo)).booleanValue()) {
            bundle.putString("request_id", this.zzb);
        } else {
            bundle.putString("request_id", this.zza);
        }
    }
}

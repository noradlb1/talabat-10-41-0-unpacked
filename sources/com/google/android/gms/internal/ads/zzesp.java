package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzesp implements zzevm<Bundle> {
    public final String zza;
    public final boolean zzb;

    public zzesp(String str, boolean z11) {
        this.zza = str;
        this.zzb = z11;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("gct", this.zza);
        if (this.zzb) {
            bundle.putString("de", "1");
        }
    }
}

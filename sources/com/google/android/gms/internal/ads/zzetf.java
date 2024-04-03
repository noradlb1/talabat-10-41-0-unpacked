package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzetf implements zzevm<Bundle> {
    public final Bundle zza;

    public zzetf(Bundle bundle) {
        this.zza = bundle;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = (Bundle) obj;
        Bundle zza2 = zzfeq.zza(bundle, "device");
        zza2.putBundle("android_mem_info", this.zza);
        bundle.putBundle("device", zza2);
    }
}

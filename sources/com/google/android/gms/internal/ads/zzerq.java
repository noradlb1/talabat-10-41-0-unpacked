package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzerq implements zzevm<Bundle> {
    public final double zza;
    public final boolean zzb;

    public zzerq(double d11, boolean z11) {
        this.zza = d11;
        this.zzb = z11;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = (Bundle) obj;
        Bundle zza2 = zzfeq.zza(bundle, "device");
        bundle.putBundle("device", zza2);
        Bundle zza3 = zzfeq.zza(zza2, "battery");
        zza2.putBundle("battery", zza3);
        zza3.putBoolean("is_charging", this.zzb);
        zza3.putDouble("battery_level", this.zza);
    }
}

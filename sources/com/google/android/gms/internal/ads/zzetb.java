package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzetb implements zzevm<Bundle> {
    private final String zza;
    private final boolean zzb;
    private final boolean zzc;

    public zzetb(String str, boolean z11, boolean z12) {
        this.zza = str;
        this.zzb = z11;
        this.zzc = z12;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (!this.zza.isEmpty()) {
            bundle.putString("inspector_extras", this.zza);
        }
        bundle.putInt("test_mode", this.zzb ? 1 : 0);
        bundle.putInt("linked_device", this.zzc ? 1 : 0);
    }
}

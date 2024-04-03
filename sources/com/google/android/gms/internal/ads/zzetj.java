package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzetj implements zzevm<Bundle> {
    public final zzfdm zza;

    public zzetj(zzfdm zzfdm) {
        this.zza = zzfdm;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = (Bundle) obj;
        zzfdm zzfdm = this.zza;
        if (zzfdm != null) {
            bundle.putBoolean("render_in_browser", zzfdm.zzd());
            bundle.putBoolean("disable_ml", this.zza.zzc());
        }
    }
}

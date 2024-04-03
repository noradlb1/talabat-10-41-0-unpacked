package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzeqq implements zzevm<Bundle> {
    private final Bundle zza;

    public /* synthetic */ zzeqq(Bundle bundle, zzeqp zzeqp) {
        this.zza = bundle;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (!this.zza.isEmpty()) {
            bundle.putBundle("installed_adapter_data", this.zza);
        }
    }
}

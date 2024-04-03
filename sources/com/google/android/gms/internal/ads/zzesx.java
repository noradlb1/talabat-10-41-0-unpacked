package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzesx implements zzevm<Bundle> {
    private final Boolean zza;

    public zzesx(Boolean bool) {
        this.zza = bool;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = (Bundle) obj;
        Boolean bool = this.zza;
        if (bool != null) {
            bundle.putBoolean("hw_accel", bool.booleanValue());
        }
    }
}

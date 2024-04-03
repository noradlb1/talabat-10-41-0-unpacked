package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzeuc implements zzevm<Bundle> {
    private final Bundle zza;

    public zzeuc(Bundle bundle) {
        this.zza = bundle;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = (Bundle) obj;
        Bundle bundle2 = this.zza;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }
}

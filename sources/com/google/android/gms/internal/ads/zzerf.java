package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;

public final class zzerf implements zzevm<Bundle> {
    @Nullable
    private final String zza;
    private final int zzb;

    public zzerf(@Nullable String str, int i11) {
        this.zza = str;
        this.zzb = i11;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (!TextUtils.isEmpty(this.zza) && this.zzb != -1) {
            Bundle zza2 = zzfeq.zza(bundle, "pii");
            bundle.putBundle("pii", zza2);
            zza2.putString("pvid", this.zza);
            zza2.putInt("pvid_s", this.zzb);
        }
    }
}

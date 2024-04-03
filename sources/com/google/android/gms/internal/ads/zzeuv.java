package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;

public final class zzeuv implements zzevm<Bundle> {
    @Nullable
    private final String zza;

    public zzeuv(@Nullable String str) {
        this.zza = str;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (!TextUtils.isEmpty(this.zza)) {
            bundle.putString("query_info", this.zza);
        }
    }
}

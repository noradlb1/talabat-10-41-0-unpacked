package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

public final class zzcwj implements zzcvr {
    private final zzebt zza;

    public zzcwj(zzebt zzebt) {
        this.zza = zzebt;
    }

    public final void zza(Map<String, String> map) {
        String str = map.get("test_mode_enabled");
        if (!TextUtils.isEmpty(str)) {
            this.zza.zzl(str.equals("true"));
        }
    }
}

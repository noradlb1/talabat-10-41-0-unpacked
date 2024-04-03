package com.google.android.recaptcha.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzgq {
    static final zzgq zza = new zzgq(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private final Map zzd;

    public zzgq() {
        this.zzd = new HashMap();
    }

    public final zzhd zza(zzip zzip, int i11) {
        return (zzhd) this.zzd.get(new zzgp(zzip, i11));
    }

    public zzgq(boolean z11) {
        this.zzd = Collections.emptyMap();
    }
}

package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Map;

public final class zzdk {
    @Nullable
    private Uri zza;
    private final int zzb = 1;
    private Map<String, String> zzc = Collections.emptyMap();
    private long zzd;
    private int zze;

    public final zzdk zza(int i11) {
        this.zze = 6;
        return this;
    }

    public final zzdk zzb(Map<String, String> map) {
        this.zzc = map;
        return this;
    }

    public final zzdk zzc(long j11) {
        this.zzd = j11;
        return this;
    }

    public final zzdk zzd(Uri uri) {
        this.zza = uri;
        return this;
    }

    public final zzdm zze() {
        Uri uri = this.zza;
        if (uri != null) {
            return new zzdm(uri, 0, 1, (byte[]) null, this.zzc, this.zzd, -1, (String) null, this.zze, (Object) null, (zzdl) null);
        }
        throw new IllegalStateException("The uri must be set.");
    }
}

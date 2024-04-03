package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public final class zzahq {
    private final int zza;
    private final List<zzagk> zzb;
    private final int zzc;
    @Nullable
    private final InputStream zzd;

    public zzahq(int i11, List<zzagk> list, int i12, InputStream inputStream) {
        this.zza = i11;
        this.zzb = list;
        this.zzc = i12;
        this.zzd = inputStream;
    }

    public final int zza() {
        return this.zzc;
    }

    public final int zzb() {
        return this.zza;
    }

    @Nullable
    public final InputStream zzc() {
        InputStream inputStream = this.zzd;
        if (inputStream != null) {
            return inputStream;
        }
        return null;
    }

    public final List<zzagk> zzd() {
        return Collections.unmodifiableList(this.zzb);
    }
}

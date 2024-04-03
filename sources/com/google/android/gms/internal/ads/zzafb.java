package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

public final class zzafb {
    public final int zza;
    @Nullable
    public final String zzb;
    public final List<zzafa> zzc;
    public final byte[] zzd;

    public zzafb(int i11, @Nullable String str, @Nullable List<zzafa> list, byte[] bArr) {
        List<zzafa> list2;
        this.zza = i11;
        this.zzb = str;
        if (list == null) {
            list2 = Collections.emptyList();
        } else {
            list2 = Collections.unmodifiableList(list);
        }
        this.zzc = list2;
        this.zzd = bArr;
    }
}

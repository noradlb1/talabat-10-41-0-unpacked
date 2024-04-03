package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.List;

public final class zzdbc {
    public final List<? extends zzfxa<? extends zzdav>> zza;

    public zzdbc(zzdav zzdav) {
        this.zza = Collections.singletonList(zzfwq.zzi(zzdav));
    }

    public zzdbc(List<? extends zzfxa<? extends zzdav>> list) {
        this.zza = list;
    }

    public static zzeht<zzdbc> zza(@NonNull zzeht<? extends zzdav> zzeht) {
        return new zzehu(zzeht, zzdba.zza);
    }
}

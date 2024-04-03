package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zza;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

final class zze extends zzbq {
    private static final String ID = zza.ADVERTISER_ID.toString();
    private final zza zzadt;

    public zze(Context context) {
        this(zza.zzf(context));
    }

    public final zzl zzb(Map<String, zzl> map) {
        String zzgq = this.zzadt.zzgq();
        if (zzgq == null) {
            return zzgj.zzkc();
        }
        return zzgj.zzi(zzgq);
    }

    public final boolean zzgw() {
        return false;
    }

    @VisibleForTesting
    private zze(zza zza) {
        super(ID, new String[0]);
        this.zzadt = zza;
        zza.zzgq();
    }
}

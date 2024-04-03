package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zza;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

final class zzdk extends zzbq {
    private static final String ID = zza.LOWERCASE_STRING.toString();
    private static final String zzags = zzb.ARG0.toString();

    public zzdk() {
        super(ID, zzags);
    }

    public final zzl zzb(Map<String, zzl> map) {
        return zzgj.zzi(zzgj.zzc(map.get(zzags)).toLowerCase());
    }

    public final boolean zzgw() {
        return true;
    }
}

package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.gtm.zza;
import com.google.android.gms.internal.gtm.zzb;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

final class zzcv extends zzbq {
    private static final String ID = zza.INSTALL_REFERRER.toString();
    private static final String zzadu = zzb.COMPONENT.toString();
    private final Context zzrm;

    public zzcv(Context context) {
        super(ID, new String[0]);
        this.zzrm = context;
    }

    public final zzl zzb(Map<String, zzl> map) {
        String str;
        String str2 = zzadu;
        if (map.get(str2) != null) {
            str = zzgj.zzc(map.get(str2));
        } else {
            str = null;
        }
        String zze = zzcw.zze(this.zzrm, str);
        if (zze != null) {
            return zzgj.zzi(zze);
        }
        return zzgj.zzkc();
    }

    public final boolean zzgw() {
        return true;
    }
}

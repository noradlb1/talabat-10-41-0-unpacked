package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkr  reason: invalid package */
public final class zzkr {
    public static final zzoi zza = new zzkq((zzkp) null);

    public static zzoo zza(zzcl zzcl) {
        zzbt zzbt;
        zzok zzok = new zzok();
        zzok.zzb(zzcl.zzb());
        for (List it : zzcl.zzd()) {
            Iterator it2 = it.iterator();
            while (true) {
                if (it2.hasNext()) {
                    zzch zzch = (zzch) it2.next();
                    int zzh = zzch.zzh() - 2;
                    if (zzh == 1) {
                        zzbt = zzbt.zza;
                    } else if (zzh == 2) {
                        zzbt = zzbt.zzb;
                    } else if (zzh == 3) {
                        zzbt = zzbt.zzc;
                    } else {
                        throw new IllegalStateException("Unknown key status");
                    }
                    int zza2 = zzch.zza();
                    String zzf = zzch.zzf();
                    if (zzf.startsWith("type.googleapis.com/google.crypto.")) {
                        zzf = zzf.substring(34);
                    }
                    zzok.zza(zzbt, zza2, zzf, zzch.zzc().name());
                }
            }
        }
        if (zzcl.zza() != null) {
            zzok.zzc(zzcl.zza().zza());
        }
        try {
            return zzok.zzd();
        } catch (GeneralSecurityException e11) {
            throw new IllegalStateException(e11);
        }
    }
}

package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzob  reason: invalid package */
final class zzob implements zzcm {
    /* access modifiers changed from: private */
    public static final Logger zza = Logger.getLogger(zzob.class.getName());
    /* access modifiers changed from: private */
    public static final byte[] zzb = {0};
    private static final zzob zzc = new zzob();

    public static void zze() throws GeneralSecurityException {
        zzcq.zzh(zzc);
    }

    public final Class zza() {
        return zzcd.class;
    }

    public final Class zzb() {
        return zzcd.class;
    }

    public final /* bridge */ /* synthetic */ Object zzc(zzcl zzcl) throws GeneralSecurityException {
        for (List it : zzcl.zzd()) {
            Iterator it2 = it.iterator();
            while (true) {
                if (it2.hasNext()) {
                    zzch zzch = (zzch) it2.next();
                    if (zzch.zzb() instanceof zznx) {
                        zznx zznx = (zznx) zzch.zzb();
                        zzwf zzb2 = zzwf.zzb(zzch.zzg());
                        if (!zzb2.equals(zznx.zzb())) {
                            String valueOf = String.valueOf(zznx.zza());
                            String obj = zznx.zzb().toString();
                            String obj2 = zzb2.toString();
                            throw new GeneralSecurityException("Mac Key with parameters " + valueOf + " has wrong output prefix (" + obj + ") instead of (" + obj2 + ")");
                        }
                    }
                }
            }
        }
        return new zzoa(zzcl, (zznz) null);
    }
}

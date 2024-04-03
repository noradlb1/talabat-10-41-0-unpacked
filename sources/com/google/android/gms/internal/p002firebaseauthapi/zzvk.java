package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvk  reason: invalid package */
public final class zzvk {
    public static final zzvk zza = new zzvk(new zzvl());
    public static final zzvk zzb = new zzvk(new zzvp());
    public static final zzvk zzc = new zzvk(new zzvr());
    public static final zzvk zzd = new zzvk(new zzvq());
    public static final zzvk zze = new zzvk(new zzvm());
    public static final zzvk zzf = new zzvk(new zzvo());
    public static final zzvk zzg = new zzvk(new zzvn());
    private final zzvj zzh;

    public zzvk(zzvs zzvs) {
        if (zzhk.zzb()) {
            this.zzh = new zzvi(zzvs, (zzvh) null);
        } else if (zzwb.zza()) {
            this.zzh = new zzve(zzvs, (zzvd) null);
        } else {
            this.zzh = new zzvg(zzvs, (zzvf) null);
        }
    }

    public static List zzb(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String provider : strArr) {
            Provider provider2 = Security.getProvider(provider);
            if (provider2 != null) {
                arrayList.add(provider2);
            }
        }
        return arrayList;
    }

    public final Object zza(String str) throws GeneralSecurityException {
        return this.zzh.zza(str);
    }
}

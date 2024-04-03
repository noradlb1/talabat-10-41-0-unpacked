package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmd  reason: invalid package */
public final class zzmd {
    /* access modifiers changed from: private */
    public final Map zza;
    /* access modifiers changed from: private */
    public final Map zzb;
    /* access modifiers changed from: private */
    public final Map zzc;
    /* access modifiers changed from: private */
    public final Map zzd;

    public /* synthetic */ zzmd(zzlx zzlx, zzmc zzmc) {
        this.zza = new HashMap(zzlx.zza);
        this.zzb = new HashMap(zzlx.zzb);
        this.zzc = new HashMap(zzlx.zzc);
        this.zzd = new HashMap(zzlx.zzd);
    }

    public final zzbm zza(zzlw zzlw, @Nullable zzcr zzcr) throws GeneralSecurityException {
        zzlz zzlz = new zzlz(zzlw.getClass(), zzlw.zzd(), (zzly) null);
        if (this.zzb.containsKey(zzlz)) {
            return ((zzke) this.zzb.get(zzlz)).zza(zzlw, zzcr);
        }
        String obj = zzlz.toString();
        throw new GeneralSecurityException("No Key Parser for requested key type " + obj + " available");
    }

    public final zzce zzb(zzlw zzlw) throws GeneralSecurityException {
        zzlz zzlz = new zzlz(zzlw.getClass(), zzlw.zzd(), (zzly) null);
        if (this.zzd.containsKey(zzlz)) {
            return ((zzlc) this.zzd.get(zzlz)).zza(zzlw);
        }
        String obj = zzlz.toString();
        throw new GeneralSecurityException("No Parameters Parser for requested key type " + obj + " available");
    }

    public final zzlw zzc(zzce zzce, Class cls) throws GeneralSecurityException {
        zzmb zzmb = new zzmb(zzce.getClass(), cls, (zzma) null);
        if (this.zzc.containsKey(zzmb)) {
            return ((zzlg) this.zzc.get(zzmb)).zza(zzce);
        }
        String obj = zzmb.toString();
        throw new GeneralSecurityException("No Key Format serializer for " + obj + " available");
    }

    public final boolean zzh(zzlw zzlw) {
        return this.zzb.containsKey(new zzlz(zzlw.getClass(), zzlw.zzd(), (zzly) null));
    }

    public final boolean zzi(zzlw zzlw) {
        return this.zzd.containsKey(new zzlz(zzlw.getClass(), zzlw.zzd(), (zzly) null));
    }
}

package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzlx  reason: invalid package */
public final class zzlx {
    /* access modifiers changed from: private */
    public final Map zza;
    /* access modifiers changed from: private */
    public final Map zzb;
    /* access modifiers changed from: private */
    public final Map zzc;
    /* access modifiers changed from: private */
    public final Map zzd;

    public zzlx() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
        this.zzc = new HashMap();
        this.zzd = new HashMap();
    }

    public final zzlx zza(zzke zzke) throws GeneralSecurityException {
        zzlz zzlz = new zzlz(zzke.zzd(), zzke.zzc(), (zzly) null);
        if (this.zzb.containsKey(zzlz)) {
            zzke zzke2 = (zzke) this.zzb.get(zzlz);
            if (!zzke2.equals(zzke) || !zzke.equals(zzke2)) {
                throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzlz.toString()));
            }
        } else {
            this.zzb.put(zzlz, zzke);
        }
        return this;
    }

    public final zzlx zzb(zzki zzki) throws GeneralSecurityException {
        zzmb zzmb = new zzmb(zzki.zzb(), zzki.zzc(), (zzma) null);
        if (this.zza.containsKey(zzmb)) {
            zzki zzki2 = (zzki) this.zza.get(zzmb);
            if (!zzki2.equals(zzki) || !zzki.equals(zzki2)) {
                throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzmb.toString()));
            }
        } else {
            this.zza.put(zzmb, zzki);
        }
        return this;
    }

    public final zzlx zzc(zzlc zzlc) throws GeneralSecurityException {
        zzlz zzlz = new zzlz(zzlc.zzd(), zzlc.zzc(), (zzly) null);
        if (this.zzd.containsKey(zzlz)) {
            zzlc zzlc2 = (zzlc) this.zzd.get(zzlz);
            if (!zzlc2.equals(zzlc) || !zzlc.equals(zzlc2)) {
                throw new GeneralSecurityException("Attempt to register non-equal parser for already existing object of type: ".concat(zzlz.toString()));
            }
        } else {
            this.zzd.put(zzlz, zzlc);
        }
        return this;
    }

    public final zzlx zzd(zzlg zzlg) throws GeneralSecurityException {
        zzmb zzmb = new zzmb(zzlg.zzc(), zzlg.zzd(), (zzma) null);
        if (this.zzc.containsKey(zzmb)) {
            zzlg zzlg2 = (zzlg) this.zzc.get(zzmb);
            if (!zzlg2.equals(zzlg) || !zzlg.equals(zzlg2)) {
                throw new GeneralSecurityException("Attempt to register non-equal serializer for already existing object of type: ".concat(zzmb.toString()));
            }
        } else {
            this.zzc.put(zzmb, zzlg);
        }
        return this;
    }

    public zzlx(zzmd zzmd) {
        this.zza = new HashMap(zzmd.zza);
        this.zzb = new HashMap(zzmd.zzb);
        this.zzc = new HashMap(zzmd.zzc);
        this.zzd = new HashMap(zzmd.zzd);
    }
}

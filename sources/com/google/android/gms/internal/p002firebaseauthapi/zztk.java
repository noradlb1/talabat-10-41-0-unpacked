package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zztk  reason: invalid package */
public final class zztk extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zztk zzb;
    /* access modifiers changed from: private */
    public int zzd;
    private zzahf zze = zzaha.zzA();

    static {
        zztk zztk = new zztk();
        zzb = zztk;
        zzaha.zzH(zztk.class, zztk);
    }

    private zztk() {
    }

    public static zzth zzc() {
        return (zzth) zzb.zzt();
    }

    public static zztk zzf(InputStream inputStream, zzagn zzagn) throws IOException {
        return (zztk) zzaha.zzy(zzb, inputStream, zzagn);
    }

    public static zztk zzg(byte[] bArr, zzagn zzagn) throws zzahi {
        return (zztk) zzaha.zzz(zzb, bArr, zzagn);
    }

    public static /* synthetic */ void zzk(zztk zztk, zztj zztj) {
        zztj.getClass();
        zzahf zzahf = zztk.zze;
        if (!zzahf.zzc()) {
            zztk.zze = zzaha.zzB(zzahf);
        }
        zztk.zze.add(zztj);
    }

    public final int zza() {
        return this.zze.size();
    }

    public final int zzb() {
        return this.zzd;
    }

    public final zztj zzd(int i11) {
        return (zztj) this.zze.get(i11);
    }

    public final List zzh() {
        return this.zze;
    }

    public final Object zzj(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzaha.zzE(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzd", "zze", zztj.class});
        } else if (i12 == 3) {
            return new zztk();
        } else {
            if (i12 == 4) {
                return new zzth((zztg) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}

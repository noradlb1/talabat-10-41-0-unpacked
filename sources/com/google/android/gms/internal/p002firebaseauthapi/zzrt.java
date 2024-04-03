package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrt  reason: invalid package */
public final class zzrt extends zzaha implements zzaig {
    /* access modifiers changed from: private */
    public static final zzrt zzb;
    private int zzd;
    /* access modifiers changed from: private */
    public zzafv zze = zzafv.zzb;
    private zztp zzf;

    static {
        zzrt zzrt = new zzrt();
        zzb = zzrt;
        zzaha.zzH(zzrt.class, zzrt);
    }

    private zzrt() {
    }

    public static zzrs zza() {
        return (zzrs) zzb.zzt();
    }

    public static zzrt zzc(InputStream inputStream, zzagn zzagn) throws IOException {
        return (zzrt) zzaha.zzy(zzb, inputStream, zzagn);
    }

    public static /* synthetic */ void zzf(zzrt zzrt, zztp zztp) {
        zztp.getClass();
        zzrt.zzf = zztp;
        zzrt.zzd |= 1;
    }

    public final zzafv zzd() {
        return this.zze;
    }

    public final Object zzj(int i11, Object obj, Object obj2) {
        int i12 = i11 - 1;
        if (i12 == 0) {
            return (byte) 1;
        }
        if (i12 == 2) {
            return zzaha.zzE(zzb, "\u0000\u0002\u0000\u0001\u0002\u0003\u0002\u0000\u0000\u0000\u0002\n\u0003ဉ\u0000", new Object[]{"zzd", "zze", "zzf"});
        } else if (i12 == 3) {
            return new zzrt();
        } else {
            if (i12 == 4) {
                return new zzrs((zzrr) null);
            }
            if (i12 != 5) {
                return null;
            }
            return zzb;
        }
    }
}

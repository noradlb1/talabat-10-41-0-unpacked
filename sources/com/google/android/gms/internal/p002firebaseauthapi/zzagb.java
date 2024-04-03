package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagb  reason: invalid package */
public abstract class zzagb {
    public static final /* synthetic */ int zzd = 0;
    private static volatile int zze = 100;
    int zza;
    final int zzb = zze;
    zzagc zzc;

    public /* synthetic */ zzagb(zzaga zzaga) {
    }

    public static int zzF(int i11) {
        return (i11 >>> 1) ^ (-(i11 & 1));
    }

    public static long zzG(long j11) {
        return (j11 >>> 1) ^ (-(1 & j11));
    }

    public static zzagb zzH(byte[] bArr, int i11, int i12, boolean z11) {
        zzafx zzafx = new zzafx(bArr, 0, i12, z11, (zzafw) null);
        try {
            zzafx.zze(i12);
            return zzafx;
        } catch (zzahi e11) {
            throw new IllegalArgumentException(e11);
        }
    }

    public abstract void zzA(int i11);

    public abstract boolean zzC() throws IOException;

    public abstract boolean zzD() throws IOException;

    public abstract boolean zzE(int i11) throws IOException;

    public abstract double zzb() throws IOException;

    public abstract float zzc() throws IOException;

    public abstract int zzd();

    public abstract int zze(int i11) throws zzahi;

    public abstract int zzf() throws IOException;

    public abstract int zzg() throws IOException;

    public abstract int zzh() throws IOException;

    public abstract int zzk() throws IOException;

    public abstract int zzl() throws IOException;

    public abstract int zzm() throws IOException;

    public abstract int zzn() throws IOException;

    public abstract long zzo() throws IOException;

    public abstract long zzp() throws IOException;

    public abstract long zzt() throws IOException;

    public abstract long zzu() throws IOException;

    public abstract long zzv() throws IOException;

    public abstract zzafv zzw() throws IOException;

    public abstract String zzx() throws IOException;

    public abstract String zzy() throws IOException;

    public abstract void zzz(int i11) throws zzahi;
}

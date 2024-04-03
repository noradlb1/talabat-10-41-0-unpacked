package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagi  reason: invalid package */
public abstract class zzagi extends zzafl {
    private static final Logger zza = Logger.getLogger(zzagi.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzb = zzajv.zzx();
    public static final /* synthetic */ int zzf = 0;
    zzagj zze;

    private zzagi() {
    }

    public /* synthetic */ zzagi(zzagh zzagh) {
    }

    public static int zzA(int i11) {
        if ((i11 & -128) == 0) {
            return 1;
        }
        if ((i11 & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i11) == 0) {
            return 3;
        }
        return (i11 & -268435456) == 0 ? 4 : 5;
    }

    public static int zzB(long j11) {
        int i11;
        if ((-128 & j11) == 0) {
            return 1;
        }
        if (j11 < 0) {
            return 10;
        }
        if ((-34359738368L & j11) != 0) {
            j11 >>>= 28;
            i11 = 6;
        } else {
            i11 = 2;
        }
        if ((-2097152 & j11) != 0) {
            j11 >>>= 14;
            i11 += 2;
        }
        return (j11 & -16384) != 0 ? i11 + 1 : i11;
    }

    public static zzagi zzC(byte[] bArr, int i11, int i12) {
        return new zzage(bArr, 0, i12);
    }

    @Deprecated
    public static int zzw(int i11, zzaif zzaif, zzair zzair) {
        int zzn = ((zzaff) zzaif).zzn(zzair);
        int zzA = zzA(i11 << 3);
        return zzA + zzA + zzn;
    }

    public static int zzx(int i11) {
        if (i11 >= 0) {
            return zzA(i11);
        }
        return 10;
    }

    public static int zzy(zzaif zzaif, zzair zzair) {
        int zzn = ((zzaff) zzaif).zzn(zzair);
        return zzA(zzn) + zzn;
    }

    public static int zzz(String str) {
        int i11;
        try {
            i11 = zzaka.zzc(str);
        } catch (zzajz unused) {
            i11 = str.getBytes(zzahg.zzb).length;
        }
        return zzA(i11) + i11;
    }

    public final void zzD() {
        if (zzb() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzE(String str, zzajz zzajz) throws IOException {
        zza.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzajz);
        byte[] bytes = str.getBytes(zzahg.zzb);
        try {
            int length = bytes.length;
            zzs(length);
            zza(bytes, 0, length);
        } catch (IndexOutOfBoundsException e11) {
            throw new zzagf(e11);
        }
    }

    public abstract void zzI() throws IOException;

    public abstract void zzJ(byte b11) throws IOException;

    public abstract void zzK(int i11, boolean z11) throws IOException;

    public abstract void zzL(int i11, zzafv zzafv) throws IOException;

    public abstract void zza(byte[] bArr, int i11, int i12) throws IOException;

    public abstract int zzb();

    public abstract void zzh(int i11, int i12) throws IOException;

    public abstract void zzi(int i11) throws IOException;

    public abstract void zzj(int i11, long j11) throws IOException;

    public abstract void zzk(long j11) throws IOException;

    public abstract void zzl(int i11, int i12) throws IOException;

    public abstract void zzm(int i11) throws IOException;

    public abstract void zzn(int i11, zzaif zzaif, zzair zzair) throws IOException;

    public abstract void zzo(int i11, String str) throws IOException;

    public abstract void zzq(int i11, int i12) throws IOException;

    public abstract void zzr(int i11, int i12) throws IOException;

    public abstract void zzs(int i11) throws IOException;

    public abstract void zzt(int i11, long j11) throws IOException;

    public abstract void zzu(long j11) throws IOException;
}

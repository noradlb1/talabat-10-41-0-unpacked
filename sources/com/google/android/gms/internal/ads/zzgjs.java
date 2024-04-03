package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzgjs extends zzgit {
    private static final Logger zzb = Logger.getLogger(zzgjs.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzc = zzgnp.zzA();
    zzgjt zza;

    private zzgjs() {
    }

    public /* synthetic */ zzgjs(zzgjr zzgjr) {
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
            i11 += 2;
            j11 >>>= 14;
        }
        return (j11 & -16384) != 0 ? i11 + 1 : i11;
    }

    public static zzgjs zzC(byte[] bArr) {
        return new zzgjp(bArr, 0, bArr.length);
    }

    public static int zzt(zzgjf zzgjf) {
        int zzd = zzgjf.zzd();
        return zzA(zzd) + zzd;
    }

    @Deprecated
    public static int zzu(int i11, zzglv zzglv, zzgmo zzgmo) {
        int zzA = zzA(i11 << 3);
        int i12 = zzA + zzA;
        zzgin zzgin = (zzgin) zzglv;
        int zzan = zzgin.zzan();
        if (zzan == -1) {
            zzan = zzgmo.zza(zzgin);
            zzgin.zzaq(zzan);
        }
        return i12 + zzan;
    }

    public static int zzv(int i11) {
        if (i11 >= 0) {
            return zzA(i11);
        }
        return 10;
    }

    public static int zzw(zzglb zzglb) {
        int zza2 = zzglb.zza();
        return zzA(zza2) + zza2;
    }

    public static int zzx(zzglv zzglv, zzgmo zzgmo) {
        zzgin zzgin = (zzgin) zzglv;
        int zzan = zzgin.zzan();
        if (zzan == -1) {
            zzan = zzgmo.zza(zzgin);
            zzgin.zzaq(zzan);
        }
        return zzA(zzan) + zzan;
    }

    public static int zzy(String str) {
        int i11;
        try {
            i11 = zzgnu.zze(str);
        } catch (zzgnt unused) {
            i11 = str.getBytes(zzgkv.zzb).length;
        }
        return zzA(i11) + i11;
    }

    public static int zzz(int i11) {
        return zzA(i11 << 3);
    }

    public final void zzD() {
        if (zza() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzE(String str, zzgnt zzgnt) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzgnt);
        byte[] bytes = str.getBytes(zzgkv.zzb);
        try {
            int length = bytes.length;
            zzq(length);
            zzl(bytes, 0, length);
        } catch (IndexOutOfBoundsException e11) {
            throw new zzgjq(e11);
        } catch (zzgjq e12) {
            throw e12;
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b11) throws IOException;

    public abstract void zzd(int i11, boolean z11) throws IOException;

    public abstract void zze(int i11, zzgjf zzgjf) throws IOException;

    public abstract void zzf(int i11, int i12) throws IOException;

    public abstract void zzg(int i11) throws IOException;

    public abstract void zzh(int i11, long j11) throws IOException;

    public abstract void zzi(long j11) throws IOException;

    public abstract void zzj(int i11, int i12) throws IOException;

    public abstract void zzk(int i11) throws IOException;

    public abstract void zzl(byte[] bArr, int i11, int i12) throws IOException;

    public abstract void zzm(int i11, String str) throws IOException;

    public abstract void zzo(int i11, int i12) throws IOException;

    public abstract void zzp(int i11, int i12) throws IOException;

    public abstract void zzq(int i11) throws IOException;

    public abstract void zzr(int i11, long j11) throws IOException;

    public abstract void zzs(long j11) throws IOException;
}

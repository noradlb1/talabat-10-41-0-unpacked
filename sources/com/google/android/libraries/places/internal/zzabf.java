package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class zzabf extends zzaam {
    private static final Logger zzb = Logger.getLogger(zzabf.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzc = zzael.zzx();
    zzabg zza;

    private zzabf() {
    }

    public /* synthetic */ zzabf(zzabe zzabe) {
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

    public static zzabf zzC(byte[] bArr) {
        return new zzabc(bArr, 0, bArr.length);
    }

    public static int zzt(zzaax zzaax) {
        int zzd = zzaax.zzd();
        return zzA(zzd) + zzd;
    }

    @Deprecated
    public static int zzu(int i11, zzacz zzacz, zzadk zzadk) {
        int zzA = zzA(i11 << 3);
        int i12 = zzA + zzA;
        zzaaj zzaaj = (zzaaj) zzacz;
        int zzr = zzaaj.zzr();
        if (zzr == -1) {
            zzr = zzadk.zza(zzaaj);
            zzaaj.zzu(zzr);
        }
        return i12 + zzr;
    }

    public static int zzv(int i11) {
        if (i11 >= 0) {
            return zzA(i11);
        }
        return 10;
    }

    public static int zzw(zzacf zzacf) {
        int zza2 = zzacf.zza();
        return zzA(zza2) + zza2;
    }

    public static int zzx(zzacz zzacz, zzadk zzadk) {
        zzaaj zzaaj = (zzaaj) zzacz;
        int zzr = zzaaj.zzr();
        if (zzr == -1) {
            zzr = zzadk.zza(zzaaj);
            zzaaj.zzu(zzr);
        }
        return zzA(zzr) + zzr;
    }

    public static int zzy(String str) {
        int i11;
        try {
            i11 = zzaep.zzc(str);
        } catch (zzaeo unused) {
            i11 = str.getBytes(zzaca.zza).length;
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

    public final void zzE(String str, zzaeo zzaeo) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzaeo);
        byte[] bytes = str.getBytes(zzaca.zza);
        try {
            int length = bytes.length;
            zzq(length);
            zzl(bytes, 0, length);
        } catch (IndexOutOfBoundsException e11) {
            throw new zzabd(e11);
        } catch (zzabd e12) {
            throw e12;
        }
    }

    public abstract int zza();

    public abstract void zzb(byte b11) throws IOException;

    public abstract void zzd(int i11, boolean z11) throws IOException;

    public abstract void zze(int i11, zzaax zzaax) throws IOException;

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

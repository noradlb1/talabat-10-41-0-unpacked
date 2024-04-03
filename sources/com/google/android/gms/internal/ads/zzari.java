package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;

public final class zzari {
    private static final byte[] zza = new byte[4096];
    private final zzavw zzb;
    private final long zzc;
    private long zzd;
    private byte[] zze = new byte[65536];
    private int zzf;
    private int zzg;

    public zzari(zzavw zzavw, long j11, long j12) {
        this.zzb = zzavw;
        this.zzd = j11;
        this.zzc = j12;
    }

    private final int zzj(byte[] bArr, int i11, int i12, int i13, boolean z11) throws InterruptedException, IOException {
        if (!Thread.interrupted()) {
            int zza2 = this.zzb.zza(bArr, i11 + i13, i12 - i13);
            if (zza2 != -1) {
                return i13 + zza2;
            }
            if (i13 == 0 && z11) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedException();
    }

    private final int zzk(byte[] bArr, int i11, int i12) {
        int i13 = this.zzg;
        if (i13 == 0) {
            return 0;
        }
        int min = Math.min(i13, i12);
        System.arraycopy(this.zze, 0, bArr, i11, min);
        zzn(min);
        return min;
    }

    private final int zzl(int i11) {
        int min = Math.min(this.zzg, i11);
        zzn(min);
        return min;
    }

    private final void zzm(int i11) {
        if (i11 != -1) {
            this.zzd += (long) i11;
        }
    }

    private final void zzn(int i11) {
        byte[] bArr;
        int i12 = this.zzg - i11;
        this.zzg = i12;
        this.zzf = 0;
        byte[] bArr2 = this.zze;
        if (i12 < bArr2.length - 524288) {
            bArr = new byte[(65536 + i12)];
        } else {
            bArr = bArr2;
        }
        System.arraycopy(bArr2, i11, bArr, 0, i12);
        this.zze = bArr;
    }

    public final int zza(byte[] bArr, int i11, int i12) throws IOException, InterruptedException {
        int zzk = zzk(bArr, i11, i12);
        if (zzk == 0) {
            zzk = zzj(bArr, i11, i12, 0, true);
        }
        zzm(zzk);
        return zzk;
    }

    public final int zzb(int i11) throws IOException, InterruptedException {
        int zzl = zzl(i11);
        if (zzl == 0) {
            zzl = zzj(zza, 0, Math.min(i11, 4096), 0, true);
        }
        zzm(zzl);
        return zzl;
    }

    public final long zzc() {
        return this.zzc;
    }

    public final long zzd() {
        return this.zzd;
    }

    public final void zze() {
        this.zzf = 0;
    }

    public final boolean zzf(int i11, boolean z11) throws IOException, InterruptedException {
        int i12 = this.zzf + i11;
        int length = this.zze.length;
        if (i12 > length) {
            this.zze = Arrays.copyOf(this.zze, zzaxb.zze(length + length, 65536 + i12, i12 + 524288));
        }
        int min = Math.min(this.zzg - this.zzf, i11);
        while (min < i11) {
            min = zzj(this.zze, this.zzf, i11, min, false);
            if (min == -1) {
                return false;
            }
        }
        int i13 = this.zzf + i11;
        this.zzf = i13;
        this.zzg = Math.max(this.zzg, i13);
        return true;
    }

    public final boolean zzg(byte[] bArr, int i11, int i12, boolean z11) throws IOException, InterruptedException {
        if (!zzf(i12, false)) {
            return false;
        }
        System.arraycopy(this.zze, this.zzf - i12, bArr, i11, i12);
        return true;
    }

    public final boolean zzh(byte[] bArr, int i11, int i12, boolean z11) throws IOException, InterruptedException {
        int zzk = zzk(bArr, i11, i12);
        while (zzk < i12 && zzk != -1) {
            zzk = zzj(bArr, i11, i12, zzk, z11);
        }
        zzm(zzk);
        if (zzk != -1) {
            return true;
        }
        return false;
    }

    public final boolean zzi(int i11, boolean z11) throws IOException, InterruptedException {
        int zzl = zzl(i11);
        while (zzl < i11 && zzl != -1) {
            zzl = zzj(zza, -zzl, Math.min(i11, zzl + 4096), zzl, false);
        }
        zzm(zzl);
        if (zzl != -1) {
            return true;
        }
        return false;
    }
}

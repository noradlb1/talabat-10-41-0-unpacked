package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;

public final class zzwk implements zzwq {
    private final byte[] zza = new byte[4096];
    private final zzdg zzb;
    private final long zzc;
    private long zzd;
    private byte[] zze = new byte[65536];
    private int zzf;
    private int zzg;

    public zzwk(zzdg zzdg, long j11, long j12) {
        this.zzb = zzdg;
        this.zzd = j11;
        this.zzc = j12;
    }

    private final int zzp(byte[] bArr, int i11, int i12) {
        int i13 = this.zzg;
        if (i13 == 0) {
            return 0;
        }
        int min = Math.min(i13, i12);
        System.arraycopy(this.zze, 0, bArr, i11, min);
        zzu(min);
        return min;
    }

    private final int zzq(byte[] bArr, int i11, int i12, int i13, boolean z11) throws IOException {
        if (!Thread.interrupted()) {
            int zzg2 = this.zzb.zzg(bArr, i11 + i13, i12 - i13);
            if (zzg2 != -1) {
                return i13 + zzg2;
            }
            if (i13 == 0 && z11) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedIOException();
    }

    private final int zzr(int i11) {
        int min = Math.min(this.zzg, i11);
        zzu(min);
        return min;
    }

    private final void zzs(int i11) {
        if (i11 != -1) {
            this.zzd += (long) i11;
        }
    }

    private final void zzt(int i11) {
        int i12 = this.zzf + i11;
        int length = this.zze.length;
        if (i12 > length) {
            this.zze = Arrays.copyOf(this.zze, zzfn.zzf(length + length, 65536 + i12, i12 + 524288));
        }
    }

    private final void zzu(int i11) {
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

    public final int zza(byte[] bArr, int i11, int i12) throws IOException {
        int i13;
        zzt(i12);
        int i14 = this.zzg;
        int i15 = this.zzf;
        int i16 = i14 - i15;
        if (i16 == 0) {
            i13 = zzq(this.zze, i15, i12, 0, true);
            if (i13 == -1) {
                return -1;
            }
            this.zzg += i13;
        } else {
            i13 = Math.min(i12, i16);
        }
        System.arraycopy(this.zze, this.zzf, bArr, i11, i13);
        this.zzf += i13;
        return i13;
    }

    public final int zzb(int i11) throws IOException {
        int zzr = zzr(1);
        if (zzr == 0) {
            zzr = zzq(this.zza, 0, Math.min(1, 4096), 0, true);
        }
        zzs(zzr);
        return zzr;
    }

    public final long zzc() {
        return this.zzc;
    }

    public final long zzd() {
        return this.zzd + ((long) this.zzf);
    }

    public final long zze() {
        return this.zzd;
    }

    public final void zzf(int i11) throws IOException {
        zzl(i11, false);
    }

    public final int zzg(byte[] bArr, int i11, int i12) throws IOException {
        int zzp = zzp(bArr, i11, i12);
        if (zzp == 0) {
            zzp = zzq(bArr, i11, i12, 0, true);
        }
        zzs(zzp);
        return zzp;
    }

    public final void zzh(byte[] bArr, int i11, int i12) throws IOException {
        zzm(bArr, i11, i12, false);
    }

    public final void zzi(byte[] bArr, int i11, int i12) throws IOException {
        zzn(bArr, i11, i12, false);
    }

    public final void zzj() {
        this.zzf = 0;
    }

    public final void zzk(int i11) throws IOException {
        zzo(i11, false);
    }

    public final boolean zzl(int i11, boolean z11) throws IOException {
        zzt(i11);
        int i12 = this.zzg - this.zzf;
        while (i12 < i11) {
            i12 = zzq(this.zze, this.zzf, i11, i12, z11);
            if (i12 == -1) {
                return false;
            }
            this.zzg = this.zzf + i12;
        }
        this.zzf += i11;
        return true;
    }

    public final boolean zzm(byte[] bArr, int i11, int i12, boolean z11) throws IOException {
        if (!zzl(i12, z11)) {
            return false;
        }
        System.arraycopy(this.zze, this.zzf - i12, bArr, i11, i12);
        return true;
    }

    public final boolean zzn(byte[] bArr, int i11, int i12, boolean z11) throws IOException {
        int zzp = zzp(bArr, i11, i12);
        while (zzp < i12 && zzp != -1) {
            zzp = zzq(bArr, i11, i12, zzp, z11);
        }
        zzs(zzp);
        if (zzp != -1) {
            return true;
        }
        return false;
    }

    public final boolean zzo(int i11, boolean z11) throws IOException {
        int zzr = zzr(i11);
        while (zzr < i11 && zzr != -1) {
            zzr = zzq(this.zza, -zzr, Math.min(i11, zzr + 4096), zzr, false);
        }
        zzs(zzr);
        if (zzr != -1) {
            return true;
        }
        return false;
    }
}

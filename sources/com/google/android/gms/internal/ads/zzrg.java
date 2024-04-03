package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

final class zzrg {
    private final zzfd zza = new zzfd(32);
    private zzrf zzb;
    private zzrf zzc;
    private zzrf zzd;
    private long zze;
    private final zztk zzf;

    public zzrg(zztk zztk, byte[] bArr) {
        this.zzf = zztk;
        zzrf zzrf = new zzrf(0, 65536);
        this.zzb = zzrf;
        this.zzc = zzrf;
        this.zzd = zzrf;
    }

    private final int zzi(int i11) {
        zzrf zzrf = this.zzd;
        if (!zzrf.zzc) {
            zzsx zzb2 = this.zzf.zzb();
            zzrf zzrf2 = new zzrf(this.zzd.zzb, 65536);
            zzrf.zzd = zzb2;
            zzrf.zze = zzrf2;
            zzrf.zzc = true;
        }
        return Math.min(i11, (int) (this.zzd.zzb - this.zze));
    }

    private static zzrf zzj(zzrf zzrf, long j11) {
        while (j11 >= zzrf.zzb) {
            zzrf = zzrf.zze;
        }
        return zzrf;
    }

    private static zzrf zzk(zzrf zzrf, long j11, ByteBuffer byteBuffer, int i11) {
        zzrf zzj = zzj(zzrf, j11);
        while (i11 > 0) {
            int min = Math.min(i11, (int) (zzj.zzb - j11));
            byteBuffer.put(zzj.zzd.zza, zzj.zza(j11), min);
            i11 -= min;
            j11 += (long) min;
            if (j11 == zzj.zzb) {
                zzj = zzj.zze;
            }
        }
        return zzj;
    }

    private static zzrf zzl(zzrf zzrf, long j11, byte[] bArr, int i11) {
        zzrf zzj = zzj(zzrf, j11);
        int i12 = i11;
        while (i12 > 0) {
            int min = Math.min(i12, (int) (zzj.zzb - j11));
            System.arraycopy(zzj.zzd.zza, zzj.zza(j11), bArr, i11 - i12, min);
            i12 -= min;
            j11 += (long) min;
            if (j11 == zzj.zzb) {
                zzj = zzj.zze;
            }
        }
        return zzj;
    }

    private static zzrf zzm(zzrf zzrf, zzda zzda, zzri zzri, zzfd zzfd) {
        zzrf zzrf2;
        zzda zzda2 = zzda;
        zzri zzri2 = zzri;
        zzfd zzfd2 = zzfd;
        if (zzda.zzk()) {
            long j11 = zzri2.zzb;
            int i11 = 1;
            zzfd2.zzC(1);
            zzrf zzl = zzl(zzrf, j11, zzfd.zzH(), 1);
            long j12 = j11 + 1;
            byte b11 = zzfd.zzH()[0];
            byte b12 = b11 & 128;
            byte b13 = b11 & Byte.MAX_VALUE;
            zzcx zzcx = zzda2.zza;
            byte[] bArr = zzcx.zza;
            if (bArr == null) {
                zzcx.zza = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            zzrf2 = zzl(zzl, j12, zzcx.zza, b13);
            long j13 = j12 + ((long) b13);
            if (b12 != 0) {
                zzfd2.zzC(2);
                zzrf2 = zzl(zzrf2, j13, zzfd.zzH(), 2);
                j13 += 2;
                i11 = zzfd.zzo();
            }
            int i12 = i11;
            int[] iArr = zzcx.zzd;
            if (iArr == null || iArr.length < i12) {
                iArr = new int[i12];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = zzcx.zze;
            if (iArr3 == null || iArr3.length < i12) {
                iArr3 = new int[i12];
            }
            int[] iArr4 = iArr3;
            if (b12 != 0) {
                int i13 = i12 * 6;
                zzfd2.zzC(i13);
                zzrf2 = zzl(zzrf2, j13, zzfd.zzH(), i13);
                j13 += (long) i13;
                zzfd2.zzF(0);
                for (int i14 = 0; i14 < i12; i14++) {
                    iArr2[i14] = zzfd.zzo();
                    iArr4[i14] = zzfd.zzn();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = zzri2.zza - ((int) (j13 - zzri2.zzb));
            }
            zzxs zzxs = zzri2.zzc;
            int i15 = zzfn.zza;
            zzcx.zzc(i12, iArr2, iArr4, zzxs.zzb, zzcx.zza, zzxs.zza, zzxs.zzc, zzxs.zzd);
            long j14 = zzri2.zzb;
            int i16 = (int) (j13 - j14);
            zzri2.zzb = j14 + ((long) i16);
            zzri2.zza -= i16;
        } else {
            zzrf2 = zzrf;
        }
        if (zzda.zze()) {
            zzfd2.zzC(4);
            zzrf zzl2 = zzl(zzrf2, zzri2.zzb, zzfd.zzH(), 4);
            int zzn = zzfd.zzn();
            zzri2.zzb += 4;
            zzri2.zza -= 4;
            zzda2.zzi(zzn);
            zzrf zzk = zzk(zzl2, zzri2.zzb, zzda2.zzb, zzn);
            zzri2.zzb += (long) zzn;
            int i17 = zzri2.zza - zzn;
            zzri2.zza = i17;
            ByteBuffer byteBuffer = zzda2.zze;
            if (byteBuffer == null || byteBuffer.capacity() < i17) {
                zzda2.zze = ByteBuffer.allocate(i17);
            } else {
                zzda2.zze.clear();
            }
            return zzk(zzk, zzri2.zzb, zzda2.zze, zzri2.zza);
        }
        zzda2.zzi(zzri2.zza);
        return zzk(zzrf2, zzri2.zzb, zzda2.zzb, zzri2.zza);
    }

    private final void zzn(int i11) {
        long j11 = this.zze + ((long) i11);
        this.zze = j11;
        zzrf zzrf = this.zzd;
        if (j11 == zzrf.zzb) {
            this.zzd = zzrf.zze;
        }
    }

    public final int zza(zzdg zzdg, int i11, boolean z11) throws IOException {
        int zzi = zzi(i11);
        zzrf zzrf = this.zzd;
        int zzg = zzdg.zzg(zzrf.zzd.zza, zzrf.zza(this.zze), zzi);
        if (zzg != -1) {
            zzn(zzg);
            return zzg;
        } else if (z11) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    public final long zzb() {
        return this.zze;
    }

    public final void zzc(long j11) {
        zzrf zzrf;
        if (j11 != -1) {
            while (true) {
                zzrf = this.zzb;
                if (j11 < zzrf.zzb) {
                    break;
                }
                this.zzf.zzc(zzrf.zzd);
                this.zzb = this.zzb.zzb();
            }
            if (this.zzc.zza < zzrf.zza) {
                this.zzc = zzrf;
            }
        }
    }

    public final void zzd(zzda zzda, zzri zzri) {
        zzm(this.zzc, zzda, zzri, this.zza);
    }

    public final void zze(zzda zzda, zzri zzri) {
        this.zzc = zzm(this.zzc, zzda, zzri, this.zza);
    }

    public final void zzf() {
        zzrf zzrf = this.zzb;
        if (zzrf.zzc) {
            zzrf zzrf2 = this.zzd;
            int i11 = (zzrf2.zzc ? 1 : 0) + (((int) (zzrf2.zza - zzrf.zza)) / 65536);
            zzsx[] zzsxArr = new zzsx[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                zzsxArr[i12] = zzrf.zzd;
                zzrf = zzrf.zzb();
            }
            this.zzf.zzd(zzsxArr);
        }
        zzrf zzrf3 = new zzrf(0, 65536);
        this.zzb = zzrf3;
        this.zzc = zzrf3;
        this.zzd = zzrf3;
        this.zze = 0;
        this.zzf.zzg();
    }

    public final void zzg() {
        this.zzc = this.zzb;
    }

    public final void zzh(zzfd zzfd, int i11) {
        while (i11 > 0) {
            int zzi = zzi(i11);
            zzrf zzrf = this.zzd;
            zzfd.zzB(zzrf.zzd.zza, zzrf.zza(this.zze), zzi);
            i11 -= zzi;
            zzn(zzi);
        }
    }
}

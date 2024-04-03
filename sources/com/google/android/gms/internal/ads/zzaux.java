package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzaux implements zzars {
    private final zzauu zza = new zzauu();
    private final zzaut zzb = new zzaut();
    private final zzawu zzc = new zzawu(32);
    private final AtomicInteger zzd = new AtomicInteger();
    private zzauv zze;
    private zzauv zzf;
    private zzapg zzg;
    private zzapg zzh;
    private long zzi;
    private int zzj = 65536;
    private zzauw zzk;
    private final zzavz zzl;

    public zzaux(zzavz zzavz, byte[] bArr) {
        this.zzl = zzavz;
        zzauv zzauv = new zzauv(0, 65536);
        this.zze = zzauv;
        this.zzf = zzauv;
    }

    private final int zzo(int i11) {
        if (this.zzj == 65536) {
            this.zzj = 0;
            zzauv zzauv = this.zzf;
            if (zzauv.zzc) {
                this.zzf = zzauv.zze;
            }
            zzauv zzauv2 = this.zzf;
            zzavt zzb2 = this.zzl.zzb();
            zzauv zzauv3 = new zzauv(this.zzf.zzb, 65536);
            zzauv2.zzd = zzb2;
            zzauv2.zze = zzauv3;
            zzauv2.zzc = true;
        }
        return Math.min(i11, 65536 - this.zzj);
    }

    private final void zzp() {
        this.zza.zzg();
        zzauv zzauv = this.zze;
        if (zzauv.zzc) {
            zzauv zzauv2 = this.zzf;
            int i11 = (zzauv2.zzc ? 1 : 0) + (((int) (zzauv2.zza - zzauv.zza)) / 65536);
            zzavt[] zzavtArr = new zzavt[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                zzavtArr[i12] = zzauv.zzd;
                zzauv.zzd = null;
                zzauv = zzauv.zze;
            }
            this.zzl.zzd(zzavtArr);
        }
        zzauv zzauv3 = new zzauv(0, 65536);
        this.zze = zzauv3;
        this.zzf = zzauv3;
        this.zzi = 0;
        this.zzj = 65536;
        this.zzl.zzg();
    }

    private final void zzq(long j11) {
        while (true) {
            zzauv zzauv = this.zze;
            if (j11 >= zzauv.zzb) {
                this.zzl.zzc(zzauv.zzd);
                zzauv zzauv2 = this.zze;
                zzauv2.zzd = null;
                this.zze = zzauv2.zze;
            } else {
                return;
            }
        }
    }

    private final void zzr() {
        if (!this.zzd.compareAndSet(1, 0)) {
            zzp();
        }
    }

    private final void zzs(long j11, byte[] bArr, int i11) {
        zzq(j11);
        int i12 = 0;
        while (i12 < i11) {
            int i13 = (int) (j11 - this.zze.zza);
            int min = Math.min(i11 - i12, 65536 - i13);
            zzavt zzavt = this.zze.zzd;
            System.arraycopy(zzavt.zza, i13, bArr, i12, min);
            j11 += (long) min;
            i12 += min;
            if (j11 == this.zze.zzb) {
                this.zzl.zzc(zzavt);
                zzauv zzauv = this.zze;
                zzauv.zzd = null;
                this.zze = zzauv.zze;
            }
        }
    }

    private final boolean zzt() {
        return this.zzd.compareAndSet(0, 1);
    }

    public final void zza(zzapg zzapg) {
        zzapg zzapg2;
        if (zzapg == null) {
            zzapg2 = null;
        } else {
            zzapg2 = zzapg;
        }
        boolean zzk2 = this.zza.zzk(zzapg2);
        this.zzh = zzapg;
        zzauw zzauw = this.zzk;
        if (zzauw != null && zzk2) {
            zzauw.zzv(zzapg2);
        }
    }

    public final void zzb(zzawu zzawu, int i11) {
        if (zzt()) {
            while (i11 > 0) {
                int zzo = zzo(i11);
                zzawu.zzq(this.zzf.zzd.zza, this.zzj, zzo);
                this.zzj += zzo;
                this.zzi += (long) zzo;
                i11 -= zzo;
            }
            zzr();
            return;
        }
        zzawu.zzw(i11);
    }

    public final void zzc(long j11, int i11, int i12, int i13, zzarr zzarr) {
        if (zzt()) {
            try {
                this.zza.zzh(j11, i11, this.zzi - ((long) i12), i12, zzarr);
            } finally {
                zzr();
            }
        } else {
            long j12 = j11;
            this.zza.zzi(j11);
        }
    }

    public final int zzd(zzari zzari, int i11, boolean z11) throws IOException, InterruptedException {
        if (!zzt()) {
            int zzb2 = zzari.zzb(i11);
            if (zzb2 != -1) {
                return zzb2;
            }
            throw new EOFException();
        }
        try {
            int zza2 = zzari.zza(this.zzf.zzd.zza, this.zzj, zzo(i11));
            if (zza2 != -1) {
                this.zzj += zza2;
                this.zzi += (long) zza2;
                return zza2;
            }
            throw new EOFException();
        } finally {
            zzr();
        }
    }

    public final int zze() {
        return this.zza.zza();
    }

    public final int zzf(zzaph zzaph, zzarb zzarb, boolean z11, boolean z12, long j11) {
        zzarb zzarb2 = zzarb;
        int zzb2 = this.zza.zzb(zzaph, zzarb, z11, z12, this.zzg, this.zzb);
        if (zzb2 == -5) {
            this.zzg = zzaph.zza;
            return -5;
        } else if (zzb2 != -4) {
            return -3;
        } else {
            if (!zzarb.zzf()) {
                if (zzarb2.zzc < j11) {
                    zzarb2.zza(Integer.MIN_VALUE);
                }
                if (zzarb.zzi()) {
                    zzaut zzaut = this.zzb;
                    long j12 = zzaut.zzb;
                    int i11 = 1;
                    this.zzc.zzs(1);
                    zzs(j12, this.zzc.zza, 1);
                    long j13 = j12 + 1;
                    byte b11 = this.zzc.zza[0];
                    byte b12 = b11 & 128;
                    byte b13 = b11 & Byte.MAX_VALUE;
                    zzaqz zzaqz = zzarb2.zza;
                    if (zzaqz.zza == null) {
                        zzaqz.zza = new byte[16];
                    }
                    zzs(j13, zzaqz.zza, b13);
                    long j14 = j13 + ((long) b13);
                    if (b12 != 0) {
                        this.zzc.zzs(2);
                        zzs(j14, this.zzc.zza, 2);
                        j14 += 2;
                        i11 = this.zzc.zzj();
                    }
                    int i12 = i11;
                    zzaqz zzaqz2 = zzarb2.zza;
                    int[] iArr = zzaqz2.zzd;
                    if (iArr == null || iArr.length < i12) {
                        iArr = new int[i12];
                    }
                    int[] iArr2 = iArr;
                    int[] iArr3 = zzaqz2.zze;
                    if (iArr3 == null || iArr3.length < i12) {
                        iArr3 = new int[i12];
                    }
                    int[] iArr4 = iArr3;
                    if (b12 != 0) {
                        int i13 = i12 * 6;
                        this.zzc.zzs(i13);
                        zzs(j14, this.zzc.zza, i13);
                        j14 += (long) i13;
                        this.zzc.zzv(0);
                        for (int i14 = 0; i14 < i12; i14++) {
                            iArr2[i14] = this.zzc.zzj();
                            iArr4[i14] = this.zzc.zzi();
                        }
                    } else {
                        iArr2[0] = 0;
                        iArr4[0] = zzaut.zza - ((int) (j14 - zzaut.zzb));
                    }
                    zzarr zzarr = zzaut.zzd;
                    zzaqz zzaqz3 = zzarb2.zza;
                    zzaqz3.zzb(i12, iArr2, iArr4, zzarr.zzb, zzaqz3.zza, 1);
                    long j15 = zzaut.zzb;
                    int i15 = (int) (j14 - j15);
                    zzaut.zzb = j15 + ((long) i15);
                    zzaut.zza -= i15;
                }
                zzarb2.zzh(this.zzb.zza);
                zzaut zzaut2 = this.zzb;
                long j16 = zzaut2.zzb;
                ByteBuffer byteBuffer = zzarb2.zzb;
                int i16 = zzaut2.zza;
                zzq(j16);
                while (i16 > 0) {
                    int i17 = (int) (j16 - this.zze.zza);
                    int min = Math.min(i16, 65536 - i17);
                    zzavt zzavt = this.zze.zzd;
                    byteBuffer.put(zzavt.zza, i17, min);
                    j16 += (long) min;
                    i16 -= min;
                    if (j16 == this.zze.zzb) {
                        this.zzl.zzc(zzavt);
                        zzauv zzauv = this.zze;
                        zzauv.zzd = null;
                        this.zze = zzauv.zze;
                    }
                }
                zzq(this.zzb.zzc);
            }
            return -4;
        }
    }

    public final long zzg() {
        return this.zza.zzc();
    }

    public final zzapg zzh() {
        return this.zza.zzf();
    }

    public final void zzi() {
        if (this.zzd.getAndSet(2) == 0) {
            zzp();
        }
    }

    public final void zzj(boolean z11) {
        int i11;
        AtomicInteger atomicInteger = this.zzd;
        if (true != z11) {
            i11 = 2;
        } else {
            i11 = 0;
        }
        int andSet = atomicInteger.getAndSet(i11);
        zzp();
        this.zza.zzj();
        if (andSet == 2) {
            this.zzg = null;
        }
    }

    public final void zzk(zzauw zzauw) {
        this.zzk = zzauw;
    }

    public final void zzl() {
        long zzd2 = this.zza.zzd();
        if (zzd2 != -1) {
            zzq(zzd2);
        }
    }

    public final boolean zzm() {
        return this.zza.zzl();
    }

    public final boolean zzn(long j11, boolean z11) {
        long zze2 = this.zza.zze(j11, z11);
        if (zze2 == -1) {
            return false;
        }
        zzq(zze2);
        return true;
    }
}

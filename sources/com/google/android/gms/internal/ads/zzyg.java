package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public final class zzyg implements zzwp {
    public static final zzww zza = zzyf.zza;
    private final byte[] zzb;
    private final zzfd zzc;
    private final zzwx zzd;
    private zzws zze;
    private zzxt zzf;
    private int zzg;
    @Nullable
    private zzdd zzh;
    private zzxd zzi;
    private int zzj;
    private int zzk;
    private zzye zzl;
    private int zzm;
    private long zzn;

    public zzyg() {
        this(0);
    }

    public zzyg(int i11) {
        this.zzb = new byte[42];
        this.zzc = new zzfd(new byte[32768], 0);
        this.zzd = new zzwx();
        this.zzg = 0;
    }

    private final long zze(zzfd zzfd, boolean z11) {
        boolean z12;
        this.zzi.getClass();
        int zzc2 = zzfd.zzc();
        while (zzc2 <= zzfd.zzd() - 16) {
            zzfd.zzF(zzc2);
            if (zzwy.zzc(zzfd, this.zzi, this.zzk, this.zzd)) {
                zzfd.zzF(zzc2);
                return this.zzd.zza;
            }
            zzc2++;
        }
        if (z11) {
            while (zzc2 <= zzfd.zzd() - this.zzj) {
                zzfd.zzF(zzc2);
                try {
                    z12 = zzwy.zzc(zzfd, this.zzi, this.zzk, this.zzd);
                } catch (IndexOutOfBoundsException unused) {
                    z12 = false;
                }
                if (zzfd.zzc() <= zzfd.zzd() && z12) {
                    zzfd.zzF(zzc2);
                    return this.zzd.zza;
                }
                zzc2++;
            }
            zzfd.zzF(zzfd.zzd());
            return -1;
        }
        zzfd.zzF(zzc2);
        return -1;
    }

    private final void zzf() {
        long j11 = this.zzn;
        zzxd zzxd = this.zzi;
        int i11 = zzfn.zza;
        this.zzf.zzs((j11 * 1000000) / ((long) zzxd.zze), 1, this.zzm, 0, (zzxs) null);
    }

    public final int zza(zzwq zzwq, zzxm zzxm) throws IOException {
        boolean zzl2;
        zzxd zzxd;
        zzxp zzxp;
        zzwq zzwq2 = zzwq;
        int i11 = this.zzg;
        boolean z11 = true;
        if (i11 == 0) {
            zzwq.zzj();
            long zzd2 = zzwq.zzd();
            zzdd zza2 = zzxa.zza(zzwq2, true);
            ((zzwk) zzwq2).zzo((int) (zzwq.zzd() - zzd2), false);
            this.zzh = zza2;
            this.zzg = 1;
            return 0;
        } else if (i11 == 1) {
            ((zzwk) zzwq2).zzm(this.zzb, 0, 42, false);
            zzwq.zzj();
            this.zzg = 2;
            return 0;
        } else if (i11 == 2) {
            zzfd zzfd = new zzfd(4);
            ((zzwk) zzwq2).zzn(zzfd.zzH(), 0, 4, false);
            if (zzfd.zzs() == 1716281667) {
                this.zzg = 3;
                return 0;
            }
            throw zzbj.zza("Failed to read FLAC stream marker.", (Throwable) null);
        } else if (i11 == 3) {
            zzwz zzwz = new zzwz(this.zzi);
            do {
                zzwq.zzj();
                zzfc zzfc = new zzfc(new byte[4], 4);
                zzwk zzwk = (zzwk) zzwq2;
                zzwk.zzm(zzfc.zza, 0, 4, false);
                zzl2 = zzfc.zzl();
                int zzc2 = zzfc.zzc(7);
                int zzc3 = zzfc.zzc(24) + 4;
                if (zzc2 == 0) {
                    byte[] bArr = new byte[38];
                    zzwk.zzn(bArr, 0, 38, false);
                    zzwz.zza = new zzxd(bArr, 4);
                } else {
                    zzxd zzxd2 = zzwz.zza;
                    if (zzxd2 == null) {
                        throw new IllegalArgumentException();
                    } else if (zzc2 == 3) {
                        zzfd zzfd2 = new zzfd(zzc3);
                        zzwk.zzn(zzfd2.zzH(), 0, zzc3, false);
                        zzwz.zza = zzxd2.zzf(zzxa.zzb(zzfd2));
                    } else if (zzc2 == 4) {
                        zzfd zzfd3 = new zzfd(zzc3);
                        zzwk.zzn(zzfd3.zzH(), 0, zzc3, false);
                        zzfd3.zzG(4);
                        zzwz.zza = zzxd2.zzg(Arrays.asList(zzxy.zzb(zzfd3, false, false).zzb));
                    } else if (zzc2 == 6) {
                        zzfd zzfd4 = new zzfd(zzc3);
                        zzwk.zzn(zzfd4.zzH(), 0, zzc3, false);
                        zzfd4.zzG(4);
                        int zze2 = zzfd4.zze();
                        String zzx = zzfd4.zzx(zzfd4.zze(), zzfpt.zza);
                        String zzx2 = zzfd4.zzx(zzfd4.zze(), zzfpt.zzc);
                        int zze3 = zzfd4.zze();
                        int zze4 = zzfd4.zze();
                        int zze5 = zzfd4.zze();
                        int zze6 = zzfd4.zze();
                        int zze7 = zzfd4.zze();
                        byte[] bArr2 = new byte[zze7];
                        zzfd4.zzB(bArr2, 0, zze7);
                        zzwz.zza = zzxd2.zze(Collections.singletonList(new zzyz(zze2, zzx, zzx2, zze3, zze4, zze5, zze6, bArr2)));
                    } else {
                        zzwk.zzo(zzc3, false);
                    }
                }
                zzxd = zzwz.zza;
                int i12 = zzfn.zza;
                this.zzi = zzxd;
            } while (!zzl2);
            zzxd.getClass();
            this.zzj = Math.max(zzxd.zzc, 6);
            this.zzf.zzk(this.zzi.zzc(this.zzb, this.zzh));
            this.zzg = 4;
            return 0;
        } else if (i11 != 4) {
            this.zzf.getClass();
            this.zzi.getClass();
            zzye zzye = this.zzl;
            if (zzye != null && zzye.zze()) {
                return this.zzl.zza(zzwq2, zzxm);
            }
            if (this.zzn == -1) {
                this.zzn = zzwy.zzb(zzwq2, this.zzi);
                return 0;
            }
            int zzd3 = this.zzc.zzd();
            if (zzd3 < 32768) {
                int zzg2 = zzwq2.zzg(this.zzc.zzH(), zzd3, 32768 - zzd3);
                if (zzg2 != -1) {
                    z11 = false;
                }
                if (!z11) {
                    this.zzc.zzE(zzd3 + zzg2);
                } else if (this.zzc.zza() == 0) {
                    zzf();
                    return -1;
                }
            } else {
                z11 = false;
            }
            int zzc4 = this.zzc.zzc();
            int i13 = this.zzm;
            int i14 = this.zzj;
            if (i13 < i14) {
                zzfd zzfd5 = this.zzc;
                zzfd5.zzG(Math.min(i14 - i13, zzfd5.zza()));
            }
            long zze8 = zze(this.zzc, z11);
            int zzc5 = this.zzc.zzc() - zzc4;
            this.zzc.zzF(zzc4);
            zzxr.zzb(this.zzf, this.zzc, zzc5);
            this.zzm += zzc5;
            if (zze8 != -1) {
                zzf();
                this.zzm = 0;
                this.zzn = zze8;
            }
            if (this.zzc.zza() >= 16) {
                return 0;
            }
            int zza3 = this.zzc.zza();
            System.arraycopy(this.zzc.zzH(), this.zzc.zzc(), this.zzc.zzH(), 0, zza3);
            this.zzc.zzF(0);
            this.zzc.zzE(zza3);
            return 0;
        } else {
            zzwq.zzj();
            zzfd zzfd6 = new zzfd(2);
            ((zzwk) zzwq2).zzm(zzfd6.zzH(), 0, 2, false);
            int zzo = zzfd6.zzo();
            if ((zzo >> 2) == 16382) {
                zzwq.zzj();
                this.zzk = zzo;
                zzws zzws = this.zze;
                int i15 = zzfn.zza;
                long zze9 = zzwq.zze();
                long zzc6 = zzwq.zzc();
                zzxd zzxd3 = this.zzi;
                zzxd3.getClass();
                if (zzxd3.zzk != null) {
                    zzxp = new zzxb(zzxd3, zze9);
                } else if (zzc6 == -1 || zzxd3.zzj <= 0) {
                    zzxp = new zzxo(zzxd3.zza(), 0);
                } else {
                    zzye zzye2 = new zzye(zzxd3, this.zzk, zze9, zzc6);
                    this.zzl = zzye2;
                    zzxp = zzye2.zzb();
                }
                zzws.zzL(zzxp);
                this.zzg = 5;
                return 0;
            }
            zzwq.zzj();
            throw zzbj.zza("First frame does not start with sync code.", (Throwable) null);
        }
    }

    public final void zzb(zzws zzws) {
        this.zze = zzws;
        this.zzf = zzws.zzv(0, 1);
        zzws.zzB();
    }

    public final void zzc(long j11, long j12) {
        long j13 = 0;
        if (j11 == 0) {
            this.zzg = 0;
        } else {
            zzye zzye = this.zzl;
            if (zzye != null) {
                zzye.zzd(j12);
            }
        }
        if (j12 != 0) {
            j13 = -1;
        }
        this.zzn = j13;
        this.zzm = 0;
        this.zzc.zzC(0);
    }

    public final boolean zzd(zzwq zzwq) throws IOException {
        zzxa.zza(zzwq, false);
        zzfd zzfd = new zzfd(4);
        ((zzwk) zzwq).zzm(zzfd.zzH(), 0, 4, false);
        if (zzfd.zzs() == 1716281667) {
            return true;
        }
        return false;
    }
}

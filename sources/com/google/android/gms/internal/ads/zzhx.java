package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;

final class zzhx {
    private final zzca zza = new zzca();
    private final zzcc zzb = new zzcc();
    @Nullable
    private final zzlb zzc;
    private final Handler zzd;
    private long zze;
    private int zzf;
    private boolean zzg;
    @Nullable
    private zzhu zzh;
    @Nullable
    private zzhu zzi;
    @Nullable
    private zzhu zzj;
    private int zzk;
    @Nullable
    private Object zzl;
    private long zzm;

    public zzhx(@Nullable zzlb zzlb, Handler handler) {
        this.zzc = zzlb;
        this.zzd = handler;
    }

    private final boolean zzA(zzcd zzcd, zzpz zzpz) {
        if (!zzC(zzpz)) {
            return false;
        }
        int i11 = zzcd.zzn(zzpz.zza, this.zza).zzd;
        if (zzcd.zze(i11, this.zzb, 0).zzp == zzcd.zza(zzpz.zza)) {
            return true;
        }
        return false;
    }

    private final boolean zzB(zzcd zzcd) {
        zzhu zzhu = this.zzh;
        if (zzhu == null) {
            return true;
        }
        int zza2 = zzcd.zza(zzhu.zzb);
        while (true) {
            zza2 = zzcd.zzi(zza2, this.zza, this.zzb, this.zzf, this.zzg);
            while (zzhu.zzh() != null && !zzhu.zzf.zzg) {
                zzhu = zzhu.zzh();
            }
            zzhu zzh2 = zzhu.zzh();
            if (zza2 == -1 || zzh2 == null || zzcd.zza(zzh2.zzb) != zza2) {
                boolean zzm2 = zzm(zzhu);
                zzhu.zzf = zzg(zzcd, zzhu.zzf);
            } else {
                zzhu = zzh2;
            }
        }
        boolean zzm22 = zzm(zzhu);
        zzhu.zzf = zzg(zzcd, zzhu.zzf);
        if (!zzm22) {
            return true;
        }
        return false;
    }

    private static final boolean zzC(zzpz zzpz) {
        return !zzpz.zzb() && zzpz.zze == -1;
    }

    private final long zzs(zzcd zzcd, Object obj, int i11) {
        zzcd.zzn(obj, this.zza);
        this.zza.zzg(i11);
        this.zza.zzi(i11);
        return 0;
    }

    @Nullable
    private final zzhv zzt(zzcd zzcd, zzhu zzhu, long j11) {
        long j12;
        zzcd zzcd2 = zzcd;
        zzhv zzhv = zzhu.zzf;
        long zze2 = (zzhu.zze() + zzhv.zze) - j11;
        if (zzhv.zzg) {
            long j13 = 0;
            int zzi2 = zzcd.zzi(zzcd2.zza(zzhv.zza.zza), this.zza, this.zzb, this.zzf, this.zzg);
            if (zzi2 == -1) {
                return null;
            }
            int i11 = zzcd2.zzd(zzi2, this.zza, true).zzd;
            Object obj = this.zza.zzc;
            long j14 = zzhv.zza.zzd;
            if (zzcd2.zze(i11, this.zzb, 0).zzo == zzi2) {
                Pair<Object, Long> zzm2 = zzcd.zzm(this.zzb, this.zza, i11, C.TIME_UNSET, Math.max(0, zze2));
                if (zzm2 == null) {
                    return null;
                }
                obj = zzm2.first;
                long longValue = ((Long) zzm2.second).longValue();
                zzhu zzh2 = zzhu.zzh();
                if (zzh2 == null || !zzh2.zzb.equals(obj)) {
                    j14 = this.zze;
                    this.zze = 1 + j14;
                } else {
                    j14 = zzh2.zzf.zza.zzd;
                }
                j12 = longValue;
                j13 = C.TIME_UNSET;
            } else {
                j12 = 0;
            }
            return zzu(zzcd, zzx(zzcd, obj, j12, j14, this.zza), j13, j12);
        }
        zzpz zzpz = zzhv.zza;
        zzcd2.zzn(zzpz.zza, this.zza);
        if (zzpz.zzb()) {
            int i12 = zzpz.zzb;
            if (this.zza.zza(i12) == -1) {
                return null;
            }
            int zze3 = this.zza.zze(i12, zzpz.zzc);
            if (zze3 < 0) {
                return zzv(zzcd, zzpz.zza, i12, zze3, zzhv.zzc, zzpz.zzd);
            }
            long j15 = zzhv.zzc;
            if (j15 == C.TIME_UNSET) {
                zzcc zzcc = this.zzb;
                zzca zzca = this.zza;
                Pair<Object, Long> zzm3 = zzcd.zzm(zzcc, zzca, zzca.zzd, C.TIME_UNSET, Math.max(0, zze2));
                if (zzm3 == null) {
                    return null;
                }
                j15 = ((Long) zzm3.second).longValue();
            }
            zzs(zzcd2, zzpz.zza, zzpz.zzb);
            return zzw(zzcd, zzpz.zza, Math.max(0, j15), zzhv.zzc, zzpz.zzd);
        }
        int zzd2 = this.zza.zzd(zzpz.zze);
        if (zzd2 == this.zza.zza(zzpz.zze)) {
            zzs(zzcd2, zzpz.zza, zzpz.zze);
            return zzw(zzcd, zzpz.zza, 0, zzhv.zze, zzpz.zzd);
        }
        return zzv(zzcd, zzpz.zza, zzpz.zze, zzd2, zzhv.zze, zzpz.zzd);
    }

    @Nullable
    private final zzhv zzu(zzcd zzcd, zzpz zzpz, long j11, long j12) {
        zzpz zzpz2 = zzpz;
        zzcd zzcd2 = zzcd;
        zzcd.zzn(zzpz2.zza, this.zza);
        if (zzpz.zzb()) {
            return zzv(zzcd, zzpz2.zza, zzpz2.zzb, zzpz2.zzc, j11, zzpz2.zzd);
        }
        return zzw(zzcd, zzpz2.zza, j12, j11, zzpz2.zzd);
    }

    private final zzhv zzv(zzcd zzcd, Object obj, int i11, int i12, long j11, long j12) {
        long j13;
        zzpz zzpz = new zzpz(obj, i11, i12, j12);
        long zzf2 = zzcd.zzn(zzpz.zza, this.zza).zzf(zzpz.zzb, zzpz.zzc);
        if (i12 == this.zza.zzd(i11)) {
            this.zza.zzh();
        }
        this.zza.zzk(zzpz.zzb);
        if (zzf2 == C.TIME_UNSET || zzf2 > 0) {
            j13 = 0;
        } else {
            j13 = Math.max(0, -1 + zzf2);
        }
        return new zzhv(zzpz, j13, j11, C.TIME_UNSET, zzf2, false, false, false, false);
    }

    private final zzhv zzw(zzcd zzcd, Object obj, long j11, long j12, long j13) {
        long j14;
        long j15;
        zzcd zzcd2 = zzcd;
        Object obj2 = obj;
        long j16 = j11;
        zzcd2.zzn(obj2, this.zza);
        int zzb2 = this.zza.zzb(j16);
        zzpz zzpz = new zzpz(obj2, j13, zzb2);
        boolean zzC = zzC(zzpz);
        boolean zzA = zzA(zzcd2, zzpz);
        boolean zzz = zzz(zzcd2, zzpz, zzC);
        if (zzb2 != -1) {
            this.zza.zzk(zzb2);
        }
        if (zzb2 != -1) {
            this.zza.zzg(zzb2);
            j14 = 0;
        } else {
            j14 = -9223372036854775807L;
        }
        if (j14 != C.TIME_UNSET) {
            j15 = j14;
        } else {
            j15 = this.zza.zze;
        }
        if (j15 != C.TIME_UNSET && j16 >= j15) {
            j16 = Math.max(0, -1 + j15);
        }
        return new zzhv(zzpz, j16, j12, j14, j15, false, zzC, zzA, zzz);
    }

    private static zzpz zzx(zzcd zzcd, Object obj, long j11, long j12, zzca zzca) {
        zzcd.zzn(obj, zzca);
        int zzc2 = zzca.zzc(j11);
        if (zzc2 == -1) {
            return new zzpz(obj, j12, zzca.zzb(j11));
        }
        return new zzpz(obj, zzc2, zzca.zzd(zzc2), j12);
    }

    private final void zzy() {
        zzpz zzpz;
        zzfsp zzi2 = zzfss.zzi();
        for (zzhu zzhu = this.zzh; zzhu != null; zzhu = zzhu.zzh()) {
            zzi2.zze(zzhu.zzf.zza);
        }
        zzhu zzhu2 = this.zzi;
        if (zzhu2 == null) {
            zzpz = null;
        } else {
            zzpz = zzhu2.zzf.zza;
        }
        this.zzd.post(new zzhw(this, zzi2, zzpz));
    }

    private final boolean zzz(zzcd zzcd, zzpz zzpz, boolean z11) {
        int zza2 = zzcd.zza(zzpz.zza);
        if (!zzcd.zze(zzcd.zzd(zza2, this.zza, false).zzd, this.zzb, 0).zzi) {
            if (zzcd.zzi(zza2, this.zza, this.zzb, this.zzf, this.zzg) != -1 || !z11) {
                return false;
            }
            return true;
        }
        return false;
    }

    @Nullable
    public final zzhu zza() {
        zzhu zzhu = this.zzh;
        if (zzhu == null) {
            return null;
        }
        if (zzhu == this.zzi) {
            this.zzi = zzhu.zzh();
        }
        this.zzh.zzn();
        int i11 = this.zzk - 1;
        this.zzk = i11;
        if (i11 == 0) {
            this.zzj = null;
            zzhu zzhu2 = this.zzh;
            this.zzl = zzhu2.zzb;
            this.zzm = zzhu2.zzf.zza.zzd;
        }
        this.zzh = this.zzh.zzh();
        zzy();
        return this.zzh;
    }

    public final zzhu zzb() {
        zzhu zzhu = this.zzi;
        boolean z11 = false;
        if (!(zzhu == null || zzhu.zzh() == null)) {
            z11 = true;
        }
        zzdy.zzf(z11);
        this.zzi = this.zzi.zzh();
        zzy();
        return this.zzi;
    }

    @Nullable
    public final zzhu zzc() {
        return this.zzj;
    }

    @Nullable
    public final zzhu zzd() {
        return this.zzh;
    }

    @Nullable
    public final zzhu zze() {
        return this.zzi;
    }

    @Nullable
    public final zzhv zzf(long j11, zzif zzif) {
        zzhu zzhu = this.zzj;
        if (zzhu != null) {
            return zzt(zzif.zza, zzhu, j11);
        }
        return zzu(zzif.zza, zzif.zzb, zzif.zzc, zzif.zzs);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0062  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzhv zzg(com.google.android.gms.internal.ads.zzcd r19, com.google.android.gms.internal.ads.zzhv r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            com.google.android.gms.internal.ads.zzpz r3 = r2.zza
            boolean r12 = zzC(r3)
            boolean r13 = r0.zzA(r1, r3)
            boolean r14 = r0.zzz(r1, r3, r12)
            com.google.android.gms.internal.ads.zzpz r4 = r2.zza
            java.lang.Object r4 = r4.zza
            com.google.android.gms.internal.ads.zzca r5 = r0.zza
            r1.zzn(r4, r5)
            boolean r1 = r3.zzb()
            r4 = -1
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 != 0) goto L_0x0036
            int r1 = r3.zze
            if (r1 != r4) goto L_0x002e
            goto L_0x0036
        L_0x002e:
            com.google.android.gms.internal.ads.zzca r7 = r0.zza
            r7.zzg(r1)
            r7 = 0
            goto L_0x0037
        L_0x0036:
            r7 = r5
        L_0x0037:
            boolean r1 = r3.zzb()
            if (r1 == 0) goto L_0x0049
            com.google.android.gms.internal.ads.zzca r1 = r0.zza
            int r5 = r3.zzb
            int r6 = r3.zzc
            long r5 = r1.zzf(r5, r6)
        L_0x0047:
            r9 = r5
            goto L_0x0054
        L_0x0049:
            int r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x004f
            r9 = r7
            goto L_0x0054
        L_0x004f:
            com.google.android.gms.internal.ads.zzca r1 = r0.zza
            long r5 = r1.zze
            goto L_0x0047
        L_0x0054:
            boolean r1 = r3.zzb()
            if (r1 == 0) goto L_0x0062
            com.google.android.gms.internal.ads.zzca r1 = r0.zza
            int r4 = r3.zzb
            r1.zzk(r4)
            goto L_0x006b
        L_0x0062:
            int r1 = r3.zze
            if (r1 == r4) goto L_0x006b
            com.google.android.gms.internal.ads.zzca r4 = r0.zza
            r4.zzk(r1)
        L_0x006b:
            com.google.android.gms.internal.ads.zzhv r15 = new com.google.android.gms.internal.ads.zzhv
            long r4 = r2.zzb
            long r1 = r2.zzc
            r11 = 0
            r16 = r1
            r1 = r15
            r2 = r3
            r3 = r4
            r5 = r16
            r1.<init>(r2, r3, r5, r7, r9, r11, r12, r13, r14)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhx.zzg(com.google.android.gms.internal.ads.zzcd, com.google.android.gms.internal.ads.zzhv):com.google.android.gms.internal.ads.zzhv");
    }

    public final zzpz zzh(zzcd zzcd, Object obj, long j11) {
        long j12;
        int zza2;
        int i11 = zzcd.zzn(obj, this.zza).zzd;
        Object obj2 = this.zzl;
        if (obj2 == null || (zza2 = zzcd.zza(obj2)) == -1 || zzcd.zzd(zza2, this.zza, false).zzd != i11) {
            zzhu zzhu = this.zzh;
            while (true) {
                if (zzhu == null) {
                    zzhu zzhu2 = this.zzh;
                    while (true) {
                        if (zzhu2 != null) {
                            int zza3 = zzcd.zza(zzhu2.zzb);
                            if (zza3 != -1 && zzcd.zzd(zza3, this.zza, false).zzd == i11) {
                                j12 = zzhu2.zzf.zza.zzd;
                                break;
                            }
                            zzhu2 = zzhu2.zzh();
                        } else {
                            j12 = this.zze;
                            this.zze = 1 + j12;
                            if (this.zzh == null) {
                                this.zzl = obj;
                                this.zzm = j12;
                            }
                        }
                    }
                } else if (zzhu.zzb.equals(obj)) {
                    j12 = zzhu.zzf.zza.zzd;
                    break;
                } else {
                    zzhu = zzhu.zzh();
                }
            }
        } else {
            j12 = this.zzm;
        }
        return zzx(zzcd, obj, j11, j12, this.zza);
    }

    public final void zzi() {
        if (this.zzk != 0) {
            zzhu zzhu = this.zzh;
            zzdy.zzb(zzhu);
            this.zzl = zzhu.zzb;
            this.zzm = zzhu.zzf.zza.zzd;
            while (zzhu != null) {
                zzhu.zzn();
                zzhu = zzhu.zzh();
            }
            this.zzh = null;
            this.zzj = null;
            this.zzi = null;
            this.zzk = 0;
            zzy();
        }
    }

    public final /* synthetic */ void zzj(zzfsp zzfsp, zzpz zzpz) {
        this.zzc.zzX(zzfsp.zzf(), zzpz);
    }

    public final void zzk(long j11) {
        zzhu zzhu = this.zzj;
        if (zzhu != null) {
            zzhu.zzm(j11);
        }
    }

    public final boolean zzl(zzpy zzpy) {
        zzhu zzhu = this.zzj;
        return zzhu != null && zzhu.zza == zzpy;
    }

    public final boolean zzm(zzhu zzhu) {
        boolean z11;
        boolean z12 = false;
        if (zzhu != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzdy.zzf(z11);
        if (zzhu.equals(this.zzj)) {
            return false;
        }
        this.zzj = zzhu;
        while (zzhu.zzh() != null) {
            zzhu = zzhu.zzh();
            if (zzhu == this.zzi) {
                this.zzi = this.zzh;
                z12 = true;
            }
            zzhu.zzn();
            this.zzk--;
        }
        this.zzj.zzo((zzhu) null);
        zzy();
        return z12;
    }

    public final boolean zzn() {
        zzhu zzhu = this.zzj;
        if (zzhu == null) {
            return true;
        }
        if (zzhu.zzf.zzi || !zzhu.zzr() || this.zzj.zzf.zze == C.TIME_UNSET) {
            return false;
        }
        if (this.zzk < 100) {
            return true;
        }
        return false;
    }

    public final boolean zzo(zzcd zzcd, long j11, long j12) {
        zzhv zzhv;
        long j13;
        boolean z11;
        zzcd zzcd2 = zzcd;
        zzhu zzhu = this.zzh;
        zzhu zzhu2 = null;
        while (zzhu != null) {
            zzhv zzhv2 = zzhu.zzf;
            if (zzhu2 == null) {
                zzhv = zzg(zzcd2, zzhv2);
                long j14 = j11;
            } else {
                zzhv zzt = zzt(zzcd2, zzhu2, j11);
                if (zzt == null) {
                    if (!zzm(zzhu2)) {
                        return true;
                    }
                    return false;
                } else if (zzhv2.zzb == zzt.zzb && zzhv2.zza.equals(zzt.zza)) {
                    zzhv = zzt;
                } else if (!zzm(zzhu2)) {
                    return true;
                } else {
                    return false;
                }
            }
            zzhu.zzf = zzhv.zza(zzhv2.zzc);
            long j15 = zzhv2.zze;
            long j16 = zzhv.zze;
            if (j15 == C.TIME_UNSET || j15 == j16) {
                zzhu2 = zzhu;
                zzhu = zzhu.zzh();
            } else {
                zzhu.zzq();
                long j17 = zzhv.zze;
                if (j17 == C.TIME_UNSET) {
                    j13 = Long.MAX_VALUE;
                } else {
                    j13 = j17 + zzhu.zze();
                }
                if (zzhu == this.zzi) {
                    boolean z12 = zzhu.zzf.zzf;
                    if (j12 == Long.MIN_VALUE || j12 >= j13) {
                        z11 = true;
                        if (!zzm(zzhu) || z11) {
                            return false;
                        }
                        return true;
                    }
                }
                z11 = false;
                if (!zzm(zzhu)) {
                }
                return false;
            }
        }
        return true;
    }

    public final boolean zzp(zzcd zzcd, int i11) {
        this.zzf = i11;
        return zzB(zzcd);
    }

    public final boolean zzq(zzcd zzcd, boolean z11) {
        this.zzg = z11;
        return zzB(zzcd);
    }

    public final zzhu zzr(zzim[] zzimArr, zzsv zzsv, zztk zztk, zzie zzie, zzhv zzhv, zzsw zzsw) {
        long j11;
        zzhv zzhv2 = zzhv;
        zzhu zzhu = this.zzj;
        if (zzhu == null) {
            if (zzhv2.zza.zzb()) {
                long j12 = zzhv2.zzc;
                if (j12 != C.TIME_UNSET) {
                    j11 = j12;
                }
            }
            j11 = 0;
        } else {
            j11 = (zzhu.zze() + this.zzj.zzf.zze) - zzhv2.zzb;
        }
        zzhu zzhu2 = new zzhu(zzimArr, j11, zzsv, zztk, zzie, zzhv, zzsw, (byte[]) null);
        zzhu zzhu3 = this.zzj;
        if (zzhu3 != null) {
            zzhu3.zzo(zzhu2);
        } else {
            this.zzh = zzhu2;
            this.zzi = zzhu2;
        }
        this.zzl = null;
        this.zzj = zzhu2;
        this.zzk++;
        zzy();
        return zzhu2;
    }
}

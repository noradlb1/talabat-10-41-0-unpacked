package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import java.io.EOFException;
import java.io.IOException;

public final class zzabg implements zzwp {
    public static final zzww zza = zzabe.zza;
    private static final zzzr zzb = zzabf.zza;
    private final zzfd zzc;
    private final zzxj zzd;
    private final zzxf zze;
    private final zzxh zzf;
    private final zzxt zzg;
    private zzws zzh;
    private zzxt zzi;
    private zzxt zzj;
    private int zzk;
    @Nullable
    private zzdd zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private int zzp;
    private zzabi zzq;
    private boolean zzr;

    public zzabg() {
        this(0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x015b  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"extractorOutput", "realTrackOutput"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzf(com.google.android.gms.internal.ads.zzwq r17) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            int r2 = r0.zzk
            r3 = -1
            r4 = 0
            if (r2 != 0) goto L_0x000f
            r0.zzk(r1, r4)     // Catch:{ EOFException -> 0x000e }
            goto L_0x000f
        L_0x000e:
            return r3
        L_0x000f:
            com.google.android.gms.internal.ads.zzabi r2 = r0.zzq
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r8 = 1
            if (r2 != 0) goto L_0x01b5
            com.google.android.gms.internal.ads.zzfd r14 = new com.google.android.gms.internal.ads.zzfd
            com.google.android.gms.internal.ads.zzxj r2 = r0.zzd
            int r2 = r2.zzc
            r14.<init>((int) r2)
            byte[] r2 = r14.zzH()
            com.google.android.gms.internal.ads.zzxj r9 = r0.zzd
            int r9 = r9.zzc
            r10 = r1
            com.google.android.gms.internal.ads.zzwk r10 = (com.google.android.gms.internal.ads.zzwk) r10
            r10.zzm(r2, r4, r9, r4)
            com.google.android.gms.internal.ads.zzxj r2 = r0.zzd
            int r9 = r2.zza
            r9 = r9 & r8
            r10 = 36
            r11 = 21
            if (r9 == 0) goto L_0x0041
            int r2 = r2.zze
            if (r2 == r8) goto L_0x0048
            r2 = r10
            goto L_0x0049
        L_0x0041:
            int r2 = r2.zze
            if (r2 == r8) goto L_0x0046
            goto L_0x0048
        L_0x0046:
            r11 = 13
        L_0x0048:
            r2 = r11
        L_0x0049:
            int r9 = r14.zzd()
            int r11 = r2 + 4
            r12 = 1483304551(0x58696e67, float:1.02664153E15)
            r13 = 1447187017(0x56425249, float:5.3414667E13)
            r15 = 1231971951(0x496e666f, float:976486.94)
            if (r9 < r11) goto L_0x0069
            r14.zzF(r2)
            int r9 = r14.zze()
            if (r9 == r12) goto L_0x0067
            if (r9 != r15) goto L_0x0069
            r11 = r15
            goto L_0x007d
        L_0x0067:
            r11 = r9
            goto L_0x007d
        L_0x0069:
            int r9 = r14.zzd()
            r11 = 40
            if (r9 < r11) goto L_0x007c
            r14.zzF(r10)
            int r9 = r14.zze()
            if (r9 != r13) goto L_0x007c
            r11 = r13
            goto L_0x007d
        L_0x007c:
            r11 = r4
        L_0x007d:
            if (r11 == r12) goto L_0x00a2
            if (r11 != r15) goto L_0x0082
            goto L_0x00a2
        L_0x0082:
            if (r11 != r13) goto L_0x009d
            long r9 = r17.zzc()
            long r11 = r17.zze()
            com.google.android.gms.internal.ads.zzxj r13 = r0.zzd
            com.google.android.gms.internal.ads.zzabj r2 = com.google.android.gms.internal.ads.zzabj.zza(r9, r11, r13, r14)
            com.google.android.gms.internal.ads.zzxj r9 = r0.zzd
            int r9 = r9.zzc
            r10 = r1
            com.google.android.gms.internal.ads.zzwk r10 = (com.google.android.gms.internal.ads.zzwk) r10
            r10.zzo(r9, r4)
            goto L_0x0105
        L_0x009d:
            r17.zzj()
            r2 = 0
            goto L_0x0105
        L_0x00a2:
            long r9 = r17.zzc()
            long r12 = r17.zze()
            com.google.android.gms.internal.ads.zzxj r8 = r0.zzd
            r7 = r11
            r11 = r12
            r13 = r8
            com.google.android.gms.internal.ads.zzabk r8 = com.google.android.gms.internal.ads.zzabk.zza(r9, r11, r13, r14)
            if (r8 == 0) goto L_0x00eb
            com.google.android.gms.internal.ads.zzxf r9 = r0.zze
            boolean r9 = r9.zza()
            if (r9 != 0) goto L_0x00eb
            r17.zzj()
            r9 = r1
            com.google.android.gms.internal.ads.zzwk r9 = (com.google.android.gms.internal.ads.zzwk) r9
            int r2 = r2 + 141
            r9.zzl(r2, r4)
            com.google.android.gms.internal.ads.zzfd r2 = r0.zzc
            byte[] r2 = r2.zzH()
            r10 = 3
            r9.zzm(r2, r4, r10, r4)
            com.google.android.gms.internal.ads.zzfd r2 = r0.zzc
            r2.zzF(r4)
            com.google.android.gms.internal.ads.zzxf r2 = r0.zze
            com.google.android.gms.internal.ads.zzfd r9 = r0.zzc
            int r9 = r9.zzm()
            int r10 = r9 >> 12
            r9 = r9 & 4095(0xfff, float:5.738E-42)
            if (r10 > 0) goto L_0x00e7
            if (r9 <= 0) goto L_0x00eb
        L_0x00e7:
            r2.zza = r10
            r2.zzb = r9
        L_0x00eb:
            com.google.android.gms.internal.ads.zzxj r2 = r0.zzd
            int r2 = r2.zzc
            r9 = r1
            com.google.android.gms.internal.ads.zzwk r9 = (com.google.android.gms.internal.ads.zzwk) r9
            r9.zzo(r2, r4)
            if (r8 == 0) goto L_0x0104
            boolean r2 = r8.zzh()
            if (r2 != 0) goto L_0x0104
            if (r7 != r15) goto L_0x0104
            com.google.android.gms.internal.ads.zzabi r2 = r0.zzh(r1, r4)
            goto L_0x0105
        L_0x0104:
            r2 = r8
        L_0x0105:
            com.google.android.gms.internal.ads.zzdd r7 = r0.zzl
            long r8 = r17.zze()
            if (r7 == 0) goto L_0x0150
            int r10 = r7.zza()
            r11 = r4
        L_0x0112:
            if (r11 >= r10) goto L_0x0150
            com.google.android.gms.internal.ads.zzdc r12 = r7.zzb(r11)
            boolean r13 = r12 instanceof com.google.android.gms.internal.ads.zzzy
            if (r13 == 0) goto L_0x014d
            com.google.android.gms.internal.ads.zzzy r12 = (com.google.android.gms.internal.ads.zzzy) r12
            int r10 = r7.zza()
            r11 = r4
        L_0x0123:
            if (r11 >= r10) goto L_0x0147
            com.google.android.gms.internal.ads.zzdc r13 = r7.zzb(r11)
            boolean r14 = r13 instanceof com.google.android.gms.internal.ads.zzaac
            if (r14 == 0) goto L_0x0144
            com.google.android.gms.internal.ads.zzaac r13 = (com.google.android.gms.internal.ads.zzaac) r13
            java.lang.String r14 = r13.zzf
            java.lang.String r15 = "TLEN"
            boolean r14 = r14.equals(r15)
            if (r14 == 0) goto L_0x0144
            java.lang.String r7 = r13.zzb
            long r10 = java.lang.Long.parseLong(r7)
            long r10 = com.google.android.gms.internal.ads.zzk.zzc(r10)
            goto L_0x0148
        L_0x0144:
            int r11 = r11 + 1
            goto L_0x0123
        L_0x0147:
            r10 = r5
        L_0x0148:
            com.google.android.gms.internal.ads.zzabd r7 = com.google.android.gms.internal.ads.zzabd.zza(r8, r12, r10)
            goto L_0x0151
        L_0x014d:
            int r11 = r11 + 1
            goto L_0x0112
        L_0x0150:
            r7 = 0
        L_0x0151:
            boolean r8 = r0.zzr
            if (r8 == 0) goto L_0x015b
            com.google.android.gms.internal.ads.zzabh r2 = new com.google.android.gms.internal.ads.zzabh
            r2.<init>()
            goto L_0x016c
        L_0x015b:
            if (r7 == 0) goto L_0x015f
            r2 = r7
            goto L_0x0162
        L_0x015f:
            if (r2 != 0) goto L_0x0162
            r2 = 0
        L_0x0162:
            if (r2 == 0) goto L_0x0168
            r2.zzh()
            goto L_0x016c
        L_0x0168:
            com.google.android.gms.internal.ads.zzabi r2 = r0.zzh(r1, r4)
        L_0x016c:
            r0.zzq = r2
            com.google.android.gms.internal.ads.zzws r7 = r0.zzh
            r7.zzL(r2)
            com.google.android.gms.internal.ads.zzxt r2 = r0.zzj
            com.google.android.gms.internal.ads.zzz r7 = new com.google.android.gms.internal.ads.zzz
            r7.<init>()
            com.google.android.gms.internal.ads.zzxj r8 = r0.zzd
            java.lang.String r8 = r8.zzb
            r7.zzS(r8)
            r8 = 4096(0x1000, float:5.74E-42)
            r7.zzL(r8)
            com.google.android.gms.internal.ads.zzxj r8 = r0.zzd
            int r8 = r8.zze
            r7.zzw(r8)
            com.google.android.gms.internal.ads.zzxj r8 = r0.zzd
            int r8 = r8.zzd
            r7.zzT(r8)
            com.google.android.gms.internal.ads.zzxf r8 = r0.zze
            int r8 = r8.zza
            r7.zzC(r8)
            com.google.android.gms.internal.ads.zzxf r8 = r0.zze
            int r8 = r8.zzb
            r7.zzD(r8)
            com.google.android.gms.internal.ads.zzdd r8 = r0.zzl
            r7.zzM(r8)
            com.google.android.gms.internal.ads.zzab r7 = r7.zzY()
            r2.zzk(r7)
            long r7 = r17.zze()
            r0.zzo = r7
            goto L_0x01cf
        L_0x01b5:
            long r7 = r0.zzo
            r9 = 0
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 == 0) goto L_0x01cf
            long r7 = r17.zze()
            long r9 = r0.zzo
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 >= 0) goto L_0x01cf
            r2 = r1
            com.google.android.gms.internal.ads.zzwk r2 = (com.google.android.gms.internal.ads.zzwk) r2
            long r9 = r9 - r7
            int r7 = (int) r9
            r2.zzo(r7, r4)
        L_0x01cf:
            int r2 = r0.zzp
            if (r2 != 0) goto L_0x0233
            r17.zzj()
            boolean r2 = r16.zzj(r17)
            if (r2 == 0) goto L_0x01dd
            goto L_0x0245
        L_0x01dd:
            com.google.android.gms.internal.ads.zzfd r2 = r0.zzc
            r2.zzF(r4)
            com.google.android.gms.internal.ads.zzfd r2 = r0.zzc
            int r2 = r2.zze()
            int r7 = r0.zzk
            long r7 = (long) r7
            boolean r7 = zzi(r2, r7)
            if (r7 == 0) goto L_0x022a
            int r7 = com.google.android.gms.internal.ads.zzxk.zzb(r2)
            if (r7 != r3) goto L_0x01f8
            goto L_0x022a
        L_0x01f8:
            com.google.android.gms.internal.ads.zzxj r7 = r0.zzd
            r7.zza(r2)
            long r7 = r0.zzm
            int r2 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x020f
            com.google.android.gms.internal.ads.zzabi r2 = r0.zzq
            long r5 = r17.zze()
            long r5 = r2.zzc(r5)
            r0.zzm = r5
        L_0x020f:
            com.google.android.gms.internal.ads.zzxj r2 = r0.zzd
            int r5 = r2.zzc
            r0.zzp = r5
            com.google.android.gms.internal.ads.zzabi r6 = r0.zzq
            boolean r7 = r6 instanceof com.google.android.gms.internal.ads.zzabc
            if (r7 != 0) goto L_0x021d
            r2 = r5
            goto L_0x0233
        L_0x021d:
            com.google.android.gms.internal.ads.zzabc r6 = (com.google.android.gms.internal.ads.zzabc) r6
            long r3 = r0.zzn
            int r1 = r2.zzg
            long r1 = (long) r1
            long r3 = r3 + r1
            r0.zzg(r3)
            r1 = 0
            throw r1
        L_0x022a:
            com.google.android.gms.internal.ads.zzwk r1 = (com.google.android.gms.internal.ads.zzwk) r1
            r5 = 1
            r1.zzo(r5, r4)
            r0.zzk = r4
            goto L_0x0244
        L_0x0233:
            r5 = 1
            com.google.android.gms.internal.ads.zzxt r6 = r0.zzj
            int r1 = r6.zze(r1, r2, r5)
            if (r1 != r3) goto L_0x023d
            goto L_0x0245
        L_0x023d:
            int r2 = r0.zzp
            int r2 = r2 - r1
            r0.zzp = r2
            if (r2 <= 0) goto L_0x0246
        L_0x0244:
            r3 = r4
        L_0x0245:
            return r3
        L_0x0246:
            com.google.android.gms.internal.ads.zzxt r5 = r0.zzj
            long r1 = r0.zzn
            long r6 = r0.zzg(r1)
            r8 = 1
            com.google.android.gms.internal.ads.zzxj r1 = r0.zzd
            int r9 = r1.zzc
            r10 = 0
            r11 = 0
            r5.zzs(r6, r8, r9, r10, r11)
            long r1 = r0.zzn
            com.google.android.gms.internal.ads.zzxj r3 = r0.zzd
            int r3 = r3.zzg
            long r5 = (long) r3
            long r1 = r1 + r5
            r0.zzn = r1
            r0.zzp = r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzabg.zzf(com.google.android.gms.internal.ads.zzwq):int");
    }

    private final long zzg(long j11) {
        return this.zzm + ((j11 * 1000000) / ((long) this.zzd.zzd));
    }

    private final zzabi zzh(zzwq zzwq, boolean z11) throws IOException {
        ((zzwk) zzwq).zzm(this.zzc.zzH(), 0, 4, false);
        this.zzc.zzF(0);
        this.zzd.zza(this.zzc.zze());
        return new zzabb(zzwq.zzc(), zzwq.zze(), this.zzd, false);
    }

    private static boolean zzi(int i11, long j11) {
        return ((long) (i11 & -128000)) == (j11 & -128000);
    }

    private final boolean zzj(zzwq zzwq) throws IOException {
        zzabi zzabi = this.zzq;
        if (zzabi != null) {
            long zzb2 = zzabi.zzb();
            if (zzb2 != -1 && zzwq.zzd() > zzb2 - 4) {
                return true;
            }
        }
        try {
            return !zzwq.zzm(this.zzc.zzH(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    private final boolean zzk(zzwq zzwq, boolean z11) throws IOException {
        int i11;
        int i12;
        int i13;
        int zzb2;
        if (true != z11) {
            i11 = 131072;
        } else {
            i11 = 32768;
        }
        zzwq.zzj();
        if (zzwq.zze() == 0) {
            zzdd zza2 = this.zzf.zza(zzwq, (zzzr) null);
            this.zzl = zza2;
            if (zza2 != null) {
                this.zze.zzb(zza2);
            }
            i13 = (int) zzwq.zzd();
            if (!z11) {
                ((zzwk) zzwq).zzo(i13, false);
            }
            i12 = 0;
        } else {
            i13 = 0;
            i12 = 0;
        }
        int i14 = i12;
        int i15 = i14;
        while (true) {
            if (!zzj(zzwq)) {
                this.zzc.zzF(0);
                int zze2 = this.zzc.zze();
                if ((i12 == 0 || zzi(zze2, (long) i12)) && (zzb2 = zzxk.zzb(zze2)) != -1) {
                    i14++;
                    if (i14 != 1) {
                        if (i14 == 4) {
                            break;
                        }
                    } else {
                        this.zzd.zza(zze2);
                        i12 = zze2;
                    }
                    ((zzwk) zzwq).zzl(zzb2 - 4, false);
                } else {
                    int i16 = i15 + 1;
                    if (i15 != i11) {
                        if (z11) {
                            zzwq.zzj();
                            ((zzwk) zzwq).zzl(i13 + i16, false);
                        } else {
                            ((zzwk) zzwq).zzo(1, false);
                        }
                        i14 = 0;
                        i15 = i16;
                        i12 = 0;
                    } else if (z11) {
                        return false;
                    } else {
                        throw zzbj.zza("Searched too many bytes.", (Throwable) null);
                    }
                }
            } else if (i14 <= 0) {
                throw new EOFException();
            }
        }
        if (z11) {
            ((zzwk) zzwq).zzo(i13 + i15, false);
        } else {
            zzwq.zzj();
        }
        this.zzk = i12;
        return true;
    }

    public final int zza(zzwq zzwq, zzxm zzxm) throws IOException {
        zzdy.zzb(this.zzi);
        int i11 = zzfn.zza;
        int zzf2 = zzf(zzwq);
        if (zzf2 == -1 && (this.zzq instanceof zzabc)) {
            if (this.zzq.zze() != zzg(this.zzn)) {
                zzabc zzabc = (zzabc) this.zzq;
                throw null;
            }
        }
        return zzf2;
    }

    public final void zzb(zzws zzws) {
        this.zzh = zzws;
        zzxt zzv = zzws.zzv(0, 1);
        this.zzi = zzv;
        this.zzj = zzv;
        this.zzh.zzB();
    }

    public final void zzc(long j11, long j12) {
        this.zzk = 0;
        this.zzm = C.TIME_UNSET;
        this.zzn = 0;
        this.zzp = 0;
        zzabi zzabi = this.zzq;
        if (zzabi instanceof zzabc) {
            zzabc zzabc = (zzabc) zzabi;
            throw null;
        }
    }

    public final boolean zzd(zzwq zzwq) throws IOException {
        return zzk(zzwq, true);
    }

    public final void zze() {
        this.zzr = true;
    }

    public zzabg(int i11) {
        this.zzc = new zzfd(10);
        this.zzd = new zzxj();
        this.zze = new zzxf();
        this.zzm = C.TIME_UNSET;
        this.zzf = new zzxh();
        zzwo zzwo = new zzwo();
        this.zzg = zzwo;
        this.zzj = zzwo;
    }
}

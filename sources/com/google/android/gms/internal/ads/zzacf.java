package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public final class zzacf implements zzwp, zzxp {
    public static final zzww zza = zzacc.zza;
    private final zzfd zzb;
    private final zzfd zzc;
    private final zzfd zzd;
    private final zzfd zze;
    private final ArrayDeque<zzabl> zzf;
    private final zzaci zzg;
    private final List<zzdc> zzh;
    private int zzi;
    private int zzj;
    private long zzk;
    private int zzl;
    @Nullable
    private zzfd zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private int zzq;
    private zzws zzr;
    private zzace[] zzs;
    private long[][] zzt;
    private int zzu;
    private long zzv;
    private int zzw;
    @Nullable
    private zzaak zzx;

    public zzacf() {
        this(0);
    }

    private static int zzf(int i11) {
        if (i11 != 1751476579) {
            return i11 != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    private static int zzi(zzacn zzacn, long j11) {
        int zza2 = zzacn.zza(j11);
        if (zza2 == -1) {
            return zzacn.zzb(j11);
        }
        return zza2;
    }

    private static long zzj(zzacn zzacn, long j11, long j12) {
        int zzi2 = zzi(zzacn, j11);
        if (zzi2 == -1) {
            return j12;
        }
        return Math.min(zzacn.zzc[zzi2], j12);
    }

    private final void zzk() {
        this.zzi = 0;
        this.zzl = 0;
    }

    private final void zzl(long j11) throws zzbj {
        zzacf zzacf;
        boolean z11;
        zzdd zzdd;
        zzdd zzdd2;
        zzdd zzdd3;
        long j12;
        int i11;
        List<zzacn> list;
        zzacf zzacf2;
        zzdd zzdd4;
        char c11;
        int i12;
        zzacf zzacf3 = this;
        while (!zzacf3.zzf.isEmpty() && zzacf3.zzf.peek().zza == j11) {
            zzabl pop = zzacf3.zzf.pop();
            if (pop.zzd == 1836019574) {
                ArrayList arrayList = new ArrayList();
                if (zzacf3.zzw == 1) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                zzxf zzxf = new zzxf();
                zzabm zzb2 = pop.zzb(Atom.TYPE_udta);
                if (zzb2 != null) {
                    Pair<zzdd, zzdd> zza2 = zzabu.zza(zzb2);
                    zzdd zzdd5 = (zzdd) zza2.first;
                    zzdd zzdd6 = (zzdd) zza2.second;
                    if (zzdd5 != null) {
                        zzxf.zzb(zzdd5);
                    }
                    zzdd2 = zzdd6;
                    zzdd = zzdd5;
                } else {
                    zzdd2 = null;
                    zzdd = null;
                }
                zzabl zza3 = pop.zza(Atom.TYPE_meta);
                if (zza3 != null) {
                    zzdd3 = zzabu.zzb(zza3);
                } else {
                    zzdd3 = null;
                }
                zzdd zzdd7 = zzdd3;
                List<zzacn> zzc2 = zzabu.zzc(pop, zzxf, C.TIME_UNSET, (zzs) null, false, z11, zzacd.zza);
                zzws zzws = zzacf3.zzr;
                zzws.getClass();
                int size = zzc2.size();
                long j13 = C.TIME_UNSET;
                long j14 = -9223372036854775807L;
                int i13 = 0;
                int i14 = -1;
                while (true) {
                    j12 = 0;
                    if (i13 >= size) {
                        break;
                    }
                    zzacn zzacn = zzc2.get(i13);
                    if (zzacn.zzb == 0) {
                        zzacf2 = zzacf3;
                        list = zzc2;
                        i11 = size;
                    } else {
                        zzack zzack = zzacn.zza;
                        ArrayList arrayList2 = arrayList;
                        long j15 = zzack.zze;
                        if (j15 == j13) {
                            j15 = zzacn.zzh;
                        }
                        long max = Math.max(j14, j15);
                        zzace zzace = new zzace(zzack, zzacn, zzws.zzv(i13, zzack.zzb));
                        int i15 = zzacn.zze;
                        list = zzc2;
                        zzz zzb3 = zzack.zzf.zzb();
                        zzb3.zzL(i15 + 30);
                        i11 = size;
                        if (zzack.zzb == 2 && j15 > 0 && (i12 = zzacn.zzb) > 1) {
                            zzb3.zzE(((float) i12) / (((float) j15) / 1000000.0f));
                        }
                        int i16 = zzack.zzb;
                        int i17 = zzacb.zzb;
                        if (i16 == 1 && zzxf.zza()) {
                            zzb3.zzC(zzxf.zza);
                            zzb3.zzD(zzxf.zzb);
                        }
                        int i18 = zzack.zzb;
                        zzdd[] zzddArr = new zzdd[2];
                        zzddArr[0] = zzdd2;
                        zzacf2 = this;
                        if (zzacf2.zzh.isEmpty()) {
                            c11 = 1;
                            zzdd4 = null;
                        } else {
                            zzdd4 = new zzdd((List<? extends zzdc>) zzacf2.zzh);
                            c11 = 1;
                        }
                        zzddArr[c11] = zzdd4;
                        long j16 = max;
                        zzdd zzdd8 = new zzdd(new zzdc[0]);
                        if (i18 == 1) {
                            if (zzdd != null) {
                                zzdd8 = zzdd;
                            }
                        } else if (i18 == 2 && zzdd7 != null) {
                            int i19 = 0;
                            while (true) {
                                if (i19 >= zzdd7.zza()) {
                                    break;
                                }
                                zzdc zzb4 = zzdd7.zzb(i19);
                                if (zzb4 instanceof zzaah) {
                                    zzaah zzaah = (zzaah) zzb4;
                                    if (MdtaMetadataEntry.KEY_ANDROID_CAPTURE_FPS.equals(zzaah.zza)) {
                                        zzdd8 = new zzdd(zzaah);
                                        break;
                                    }
                                }
                                i19++;
                            }
                        }
                        for (int i21 = 0; i21 < 2; i21++) {
                            zzdd8 = zzdd8.zzd(zzddArr[i21]);
                        }
                        if (zzdd8.zza() > 0) {
                            zzb3.zzM(zzdd8);
                        }
                        zzace.zzc.zzk(zzb3.zzY());
                        if (zzack.zzb == 2) {
                            if (i14 == -1) {
                                i14 = arrayList2.size();
                            }
                        }
                        arrayList = arrayList2;
                        arrayList.add(zzace);
                        j14 = j16;
                    }
                    i13++;
                    zzacf3 = zzacf2;
                    zzc2 = list;
                    size = i11;
                    j13 = C.TIME_UNSET;
                }
                zzacf = zzacf3;
                zzacf.zzu = i14;
                zzacf.zzv = j14;
                zzace[] zzaceArr = (zzace[]) arrayList.toArray(new zzace[0]);
                zzacf.zzs = zzaceArr;
                int length = zzaceArr.length;
                long[][] jArr = new long[length][];
                int[] iArr = new int[length];
                long[] jArr2 = new long[length];
                boolean[] zArr = new boolean[length];
                for (int i22 = 0; i22 < zzaceArr.length; i22++) {
                    jArr[i22] = new long[zzaceArr[i22].zzb.zzb];
                    jArr2[i22] = zzaceArr[i22].zzb.zzf[0];
                }
                int i23 = 0;
                while (i23 < zzaceArr.length) {
                    long j17 = Long.MAX_VALUE;
                    int i24 = -1;
                    for (int i25 = 0; i25 < zzaceArr.length; i25++) {
                        if (!zArr[i25]) {
                            long j18 = jArr2[i25];
                            if (j18 <= j17) {
                                i24 = i25;
                                j17 = j18;
                            }
                        }
                    }
                    int i26 = iArr[i24];
                    long[] jArr3 = jArr[i24];
                    jArr3[i26] = j12;
                    zzacn zzacn2 = zzaceArr[i24].zzb;
                    j12 += (long) zzacn2.zzd[i26];
                    int i27 = i26 + 1;
                    iArr[i24] = i27;
                    if (i27 < jArr3.length) {
                        jArr2[i24] = zzacn2.zzf[i27];
                    } else {
                        zArr[i24] = true;
                        i23++;
                    }
                }
                zzacf.zzt = jArr;
                zzws.zzB();
                zzws.zzL(zzacf);
                zzacf.zzf.clear();
                zzacf.zzi = 2;
            } else {
                zzacf = zzacf3;
                if (!zzacf.zzf.isEmpty()) {
                    zzacf.zzf.peek().zzc(pop);
                }
            }
            zzacf3 = zzacf;
        }
        if (zzacf3.zzi != 2) {
            zzk();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:202:0x0089 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0084  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzwq r33, com.google.android.gms.internal.ads.zzxm r34) throws java.io.IOException {
        /*
            r32 = this;
            r0 = r32
            r1 = r33
            r2 = r34
        L_0x0006:
            int r3 = r0.zzi
            r5 = 1718909296(0x66747970, float:2.8862439E23)
            r6 = 0
            r8 = -1
            r9 = 8
            r10 = 1
            if (r3 == 0) goto L_0x0234
            r13 = 262144(0x40000, double:1.295163E-318)
            if (r3 == r10) goto L_0x01b8
            long r16 = r33.zze()
            int r3 = r0.zzn
            if (r3 != r8) goto L_0x00a4
            r18 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r5 = r8
            r27 = r5
            r9 = r10
            r24 = r9
            r20 = r18
            r22 = r20
            r25 = r22
            r3 = 0
        L_0x0032:
            com.google.android.gms.internal.ads.zzace[] r4 = r0.zzs
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzfn.zzC(r4)
            com.google.android.gms.internal.ads.zzace[] r4 = (com.google.android.gms.internal.ads.zzace[]) r4
            int r4 = r4.length
            if (r3 >= r4) goto L_0x008c
            com.google.android.gms.internal.ads.zzace[] r4 = r0.zzs
            r4 = r4[r3]
            int r15 = r4.zzd
            com.google.android.gms.internal.ads.zzacn r4 = r4.zzb
            int r12 = r4.zzb
            if (r15 != r12) goto L_0x004a
            goto L_0x0089
        L_0x004a:
            long[] r4 = r4.zzc
            r28 = r4[r15]
            long[][] r4 = r0.zzt
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzfn.zzC(r4)
            long[][] r4 = (long[][]) r4
            r4 = r4[r3]
            r30 = r4[r15]
            long r28 = r28 - r16
            int r4 = (r28 > r6 ? 1 : (r28 == r6 ? 0 : -1))
            if (r4 < 0) goto L_0x0067
            int r4 = (r28 > r13 ? 1 : (r28 == r13 ? 0 : -1))
            if (r4 < 0) goto L_0x0065
            goto L_0x0067
        L_0x0065:
            r4 = 0
            goto L_0x0068
        L_0x0067:
            r4 = r10
        L_0x0068:
            if (r4 != 0) goto L_0x006e
            if (r24 != 0) goto L_0x0076
            r12 = 0
            goto L_0x0070
        L_0x006e:
            r12 = r24
        L_0x0070:
            if (r4 != r12) goto L_0x007e
            int r15 = (r28 > r22 ? 1 : (r28 == r22 ? 0 : -1))
            if (r15 >= 0) goto L_0x007e
        L_0x0076:
            r5 = r3
            r24 = r4
            r22 = r28
            r25 = r30
            goto L_0x0080
        L_0x007e:
            r24 = r12
        L_0x0080:
            int r12 = (r30 > r20 ? 1 : (r30 == r20 ? 0 : -1))
            if (r12 >= 0) goto L_0x0089
            r27 = r3
            r9 = r4
            r20 = r30
        L_0x0089:
            int r3 = r3 + 1
            goto L_0x0032
        L_0x008c:
            int r3 = (r20 > r18 ? 1 : (r20 == r18 ? 0 : -1))
            if (r3 == 0) goto L_0x009e
            if (r9 == 0) goto L_0x009e
            r3 = 10485760(0xa00000, double:5.180654E-317)
            long r20 = r20 + r3
            int r3 = (r25 > r20 ? 1 : (r25 == r20 ? 0 : -1))
            if (r3 >= 0) goto L_0x009c
            goto L_0x009e
        L_0x009c:
            r5 = r27
        L_0x009e:
            r0.zzn = r5
            if (r5 != r8) goto L_0x00a4
            goto L_0x01b7
        L_0x00a4:
            com.google.android.gms.internal.ads.zzace[] r3 = r0.zzs
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzfn.zzC(r3)
            com.google.android.gms.internal.ads.zzace[] r3 = (com.google.android.gms.internal.ads.zzace[]) r3
            int r4 = r0.zzn
            r3 = r3[r4]
            com.google.android.gms.internal.ads.zzxt r4 = r3.zzc
            int r5 = r3.zzd
            com.google.android.gms.internal.ads.zzacn r9 = r3.zzb
            long[] r12 = r9.zzc
            r11 = r12[r5]
            int[] r9 = r9.zzd
            r9 = r9[r5]
            long r16 = r11 - r16
            int r15 = r0.zzo
            r19 = r9
            long r8 = (long) r15
            long r16 = r16 + r8
            int r6 = (r16 > r6 ? 1 : (r16 == r6 ? 0 : -1))
            if (r6 < 0) goto L_0x01b4
            int r6 = (r16 > r13 ? 1 : (r16 == r13 ? 0 : -1))
            if (r6 < 0) goto L_0x00d1
            goto L_0x01b4
        L_0x00d1:
            com.google.android.gms.internal.ads.zzack r2 = r3.zza
            int r2 = r2.zzg
            if (r2 != r10) goto L_0x00e0
            r6 = 8
            long r16 = r16 + r6
            int r9 = r19 + -8
            r6 = r16
            goto L_0x00e4
        L_0x00e0:
            r6 = r16
            r9 = r19
        L_0x00e4:
            int r2 = (int) r6
            r1.zzk(r2)
            com.google.android.gms.internal.ads.zzack r2 = r3.zza
            int r6 = r2.zzj
            if (r6 == 0) goto L_0x0151
            com.google.android.gms.internal.ads.zzfd r2 = r0.zzc
            byte[] r2 = r2.zzH()
            r6 = 0
            r2[r6] = r6
            r2[r10] = r6
            r7 = 2
            r2[r7] = r6
            com.google.android.gms.internal.ads.zzack r6 = r3.zza
            int r6 = r6.zzj
            int r7 = 4 - r6
        L_0x0102:
            int r8 = r0.zzp
            if (r8 >= r9) goto L_0x018e
            int r8 = r0.zzq
            if (r8 != 0) goto L_0x013c
            r1.zzi(r2, r7, r6)
            int r8 = r0.zzo
            int r8 = r8 + r6
            r0.zzo = r8
            com.google.android.gms.internal.ads.zzfd r8 = r0.zzc
            r11 = 0
            r8.zzF(r11)
            com.google.android.gms.internal.ads.zzfd r8 = r0.zzc
            int r8 = r8.zze()
            if (r8 < 0) goto L_0x0134
            r0.zzq = r8
            com.google.android.gms.internal.ads.zzfd r8 = r0.zzb
            r8.zzF(r11)
            com.google.android.gms.internal.ads.zzfd r8 = r0.zzb
            r12 = 4
            com.google.android.gms.internal.ads.zzxr.zzb(r4, r8, r12)
            int r8 = r0.zzp
            int r8 = r8 + r12
            r0.zzp = r8
            int r9 = r9 + r7
            goto L_0x0102
        L_0x0134:
            java.lang.String r1 = "Invalid NAL length"
            r2 = 0
            com.google.android.gms.internal.ads.zzbj r1 = com.google.android.gms.internal.ads.zzbj.zza(r1, r2)
            throw r1
        L_0x013c:
            r11 = 0
            int r8 = com.google.android.gms.internal.ads.zzxr.zza(r4, r1, r8, r11)
            int r11 = r0.zzo
            int r11 = r11 + r8
            r0.zzo = r11
            int r11 = r0.zzp
            int r11 = r11 + r8
            r0.zzp = r11
            int r11 = r0.zzq
            int r11 = r11 - r8
            r0.zzq = r11
            goto L_0x0102
        L_0x0151:
            com.google.android.gms.internal.ads.zzab r2 = r2.zzf
            java.lang.String r2 = r2.zzm
            java.lang.String r6 = "audio/ac4"
            boolean r2 = r6.equals(r2)
            if (r2 == 0) goto L_0x0173
            int r2 = r0.zzp
            if (r2 != 0) goto L_0x0171
            com.google.android.gms.internal.ads.zzfd r2 = r0.zzd
            com.google.android.gms.internal.ads.zzvy.zzb(r9, r2)
            com.google.android.gms.internal.ads.zzfd r2 = r0.zzd
            r6 = 7
            com.google.android.gms.internal.ads.zzxr.zzb(r4, r2, r6)
            int r2 = r0.zzp
            int r2 = r2 + r6
            r0.zzp = r2
        L_0x0171:
            int r9 = r9 + 7
        L_0x0173:
            int r2 = r0.zzp
            if (r2 >= r9) goto L_0x018e
            int r2 = r9 - r2
            r6 = 0
            int r2 = com.google.android.gms.internal.ads.zzxr.zza(r4, r1, r2, r6)
            int r6 = r0.zzo
            int r6 = r6 + r2
            r0.zzo = r6
            int r6 = r0.zzp
            int r6 = r6 + r2
            r0.zzp = r6
            int r6 = r0.zzq
            int r6 = r6 - r2
            r0.zzq = r6
            goto L_0x0173
        L_0x018e:
            r22 = r9
            com.google.android.gms.internal.ads.zzacn r1 = r3.zzb
            long[] r2 = r1.zzf
            r19 = r2[r5]
            int[] r1 = r1.zzg
            r21 = r1[r5]
            r23 = 0
            r24 = 0
            r18 = r4
            r18.zzs(r19, r21, r22, r23, r24)
            int r1 = r3.zzd
            int r1 = r1 + r10
            r3.zzd = r1
            r1 = -1
            r0.zzn = r1
            r1 = 0
            r0.zzo = r1
            r0.zzp = r1
            r0.zzq = r1
            r8 = 0
            goto L_0x01b7
        L_0x01b4:
            r2.zza = r11
            r8 = r10
        L_0x01b7:
            return r8
        L_0x01b8:
            long r3 = r0.zzk
            int r6 = r0.zzl
            long r6 = (long) r6
            long r3 = r3 - r6
            long r6 = r33.zze()
            long r6 = r6 + r3
            com.google.android.gms.internal.ads.zzfd r8 = r0.zzm
            if (r8 == 0) goto L_0x0217
            byte[] r11 = r8.zzH()
            int r12 = r0.zzl
            int r3 = (int) r3
            r1.zzi(r11, r12, r3)
            int r3 = r0.zzj
            if (r3 != r5) goto L_0x01fc
            r8.zzF(r9)
            int r3 = r8.zze()
            int r3 = zzf(r3)
            if (r3 == 0) goto L_0x01e3
            goto L_0x01f9
        L_0x01e3:
            r3 = 4
            r8.zzG(r3)
        L_0x01e7:
            int r3 = r8.zza()
            if (r3 <= 0) goto L_0x01f8
            int r3 = r8.zze()
            int r3 = zzf(r3)
            if (r3 == 0) goto L_0x01e7
            goto L_0x01f9
        L_0x01f8:
            r3 = 0
        L_0x01f9:
            r0.zzw = r3
            goto L_0x021f
        L_0x01fc:
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzabl> r3 = r0.zzf
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x021f
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzabl> r3 = r0.zzf
            java.lang.Object r3 = r3.peek()
            com.google.android.gms.internal.ads.zzabl r3 = (com.google.android.gms.internal.ads.zzabl) r3
            com.google.android.gms.internal.ads.zzabm r4 = new com.google.android.gms.internal.ads.zzabm
            int r5 = r0.zzj
            r4.<init>(r5, r8)
            r3.zzd(r4)
            goto L_0x021f
        L_0x0217:
            int r5 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r5 >= 0) goto L_0x0221
            int r3 = (int) r3
            r1.zzk(r3)
        L_0x021f:
            r11 = 0
            goto L_0x0229
        L_0x0221:
            long r8 = r33.zze()
            long r8 = r8 + r3
            r2.zza = r8
            r11 = r10
        L_0x0229:
            r0.zzl(r6)
            if (r11 == 0) goto L_0x0006
            int r3 = r0.zzi
            r4 = 2
            if (r3 == r4) goto L_0x0006
            return r10
        L_0x0234:
            int r3 = r0.zzl
            if (r3 != 0) goto L_0x025e
            com.google.android.gms.internal.ads.zzfd r3 = r0.zze
            byte[] r3 = r3.zzH()
            r4 = 0
            boolean r3 = r1.zzn(r3, r4, r9, r10)
            if (r3 != 0) goto L_0x0247
            r3 = -1
            return r3
        L_0x0247:
            r0.zzl = r9
            com.google.android.gms.internal.ads.zzfd r3 = r0.zze
            r3.zzF(r4)
            com.google.android.gms.internal.ads.zzfd r3 = r0.zze
            long r3 = r3.zzs()
            r0.zzk = r3
            com.google.android.gms.internal.ads.zzfd r3 = r0.zze
            int r3 = r3.zze()
            r0.zzj = r3
        L_0x025e:
            long r3 = r0.zzk
            r11 = 1
            int r8 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r8 != 0) goto L_0x027d
            com.google.android.gms.internal.ads.zzfd r3 = r0.zze
            byte[] r3 = r3.zzH()
            r1.zzi(r3, r9, r9)
            int r3 = r0.zzl
            int r3 = r3 + r9
            r0.zzl = r3
            com.google.android.gms.internal.ads.zzfd r3 = r0.zze
            long r3 = r3.zzt()
            r0.zzk = r3
            goto L_0x02a6
        L_0x027d:
            int r3 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x02a6
            long r3 = r33.zzc()
            r6 = -1
            int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x0297
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzabl> r8 = r0.zzf
            java.lang.Object r8 = r8.peek()
            com.google.android.gms.internal.ads.zzabl r8 = (com.google.android.gms.internal.ads.zzabl) r8
            if (r8 == 0) goto L_0x0297
            long r3 = r8.zza
        L_0x0297:
            int r6 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r6 == 0) goto L_0x02a6
            long r6 = r33.zze()
            long r3 = r3 - r6
            int r6 = r0.zzl
            long r6 = (long) r6
            long r3 = r3 + r6
            r0.zzk = r3
        L_0x02a6:
            long r3 = r0.zzk
            int r6 = r0.zzl
            long r7 = (long) r6
            int r3 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r3 < 0) goto L_0x03df
            int r3 = r0.zzj
            r4 = 1836019574(0x6d6f6f76, float:4.631354E27)
            r7 = 1835365473(0x6d657461, float:4.4382975E27)
            if (r3 == r4) goto L_0x038d
            r4 = 1953653099(0x7472616b, float:7.681346E31)
            if (r3 == r4) goto L_0x038d
            r4 = 1835297121(0x6d646961, float:4.4181236E27)
            if (r3 == r4) goto L_0x038d
            r4 = 1835626086(0x6d696e66, float:4.515217E27)
            if (r3 == r4) goto L_0x038d
            r4 = 1937007212(0x7374626c, float:1.9362132E31)
            if (r3 == r4) goto L_0x038d
            r4 = 1701082227(0x65647473, float:6.742798E22)
            if (r3 == r4) goto L_0x038d
            if (r3 != r7) goto L_0x02d6
            goto L_0x038d
        L_0x02d6:
            r4 = 1835296868(0x6d646864, float:4.418049E27)
            if (r3 == r4) goto L_0x035a
            r4 = 1836476516(0x6d766864, float:4.7662196E27)
            if (r3 == r4) goto L_0x035a
            r4 = 1751411826(0x68646c72, float:4.3148E24)
            if (r3 == r4) goto L_0x035a
            r4 = 1937011556(0x73747364, float:1.9367383E31)
            if (r3 == r4) goto L_0x035a
            r4 = 1937011827(0x73747473, float:1.9367711E31)
            if (r3 == r4) goto L_0x035a
            r4 = 1937011571(0x73747373, float:1.9367401E31)
            if (r3 == r4) goto L_0x035a
            r4 = 1668576371(0x63747473, float:4.5093966E21)
            if (r3 == r4) goto L_0x035a
            r4 = 1701606260(0x656c7374, float:6.9788014E22)
            if (r3 == r4) goto L_0x035a
            r4 = 1937011555(0x73747363, float:1.9367382E31)
            if (r3 == r4) goto L_0x035a
            r4 = 1937011578(0x7374737a, float:1.936741E31)
            if (r3 == r4) goto L_0x035a
            r4 = 1937013298(0x73747a32, float:1.9369489E31)
            if (r3 == r4) goto L_0x035a
            r4 = 1937007471(0x7374636f, float:1.9362445E31)
            if (r3 == r4) goto L_0x035a
            r4 = 1668232756(0x636f3634, float:4.4126776E21)
            if (r3 == r4) goto L_0x035a
            r4 = 1953196132(0x746b6864, float:7.46037E31)
            if (r3 == r4) goto L_0x035a
            if (r3 == r5) goto L_0x035a
            r4 = 1969517665(0x75647461, float:2.8960062E32)
            if (r3 == r4) goto L_0x035a
            r4 = 1801812339(0x6b657973, float:2.7741754E26)
            if (r3 == r4) goto L_0x035a
            r4 = 1768715124(0x696c7374, float:1.7865732E25)
            if (r3 != r4) goto L_0x032e
            goto L_0x035a
        L_0x032e:
            long r3 = r33.zze()
            int r5 = r0.zzl
            long r5 = (long) r5
            long r14 = r3 - r5
            int r3 = r0.zzj
            r4 = 1836086884(0x6d707664, float:4.6512205E27)
            if (r3 != r4) goto L_0x0353
            com.google.android.gms.internal.ads.zzaak r3 = new com.google.android.gms.internal.ads.zzaak
            r12 = 0
            r16 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            long r18 = r14 + r5
            long r7 = r0.zzk
            long r20 = r7 - r5
            r11 = r3
            r11.<init>(r12, r14, r16, r18, r20)
            r0.zzx = r3
        L_0x0353:
            r3 = 0
            r0.zzm = r3
            r0.zzi = r10
            goto L_0x0006
        L_0x035a:
            if (r6 != r9) goto L_0x035e
            r3 = r10
            goto L_0x035f
        L_0x035e:
            r3 = 0
        L_0x035f:
            com.google.android.gms.internal.ads.zzdy.zzf(r3)
            long r3 = r0.zzk
            r5 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 > 0) goto L_0x036d
            r3 = r10
            goto L_0x036e
        L_0x036d:
            r3 = 0
        L_0x036e:
            com.google.android.gms.internal.ads.zzdy.zzf(r3)
            com.google.android.gms.internal.ads.zzfd r3 = new com.google.android.gms.internal.ads.zzfd
            long r4 = r0.zzk
            int r4 = (int) r4
            r3.<init>((int) r4)
            com.google.android.gms.internal.ads.zzfd r4 = r0.zze
            byte[] r4 = r4.zzH()
            byte[] r5 = r3.zzH()
            r6 = 0
            java.lang.System.arraycopy(r4, r6, r5, r6, r9)
            r0.zzm = r3
            r0.zzi = r10
            goto L_0x0006
        L_0x038d:
            long r3 = r33.zze()
            long r5 = r0.zzk
            int r8 = r0.zzl
            long r10 = (long) r8
            long r3 = r3 + r5
            long r3 = r3 - r10
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 == 0) goto L_0x03c0
            int r5 = r0.zzj
            if (r5 != r7) goto L_0x03c0
            com.google.android.gms.internal.ads.zzfd r5 = r0.zzd
            r5.zzC(r9)
            com.google.android.gms.internal.ads.zzfd r5 = r0.zzd
            byte[] r5 = r5.zzH()
            r6 = 0
            r1.zzh(r5, r6, r9)
            com.google.android.gms.internal.ads.zzfd r5 = r0.zzd
            com.google.android.gms.internal.ads.zzabu.zzd(r5)
            com.google.android.gms.internal.ads.zzfd r5 = r0.zzd
            int r5 = r5.zzc()
            r1.zzk(r5)
            r33.zzj()
        L_0x03c0:
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzabl> r5 = r0.zzf
            com.google.android.gms.internal.ads.zzabl r6 = new com.google.android.gms.internal.ads.zzabl
            int r7 = r0.zzj
            r6.<init>(r7, r3)
            r5.push(r6)
            long r5 = r0.zzk
            int r7 = r0.zzl
            long r7 = (long) r7
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 != 0) goto L_0x03da
            r0.zzl(r3)
            goto L_0x0006
        L_0x03da:
            r32.zzk()
            goto L_0x0006
        L_0x03df:
            java.lang.String r1 = "Atom size less than header length (unsupported)."
            com.google.android.gms.internal.ads.zzbj r1 = com.google.android.gms.internal.ads.zzbj.zzc(r1)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacf.zza(com.google.android.gms.internal.ads.zzwq, com.google.android.gms.internal.ads.zzxm):int");
    }

    public final void zzb(zzws zzws) {
        this.zzr = zzws;
    }

    public final void zzc(long j11, long j12) {
        this.zzf.clear();
        this.zzl = 0;
        this.zzn = -1;
        this.zzo = 0;
        this.zzp = 0;
        this.zzq = 0;
        if (j11 == 0) {
            zzk();
            return;
        }
        zzace[] zzaceArr = this.zzs;
        if (zzaceArr != null) {
            for (zzace zzace : zzaceArr) {
                zzacn zzacn = zzace.zzb;
                int zza2 = zzacn.zza(j12);
                if (zza2 == -1) {
                    zza2 = zzacn.zzb(j12);
                }
                zzace.zzd = zza2;
            }
        }
    }

    public final boolean zzd(zzwq zzwq) throws IOException {
        return zzacj.zzb(zzwq, false);
    }

    public final long zze() {
        return this.zzv;
    }

    public final zzxn zzg(long j11) {
        long j12;
        long j13;
        int zzb2;
        zzace[] zzaceArr = this.zzs;
        zzaceArr.getClass();
        if (zzaceArr.length == 0) {
            zzxq zzxq = zzxq.zza;
            return new zzxn(zzxq, zzxq);
        }
        int i11 = this.zzu;
        long j14 = -1;
        if (i11 != -1) {
            zzacn zzacn = zzaceArr[i11].zzb;
            int zzi2 = zzi(zzacn, j11);
            if (zzi2 == -1) {
                zzxq zzxq2 = zzxq.zza;
                return new zzxn(zzxq2, zzxq2);
            }
            long j15 = zzacn.zzf[zzi2];
            j12 = zzacn.zzc[zzi2];
            if (j15 >= j11 || zzi2 >= zzacn.zzb - 1 || (zzb2 = zzacn.zzb(j11)) == -1 || zzb2 == zzi2) {
                j13 = -9223372036854775807L;
            } else {
                j13 = zzacn.zzf[zzb2];
                j14 = zzacn.zzc[zzb2];
            }
            j11 = j15;
        } else {
            j12 = Long.MAX_VALUE;
            j13 = -9223372036854775807L;
        }
        int i12 = 0;
        while (true) {
            zzace[] zzaceArr2 = this.zzs;
            if (i12 >= zzaceArr2.length) {
                break;
            }
            if (i12 != this.zzu) {
                zzacn zzacn2 = zzaceArr2[i12].zzb;
                long zzj2 = zzj(zzacn2, j11, j12);
                if (j13 != C.TIME_UNSET) {
                    j14 = zzj(zzacn2, j13, j14);
                }
                j12 = zzj2;
            }
            i12++;
        }
        zzxq zzxq3 = new zzxq(j11, j12);
        if (j13 == C.TIME_UNSET) {
            return new zzxn(zzxq3, zzxq3);
        }
        return new zzxn(zzxq3, new zzxq(j13, j14));
    }

    public final boolean zzh() {
        return true;
    }

    public zzacf(int i11) {
        this.zzi = 0;
        this.zzg = new zzaci();
        this.zzh = new ArrayList();
        this.zze = new zzfd(16);
        this.zzf = new ArrayDeque<>();
        this.zzb = new zzfd(zzeu.zza);
        this.zzc = new zzfd(4);
        this.zzd = new zzfd();
        this.zzn = -1;
    }
}

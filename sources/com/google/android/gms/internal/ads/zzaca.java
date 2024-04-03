package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public final class zzaca implements zzwp {
    public static final zzww zza = zzabw.zza;
    private static final byte[] zzb = {-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final zzab zzc;
    private int zzA;
    private int zzB;
    private boolean zzC;
    private zzws zzD;
    private zzxt[] zzE;
    private zzxt[] zzF;
    private boolean zzG;
    private final List<zzab> zzd;
    private final SparseArray<zzabz> zze;
    private final zzfd zzf;
    private final zzfd zzg;
    private final zzfd zzh;
    private final byte[] zzi;
    private final zzfd zzj;
    private final zzyx zzk;
    private final zzfd zzl;
    private final ArrayDeque<zzabl> zzm;
    private final ArrayDeque<zzaby> zzn;
    private int zzo;
    private int zzp;
    private long zzq;
    private int zzr;
    @Nullable
    private zzfd zzs;
    private long zzt;
    private int zzu;
    private long zzv;
    private long zzw;
    private long zzx;
    @Nullable
    private zzabz zzy;
    private int zzz;

    static {
        zzz zzz2 = new zzz();
        zzz2.zzS(MimeTypes.APPLICATION_EMSG);
        zzc = zzz2.zzY();
    }

    public zzaca() {
        this(0, (zzfk) null);
    }

    private static int zze(int i11) throws zzbj {
        if (i11 >= 0) {
            return i11;
        }
        StringBuilder sb2 = new StringBuilder(38);
        sb2.append("Unexpected negative value: ");
        sb2.append(i11);
        throw zzbj.zza(sb2.toString(), (Throwable) null);
    }

    @Nullable
    private static zzs zzf(List<zzabm> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i11 = 0; i11 < size; i11++) {
            zzabm zzabm = list.get(i11);
            if (zzabm.zzd == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] zzH = zzabm.zza.zzH();
                UUID zza2 = zzach.zza(zzH);
                if (zza2 == null) {
                    Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new zzr(zza2, (String) null, MimeTypes.VIDEO_MP4, zzH));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new zzs((List<zzr>) arrayList);
    }

    private final void zzg() {
        this.zzo = 0;
        this.zzr = 0;
    }

    private static void zzh(zzfd zzfd, int i11, zzacm zzacm) throws zzbj {
        boolean z11;
        zzfd.zzF(i11 + 8);
        int zze2 = zzfd.zze() & 16777215;
        if ((zze2 & 1) == 0) {
            if ((zze2 & 2) != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            int zzn2 = zzfd.zzn();
            if (zzn2 == 0) {
                Arrays.fill(zzacm.zzm, 0, zzacm.zze, false);
                return;
            }
            int i12 = zzacm.zze;
            if (zzn2 == i12) {
                Arrays.fill(zzacm.zzm, 0, zzn2, z11);
                zzacm.zzb(zzfd.zza());
                zzfd.zzB(zzacm.zzo.zzH(), 0, zzacm.zzo.zzd());
                zzacm.zzo.zzF(0);
                zzacm.zzp = false;
                return;
            }
            StringBuilder sb2 = new StringBuilder(80);
            sb2.append("Senc sample count ");
            sb2.append(zzn2);
            sb2.append(" is different from fragment sample count");
            sb2.append(i12);
            throw zzbj.zza(sb2.toString(), (Throwable) null);
        }
        throw zzbj.zzc("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:108:0x032c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzi(long r48) throws com.google.android.gms.internal.ads.zzbj {
        /*
            r47 = this;
            r0 = r47
        L_0x0002:
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzabl> r1 = r0.zzm
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0702
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzabl> r1 = r0.zzm
            java.lang.Object r1 = r1.peek()
            com.google.android.gms.internal.ads.zzabl r1 = (com.google.android.gms.internal.ads.zzabl) r1
            long r1 = r1.zza
            int r1 = (r1 > r48 ? 1 : (r1 == r48 ? 0 : -1))
            if (r1 != 0) goto L_0x0702
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzabl> r1 = r0.zzm
            java.lang.Object r1 = r1.pop()
            r2 = r1
            com.google.android.gms.internal.ads.zzabl r2 = (com.google.android.gms.internal.ads.zzabl) r2
            int r1 = r2.zzd
            r3 = 1836019574(0x6d6f6f76, float:4.631354E27)
            r6 = 12
            r7 = 8
            if (r1 != r3) goto L_0x013d
            java.util.List<com.google.android.gms.internal.ads.zzabm> r1 = r2.zzb
            com.google.android.gms.internal.ads.zzs r1 = zzf(r1)
            r3 = 1836475768(0x6d766578, float:4.7659988E27)
            com.google.android.gms.internal.ads.zzabl r3 = r2.zza(r3)
            r3.getClass()
            android.util.SparseArray r12 = new android.util.SparseArray
            r12.<init>()
            java.util.List<com.google.android.gms.internal.ads.zzabm> r8 = r3.zzb
            int r8 = r8.size()
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r9 = 0
        L_0x004d:
            if (r9 >= r8) goto L_0x00b8
            java.util.List<com.google.android.gms.internal.ads.zzabm> r13 = r3.zzb
            java.lang.Object r13 = r13.get(r9)
            com.google.android.gms.internal.ads.zzabm r13 = (com.google.android.gms.internal.ads.zzabm) r13
            int r14 = r13.zzd
            r15 = 1953654136(0x74726578, float:7.6818474E31)
            if (r14 != r15) goto L_0x0096
            com.google.android.gms.internal.ads.zzfd r13 = r13.zza
            r13.zzF(r6)
            int r14 = r13.zze()
            int r15 = r13.zze()
            int r10 = r13.zze()
            int r6 = r13.zze()
            int r13 = r13.zze()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            com.google.android.gms.internal.ads.zzabv r11 = new com.google.android.gms.internal.ads.zzabv
            int r15 = r15 + -1
            r11.<init>(r15, r10, r6, r13)
            android.util.Pair r6 = android.util.Pair.create(r14, r11)
            java.lang.Object r10 = r6.first
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            java.lang.Object r6 = r6.second
            com.google.android.gms.internal.ads.zzabv r6 = (com.google.android.gms.internal.ads.zzabv) r6
            r12.put(r10, r6)
            goto L_0x00b3
        L_0x0096:
            r6 = 1835362404(0x6d656864, float:4.4373917E27)
            if (r14 != r6) goto L_0x00b3
            com.google.android.gms.internal.ads.zzfd r4 = r13.zza
            r4.zzF(r7)
            int r5 = r4.zze()
            int r5 = com.google.android.gms.internal.ads.zzabn.zze(r5)
            if (r5 != 0) goto L_0x00af
            long r4 = r4.zzs()
            goto L_0x00b3
        L_0x00af:
            long r4 = r4.zzt()
        L_0x00b3:
            int r9 = r9 + 1
            r6 = 12
            goto L_0x004d
        L_0x00b8:
            com.google.android.gms.internal.ads.zzxf r3 = new com.google.android.gms.internal.ads.zzxf
            r3.<init>()
            com.google.android.gms.internal.ads.zzabx r9 = new com.google.android.gms.internal.ads.zzabx
            r9.<init>(r0)
            r7 = 0
            r8 = 0
            r6 = r1
            java.util.List r1 = com.google.android.gms.internal.ads.zzabu.zzc(r2, r3, r4, r6, r7, r8, r9)
            int r2 = r1.size()
            android.util.SparseArray<com.google.android.gms.internal.ads.zzabz> r3 = r0.zze
            int r3 = r3.size()
            if (r3 != 0) goto L_0x010e
            r10 = 0
        L_0x00d6:
            if (r10 >= r2) goto L_0x0107
            java.lang.Object r3 = r1.get(r10)
            com.google.android.gms.internal.ads.zzacn r3 = (com.google.android.gms.internal.ads.zzacn) r3
            com.google.android.gms.internal.ads.zzack r4 = r3.zza
            com.google.android.gms.internal.ads.zzabz r5 = new com.google.android.gms.internal.ads.zzabz
            com.google.android.gms.internal.ads.zzws r6 = r0.zzD
            int r7 = r4.zzb
            com.google.android.gms.internal.ads.zzxt r6 = r6.zzv(r10, r7)
            int r7 = r4.zza
            com.google.android.gms.internal.ads.zzabv r7 = zzj(r12, r7)
            r5.<init>(r6, r3, r7)
            android.util.SparseArray<com.google.android.gms.internal.ads.zzabz> r3 = r0.zze
            int r6 = r4.zza
            r3.put(r6, r5)
            long r5 = r0.zzw
            long r3 = r4.zze
            long r3 = java.lang.Math.max(r5, r3)
            r0.zzw = r3
            int r10 = r10 + 1
            goto L_0x00d6
        L_0x0107:
            com.google.android.gms.internal.ads.zzws r1 = r0.zzD
            r1.zzB()
            goto L_0x0002
        L_0x010e:
            android.util.SparseArray<com.google.android.gms.internal.ads.zzabz> r3 = r0.zze
            int r3 = r3.size()
            if (r3 != r2) goto L_0x0118
            r11 = 1
            goto L_0x0119
        L_0x0118:
            r11 = 0
        L_0x0119:
            com.google.android.gms.internal.ads.zzdy.zzf(r11)
            r10 = 0
        L_0x011d:
            if (r10 >= r2) goto L_0x0002
            java.lang.Object r3 = r1.get(r10)
            com.google.android.gms.internal.ads.zzacn r3 = (com.google.android.gms.internal.ads.zzacn) r3
            com.google.android.gms.internal.ads.zzack r4 = r3.zza
            android.util.SparseArray<com.google.android.gms.internal.ads.zzabz> r5 = r0.zze
            int r6 = r4.zza
            java.lang.Object r5 = r5.get(r6)
            com.google.android.gms.internal.ads.zzabz r5 = (com.google.android.gms.internal.ads.zzabz) r5
            int r4 = r4.zza
            com.google.android.gms.internal.ads.zzabv r4 = zzj(r12, r4)
            r5.zzh(r3, r4)
            int r10 = r10 + 1
            goto L_0x011d
        L_0x013d:
            r3 = 1836019558(0x6d6f6f66, float:4.6313494E27)
            if (r1 != r3) goto L_0x06ea
            android.util.SparseArray<com.google.android.gms.internal.ads.zzabz> r1 = r0.zze
            byte[] r3 = r0.zzi
            java.util.List<com.google.android.gms.internal.ads.zzabl> r6 = r2.zzc
            int r6 = r6.size()
            r8 = 0
        L_0x014d:
            if (r8 >= r6) goto L_0x0653
            java.util.List<com.google.android.gms.internal.ads.zzabl> r10 = r2.zzc
            java.lang.Object r10 = r10.get(r8)
            com.google.android.gms.internal.ads.zzabl r10 = (com.google.android.gms.internal.ads.zzabl) r10
            int r11 = r10.zzd
            r12 = 1953653094(0x74726166, float:7.6813435E31)
            if (r11 != r12) goto L_0x0636
            r11 = 1952868452(0x74666864, float:7.301914E31)
            com.google.android.gms.internal.ads.zzabm r11 = r10.zzb(r11)
            r11.getClass()
            com.google.android.gms.internal.ads.zzfd r11 = r11.zza
            r11.zzF(r7)
            int r12 = r11.zze()
            r13 = 16777215(0xffffff, float:2.3509886E-38)
            r12 = r12 & r13
            int r14 = r11.zze()
            java.lang.Object r14 = r1.get(r14)
            com.google.android.gms.internal.ads.zzabz r14 = (com.google.android.gms.internal.ads.zzabz) r14
            if (r14 != 0) goto L_0x0183
            r14 = 0
            goto L_0x01cc
        L_0x0183:
            r15 = r12 & 1
            if (r15 == 0) goto L_0x0191
            long r4 = r11.zzt()
            com.google.android.gms.internal.ads.zzacm r15 = r14.zzb
            r15.zzb = r4
            r15.zzc = r4
        L_0x0191:
            com.google.android.gms.internal.ads.zzabv r4 = r14.zze
            r5 = r12 & 2
            if (r5 == 0) goto L_0x019e
            int r5 = r11.zze()
            int r5 = r5 + -1
            goto L_0x01a0
        L_0x019e:
            int r5 = r4.zza
        L_0x01a0:
            r15 = r12 & 8
            if (r15 == 0) goto L_0x01a9
            int r15 = r11.zze()
            goto L_0x01ab
        L_0x01a9:
            int r15 = r4.zzb
        L_0x01ab:
            r16 = r12 & 16
            if (r16 == 0) goto L_0x01b6
            int r16 = r11.zze()
            r9 = r16
            goto L_0x01b8
        L_0x01b6:
            int r9 = r4.zzc
        L_0x01b8:
            r12 = r12 & 32
            if (r12 == 0) goto L_0x01c1
            int r4 = r11.zze()
            goto L_0x01c3
        L_0x01c1:
            int r4 = r4.zzd
        L_0x01c3:
            com.google.android.gms.internal.ads.zzacm r11 = r14.zzb
            com.google.android.gms.internal.ads.zzabv r12 = new com.google.android.gms.internal.ads.zzabv
            r12.<init>(r5, r15, r9, r4)
            r11.zza = r12
        L_0x01cc:
            if (r14 != 0) goto L_0x01d0
            goto L_0x0636
        L_0x01d0:
            com.google.android.gms.internal.ads.zzacm r4 = r14.zzb
            long r11 = r4.zzq
            boolean r5 = r4.zzr
            r14.zzi()
            r9 = 1
            r14.zzl = true
            r15 = 1952867444(0x74666474, float:7.3014264E31)
            com.google.android.gms.internal.ads.zzabm r15 = r10.zzb(r15)
            if (r15 == 0) goto L_0x0203
            com.google.android.gms.internal.ads.zzfd r5 = r15.zza
            r5.zzF(r7)
            int r11 = r5.zze()
            int r11 = com.google.android.gms.internal.ads.zzabn.zze(r11)
            if (r11 != r9) goto L_0x01fa
            long r11 = r5.zzt()
            goto L_0x01fe
        L_0x01fa:
            long r11 = r5.zzs()
        L_0x01fe:
            r4.zzq = r11
            r4.zzr = r9
            goto L_0x0207
        L_0x0203:
            r4.zzq = r11
            r4.zzr = r5
        L_0x0207:
            java.util.List<com.google.android.gms.internal.ads.zzabm> r5 = r10.zzb
            int r9 = r5.size()
            r11 = 0
            r12 = 0
            r15 = 0
        L_0x0210:
            r13 = 1953658222(0x7472756e, float:7.683823E31)
            if (r11 >= r9) goto L_0x023a
            java.lang.Object r18 = r5.get(r11)
            r7 = r18
            com.google.android.gms.internal.ads.zzabm r7 = (com.google.android.gms.internal.ads.zzabm) r7
            r18 = r1
            int r1 = r7.zzd
            if (r1 != r13) goto L_0x0233
            com.google.android.gms.internal.ads.zzfd r1 = r7.zza
            r7 = 12
            r1.zzF(r7)
            int r1 = r1.zzn()
            if (r1 <= 0) goto L_0x0233
            int r15 = r15 + r1
            int r12 = r12 + 1
        L_0x0233:
            int r11 = r11 + 1
            r1 = r18
            r7 = 8
            goto L_0x0210
        L_0x023a:
            r18 = r1
            r1 = 0
            r14.zzh = r1
            r14.zzg = r1
            r14.zzf = r1
            com.google.android.gms.internal.ads.zzacm r1 = r14.zzb
            r1.zzd = r12
            r1.zze = r15
            int[] r7 = r1.zzg
            int r7 = r7.length
            if (r7 >= r12) goto L_0x0256
            long[] r7 = new long[r12]
            r1.zzf = r7
            int[] r7 = new int[r12]
            r1.zzg = r7
        L_0x0256:
            int[] r7 = r1.zzh
            int r7 = r7.length
            if (r7 >= r15) goto L_0x0273
            int r15 = r15 * 125
            int r15 = r15 / 100
            int[] r7 = new int[r15]
            r1.zzh = r7
            int[] r7 = new int[r15]
            r1.zzi = r7
            long[] r7 = new long[r15]
            r1.zzj = r7
            boolean[] r7 = new boolean[r15]
            r1.zzk = r7
            boolean[] r7 = new boolean[r15]
            r1.zzm = r7
        L_0x0273:
            r1 = 0
            r7 = 0
            r11 = 0
        L_0x0276:
            r19 = 0
            if (r1 >= r9) goto L_0x0404
            java.lang.Object r15 = r5.get(r1)
            com.google.android.gms.internal.ads.zzabm r15 = (com.google.android.gms.internal.ads.zzabm) r15
            int r12 = r15.zzd
            if (r12 != r13) goto L_0x03d3
            int r12 = r11 + 1
            com.google.android.gms.internal.ads.zzfd r15 = r15.zza
            r13 = 8
            r15.zzF(r13)
            int r13 = r15.zze()
            r17 = 16777215(0xffffff, float:2.3509886E-38)
            r13 = r13 & r17
            r21 = r5
            com.google.android.gms.internal.ads.zzacn r5 = r14.zzd
            com.google.android.gms.internal.ads.zzack r5 = r5.zza
            r22 = r6
            com.google.android.gms.internal.ads.zzacm r6 = r14.zzb
            r23 = r9
            com.google.android.gms.internal.ads.zzabv r9 = r6.zza
            int r24 = com.google.android.gms.internal.ads.zzfn.zza
            r24 = r12
            int[] r12 = r6.zzg
            int r25 = r15.zzn()
            r12[r11] = r25
            long[] r12 = r6.zzf
            r25 = r2
            r26 = r3
            long r2 = r6.zzb
            r12[r11] = r2
            r27 = r13 & 1
            if (r27 == 0) goto L_0x02c9
            int r0 = r15.zze()
            r27 = r1
            long r0 = (long) r0
            long r2 = r2 + r0
            r12[r11] = r2
            goto L_0x02cb
        L_0x02c9:
            r27 = r1
        L_0x02cb:
            r0 = r13 & 4
            int r1 = r9.zzd
            if (r0 == 0) goto L_0x02d5
            int r1 = r15.zze()
        L_0x02d5:
            r2 = r13 & 256(0x100, float:3.59E-43)
            r3 = r13 & 512(0x200, float:7.175E-43)
            r12 = r13 & 1024(0x400, float:1.435E-42)
            r13 = r13 & 2048(0x800, float:2.87E-42)
            r28 = r1
            long[] r1 = r5.zzh
            if (r1 == 0) goto L_0x030a
            r29 = r8
            int r8 = r1.length
            r30 = r10
            r10 = 1
            if (r8 != r10) goto L_0x030e
            r8 = 0
            r31 = r1[r8]
            int r1 = (r31 > r19 ? 1 : (r31 == r19 ? 0 : -1))
            if (r1 != 0) goto L_0x030e
            long[] r1 = r5.zzi
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzfn.zzC(r1)
            long[] r1 = (long[]) r1
            r31 = r1[r8]
            r33 = 1000000(0xf4240, double:4.940656E-318)
            r8 = r13
            r1 = r14
            long r13 = r5.zzc
            r35 = r13
            long r19 = com.google.android.gms.internal.ads.zzfn.zzt(r31, r33, r35)
            goto L_0x0310
        L_0x030a:
            r29 = r8
            r30 = r10
        L_0x030e:
            r8 = r13
            r1 = r14
        L_0x0310:
            int[] r10 = r6.zzh
            int[] r13 = r6.zzi
            long[] r14 = r6.zzj
            r31 = r4
            boolean[] r4 = r6.zzk
            r32 = r4
            int[] r4 = r6.zzg
            r4 = r4[r11]
            int r4 = r4 + r7
            r39 = r10
            long r10 = r5.zzc
            r5 = r13
            r40 = r14
            long r13 = r6.zzq
        L_0x032a:
            if (r7 >= r4) goto L_0x03ca
            if (r2 == 0) goto L_0x0337
            int r33 = r15.zze()
            r41 = r2
            r2 = r33
            goto L_0x033b
        L_0x0337:
            r41 = r2
            int r2 = r9.zzb
        L_0x033b:
            zze(r2)
            if (r3 == 0) goto L_0x0349
            int r33 = r15.zze()
            r42 = r3
            r3 = r33
            goto L_0x034d
        L_0x0349:
            r42 = r3
            int r3 = r9.zzc
        L_0x034d:
            zze(r3)
            if (r12 == 0) goto L_0x035b
            int r33 = r15.zze()
            r43 = r0
            r0 = r33
            goto L_0x0368
        L_0x035b:
            r43 = r0
            if (r7 != 0) goto L_0x0366
            if (r0 == 0) goto L_0x0365
            r0 = r28
            r7 = 0
            goto L_0x0368
        L_0x0365:
            r7 = 0
        L_0x0366:
            int r0 = r9.zzd
        L_0x0368:
            if (r8 == 0) goto L_0x037f
            r44 = r4
            int r4 = r15.zze()
            r46 = r8
            r45 = r9
            long r8 = (long) r4
            r33 = 1000000(0xf4240, double:4.940656E-318)
            long r8 = r8 * r33
            long r8 = r8 / r10
            int r4 = (int) r8
            r5[r7] = r4
            goto L_0x0388
        L_0x037f:
            r44 = r4
            r46 = r8
            r45 = r9
            r4 = 0
            r5[r7] = r4
        L_0x0388:
            r35 = 1000000(0xf4240, double:4.940656E-318)
            r33 = r13
            r37 = r10
            long r8 = com.google.android.gms.internal.ads.zzfn.zzt(r33, r35, r37)
            long r8 = r8 - r19
            r40[r7] = r8
            boolean r4 = r6.zzr
            if (r4 != 0) goto L_0x03a5
            com.google.android.gms.internal.ads.zzacn r4 = r1.zzd
            r33 = r5
            long r4 = r4.zzh
            long r8 = r8 + r4
            r40[r7] = r8
            goto L_0x03a7
        L_0x03a5:
            r33 = r5
        L_0x03a7:
            r39[r7] = r3
            r3 = 16
            int r0 = r0 >> r3
            r3 = 1
            r0 = r0 & r3
            r0 = r0 ^ r3
            if (r3 == r0) goto L_0x03b3
            r0 = 0
            goto L_0x03b4
        L_0x03b3:
            r0 = 1
        L_0x03b4:
            r32[r7] = r0
            long r2 = (long) r2
            long r13 = r13 + r2
            int r7 = r7 + 1
            r5 = r33
            r2 = r41
            r3 = r42
            r0 = r43
            r4 = r44
            r9 = r45
            r8 = r46
            goto L_0x032a
        L_0x03ca:
            r44 = r4
            r6.zzq = r13
            r11 = r24
            r7 = r44
            goto L_0x03e9
        L_0x03d3:
            r27 = r1
            r25 = r2
            r26 = r3
            r31 = r4
            r21 = r5
            r22 = r6
            r29 = r8
            r23 = r9
            r30 = r10
            r1 = r14
            r17 = 16777215(0xffffff, float:2.3509886E-38)
        L_0x03e9:
            int r0 = r27 + 1
            r14 = r1
            r5 = r21
            r6 = r22
            r9 = r23
            r2 = r25
            r3 = r26
            r8 = r29
            r10 = r30
            r4 = r31
            r13 = 1953658222(0x7472756e, float:7.683823E31)
            r1 = r0
            r0 = r47
            goto L_0x0276
        L_0x0404:
            r25 = r2
            r26 = r3
            r31 = r4
            r22 = r6
            r29 = r8
            r30 = r10
            r1 = r14
            com.google.android.gms.internal.ads.zzacn r0 = r1.zzd
            com.google.android.gms.internal.ads.zzack r0 = r0.zza
            r1 = r31
            com.google.android.gms.internal.ads.zzabv r2 = r1.zza
            r2.getClass()
            int r2 = r2.zza
            com.google.android.gms.internal.ads.zzacl r0 = r0.zza(r2)
            r2 = 1935763834(0x7361697a, float:1.785898E31)
            r10 = r30
            com.google.android.gms.internal.ads.zzabm r2 = r10.zzb(r2)
            if (r2 == 0) goto L_0x04a4
            r0.getClass()
            com.google.android.gms.internal.ads.zzfd r2 = r2.zza
            int r3 = r0.zzd
            r4 = 8
            r2.zzF(r4)
            int r5 = r2.zze()
            r6 = 1
            r5 = r5 & r6
            if (r5 != r6) goto L_0x0444
            r2.zzG(r4)
        L_0x0444:
            int r4 = r2.zzk()
            int r5 = r2.zzn()
            int r6 = r1.zze
            if (r5 > r6) goto L_0x0483
            if (r4 != 0) goto L_0x0469
            boolean[] r4 = r1.zzm
            r6 = 0
            r7 = 0
        L_0x0456:
            if (r6 >= r5) goto L_0x0467
            int r8 = r2.zzk()
            int r7 = r7 + r8
            if (r8 <= r3) goto L_0x0461
            r8 = 1
            goto L_0x0462
        L_0x0461:
            r8 = 0
        L_0x0462:
            r4[r6] = r8
            int r6 = r6 + 1
            goto L_0x0456
        L_0x0467:
            r4 = 0
            goto L_0x0476
        L_0x0469:
            if (r4 <= r3) goto L_0x046d
            r2 = 1
            goto L_0x046e
        L_0x046d:
            r2 = 0
        L_0x046e:
            int r7 = r4 * r5
            boolean[] r3 = r1.zzm
            r4 = 0
            java.util.Arrays.fill(r3, r4, r5, r2)
        L_0x0476:
            boolean[] r2 = r1.zzm
            int r3 = r1.zze
            java.util.Arrays.fill(r2, r5, r3, r4)
            if (r7 <= 0) goto L_0x04a4
            r1.zzb(r7)
            goto L_0x04a4
        L_0x0483:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = 78
            r0.<init>(r1)
            java.lang.String r1 = "Saiz sample count "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r1 = " is greater than fragment sample count"
            r0.append(r1)
            r0.append(r6)
            java.lang.String r0 = r0.toString()
            r1 = 0
            com.google.android.gms.internal.ads.zzbj r0 = com.google.android.gms.internal.ads.zzbj.zza(r0, r1)
            throw r0
        L_0x04a4:
            r2 = 1935763823(0x7361696f, float:1.7858967E31)
            com.google.android.gms.internal.ads.zzabm r2 = r10.zzb(r2)
            if (r2 == 0) goto L_0x04f4
            com.google.android.gms.internal.ads.zzfd r2 = r2.zza
            r3 = 8
            r2.zzF(r3)
            int r4 = r2.zze()
            r5 = r4 & 1
            r6 = 1
            if (r5 != r6) goto L_0x04c0
            r2.zzG(r3)
        L_0x04c0:
            int r3 = r2.zzn()
            if (r3 != r6) goto L_0x04db
            long r5 = r1.zzc
            int r3 = com.google.android.gms.internal.ads.zzabn.zze(r4)
            if (r3 != 0) goto L_0x04d3
            long r2 = r2.zzs()
            goto L_0x04d7
        L_0x04d3:
            long r2 = r2.zzt()
        L_0x04d7:
            long r5 = r5 + r2
            r1.zzc = r5
            goto L_0x04f4
        L_0x04db:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = 40
            r0.<init>(r1)
            java.lang.String r1 = "Unexpected saio entry count: "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r2 = 0
            com.google.android.gms.internal.ads.zzbj r0 = com.google.android.gms.internal.ads.zzbj.zza(r0, r2)
            throw r0
        L_0x04f4:
            r2 = 0
            r3 = 1936027235(0x73656e63, float:1.8177412E31)
            com.google.android.gms.internal.ads.zzabm r3 = r10.zzb(r3)
            if (r3 == 0) goto L_0x0504
            com.google.android.gms.internal.ads.zzfd r3 = r3.zza
            r4 = 0
            zzh(r3, r4, r1)
        L_0x0504:
            if (r0 == 0) goto L_0x050b
            java.lang.String r0 = r0.zzb
            r32 = r0
            goto L_0x050d
        L_0x050b:
            r32 = r2
        L_0x050d:
            r0 = r2
            r3 = r0
            r4 = 0
        L_0x0510:
            java.util.List<com.google.android.gms.internal.ads.zzabm> r5 = r10.zzb
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x054d
            java.util.List<com.google.android.gms.internal.ads.zzabm> r5 = r10.zzb
            java.lang.Object r5 = r5.get(r4)
            com.google.android.gms.internal.ads.zzabm r5 = (com.google.android.gms.internal.ads.zzabm) r5
            com.google.android.gms.internal.ads.zzfd r6 = r5.zza
            int r5 = r5.zzd
            r7 = 1935828848(0x73626770, float:1.7937577E31)
            r8 = 1936025959(0x73656967, float:1.817587E31)
            if (r5 != r7) goto L_0x0539
            r7 = 12
            r6.zzF(r7)
            int r5 = r6.zze()
            if (r5 != r8) goto L_0x054a
            r0 = r6
            goto L_0x054a
        L_0x0539:
            r7 = 12
            r9 = 1936158820(0x73677064, float:1.8336489E31)
            if (r5 != r9) goto L_0x054a
            r6.zzF(r7)
            int r5 = r6.zze()
            if (r5 != r8) goto L_0x054a
            r3 = r6
        L_0x054a:
            int r4 = r4 + 1
            goto L_0x0510
        L_0x054d:
            r7 = 12
            if (r0 == 0) goto L_0x05f0
            if (r3 != 0) goto L_0x0555
            goto L_0x05f0
        L_0x0555:
            r4 = 8
            r0.zzF(r4)
            int r5 = r0.zze()
            r6 = 4
            r0.zzG(r6)
            int r5 = com.google.android.gms.internal.ads.zzabn.zze(r5)
            r8 = 1
            if (r5 != r8) goto L_0x056c
            r0.zzG(r6)
        L_0x056c:
            int r0 = r0.zze()
            if (r0 != r8) goto L_0x05e9
            r3.zzF(r4)
            int r0 = r3.zze()
            int r0 = com.google.android.gms.internal.ads.zzabn.zze(r0)
            r3.zzG(r6)
            if (r0 != r8) goto L_0x0592
            long r4 = r3.zzs()
            int r0 = (r4 > r19 ? 1 : (r4 == r19 ? 0 : -1))
            if (r0 == 0) goto L_0x058b
            goto L_0x0598
        L_0x058b:
            java.lang.String r0 = "Variable length description in sgpd found (unsupported)"
            com.google.android.gms.internal.ads.zzbj r0 = com.google.android.gms.internal.ads.zzbj.zzc(r0)
            throw r0
        L_0x0592:
            r4 = 2
            if (r0 < r4) goto L_0x0598
            r3.zzG(r6)
        L_0x0598:
            long r4 = r3.zzs()
            r8 = 1
            int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r0 != 0) goto L_0x05e2
            r0 = 1
            r3.zzG(r0)
            int r4 = r3.zzk()
            r5 = r4 & 240(0xf0, float:3.36E-43)
            int r35 = r5 >> 4
            r36 = r4 & 15
            int r4 = r3.zzk()
            if (r4 != r0) goto L_0x05f1
            int r33 = r3.zzk()
            r4 = 16
            byte[] r5 = new byte[r4]
            r6 = 0
            r3.zzB(r5, r6, r4)
            if (r33 != 0) goto L_0x05d0
            int r2 = r3.zzk()
            byte[] r9 = new byte[r2]
            r3.zzB(r9, r6, r2)
            r37 = r9
            goto L_0x05d2
        L_0x05d0:
            r37 = r2
        L_0x05d2:
            r1.zzl = r0
            com.google.android.gms.internal.ads.zzacl r2 = new com.google.android.gms.internal.ads.zzacl
            r31 = 1
            r30 = r2
            r34 = r5
            r30.<init>(r31, r32, r33, r34, r35, r36, r37)
            r1.zzn = r2
            goto L_0x05f1
        L_0x05e2:
            java.lang.String r0 = "Entry count in sgpd != 1 (unsupported)."
            com.google.android.gms.internal.ads.zzbj r0 = com.google.android.gms.internal.ads.zzbj.zzc(r0)
            throw r0
        L_0x05e9:
            java.lang.String r0 = "Entry count in sbgp != 1 (unsupported)."
            com.google.android.gms.internal.ads.zzbj r0 = com.google.android.gms.internal.ads.zzbj.zzc(r0)
            throw r0
        L_0x05f0:
            r0 = 1
        L_0x05f1:
            java.util.List<com.google.android.gms.internal.ads.zzabm> r2 = r10.zzb
            int r2 = r2.size()
            r3 = 0
        L_0x05f8:
            if (r3 >= r2) goto L_0x0630
            java.util.List<com.google.android.gms.internal.ads.zzabm> r4 = r10.zzb
            java.lang.Object r4 = r4.get(r3)
            com.google.android.gms.internal.ads.zzabm r4 = (com.google.android.gms.internal.ads.zzabm) r4
            int r5 = r4.zzd
            r6 = 1970628964(0x75756964, float:3.1109627E32)
            if (r5 != r6) goto L_0x0624
            com.google.android.gms.internal.ads.zzfd r4 = r4.zza
            r5 = 8
            r4.zzF(r5)
            r8 = r26
            r6 = 0
            r9 = 16
            r4.zzB(r8, r6, r9)
            byte[] r11 = zzb
            boolean r11 = java.util.Arrays.equals(r8, r11)
            if (r11 == 0) goto L_0x062b
            zzh(r4, r9, r1)
            goto L_0x062b
        L_0x0624:
            r8 = r26
            r5 = 8
            r6 = 0
            r9 = 16
        L_0x062b:
            int r3 = r3 + 1
            r26 = r8
            goto L_0x05f8
        L_0x0630:
            r8 = r26
            r5 = 8
            r6 = 0
            goto L_0x0644
        L_0x0636:
            r18 = r1
            r25 = r2
            r22 = r6
            r5 = r7
            r29 = r8
            r0 = 1
            r6 = 0
            r7 = 12
            r8 = r3
        L_0x0644:
            int r1 = r29 + 1
            r0 = r47
            r7 = r5
            r3 = r8
            r6 = r22
            r2 = r25
            r8 = r1
            r1 = r18
            goto L_0x014d
        L_0x0653:
            r1 = r2
            r2 = 0
            r6 = 0
            java.util.List<com.google.android.gms.internal.ads.zzabm> r0 = r1.zzb
            com.google.android.gms.internal.ads.zzs r0 = zzf(r0)
            r3 = r47
            if (r0 == 0) goto L_0x06a4
            android.util.SparseArray<com.google.android.gms.internal.ads.zzabz> r1 = r3.zze
            int r1 = r1.size()
            r4 = r6
        L_0x0667:
            if (r4 >= r1) goto L_0x06a4
            android.util.SparseArray<com.google.android.gms.internal.ads.zzabz> r5 = r3.zze
            java.lang.Object r5 = r5.valueAt(r4)
            com.google.android.gms.internal.ads.zzabz r5 = (com.google.android.gms.internal.ads.zzabz) r5
            com.google.android.gms.internal.ads.zzacn r7 = r5.zzd
            com.google.android.gms.internal.ads.zzack r7 = r7.zza
            com.google.android.gms.internal.ads.zzacm r8 = r5.zzb
            com.google.android.gms.internal.ads.zzabv r8 = r8.zza
            int r9 = com.google.android.gms.internal.ads.zzfn.zza
            int r8 = r8.zza
            com.google.android.gms.internal.ads.zzacl r7 = r7.zza(r8)
            if (r7 == 0) goto L_0x0686
            java.lang.String r7 = r7.zzb
            goto L_0x0687
        L_0x0686:
            r7 = r2
        L_0x0687:
            com.google.android.gms.internal.ads.zzs r7 = r0.zza(r7)
            com.google.android.gms.internal.ads.zzacn r8 = r5.zzd
            com.google.android.gms.internal.ads.zzack r8 = r8.zza
            com.google.android.gms.internal.ads.zzab r8 = r8.zzf
            com.google.android.gms.internal.ads.zzz r8 = r8.zzb()
            r8.zzB(r7)
            com.google.android.gms.internal.ads.zzab r7 = r8.zzY()
            com.google.android.gms.internal.ads.zzxt r5 = r5.zza
            r5.zzk(r7)
            int r4 = r4 + 1
            goto L_0x0667
        L_0x06a4:
            long r0 = r3.zzv
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x06ff
            android.util.SparseArray<com.google.android.gms.internal.ads.zzabz> r0 = r3.zze
            int r0 = r0.size()
            r10 = r6
        L_0x06b6:
            if (r10 >= r0) goto L_0x06e2
            android.util.SparseArray<com.google.android.gms.internal.ads.zzabz> r1 = r3.zze
            java.lang.Object r1 = r1.valueAt(r10)
            com.google.android.gms.internal.ads.zzabz r1 = (com.google.android.gms.internal.ads.zzabz) r1
            long r4 = r3.zzv
            int r2 = r1.zzf
        L_0x06c4:
            com.google.android.gms.internal.ads.zzacm r6 = r1.zzb
            int r7 = r6.zze
            if (r2 >= r7) goto L_0x06df
            long r6 = r6.zza(r2)
            int r6 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r6 >= 0) goto L_0x06df
            com.google.android.gms.internal.ads.zzacm r6 = r1.zzb
            boolean[] r6 = r6.zzk
            boolean r6 = r6[r2]
            if (r6 == 0) goto L_0x06dc
            r1.zzi = r2
        L_0x06dc:
            int r2 = r2 + 1
            goto L_0x06c4
        L_0x06df:
            int r10 = r10 + 1
            goto L_0x06b6
        L_0x06e2:
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r3.zzv = r1
            goto L_0x06ff
        L_0x06ea:
            r3 = r0
            r1 = r2
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzabl> r0 = r3.zzm
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x06ff
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzabl> r0 = r3.zzm
            java.lang.Object r0 = r0.peek()
            com.google.android.gms.internal.ads.zzabl r0 = (com.google.android.gms.internal.ads.zzabl) r0
            r0.zzc(r1)
        L_0x06ff:
            r0 = r3
            goto L_0x0002
        L_0x0702:
            r3 = r0
            r47.zzg()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaca.zzi(long):void");
    }

    private static final zzabv zzj(SparseArray<zzabv> sparseArray, int i11) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        zzabv zzabv = sparseArray.get(i11);
        zzabv.getClass();
        return zzabv;
    }

    public final int zza(zzwq zzwq, zzxm zzxm) throws IOException {
        boolean z11;
        boolean z12;
        long j11;
        long j12;
        String str;
        String str2;
        long j13;
        long j14;
        long j15;
        long j16;
        zzabz zzabz;
        int i11;
        boolean z13;
        int i12;
        zzwq zzwq2 = zzwq;
        while (true) {
            int i13 = this.zzo;
            z11 = true;
            z12 = false;
            if (i13 == 0) {
                if (this.zzr == 0) {
                    if (!zzwq2.zzn(this.zzl.zzH(), 0, 8, true)) {
                        return -1;
                    }
                    this.zzr = 8;
                    this.zzl.zzF(0);
                    this.zzq = this.zzl.zzs();
                    this.zzp = this.zzl.zze();
                }
                long j17 = this.zzq;
                if (j17 == 1) {
                    ((zzwk) zzwq2).zzn(this.zzl.zzH(), 8, 8, false);
                    this.zzr += 8;
                    this.zzq = this.zzl.zzt();
                } else if (j17 == 0) {
                    long zzc2 = zzwq.zzc();
                    if (zzc2 == -1 && !this.zzm.isEmpty()) {
                        zzc2 = this.zzm.peek().zza;
                    }
                    if (zzc2 != -1) {
                        this.zzq = (zzc2 - zzwq.zze()) + ((long) this.zzr);
                    }
                }
                if (this.zzq >= ((long) this.zzr)) {
                    long zze2 = zzwq.zze() - ((long) this.zzr);
                    int i14 = this.zzp;
                    if ((i14 == 1836019558 || i14 == 1835295092) && !this.zzG) {
                        this.zzD.zzL(new zzxo(this.zzw, zze2));
                        this.zzG = true;
                    }
                    if (this.zzp == 1836019558) {
                        int size = this.zze.size();
                        for (int i15 = 0; i15 < size; i15++) {
                            zzacm zzacm = this.zze.valueAt(i15).zzb;
                            zzacm.zzc = zze2;
                            zzacm.zzb = zze2;
                        }
                    }
                    int i16 = this.zzp;
                    if (i16 == 1835295092) {
                        this.zzy = null;
                        this.zzt = zze2 + this.zzq;
                        this.zzo = 2;
                    } else if (i16 == 1836019574 || i16 == 1953653099 || i16 == 1835297121 || i16 == 1835626086 || i16 == 1937007212 || i16 == 1836019558 || i16 == 1953653094 || i16 == 1836475768 || i16 == 1701082227) {
                        long zze3 = (zzwq.zze() + this.zzq) - 8;
                        this.zzm.push(new zzabl(this.zzp, zze3));
                        if (this.zzq == ((long) this.zzr)) {
                            zzi(zze3);
                        } else {
                            zzg();
                        }
                    } else if (i16 == 1751411826 || i16 == 1835296868 || i16 == 1836476516 || i16 == 1936286840 || i16 == 1937011556 || i16 == 1937011827 || i16 == 1668576371 || i16 == 1937011555 || i16 == 1937011578 || i16 == 1937013298 || i16 == 1937007471 || i16 == 1668232756 || i16 == 1937011571 || i16 == 1952867444 || i16 == 1952868452 || i16 == 1953196132 || i16 == 1953654136 || i16 == 1953658222 || i16 == 1886614376 || i16 == 1935763834 || i16 == 1935763823 || i16 == 1936027235 || i16 == 1970628964 || i16 == 1935828848 || i16 == 1936158820 || i16 == 1701606260 || i16 == 1835362404 || i16 == 1701671783) {
                        if (this.zzr == 8) {
                            long j18 = this.zzq;
                            if (j18 <= 2147483647L) {
                                zzfd zzfd = new zzfd((int) j18);
                                System.arraycopy(this.zzl.zzH(), 0, zzfd.zzH(), 0, 8);
                                this.zzs = zzfd;
                                this.zzo = 1;
                            } else {
                                throw zzbj.zzc("Leaf atom with length > 2147483647 (unsupported).");
                            }
                        } else {
                            throw zzbj.zzc("Leaf atom defines extended atom size (unsupported).");
                        }
                    } else if (this.zzq <= 2147483647L) {
                        this.zzs = null;
                        this.zzo = 1;
                    } else {
                        throw zzbj.zzc("Skipping atom with length > 2147483647 (unsupported).");
                    }
                } else {
                    throw zzbj.zzc("Atom size less than header length (unsupported).");
                }
            } else if (i13 != 1) {
                long j19 = Long.MAX_VALUE;
                if (i13 != 2) {
                    zzabz = this.zzy;
                    if (zzabz != null) {
                        break;
                    }
                    SparseArray<zzabz> sparseArray = this.zze;
                    int size2 = sparseArray.size();
                    long j21 = Long.MAX_VALUE;
                    zzabz zzabz2 = null;
                    for (int i17 = 0; i17 < size2; i17++) {
                        zzabz valueAt = sparseArray.valueAt(i17);
                        if ((valueAt.zzl || valueAt.zzf != valueAt.zzd.zzb) && (!valueAt.zzl || valueAt.zzh != valueAt.zzb.zzd)) {
                            long zzd2 = valueAt.zzd();
                            if (zzd2 < j21) {
                                zzabz2 = valueAt;
                                j21 = zzd2;
                            }
                        }
                    }
                    if (zzabz2 == null) {
                        int zze4 = (int) (this.zzt - zzwq.zze());
                        if (zze4 >= 0) {
                            ((zzwk) zzwq2).zzo(zze4, false);
                            zzg();
                        } else {
                            throw zzbj.zza("Offset to end of mdat was negative.", (Throwable) null);
                        }
                    } else {
                        int zzd3 = (int) (zzabz2.zzd() - zzwq.zze());
                        if (zzd3 < 0) {
                            Log.w("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                            zzd3 = 0;
                        }
                        ((zzwk) zzwq2).zzo(zzd3, false);
                        this.zzy = zzabz2;
                        zzabz = zzabz2;
                    }
                } else {
                    int size3 = this.zze.size();
                    zzabz zzabz3 = null;
                    for (int i18 = 0; i18 < size3; i18++) {
                        zzacm zzacm2 = this.zze.valueAt(i18).zzb;
                        if (zzacm2.zzp) {
                            long j22 = zzacm2.zzc;
                            if (j22 < j19) {
                                zzabz3 = this.zze.valueAt(i18);
                                j19 = j22;
                            }
                        }
                    }
                    if (zzabz3 == null) {
                        this.zzo = 3;
                    } else {
                        int zze5 = (int) (j19 - zzwq.zze());
                        if (zze5 >= 0) {
                            zzwk zzwk = (zzwk) zzwq2;
                            zzwk.zzo(zze5, false);
                            zzacm zzacm3 = zzabz3.zzb;
                            zzwk.zzn(zzacm3.zzo.zzH(), 0, zzacm3.zzo.zzd(), false);
                            zzacm3.zzo.zzF(0);
                            zzacm3.zzp = false;
                        } else {
                            throw zzbj.zza("Offset to encryption data was negative.", (Throwable) null);
                        }
                    }
                }
            } else {
                int i19 = ((int) this.zzq) - this.zzr;
                zzfd zzfd2 = this.zzs;
                if (zzfd2 != null) {
                    ((zzwk) zzwq2).zzn(zzfd2.zzH(), 8, i19, false);
                    zzabm zzabm = new zzabm(this.zzp, zzfd2);
                    long zze6 = zzwq.zze();
                    if (!this.zzm.isEmpty()) {
                        this.zzm.peek().zzd(zzabm);
                    } else {
                        int i21 = zzabm.zzd;
                        if (i21 == 1936286840) {
                            zzfd zzfd3 = zzabm.zza;
                            zzfd3.zzF(8);
                            int zze7 = zzfd3.zze();
                            zzfd3.zzG(4);
                            long zzs2 = zzfd3.zzs();
                            if (zzabn.zze(zze7) == 0) {
                                j16 = zzfd3.zzs();
                                j15 = zzfd3.zzs();
                            } else {
                                j16 = zzfd3.zzt();
                                j15 = zzfd3.zzt();
                            }
                            long j23 = zze6 + j15;
                            long zzt2 = zzfn.zzt(j16, 1000000, zzs2);
                            zzfd3.zzG(2);
                            int zzo2 = zzfd3.zzo();
                            int[] iArr = new int[zzo2];
                            long[] jArr = new long[zzo2];
                            long[] jArr2 = new long[zzo2];
                            long[] jArr3 = new long[zzo2];
                            long j24 = zzt2;
                            int i22 = 0;
                            while (i22 < zzo2) {
                                int zze8 = zzfd3.zze();
                                if ((zze8 & Integer.MIN_VALUE) == 0) {
                                    long zzs3 = zzfd3.zzs();
                                    iArr[i22] = zze8 & Integer.MAX_VALUE;
                                    jArr[i22] = j23;
                                    jArr3[i22] = j24;
                                    long j25 = j16 + zzs3;
                                    long[] jArr4 = jArr3;
                                    int i23 = i22;
                                    long[] jArr5 = jArr2;
                                    int[] iArr2 = iArr;
                                    j24 = zzfn.zzt(j25, 1000000, zzs2);
                                    jArr5[i23] = j24 - jArr4[i23];
                                    zzfd3.zzG(4);
                                    j23 += (long) iArr2[i23];
                                    i22 = i23 + 1;
                                    iArr = iArr2;
                                    jArr = jArr;
                                    jArr2 = jArr5;
                                    jArr3 = jArr4;
                                    zzo2 = zzo2;
                                    j16 = j25;
                                    zzwq zzwq3 = zzwq;
                                } else {
                                    throw zzbj.zza("Unhandled indirect reference", (Throwable) null);
                                }
                            }
                            Pair create = Pair.create(Long.valueOf(zzt2), new zzwi(iArr, jArr, jArr2, jArr3));
                            this.zzx = ((Long) create.first).longValue();
                            this.zzD.zzL((zzxp) create.second);
                            this.zzG = true;
                        } else if (i21 == 1701671783) {
                            zzfd zzfd4 = zzabm.zza;
                            if (this.zzE.length != 0) {
                                zzfd4.zzF(8);
                                int zze9 = zzabn.zze(zzfd4.zze());
                                if (zze9 == 0) {
                                    String zzv2 = zzfd4.zzv(0);
                                    zzv2.getClass();
                                    String zzv3 = zzfd4.zzv(0);
                                    zzv3.getClass();
                                    long zzs4 = zzfd4.zzs();
                                    long zzt3 = zzfn.zzt(zzfd4.zzs(), 1000000, zzs4);
                                    long j26 = this.zzx;
                                    j13 = j26 != C.TIME_UNSET ? j26 + zzt3 : -9223372036854775807L;
                                    j12 = zzfn.zzt(zzfd4.zzs(), 1000, zzs4);
                                    j11 = zzfd4.zzs();
                                    str2 = zzv2;
                                    str = zzv3;
                                    j14 = zzt3;
                                } else if (zze9 != 1) {
                                    StringBuilder sb2 = new StringBuilder(46);
                                    sb2.append("Skipping unsupported emsg version: ");
                                    sb2.append(zze9);
                                    Log.w("FragmentedMp4Extractor", sb2.toString());
                                } else {
                                    long zzs5 = zzfd4.zzs();
                                    long zzt4 = zzfn.zzt(zzfd4.zzt(), 1000000, zzs5);
                                    long zzt5 = zzfn.zzt(zzfd4.zzs(), 1000, zzs5);
                                    long zzs6 = zzfd4.zzs();
                                    String zzv4 = zzfd4.zzv(0);
                                    zzv4.getClass();
                                    String zzv5 = zzfd4.zzv(0);
                                    zzv5.getClass();
                                    j12 = zzt5;
                                    j13 = zzt4;
                                    j11 = zzs6;
                                    str2 = zzv4;
                                    str = zzv5;
                                    j14 = -9223372036854775807L;
                                }
                                byte[] bArr = new byte[zzfd4.zza()];
                                zzfd4.zzB(bArr, 0, zzfd4.zza());
                                zzfd zzfd5 = new zzfd(this.zzk.zza(new zzyw(str2, str, j12, j11, bArr)));
                                int zza2 = zzfd5.zza();
                                for (zzxt zzq2 : this.zzE) {
                                    zzfd5.zzF(0);
                                    zzq2.zzq(zzfd5, zza2);
                                }
                                if (j13 == C.TIME_UNSET) {
                                    this.zzn.addLast(new zzaby(j14, zza2));
                                    this.zzu += zza2;
                                } else {
                                    for (zzxt zzs7 : this.zzE) {
                                        zzs7.zzs(j13, 1, zza2, 0, (zzxs) null);
                                    }
                                }
                            }
                        }
                        zzwq2 = zzwq;
                    }
                } else {
                    ((zzwk) zzwq2).zzo(i19, false);
                }
                zzi(zzwq.zze());
            }
        }
        byte b11 = 6;
        if (this.zzo == 3) {
            int zzb2 = zzabz.zzb();
            this.zzz = zzb2;
            if (zzabz.zzf < zzabz.zzi) {
                ((zzwk) zzwq2).zzo(zzb2, false);
                zzacl zzf2 = zzabz.zzf();
                if (zzf2 != null) {
                    zzfd zzfd6 = zzabz.zzb.zzo;
                    int i24 = zzf2.zzd;
                    if (i24 != 0) {
                        zzfd6.zzG(i24);
                    }
                    if (zzabz.zzb.zzc(zzabz.zzf)) {
                        zzfd6.zzG(zzfd6.zzo() * 6);
                    }
                }
                if (!zzabz.zzk()) {
                    this.zzy = null;
                }
                this.zzo = 3;
                return 0;
            }
            if (zzabz.zzd.zza.zzg == 1) {
                this.zzz = zzb2 - 8;
                ((zzwk) zzwq2).zzo(8, false);
            }
            if (MimeTypes.AUDIO_AC4.equals(zzabz.zzd.zza.zzf.zzm)) {
                this.zzA = zzabz.zzc(this.zzz, 7);
                zzvy.zzb(this.zzz, this.zzj);
                zzxr.zzb(zzabz.zza, this.zzj, 7);
                i12 = this.zzA + 7;
                this.zzA = i12;
            } else {
                i12 = zzabz.zzc(this.zzz, 0);
                this.zzA = i12;
            }
            this.zzz += i12;
            this.zzo = 4;
            this.zzB = 0;
        }
        zzack zzack = zzabz.zzd.zza;
        zzxt zzxt = zzabz.zza;
        long zze10 = zzabz.zze();
        if (zzack.zzj == 0) {
            while (true) {
                int i25 = this.zzA;
                int i26 = this.zzz;
                if (i25 >= i26) {
                    break;
                }
                this.zzA += zzxr.zza(zzxt, zzwq2, i26 - i25, false);
            }
        } else {
            byte[] zzH = this.zzg.zzH();
            zzH[0] = 0;
            zzH[1] = 0;
            zzH[2] = 0;
            int i27 = zzack.zzj;
            int i28 = i27 + 1;
            int i29 = 4 - i27;
            while (this.zzA < this.zzz) {
                int i31 = this.zzB;
                if (i31 == 0) {
                    ((zzwk) zzwq2).zzn(zzH, i29, i28, z12);
                    this.zzg.zzF(z12 ? 1 : 0);
                    int zze11 = this.zzg.zze();
                    if (zze11 > 0) {
                        this.zzB = zze11 - 1;
                        this.zzf.zzF(z12);
                        zzxr.zzb(zzxt, this.zzf, 4);
                        zzxr.zzb(zzxt, this.zzg, z11 ? 1 : 0);
                        if (this.zzF.length > 0) {
                            String str3 = zzack.zzf.zzm;
                            byte b12 = zzH[4];
                            byte[] bArr2 = zzeu.zza;
                            if ((MimeTypes.VIDEO_H264.equals(str3) && (b12 & Ascii.US) == b11) || (MimeTypes.VIDEO_H265.equals(str3) && ((b12 & true ? 1 : 0) >> z11) == 39)) {
                                z13 = z11;
                                this.zzC = z13;
                                this.zzA += 5;
                                this.zzz += i29;
                            }
                        }
                        z13 = false;
                        this.zzC = z13;
                        this.zzA += 5;
                        this.zzz += i29;
                    } else {
                        throw zzbj.zza("Invalid NAL length", (Throwable) null);
                    }
                } else {
                    if (this.zzC) {
                        this.zzh.zzC(i31);
                        ((zzwk) zzwq2).zzn(this.zzh.zzH(), 0, this.zzB, false);
                        zzxr.zzb(zzxt, this.zzh, this.zzB);
                        i11 = this.zzB;
                        int zzb3 = zzeu.zzb(this.zzh.zzH(), this.zzh.zzd());
                        this.zzh.zzF(MimeTypes.VIDEO_H265.equals(zzack.zzf.zzm) ? 1 : 0);
                        this.zzh.zzE(zzb3);
                        zzwh.zza(zze10, this.zzh, this.zzF);
                    } else {
                        i11 = zzxr.zza(zzxt, zzwq2, i31, false);
                    }
                    this.zzA += i11;
                    this.zzB -= i11;
                    b11 = 6;
                    z11 = true;
                }
                z12 = false;
            }
        }
        int zza3 = zzabz.zza();
        zzacl zzf3 = zzabz.zzf();
        zzxt.zzs(zze10, zza3, this.zzz, 0, zzf3 != null ? zzf3.zzc : null);
        while (!this.zzn.isEmpty()) {
            zzaby removeFirst = this.zzn.removeFirst();
            this.zzu -= removeFirst.zzb;
            long j27 = removeFirst.zza + zze10;
            for (zzxt zzs8 : this.zzE) {
                zzs8.zzs(j27, 1, removeFirst.zzb, this.zzu, (zzxs) null);
            }
        }
        if (!zzabz.zzk()) {
            this.zzy = null;
        }
        this.zzo = 3;
        return 0;
    }

    public final void zzb(zzws zzws) {
        this.zzD = zzws;
        zzg();
        zzxt[] zzxtArr = new zzxt[2];
        this.zzE = zzxtArr;
        int i11 = 0;
        zzxt[] zzxtArr2 = (zzxt[]) zzfn.zzaa(zzxtArr, 0);
        this.zzE = zzxtArr2;
        for (zzxt zzk2 : zzxtArr2) {
            zzk2.zzk(zzc);
        }
        this.zzF = new zzxt[this.zzd.size()];
        int i12 = 100;
        while (i11 < this.zzF.length) {
            int i13 = i12 + 1;
            zzxt zzv2 = this.zzD.zzv(i12, 3);
            zzv2.zzk(this.zzd.get(i11));
            this.zzF[i11] = zzv2;
            i11++;
            i12 = i13;
        }
    }

    public final void zzc(long j11, long j12) {
        int size = this.zze.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.zze.valueAt(i11).zzi();
        }
        this.zzn.clear();
        this.zzu = 0;
        this.zzv = j12;
        this.zzm.clear();
        zzg();
    }

    public final boolean zzd(zzwq zzwq) throws IOException {
        return zzacj.zza(zzwq);
    }

    public zzaca(int i11, @Nullable zzfk zzfk) {
        this.zzd = Collections.unmodifiableList(Collections.emptyList());
        this.zzk = new zzyx();
        this.zzl = new zzfd(16);
        this.zzf = new zzfd(zzeu.zza);
        this.zzg = new zzfd(5);
        this.zzh = new zzfd();
        byte[] bArr = new byte[16];
        this.zzi = bArr;
        this.zzj = new zzfd(bArr);
        this.zzm = new ArrayDeque<>();
        this.zzn = new ArrayDeque<>();
        this.zze = new SparseArray<>();
        this.zzw = C.TIME_UNSET;
        this.zzv = C.TIME_UNSET;
        this.zzx = C.TIME_UNSET;
        this.zzD = zzws.zza;
        this.zzE = new zzxt[0];
        this.zzF = new zzxt[0];
    }
}

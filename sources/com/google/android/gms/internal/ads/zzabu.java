package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.List;

final class zzabu {
    private static final byte[] zza = zzfn.zzW("OpusHead");

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0073, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ae, code lost:
        if (r3 != 13) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d3, code lost:
        r3 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<com.google.android.gms.internal.ads.zzdd, com.google.android.gms.internal.ads.zzdd> zza(com.google.android.gms.internal.ads.zzabm r11) {
        /*
            com.google.android.gms.internal.ads.zzfd r11 = r11.zza
            r0 = 8
            r11.zzF(r0)
            r1 = 0
            r2 = r1
            r3 = r2
        L_0x000a:
            int r4 = r11.zza()
            if (r4 < r0) goto L_0x00da
            int r4 = r11.zzc()
            int r5 = r11.zze()
            int r6 = r11.zze()
            r7 = 1835365473(0x6d657461, float:4.4382975E27)
            if (r6 != r7) goto L_0x0075
            r11.zzF(r4)
            int r2 = r4 + r5
            r11.zzG(r0)
            zzd(r11)
        L_0x002c:
            int r6 = r11.zzc()
            if (r6 >= r2) goto L_0x0073
            int r6 = r11.zzc()
            int r7 = r11.zze()
            int r8 = r11.zze()
            r9 = 1768715124(0x696c7374, float:1.7865732E25)
            if (r8 != r9) goto L_0x006e
            r11.zzF(r6)
            int r6 = r6 + r7
            r11.zzG(r0)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
        L_0x004f:
            int r7 = r11.zzc()
            if (r7 >= r6) goto L_0x005f
            com.google.android.gms.internal.ads.zzdc r7 = com.google.android.gms.internal.ads.zzacb.zza(r11)
            if (r7 == 0) goto L_0x004f
            r2.add(r7)
            goto L_0x004f
        L_0x005f:
            boolean r6 = r2.isEmpty()
            if (r6 == 0) goto L_0x0066
            goto L_0x0073
        L_0x0066:
            com.google.android.gms.internal.ads.zzdd r6 = new com.google.android.gms.internal.ads.zzdd
            r6.<init>((java.util.List<? extends com.google.android.gms.internal.ads.zzdc>) r2)
            r2 = r6
            goto L_0x00d4
        L_0x006e:
            int r6 = r6 + r7
            r11.zzF(r6)
            goto L_0x002c
        L_0x0073:
            r2 = r1
            goto L_0x00d4
        L_0x0075:
            r7 = 1936553057(0x736d7461, float:1.8813092E31)
            if (r6 != r7) goto L_0x00d4
            r11.zzF(r4)
            int r3 = r4 + r5
            r6 = 12
            r11.zzG(r6)
        L_0x0084:
            int r7 = r11.zzc()
            if (r7 >= r3) goto L_0x00d3
            int r7 = r11.zzc()
            int r8 = r11.zze()
            int r9 = r11.zze()
            r10 = 1935766900(0x73617574, float:1.7862687E31)
            if (r9 != r10) goto L_0x00ce
            r3 = 14
            if (r8 >= r3) goto L_0x00a0
            goto L_0x00d3
        L_0x00a0:
            r3 = 5
            r11.zzG(r3)
            int r3 = r11.zzk()
            r7 = 1123024896(0x42f00000, float:120.0)
            if (r3 == r6) goto L_0x00b1
            r6 = 13
            if (r3 == r6) goto L_0x00b5
            goto L_0x00d3
        L_0x00b1:
            if (r3 != r6) goto L_0x00b5
            r7 = 1131413504(0x43700000, float:240.0)
        L_0x00b5:
            r3 = 1
            r11.zzG(r3)
            int r6 = r11.zzk()
            com.google.android.gms.internal.ads.zzdd r8 = new com.google.android.gms.internal.ads.zzdd
            com.google.android.gms.internal.ads.zzdc[] r3 = new com.google.android.gms.internal.ads.zzdc[r3]
            com.google.android.gms.internal.ads.zzaan r9 = new com.google.android.gms.internal.ads.zzaan
            r9.<init>((float) r7, (int) r6)
            r6 = 0
            r3[r6] = r9
            r8.<init>((com.google.android.gms.internal.ads.zzdc[]) r3)
            r3 = r8
            goto L_0x00d4
        L_0x00ce:
            int r7 = r7 + r8
            r11.zzF(r7)
            goto L_0x0084
        L_0x00d3:
            r3 = r1
        L_0x00d4:
            int r4 = r4 + r5
            r11.zzF(r4)
            goto L_0x000a
        L_0x00da:
            android.util.Pair r11 = android.util.Pair.create(r2, r3)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzabu.zza(com.google.android.gms.internal.ads.zzabm):android.util.Pair");
    }

    @Nullable
    public static zzdd zzb(zzabl zzabl) {
        zzaah zzaah;
        zzabm zzb = zzabl.zzb(Atom.TYPE_hdlr);
        zzabm zzb2 = zzabl.zzb(Atom.TYPE_keys);
        zzabm zzb3 = zzabl.zzb(Atom.TYPE_ilst);
        if (zzb == null || zzb2 == null || zzb3 == null || zzg(zzb.zza) != 1835299937) {
            return null;
        }
        zzfd zzfd = zzb2.zza;
        zzfd.zzF(12);
        int zze = zzfd.zze();
        String[] strArr = new String[zze];
        for (int i11 = 0; i11 < zze; i11++) {
            int zze2 = zzfd.zze();
            zzfd.zzG(4);
            strArr[i11] = zzfd.zzx(zze2 - 8, zzfpt.zzc);
        }
        zzfd zzfd2 = zzb3.zza;
        zzfd2.zzF(8);
        ArrayList arrayList = new ArrayList();
        while (zzfd2.zza() > 8) {
            int zzc = zzfd2.zzc();
            int zze3 = zzfd2.zze();
            int zze4 = zzfd2.zze() - 1;
            if (zze4 < 0 || zze4 >= zze) {
                StringBuilder sb2 = new StringBuilder(52);
                sb2.append("Skipped metadata with unknown key index: ");
                sb2.append(zze4);
                Log.w("AtomParsers", sb2.toString());
            } else {
                String str = strArr[zze4];
                int i12 = zzc + zze3;
                int i13 = zzacb.zzb;
                while (true) {
                    int zzc2 = zzfd2.zzc();
                    if (zzc2 >= i12) {
                        zzaah = null;
                        break;
                    }
                    int zze5 = zzfd2.zze();
                    if (zzfd2.zze() == 1684108385) {
                        int zze6 = zzfd2.zze();
                        int zze7 = zzfd2.zze();
                        int i14 = zze5 - 16;
                        byte[] bArr = new byte[i14];
                        zzfd2.zzB(bArr, 0, i14);
                        zzaah = new zzaah(str, bArr, zze7, zze6);
                        break;
                    }
                    zzfd2.zzF(zzc2 + zze5);
                }
                if (zzaah != null) {
                    arrayList.add(zzaah);
                }
            }
            zzfd2.zzF(zzc + zze3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzdd((List<? extends zzdc>) arrayList);
    }

    /* JADX WARNING: Removed duplicated region for block: B:350:0x0732  */
    /* JADX WARNING: Removed duplicated region for block: B:374:0x079d  */
    /* JADX WARNING: Removed duplicated region for block: B:375:0x07a1  */
    /* JADX WARNING: Removed duplicated region for block: B:378:0x07db  */
    /* JADX WARNING: Removed duplicated region for block: B:505:0x0b30  */
    /* JADX WARNING: Removed duplicated region for block: B:506:0x0b48  */
    /* JADX WARNING: Removed duplicated region for block: B:534:0x0c07  */
    /* JADX WARNING: Removed duplicated region for block: B:545:0x0c52  */
    /* JADX WARNING: Removed duplicated region for block: B:546:0x0c54  */
    /* JADX WARNING: Removed duplicated region for block: B:550:0x0c69  */
    /* JADX WARNING: Removed duplicated region for block: B:567:0x0cd3  */
    /* JADX WARNING: Removed duplicated region for block: B:568:0x0cd5  */
    /* JADX WARNING: Removed duplicated region for block: B:571:0x0cd9  */
    /* JADX WARNING: Removed duplicated region for block: B:572:0x0cdd  */
    /* JADX WARNING: Removed duplicated region for block: B:574:0x0ce1  */
    /* JADX WARNING: Removed duplicated region for block: B:575:0x0ce5  */
    /* JADX WARNING: Removed duplicated region for block: B:578:0x0cea  */
    /* JADX WARNING: Removed duplicated region for block: B:579:0x0cec  */
    /* JADX WARNING: Removed duplicated region for block: B:581:0x0cf0  */
    /* JADX WARNING: Removed duplicated region for block: B:582:0x0cf4  */
    /* JADX WARNING: Removed duplicated region for block: B:586:0x0d01  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:602:0x0dab  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:642:0x0cca A[EDGE_INSN: B:642:0x0cca->B:565:0x0cca ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0183  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0193  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<com.google.android.gms.internal.ads.zzacn> zzc(com.google.android.gms.internal.ads.zzabl r49, com.google.android.gms.internal.ads.zzxf r50, long r51, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzs r53, boolean r54, boolean r55, com.google.android.gms.internal.ads.zzfpv<com.google.android.gms.internal.ads.zzack, com.google.android.gms.internal.ads.zzack> r56) throws com.google.android.gms.internal.ads.zzbj {
        /*
            r0 = r49
            r1 = r50
            r12 = r53
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            r15 = 0
        L_0x000c:
            java.util.List<com.google.android.gms.internal.ads.zzabl> r2 = r0.zzc
            int r2 = r2.size()
            if (r15 >= r2) goto L_0x0db8
            java.util.List<com.google.android.gms.internal.ads.zzabl> r2 = r0.zzc
            java.lang.Object r2 = r2.get(r15)
            r11 = r2
            com.google.android.gms.internal.ads.zzabl r11 = (com.google.android.gms.internal.ads.zzabl) r11
            int r2 = r11.zzd
            r3 = 1953653099(0x7472616b, float:7.681346E31)
            if (r2 == r3) goto L_0x0029
            r0 = r13
            r31 = r15
            goto L_0x0dad
        L_0x0029:
            r2 = 1836476516(0x6d766864, float:4.7662196E27)
            com.google.android.gms.internal.ads.zzabm r2 = r0.zzb(r2)
            r2.getClass()
            r10 = 1835297121(0x6d646961, float:4.4181236E27)
            com.google.android.gms.internal.ads.zzabl r3 = r11.zza(r10)
            r3.getClass()
            r4 = 1751411826(0x68646c72, float:4.3148E24)
            com.google.android.gms.internal.ads.zzabm r4 = r3.zzb(r4)
            r4.getClass()
            com.google.android.gms.internal.ads.zzfd r4 = r4.zza
            int r4 = zzg(r4)
            int r9 = zze(r4)
            java.lang.String r7 = "AtomParsers"
            r5 = 4
            r31 = r15
            r6 = -1
            if (r9 != r6) goto L_0x0063
            r0 = r56
            r45 = r7
            r2 = r11
            r32 = r13
        L_0x0060:
            r8 = 0
            goto L_0x07d2
        L_0x0063:
            r15 = 1953196132(0x746b6864, float:7.46037E31)
            com.google.android.gms.internal.ads.zzabm r15 = r11.zzb(r15)
            r15.getClass()
            com.google.android.gms.internal.ads.zzfd r15 = r15.zza
            r14 = 8
            r15.zzF(r14)
            int r18 = r15.zze()
            int r18 = com.google.android.gms.internal.ads.zzabn.zze(r18)
            r14 = 16
            if (r18 != 0) goto L_0x0083
            r4 = 8
            goto L_0x0084
        L_0x0083:
            r4 = r14
        L_0x0084:
            r15.zzG(r4)
            int r4 = r15.zze()
            r15.zzG(r5)
            int r21 = r15.zzc()
            if (r18 != 0) goto L_0x0096
            r8 = r5
            goto L_0x0098
        L_0x0096:
            r8 = 8
        L_0x0098:
            r10 = 0
        L_0x0099:
            r24 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r10 >= r8) goto L_0x00c4
            byte[] r26 = r15.zzH()
            int r27 = r21 + r10
            byte r5 = r26[r27]
            if (r5 == r6) goto L_0x00c0
            if (r18 != 0) goto L_0x00b1
            long r26 = r15.zzs()
            goto L_0x00b5
        L_0x00b1:
            long r26 = r15.zzt()
        L_0x00b5:
            r29 = 0
            int r5 = (r26 > r29 ? 1 : (r26 == r29 ? 0 : -1))
            if (r5 != 0) goto L_0x00bc
            goto L_0x00c7
        L_0x00bc:
            r8 = r7
            r6 = r26
            goto L_0x00ca
        L_0x00c0:
            int r10 = r10 + 1
            r5 = 4
            goto L_0x0099
        L_0x00c4:
            r15.zzG(r8)
        L_0x00c7:
            r8 = r7
            r6 = r24
        L_0x00ca:
            r15.zzG(r14)
            int r5 = r15.zze()
            int r10 = r15.zze()
            r14 = 4
            r15.zzG(r14)
            int r14 = r15.zze()
            int r15 = r15.zze()
            r0 = 65536(0x10000, float:9.18355E-41)
            r26 = r8
            r8 = -65536(0xffffffffffff0000, float:NaN)
            if (r5 != 0) goto L_0x00f7
            if (r10 != r0) goto L_0x00f6
            if (r14 != r8) goto L_0x00f5
            if (r15 != 0) goto L_0x00f2
            r0 = 90
            goto L_0x0115
        L_0x00f2:
            r10 = r0
            r14 = r8
            goto L_0x00f6
        L_0x00f5:
            r10 = r0
        L_0x00f6:
            r5 = 0
        L_0x00f7:
            if (r5 != 0) goto L_0x0108
            if (r10 != r8) goto L_0x0105
            if (r14 != r0) goto L_0x0104
            if (r15 != 0) goto L_0x0102
            r0 = 270(0x10e, float:3.78E-43)
            goto L_0x0115
        L_0x0102:
            r10 = r8
            goto L_0x0106
        L_0x0104:
            r10 = r8
        L_0x0105:
            r0 = r14
        L_0x0106:
            r5 = 0
            goto L_0x0109
        L_0x0108:
            r0 = r14
        L_0x0109:
            if (r5 != r8) goto L_0x0114
            if (r10 != 0) goto L_0x0114
            if (r0 != 0) goto L_0x0114
            if (r15 != r8) goto L_0x0114
            r0 = 180(0xb4, float:2.52E-43)
            goto L_0x0115
        L_0x0114:
            r0 = 0
        L_0x0115:
            com.google.android.gms.internal.ads.zzabt r14 = new com.google.android.gms.internal.ads.zzabt
            r14.<init>(r4, r6, r0)
            int r0 = (r51 > r24 ? 1 : (r51 == r24 ? 0 : -1))
            if (r0 != 0) goto L_0x0125
            long r4 = r14.zzb
            r32 = r4
            goto L_0x0127
        L_0x0125:
            r32 = r51
        L_0x0127:
            com.google.android.gms.internal.ads.zzfd r0 = r2.zza
            r2 = 8
            r0.zzF(r2)
            int r2 = r0.zze()
            int r2 = com.google.android.gms.internal.ads.zzabn.zze(r2)
            if (r2 != 0) goto L_0x013b
            r2 = 8
            goto L_0x013d
        L_0x013b:
            r2 = 16
        L_0x013d:
            r0.zzG(r2)
            long r29 = r0.zzs()
            int r0 = (r32 > r24 ? 1 : (r32 == r24 ? 0 : -1))
            if (r0 != 0) goto L_0x0149
            goto L_0x0154
        L_0x0149:
            r34 = 1000000(0xf4240, double:4.940656E-318)
            r36 = r29
            long r4 = com.google.android.gms.internal.ads.zzfn.zzt(r32, r34, r36)
            r24 = r4
        L_0x0154:
            r0 = 1835626086(0x6d696e66, float:4.515217E27)
            com.google.android.gms.internal.ads.zzabl r2 = r3.zza(r0)
            r2.getClass()
            r4 = 1937007212(0x7374626c, float:1.9362132E31)
            com.google.android.gms.internal.ads.zzabl r2 = r2.zza(r4)
            r2.getClass()
            r4 = 1835296868(0x6d646864, float:4.418049E27)
            com.google.android.gms.internal.ads.zzabm r3 = r3.zzb(r4)
            r3.getClass()
            com.google.android.gms.internal.ads.zzfd r3 = r3.zza
            r4 = 8
            r3.zzF(r4)
            int r4 = r3.zze()
            int r4 = com.google.android.gms.internal.ads.zzabn.zze(r4)
            if (r4 != 0) goto L_0x0186
            r5 = 8
            goto L_0x0188
        L_0x0186:
            r5 = 16
        L_0x0188:
            r3.zzG(r5)
            long r5 = r3.zzs()
            if (r4 != 0) goto L_0x0193
            r4 = 4
            goto L_0x0195
        L_0x0193:
            r4 = 8
        L_0x0195:
            r3.zzG(r4)
            int r3 = r3.zzo()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r15 = 3
            r4.<init>(r15)
            int r7 = r3 >> 10
            r7 = r7 & 31
            int r7 = r7 + 96
            char r7 = (char) r7
            r4.append(r7)
            int r7 = r3 >> 5
            r7 = r7 & 31
            int r7 = r7 + 96
            char r7 = (char) r7
            r4.append(r7)
            r3 = r3 & 31
            int r3 = r3 + 96
            char r3 = (char) r3
            r4.append(r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r5)
            java.lang.String r4 = r4.toString()
            android.util.Pair r10 = android.util.Pair.create(r3, r4)
            r3 = 1937011556(0x73747364, float:1.9367383E31)
            com.google.android.gms.internal.ads.zzabm r2 = r2.zzb(r3)
            r2.getClass()
            com.google.android.gms.internal.ads.zzfd r8 = r2.zza
            int r7 = r14.zza
            int r6 = r14.zzc
            java.lang.Object r2 = r10.second
            r5 = r2
            java.lang.String r5 = (java.lang.String) r5
            r4 = 12
            r8.zzF(r4)
            int r3 = r8.zze()
            com.google.android.gms.internal.ads.zzabq r2 = new com.google.android.gms.internal.ads.zzabq
            r2.<init>(r3)
            r0 = 0
        L_0x01f2:
            if (r0 >= r3) goto L_0x071a
            int r15 = r8.zzc()
            r32 = r13
            int r13 = r8.zze()
            if (r13 <= 0) goto L_0x0204
            r33 = r3
            r4 = 1
            goto L_0x0207
        L_0x0204:
            r33 = r3
            r4 = 0
        L_0x0207:
            java.lang.String r3 = "childAtomSize must be positive"
            com.google.android.gms.internal.ads.zzwt.zzb(r4, r3)
            int r3 = r8.zze()
            r4 = 1635148593(0x61766331, float:2.840654E20)
            r34 = r6
            r6 = 1701733238(0x656e6376, float:7.035987E22)
            if (r3 == r4) goto L_0x0418
            r4 = 1635148595(0x61766333, float:2.8406544E20)
            if (r3 == r4) goto L_0x0418
            if (r3 == r6) goto L_0x0418
            r4 = 1831958048(0x6d317620, float:3.4326032E27)
            if (r3 == r4) goto L_0x0418
            r4 = 1836070006(0x6d703476, float:4.646239E27)
            if (r3 == r4) goto L_0x0418
            r4 = 1752589105(0x68766331, float:4.6541277E24)
            if (r3 == r4) goto L_0x0418
            r4 = 1751479857(0x68657631, float:4.3344087E24)
            if (r3 == r4) goto L_0x0418
            r4 = 1932670515(0x73323633, float:1.4119387E31)
            if (r3 == r4) goto L_0x0418
            r4 = 1211250227(0x48323633, float:182488.8)
            if (r3 == r4) goto L_0x0418
            r4 = 1987063864(0x76703038, float:1.21789965E33)
            if (r3 == r4) goto L_0x0418
            r4 = 1987063865(0x76703039, float:1.2178997E33)
            if (r3 == r4) goto L_0x0418
            r4 = 1635135537(0x61763031, float:2.8383572E20)
            if (r3 == r4) goto L_0x0418
            r4 = 1685479798(0x64766176, float:1.8179687E22)
            if (r3 == r4) goto L_0x0418
            r4 = 1685479729(0x64766131, float:1.817961E22)
            if (r3 == r4) goto L_0x0418
            r4 = 1685481573(0x64766865, float:1.8181686E22)
            if (r3 == r4) goto L_0x0418
            r4 = 1685481521(0x64766831, float:1.8181627E22)
            if (r3 != r4) goto L_0x0264
            goto L_0x0418
        L_0x0264:
            r4 = 1836069985(0x6d703461, float:4.6462328E27)
            if (r3 == r4) goto L_0x03d6
            r4 = 1701733217(0x656e6361, float:7.0359778E22)
            if (r3 == r4) goto L_0x03d6
            r4 = 1633889587(0x61632d33, float:2.6191674E20)
            if (r3 == r4) goto L_0x03d6
            r4 = 1700998451(0x65632d33, float:6.7050686E22)
            if (r3 == r4) goto L_0x03d6
            r4 = 1633889588(0x61632d34, float:2.6191676E20)
            if (r3 == r4) goto L_0x03d6
            r4 = 1685353315(0x64747363, float:1.803728E22)
            if (r3 == r4) goto L_0x03d6
            r4 = 1685353317(0x64747365, float:1.8037282E22)
            if (r3 == r4) goto L_0x03d6
            r4 = 1685353320(0x64747368, float:1.8037286E22)
            if (r3 == r4) goto L_0x03d6
            r4 = 1685353324(0x6474736c, float:1.803729E22)
            if (r3 == r4) goto L_0x03d6
            r4 = 1685353336(0x64747378, float:1.8037304E22)
            if (r3 == r4) goto L_0x03d6
            r4 = 1935764850(0x73616d72, float:1.7860208E31)
            if (r3 == r4) goto L_0x03d6
            r4 = 1935767394(0x73617762, float:1.7863284E31)
            if (r3 == r4) goto L_0x03d6
            r4 = 1819304813(0x6c70636d, float:1.1624469E27)
            if (r3 == r4) goto L_0x03d6
            r4 = 1936684916(0x736f7774, float:1.89725E31)
            if (r3 == r4) goto L_0x03d6
            r4 = 1953984371(0x74776f73, float:7.841539E31)
            if (r3 == r4) goto L_0x03d6
            r4 = 778924082(0x2e6d7032, float:5.398721E-11)
            if (r3 == r4) goto L_0x03d6
            r4 = 778924083(0x2e6d7033, float:5.3987214E-11)
            if (r3 == r4) goto L_0x03d6
            r4 = 1835557169(0x6d686131, float:4.4948762E27)
            if (r3 == r4) goto L_0x03d6
            r4 = 1835560241(0x6d686d31, float:4.495783E27)
            if (r3 == r4) goto L_0x03d6
            r4 = 1634492771(0x616c6163, float:2.7252807E20)
            if (r3 == r4) goto L_0x03d6
            r4 = 1634492791(0x616c6177, float:2.7252842E20)
            if (r3 == r4) goto L_0x03d6
            r4 = 1970037111(0x756c6177, float:2.9964816E32)
            if (r3 == r4) goto L_0x03d6
            r4 = 1332770163(0x4f707573, float:4.03422899E9)
            if (r3 == r4) goto L_0x03d6
            r4 = 1716281667(0x664c6143, float:2.4128923E23)
            if (r3 != r4) goto L_0x02de
            goto L_0x03d6
        L_0x02de:
            r4 = 1414810956(0x54544d4c, float:3.64731957E12)
            if (r3 == r4) goto L_0x034c
            r4 = 1954034535(0x74783367, float:7.865797E31)
            if (r3 == r4) goto L_0x034c
            r4 = 2004251764(0x77767474, float:4.998699E33)
            if (r3 == r4) goto L_0x034c
            r4 = 1937010800(0x73747070, float:1.9366469E31)
            if (r3 == r4) goto L_0x034c
            r4 = 1664495672(0x63363038, float:3.360782E21)
            if (r3 != r4) goto L_0x02f8
            goto L_0x034c
        L_0x02f8:
            r4 = 1835365492(0x6d657474, float:4.4383032E27)
            if (r3 != r4) goto L_0x031e
            int r3 = r15 + 16
            r8.zzF(r3)
            r3 = 0
            r8.zzv(r3)
            java.lang.String r4 = r8.zzv(r3)
            if (r4 == 0) goto L_0x0336
            com.google.android.gms.internal.ads.zzz r3 = new com.google.android.gms.internal.ads.zzz
            r3.<init>()
            r3.zzG(r7)
            r3.zzS(r4)
            com.google.android.gms.internal.ads.zzab r3 = r3.zzY()
            r2.zzb = r3
            goto L_0x0336
        L_0x031e:
            r4 = 1667329389(0x63616d6d, float:4.1584024E21)
            if (r3 != r4) goto L_0x0336
            com.google.android.gms.internal.ads.zzz r3 = new com.google.android.gms.internal.ads.zzz
            r3.<init>()
            r3.zzG(r7)
            java.lang.String r4 = "application/x-camera-motion"
            r3.zzS(r4)
            com.google.android.gms.internal.ads.zzab r3 = r3.zzY()
            r2.zzb = r3
        L_0x0336:
            r17 = r0
            r20 = r5
            r1 = r7
            r22 = r9
            r39 = r10
            r40 = r11
            r23 = r13
            r18 = r14
            r45 = r26
            r3 = r34
            r9 = r2
            goto L_0x03d3
        L_0x034c:
            int r4 = r15 + 16
            r8.zzF(r4)
            r4 = 1414810956(0x54544d4c, float:3.64731957E12)
            r35 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r3 != r4) goto L_0x0367
            java.lang.String r3 = "application/ttml+xml"
        L_0x035d:
            r37 = r10
            r4 = 0
            r46 = r35
            r36 = r9
            r9 = r46
            goto L_0x03a5
        L_0x0367:
            r4 = 1954034535(0x74783367, float:7.865797E31)
            if (r3 != r4) goto L_0x0388
            int r3 = r13 + -16
            byte[] r4 = new byte[r3]
            r6 = 0
            r8.zzB(r4, r6, r3)
            com.google.android.gms.internal.ads.zzfss r3 = com.google.android.gms.internal.ads.zzfss.zzp(r4)
            java.lang.String r4 = "application/x-quicktime-tx3g"
            r37 = r10
            r46 = r4
            r4 = r3
            r3 = r46
            r47 = r35
            r36 = r9
            r9 = r47
            goto L_0x03a5
        L_0x0388:
            r4 = 2004251764(0x77767474, float:4.998699E33)
            if (r3 != r4) goto L_0x0390
            java.lang.String r3 = "application/x-mp4-vtt"
            goto L_0x035d
        L_0x0390:
            r4 = 1937010800(0x73747070, float:1.9366469E31)
            if (r3 != r4) goto L_0x039f
            java.lang.String r3 = "application/ttml+xml"
            r36 = r9
            r37 = r10
            r4 = 0
            r9 = 0
            goto L_0x03a5
        L_0x039f:
            r3 = 1
            r2.zzd = r3
            java.lang.String r3 = "application/x-mp4-cea-608"
            goto L_0x035d
        L_0x03a5:
            com.google.android.gms.internal.ads.zzz r6 = new com.google.android.gms.internal.ads.zzz
            r6.<init>()
            r6.zzG(r7)
            r6.zzS(r3)
            r6.zzK(r5)
            r6.zzW(r9)
            r6.zzI(r4)
            com.google.android.gms.internal.ads.zzab r3 = r6.zzY()
            r2.zzb = r3
            r17 = r0
            r9 = r2
            r20 = r5
            r1 = r7
            r40 = r11
            r23 = r13
            r18 = r14
            r45 = r26
            r3 = r34
            r22 = r36
            r39 = r37
        L_0x03d3:
            r14 = r8
            goto L_0x06f6
        L_0x03d6:
            r36 = r9
            r37 = r10
            r9 = r2
            r2 = r8
            r6 = 12
            r10 = 2
            r4 = r15
            r20 = r5
            r1 = 4
            r5 = r13
            r1 = r34
            r6 = r7
            r18 = r14
            r14 = r7
            r46 = r26
            r26 = r1
            r1 = r46
            r7 = r20
            r27 = r14
            r14 = r8
            r8 = r55
            r17 = r9
            r22 = r36
            r9 = r53
            r36 = r1
            r1 = r10
            r39 = r37
            r10 = r17
            r40 = r11
            r11 = r0
            zzj(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r23 = r13
            r9 = r17
            r3 = r26
            r1 = r27
            r45 = r36
            r17 = r0
            goto L_0x06f6
        L_0x0418:
            r17 = r2
            r20 = r5
            r27 = r7
            r22 = r9
            r39 = r10
            r40 = r11
            r18 = r14
            r36 = r26
            r26 = r34
            r1 = 2
            r14 = r8
            int r2 = r15 + 16
            r14.zzF(r2)
            r2 = 16
            r14.zzG(r2)
            int r4 = r14.zzo()
            int r5 = r14.zzo()
            r7 = 50
            r14.zzG(r7)
            int r7 = r14.zzc()
            if (r3 != r6) goto L_0x047b
            android.util.Pair r3 = zzi(r14, r15, r13)
            if (r3 == 0) goto L_0x0473
            java.lang.Object r6 = r3.first
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            if (r12 != 0) goto L_0x045d
            r9 = r17
            r8 = 0
            goto L_0x0469
        L_0x045d:
            java.lang.Object r8 = r3.second
            com.google.android.gms.internal.ads.zzacl r8 = (com.google.android.gms.internal.ads.zzacl) r8
            java.lang.String r8 = r8.zzb
            com.google.android.gms.internal.ads.zzs r8 = r12.zza(r8)
            r9 = r17
        L_0x0469:
            com.google.android.gms.internal.ads.zzacl[] r10 = r9.zza
            java.lang.Object r3 = r3.second
            com.google.android.gms.internal.ads.zzacl r3 = (com.google.android.gms.internal.ads.zzacl) r3
            r10[r0] = r3
            r3 = r6
            goto L_0x0477
        L_0x0473:
            r9 = r17
            r3 = r6
            r8 = r12
        L_0x0477:
            r14.zzF(r7)
            goto L_0x047e
        L_0x047b:
            r9 = r17
            r8 = r12
        L_0x047e:
            r6 = 1831958048(0x6d317620, float:3.4326032E27)
            if (r3 != r6) goto L_0x048b
            java.lang.String r6 = "video/mpeg"
            r46 = r6
            r6 = r3
            r3 = r46
            goto L_0x0495
        L_0x048b:
            r6 = 1211250227(0x48323633, float:182488.8)
            if (r3 != r6) goto L_0x0493
            java.lang.String r3 = "video/3gpp"
            goto L_0x0495
        L_0x0493:
            r6 = r3
            r3 = 0
        L_0x0495:
            r10 = 1065353216(0x3f800000, float:1.0)
            r11 = r7
            r44 = r10
            r2 = 0
            r10 = -1
            r41 = 0
            r42 = 0
            r43 = 0
            r7 = r3
            r3 = 0
        L_0x04a4:
            int r1 = r11 - r15
            if (r1 >= r13) goto L_0x06ae
            r14.zzF(r11)
            int r1 = r14.zzc()
            int r17 = r14.zze()
            if (r17 != 0) goto L_0x04c1
            int r17 = r14.zzc()
            int r12 = r17 - r15
            if (r12 != r13) goto L_0x04bf
            goto L_0x06ae
        L_0x04bf:
            r12 = 0
            goto L_0x04c3
        L_0x04c1:
            r12 = r17
        L_0x04c3:
            if (r12 <= 0) goto L_0x04cb
            r17 = r0
            r23 = r13
            r0 = 1
            goto L_0x04d0
        L_0x04cb:
            r17 = r0
            r23 = r13
            r0 = 0
        L_0x04d0:
            java.lang.String r13 = "childAtomSize must be positive"
            com.google.android.gms.internal.ads.zzwt.zzb(r0, r13)
            int r0 = r14.zze()
            r13 = 1635148611(0x61766343, float:2.8406573E20)
            if (r0 != r13) goto L_0x050a
            if (r7 != 0) goto L_0x04e2
            r0 = 1
            goto L_0x04e3
        L_0x04e2:
            r0 = 0
        L_0x04e3:
            r2 = 0
            com.google.android.gms.internal.ads.zzwt.zzb(r0, r2)
            int r1 = r1 + 8
            r14.zzF(r1)
            com.google.android.gms.internal.ads.zzvz r0 = com.google.android.gms.internal.ads.zzvz.zza(r14)
            java.util.List<byte[]> r1 = r0.zza
            int r2 = r0.zzb
            r9.zzc = r2
            if (r3 != 0) goto L_0x04fc
            float r2 = r0.zze
            r44 = r2
        L_0x04fc:
            java.lang.String r0 = r0.zzf
            java.lang.String r2 = "video/avc"
        L_0x0500:
            r41 = r0
            r7 = r2
            r45 = r36
            r2 = r1
        L_0x0506:
            r36 = r6
            goto L_0x06a1
        L_0x050a:
            r13 = 1752589123(0x68766343, float:4.6541328E24)
            if (r0 != r13) goto L_0x0532
            if (r7 != 0) goto L_0x0513
            r0 = 1
            goto L_0x0514
        L_0x0513:
            r0 = 0
        L_0x0514:
            r2 = 0
            com.google.android.gms.internal.ads.zzwt.zzb(r0, r2)
            int r1 = r1 + 8
            r14.zzF(r1)
            com.google.android.gms.internal.ads.zzxg r0 = com.google.android.gms.internal.ads.zzxg.zza(r14)
            java.util.List<byte[]> r1 = r0.zza
            int r2 = r0.zzb
            r9.zzc = r2
            if (r3 != 0) goto L_0x052d
            float r2 = r0.zzc
            r44 = r2
        L_0x052d:
            java.lang.String r0 = r0.zzd
            java.lang.String r2 = "video/hevc"
            goto L_0x0500
        L_0x0532:
            r13 = 1685480259(0x64766343, float:1.8180206E22)
            if (r0 == r13) goto L_0x068d
            r13 = 1685485123(0x64767643, float:1.8185683E22)
            if (r0 != r13) goto L_0x053e
            goto L_0x068d
        L_0x053e:
            r13 = 1987076931(0x76706343, float:1.21891066E33)
            if (r0 != r13) goto L_0x0557
            if (r7 != 0) goto L_0x0547
            r0 = 1
            goto L_0x0548
        L_0x0547:
            r0 = 0
        L_0x0548:
            r1 = 0
            com.google.android.gms.internal.ads.zzwt.zzb(r0, r1)
            r0 = 1987063864(0x76703038, float:1.21789965E33)
            if (r6 != r0) goto L_0x0554
            java.lang.String r0 = "video/x-vnd.on2.vp8"
            goto L_0x0567
        L_0x0554:
            java.lang.String r0 = "video/x-vnd.on2.vp9"
            goto L_0x0567
        L_0x0557:
            r13 = 1635135811(0x61763143, float:2.8384055E20)
            if (r0 != r13) goto L_0x056b
            if (r7 != 0) goto L_0x0560
            r0 = 1
            goto L_0x0561
        L_0x0560:
            r0 = 0
        L_0x0561:
            r13 = 0
            com.google.android.gms.internal.ads.zzwt.zzb(r0, r13)
            java.lang.String r0 = "video/av01"
        L_0x0567:
            r7 = r0
        L_0x0568:
            r45 = r36
            goto L_0x0506
        L_0x056b:
            r13 = 1681012275(0x64323633, float:1.3149704E22)
            if (r0 != r13) goto L_0x057c
            if (r7 != 0) goto L_0x0574
            r0 = 1
            goto L_0x0575
        L_0x0574:
            r0 = 0
        L_0x0575:
            r13 = 0
            com.google.android.gms.internal.ads.zzwt.zzb(r0, r13)
            java.lang.String r0 = "video/3gpp"
            goto L_0x0567
        L_0x057c:
            r13 = 1702061171(0x65736473, float:7.183675E22)
            if (r0 != r13) goto L_0x059e
            if (r7 != 0) goto L_0x0585
            r0 = 1
            goto L_0x0586
        L_0x0585:
            r0 = 0
        L_0x0586:
            r7 = 0
            com.google.android.gms.internal.ads.zzwt.zzb(r0, r7)
            android.util.Pair r0 = zzh(r14, r1)
            java.lang.Object r1 = r0.first
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r0 = r0.second
            byte[] r0 = (byte[]) r0
            if (r0 == 0) goto L_0x059c
            com.google.android.gms.internal.ads.zzfss r2 = com.google.android.gms.internal.ads.zzfss.zzp(r0)
        L_0x059c:
            r7 = r1
            goto L_0x0568
        L_0x059e:
            r13 = 1885434736(0x70617370, float:2.7909473E29)
            if (r0 != r13) goto L_0x05ba
            int r1 = r1 + 8
            r14.zzF(r1)
            int r0 = r14.zzn()
            float r0 = (float) r0
            int r1 = r14.zzn()
            float r1 = (float) r1
            float r0 = r0 / r1
            r44 = r0
            r45 = r36
            r3 = 1
            goto L_0x0506
        L_0x05ba:
            r13 = 1937126244(0x73763364, float:1.9506033E31)
            if (r0 != r13) goto L_0x05ef
            int r0 = r1 + 8
        L_0x05c1:
            int r13 = r0 - r1
            if (r13 >= r12) goto L_0x05e9
            r14.zzF(r0)
            int r13 = r14.zze()
            r28 = r1
            int r1 = r14.zze()
            r37 = r3
            r3 = 1886547818(0x70726f6a, float:3.0012025E29)
            if (r1 != r3) goto L_0x05e3
            byte[] r1 = r14.zzH()
            int r13 = r13 + r0
            byte[] r0 = java.util.Arrays.copyOfRange(r1, r0, r13)
            goto L_0x05ec
        L_0x05e3:
            int r0 = r0 + r13
            r1 = r28
            r3 = r37
            goto L_0x05c1
        L_0x05e9:
            r37 = r3
            r0 = 0
        L_0x05ec:
            r42 = r0
            goto L_0x0616
        L_0x05ef:
            r37 = r3
            r1 = 1936995172(0x73743364, float:1.9347576E31)
            if (r0 != r1) goto L_0x061c
            int r0 = r14.zzk()
            r1 = 3
            r14.zzG(r1)
            if (r0 != 0) goto L_0x0616
            int r0 = r14.zzk()
            if (r0 == 0) goto L_0x0615
            r3 = 1
            if (r0 == r3) goto L_0x0613
            r3 = 2
            if (r0 == r3) goto L_0x0611
            if (r0 == r1) goto L_0x060f
            goto L_0x0616
        L_0x060f:
            r10 = r1
            goto L_0x0616
        L_0x0611:
            r10 = 2
            goto L_0x0616
        L_0x0613:
            r10 = 1
            goto L_0x0616
        L_0x0615:
            r10 = 0
        L_0x0616:
            r45 = r36
            r3 = r37
            goto L_0x0506
        L_0x061c:
            r1 = 3
            r3 = 1668246642(0x636f6c72, float:4.4165861E21)
            if (r0 != r3) goto L_0x0688
            int r0 = r14.zze()
            r3 = 1852009592(0x6e636c78, float:1.7596057E28)
            if (r0 == r3) goto L_0x064f
            r3 = 1852009571(0x6e636c63, float:1.7596032E28)
            if (r0 != r3) goto L_0x0631
            goto L_0x064f
        L_0x0631:
            java.lang.String r0 = com.google.android.gms.internal.ads.zzabn.zzf(r0)
            int r3 = r0.length()
            java.lang.String r13 = "Unsupported color type: "
            if (r3 == 0) goto L_0x0642
            java.lang.String r0 = r13.concat(r0)
            goto L_0x0647
        L_0x0642:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r13)
        L_0x0647:
            r3 = r36
            android.util.Log.w(r3, r0)
            r45 = r3
            goto L_0x068a
        L_0x064f:
            r3 = r36
            int r13 = r14.zzo()
            int r16 = r14.zzo()
            r1 = 2
            r14.zzG(r1)
            r1 = 1852009592(0x6e636c78, float:1.7596057E28)
            if (r0 != r1) goto L_0x066c
            int r0 = r14.zzk()
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x066c
            r0 = 1
            goto L_0x066d
        L_0x066c:
            r0 = 0
        L_0x066d:
            int r1 = com.google.android.gms.internal.ads.zzm.zza(r13)
            r13 = 1
            if (r13 == r0) goto L_0x0676
            r0 = 2
            goto L_0x0677
        L_0x0676:
            r0 = 1
        L_0x0677:
            com.google.android.gms.internal.ads.zzm r13 = new com.google.android.gms.internal.ads.zzm
            r36 = r6
            int r6 = com.google.android.gms.internal.ads.zzm.zzb(r16)
            r45 = r3
            r3 = 0
            r13.<init>(r1, r0, r6, r3)
            r43 = r13
            goto L_0x069f
        L_0x0688:
            r45 = r36
        L_0x068a:
            r36 = r6
            goto L_0x069f
        L_0x068d:
            r37 = r3
            r45 = r36
            r36 = r6
            com.google.android.gms.internal.ads.zzwm r0 = com.google.android.gms.internal.ads.zzwm.zza(r14)
            if (r0 == 0) goto L_0x069f
            java.lang.String r0 = r0.zza
            java.lang.String r7 = "video/dolby-vision"
            r41 = r0
        L_0x069f:
            r3 = r37
        L_0x06a1:
            int r11 = r11 + r12
            r12 = r53
            r0 = r17
            r13 = r23
            r6 = r36
            r36 = r45
            goto L_0x04a4
        L_0x06ae:
            r17 = r0
            r23 = r13
            r45 = r36
            if (r7 == 0) goto L_0x06f2
            com.google.android.gms.internal.ads.zzz r0 = new com.google.android.gms.internal.ads.zzz
            r0.<init>()
            r1 = r27
            r0.zzG(r1)
            r0.zzS(r7)
            r3 = r41
            r0.zzx(r3)
            r0.zzX(r4)
            r0.zzF(r5)
            r3 = r44
            r0.zzP(r3)
            r3 = r26
            r0.zzR(r3)
            r4 = r42
            r0.zzQ(r4)
            r0.zzV(r10)
            r0.zzI(r2)
            r0.zzB(r8)
            r2 = r43
            r0.zzy(r2)
            com.google.android.gms.internal.ads.zzab r0 = r0.zzY()
            r9.zzb = r0
            goto L_0x06f6
        L_0x06f2:
            r3 = r26
            r1 = r27
        L_0x06f6:
            int r15 = r15 + r23
            r14.zzF(r15)
            int r0 = r17 + 1
            r12 = r53
            r7 = r1
            r6 = r3
            r2 = r9
            r8 = r14
            r14 = r18
            r5 = r20
            r9 = r22
            r13 = r32
            r3 = r33
            r10 = r39
            r11 = r40
            r26 = r45
            r4 = 12
            r15 = 3
            r1 = r50
            goto L_0x01f2
        L_0x071a:
            r22 = r9
            r39 = r10
            r40 = r11
            r32 = r13
            r18 = r14
            r45 = r26
            r9 = r2
            r0 = 1701082227(0x65647473, float:6.742798E22)
            r2 = r40
            com.google.android.gms.internal.ads.zzabl r0 = r2.zza(r0)
            if (r0 == 0) goto L_0x0797
            r1 = 1701606260(0x656c7374, float:6.9788014E22)
            com.google.android.gms.internal.ads.zzabm r0 = r0.zzb(r1)
            if (r0 != 0) goto L_0x073d
            r8 = 0
            goto L_0x078c
        L_0x073d:
            com.google.android.gms.internal.ads.zzfd r0 = r0.zza
            r1 = 8
            r0.zzF(r1)
            int r1 = r0.zze()
            int r1 = com.google.android.gms.internal.ads.zzabn.zze(r1)
            int r3 = r0.zzn()
            long[] r4 = new long[r3]
            long[] r5 = new long[r3]
            r6 = 0
        L_0x0755:
            if (r6 >= r3) goto L_0x0788
            r7 = 1
            if (r1 != r7) goto L_0x075f
            long r10 = r0.zzt()
            goto L_0x0763
        L_0x075f:
            long r10 = r0.zzs()
        L_0x0763:
            r4[r6] = r10
            if (r1 != r7) goto L_0x076c
            long r10 = r0.zzr()
            goto L_0x0771
        L_0x076c:
            int r8 = r0.zze()
            long r10 = (long) r8
        L_0x0771:
            r5[r6] = r10
            short r8 = r0.zzy()
            if (r8 != r7) goto L_0x0780
            r7 = 2
            r0.zzG(r7)
            int r6 = r6 + 1
            goto L_0x0755
        L_0x0780:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Unsupported media rate."
            r0.<init>(r1)
            throw r0
        L_0x0788:
            android.util.Pair r8 = android.util.Pair.create(r4, r5)
        L_0x078c:
            if (r8 == 0) goto L_0x0797
            java.lang.Object r0 = r8.first
            long[] r0 = (long[]) r0
            java.lang.Object r1 = r8.second
            long[] r1 = (long[]) r1
            goto L_0x0799
        L_0x0797:
            r0 = 0
            r1 = 0
        L_0x0799:
            com.google.android.gms.internal.ads.zzab r3 = r9.zzb
            if (r3 != 0) goto L_0x07a1
            r0 = r56
            goto L_0x0060
        L_0x07a1:
            com.google.android.gms.internal.ads.zzack r8 = new com.google.android.gms.internal.ads.zzack
            int r17 = r18.zza
            r3 = r39
            java.lang.Object r3 = r3.first
            java.lang.Long r3 = (java.lang.Long) r3
            long r19 = r3.longValue()
            com.google.android.gms.internal.ads.zzab r3 = r9.zzb
            int r4 = r9.zzd
            com.google.android.gms.internal.ads.zzacl[] r5 = r9.zza
            int r6 = r9.zzc
            r16 = r8
            r18 = r22
            r21 = r29
            r23 = r24
            r25 = r3
            r26 = r4
            r27 = r5
            r28 = r6
            r29 = r0
            r30 = r1
            r16.<init>(r17, r18, r19, r21, r23, r25, r26, r27, r28, r29, r30)
            r0 = r56
        L_0x07d2:
            java.lang.Object r1 = r0.apply(r8)
            r4 = r1
            com.google.android.gms.internal.ads.zzack r4 = (com.google.android.gms.internal.ads.zzack) r4
            if (r4 == 0) goto L_0x0dab
            r1 = 1835297121(0x6d646961, float:4.4181236E27)
            com.google.android.gms.internal.ads.zzabl r1 = r2.zza(r1)
            r1.getClass()
            r2 = 1835626086(0x6d696e66, float:4.515217E27)
            com.google.android.gms.internal.ads.zzabl r1 = r1.zza(r2)
            r1.getClass()
            r2 = 1937007212(0x7374626c, float:1.9362132E31)
            com.google.android.gms.internal.ads.zzabl r1 = r1.zza(r2)
            r1.getClass()
            r2 = 1937011578(0x7374737a, float:1.936741E31)
            com.google.android.gms.internal.ads.zzabm r2 = r1.zzb(r2)
            if (r2 == 0) goto L_0x080a
            com.google.android.gms.internal.ads.zzabr r3 = new com.google.android.gms.internal.ads.zzabr
            com.google.android.gms.internal.ads.zzab r5 = r4.zzf
            r3.<init>(r2, r5)
            goto L_0x0818
        L_0x080a:
            r2 = 1937013298(0x73747a32, float:1.9369489E31)
            com.google.android.gms.internal.ads.zzabm r2 = r1.zzb(r2)
            if (r2 == 0) goto L_0x0da3
            com.google.android.gms.internal.ads.zzabs r3 = new com.google.android.gms.internal.ads.zzabs
            r3.<init>(r2)
        L_0x0818:
            int r2 = r3.zzb()
            if (r2 != 0) goto L_0x0834
            com.google.android.gms.internal.ads.zzacn r1 = new com.google.android.gms.internal.ads.zzacn
            r2 = 0
            long[] r5 = new long[r2]
            int[] r6 = new int[r2]
            r7 = 0
            long[] r8 = new long[r2]
            int[] r9 = new int[r2]
            r10 = 0
            r3 = r1
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
        L_0x0830:
            r0 = r32
            goto L_0x0d9f
        L_0x0834:
            r5 = 1937007471(0x7374636f, float:1.9362445E31)
            com.google.android.gms.internal.ads.zzabm r5 = r1.zzb(r5)
            if (r5 != 0) goto L_0x084a
            r5 = 1668232756(0x636f3634, float:4.4126776E21)
            com.google.android.gms.internal.ads.zzabm r5 = r1.zzb(r5)
            r5.getClass()
            r6 = r5
            r5 = 1
            goto L_0x084c
        L_0x084a:
            r6 = r5
            r5 = 0
        L_0x084c:
            com.google.android.gms.internal.ads.zzfd r6 = r6.zza
            r7 = 1937011555(0x73747363, float:1.9367382E31)
            com.google.android.gms.internal.ads.zzabm r7 = r1.zzb(r7)
            r7.getClass()
            com.google.android.gms.internal.ads.zzfd r7 = r7.zza
            r8 = 1937011827(0x73747473, float:1.9367711E31)
            com.google.android.gms.internal.ads.zzabm r8 = r1.zzb(r8)
            r8.getClass()
            com.google.android.gms.internal.ads.zzfd r8 = r8.zza
            r9 = 1937011571(0x73747373, float:1.9367401E31)
            com.google.android.gms.internal.ads.zzabm r9 = r1.zzb(r9)
            if (r9 == 0) goto L_0x0872
            com.google.android.gms.internal.ads.zzfd r9 = r9.zza
            goto L_0x0873
        L_0x0872:
            r9 = 0
        L_0x0873:
            r10 = 1668576371(0x63747473, float:4.5093966E21)
            com.google.android.gms.internal.ads.zzabm r1 = r1.zzb(r10)
            if (r1 == 0) goto L_0x087f
            com.google.android.gms.internal.ads.zzfd r1 = r1.zza
            goto L_0x0880
        L_0x087f:
            r1 = 0
        L_0x0880:
            com.google.android.gms.internal.ads.zzabo r10 = new com.google.android.gms.internal.ads.zzabo
            r10.<init>(r7, r6, r5)
            r5 = 12
            r8.zzF(r5)
            int r6 = r8.zzn()
            r7 = -1
            int r6 = r6 + r7
            int r7 = r8.zzn()
            int r11 = r8.zzn()
            if (r1 == 0) goto L_0x08a2
            r1.zzF(r5)
            int r12 = r1.zzn()
            goto L_0x08a3
        L_0x08a2:
            r12 = 0
        L_0x08a3:
            if (r9 == 0) goto L_0x08b9
            r9.zzF(r5)
            int r5 = r9.zzn()
            if (r5 <= 0) goto L_0x08b5
            int r13 = r9.zzn()
            r14 = -1
            int r13 = r13 + r14
            goto L_0x08bc
        L_0x08b5:
            r14 = -1
            r13 = r14
            r9 = 0
            goto L_0x08bc
        L_0x08b9:
            r14 = -1
            r13 = r14
            r5 = 0
        L_0x08bc:
            int r15 = r3.zza()
            com.google.android.gms.internal.ads.zzab r0 = r4.zzf
            java.lang.String r0 = r0.zzm
            if (r15 == r14) goto L_0x096c
            java.lang.String r14 = "audio/raw"
            boolean r14 = r14.equals(r0)
            if (r14 != 0) goto L_0x08de
            java.lang.String r14 = "audio/g711-mlaw"
            boolean r14 = r14.equals(r0)
            if (r14 != 0) goto L_0x08de
            java.lang.String r14 = "audio/g711-alaw"
            boolean r0 = r14.equals(r0)
            if (r0 == 0) goto L_0x096c
        L_0x08de:
            if (r6 != 0) goto L_0x096c
            if (r12 != 0) goto L_0x096b
            if (r5 != 0) goto L_0x096b
            int r0 = r10.zza
            long[] r1 = new long[r0]
            int[] r3 = new int[r0]
        L_0x08ea:
            boolean r5 = r10.zza()
            if (r5 == 0) goto L_0x08fb
            int r5 = r10.zzb
            long r6 = r10.zzd
            r1[r5] = r6
            int r6 = r10.zzc
            r3[r5] = r6
            goto L_0x08ea
        L_0x08fb:
            long r5 = (long) r11
            r7 = 8192(0x2000, float:1.14794E-41)
            int r7 = r7 / r15
            r8 = 0
            r9 = 0
        L_0x0901:
            if (r8 >= r0) goto L_0x090d
            r10 = r3[r8]
            int r10 = com.google.android.gms.internal.ads.zzfn.zze(r10, r7)
            int r9 = r9 + r10
            int r8 = r8 + 1
            goto L_0x0901
        L_0x090d:
            long[] r8 = new long[r9]
            int[] r10 = new int[r9]
            long[] r11 = new long[r9]
            int[] r9 = new int[r9]
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
        L_0x091a:
            if (r12 >= r0) goto L_0x095f
            r17 = r3[r12]
            r18 = r1[r12]
            r46 = r17
            r17 = r0
            r0 = r46
        L_0x0926:
            if (r0 <= 0) goto L_0x0953
            int r20 = java.lang.Math.min(r7, r0)
            r8[r16] = r18
            r21 = r1
            int r1 = r15 * r20
            r10[r16] = r1
            int r14 = java.lang.Math.max(r14, r1)
            r1 = r7
            r22 = r8
            long r7 = (long) r13
            long r7 = r7 * r5
            r11[r16] = r7
            r7 = 1
            r9[r16] = r7
            r7 = r10[r16]
            long r7 = (long) r7
            long r18 = r18 + r7
            int r13 = r13 + r20
            int r0 = r0 - r20
            int r16 = r16 + 1
            r7 = r1
            r1 = r21
            r8 = r22
            goto L_0x0926
        L_0x0953:
            r21 = r1
            r1 = r7
            r22 = r8
            int r12 = r12 + 1
            r0 = r17
            r1 = r21
            goto L_0x091a
        L_0x095f:
            r22 = r8
            long r0 = (long) r13
            long r5 = r5 * r0
            r0 = r5
            r12 = r9
            r15 = r11
            r9 = r22
            r11 = r4
            goto L_0x0b22
        L_0x096b:
            r6 = 0
        L_0x096c:
            long[] r0 = new long[r2]
            int[] r14 = new int[r2]
            long[] r15 = new long[r2]
            r16 = r5
            int[] r5 = new int[r2]
            r19 = r4
            r17 = r7
            r4 = r11
            r20 = r12
            r12 = r13
            r7 = 0
            r11 = 0
            r18 = 0
            r21 = 0
            r22 = 0
            r24 = 0
            r13 = r6
            r6 = 0
        L_0x098a:
            if (r6 >= r2) goto L_0x0a5e
            r26 = 1
        L_0x098e:
            if (r18 != 0) goto L_0x09b3
            boolean r26 = r10.zza()
            if (r26 == 0) goto L_0x09ab
            r27 = r11
            r28 = r12
            long r11 = r10.zzd
            r29 = r2
            int r2 = r10.zzc
            r18 = r2
            r22 = r11
            r11 = r27
            r12 = r28
            r2 = r29
            goto L_0x098e
        L_0x09ab:
            r29 = r2
            r27 = r11
            r28 = r12
            r2 = 0
            goto L_0x09bb
        L_0x09b3:
            r29 = r2
            r27 = r11
            r28 = r12
            r2 = r18
        L_0x09bb:
            if (r26 != 0) goto L_0x09db
            java.lang.String r2 = "Unexpected end of chunk data"
            r11 = r45
            android.util.Log.w(r11, r2)
            long[] r0 = java.util.Arrays.copyOf(r0, r6)
            int[] r14 = java.util.Arrays.copyOf(r14, r6)
            long[] r15 = java.util.Arrays.copyOf(r15, r6)
            int[] r5 = java.util.Arrays.copyOf(r5, r6)
            r2 = r6
            r36 = r11
            r12 = r27
            goto L_0x0a65
        L_0x09db:
            r11 = r45
            if (r1 == 0) goto L_0x09f5
        L_0x09df:
            if (r21 != 0) goto L_0x09f2
            if (r20 <= 0) goto L_0x09ee
            int r21 = r1.zzn()
            int r27 = r1.zze()
            int r20 = r20 + -1
            goto L_0x09df
        L_0x09ee:
            r12 = -1
            r21 = 0
            goto L_0x09f3
        L_0x09f2:
            r12 = -1
        L_0x09f3:
            int r21 = r21 + -1
        L_0x09f5:
            r12 = r27
            r0[r6] = r22
            r26 = r0
            int r0 = r3.zzc()
            r14[r6] = r0
            if (r0 <= r7) goto L_0x0a04
            r7 = r0
        L_0x0a04:
            r0 = r10
            r36 = r11
            long r10 = (long) r12
            long r10 = r24 + r10
            r15[r6] = r10
            if (r9 != 0) goto L_0x0a10
            r10 = 1
            goto L_0x0a11
        L_0x0a10:
            r10 = 0
        L_0x0a11:
            r5[r6] = r10
            r10 = r28
            if (r6 != r10) goto L_0x0a27
            r11 = 1
            r5[r6] = r11
            int r16 = r16 + -1
            if (r16 <= 0) goto L_0x0a27
            r9.getClass()
            int r10 = r9.zzn()
            r11 = -1
            int r10 = r10 + r11
        L_0x0a27:
            r11 = r9
            r18 = r10
            long r9 = (long) r4
            long r24 = r24 + r9
            int r9 = r17 + -1
            if (r9 != 0) goto L_0x0a44
            if (r13 <= 0) goto L_0x0a41
            int r4 = r8.zzn()
            int r9 = r8.zze()
            int r13 = r13 + -1
            r17 = r4
            r4 = r9
            goto L_0x0a46
        L_0x0a41:
            r17 = 0
            goto L_0x0a46
        L_0x0a44:
            r17 = r9
        L_0x0a46:
            r9 = r14[r6]
            long r9 = (long) r9
            long r22 = r22 + r9
            r9 = -1
            int r2 = r2 + r9
            int r6 = r6 + 1
            r10 = r0
            r9 = r11
            r11 = r12
            r12 = r18
            r0 = r26
            r45 = r36
            r18 = r2
            r2 = r29
            goto L_0x098a
        L_0x0a5e:
            r26 = r0
            r29 = r2
            r36 = r45
            r12 = r11
        L_0x0a65:
            long r3 = (long) r12
            long r3 = r24 + r3
            if (r1 == 0) goto L_0x0a7a
        L_0x0a6a:
            if (r20 <= 0) goto L_0x0a7a
            int r6 = r1.zzn()
            if (r6 == 0) goto L_0x0a74
            r1 = 0
            goto L_0x0a7b
        L_0x0a74:
            r1.zze()
            int r20 = r20 + -1
            goto L_0x0a6a
        L_0x0a7a:
            r1 = 1
        L_0x0a7b:
            if (r16 != 0) goto L_0x0abb
            if (r17 != 0) goto L_0x0ab1
            if (r18 != 0) goto L_0x0aa8
            if (r13 != 0) goto L_0x0aa0
            if (r21 != 0) goto L_0x0a97
            if (r1 != 0) goto L_0x0a8f
            r11 = r19
            r1 = 0
            r6 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            goto L_0x0a9e
        L_0x0a8f:
            r16 = r0
            r17 = r2
            r11 = r19
            goto L_0x0b1a
        L_0x0a97:
            r11 = r19
            r10 = r21
            r6 = 0
            r8 = 0
            r9 = 0
        L_0x0a9e:
            r13 = 0
            goto L_0x0ac5
        L_0x0aa0:
            r11 = r19
            r10 = r21
            r6 = 0
            r8 = 0
            r9 = 0
            goto L_0x0ac5
        L_0x0aa8:
            r9 = r18
            r11 = r19
            r10 = r21
            r6 = 0
            r8 = 0
            goto L_0x0ac5
        L_0x0ab1:
            r8 = r17
            r9 = r18
            r11 = r19
            r10 = r21
            r6 = 0
            goto L_0x0ac5
        L_0x0abb:
            r6 = r16
            r8 = r17
            r9 = r18
            r11 = r19
            r10 = r21
        L_0x0ac5:
            int r12 = r11.zza
            r16 = r0
            r0 = 1
            if (r0 == r1) goto L_0x0acf
            java.lang.String r0 = ", ctts invalid"
            goto L_0x0ad1
        L_0x0acf:
            java.lang.String r0 = ""
        L_0x0ad1:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r17 = r2
            int r2 = r0.length()
            int r2 = r2 + 262
            r1.<init>(r2)
            java.lang.String r2 = "Inconsistent stbl box for track "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r2 = ": remainingSynchronizationSamples "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r2 = ", remainingSamplesAtTimestampDelta "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r2 = ", remainingSamplesInChunk "
            r1.append(r2)
            r1.append(r9)
            java.lang.String r2 = ", remainingTimestampDeltaChanges "
            r1.append(r2)
            r1.append(r13)
            java.lang.String r2 = ", remainingSamplesAtTimestampOffset "
            r1.append(r2)
            r1.append(r10)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r1 = r36
            android.util.Log.w(r1, r0)
        L_0x0b1a:
            r0 = r3
            r12 = r5
            r10 = r14
            r9 = r16
            r2 = r17
            r14 = r7
        L_0x0b22:
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r7 = r11.zzc
            r3 = r0
            long r16 = com.google.android.gms.internal.ads.zzfn.zzt(r3, r5, r7)
            long[] r3 = r11.zzh
            if (r3 != 0) goto L_0x0b48
            r0 = 1000000(0xf4240, double:4.940656E-318)
            long r2 = r11.zzc
            com.google.android.gms.internal.ads.zzfn.zzN(r15, r0, r2)
            com.google.android.gms.internal.ads.zzacn r1 = new com.google.android.gms.internal.ads.zzacn
            r3 = r1
            r4 = r11
            r5 = r9
            r6 = r10
            r7 = r14
            r8 = r15
            r9 = r12
            r10 = r16
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            goto L_0x0830
        L_0x0b48:
            int r4 = r3.length
            r5 = 1
            if (r4 != r5) goto L_0x0bfe
            int r4 = r11.zzb
            if (r4 != r5) goto L_0x0bfe
            int r4 = r15.length
            r5 = 2
            if (r4 < r5) goto L_0x0bfe
            long[] r5 = r11.zzi
            r5.getClass()
            r6 = 0
            r7 = r5[r6]
            r16 = r3[r6]
            r22 = r7
            long r6 = r11.zzc
            r5 = r2
            long r2 = r11.zzd
            r18 = r6
            r20 = r2
            long r2 = com.google.android.gms.internal.ads.zzfn.zzt(r16, r18, r20)
            long r7 = r22 + r2
            int r2 = r4 + -1
            r3 = 4
            r6 = 0
            int r3 = com.google.android.gms.internal.ads.zzfn.zzf(r3, r6, r2)
            int r4 = r4 + -4
            int r2 = com.google.android.gms.internal.ads.zzfn.zzf(r4, r6, r2)
            r16 = r15[r6]
            int r4 = (r16 > r22 ? 1 : (r16 == r22 ? 0 : -1))
            if (r4 > 0) goto L_0x0bfa
            r3 = r15[r3]
            int r3 = (r22 > r3 ? 1 : (r22 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0bfa
            r2 = r15[r2]
            int r2 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r2 >= 0) goto L_0x0bfa
            int r2 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x0bfa
            long r24 = r22 - r16
            com.google.android.gms.internal.ads.zzab r2 = r11.zzf
            int r2 = r2.zzA
            long r2 = (long) r2
            r6 = r5
            long r4 = r11.zzc
            r26 = r2
            r28 = r4
            long r2 = com.google.android.gms.internal.ads.zzfn.zzt(r24, r26, r28)
            long r16 = r0 - r7
            com.google.android.gms.internal.ads.zzab r4 = r11.zzf
            int r4 = r4.zzA
            long r4 = (long) r4
            long r7 = r11.zzc
            r18 = r4
            r20 = r7
            long r4 = com.google.android.gms.internal.ads.zzfn.zzt(r16, r18, r20)
            r7 = 0
            int r13 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r13 != 0) goto L_0x0bc0
            int r13 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r13 == 0) goto L_0x0bff
        L_0x0bc0:
            r7 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r7 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r7 > 0) goto L_0x0bff
            r7 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r7 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r7 > 0) goto L_0x0bff
            int r0 = (int) r2
            r2 = r50
            r2.zza = r0
            int r0 = (int) r4
            r2.zzb = r0
            r0 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r11.zzc
            com.google.android.gms.internal.ads.zzfn.zzN(r15, r0, r3)
            long[] r0 = r11.zzh
            r1 = 0
            r3 = r0[r1]
            long r7 = r11.zzd
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = com.google.android.gms.internal.ads.zzfn.zzt(r3, r5, r7)
            com.google.android.gms.internal.ads.zzacn r13 = new com.google.android.gms.internal.ads.zzacn
            r3 = r13
            r4 = r11
            r5 = r9
            r6 = r10
            r7 = r14
            r8 = r15
            r9 = r12
            r10 = r0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            goto L_0x0c49
        L_0x0bfa:
            r2 = r50
            r6 = r5
            goto L_0x0c01
        L_0x0bfe:
            r6 = r2
        L_0x0bff:
            r2 = r50
        L_0x0c01:
            long[] r3 = r11.zzh
            int r4 = r3.length
            r5 = 1
            if (r4 != r5) goto L_0x0c4d
            r5 = 0
            r7 = r3[r5]
            r3 = 0
            int r7 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r7 != 0) goto L_0x0c4c
            long[] r3 = r11.zzi
            r3.getClass()
            r6 = r3[r5]
            r3 = 0
        L_0x0c18:
            int r4 = r15.length
            if (r3 >= r4) goto L_0x0c2f
            r4 = r15[r3]
            long r16 = r4 - r6
            r18 = 1000000(0xf4240, double:4.940656E-318)
            long r4 = r11.zzc
            r20 = r4
            long r4 = com.google.android.gms.internal.ads.zzfn.zzt(r16, r18, r20)
            r15[r3] = r4
            int r3 = r3 + 1
            goto L_0x0c18
        L_0x0c2f:
            long r3 = r11.zzc
            long r16 = r0 - r6
            r18 = 1000000(0xf4240, double:4.940656E-318)
            r20 = r3
            long r0 = com.google.android.gms.internal.ads.zzfn.zzt(r16, r18, r20)
            com.google.android.gms.internal.ads.zzacn r13 = new com.google.android.gms.internal.ads.zzacn
            r3 = r13
            r4 = r11
            r5 = r9
            r6 = r10
            r7 = r14
            r8 = r15
            r9 = r12
            r10 = r0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
        L_0x0c49:
            r1 = r13
            goto L_0x0830
        L_0x0c4c:
            r4 = 1
        L_0x0c4d:
            int r0 = r11.zzb
            r1 = 1
            if (r0 != r1) goto L_0x0c54
            r3 = 1
            goto L_0x0c55
        L_0x0c54:
            r3 = 0
        L_0x0c55:
            int[] r0 = new int[r4]
            int[] r1 = new int[r4]
            long[] r4 = r11.zzi
            r4.getClass()
            r5 = 0
            r7 = 0
            r8 = 0
            r13 = 0
        L_0x0c62:
            long[] r2 = r11.zzh
            r16 = r14
            int r14 = r2.length
            if (r5 >= r14) goto L_0x0cca
            r14 = r9
            r17 = r10
            r9 = r4[r5]
            r18 = -1
            int r18 = (r9 > r18 ? 1 : (r9 == r18 ? 0 : -1))
            if (r18 == 0) goto L_0x0cb7
            r19 = r2[r5]
            r2 = r13
            r18 = r14
            long r13 = r11.zzc
            r25 = r6
            r26 = r7
            long r6 = r11.zzd
            r21 = r13
            r23 = r6
            long r6 = com.google.android.gms.internal.ads.zzfn.zzt(r19, r21, r23)
            r13 = 1
            int r14 = com.google.android.gms.internal.ads.zzfn.zzd(r15, r9, r13, r13)
            r0[r5] = r14
            long r9 = r9 + r6
            r14 = 0
            int r6 = com.google.android.gms.internal.ads.zzfn.zzb(r15, r9, r3, r14)
            r1[r5] = r6
        L_0x0c98:
            r6 = r0[r5]
            r7 = r1[r5]
            if (r6 >= r7) goto L_0x0ca9
            r9 = r12[r6]
            r9 = r9 & r13
            if (r9 != 0) goto L_0x0ca9
            int r6 = r6 + 1
            r0[r5] = r6
            r13 = 1
            goto L_0x0c98
        L_0x0ca9:
            int r9 = r7 - r6
            int r9 = r26 + r9
            if (r8 == r6) goto L_0x0cb1
            r6 = 1
            goto L_0x0cb2
        L_0x0cb1:
            r6 = r14
        L_0x0cb2:
            r2 = r2 | r6
            r13 = r2
            r8 = r7
            r7 = r9
            goto L_0x0cbf
        L_0x0cb7:
            r25 = r6
            r26 = r7
            r2 = r13
            r18 = r14
            r14 = 0
        L_0x0cbf:
            int r5 = r5 + 1
            r14 = r16
            r10 = r17
            r9 = r18
            r6 = r25
            goto L_0x0c62
        L_0x0cca:
            r5 = r6
            r18 = r9
            r17 = r10
            r2 = r13
            r14 = 0
            if (r7 == r5) goto L_0x0cd5
            r3 = 1
            goto L_0x0cd6
        L_0x0cd5:
            r3 = r14
        L_0x0cd6:
            r2 = r2 | r3
            if (r2 == 0) goto L_0x0cdd
            long[] r3 = new long[r7]
            r5 = r3
            goto L_0x0cdf
        L_0x0cdd:
            r5 = r18
        L_0x0cdf:
            if (r2 == 0) goto L_0x0ce5
            int[] r3 = new int[r7]
            r6 = r3
            goto L_0x0ce7
        L_0x0ce5:
            r6 = r17
        L_0x0ce7:
            r3 = 1
            if (r3 != r2) goto L_0x0cec
            r3 = r14
            goto L_0x0cee
        L_0x0cec:
            r3 = r16
        L_0x0cee:
            if (r2 == 0) goto L_0x0cf4
            int[] r4 = new int[r7]
            r9 = r4
            goto L_0x0cf5
        L_0x0cf4:
            r9 = r12
        L_0x0cf5:
            long[] r8 = new long[r7]
            r7 = r3
            r3 = r14
            r4 = r3
            r25 = 0
        L_0x0cfc:
            long[] r10 = r11.zzh
            int r10 = r10.length
            if (r3 >= r10) goto L_0x0d87
            long[] r10 = r11.zzi
            r27 = r10[r3]
            r10 = r0[r3]
            r13 = r1[r3]
            if (r2 == 0) goto L_0x0d1d
            int r14 = r13 - r10
            r16 = r0
            r0 = r18
            java.lang.System.arraycopy(r0, r10, r5, r4, r14)
            r0 = r17
            java.lang.System.arraycopy(r0, r10, r6, r4, r14)
            java.lang.System.arraycopy(r12, r10, r9, r4, r14)
            goto L_0x0d21
        L_0x0d1d:
            r16 = r0
            r0 = r17
        L_0x0d21:
            if (r10 >= r13) goto L_0x0d6a
            r21 = 1000000(0xf4240, double:4.940656E-318)
            r14 = r12
            r17 = r13
            long r12 = r11.zzd
            r19 = r25
            r23 = r12
            long r12 = com.google.android.gms.internal.ads.zzfn.zzt(r19, r21, r23)
            r19 = r15[r10]
            r22 = r14
            r21 = r15
            long r14 = r19 - r27
            r20 = r0
            r19 = r1
            r0 = 0
            long r33 = java.lang.Math.max(r0, r14)
            r35 = 1000000(0xf4240, double:4.940656E-318)
            long r14 = r11.zzc
            r37 = r14
            long r14 = com.google.android.gms.internal.ads.zzfn.zzt(r33, r35, r37)
            long r12 = r12 + r14
            r8[r4] = r12
            if (r2 == 0) goto L_0x0d5b
            r12 = r6[r4]
            if (r12 <= r7) goto L_0x0d5b
            r7 = r20[r10]
        L_0x0d5b:
            int r4 = r4 + 1
            int r10 = r10 + 1
            r13 = r17
            r1 = r19
            r0 = r20
            r15 = r21
            r12 = r22
            goto L_0x0d21
        L_0x0d6a:
            r20 = r0
            r19 = r1
            r22 = r12
            r21 = r15
            r0 = 0
            long[] r10 = r11.zzh
            r12 = r10[r3]
            long r25 = r25 + r12
            int r3 = r3 + 1
            r0 = r16
            r1 = r19
            r17 = r20
            r12 = r22
            r14 = 0
            goto L_0x0cfc
        L_0x0d87:
            long r0 = r11.zzd
            r21 = 1000000(0xf4240, double:4.940656E-318)
            r19 = r25
            r23 = r0
            long r0 = com.google.android.gms.internal.ads.zzfn.zzt(r19, r21, r23)
            com.google.android.gms.internal.ads.zzacn r2 = new com.google.android.gms.internal.ads.zzacn
            r3 = r2
            r4 = r11
            r10 = r0
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            r1 = r2
            goto L_0x0830
        L_0x0d9f:
            r0.add(r1)
            goto L_0x0dad
        L_0x0da3:
            java.lang.String r0 = "Track has no sample table size information"
            r1 = 0
            com.google.android.gms.internal.ads.zzbj r0 = com.google.android.gms.internal.ads.zzbj.zza(r0, r1)
            throw r0
        L_0x0dab:
            r0 = r32
        L_0x0dad:
            int r15 = r31 + 1
            r1 = r50
            r12 = r53
            r13 = r0
            r0 = r49
            goto L_0x000c
        L_0x0db8:
            r0 = r13
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzabu.zzc(com.google.android.gms.internal.ads.zzabl, com.google.android.gms.internal.ads.zzxf, long, com.google.android.gms.internal.ads.zzs, boolean, boolean, com.google.android.gms.internal.ads.zzfpv):java.util.List");
    }

    public static void zzd(zzfd zzfd) {
        int zzc = zzfd.zzc();
        zzfd.zzG(4);
        if (zzfd.zze() != 1751411826) {
            zzc += 4;
        }
        zzfd.zzF(zzc);
    }

    private static int zze(int i11) {
        if (i11 == 1936684398) {
            return 1;
        }
        if (i11 == 1986618469) {
            return 2;
        }
        if (i11 == 1952807028 || i11 == 1935832172 || i11 == 1937072756 || i11 == 1668047728) {
            return 3;
        }
        return i11 == 1835365473 ? 5 : -1;
    }

    private static int zzf(zzfd zzfd) {
        int zzk = zzfd.zzk();
        int i11 = zzk & 127;
        while ((zzk & 128) == 128) {
            zzk = zzfd.zzk();
            i11 = (i11 << 7) | (zzk & 127);
        }
        return i11;
    }

    private static int zzg(zzfd zzfd) {
        zzfd.zzF(16);
        return zzfd.zze();
    }

    private static Pair<String, byte[]> zzh(zzfd zzfd, int i11) {
        zzfd.zzF(i11 + 12);
        zzfd.zzG(1);
        zzf(zzfd);
        zzfd.zzG(2);
        int zzk = zzfd.zzk();
        if ((zzk & 128) != 0) {
            zzfd.zzG(2);
        }
        if ((zzk & 64) != 0) {
            zzfd.zzG(zzfd.zzo());
        }
        if ((zzk & 32) != 0) {
            zzfd.zzG(2);
        }
        zzfd.zzG(1);
        zzf(zzfd);
        String zzd = zzbi.zzd(zzfd.zzk());
        if (MimeTypes.AUDIO_MPEG.equals(zzd) || MimeTypes.AUDIO_DTS.equals(zzd) || MimeTypes.AUDIO_DTS_HD.equals(zzd)) {
            return Pair.create(zzd, (Object) null);
        }
        zzfd.zzG(12);
        zzfd.zzG(1);
        int zzf = zzf(zzfd);
        byte[] bArr = new byte[zzf];
        zzfd.zzB(bArr, 0, zzf);
        return Pair.create(zzd, bArr);
    }

    @Nullable
    private static Pair<Integer, zzacl> zzi(zzfd zzfd, int i11, int i12) throws zzbj {
        boolean z11;
        Pair<Integer, zzacl> pair;
        boolean z12;
        boolean z13;
        Integer num;
        zzacl zzacl;
        int i13;
        int i14;
        boolean z14;
        byte[] bArr;
        zzfd zzfd2 = zzfd;
        int zzc = zzfd.zzc();
        while (zzc - i11 < i12) {
            zzfd2.zzF(zzc);
            int zze = zzfd.zze();
            boolean z15 = true;
            if (zze > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            zzwt.zzb(z11, "childAtomSize must be positive");
            if (zzfd.zze() == 1936289382) {
                int i15 = zzc + 8;
                int i16 = 0;
                int i17 = -1;
                String str = null;
                Integer num2 = null;
                while (i15 - zzc < zze) {
                    zzfd2.zzF(i15);
                    int zze2 = zzfd.zze();
                    int zze3 = zzfd.zze();
                    if (zze3 == 1718775137) {
                        num2 = Integer.valueOf(zzfd.zze());
                    } else if (zze3 == 1935894637) {
                        zzfd2.zzG(4);
                        str = zzfd2.zzx(4, zzfpt.zzc);
                    } else if (zze3 == 1935894633) {
                        i17 = i15;
                        i16 = zze2;
                    }
                    i15 += zze2;
                }
                if (C.CENC_TYPE_cenc.equals(str) || C.CENC_TYPE_cbc1.equals(str) || C.CENC_TYPE_cens.equals(str) || C.CENC_TYPE_cbcs.equals(str)) {
                    if (num2 != null) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    zzwt.zzb(z12, "frma atom is mandatory");
                    if (i17 != -1) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    zzwt.zzb(z13, "schi atom is mandatory");
                    int i18 = i17 + 8;
                    while (true) {
                        if (i18 - i17 >= i16) {
                            num = num2;
                            zzacl = null;
                            break;
                        }
                        zzfd2.zzF(i18);
                        int zze4 = zzfd.zze();
                        if (zzfd.zze() == 1952804451) {
                            int zze5 = zzfd.zze();
                            zzfd2.zzG(1);
                            if (zzabn.zze(zze5) == 0) {
                                zzfd2.zzG(1);
                                i14 = 0;
                                i13 = 0;
                            } else {
                                int zzk = zzfd.zzk();
                                i14 = zzk & 15;
                                i13 = (zzk & PsExtractor.VIDEO_STREAM_MASK) >> 4;
                            }
                            if (zzfd.zzk() == 1) {
                                z14 = true;
                            } else {
                                z14 = false;
                            }
                            int zzk2 = zzfd.zzk();
                            byte[] bArr2 = new byte[16];
                            zzfd2.zzB(bArr2, 0, 16);
                            if (!z14 || zzk2 != 0) {
                                bArr = null;
                            } else {
                                int zzk3 = zzfd.zzk();
                                byte[] bArr3 = new byte[zzk3];
                                zzfd2.zzB(bArr3, 0, zzk3);
                                bArr = bArr3;
                            }
                            num = num2;
                            zzacl = new zzacl(z14, str, zzk2, bArr2, i13, i14, bArr);
                        } else {
                            Integer num3 = num2;
                            i18 += zze4;
                        }
                    }
                    if (zzacl == null) {
                        z15 = false;
                    }
                    zzwt.zzb(z15, "tenc atom is mandatory");
                    int i19 = zzfn.zza;
                    pair = Pair.create(num, zzacl);
                } else {
                    pair = null;
                }
                if (pair != null) {
                    return pair;
                }
            }
            zzc += zze;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:157:0x0344 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:169:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x0154  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zzj(com.google.android.gms.internal.ads.zzfd r21, int r22, int r23, int r24, int r25, java.lang.String r26, boolean r27, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzs r28, com.google.android.gms.internal.ads.zzabq r29, int r30) throws com.google.android.gms.internal.ads.zzbj {
        /*
            r0 = r21
            r1 = r23
            r2 = r24
            r3 = r25
            r4 = r26
            r5 = r28
            r6 = r29
            int r7 = r1 + 16
            r0.zzF(r7)
            r7 = 6
            if (r27 == 0) goto L_0x001e
            int r9 = r21.zzo()
            r0.zzG(r7)
            goto L_0x0024
        L_0x001e:
            r9 = 8
            r0.zzG(r9)
            r9 = 0
        L_0x0024:
            r10 = 20
            r11 = 2
            r12 = 1
            r13 = 16
            if (r9 == 0) goto L_0x004a
            if (r9 != r12) goto L_0x002f
            goto L_0x004a
        L_0x002f:
            if (r9 != r11) goto L_0x0049
            r0.zzG(r13)
            long r13 = r21.zzr()
            double r13 = java.lang.Double.longBitsToDouble(r13)
            long r13 = java.lang.Math.round(r13)
            int r7 = (int) r13
            int r9 = r21.zzn()
            r0.zzG(r10)
            goto L_0x005b
        L_0x0049:
            return
        L_0x004a:
            int r14 = r21.zzo()
            r0.zzG(r7)
            int r7 = r21.zzl()
            if (r9 != r12) goto L_0x005a
            r0.zzG(r13)
        L_0x005a:
            r9 = r14
        L_0x005b:
            int r13 = r21.zzc()
            r14 = 1701733217(0x656e6361, float:7.0359778E22)
            r15 = r22
            if (r15 != r14) goto L_0x008e
            android.util.Pair r15 = zzi(r0, r1, r2)
            if (r15 == 0) goto L_0x008a
            java.lang.Object r14 = r15.first
            java.lang.Integer r14 = (java.lang.Integer) r14
            int r14 = r14.intValue()
            if (r5 != 0) goto L_0x0078
            r5 = 0
            goto L_0x0082
        L_0x0078:
            java.lang.Object r10 = r15.second
            com.google.android.gms.internal.ads.zzacl r10 = (com.google.android.gms.internal.ads.zzacl) r10
            java.lang.String r10 = r10.zzb
            com.google.android.gms.internal.ads.zzs r5 = r5.zza(r10)
        L_0x0082:
            com.google.android.gms.internal.ads.zzacl[] r10 = r6.zza
            java.lang.Object r15 = r15.second
            com.google.android.gms.internal.ads.zzacl r15 = (com.google.android.gms.internal.ads.zzacl) r15
            r10[r30] = r15
        L_0x008a:
            r0.zzF(r13)
            goto L_0x008f
        L_0x008e:
            r14 = r15
        L_0x008f:
            r10 = 1633889587(0x61632d33, float:2.6191674E20)
            r15 = 1634492771(0x616c6163, float:2.7252807E20)
            java.lang.String r11 = "audio/ac4"
            if (r14 != r10) goto L_0x009e
            java.lang.String r10 = "audio/ac3"
        L_0x009b:
            r14 = -1
            goto L_0x014c
        L_0x009e:
            r10 = 1700998451(0x65632d33, float:6.7050686E22)
            if (r14 != r10) goto L_0x00a6
            java.lang.String r10 = "audio/eac3"
            goto L_0x009b
        L_0x00a6:
            r10 = 1633889588(0x61632d34, float:2.6191676E20)
            if (r14 != r10) goto L_0x00ad
            r10 = r11
            goto L_0x009b
        L_0x00ad:
            r10 = 1685353315(0x64747363, float:1.803728E22)
            if (r14 != r10) goto L_0x00b5
            java.lang.String r10 = "audio/vnd.dts"
            goto L_0x009b
        L_0x00b5:
            r10 = 1685353320(0x64747368, float:1.8037286E22)
            if (r14 == r10) goto L_0x0148
            r10 = 1685353324(0x6474736c, float:1.803729E22)
            if (r14 != r10) goto L_0x00c1
            goto L_0x0148
        L_0x00c1:
            r10 = 1685353317(0x64747365, float:1.8037282E22)
            if (r14 != r10) goto L_0x00c9
            java.lang.String r10 = "audio/vnd.dts.hd;profile=lbr"
            goto L_0x009b
        L_0x00c9:
            r10 = 1685353336(0x64747378, float:1.8037304E22)
            if (r14 != r10) goto L_0x00d1
            java.lang.String r10 = "audio/vnd.dts.uhd;profile=p2"
            goto L_0x009b
        L_0x00d1:
            r10 = 1935764850(0x73616d72, float:1.7860208E31)
            if (r14 != r10) goto L_0x00d9
            java.lang.String r10 = "audio/3gpp"
            goto L_0x009b
        L_0x00d9:
            r10 = 1935767394(0x73617762, float:1.7863284E31)
            if (r14 != r10) goto L_0x00e1
            java.lang.String r10 = "audio/amr-wb"
            goto L_0x009b
        L_0x00e1:
            r10 = 1819304813(0x6c70636d, float:1.1624469E27)
            java.lang.String r18 = "audio/raw"
            if (r14 == r10) goto L_0x0144
            r10 = 1936684916(0x736f7774, float:1.89725E31)
            if (r14 != r10) goto L_0x00ee
            goto L_0x0144
        L_0x00ee:
            r10 = 1953984371(0x74776f73, float:7.841539E31)
            if (r14 != r10) goto L_0x00f9
            r10 = 268435456(0x10000000, float:2.5243549E-29)
            r14 = r10
            r10 = r18
            goto L_0x014c
        L_0x00f9:
            r10 = 778924082(0x2e6d7032, float:5.398721E-11)
            if (r14 == r10) goto L_0x0140
            r10 = 778924083(0x2e6d7033, float:5.3987214E-11)
            if (r14 != r10) goto L_0x0104
            goto L_0x0140
        L_0x0104:
            r10 = 1835557169(0x6d686131, float:4.4948762E27)
            if (r14 != r10) goto L_0x010c
            java.lang.String r10 = "audio/mha1"
            goto L_0x009b
        L_0x010c:
            r10 = 1835560241(0x6d686d31, float:4.495783E27)
            if (r14 != r10) goto L_0x0114
            java.lang.String r10 = "audio/mhm1"
            goto L_0x009b
        L_0x0114:
            if (r14 != r15) goto L_0x0119
            java.lang.String r10 = "audio/alac"
            goto L_0x009b
        L_0x0119:
            r10 = 1634492791(0x616c6177, float:2.7252842E20)
            if (r14 != r10) goto L_0x0122
            java.lang.String r10 = "audio/g711-alaw"
            goto L_0x009b
        L_0x0122:
            r10 = 1970037111(0x756c6177, float:2.9964816E32)
            if (r14 != r10) goto L_0x012b
            java.lang.String r10 = "audio/g711-mlaw"
            goto L_0x009b
        L_0x012b:
            r10 = 1332770163(0x4f707573, float:4.03422899E9)
            if (r14 != r10) goto L_0x0134
            java.lang.String r10 = "audio/opus"
            goto L_0x009b
        L_0x0134:
            r10 = 1716281667(0x664c6143, float:2.4128923E23)
            if (r14 != r10) goto L_0x013d
            java.lang.String r10 = "audio/flac"
            goto L_0x009b
        L_0x013d:
            r10 = 0
            goto L_0x009b
        L_0x0140:
            java.lang.String r10 = "audio/mpeg"
            goto L_0x009b
        L_0x0144:
            r10 = r18
            r14 = 2
            goto L_0x014c
        L_0x0148:
            java.lang.String r10 = "audio/vnd.dts.hd"
            goto L_0x009b
        L_0x014c:
            r19 = 0
            r20 = 0
        L_0x0150:
            int r12 = r13 - r1
            if (r12 >= r2) goto L_0x0340
            r0.zzF(r13)
            int r12 = r21.zze()
            if (r12 <= 0) goto L_0x015f
            r15 = 1
            goto L_0x0160
        L_0x015f:
            r15 = 0
        L_0x0160:
            java.lang.String r8 = "childAtomSize must be positive"
            com.google.android.gms.internal.ads.zzwt.zzb(r15, r8)
            int r15 = r21.zze()
            r1 = 1835557187(0x6d686143, float:4.4948815E27)
            if (r15 != r1) goto L_0x018a
            int r1 = r12 + -13
            byte[] r8 = new byte[r1]
            int r15 = r13 + 13
            r0.zzF(r15)
            r15 = 0
            r0.zzB(r8, r15, r1)
            com.google.android.gms.internal.ads.zzfss r1 = com.google.android.gms.internal.ads.zzfss.zzp(r8)
        L_0x017f:
            r20 = r1
        L_0x0181:
            r8 = 0
            r15 = 20
            r16 = 2
            r17 = 1
            goto L_0x0336
        L_0x018a:
            r1 = 1702061171(0x65736473, float:7.183675E22)
            if (r15 == r1) goto L_0x0305
            if (r27 == 0) goto L_0x01cc
            r1 = 2002876005(0x77617665, float:4.5729223E33)
            if (r15 != r1) goto L_0x01cc
            int r1 = r21.zzc()
        L_0x019a:
            int r15 = r1 - r13
            if (r15 >= r12) goto L_0x01c1
            r0.zzF(r1)
            int r15 = r21.zze()
            if (r15 <= 0) goto L_0x01a9
            r2 = 1
            goto L_0x01aa
        L_0x01a9:
            r2 = 0
        L_0x01aa:
            com.google.android.gms.internal.ads.zzwt.zzb(r2, r8)
            int r2 = r21.zze()
            r18 = r8
            r8 = 1702061171(0x65736473, float:7.183675E22)
            if (r2 == r8) goto L_0x01be
            int r1 = r1 + r15
            r2 = r24
            r8 = r18
            goto L_0x019a
        L_0x01be:
            r2 = r1
            r1 = -1
            goto L_0x01c3
        L_0x01c1:
            r1 = -1
            r2 = -1
        L_0x01c3:
            r8 = 0
            r15 = 20
            r16 = 2
            r17 = 1
            goto L_0x030e
        L_0x01cc:
            r1 = 1684103987(0x64616333, float:1.6630662E22)
            if (r15 != r1) goto L_0x01e4
            int r1 = r13 + 8
            r0.zzF(r1)
            java.lang.String r1 = java.lang.Integer.toString(r25)
            com.google.android.gms.internal.ads.zzab r1 = com.google.android.gms.internal.ads.zzvv.zzb(r0, r1, r4, r5)
            r6.zzb = r1
        L_0x01e0:
            r1 = 1634492771(0x616c6163, float:2.7252807E20)
            goto L_0x0181
        L_0x01e4:
            r1 = 1684366131(0x64656333, float:1.692581E22)
            if (r15 != r1) goto L_0x01f9
            int r1 = r13 + 8
            r0.zzF(r1)
            java.lang.String r1 = java.lang.Integer.toString(r25)
            com.google.android.gms.internal.ads.zzab r1 = com.google.android.gms.internal.ads.zzvv.zzc(r0, r1, r4, r5)
            r6.zzb = r1
            goto L_0x01e0
        L_0x01f9:
            r1 = 1684103988(0x64616334, float:1.6630663E22)
            if (r15 != r1) goto L_0x023d
            int r1 = r13 + 8
            r0.zzF(r1)
            java.lang.String r1 = java.lang.Integer.toString(r25)
            int r2 = com.google.android.gms.internal.ads.zzvy.zza
            r2 = 1
            r0.zzG(r2)
            int r8 = r21.zzk()
            r8 = r8 & 32
            int r8 = r8 >> 5
            if (r2 == r8) goto L_0x021b
            r2 = 44100(0xac44, float:6.1797E-41)
            goto L_0x021e
        L_0x021b:
            r2 = 48000(0xbb80, float:6.7262E-41)
        L_0x021e:
            com.google.android.gms.internal.ads.zzz r8 = new com.google.android.gms.internal.ads.zzz
            r8.<init>()
            r8.zzH(r1)
            r8.zzS(r11)
            r1 = 2
            r8.zzw(r1)
            r8.zzT(r2)
            r8.zzB(r5)
            r8.zzK(r4)
            com.google.android.gms.internal.ads.zzab r1 = r8.zzY()
            r6.zzb = r1
            goto L_0x01e0
        L_0x023d:
            r1 = 1684305011(0x64647473, float:1.6856995E22)
            if (r15 != r1) goto L_0x0260
            com.google.android.gms.internal.ads.zzz r1 = new com.google.android.gms.internal.ads.zzz
            r1.<init>()
            r1.zzG(r3)
            r1.zzS(r10)
            r1.zzw(r9)
            r1.zzT(r7)
            r1.zzB(r5)
            r1.zzK(r4)
            com.google.android.gms.internal.ads.zzab r1 = r1.zzY()
            r6.zzb = r1
            goto L_0x01e0
        L_0x0260:
            r1 = 1682927731(0x644f7073, float:1.5306315E22)
            if (r15 != r1) goto L_0x027e
            int r1 = r12 + -8
            byte[] r2 = zza
            int r8 = r2.length
            int r8 = r8 + r1
            byte[] r8 = java.util.Arrays.copyOf(r2, r8)
            int r15 = r13 + 8
            r0.zzF(r15)
            int r2 = r2.length
            r0.zzB(r8, r2, r1)
            java.util.List r1 = com.google.android.gms.internal.ads.zzxl.zza(r8)
            goto L_0x017f
        L_0x027e:
            r1 = 1684425825(0x64664c61, float:1.6993019E22)
            if (r15 != r1) goto L_0x02b3
            int r1 = r12 + -12
            int r2 = r1 + 4
            byte[] r2 = new byte[r2]
            r8 = 102(0x66, float:1.43E-43)
            r15 = 0
            r2[r15] = r8
            r8 = 76
            r17 = 1
            r2[r17] = r8
            r8 = 97
            r16 = 2
            r2[r16] = r8
            r8 = 3
            r15 = 67
            r2[r8] = r15
            int r8 = r13 + 12
            r0.zzF(r8)
            r8 = 4
            r0.zzB(r2, r8, r1)
            com.google.android.gms.internal.ads.zzfss r1 = com.google.android.gms.internal.ads.zzfss.zzp(r2)
            r20 = r1
        L_0x02ae:
            r8 = 0
            r15 = 20
            goto L_0x0336
        L_0x02b3:
            r1 = 1634492771(0x616c6163, float:2.7252807E20)
            r16 = 2
            r17 = 1
            if (r15 != r1) goto L_0x02ae
            int r2 = r12 + -12
            byte[] r7 = new byte[r2]
            int r8 = r13 + 12
            r0.zzF(r8)
            r8 = 0
            r0.zzB(r7, r8, r2)
            com.google.android.gms.internal.ads.zzfd r2 = new com.google.android.gms.internal.ads.zzfd
            r2.<init>((byte[]) r7)
            r9 = 9
            r2.zzF(r9)
            int r9 = r2.zzk()
            r15 = 20
            r2.zzF(r15)
            int r2 = r2.zzn()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            android.util.Pair r2 = android.util.Pair.create(r2, r9)
            java.lang.Object r9 = r2.first
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            java.lang.Object r2 = r2.second
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            com.google.android.gms.internal.ads.zzfss r7 = com.google.android.gms.internal.ads.zzfss.zzp(r7)
            r20 = r7
            r7 = r9
            r9 = r2
            goto L_0x0336
        L_0x0305:
            r8 = 0
            r15 = 20
            r16 = 2
            r17 = 1
            r2 = r13
            r1 = -1
        L_0x030e:
            if (r2 == r1) goto L_0x0336
            android.util.Pair r2 = zzh(r0, r2)
            java.lang.Object r10 = r2.first
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r2 = r2.second
            byte[] r2 = (byte[]) r2
            if (r2 == 0) goto L_0x0336
            java.lang.String r1 = "audio/mp4a-latm"
            boolean r1 = r1.equals(r10)
            if (r1 == 0) goto L_0x0332
            com.google.android.gms.internal.ads.zzvr r1 = com.google.android.gms.internal.ads.zzvs.zza(r2)
            int r7 = r1.zza
            int r9 = r1.zzb
            java.lang.String r1 = r1.zzc
            r19 = r1
        L_0x0332:
            com.google.android.gms.internal.ads.zzfss r20 = com.google.android.gms.internal.ads.zzfss.zzp(r2)
        L_0x0336:
            int r13 = r13 + r12
            r1 = r23
            r2 = r24
            r15 = 1634492771(0x616c6163, float:2.7252807E20)
            goto L_0x0150
        L_0x0340:
            com.google.android.gms.internal.ads.zzab r0 = r6.zzb
            if (r0 != 0) goto L_0x0370
            if (r10 == 0) goto L_0x0370
            com.google.android.gms.internal.ads.zzz r0 = new com.google.android.gms.internal.ads.zzz
            r0.<init>()
            r0.zzG(r3)
            r0.zzS(r10)
            r1 = r19
            r0.zzx(r1)
            r0.zzw(r9)
            r0.zzT(r7)
            r0.zzN(r14)
            r1 = r20
            r0.zzI(r1)
            r0.zzB(r5)
            r0.zzK(r4)
            com.google.android.gms.internal.ads.zzab r0 = r0.zzY()
            r6.zzb = r0
        L_0x0370:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzabu.zzj(com.google.android.gms.internal.ads.zzfd, int, int, int, int, java.lang.String, boolean, com.google.android.gms.internal.ads.zzs, com.google.android.gms.internal.ads.zzabq, int):void");
    }
}

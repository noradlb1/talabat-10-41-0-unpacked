package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.util.concurrent.atomic.AtomicReference;

public final class zzsp extends zzst {
    public static final /* synthetic */ int zza = 0;
    /* access modifiers changed from: private */
    public static final zzfuf<Integer> zzb = zzfuf.zzb(zzsc.zza);
    /* access modifiers changed from: private */
    public static final zzfuf<Integer> zzc = zzfuf.zzb(zzsd.zza);
    private final AtomicReference<zzsi> zzd;
    private final zzry zze;

    @Deprecated
    public zzsp() {
        zzsi zzsi = zzsi.zzB;
        throw null;
    }

    public static int zza(zzab zzab, @Nullable String str, boolean z11) {
        if (!TextUtils.isEmpty(str) && str.equals(zzab.zzd)) {
            return 4;
        }
        String zzf = zzf(str);
        String zzf2 = zzf(zzab.zzd);
        if (zzf2 == null || zzf == null) {
            if (!z11 || zzf2 != null) {
                return 0;
            }
            return 1;
        } else if (zzf2.startsWith(zzf) || zzf.startsWith(zzf2)) {
            return 3;
        } else {
            if (zzfn.zzad(zzf2, SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE)[0].equals(zzfn.zzad(zzf, SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE)[0])) {
                return 2;
            }
            return 0;
        }
    }

    @Nullable
    public static String zzf(@Nullable String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, C.LANGUAGE_UNDETERMINED)) {
            return null;
        }
        return str;
    }

    public static boolean zzh(int i11, boolean z11) {
        int i12 = i11 & 7;
        if (i12 == 4) {
            return true;
        }
        if (z11) {
            return i12 == 3;
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v0, resolved type: com.google.android.gms.internal.ads.zzsb[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v8, resolved type: com.google.android.gms.internal.ads.zzrz} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v42, resolved type: com.google.android.gms.internal.ads.zzsr} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r21v9, resolved type: com.google.android.gms.internal.ads.zzsr} */
    /* JADX WARNING: type inference failed for: r8v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x02a6  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.util.Pair<com.google.android.gms.internal.ads.zzin[], com.google.android.gms.internal.ads.zzsb[]> zzb(com.google.android.gms.internal.ads.zzss r28, int[][][] r29, int[] r30, com.google.android.gms.internal.ads.zzpz r31, com.google.android.gms.internal.ads.zzcd r32) throws com.google.android.gms.internal.ads.zzgg {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            java.util.concurrent.atomic.AtomicReference<com.google.android.gms.internal.ads.zzsi> r2 = r0.zzd
            java.lang.Object r2 = r2.get()
            com.google.android.gms.internal.ads.zzsi r2 = (com.google.android.gms.internal.ads.zzsi) r2
            r3 = 2
            com.google.android.gms.internal.ads.zzsq[] r4 = new com.google.android.gms.internal.ads.zzsq[r3]
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x0012:
            r11 = 1
            if (r6 >= r3) goto L_0x01c9
            int r12 = r1.zza(r6)
            if (r12 != r3) goto L_0x01b9
            if (r7 != 0) goto L_0x01a4
            com.google.android.gms.internal.ads.zzch r7 = r1.zzc(r6)
            r12 = r29[r6]
            r13 = r30[r6]
            boolean r13 = r2.zzy
            r13 = 0
        L_0x0028:
            int r14 = r7.zzc
            if (r13 >= r14) goto L_0x0037
            com.google.android.gms.internal.ads.zzcf r14 = r7.zzb(r13)
            r15 = r12[r13]
            int r14 = r14.zzb
            int r13 = r13 + 1
            goto L_0x0028
        L_0x0037:
            r13 = 0
            r14 = 0
            r15 = -1
            r16 = 0
        L_0x003c:
            int r10 = r7.zzc
            if (r13 >= r10) goto L_0x017f
            com.google.android.gms.internal.ads.zzcf r10 = r7.zzb(r13)
            int r3 = r2.zzl
            int r5 = r2.zzm
            boolean r9 = r2.zzn
            r17 = r7
            java.util.ArrayList r7 = new java.util.ArrayList
            int r0 = r10.zzb
            r7.<init>(r11)
            r0 = 0
        L_0x0054:
            if (r0 > 0) goto L_0x0061
            java.lang.Integer r11 = java.lang.Integer.valueOf(r0)
            r7.add(r11)
            int r0 = r0 + 1
            r11 = 1
            goto L_0x0054
        L_0x0061:
            r0 = 2147483647(0x7fffffff, float:NaN)
            if (r3 == r0) goto L_0x0128
            if (r5 != r0) goto L_0x006a
            goto L_0x0128
        L_0x006a:
            r11 = 0
        L_0x006b:
            if (r11 > 0) goto L_0x00f8
            r19 = r8
            com.google.android.gms.internal.ads.zzab r8 = r10.zzb(r11)
            int r1 = r8.zzr
            if (r1 <= 0) goto L_0x00dc
            r20 = r4
            int r4 = r8.zzs
            if (r4 <= 0) goto L_0x00d9
            if (r9 == 0) goto L_0x0099
            if (r1 > r4) goto L_0x0085
            r21 = r9
            r9 = 0
            goto L_0x0088
        L_0x0085:
            r21 = r9
            r9 = 1
        L_0x0088:
            if (r3 > r5) goto L_0x008e
            r22 = r3
            r3 = 0
            goto L_0x0091
        L_0x008e:
            r22 = r3
            r3 = 1
        L_0x0091:
            if (r9 == r3) goto L_0x009d
            r9 = r5
            r23 = r9
            r3 = r22
            goto L_0x00a2
        L_0x0099:
            r22 = r3
            r21 = r9
        L_0x009d:
            r3 = r5
            r23 = r3
            r9 = r22
        L_0x00a2:
            int r5 = r1 * r3
            r24 = r6
            int r6 = r4 * r9
            if (r5 < r6) goto L_0x00b4
            android.graphics.Point r3 = new android.graphics.Point
            int r1 = com.google.android.gms.internal.ads.zzfn.zze(r6, r1)
            r3.<init>(r9, r1)
            goto L_0x00be
        L_0x00b4:
            android.graphics.Point r1 = new android.graphics.Point
            int r4 = com.google.android.gms.internal.ads.zzfn.zze(r5, r4)
            r1.<init>(r4, r3)
            r3 = r1
        L_0x00be:
            int r1 = r8.zzr
            int r4 = r8.zzs
            int r5 = r1 * r4
            int r6 = r3.x
            float r6 = (float) r6
            r8 = 1065017672(0x3f7ae148, float:0.98)
            float r6 = r6 * r8
            int r6 = (int) r6
            if (r1 < r6) goto L_0x00e6
            int r1 = r3.y
            float r1 = (float) r1
            float r1 = r1 * r8
            int r1 = (int) r1
            if (r4 < r1) goto L_0x00e6
            if (r5 >= r0) goto L_0x00e6
            r0 = r5
            goto L_0x00e6
        L_0x00d9:
            r22 = r3
            goto L_0x00e0
        L_0x00dc:
            r22 = r3
            r20 = r4
        L_0x00e0:
            r23 = r5
            r24 = r6
            r21 = r9
        L_0x00e6:
            int r11 = r11 + 1
            r1 = r28
            r8 = r19
            r4 = r20
            r9 = r21
            r3 = r22
            r5 = r23
            r6 = r24
            goto L_0x006b
        L_0x00f8:
            r20 = r4
            r24 = r6
            r19 = r8
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == r1) goto L_0x012e
            int r1 = r7.size()
            r3 = -1
            int r1 = r1 + r3
        L_0x0109:
            if (r1 < 0) goto L_0x012e
            java.lang.Object r4 = r7.get(r1)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            com.google.android.gms.internal.ads.zzab r4 = r10.zzb(r4)
            int r4 = r4.zza()
            if (r4 == r3) goto L_0x0121
            if (r4 <= r0) goto L_0x0124
        L_0x0121:
            r7.remove(r1)
        L_0x0124:
            int r1 = r1 + -1
            r3 = -1
            goto L_0x0109
        L_0x0128:
            r20 = r4
            r24 = r6
            r19 = r8
        L_0x012e:
            r0 = r12[r13]
            r1 = r16
            r3 = 0
        L_0x0133:
            if (r3 > 0) goto L_0x016b
            com.google.android.gms.internal.ads.zzab r4 = r10.zzb(r3)
            int r5 = r4.zzf
            r5 = r0[r3]
            boolean r6 = r2.zzM
            boolean r5 = zzh(r5, r6)
            if (r5 == 0) goto L_0x0168
            com.google.android.gms.internal.ads.zzso r5 = new com.google.android.gms.internal.ads.zzso
            r6 = r0[r3]
            java.lang.Integer r8 = java.lang.Integer.valueOf(r3)
            boolean r8 = r7.contains(r8)
            r5.<init>(r4, r2, r6, r8)
            boolean r4 = r5.zza
            if (r4 != 0) goto L_0x015d
            boolean r4 = r2.zzF
            if (r4 != 0) goto L_0x015d
            goto L_0x0168
        L_0x015d:
            if (r1 == 0) goto L_0x0165
            int r4 = r5.compareTo(r1)
            if (r4 <= 0) goto L_0x0168
        L_0x0165:
            r15 = r3
            r1 = r5
            r14 = r10
        L_0x0168:
            int r3 = r3 + 1
            goto L_0x0133
        L_0x016b:
            int r13 = r13 + 1
            r0 = r27
            r16 = r1
            r7 = r17
            r8 = r19
            r4 = r20
            r6 = r24
            r3 = 2
            r11 = 1
            r1 = r28
            goto L_0x003c
        L_0x017f:
            r20 = r4
            r24 = r6
            r19 = r8
            if (r14 != 0) goto L_0x0189
            r10 = 0
            goto L_0x0194
        L_0x0189:
            com.google.android.gms.internal.ads.zzsq r10 = new com.google.android.gms.internal.ads.zzsq
            r0 = 1
            int[] r1 = new int[r0]
            r0 = 0
            r1[r0] = r15
            r10.<init>(r14, r1, r0)
        L_0x0194:
            r20[r24] = r10
            if (r10 == 0) goto L_0x019e
            r0 = r28
            r5 = r24
            r7 = 1
            goto L_0x01ab
        L_0x019e:
            r0 = r28
            r5 = r24
            r7 = 0
            goto L_0x01ab
        L_0x01a4:
            r20 = r4
            r19 = r8
            r0 = r28
            r5 = r6
        L_0x01ab:
            com.google.android.gms.internal.ads.zzch r1 = r0.zzc(r5)
            int r1 = r1.zzc
            if (r1 <= 0) goto L_0x01b5
            r11 = 1
            goto L_0x01b6
        L_0x01b5:
            r11 = 0
        L_0x01b6:
            r8 = r19 | r11
            goto L_0x01bf
        L_0x01b9:
            r0 = r1
            r20 = r4
            r5 = r6
            r19 = r8
        L_0x01bf:
            int r6 = r5 + 1
            r1 = r0
            r4 = r20
            r3 = 2
            r0 = r27
            goto L_0x0012
        L_0x01c9:
            r0 = r1
            r20 = r4
            r19 = r8
            r6 = r3
            r1 = 0
            r3 = -1
            r4 = 0
            r5 = 0
        L_0x01d3:
            if (r4 >= r6) goto L_0x02e9
            int r6 = r0.zza(r4)
            r7 = 1
            if (r6 != r7) goto L_0x02e4
            boolean r6 = r2.zzO
            if (r6 != 0) goto L_0x01e5
            if (r19 != 0) goto L_0x01e3
            goto L_0x01e5
        L_0x01e3:
            r6 = 0
            goto L_0x01e6
        L_0x01e5:
            r6 = 1
        L_0x01e6:
            com.google.android.gms.internal.ads.zzch r7 = r0.zzc(r4)
            r8 = r29[r4]
            r9 = r30[r4]
            r9 = 0
            r10 = 0
            r11 = -1
            r12 = -1
        L_0x01f2:
            int r13 = r7.zzc
            if (r10 >= r13) goto L_0x0239
            com.google.android.gms.internal.ads.zzcf r13 = r7.zzb(r10)
            r14 = r8[r10]
            r16 = r11
            r15 = 0
        L_0x01ff:
            int r11 = r13.zzb
            if (r15 > 0) goto L_0x0232
            r11 = r14[r15]
            r17 = r12
            boolean r12 = r2.zzM
            boolean r11 = zzh(r11, r12)
            if (r11 == 0) goto L_0x0229
            com.google.android.gms.internal.ads.zzab r11 = r13.zzb(r15)
            com.google.android.gms.internal.ads.zzse r12 = new com.google.android.gms.internal.ads.zzse
            r18 = r13
            r13 = r14[r15]
            r12.<init>(r11, r2, r13)
            if (r9 == 0) goto L_0x0224
            int r11 = r12.compareTo(r9)
            if (r11 <= 0) goto L_0x022b
        L_0x0224:
            r16 = r10
            r9 = r12
            r12 = r15
            goto L_0x022d
        L_0x0229:
            r18 = r13
        L_0x022b:
            r12 = r17
        L_0x022d:
            int r15 = r15 + 1
            r13 = r18
            goto L_0x01ff
        L_0x0232:
            r17 = r12
            int r10 = r10 + 1
            r11 = r16
            goto L_0x01f2
        L_0x0239:
            r10 = -1
            if (r11 != r10) goto L_0x023f
            r6 = 0
            goto L_0x02b6
        L_0x023f:
            com.google.android.gms.internal.ads.zzcf r7 = r7.zzb(r11)
            if (r6 == 0) goto L_0x02a1
            r6 = r8[r11]
            com.google.android.gms.internal.ads.zzab r8 = r7.zzb(r12)
            r10 = 1
            int[] r11 = new int[r10]
            r10 = 0
            r13 = 0
        L_0x0250:
            if (r10 > 0) goto L_0x0292
            if (r10 == r12) goto L_0x0286
            com.google.android.gms.internal.ads.zzab r14 = r7.zzb(r10)
            r15 = r6[r10]
            r16 = r6
            r6 = 0
            boolean r15 = zzh(r15, r6)
            if (r15 == 0) goto L_0x028d
            int r6 = r14.zzi
            r15 = -1
            if (r6 == r15) goto L_0x028d
            int r6 = r14.zzz
            if (r6 == r15) goto L_0x028d
            int r15 = r8.zzz
            if (r6 != r15) goto L_0x028d
            java.lang.String r6 = r14.zzm
            if (r6 == 0) goto L_0x028d
            java.lang.String r15 = r8.zzm
            boolean r6 = android.text.TextUtils.equals(r6, r15)
            if (r6 == 0) goto L_0x028d
            int r6 = r14.zzA
            r14 = -1
            if (r6 == r14) goto L_0x028d
            int r14 = r8.zzA
            if (r6 != r14) goto L_0x028d
            goto L_0x0288
        L_0x0286:
            r16 = r6
        L_0x0288:
            int r6 = r13 + 1
            r11[r13] = r10
            r13 = r6
        L_0x028d:
            int r10 = r10 + 1
            r6 = r16
            goto L_0x0250
        L_0x0292:
            int[] r6 = java.util.Arrays.copyOf(r11, r13)
            int r8 = r6.length
            r10 = 1
            if (r8 <= r10) goto L_0x02a2
            com.google.android.gms.internal.ads.zzsq r8 = new com.google.android.gms.internal.ads.zzsq
            r11 = 0
            r8.<init>(r7, r6, r11)
            goto L_0x02a4
        L_0x02a1:
            r10 = 1
        L_0x02a2:
            r11 = 0
            r8 = 0
        L_0x02a4:
            if (r8 != 0) goto L_0x02af
            com.google.android.gms.internal.ads.zzsq r8 = new com.google.android.gms.internal.ads.zzsq
            int[] r6 = new int[r10]
            r6[r11] = r12
            r8.<init>(r7, r6, r11)
        L_0x02af:
            r9.getClass()
            android.util.Pair r6 = android.util.Pair.create(r8, r9)
        L_0x02b6:
            if (r6 == 0) goto L_0x02e4
            if (r1 == 0) goto L_0x02c4
            java.lang.Object r7 = r6.second
            com.google.android.gms.internal.ads.zzse r7 = (com.google.android.gms.internal.ads.zzse) r7
            int r7 = r7.compareTo(r1)
            if (r7 <= 0) goto L_0x02e4
        L_0x02c4:
            r1 = -1
            if (r3 == r1) goto L_0x02ca
            r1 = 0
            r20[r3] = r1
        L_0x02ca:
            java.lang.Object r1 = r6.first
            com.google.android.gms.internal.ads.zzsq r1 = (com.google.android.gms.internal.ads.zzsq) r1
            r20[r4] = r1
            com.google.android.gms.internal.ads.zzcf r3 = r1.zza
            int[] r1 = r1.zzb
            r5 = 0
            r1 = r1[r5]
            com.google.android.gms.internal.ads.zzab r1 = r3.zzb(r1)
            java.lang.String r1 = r1.zzd
            java.lang.Object r3 = r6.second
            com.google.android.gms.internal.ads.zzse r3 = (com.google.android.gms.internal.ads.zzse) r3
            r5 = r1
            r1 = r3
            r3 = r4
        L_0x02e4:
            int r4 = r4 + 1
            r6 = 2
            goto L_0x01d3
        L_0x02e9:
            r1 = 0
            r3 = -1
            r4 = 0
        L_0x02ec:
            if (r4 >= r6) goto L_0x03e9
            int r7 = r0.zza(r4)
            r8 = 1
            if (r7 == r8) goto L_0x03e3
            if (r7 == r6) goto L_0x03e3
            r6 = 3
            if (r7 == r6) goto L_0x035b
            com.google.android.gms.internal.ads.zzch r6 = r0.zzc(r4)
            r7 = r29[r4]
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
        L_0x0304:
            int r12 = r6.zzc
            if (r10 >= r12) goto L_0x0348
            com.google.android.gms.internal.ads.zzcf r12 = r6.zzb(r10)
            r13 = r7[r10]
            r14 = 0
        L_0x030f:
            int r15 = r12.zzb
            if (r14 > 0) goto L_0x0341
            r15 = r13[r14]
            r30 = r6
            boolean r6 = r2.zzM
            boolean r6 = zzh(r15, r6)
            if (r6 == 0) goto L_0x0338
            com.google.android.gms.internal.ads.zzab r6 = r12.zzb(r14)
            com.google.android.gms.internal.ads.zzsf r15 = new com.google.android.gms.internal.ads.zzsf
            r16 = r7
            r7 = r13[r14]
            r15.<init>(r6, r7)
            if (r9 == 0) goto L_0x0334
            int r6 = r15.compareTo(r9)
            if (r6 <= 0) goto L_0x033a
        L_0x0334:
            r8 = r12
            r11 = r14
            r9 = r15
            goto L_0x033a
        L_0x0338:
            r16 = r7
        L_0x033a:
            int r14 = r14 + 1
            r6 = r30
            r7 = r16
            goto L_0x030f
        L_0x0341:
            r30 = r6
            r16 = r7
            int r10 = r10 + 1
            goto L_0x0304
        L_0x0348:
            if (r8 != 0) goto L_0x034c
            r6 = 0
            goto L_0x0357
        L_0x034c:
            com.google.android.gms.internal.ads.zzsq r6 = new com.google.android.gms.internal.ads.zzsq
            r7 = 1
            int[] r9 = new int[r7]
            r7 = 0
            r9[r7] = r11
            r6.<init>(r8, r9, r7)
        L_0x0357:
            r20[r4] = r6
            goto L_0x03e3
        L_0x035b:
            com.google.android.gms.internal.ads.zzch r6 = r0.zzc(r4)
            r7 = r29[r4]
            r8 = 0
            r9 = 0
            r10 = -1
            r11 = 0
        L_0x0365:
            int r12 = r6.zzc
            if (r11 >= r12) goto L_0x03ad
            com.google.android.gms.internal.ads.zzcf r12 = r6.zzb(r11)
            r13 = r7[r11]
            r14 = 0
        L_0x0370:
            int r15 = r12.zzb
            if (r14 > 0) goto L_0x03a6
            r15 = r13[r14]
            r30 = r6
            boolean r6 = r2.zzM
            boolean r6 = zzh(r15, r6)
            if (r6 == 0) goto L_0x039d
            com.google.android.gms.internal.ads.zzab r6 = r12.zzb(r14)
            com.google.android.gms.internal.ads.zzsn r15 = new com.google.android.gms.internal.ads.zzsn
            r16 = r7
            r7 = r13[r14]
            r15.<init>(r6, r2, r7, r5)
            boolean r6 = r15.zza
            if (r6 == 0) goto L_0x039f
            if (r9 == 0) goto L_0x0399
            int r6 = r15.compareTo(r9)
            if (r6 <= 0) goto L_0x039f
        L_0x0399:
            r8 = r12
            r10 = r14
            r9 = r15
            goto L_0x039f
        L_0x039d:
            r16 = r7
        L_0x039f:
            int r14 = r14 + 1
            r6 = r30
            r7 = r16
            goto L_0x0370
        L_0x03a6:
            r30 = r6
            r16 = r7
            int r11 = r11 + 1
            goto L_0x0365
        L_0x03ad:
            if (r8 != 0) goto L_0x03b1
            r6 = 0
            goto L_0x03c3
        L_0x03b1:
            com.google.android.gms.internal.ads.zzsq r6 = new com.google.android.gms.internal.ads.zzsq
            r7 = 1
            int[] r11 = new int[r7]
            r7 = 0
            r11[r7] = r10
            r6.<init>(r8, r11, r7)
            r9.getClass()
            android.util.Pair r6 = android.util.Pair.create(r6, r9)
        L_0x03c3:
            if (r6 == 0) goto L_0x03e3
            if (r1 == 0) goto L_0x03d1
            java.lang.Object r7 = r6.second
            com.google.android.gms.internal.ads.zzsn r7 = (com.google.android.gms.internal.ads.zzsn) r7
            int r7 = r7.compareTo(r1)
            if (r7 <= 0) goto L_0x03e3
        L_0x03d1:
            r7 = -1
            if (r3 == r7) goto L_0x03d7
            r1 = 0
            r20[r3] = r1
        L_0x03d7:
            java.lang.Object r1 = r6.first
            com.google.android.gms.internal.ads.zzsq r1 = (com.google.android.gms.internal.ads.zzsq) r1
            r20[r4] = r1
            java.lang.Object r1 = r6.second
            com.google.android.gms.internal.ads.zzsn r1 = (com.google.android.gms.internal.ads.zzsn) r1
            r3 = r4
            goto L_0x03e4
        L_0x03e3:
            r7 = -1
        L_0x03e4:
            int r4 = r4 + 1
            r6 = 2
            goto L_0x02ec
        L_0x03e9:
            r3 = r6
            r1 = 0
        L_0x03eb:
            if (r1 >= r3) goto L_0x0467
            r3 = r20[r1]
            int r4 = r0.zza(r1)
            boolean r5 = r2.zzf(r1)
            if (r5 != 0) goto L_0x045f
            com.google.android.gms.internal.ads.zzftc<java.lang.Integer> r5 = r2.zzA
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r4 = r5.contains(r4)
            if (r4 == 0) goto L_0x0408
        L_0x0405:
            r3 = 0
            r6 = 0
            goto L_0x0461
        L_0x0408:
            com.google.android.gms.internal.ads.zzch r4 = r0.zzc(r1)
            boolean r5 = r2.zzg(r1, r4)
            if (r5 == 0) goto L_0x0425
            com.google.android.gms.internal.ads.zzsm r3 = r2.zze(r1, r4)
            if (r3 != 0) goto L_0x0419
            goto L_0x0405
        L_0x0419:
            com.google.android.gms.internal.ads.zzsq r3 = new com.google.android.gms.internal.ads.zzsq
            r5 = 0
            com.google.android.gms.internal.ads.zzcf r4 = r4.zzb(r5)
            r6 = 0
            r3.<init>(r4, r6, r5)
            goto L_0x0461
        L_0x0425:
            r6 = 0
            r5 = 0
        L_0x0427:
            int r7 = r4.zzc
            if (r5 >= r7) goto L_0x0461
            com.google.android.gms.internal.ads.zzcf r7 = r4.zzb(r5)
            com.google.android.gms.internal.ads.zzfsw<com.google.android.gms.internal.ads.zzcf, com.google.android.gms.internal.ads.zzcm> r8 = r2.zzz
            java.lang.Object r8 = r8.get(r7)
            com.google.android.gms.internal.ads.zzcm r8 = (com.google.android.gms.internal.ads.zzcm) r8
            if (r8 == 0) goto L_0x045c
            com.google.android.gms.internal.ads.zzsq r3 = new com.google.android.gms.internal.ads.zzsq
            com.google.android.gms.internal.ads.zzftc<java.lang.Integer> r4 = r8.zzc
            java.lang.Object[] r4 = r4.toArray()
            int r5 = r4.length
            int[] r8 = new int[r5]
            r9 = 0
        L_0x0445:
            if (r9 >= r5) goto L_0x0457
            r10 = r4[r9]
            r10.getClass()
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            r8[r9] = r10
            int r9 = r9 + 1
            goto L_0x0445
        L_0x0457:
            r9 = 0
            r3.<init>(r7, r8, r9)
            goto L_0x0461
        L_0x045c:
            int r5 = r5 + 1
            goto L_0x0427
        L_0x045f:
            r6 = 0
            r3 = r6
        L_0x0461:
            r20[r1] = r3
            int r1 = r1 + 1
            r3 = 2
            goto L_0x03eb
        L_0x0467:
            r1 = r27
            r6 = 0
            com.google.android.gms.internal.ads.zzry r3 = r1.zze
            com.google.android.gms.internal.ads.zzte r4 = r27.zzk()
            com.google.android.gms.internal.ads.zzfss r5 = com.google.android.gms.internal.ads.zzrz.zza(r20)
            r7 = 2
            com.google.android.gms.internal.ads.zzsb[] r13 = new com.google.android.gms.internal.ads.zzsb[r7]
            r14 = 0
        L_0x0478:
            if (r14 >= r7) goto L_0x04b9
            r7 = r20[r14]
            if (r7 == 0) goto L_0x04b2
            int[] r9 = r7.zzb
            int r8 = r9.length
            if (r8 != 0) goto L_0x0484
            goto L_0x04b2
        L_0x0484:
            r15 = 1
            if (r8 != r15) goto L_0x049d
            com.google.android.gms.internal.ads.zzsr r8 = new com.google.android.gms.internal.ads.zzsr
            com.google.android.gms.internal.ads.zzcf r7 = r7.zza
            r16 = 0
            r23 = r9[r16]
            r24 = 0
            r25 = 0
            r26 = 0
            r21 = r8
            r22 = r7
            r21.<init>(r22, r23, r24, r25, r26)
            goto L_0x04af
        L_0x049d:
            r16 = 0
            com.google.android.gms.internal.ads.zzcf r8 = r7.zza
            r10 = 0
            java.lang.Object r7 = r5.get(r14)
            r12 = r7
            com.google.android.gms.internal.ads.zzfss r12 = (com.google.android.gms.internal.ads.zzfss) r12
            r7 = r3
            r11 = r4
            com.google.android.gms.internal.ads.zzrz r8 = r7.zza(r8, r9, r10, r11, r12)
        L_0x04af:
            r13[r14] = r8
            goto L_0x04b5
        L_0x04b2:
            r15 = 1
            r16 = 0
        L_0x04b5:
            int r14 = r14 + 1
            r7 = 2
            goto L_0x0478
        L_0x04b9:
            r16 = 0
            com.google.android.gms.internal.ads.zzin[] r3 = new com.google.android.gms.internal.ads.zzin[r7]
            r5 = r16
        L_0x04bf:
            if (r5 >= r7) goto L_0x04ec
            int r4 = r0.zza(r5)
            boolean r8 = r2.zzf(r5)
            if (r8 != 0) goto L_0x04e6
            com.google.android.gms.internal.ads.zzftc<java.lang.Integer> r8 = r2.zzA
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            boolean r4 = r8.contains(r4)
            if (r4 == 0) goto L_0x04d8
            goto L_0x04e6
        L_0x04d8:
            int r4 = r0.zza(r5)
            r8 = -2
            if (r4 == r8) goto L_0x04e3
            r4 = r13[r5]
            if (r4 == 0) goto L_0x04e6
        L_0x04e3:
            com.google.android.gms.internal.ads.zzin r4 = com.google.android.gms.internal.ads.zzin.zza
            goto L_0x04e7
        L_0x04e6:
            r4 = r6
        L_0x04e7:
            r3[r5] = r4
            int r5 = r5 + 1
            goto L_0x04bf
        L_0x04ec:
            boolean r0 = r2.zzN
            android.util.Pair r0 = android.util.Pair.create(r3, r13)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzsp.zzb(com.google.android.gms.internal.ads.zzss, int[][][], int[], com.google.android.gms.internal.ads.zzpz, com.google.android.gms.internal.ads.zzcd):android.util.Pair");
    }

    public final zzsi zzc() {
        return this.zzd.get();
    }

    public final void zzg(zzsk zzsk) {
        zzsi zzsi = new zzsi(zzsk);
        if (!this.zzd.getAndSet(zzsi).equals(zzsi)) {
            zzm();
        }
    }

    public zzsp(Context context) {
        zzry zzry = new zzry();
        zzsi zzc2 = zzsi.zzc(context);
        this.zze = zzry;
        this.zzd = new AtomicReference<>(zzc2);
    }
}

package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Locale;

public final class zzzt {
    public static final zzzr zza = zzzq.zza;

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00bd A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00be  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.google.android.gms.internal.ads.zzdd zza(byte[] r11, int r12, com.google.android.gms.internal.ads.zzzr r13, com.google.android.gms.internal.ads.zzde r14) {
        /*
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            com.google.android.gms.internal.ads.zzfd r0 = new com.google.android.gms.internal.ads.zzfd
            r0.<init>(r11, r12)
            int r11 = r0.zza()
            r12 = 2
            r1 = 4
            r2 = 0
            r3 = 1
            java.lang.String r4 = "Id3Decoder"
            r5 = 0
            r6 = 10
            if (r11 >= r6) goto L_0x0021
            java.lang.String r11 = "Data too short to be an ID3 tag"
            android.util.Log.w(r4, r11)
        L_0x001e:
            r9 = r5
            goto L_0x00bb
        L_0x0021:
            int r11 = r0.zzm()
            r7 = 4801587(0x494433, float:6.728456E-39)
            if (r11 == r7) goto L_0x0052
            java.lang.Object[] r7 = new java.lang.Object[r3]
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r7[r2] = r11
            java.lang.String r11 = "%06X"
            java.lang.String r11 = java.lang.String.format(r11, r7)
            java.lang.String r11 = java.lang.String.valueOf(r11)
            int r7 = r11.length()
            java.lang.String r8 = "Unexpected first three bytes of ID3 tag header: 0x"
            if (r7 == 0) goto L_0x0049
            java.lang.String r11 = r8.concat(r11)
            goto L_0x004e
        L_0x0049:
            java.lang.String r11 = new java.lang.String
            r11.<init>(r8)
        L_0x004e:
            android.util.Log.w(r4, r11)
            goto L_0x001e
        L_0x0052:
            int r11 = r0.zzk()
            r0.zzG(r3)
            int r7 = r0.zzk()
            int r8 = r0.zzj()
            if (r11 != r12) goto L_0x006d
            r9 = r7 & 64
            if (r9 == 0) goto L_0x0094
            java.lang.String r11 = "Skipped ID3 tag with majorVersion=2 and undefined compression scheme"
            android.util.Log.w(r4, r11)
            goto L_0x001e
        L_0x006d:
            r9 = 3
            if (r11 != r9) goto L_0x007e
            r9 = r7 & 64
            if (r9 == 0) goto L_0x0094
            int r9 = r0.zze()
            r0.zzG(r9)
            int r9 = r9 + r1
            int r8 = r8 - r9
            goto L_0x0094
        L_0x007e:
            if (r11 != r1) goto L_0x00a3
            r9 = r7 & 64
            if (r9 == 0) goto L_0x008e
            int r9 = r0.zzj()
            int r10 = r9 + -4
            r0.zzG(r10)
            int r8 = r8 - r9
        L_0x008e:
            r9 = r7 & 16
            if (r9 == 0) goto L_0x0094
            int r8 = r8 + -10
        L_0x0094:
            if (r11 >= r1) goto L_0x009c
            r7 = r7 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x009c
            r7 = r3
            goto L_0x009d
        L_0x009c:
            r7 = r2
        L_0x009d:
            com.google.android.gms.internal.ads.zzzs r9 = new com.google.android.gms.internal.ads.zzzs
            r9.<init>(r11, r7, r8)
            goto L_0x00bb
        L_0x00a3:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r8 = 57
            r7.<init>(r8)
            java.lang.String r8 = "Skipped ID3 tag with unsupported majorVersion="
            r7.append(r8)
            r7.append(r11)
            java.lang.String r11 = r7.toString()
            android.util.Log.w(r4, r11)
            goto L_0x001e
        L_0x00bb:
            if (r9 != 0) goto L_0x00be
            return r5
        L_0x00be:
            int r11 = r0.zzc()
            int r7 = r9.zza
            if (r7 != r12) goto L_0x00c9
            r6 = 6
        L_0x00c9:
            int r12 = r9.zzc
            boolean r7 = r9.zzb
            if (r7 == 0) goto L_0x00db
            int r12 = r9.zzc
            int r12 = zze(r0, r12)
        L_0x00db:
            int r11 = r11 + r12
            r0.zzE(r11)
            int r11 = r9.zza
            boolean r11 = zzj(r0, r11, r6, r2)
            if (r11 != 0) goto L_0x0112
            int r11 = r9.zza
            if (r11 != r1) goto L_0x00f7
            boolean r11 = zzj(r0, r1, r6, r3)
            if (r11 == 0) goto L_0x00f7
            r2 = r3
            goto L_0x0112
        L_0x00f7:
            int r11 = r9.zza
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r13 = 56
            r12.<init>(r13)
            java.lang.String r13 = "Failed to validate ID3 tag with majorVersion="
            r12.append(r13)
            r12.append(r11)
            java.lang.String r11 = r12.toString()
            android.util.Log.w(r4, r11)
            return r5
        L_0x0112:
            int r11 = r0.zza()
            if (r11 < r6) goto L_0x0126
            int r11 = r9.zza
            com.google.android.gms.internal.ads.zzzu r11 = zzf(r11, r0, r2, r6, r13)
            if (r11 == 0) goto L_0x0112
            r14.add(r11)
            goto L_0x0112
        L_0x0126:
            com.google.android.gms.internal.ads.zzdd r11 = new com.google.android.gms.internal.ads.zzdd
            r11.<init>((java.util.List<? extends com.google.android.gms.internal.ads.zzdc>) r14)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzt.zza(byte[], int, com.google.android.gms.internal.ads.zzzr, com.google.android.gms.internal.ads.zzde):com.google.android.gms.internal.ads.zzdd");
    }

    private static int zzb(int i11) {
        return (i11 == 0 || i11 == 3) ? 1 : 2;
    }

    private static int zzc(byte[] bArr, int i11, int i12) {
        int zzd = zzd(bArr, i11);
        if (i12 == 0 || i12 == 3) {
            return zzd;
        }
        while (true) {
            int length = bArr.length;
            if (zzd >= length - 1) {
                return length;
            }
            if ((zzd - i11) % 2 == 0 && bArr[zzd + 1] == 0) {
                return zzd;
            }
            zzd = zzd(bArr, zzd + 1);
        }
    }

    private static int zzd(byte[] bArr, int i11) {
        while (true) {
            int length = bArr.length;
            if (i11 >= length) {
                return length;
            }
            if (bArr[i11] == 0) {
                return i11;
            }
            i11++;
        }
    }

    private static int zze(zzfd zzfd, int i11) {
        byte[] zzH = zzfd.zzH();
        int zzc = zzfd.zzc();
        int i12 = zzc;
        while (true) {
            int i13 = i12 + 1;
            if (i13 >= zzc + i11) {
                return i11;
            }
            if ((zzH[i12] & 255) == 255 && zzH[i13] == 0) {
                System.arraycopy(zzH, i12 + 2, zzH, i13, (i11 - (i12 - zzc)) - 2);
                i11--;
            }
            i12 = i13;
        }
    }

    /* JADX WARNING: type inference failed for: r3v17, types: [com.google.android.gms.internal.ads.zzzn] */
    /* JADX WARNING: type inference failed for: r3v20, types: [com.google.android.gms.internal.ads.zzzf] */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0273, code lost:
        if (r9 == 67) goto L_0x0275;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0305, code lost:
        r2 = "Id3Decoder";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x0554, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x0555, code lost:
        r14 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x0558, code lost:
        r2 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x0563, code lost:
        r14 = r21;
        r2 = r22;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:123:0x0221, B:144:0x028f] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x025c A[Catch:{ UnsupportedEncodingException -> 0x0305, all -> 0x0554 }] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0267 A[Catch:{ UnsupportedEncodingException -> 0x0305, all -> 0x0554 }] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0288 A[Catch:{ UnsupportedEncodingException -> 0x0305, all -> 0x0554 }] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x02b6 A[Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }] */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x036e A[Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x03e1 A[Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }] */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x0525  */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x0554 A[ExcHandler: all (th java.lang.Throwable), PHI: r21 
      PHI: (r21v1 int) = (r21v2 int), (r21v2 int), (r21v2 int), (r21v5 int), (r21v8 int) binds: [B:238:0x0527, B:241:0x0550, B:242:?, B:144:0x028f, B:123:0x0221] A[DONT_GENERATE, DONT_INLINE], Splitter:B:123:0x0221] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.ads.zzzu zzf(int r34, com.google.android.gms.internal.ads.zzfd r35, boolean r36, int r37, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzzr r38) {
        /*
            r0 = r34
            r1 = r35
            r2 = r36
            r3 = r37
            int r4 = r35.zzk()
            int r5 = r35.zzk()
            int r6 = r35.zzk()
            r8 = 3
            if (r0 < r8) goto L_0x001c
            int r9 = r35.zzk()
            goto L_0x001d
        L_0x001c:
            r9 = 0
        L_0x001d:
            r10 = 4
            if (r0 != r10) goto L_0x003c
            int r11 = r35.zzn()
            if (r2 != 0) goto L_0x0047
            r12 = r11 & 255(0xff, float:3.57E-43)
            int r13 = r11 >> 8
            r13 = r13 & 255(0xff, float:3.57E-43)
            int r13 = r13 << 7
            r12 = r12 | r13
            int r13 = r11 >> 16
            r13 = r13 & 255(0xff, float:3.57E-43)
            int r13 = r13 << 14
            r12 = r12 | r13
            int r11 = r11 >> 24
            int r11 = r11 << 21
            r11 = r11 | r12
            goto L_0x0047
        L_0x003c:
            if (r0 != r8) goto L_0x0043
            int r11 = r35.zzn()
            goto L_0x0047
        L_0x0043:
            int r11 = r35.zzm()
        L_0x0047:
            if (r0 < r8) goto L_0x004e
            int r12 = r35.zzo()
            goto L_0x004f
        L_0x004e:
            r12 = 0
        L_0x004f:
            r13 = 0
            if (r4 != 0) goto L_0x0065
            if (r5 != 0) goto L_0x0065
            if (r6 != 0) goto L_0x0065
            if (r9 != 0) goto L_0x0065
            if (r11 != 0) goto L_0x0065
            if (r12 == 0) goto L_0x005d
            goto L_0x0065
        L_0x005d:
            int r0 = r35.zzd()
            r1.zzF(r0)
            return r13
        L_0x0065:
            int r14 = r35.zzc()
            int r14 = r14 + r11
            int r15 = r35.zzd()
            java.lang.String r7 = "Id3Decoder"
            if (r14 <= r15) goto L_0x007f
            java.lang.String r0 = "Frame size exceeds remaining tag data"
            android.util.Log.w(r7, r0)
            int r0 = r35.zzd()
            r1.zzF(r0)
            return r13
        L_0x007f:
            if (r38 != 0) goto L_0x0580
            r15 = 1
            if (r0 != r8) goto L_0x00a2
            r8 = r12 & 128(0x80, float:1.794E-43)
            if (r8 == 0) goto L_0x008a
            r8 = r15
            goto L_0x008b
        L_0x008a:
            r8 = 0
        L_0x008b:
            r17 = r12 & 64
            if (r17 == 0) goto L_0x0092
            r17 = r15
            goto L_0x0094
        L_0x0092:
            r17 = 0
        L_0x0094:
            r12 = r12 & 32
            if (r12 == 0) goto L_0x009a
            r12 = r15
            goto L_0x009b
        L_0x009a:
            r12 = 0
        L_0x009b:
            r18 = r17
            r19 = 0
            r17 = r8
            goto L_0x00d5
        L_0x00a2:
            if (r0 != r10) goto L_0x00cd
            r8 = r12 & 64
            if (r8 == 0) goto L_0x00aa
            r8 = r15
            goto L_0x00ab
        L_0x00aa:
            r8 = 0
        L_0x00ab:
            r17 = r12 & 8
            if (r17 == 0) goto L_0x00b2
            r17 = r15
            goto L_0x00b4
        L_0x00b2:
            r17 = 0
        L_0x00b4:
            r18 = r12 & 4
            if (r18 == 0) goto L_0x00bb
            r18 = r15
            goto L_0x00bd
        L_0x00bb:
            r18 = 0
        L_0x00bd:
            r19 = r12 & 2
            if (r19 == 0) goto L_0x00c4
            r19 = r15
            goto L_0x00c6
        L_0x00c4:
            r19 = 0
        L_0x00c6:
            r12 = r12 & r15
            r33 = r12
            r12 = r8
            r8 = r33
            goto L_0x00d5
        L_0x00cd:
            r8 = 0
            r12 = 0
            r17 = 0
            r18 = 0
            r19 = 0
        L_0x00d5:
            if (r17 != 0) goto L_0x0575
            if (r18 == 0) goto L_0x00db
            goto L_0x0575
        L_0x00db:
            if (r12 == 0) goto L_0x00e2
            int r11 = r11 + -1
            r1.zzG(r15)
        L_0x00e2:
            if (r8 == 0) goto L_0x00e9
            int r11 = r11 + -4
            r1.zzG(r10)
        L_0x00e9:
            if (r19 == 0) goto L_0x00ef
            int r11 = zze(r1, r11)
        L_0x00ef:
            r8 = 84
            r12 = 88
            r10 = 2
            if (r4 != r8) goto L_0x012f
            if (r5 != r12) goto L_0x012f
            if (r6 != r12) goto L_0x012f
            if (r0 == r10) goto L_0x00fe
            if (r9 != r12) goto L_0x012f
        L_0x00fe:
            if (r11 > 0) goto L_0x0101
            goto L_0x0137
        L_0x0101:
            int r2 = r35.zzk()     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            java.lang.String r3 = zzh(r2)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            int r8 = r11 + -1
            byte[] r10 = new byte[r8]     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            r12 = 0
            r1.zzB(r10, r12, r8)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            int r8 = zzc(r10, r12, r2)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            java.lang.String r15 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            r15.<init>(r10, r12, r8, r3)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            int r12 = zzb(r2)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            int r8 = r8 + r12
            int r2 = zzc(r10, r8, r2)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            java.lang.String r2 = zzg(r10, r8, r2, r3)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            com.google.android.gms.internal.ads.zzaac r3 = new com.google.android.gms.internal.ads.zzaac     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            java.lang.String r8 = "TXXX"
            r3.<init>(r8, r15, r2)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            goto L_0x0160
        L_0x012f:
            if (r4 != r8) goto L_0x0168
            java.lang.String r2 = zzi(r0, r8, r5, r6, r9)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            if (r11 > 0) goto L_0x0142
        L_0x0137:
            r23 = r4
            r3 = r5
            r4 = r6
            r22 = r7
            r7 = r9
            r21 = r14
            goto L_0x0523
        L_0x0142:
            int r3 = r35.zzk()     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            java.lang.String r8 = zzh(r3)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            int r10 = r11 + -1
            byte[] r12 = new byte[r10]     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            r15 = 0
            r1.zzB(r12, r15, r10)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            int r3 = zzc(r12, r15, r3)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            java.lang.String r10 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            r10.<init>(r12, r15, r3, r8)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            com.google.android.gms.internal.ads.zzaac r3 = new com.google.android.gms.internal.ads.zzaac     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            r3.<init>(r2, r13, r10)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
        L_0x0160:
            r13 = r3
            goto L_0x0137
        L_0x0162:
            r0 = move-exception
            goto L_0x0571
        L_0x0165:
            r2 = r7
            goto L_0x0567
        L_0x0168:
            r8 = 87
            java.lang.String r15 = "ISO-8859-1"
            if (r4 != r8) goto L_0x01a9
            if (r5 != r12) goto L_0x01a7
            if (r6 != r12) goto L_0x01a7
            if (r0 == r10) goto L_0x0176
            if (r9 != r12) goto L_0x01a7
        L_0x0176:
            if (r11 > 0) goto L_0x0179
            goto L_0x0137
        L_0x0179:
            int r2 = r35.zzk()     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            java.lang.String r3 = zzh(r2)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            int r8 = r11 + -1
            byte[] r10 = new byte[r8]     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            r12 = 0
            r1.zzB(r10, r12, r8)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            int r8 = zzc(r10, r12, r2)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            java.lang.String r13 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            r13.<init>(r10, r12, r8, r3)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            int r2 = zzb(r2)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            int r8 = r8 + r2
            int r2 = zzd(r10, r8)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            java.lang.String r2 = zzg(r10, r8, r2, r15)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            com.google.android.gms.internal.ads.zzaae r3 = new com.google.android.gms.internal.ads.zzaae     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            java.lang.String r8 = "WXXX"
            r3.<init>(r8, r13, r2)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            goto L_0x0160
        L_0x01a7:
            r12 = r8
            goto L_0x01aa
        L_0x01a9:
            r12 = r4
        L_0x01aa:
            if (r12 != r8) goto L_0x01c6
            java.lang.String r2 = zzi(r0, r8, r5, r6, r9)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            byte[] r3 = new byte[r11]     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            r8 = 0
            r1.zzB(r3, r8, r11)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            int r10 = zzd(r3, r8)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            java.lang.String r12 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            r12.<init>(r3, r8, r10, r15)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            com.google.android.gms.internal.ads.zzaae r3 = new com.google.android.gms.internal.ads.zzaae     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            r8 = 0
            r3.<init>(r2, r8, r12)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            goto L_0x0160
        L_0x01c6:
            r8 = 73
            r13 = 80
            if (r12 != r13) goto L_0x01f3
            r12 = 82
            if (r5 != r12) goto L_0x01f2
            if (r6 != r8) goto L_0x01f2
            r12 = 86
            if (r9 != r12) goto L_0x01f2
            byte[] r2 = new byte[r11]     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            r3 = 0
            r1.zzB(r2, r3, r11)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            int r8 = zzd(r2, r3)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            java.lang.String r10 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            r10.<init>(r2, r3, r8, r15)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            r3 = 1
            int r8 = r8 + r3
            byte[] r2 = zzk(r2, r8, r11)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            com.google.android.gms.internal.ads.zzaaa r3 = new com.google.android.gms.internal.ads.zzaaa     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            r3.<init>(r10, r2)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            goto L_0x0160
        L_0x01f2:
            r12 = r13
        L_0x01f3:
            r8 = 79
            r13 = 71
            if (r12 != r13) goto L_0x0256
            r12 = 69
            if (r5 != r12) goto L_0x0252
            if (r6 != r8) goto L_0x0252
            r12 = 66
            if (r9 == r12) goto L_0x0208
            if (r0 != r10) goto L_0x0206
            goto L_0x0208
        L_0x0206:
            r12 = r13
            goto L_0x0256
        L_0x0208:
            int r2 = r35.zzk()     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            java.lang.String r3 = zzh(r2)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            int r8 = r11 + -1
            byte[] r10 = new byte[r8]     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            r12 = 0
            r1.zzB(r10, r12, r8)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            int r13 = zzd(r10, r12)     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            java.lang.String r12 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0165 }
            r21 = r14
            r14 = 0
            r12.<init>(r10, r14, r13, r15)     // Catch:{ UnsupportedEncodingException -> 0x0305, all -> 0x0554 }
            r14 = 1
            int r13 = r13 + r14
            int r14 = zzc(r10, r13, r2)     // Catch:{ UnsupportedEncodingException -> 0x0305, all -> 0x0554 }
            java.lang.String r13 = zzg(r10, r13, r14, r3)     // Catch:{ UnsupportedEncodingException -> 0x0305, all -> 0x0554 }
            int r15 = zzb(r2)     // Catch:{ UnsupportedEncodingException -> 0x0305, all -> 0x0554 }
            int r14 = r14 + r15
            int r15 = zzc(r10, r14, r2)     // Catch:{ UnsupportedEncodingException -> 0x0305, all -> 0x0554 }
            java.lang.String r3 = zzg(r10, r14, r15, r3)     // Catch:{ UnsupportedEncodingException -> 0x0305, all -> 0x0554 }
            int r2 = zzb(r2)     // Catch:{ UnsupportedEncodingException -> 0x0305, all -> 0x0554 }
            int r15 = r15 + r2
            byte[] r2 = zzk(r10, r15, r8)     // Catch:{ UnsupportedEncodingException -> 0x0305, all -> 0x0554 }
            com.google.android.gms.internal.ads.zzzp r8 = new com.google.android.gms.internal.ads.zzzp     // Catch:{ UnsupportedEncodingException -> 0x0305, all -> 0x0554 }
            r8.<init>(r12, r13, r3, r2)     // Catch:{ UnsupportedEncodingException -> 0x0305, all -> 0x0554 }
            r23 = r4
            r3 = r5
            r4 = r6
            r22 = r7
            r13 = r8
            goto L_0x035d
        L_0x0252:
            r21 = r14
            r12 = r13
            goto L_0x0258
        L_0x0256:
            r21 = r14
        L_0x0258:
            r13 = 67
            if (r0 != r10) goto L_0x0267
            r14 = 80
            if (r12 != r14) goto L_0x0308
            r8 = 73
            if (r5 != r8) goto L_0x0308
            if (r6 != r13) goto L_0x0308
            goto L_0x0275
        L_0x0267:
            r8 = 73
            r14 = 80
            r10 = 65
            if (r12 != r10) goto L_0x0308
            if (r5 != r14) goto L_0x0308
            if (r6 != r8) goto L_0x0308
            if (r9 != r13) goto L_0x0308
        L_0x0275:
            int r2 = r35.zzk()     // Catch:{ UnsupportedEncodingException -> 0x0305, all -> 0x0554 }
            java.lang.String r3 = zzh(r2)     // Catch:{ UnsupportedEncodingException -> 0x0305, all -> 0x0554 }
            int r8 = r11 + -1
            byte[] r10 = new byte[r8]     // Catch:{ UnsupportedEncodingException -> 0x0305, all -> 0x0554 }
            r12 = 0
            r1.zzB(r10, r12, r8)     // Catch:{ UnsupportedEncodingException -> 0x0305, all -> 0x0554 }
            r13 = 2
            if (r0 != r13) goto L_0x02b6
            java.lang.String r13 = "image/"
            java.lang.String r14 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0305, all -> 0x0554 }
            r22 = r7
            r7 = 3
            r14.<init>(r10, r12, r7, r15)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            java.lang.String r7 = com.google.android.gms.internal.ads.zzfpn.zza(r14)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            int r12 = r7.length()     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            if (r12 == 0) goto L_0x02a5
            java.lang.String r7 = r13.concat(r7)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            goto L_0x02aa
        L_0x02a5:
            java.lang.String r7 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r7.<init>(r13)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
        L_0x02aa:
            java.lang.String r12 = "image/jpg"
            boolean r12 = r12.equals(r7)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            if (r12 == 0) goto L_0x02b4
            java.lang.String r7 = "image/jpeg"
        L_0x02b4:
            r12 = 2
            goto L_0x02e1
        L_0x02b6:
            r22 = r7
            r7 = r12
            int r12 = zzd(r10, r7)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            java.lang.String r13 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r13.<init>(r10, r7, r12, r15)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            java.lang.String r7 = com.google.android.gms.internal.ads.zzfpn.zza(r13)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r13 = 47
            int r13 = r7.indexOf(r13)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r14 = -1
            if (r13 != r14) goto L_0x02e1
            java.lang.String r13 = "image/"
            int r14 = r7.length()     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            if (r14 == 0) goto L_0x02dc
            java.lang.String r7 = r13.concat(r7)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            goto L_0x02e1
        L_0x02dc:
            java.lang.String r7 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r7.<init>(r13)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
        L_0x02e1:
            int r13 = r12 + 1
            byte r13 = r10[r13]     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r13 = r13 & 255(0xff, float:3.57E-43)
            r14 = 2
            int r12 = r12 + r14
            int r14 = zzc(r10, r12, r2)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            java.lang.String r15 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r23 = r4
            int r4 = r14 - r12
            r15.<init>(r10, r12, r4, r3)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            int r2 = zzb(r2)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            int r14 = r14 + r2
            byte[] r2 = zzk(r10, r14, r8)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            com.google.android.gms.internal.ads.zzzf r3 = new com.google.android.gms.internal.ads.zzzf     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r3.<init>(r7, r15, r13, r2)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            goto L_0x035a
        L_0x0305:
            r2 = r7
            goto L_0x055a
        L_0x0308:
            r23 = r4
            r22 = r7
            r4 = 77
            if (r12 != r13) goto L_0x0360
            r7 = 79
            if (r5 != r7) goto L_0x0360
            if (r6 != r4) goto L_0x0360
            if (r9 == r4) goto L_0x031b
            r7 = 2
            if (r0 != r7) goto L_0x0360
        L_0x031b:
            r2 = 4
            if (r11 >= r2) goto L_0x0324
            r3 = r5
            r4 = r6
            r7 = r9
            r13 = 0
            goto L_0x0523
        L_0x0324:
            int r2 = r35.zzk()     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            java.lang.String r3 = zzh(r2)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r4 = 3
            byte[] r7 = new byte[r4]     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r8 = 0
            r1.zzB(r7, r8, r4)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            java.lang.String r10 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r10.<init>(r7, r8, r4)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            int r4 = r11 + -4
            byte[] r7 = new byte[r4]     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r1.zzB(r7, r8, r4)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            int r4 = zzc(r7, r8, r2)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            java.lang.String r12 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r12.<init>(r7, r8, r4, r3)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            int r8 = zzb(r2)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            int r4 = r4 + r8
            int r2 = zzc(r7, r4, r2)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            java.lang.String r2 = zzg(r7, r4, r2, r3)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            com.google.android.gms.internal.ads.zzzn r3 = new com.google.android.gms.internal.ads.zzzn     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r3.<init>(r10, r12, r2)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
        L_0x035a:
            r13 = r3
            r3 = r5
            r4 = r6
        L_0x035d:
            r7 = r9
            goto L_0x0523
        L_0x0360:
            if (r12 != r13) goto L_0x03e1
            r7 = 72
            if (r5 != r7) goto L_0x03e1
            r7 = 65
            if (r6 != r7) goto L_0x03e1
            r7 = 80
            if (r9 != r7) goto L_0x03e1
            int r4 = r35.zzc()     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            byte[] r7 = r35.zzH()     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            int r7 = zzd(r7, r4)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            java.lang.String r8 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            byte[] r10 = r35.zzH()     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            int r12 = r7 - r4
            r8.<init>(r10, r4, r12, r15)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r10 = 1
            int r7 = r7 + r10
            r1.zzF(r7)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            int r26 = r35.zze()     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            int r27 = r35.zze()     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            long r12 = r35.zzs()     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r14 = 4294967295(0xffffffff, double:2.1219957905E-314)
            int r7 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r7 != 0) goto L_0x03a1
            r12 = -1
        L_0x03a1:
            r28 = r12
            long r12 = r35.zzs()     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r14 = 4294967295(0xffffffff, double:2.1219957905E-314)
            int r7 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r7 != 0) goto L_0x03b2
            r12 = -1
        L_0x03b2:
            r30 = r12
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r7.<init>()     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            int r4 = r4 + r11
        L_0x03ba:
            int r10 = r35.zzc()     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            if (r10 >= r4) goto L_0x03cb
            r10 = 0
            com.google.android.gms.internal.ads.zzzu r12 = zzf(r0, r1, r2, r3, r10)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            if (r12 == 0) goto L_0x03ba
            r7.add(r12)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            goto L_0x03ba
        L_0x03cb:
            r2 = 0
            com.google.android.gms.internal.ads.zzzu[] r2 = new com.google.android.gms.internal.ads.zzzu[r2]     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            java.lang.Object[] r2 = r7.toArray(r2)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r32 = r2
            com.google.android.gms.internal.ads.zzzu[] r32 = (com.google.android.gms.internal.ads.zzzu[]) r32     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            com.google.android.gms.internal.ads.zzzj r3 = new com.google.android.gms.internal.ads.zzzj     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r24 = r3
            r25 = r8
            r24.<init>(r25, r26, r27, r28, r30, r32)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            goto L_0x035a
        L_0x03e1:
            if (r12 != r13) goto L_0x0497
            r7 = 84
            if (r5 != r7) goto L_0x0497
            r7 = 79
            if (r6 != r7) goto L_0x0497
            if (r9 != r13) goto L_0x0497
            int r4 = r35.zzc()     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            byte[] r7 = r35.zzH()     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            int r7 = zzd(r7, r4)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            java.lang.String r8 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            byte[] r10 = r35.zzH()     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            int r12 = r7 - r4
            r8.<init>(r10, r4, r12, r15)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r10 = 1
            int r7 = r7 + r10
            r1.zzF(r7)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            int r7 = r35.zzk()     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r10 = r7 & 2
            if (r10 == 0) goto L_0x0415
            r10 = 1
            r26 = 1
            goto L_0x0418
        L_0x0415:
            r10 = 1
            r26 = 0
        L_0x0418:
            r7 = r7 & r10
            int r10 = r35.zzk()     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            java.lang.String[] r12 = new java.lang.String[r10]     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r13 = 0
        L_0x0420:
            if (r13 >= r10) goto L_0x0453
            int r14 = r35.zzc()     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r38 = r10
            byte[] r10 = r35.zzH()     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            int r10 = zzd(r10, r14)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r16 = r9
            java.lang.String r9 = new java.lang.String     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r17 = r6
            byte[] r6 = r35.zzH()     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r20 = r5
            int r5 = r10 - r14
            r9.<init>(r6, r14, r5, r15)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r12[r13] = r9     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            int r10 = r10 + 1
            r1.zzF(r10)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            int r13 = r13 + 1
            r10 = r38
            r9 = r16
            r6 = r17
            r5 = r20
            goto L_0x0420
        L_0x0453:
            r20 = r5
            r17 = r6
            r16 = r9
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r5.<init>()     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            int r4 = r4 + r11
        L_0x045f:
            int r6 = r35.zzc()     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            if (r6 >= r4) goto L_0x0470
            r6 = 0
            com.google.android.gms.internal.ads.zzzu r9 = zzf(r0, r1, r2, r3, r6)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            if (r9 == 0) goto L_0x045f
            r5.add(r9)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            goto L_0x045f
        L_0x0470:
            r2 = 0
            com.google.android.gms.internal.ads.zzzu[] r3 = new com.google.android.gms.internal.ads.zzzu[r2]     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            java.lang.Object[] r2 = r5.toArray(r3)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r29 = r2
            com.google.android.gms.internal.ads.zzzu[] r29 = (com.google.android.gms.internal.ads.zzzu[]) r29     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            com.google.android.gms.internal.ads.zzzl r3 = new com.google.android.gms.internal.ads.zzzl     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r2 = 1
            if (r2 == r7) goto L_0x0483
            r27 = 0
            goto L_0x0485
        L_0x0483:
            r27 = r2
        L_0x0485:
            r24 = r3
            r25 = r8
            r28 = r12
            r24.<init>(r25, r26, r27, r28, r29)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r13 = r3
            r7 = r16
            r4 = r17
            r3 = r20
            goto L_0x0523
        L_0x0497:
            r20 = r5
            r17 = r6
            r16 = r9
            if (r12 != r4) goto L_0x050d
            r2 = 76
            r3 = r20
            if (r3 != r2) goto L_0x0508
            r2 = 76
            r4 = r17
            r7 = r16
            if (r4 != r2) goto L_0x0513
            r2 = 84
            if (r7 != r2) goto L_0x0513
            int r25 = r35.zzo()     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            int r26 = r35.zzm()     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            int r27 = r35.zzm()     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            int r2 = r35.zzk()     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            int r5 = r35.zzk()     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            com.google.android.gms.internal.ads.zzfc r6 = new com.google.android.gms.internal.ads.zzfc     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r6.<init>()     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            byte[] r8 = r35.zzH()     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            int r9 = r35.zzd()     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r6.zzg(r8, r9)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            int r8 = r35.zzc()     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            int r8 = r8 * 8
            r6.zzh(r8)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            int r8 = r11 + -10
            int r8 = r8 * 8
            int r9 = r2 + r5
            int r8 = r8 / r9
            int[] r9 = new int[r8]     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            int[] r10 = new int[r8]     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r12 = 0
        L_0x04ea:
            if (r12 >= r8) goto L_0x04fb
            int r13 = r6.zzc(r2)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            int r14 = r6.zzc(r5)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r9[r12] = r13     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r10[r12] = r14     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            int r12 = r12 + 1
            goto L_0x04ea
        L_0x04fb:
            com.google.android.gms.internal.ads.zzzy r2 = new com.google.android.gms.internal.ads.zzzy     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r24 = r2
            r28 = r9
            r29 = r10
            r24.<init>(r25, r26, r27, r28, r29)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r13 = r2
            goto L_0x0523
        L_0x0508:
            r7 = r16
            r4 = r17
            goto L_0x0513
        L_0x050d:
            r7 = r16
            r4 = r17
            r3 = r20
        L_0x0513:
            java.lang.String r2 = zzi(r0, r12, r3, r4, r7)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            byte[] r5 = new byte[r11]     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r6 = 0
            r1.zzB(r5, r6, r11)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            com.google.android.gms.internal.ads.zzzh r6 = new com.google.android.gms.internal.ads.zzzh     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r6.<init>(r2, r5)     // Catch:{ UnsupportedEncodingException -> 0x0563, all -> 0x0554 }
            r13 = r6
        L_0x0523:
            if (r13 != 0) goto L_0x055d
            r2 = r23
            java.lang.String r0 = zzi(r0, r2, r3, r4, r7)     // Catch:{ UnsupportedEncodingException -> 0x0558, all -> 0x0554 }
            java.lang.String r2 = java.lang.String.valueOf(r0)     // Catch:{ UnsupportedEncodingException -> 0x0558, all -> 0x0554 }
            int r2 = r2.length()     // Catch:{ UnsupportedEncodingException -> 0x0558, all -> 0x0554 }
            int r2 = r2 + 50
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ UnsupportedEncodingException -> 0x0558, all -> 0x0554 }
            r3.<init>(r2)     // Catch:{ UnsupportedEncodingException -> 0x0558, all -> 0x0554 }
            java.lang.String r2 = "Failed to decode frame: id="
            r3.append(r2)     // Catch:{ UnsupportedEncodingException -> 0x0558, all -> 0x0554 }
            r3.append(r0)     // Catch:{ UnsupportedEncodingException -> 0x0558, all -> 0x0554 }
            java.lang.String r0 = ", frameSize="
            r3.append(r0)     // Catch:{ UnsupportedEncodingException -> 0x0558, all -> 0x0554 }
            r3.append(r11)     // Catch:{ UnsupportedEncodingException -> 0x0558, all -> 0x0554 }
            java.lang.String r0 = r3.toString()     // Catch:{ UnsupportedEncodingException -> 0x0558, all -> 0x0554 }
            r2 = r22
            android.util.Log.w(r2, r0)     // Catch:{ UnsupportedEncodingException -> 0x055a, all -> 0x0554 }
            goto L_0x055d
        L_0x0554:
            r0 = move-exception
            r14 = r21
            goto L_0x0571
        L_0x0558:
            r2 = r22
        L_0x055a:
            r14 = r21
            goto L_0x0567
        L_0x055d:
            r14 = r21
            r1.zzF(r14)
            return r13
        L_0x0563:
            r14 = r21
            r2 = r22
        L_0x0567:
            java.lang.String r0 = "Unsupported character encoding"
            android.util.Log.w(r2, r0)     // Catch:{ all -> 0x0162 }
            r1.zzF(r14)
            r0 = 0
            return r0
        L_0x0571:
            r1.zzF(r14)
            throw r0
        L_0x0575:
            r2 = r7
            r0 = r13
            java.lang.String r3 = "Skipping unsupported compressed or encrypted frame"
            android.util.Log.w(r2, r3)
            r1.zzF(r14)
            return r0
        L_0x0580:
            r0 = r13
            r1.zzF(r14)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzt.zzf(int, com.google.android.gms.internal.ads.zzfd, boolean, int, com.google.android.gms.internal.ads.zzzr):com.google.android.gms.internal.ads.zzzu");
    }

    private static String zzg(byte[] bArr, int i11, int i12, String str) throws UnsupportedEncodingException {
        return (i12 <= i11 || i12 > bArr.length) ? "" : new String(bArr, i11, i12 - i11, str);
    }

    private static String zzh(int i11) {
        return i11 != 1 ? i11 != 2 ? i11 != 3 ? "ISO-8859-1" : "UTF-8" : "UTF-16BE" : "UTF-16";
    }

    private static String zzi(int i11, int i12, int i13, int i14, int i15) {
        if (i11 == 2) {
            return String.format(Locale.US, "%c%c%c", new Object[]{Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14)});
        }
        return String.format(Locale.US, "%c%c%c%c", new Object[]{Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15)});
    }

    private static boolean zzj(zzfd zzfd, int i11, int i12, boolean z11) {
        int i13;
        long j11;
        int i14;
        int i15;
        zzfd zzfd2 = zzfd;
        int i16 = i11;
        int zzc = zzfd.zzc();
        while (true) {
            try {
                int i17 = 1;
                if (zzfd.zza() >= i12) {
                    if (i16 >= 3) {
                        i14 = zzfd.zze();
                        j11 = zzfd.zzs();
                        i13 = zzfd.zzo();
                    } else {
                        i14 = zzfd.zzm();
                        j11 = (long) zzfd.zzm();
                        i13 = 0;
                    }
                    if (i14 == 0 && j11 == 0 && i13 == 0) {
                        zzfd2.zzF(zzc);
                        return true;
                    }
                    if (i16 == 4 && !z11) {
                        if ((8421504 & j11) != 0) {
                            zzfd2.zzF(zzc);
                            return false;
                        }
                        j11 = ((j11 >> 24) << 21) | ((255 & (j11 >> 16)) << 14) | (j11 & 255) | (((j11 >> 8) & 255) << 7);
                    }
                    if (i16 == 4) {
                        if ((i13 & 64) == 0) {
                            i17 = 0;
                        }
                        int i18 = i17;
                        i17 = i13 & 1;
                        i15 = i18;
                    } else if (i16 == 3) {
                        if ((i13 & 32) != 0) {
                            i15 = 1;
                        } else {
                            i15 = 0;
                        }
                        if ((i13 & 128) == 0) {
                            i17 = 0;
                        }
                    } else {
                        i15 = 0;
                        i17 = 0;
                    }
                    if (i17 != 0) {
                        i15 += 4;
                    }
                    if (j11 < ((long) i15)) {
                        zzfd2.zzF(zzc);
                        return false;
                    } else if (((long) zzfd.zza()) < j11) {
                        return false;
                    } else {
                        zzfd2.zzG((int) j11);
                    }
                } else {
                    zzfd2.zzF(zzc);
                    return true;
                }
            } finally {
                zzfd2.zzF(zzc);
            }
        }
    }

    private static byte[] zzk(byte[] bArr, int i11, int i12) {
        if (i12 <= i11) {
            return zzfn.zzf;
        }
        return Arrays.copyOfRange(bArr, i11, i12);
    }
}

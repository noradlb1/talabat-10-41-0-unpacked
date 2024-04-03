package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.media.MediaCodecInfo;
import android.util.Log;
import androidx.annotation.CheckResult;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

@SuppressLint({"InlinedApi"})
public final class zzoy {
    public static final /* synthetic */ int zza = 0;
    private static final Pattern zzb = Pattern.compile("^\\D?(\\d+)$");
    @GuardedBy("MediaCodecUtil.class")
    private static final HashMap<zzoq, List<zzoh>> zzc = new HashMap<>();
    private static int zzd = -1;

    public static int zza() throws zzos {
        int i11;
        int i12;
        if (zzd == -1) {
            int i13 = 0;
            zzoh zzc2 = zzc(MimeTypes.VIDEO_H264, false, false);
            if (zzc2 != null) {
                MediaCodecInfo.CodecProfileLevel[] zzg = zzc2.zzg();
                int length = zzg.length;
                int i14 = 0;
                while (i13 < length) {
                    int i15 = zzg[i13].level;
                    if (i15 != 1 && i15 != 2) {
                        switch (i15) {
                            case 8:
                            case 16:
                            case 32:
                                i12 = 101376;
                                break;
                            case 64:
                                i12 = 202752;
                                break;
                            case 128:
                            case 256:
                                i12 = 414720;
                                break;
                            case 512:
                                i12 = 921600;
                                break;
                            case 1024:
                                i12 = 1310720;
                                break;
                            case 2048:
                            case 4096:
                                i12 = 2097152;
                                break;
                            case 8192:
                                i12 = 2228224;
                                break;
                            case 16384:
                                i12 = 5652480;
                                break;
                            case 32768:
                            case 65536:
                                i12 = 9437184;
                                break;
                            case 131072:
                            case 262144:
                            case 524288:
                                i12 = 35651584;
                                break;
                            default:
                                i12 = -1;
                                break;
                        }
                    } else {
                        i12 = 25344;
                    }
                    i14 = Math.max(i12, i14);
                    i13++;
                }
                if (zzfn.zza >= 21) {
                    i11 = 345600;
                } else {
                    i11 = 172800;
                }
                i13 = Math.max(i14, i11);
            }
            zzd = i13;
        }
        return zzd;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:463:0x076c  */
    /* JADX WARNING: Removed duplicated region for block: B:464:0x0782  */
    /* JADX WARNING: Removed duplicated region for block: B:509:0x0834  */
    /* JADX WARNING: Removed duplicated region for block: B:510:0x0849  */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> zzb(com.google.android.gms.internal.ads.zzab r17) {
        /*
            r0 = r17
            java.lang.String r1 = r0.zzj
            r2 = 0
            if (r1 != 0) goto L_0x0008
            return r2
        L_0x0008:
            java.lang.String r3 = "\\."
            java.lang.String[] r1 = r1.split(r3)
            java.lang.String r3 = "video/dolby-vision"
            java.lang.String r4 = r0.zzm
            boolean r3 = r3.equals(r4)
            r7 = 512(0x200, float:7.175E-43)
            r8 = 256(0x100, float:3.59E-43)
            r9 = 128(0x80, float:1.794E-43)
            r11 = 64
            r13 = 4096(0x1000, float:5.74E-42)
            r14 = 32
            r15 = 16
            r5 = 8
            r2 = 3
            r10 = 4
            r12 = 2
            java.lang.String r4 = "MediaCodecUtil"
            r6 = 1
            if (r3 == 0) goto L_0x0229
            java.lang.String r0 = r0.zzj
            int r3 = r1.length
            if (r3 >= r2) goto L_0x004f
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r1 = r0.length()
            java.lang.String r2 = "Ignoring malformed Dolby Vision codec string: "
            if (r1 == 0) goto L_0x0044
            java.lang.String r0 = r2.concat(r0)
            goto L_0x0049
        L_0x0044:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
        L_0x0049:
            android.util.Log.w(r4, r0)
        L_0x004c:
            r2 = 0
            goto L_0x0228
        L_0x004f:
            java.util.regex.Pattern r3 = zzb
            r2 = r1[r6]
            java.util.regex.Matcher r2 = r3.matcher(r2)
            boolean r3 = r2.matches()
            if (r3 != 0) goto L_0x0077
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r1 = r0.length()
            java.lang.String r2 = "Ignoring malformed Dolby Vision codec string: "
            if (r1 == 0) goto L_0x006e
            java.lang.String r0 = r2.concat(r0)
            goto L_0x0073
        L_0x006e:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
        L_0x0073:
            android.util.Log.w(r4, r0)
            goto L_0x004c
        L_0x0077:
            java.lang.String r0 = r2.group(r6)
            if (r0 != 0) goto L_0x0080
        L_0x007d:
            r2 = 0
            goto L_0x0125
        L_0x0080:
            int r2 = r0.hashCode()
            switch(r2) {
                case 1536: goto L_0x00e5;
                case 1537: goto L_0x00db;
                case 1538: goto L_0x00d1;
                case 1539: goto L_0x00c7;
                case 1540: goto L_0x00bd;
                case 1541: goto L_0x00b3;
                case 1542: goto L_0x00a9;
                case 1543: goto L_0x009f;
                case 1544: goto L_0x0095;
                case 1545: goto L_0x0089;
                default: goto L_0x0087;
            }
        L_0x0087:
            goto L_0x00ef
        L_0x0089:
            java.lang.String r2 = "09"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x00ef
            r2 = 9
            goto L_0x00f0
        L_0x0095:
            java.lang.String r2 = "08"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x00ef
            r2 = r5
            goto L_0x00f0
        L_0x009f:
            java.lang.String r2 = "07"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x00ef
            r2 = 7
            goto L_0x00f0
        L_0x00a9:
            java.lang.String r2 = "06"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x00ef
            r2 = 6
            goto L_0x00f0
        L_0x00b3:
            java.lang.String r2 = "05"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x00ef
            r2 = 5
            goto L_0x00f0
        L_0x00bd:
            java.lang.String r2 = "04"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x00ef
            r2 = r10
            goto L_0x00f0
        L_0x00c7:
            java.lang.String r2 = "03"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x00ef
            r2 = 3
            goto L_0x00f0
        L_0x00d1:
            java.lang.String r2 = "02"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x00ef
            r2 = r12
            goto L_0x00f0
        L_0x00db:
            java.lang.String r2 = "01"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x00ef
            r2 = r6
            goto L_0x00f0
        L_0x00e5:
            java.lang.String r2 = "00"
            boolean r2 = r0.equals(r2)
            if (r2 == 0) goto L_0x00ef
            r2 = 0
            goto L_0x00f0
        L_0x00ef:
            r2 = -1
        L_0x00f0:
            switch(r2) {
                case 0: goto L_0x0121;
                case 1: goto L_0x011c;
                case 2: goto L_0x0117;
                case 3: goto L_0x0112;
                case 4: goto L_0x010d;
                case 5: goto L_0x0108;
                case 6: goto L_0x0103;
                case 7: goto L_0x00fe;
                case 8: goto L_0x00f9;
                case 9: goto L_0x00f4;
                default: goto L_0x00f3;
            }
        L_0x00f3:
            goto L_0x007d
        L_0x00f4:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            goto L_0x0125
        L_0x00f9:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)
            goto L_0x0125
        L_0x00fe:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r9)
            goto L_0x0125
        L_0x0103:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r11)
            goto L_0x0125
        L_0x0108:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r14)
            goto L_0x0125
        L_0x010d:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r15)
            goto L_0x0125
        L_0x0112:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            goto L_0x0125
        L_0x0117:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r10)
            goto L_0x0125
        L_0x011c:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r12)
            goto L_0x0125
        L_0x0121:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
        L_0x0125:
            if (r2 != 0) goto L_0x0142
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r1 = r0.length()
            java.lang.String r2 = "Unknown Dolby Vision profile string: "
            if (r1 == 0) goto L_0x0138
            java.lang.String r0 = r2.concat(r0)
            goto L_0x013d
        L_0x0138:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
        L_0x013d:
            android.util.Log.w(r4, r0)
            goto L_0x004c
        L_0x0142:
            r0 = r1[r12]
            if (r0 != 0) goto L_0x0149
        L_0x0146:
            r1 = 0
            goto L_0x0205
        L_0x0149:
            int r1 = r0.hashCode()
            switch(r1) {
                case 1537: goto L_0x01f9;
                case 1538: goto L_0x01ec;
                case 1539: goto L_0x01df;
                case 1540: goto L_0x01d2;
                case 1541: goto L_0x01c5;
                case 1542: goto L_0x01b8;
                case 1543: goto L_0x01ab;
                case 1544: goto L_0x019e;
                case 1545: goto L_0x0190;
                default: goto L_0x0150;
            }
        L_0x0150:
            switch(r1) {
                case 1567: goto L_0x0182;
                case 1568: goto L_0x0172;
                case 1569: goto L_0x0162;
                case 1570: goto L_0x0154;
                default: goto L_0x0153;
            }
        L_0x0153:
            goto L_0x0146
        L_0x0154:
            java.lang.String r1 = "13"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0146
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            goto L_0x0205
        L_0x0162:
            java.lang.String r1 = "12"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0146
            r1 = 2048(0x800, float:2.87E-42)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0205
        L_0x0172:
            java.lang.String r1 = "11"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0146
            r1 = 1024(0x400, float:1.435E-42)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0205
        L_0x0182:
            java.lang.String r1 = "10"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0146
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)
            goto L_0x0205
        L_0x0190:
            java.lang.String r1 = "09"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0146
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)
            goto L_0x0205
        L_0x019e:
            java.lang.String r1 = "08"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0146
            java.lang.Integer r1 = java.lang.Integer.valueOf(r9)
            goto L_0x0205
        L_0x01ab:
            java.lang.String r1 = "07"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0146
            java.lang.Integer r1 = java.lang.Integer.valueOf(r11)
            goto L_0x0205
        L_0x01b8:
            java.lang.String r1 = "06"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0146
            java.lang.Integer r1 = java.lang.Integer.valueOf(r14)
            goto L_0x0205
        L_0x01c5:
            java.lang.String r1 = "05"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0146
            java.lang.Integer r1 = java.lang.Integer.valueOf(r15)
            goto L_0x0205
        L_0x01d2:
            java.lang.String r1 = "04"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0146
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            goto L_0x0205
        L_0x01df:
            java.lang.String r1 = "03"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0146
            java.lang.Integer r1 = java.lang.Integer.valueOf(r10)
            goto L_0x0205
        L_0x01ec:
            java.lang.String r1 = "02"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0146
            java.lang.Integer r1 = java.lang.Integer.valueOf(r12)
            goto L_0x0205
        L_0x01f9:
            java.lang.String r1 = "01"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0146
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
        L_0x0205:
            if (r1 != 0) goto L_0x0222
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r1 = r0.length()
            java.lang.String r2 = "Unknown Dolby Vision level string: "
            if (r1 == 0) goto L_0x0218
            java.lang.String r0 = r2.concat(r0)
            goto L_0x021d
        L_0x0218:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
        L_0x021d:
            android.util.Log.w(r4, r0)
            goto L_0x004c
        L_0x0222:
            android.util.Pair r0 = new android.util.Pair
            r0.<init>(r2, r1)
            r2 = r0
        L_0x0228:
            return r2
        L_0x0229:
            r2 = 0
            r3 = r1[r2]
            int r2 = r3.hashCode()
            switch(r2) {
                case 3004662: goto L_0x0270;
                case 3006243: goto L_0x0266;
                case 3006244: goto L_0x025c;
                case 3199032: goto L_0x0252;
                case 3214780: goto L_0x0248;
                case 3356560: goto L_0x023e;
                case 3624515: goto L_0x0234;
                default: goto L_0x0233;
            }
        L_0x0233:
            goto L_0x027a
        L_0x0234:
            java.lang.String r2 = "vp09"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x027a
            r2 = r12
            goto L_0x027b
        L_0x023e:
            java.lang.String r2 = "mp4a"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x027a
            r2 = 6
            goto L_0x027b
        L_0x0248:
            java.lang.String r2 = "hvc1"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x027a
            r2 = r10
            goto L_0x027b
        L_0x0252:
            java.lang.String r2 = "hev1"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x027a
            r2 = 3
            goto L_0x027b
        L_0x025c:
            java.lang.String r2 = "avc2"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x027a
            r2 = r6
            goto L_0x027b
        L_0x0266:
            java.lang.String r2 = "avc1"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x027a
            r2 = 0
            goto L_0x027b
        L_0x0270:
            java.lang.String r2 = "av01"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x027a
            r2 = 5
            goto L_0x027b
        L_0x027a:
            r2 = -1
        L_0x027b:
            r3 = 30
            r11 = 20
            switch(r2) {
                case 0: goto L_0x07ac;
                case 1: goto L_0x07ac;
                case 2: goto L_0x06c5;
                case 3: goto L_0x0434;
                case 4: goto L_0x0434;
                case 5: goto L_0x0329;
                case 6: goto L_0x0284;
                default: goto L_0x0282;
            }
        L_0x0282:
            r0 = 0
            return r0
        L_0x0284:
            java.lang.String r0 = r0.zzj
            int r2 = r1.length
            r3 = 3
            if (r2 == r3) goto L_0x02a6
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r1 = r0.length()
            java.lang.String r2 = "Ignoring malformed MP4A codec string: "
            if (r1 == 0) goto L_0x029b
            java.lang.String r0 = r2.concat(r0)
            goto L_0x02a0
        L_0x029b:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
        L_0x02a0:
            android.util.Log.w(r4, r0)
        L_0x02a3:
            r2 = 0
            goto L_0x0328
        L_0x02a6:
            java.lang.String r2 = "audio/mp4a-latm"
            r3 = r1[r6]     // Catch:{ NumberFormatException -> 0x030d }
            int r3 = java.lang.Integer.parseInt(r3, r15)     // Catch:{ NumberFormatException -> 0x030d }
            java.lang.String r3 = com.google.android.gms.internal.ads.zzbi.zzd(r3)     // Catch:{ NumberFormatException -> 0x030d }
            boolean r2 = r2.equals(r3)     // Catch:{ NumberFormatException -> 0x030d }
            if (r2 == 0) goto L_0x02a3
            r1 = r1[r12]     // Catch:{ NumberFormatException -> 0x030d }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x030d }
            r2 = 17
            if (r1 == r2) goto L_0x02f8
            if (r1 == r11) goto L_0x02f6
            r2 = 23
            if (r1 == r2) goto L_0x02f3
            r2 = 29
            if (r1 == r2) goto L_0x02f0
            r2 = 39
            if (r1 == r2) goto L_0x02ed
            r2 = 42
            if (r1 == r2) goto L_0x02ea
            switch(r1) {
                case 1: goto L_0x02e7;
                case 2: goto L_0x02e5;
                case 3: goto L_0x02e2;
                case 4: goto L_0x02e0;
                case 5: goto L_0x02dd;
                case 6: goto L_0x02da;
                default: goto L_0x02d7;
            }     // Catch:{ NumberFormatException -> 0x030d }
        L_0x02d7:
            r1 = -1
            r5 = -1
            goto L_0x02fb
        L_0x02da:
            r1 = -1
            r5 = 6
            goto L_0x02fb
        L_0x02dd:
            r1 = -1
            r5 = 5
            goto L_0x02fb
        L_0x02e0:
            r5 = r10
            goto L_0x02e8
        L_0x02e2:
            r1 = -1
            r5 = 3
            goto L_0x02fb
        L_0x02e5:
            r5 = r12
            goto L_0x02e8
        L_0x02e7:
            r5 = r6
        L_0x02e8:
            r1 = -1
            goto L_0x02fb
        L_0x02ea:
            r5 = 42
            goto L_0x02e8
        L_0x02ed:
            r5 = 39
            goto L_0x02e8
        L_0x02f0:
            r5 = 29
            goto L_0x02e8
        L_0x02f3:
            r5 = 23
            goto L_0x02e8
        L_0x02f6:
            r5 = r11
            goto L_0x02e8
        L_0x02f8:
            r5 = 17
            goto L_0x02e8
        L_0x02fb:
            if (r5 == r1) goto L_0x02a3
            android.util.Pair r1 = new android.util.Pair     // Catch:{ NumberFormatException -> 0x030d }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)     // Catch:{ NumberFormatException -> 0x030d }
            r3 = 0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ NumberFormatException -> 0x030d }
            r1.<init>(r2, r3)     // Catch:{ NumberFormatException -> 0x030d }
            r2 = r1
            goto L_0x0328
        L_0x030d:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r1 = r0.length()
            java.lang.String r2 = "Ignoring malformed MP4A codec string: "
            if (r1 == 0) goto L_0x031e
            java.lang.String r0 = r2.concat(r0)
            goto L_0x0323
        L_0x031e:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
        L_0x0323:
            android.util.Log.w(r4, r0)
            goto L_0x02a3
        L_0x0328:
            return r2
        L_0x0329:
            java.lang.String r2 = r0.zzj
            com.google.android.gms.internal.ads.zzm r0 = r0.zzy
            int r11 = r1.length
            if (r11 >= r10) goto L_0x034c
            java.lang.String r0 = java.lang.String.valueOf(r2)
            int r1 = r0.length()
            java.lang.String r2 = "Ignoring malformed AV1 codec string: "
            if (r1 == 0) goto L_0x0341
            java.lang.String r0 = r2.concat(r0)
            goto L_0x0346
        L_0x0341:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
        L_0x0346:
            android.util.Log.w(r4, r0)
        L_0x0349:
            r2 = 0
            goto L_0x0433
        L_0x034c:
            r11 = r1[r6]     // Catch:{ NumberFormatException -> 0x0418 }
            int r11 = java.lang.Integer.parseInt(r11)     // Catch:{ NumberFormatException -> 0x0418 }
            r15 = r1[r12]     // Catch:{ NumberFormatException -> 0x0418 }
            r8 = 0
            java.lang.String r8 = r15.substring(r8, r12)     // Catch:{ NumberFormatException -> 0x0418 }
            int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ NumberFormatException -> 0x0418 }
            r15 = 3
            r1 = r1[r15]     // Catch:{ NumberFormatException -> 0x0418 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x0418 }
            if (r11 == 0) goto L_0x037b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r14)
            java.lang.String r1 = "Unknown AV1 profile: "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            android.util.Log.w(r4, r0)
            goto L_0x0349
        L_0x037b:
            if (r1 == r5) goto L_0x03aa
            r2 = 10
            if (r1 == r2) goto L_0x0398
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r2 = 34
            r0.<init>(r2)
            java.lang.String r2 = "Unknown AV1 bit depth: "
            r0.append(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            android.util.Log.w(r4, r0)
            goto L_0x0349
        L_0x0398:
            if (r0 == 0) goto L_0x03a8
            byte[] r1 = r0.zze
            if (r1 != 0) goto L_0x03a6
            int r0 = r0.zzd
            r1 = 7
            if (r0 == r1) goto L_0x03a6
            r1 = 6
            if (r0 != r1) goto L_0x03a8
        L_0x03a6:
            r0 = r13
            goto L_0x03ab
        L_0x03a8:
            r0 = r12
            goto L_0x03ab
        L_0x03aa:
            r0 = r6
        L_0x03ab:
            switch(r8) {
                case 0: goto L_0x03f0;
                case 1: goto L_0x03ee;
                case 2: goto L_0x03ec;
                case 3: goto L_0x03ea;
                case 4: goto L_0x03e7;
                case 5: goto L_0x03e5;
                case 6: goto L_0x03e2;
                case 7: goto L_0x03e0;
                case 8: goto L_0x03dd;
                case 9: goto L_0x03db;
                case 10: goto L_0x03d8;
                case 11: goto L_0x03d5;
                case 12: goto L_0x03d3;
                case 13: goto L_0x03d0;
                case 14: goto L_0x03cd;
                case 15: goto L_0x03c9;
                case 16: goto L_0x03c6;
                case 17: goto L_0x03c3;
                case 18: goto L_0x03c0;
                case 19: goto L_0x03bd;
                case 20: goto L_0x03ba;
                case 21: goto L_0x03b7;
                case 22: goto L_0x03b4;
                case 23: goto L_0x03b1;
                default: goto L_0x03ae;
            }
        L_0x03ae:
            r1 = -1
            goto L_0x03f1
        L_0x03b1:
            r1 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x03f1
        L_0x03b4:
            r1 = 4194304(0x400000, float:5.877472E-39)
            goto L_0x03f1
        L_0x03b7:
            r1 = 2097152(0x200000, float:2.938736E-39)
            goto L_0x03f1
        L_0x03ba:
            r1 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x03f1
        L_0x03bd:
            r1 = 524288(0x80000, float:7.34684E-40)
            goto L_0x03f1
        L_0x03c0:
            r1 = 262144(0x40000, float:3.67342E-40)
            goto L_0x03f1
        L_0x03c3:
            r1 = 131072(0x20000, float:1.83671E-40)
            goto L_0x03f1
        L_0x03c6:
            r1 = 65536(0x10000, float:9.18355E-41)
            goto L_0x03f1
        L_0x03c9:
            r1 = 32768(0x8000, float:4.5918E-41)
            goto L_0x03f1
        L_0x03cd:
            r1 = 16384(0x4000, float:2.2959E-41)
            goto L_0x03f1
        L_0x03d0:
            r1 = 8192(0x2000, float:1.14794E-41)
            goto L_0x03f1
        L_0x03d3:
            r1 = r13
            goto L_0x03f1
        L_0x03d5:
            r1 = 2048(0x800, float:2.87E-42)
            goto L_0x03f1
        L_0x03d8:
            r1 = 1024(0x400, float:1.435E-42)
            goto L_0x03f1
        L_0x03db:
            r1 = r7
            goto L_0x03f1
        L_0x03dd:
            r1 = 256(0x100, float:3.59E-43)
            goto L_0x03f1
        L_0x03e0:
            r1 = r9
            goto L_0x03f1
        L_0x03e2:
            r1 = 64
            goto L_0x03f1
        L_0x03e5:
            r1 = r14
            goto L_0x03f1
        L_0x03e7:
            r1 = 16
            goto L_0x03f1
        L_0x03ea:
            r1 = r5
            goto L_0x03f1
        L_0x03ec:
            r1 = r10
            goto L_0x03f1
        L_0x03ee:
            r1 = r12
            goto L_0x03f1
        L_0x03f0:
            r1 = r6
        L_0x03f1:
            r2 = -1
            if (r1 != r2) goto L_0x040a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r3)
            java.lang.String r1 = "Unknown AV1 level: "
            r0.append(r1)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            android.util.Log.w(r4, r0)
            goto L_0x0349
        L_0x040a:
            android.util.Pair r2 = new android.util.Pair
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r2.<init>(r0, r1)
            goto L_0x0433
        L_0x0418:
            java.lang.String r0 = java.lang.String.valueOf(r2)
            int r1 = r0.length()
            java.lang.String r2 = "Ignoring malformed AV1 codec string: "
            if (r1 == 0) goto L_0x0429
            java.lang.String r0 = r2.concat(r0)
            goto L_0x042e
        L_0x0429:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
        L_0x042e:
            android.util.Log.w(r4, r0)
            goto L_0x0349
        L_0x0433:
            return r2
        L_0x0434:
            java.lang.String r0 = r0.zzj
            int r2 = r1.length
            if (r2 >= r10) goto L_0x0455
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r1 = r0.length()
            java.lang.String r2 = "Ignoring malformed HEVC codec string: "
            if (r1 == 0) goto L_0x044a
            java.lang.String r0 = r2.concat(r0)
            goto L_0x044f
        L_0x044a:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
        L_0x044f:
            android.util.Log.w(r4, r0)
        L_0x0452:
            r2 = 0
            goto L_0x06c4
        L_0x0455:
            java.util.regex.Pattern r2 = zzb
            r3 = r1[r6]
            java.util.regex.Matcher r2 = r2.matcher(r3)
            boolean r3 = r2.matches()
            if (r3 != 0) goto L_0x047d
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r1 = r0.length()
            java.lang.String r2 = "Ignoring malformed HEVC codec string: "
            if (r1 == 0) goto L_0x0474
            java.lang.String r0 = r2.concat(r0)
            goto L_0x0479
        L_0x0474:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
        L_0x0479:
            android.util.Log.w(r4, r0)
            goto L_0x0452
        L_0x047d:
            java.lang.String r0 = r2.group(r6)
            java.lang.String r2 = "1"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x048c
            r0 = r6
        L_0x048a:
            r2 = 3
            goto L_0x0496
        L_0x048c:
            java.lang.String r2 = "2"
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x06a9
            r0 = r12
            goto L_0x048a
        L_0x0496:
            r1 = r1[r2]
            if (r1 != 0) goto L_0x049d
        L_0x049a:
            r2 = 0
            goto L_0x0681
        L_0x049d:
            int r2 = r1.hashCode()
            switch(r2) {
                case 70821: goto L_0x05c0;
                case 70914: goto L_0x05b5;
                case 70917: goto L_0x05aa;
                case 71007: goto L_0x059f;
                case 71010: goto L_0x0594;
                case 74665: goto L_0x058a;
                case 74758: goto L_0x0580;
                case 74761: goto L_0x0576;
                case 74851: goto L_0x056c;
                case 74854: goto L_0x0561;
                case 2193639: goto L_0x0555;
                case 2193642: goto L_0x0549;
                case 2193732: goto L_0x053e;
                case 2193735: goto L_0x0532;
                case 2193738: goto L_0x0526;
                case 2193825: goto L_0x051a;
                case 2193828: goto L_0x050e;
                case 2193831: goto L_0x0502;
                case 2312803: goto L_0x04f7;
                case 2312806: goto L_0x04ec;
                case 2312896: goto L_0x04e1;
                case 2312899: goto L_0x04d6;
                case 2312902: goto L_0x04ca;
                case 2312989: goto L_0x04be;
                case 2312992: goto L_0x04b2;
                case 2312995: goto L_0x04a6;
                default: goto L_0x04a4;
            }
        L_0x04a4:
            goto L_0x05cb
        L_0x04a6:
            java.lang.String r2 = "L186"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x05cb
            r2 = 12
            goto L_0x05cc
        L_0x04b2:
            java.lang.String r2 = "L183"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x05cb
            r2 = 11
            goto L_0x05cc
        L_0x04be:
            java.lang.String r2 = "L180"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x05cb
            r2 = 10
            goto L_0x05cc
        L_0x04ca:
            java.lang.String r2 = "L156"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x05cb
            r2 = 9
            goto L_0x05cc
        L_0x04d6:
            java.lang.String r2 = "L153"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x05cb
            r2 = r5
            goto L_0x05cc
        L_0x04e1:
            java.lang.String r2 = "L150"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x05cb
            r2 = 7
            goto L_0x05cc
        L_0x04ec:
            java.lang.String r2 = "L123"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x05cb
            r2 = 6
            goto L_0x05cc
        L_0x04f7:
            java.lang.String r2 = "L120"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x05cb
            r2 = 5
            goto L_0x05cc
        L_0x0502:
            java.lang.String r2 = "H186"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x05cb
            r2 = 25
            goto L_0x05cc
        L_0x050e:
            java.lang.String r2 = "H183"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x05cb
            r2 = 24
            goto L_0x05cc
        L_0x051a:
            java.lang.String r2 = "H180"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x05cb
            r2 = 23
            goto L_0x05cc
        L_0x0526:
            java.lang.String r2 = "H156"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x05cb
            r2 = 22
            goto L_0x05cc
        L_0x0532:
            java.lang.String r2 = "H153"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x05cb
            r2 = 21
            goto L_0x05cc
        L_0x053e:
            java.lang.String r2 = "H150"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x05cb
            r2 = r11
            goto L_0x05cc
        L_0x0549:
            java.lang.String r2 = "H123"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x05cb
            r2 = 19
            goto L_0x05cc
        L_0x0555:
            java.lang.String r2 = "H120"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x05cb
            r2 = 18
            goto L_0x05cc
        L_0x0561:
            java.lang.String r2 = "L93"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x05cb
            r2 = r10
            goto L_0x05cc
        L_0x056c:
            java.lang.String r2 = "L90"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x05cb
            r2 = 3
            goto L_0x05cc
        L_0x0576:
            java.lang.String r2 = "L63"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x05cb
            r2 = r12
            goto L_0x05cc
        L_0x0580:
            java.lang.String r2 = "L60"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x05cb
            r2 = r6
            goto L_0x05cc
        L_0x058a:
            java.lang.String r2 = "L30"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x05cb
            r2 = 0
            goto L_0x05cc
        L_0x0594:
            java.lang.String r2 = "H93"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x05cb
            r2 = 17
            goto L_0x05cc
        L_0x059f:
            java.lang.String r2 = "H90"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x05cb
            r2 = 16
            goto L_0x05cc
        L_0x05aa:
            java.lang.String r2 = "H63"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x05cb
            r2 = 15
            goto L_0x05cc
        L_0x05b5:
            java.lang.String r2 = "H60"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x05cb
            r2 = 14
            goto L_0x05cc
        L_0x05c0:
            java.lang.String r2 = "H30"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x05cb
            r2 = 13
            goto L_0x05cc
        L_0x05cb:
            r2 = -1
        L_0x05cc:
            switch(r2) {
                case 0: goto L_0x067d;
                case 1: goto L_0x0678;
                case 2: goto L_0x0671;
                case 3: goto L_0x066a;
                case 4: goto L_0x0663;
                case 5: goto L_0x065c;
                case 6: goto L_0x0657;
                case 7: goto L_0x0650;
                case 8: goto L_0x0649;
                case 9: goto L_0x0642;
                case 10: goto L_0x063b;
                case 11: goto L_0x0634;
                case 12: goto L_0x062d;
                case 13: goto L_0x0628;
                case 14: goto L_0x0623;
                case 15: goto L_0x061e;
                case 16: goto L_0x0618;
                case 17: goto L_0x0612;
                case 18: goto L_0x060a;
                case 19: goto L_0x0602;
                case 20: goto L_0x05f9;
                case 21: goto L_0x05f1;
                case 22: goto L_0x05e9;
                case 23: goto L_0x05e1;
                case 24: goto L_0x05d9;
                case 25: goto L_0x05d1;
                default: goto L_0x05cf;
            }
        L_0x05cf:
            goto L_0x049a
        L_0x05d1:
            r2 = 33554432(0x2000000, float:9.403955E-38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0681
        L_0x05d9:
            r2 = 8388608(0x800000, float:1.17549435E-38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0681
        L_0x05e1:
            r2 = 2097152(0x200000, float:2.938736E-39)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0681
        L_0x05e9:
            r2 = 524288(0x80000, float:7.34684E-40)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0681
        L_0x05f1:
            r2 = 131072(0x20000, float:1.83671E-40)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0681
        L_0x05f9:
            r2 = 32768(0x8000, float:4.5918E-41)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0681
        L_0x0602:
            r2 = 8192(0x2000, float:1.14794E-41)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0681
        L_0x060a:
            r2 = 2048(0x800, float:2.87E-42)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0681
        L_0x0612:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r7)
            goto L_0x0681
        L_0x0618:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r9)
            goto L_0x0681
        L_0x061e:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r14)
            goto L_0x0681
        L_0x0623:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r5)
            goto L_0x0681
        L_0x0628:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r12)
            goto L_0x0681
        L_0x062d:
            r2 = 16777216(0x1000000, float:2.3509887E-38)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0681
        L_0x0634:
            r2 = 4194304(0x400000, float:5.877472E-39)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0681
        L_0x063b:
            r2 = 1048576(0x100000, float:1.469368E-39)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0681
        L_0x0642:
            r2 = 262144(0x40000, float:3.67342E-40)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0681
        L_0x0649:
            r2 = 65536(0x10000, float:9.18355E-41)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0681
        L_0x0650:
            r2 = 16384(0x4000, float:2.2959E-41)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0681
        L_0x0657:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            goto L_0x0681
        L_0x065c:
            r8 = 1024(0x400, float:1.435E-42)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)
            goto L_0x0681
        L_0x0663:
            r15 = 256(0x100, float:3.59E-43)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r15)
            goto L_0x0681
        L_0x066a:
            r16 = 64
            java.lang.Integer r2 = java.lang.Integer.valueOf(r16)
            goto L_0x0681
        L_0x0671:
            r2 = 16
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0681
        L_0x0678:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r10)
            goto L_0x0681
        L_0x067d:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r6)
        L_0x0681:
            if (r2 != 0) goto L_0x069e
            java.lang.String r0 = java.lang.String.valueOf(r1)
            int r1 = r0.length()
            java.lang.String r2 = "Unknown HEVC level string: "
            if (r1 == 0) goto L_0x0694
            java.lang.String r0 = r2.concat(r0)
            goto L_0x0699
        L_0x0694:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
        L_0x0699:
            android.util.Log.w(r4, r0)
            goto L_0x0452
        L_0x069e:
            android.util.Pair r1 = new android.util.Pair
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1.<init>(r0, r2)
            r2 = r1
            goto L_0x06c4
        L_0x06a9:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r1 = r0.length()
            java.lang.String r2 = "Unknown HEVC profile string: "
            if (r1 == 0) goto L_0x06ba
            java.lang.String r0 = r2.concat(r0)
            goto L_0x06bf
        L_0x06ba:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
        L_0x06bf:
            android.util.Log.w(r4, r0)
            goto L_0x0452
        L_0x06c4:
            return r2
        L_0x06c5:
            r15 = r8
            r2 = 2048(0x800, float:2.87E-42)
            r16 = 64
            java.lang.String r0 = r0.zzj
            int r8 = r1.length
            r2 = 3
            if (r8 >= r2) goto L_0x06ec
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r1 = r0.length()
            java.lang.String r2 = "Ignoring malformed VP9 codec string: "
            if (r1 == 0) goto L_0x06e1
            java.lang.String r0 = r2.concat(r0)
            goto L_0x06e6
        L_0x06e1:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
        L_0x06e6:
            android.util.Log.w(r4, r0)
        L_0x06e9:
            r2 = 0
            goto L_0x07ab
        L_0x06ec:
            r2 = r1[r6]     // Catch:{ NumberFormatException -> 0x0790 }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x0790 }
            r1 = r1[r12]     // Catch:{ NumberFormatException -> 0x0790 }
            int r0 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x0790 }
            if (r2 == 0) goto L_0x0709
            if (r2 == r6) goto L_0x0707
            if (r2 == r12) goto L_0x0705
            r1 = 3
            if (r2 == r1) goto L_0x0703
            r1 = -1
            goto L_0x070a
        L_0x0703:
            r1 = r5
            goto L_0x070a
        L_0x0705:
            r1 = r10
            goto L_0x070a
        L_0x0707:
            r1 = r12
            goto L_0x070a
        L_0x0709:
            r1 = r6
        L_0x070a:
            r8 = -1
            if (r1 != r8) goto L_0x0722
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r14)
            java.lang.String r1 = "Unknown VP9 profile: "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.w(r4, r0)
            goto L_0x06e9
        L_0x0722:
            r2 = 10
            if (r0 == r2) goto L_0x0769
            r2 = 11
            if (r0 == r2) goto L_0x0768
            if (r0 == r11) goto L_0x0766
            r2 = 21
            if (r0 == r2) goto L_0x0764
            if (r0 == r3) goto L_0x0760
            r2 = 31
            if (r0 == r2) goto L_0x075e
            r2 = 40
            if (r0 == r2) goto L_0x075b
            r2 = 41
            if (r0 == r2) goto L_0x0759
            r2 = 50
            if (r0 == r2) goto L_0x0757
            r2 = 51
            if (r0 == r2) goto L_0x0755
            switch(r0) {
                case 60: goto L_0x0751;
                case 61: goto L_0x074f;
                case 62: goto L_0x074c;
                default: goto L_0x0749;
            }
        L_0x0749:
            r2 = -1
            r6 = -1
            goto L_0x076a
        L_0x074c:
            r6 = 8192(0x2000, float:1.14794E-41)
            goto L_0x0769
        L_0x074f:
            r6 = r13
            goto L_0x0769
        L_0x0751:
            r2 = -1
            r6 = 2048(0x800, float:2.87E-42)
            goto L_0x076a
        L_0x0755:
            r6 = r7
            goto L_0x0769
        L_0x0757:
            r6 = r15
            goto L_0x0769
        L_0x0759:
            r6 = r9
            goto L_0x0769
        L_0x075b:
            r6 = r16
            goto L_0x0769
        L_0x075e:
            r6 = r14
            goto L_0x0769
        L_0x0760:
            r2 = -1
            r6 = 16
            goto L_0x076a
        L_0x0764:
            r6 = r5
            goto L_0x0769
        L_0x0766:
            r6 = r10
            goto L_0x0769
        L_0x0768:
            r6 = r12
        L_0x0769:
            r2 = -1
        L_0x076a:
            if (r6 != r2) goto L_0x0782
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            java.lang.String r2 = "Unknown VP9 level: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            android.util.Log.w(r4, r0)
            goto L_0x06e9
        L_0x0782:
            android.util.Pair r2 = new android.util.Pair
            java.lang.Integer r0 = java.lang.Integer.valueOf(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
            r2.<init>(r0, r1)
            goto L_0x07ab
        L_0x0790:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r1 = r0.length()
            java.lang.String r2 = "Ignoring malformed VP9 codec string: "
            if (r1 == 0) goto L_0x07a1
            java.lang.String r0 = r2.concat(r0)
            goto L_0x07a6
        L_0x07a1:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
        L_0x07a6:
            android.util.Log.w(r4, r0)
            goto L_0x06e9
        L_0x07ab:
            return r2
        L_0x07ac:
            r15 = r8
            r8 = 1024(0x400, float:1.435E-42)
            r16 = 64
            java.lang.String r0 = r0.zzj
            int r2 = r1.length
            if (r2 >= r12) goto L_0x07d2
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r1 = r0.length()
            java.lang.String r2 = "Ignoring malformed AVC codec string: "
            if (r1 == 0) goto L_0x07c7
            java.lang.String r0 = r2.concat(r0)
            goto L_0x07cc
        L_0x07c7:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
        L_0x07cc:
            android.util.Log.w(r4, r0)
        L_0x07cf:
            r2 = 0
            goto L_0x08df
        L_0x07d2:
            r11 = r1[r6]     // Catch:{ NumberFormatException -> 0x08c4 }
            int r11 = r11.length()     // Catch:{ NumberFormatException -> 0x08c4 }
            r5 = 6
            if (r11 != r5) goto L_0x07f3
            r2 = r1[r6]     // Catch:{ NumberFormatException -> 0x08c4 }
            r5 = 0
            java.lang.String r2 = r2.substring(r5, r12)     // Catch:{ NumberFormatException -> 0x08c4 }
            r5 = 16
            int r2 = java.lang.Integer.parseInt(r2, r5)     // Catch:{ NumberFormatException -> 0x08c4 }
            r1 = r1[r6]     // Catch:{ NumberFormatException -> 0x08c4 }
            java.lang.String r1 = r1.substring(r10)     // Catch:{ NumberFormatException -> 0x08c4 }
            int r0 = java.lang.Integer.parseInt(r1, r5)     // Catch:{ NumberFormatException -> 0x08c4 }
            goto L_0x0804
        L_0x07f3:
            r5 = 16
            r11 = 3
            if (r2 < r11) goto L_0x08a8
            r2 = r1[r6]     // Catch:{ NumberFormatException -> 0x08c4 }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ NumberFormatException -> 0x08c4 }
            r1 = r1[r12]     // Catch:{ NumberFormatException -> 0x08c4 }
            int r0 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x08c4 }
        L_0x0804:
            r1 = 66
            if (r2 == r1) goto L_0x0830
            r1 = 77
            if (r2 == r1) goto L_0x0831
            r1 = 88
            if (r2 == r1) goto L_0x082e
            r1 = 100
            if (r2 == r1) goto L_0x082a
            r1 = 110(0x6e, float:1.54E-43)
            if (r2 == r1) goto L_0x0828
            r1 = 122(0x7a, float:1.71E-43)
            if (r2 == r1) goto L_0x0826
            r1 = 244(0xf4, float:3.42E-43)
            if (r2 == r1) goto L_0x0823
            r1 = -1
            r12 = -1
            goto L_0x0832
        L_0x0823:
            r12 = r16
            goto L_0x0831
        L_0x0826:
            r12 = r14
            goto L_0x0831
        L_0x0828:
            r12 = r5
            goto L_0x0831
        L_0x082a:
            r1 = -1
            r12 = 8
            goto L_0x0832
        L_0x082e:
            r12 = r10
            goto L_0x0831
        L_0x0830:
            r12 = r6
        L_0x0831:
            r1 = -1
        L_0x0832:
            if (r12 != r1) goto L_0x0849
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r14)
            java.lang.String r1 = "Unknown AVC profile: "
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.w(r4, r0)
            goto L_0x07cf
        L_0x0849:
            switch(r0) {
                case 10: goto L_0x0880;
                case 11: goto L_0x087e;
                case 12: goto L_0x087b;
                case 13: goto L_0x0879;
                default: goto L_0x084c;
            }
        L_0x084c:
            switch(r0) {
                case 20: goto L_0x0877;
                case 21: goto L_0x0874;
                case 22: goto L_0x0872;
                default: goto L_0x084f;
            }
        L_0x084f:
            switch(r0) {
                case 30: goto L_0x0870;
                case 31: goto L_0x086e;
                case 32: goto L_0x086c;
                default: goto L_0x0852;
            }
        L_0x0852:
            switch(r0) {
                case 40: goto L_0x0869;
                case 41: goto L_0x0867;
                case 42: goto L_0x0864;
                default: goto L_0x0855;
            }
        L_0x0855:
            switch(r0) {
                case 50: goto L_0x0861;
                case 51: goto L_0x085d;
                case 52: goto L_0x085a;
                default: goto L_0x0858;
            }
        L_0x0858:
            r1 = -1
            goto L_0x0881
        L_0x085a:
            r1 = 65536(0x10000, float:9.18355E-41)
            goto L_0x0881
        L_0x085d:
            r1 = 32768(0x8000, float:4.5918E-41)
            goto L_0x0881
        L_0x0861:
            r1 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0881
        L_0x0864:
            r1 = 8192(0x2000, float:1.14794E-41)
            goto L_0x0881
        L_0x0867:
            r1 = r13
            goto L_0x0881
        L_0x0869:
            r1 = 2048(0x800, float:2.87E-42)
            goto L_0x0881
        L_0x086c:
            r1 = r8
            goto L_0x0881
        L_0x086e:
            r1 = r7
            goto L_0x0881
        L_0x0870:
            r1 = r15
            goto L_0x0881
        L_0x0872:
            r1 = r9
            goto L_0x0881
        L_0x0874:
            r1 = r16
            goto L_0x0881
        L_0x0877:
            r1 = r14
            goto L_0x0881
        L_0x0879:
            r1 = r5
            goto L_0x0881
        L_0x087b:
            r1 = 8
            goto L_0x0881
        L_0x087e:
            r1 = r10
            goto L_0x0881
        L_0x0880:
            r1 = r6
        L_0x0881:
            r2 = -1
            if (r1 != r2) goto L_0x089a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r3)
            java.lang.String r2 = "Unknown AVC level: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            android.util.Log.w(r4, r0)
            goto L_0x07cf
        L_0x089a:
            android.util.Pair r2 = new android.util.Pair
            java.lang.Integer r0 = java.lang.Integer.valueOf(r12)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r2.<init>(r0, r1)
            goto L_0x08df
        L_0x08a8:
            java.lang.String r1 = "Ignoring malformed AVC codec string: "
            java.lang.String r2 = java.lang.String.valueOf(r0)     // Catch:{ NumberFormatException -> 0x08c4 }
            int r3 = r2.length()     // Catch:{ NumberFormatException -> 0x08c4 }
            if (r3 == 0) goto L_0x08b9
            java.lang.String r1 = r1.concat(r2)     // Catch:{ NumberFormatException -> 0x08c4 }
            goto L_0x08bf
        L_0x08b9:
            java.lang.String r2 = new java.lang.String     // Catch:{ NumberFormatException -> 0x08c4 }
            r2.<init>(r1)     // Catch:{ NumberFormatException -> 0x08c4 }
            r1 = r2
        L_0x08bf:
            android.util.Log.w(r4, r1)     // Catch:{ NumberFormatException -> 0x08c4 }
            goto L_0x07cf
        L_0x08c4:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r1 = r0.length()
            java.lang.String r2 = "Ignoring malformed AVC codec string: "
            if (r1 == 0) goto L_0x08d5
            java.lang.String r0 = r2.concat(r0)
            goto L_0x08da
        L_0x08d5:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r2)
        L_0x08da:
            android.util.Log.w(r4, r0)
            goto L_0x07cf
        L_0x08df:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzoy.zzb(com.google.android.gms.internal.ads.zzab):android.util.Pair");
    }

    @Nullable
    public static zzoh zzc(String str, boolean z11, boolean z12) throws zzos {
        List<zzoh> zze = zze(str, false, false);
        if (zze.isEmpty()) {
            return null;
        }
        return zze.get(0);
    }

    @Nullable
    public static zzoh zzd() throws zzos {
        return zzc(MimeTypes.AUDIO_RAW, false, false);
    }

    public static synchronized List<zzoh> zze(String str, boolean z11, boolean z12) throws zzos {
        zzot zzot;
        String str2 = str;
        boolean z13 = z11;
        boolean z14 = z12;
        synchronized (zzoy.class) {
            zzoq zzoq = new zzoq(str2, z13, z14);
            HashMap<zzoq, List<zzoh>> hashMap = zzc;
            List<zzoh> list = hashMap.get(zzoq);
            if (list != null) {
                return list;
            }
            int i11 = zzfn.zza;
            if (i11 >= 21) {
                zzot = new zzow(z13, z14);
            } else {
                zzot = new zzov((zzou) null);
            }
            ArrayList<zzoh> zzg = zzg(zzoq, zzot);
            if (z13 && zzg.isEmpty() && i11 >= 21 && i11 <= 23) {
                zzg = zzg(zzoq, new zzov((zzou) null));
                if (!zzg.isEmpty()) {
                    String str3 = zzg.get(0).zza;
                    StringBuilder sb2 = new StringBuilder(str.length() + 63 + String.valueOf(str3).length());
                    sb2.append("MediaCodecList API didn't list secure decoder for: ");
                    sb2.append(str2);
                    sb2.append(". Assuming: ");
                    sb2.append(str3);
                    Log.w("MediaCodecUtil", sb2.toString());
                }
            }
            if (MimeTypes.AUDIO_RAW.equals(str2)) {
                if (i11 < 26 && zzfn.zzb.equals("R9") && zzg.size() == 1 && zzg.get(0).zza.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                    zzg.add(zzoh.zzc("OMX.google.raw.decoder", MimeTypes.AUDIO_RAW, MimeTypes.AUDIO_RAW, (MediaCodecInfo.CodecCapabilities) null, false, true, false, false, false));
                }
                zzh(zzg, zzon.zza);
            }
            if (i11 < 21 && zzg.size() > 1) {
                String str4 = zzg.get(0).zza;
                if ("OMX.SEC.mp3.dec".equals(str4) || "OMX.SEC.MP3.Decoder".equals(str4) || "OMX.brcm.audio.mp3.decoder".equals(str4)) {
                    zzh(zzg, zzoo.zza);
                }
            }
            if (i11 < 32 && zzg.size() > 1 && "OMX.qti.audio.decoder.flac".equals(zzg.get(0).zza)) {
                zzg.add(zzg.remove(0));
            }
            List<zzoh> unmodifiableList = Collections.unmodifiableList(zzg);
            hashMap.put(zzoq, unmodifiableList);
            return unmodifiableList;
        }
    }

    @CheckResult
    public static List<zzoh> zzf(List<zzoh> list, zzab zzab) {
        ArrayList arrayList = new ArrayList(list);
        zzh(arrayList, new zzom(zzab));
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x019c, code lost:
        if ("SCV31".equals(r5) == false) goto L_0x019e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x01da, code lost:
        if (r8.startsWith("t0") == false) goto L_0x01dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0046, code lost:
        if (r12.endsWith(".secure") == false) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a2, code lost:
        if (r11.startsWith("HM") == false) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0110, code lost:
        if ("SO-02E".equals(r11) == false) goto L_0x0112;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x013c, code lost:
        if ("C1605".equals(r10) == false) goto L_0x013e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x0333 A[SYNTHETIC, Splitter:B:213:0x0333] */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x035f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList<com.google.android.gms.internal.ads.zzoh> zzg(com.google.android.gms.internal.ads.zzoq r23, com.google.android.gms.internal.ads.zzot r24) throws com.google.android.gms.internal.ads.zzos {
        /*
            r1 = r23
            r2 = r24
            java.lang.String r3 = "secure-playback"
            java.lang.String r4 = "tunneled-playback"
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x039c }
            r6.<init>()     // Catch:{ Exception -> 0x039c }
            java.lang.String r15 = r1.zza     // Catch:{ Exception -> 0x039c }
            int r14 = r24.zza()     // Catch:{ Exception -> 0x039c }
            boolean r16 = r24.zze()     // Catch:{ Exception -> 0x039c }
            r17 = 0
            r13 = r17
        L_0x001b:
            if (r13 >= r14) goto L_0x039b
            android.media.MediaCodecInfo r0 = r2.zzb(r13)     // Catch:{ Exception -> 0x039c }
            int r7 = com.google.android.gms.internal.ads.zzfn.zza     // Catch:{ Exception -> 0x039c }
            r8 = 29
            if (r7 < r8) goto L_0x0034
            boolean r9 = r0.isAlias()     // Catch:{ Exception -> 0x039c }
            if (r9 == 0) goto L_0x0034
        L_0x002d:
            r21 = r13
            r22 = r14
            r2 = r15
            goto L_0x0392
        L_0x0034:
            java.lang.String r12 = r0.getName()     // Catch:{ Exception -> 0x039c }
            boolean r9 = r0.isEncoder()     // Catch:{ Exception -> 0x039c }
            if (r9 != 0) goto L_0x002d
            java.lang.String r9 = ".secure"
            if (r16 != 0) goto L_0x0048
            boolean r10 = r12.endsWith(r9)     // Catch:{ Exception -> 0x039c }
            if (r10 != 0) goto L_0x002d
        L_0x0048:
            r10 = 21
            if (r7 >= r10) goto L_0x007c
            java.lang.String r10 = "CIPAACDecoder"
            boolean r10 = r10.equals(r12)     // Catch:{ Exception -> 0x039c }
            if (r10 != 0) goto L_0x002d
            java.lang.String r10 = "CIPMP3Decoder"
            boolean r10 = r10.equals(r12)     // Catch:{ Exception -> 0x039c }
            if (r10 != 0) goto L_0x002d
            java.lang.String r10 = "CIPVorbisDecoder"
            boolean r10 = r10.equals(r12)     // Catch:{ Exception -> 0x039c }
            if (r10 != 0) goto L_0x002d
            java.lang.String r10 = "CIPAMRNBDecoder"
            boolean r10 = r10.equals(r12)     // Catch:{ Exception -> 0x039c }
            if (r10 != 0) goto L_0x002d
            java.lang.String r10 = "AACDecoder"
            boolean r10 = r10.equals(r12)     // Catch:{ Exception -> 0x039c }
            if (r10 != 0) goto L_0x002d
            java.lang.String r10 = "MP3Decoder"
            boolean r10 = r10.equals(r12)     // Catch:{ Exception -> 0x039c }
            if (r10 != 0) goto L_0x002d
        L_0x007c:
            r10 = 18
            if (r7 >= r10) goto L_0x00a4
            java.lang.String r10 = "OMX.MTK.AUDIO.DECODER.AAC"
            boolean r10 = r10.equals(r12)     // Catch:{ Exception -> 0x039c }
            if (r10 == 0) goto L_0x00a4
            java.lang.String r10 = "a70"
            java.lang.String r11 = com.google.android.gms.internal.ads.zzfn.zzb     // Catch:{ Exception -> 0x039c }
            boolean r10 = r10.equals(r11)     // Catch:{ Exception -> 0x039c }
            if (r10 != 0) goto L_0x002d
            java.lang.String r10 = "Xiaomi"
            java.lang.String r5 = com.google.android.gms.internal.ads.zzfn.zzc     // Catch:{ Exception -> 0x039c }
            boolean r5 = r10.equals(r5)     // Catch:{ Exception -> 0x039c }
            if (r5 == 0) goto L_0x00a4
            java.lang.String r5 = "HM"
            boolean r5 = r11.startsWith(r5)     // Catch:{ Exception -> 0x039c }
            if (r5 != 0) goto L_0x002d
        L_0x00a4:
            r5 = 16
            if (r7 != r5) goto L_0x0112
            java.lang.String r10 = "OMX.qcom.audio.decoder.mp3"
            boolean r10 = r10.equals(r12)     // Catch:{ Exception -> 0x039c }
            if (r10 == 0) goto L_0x0112
            java.lang.String r10 = "dlxu"
            java.lang.String r11 = com.google.android.gms.internal.ads.zzfn.zzb     // Catch:{ Exception -> 0x039c }
            boolean r10 = r10.equals(r11)     // Catch:{ Exception -> 0x039c }
            if (r10 != 0) goto L_0x002d
            java.lang.String r10 = "protou"
            boolean r10 = r10.equals(r11)     // Catch:{ Exception -> 0x039c }
            if (r10 != 0) goto L_0x002d
            java.lang.String r10 = "ville"
            boolean r10 = r10.equals(r11)     // Catch:{ Exception -> 0x039c }
            if (r10 != 0) goto L_0x002d
            java.lang.String r10 = "villeplus"
            boolean r10 = r10.equals(r11)     // Catch:{ Exception -> 0x039c }
            if (r10 != 0) goto L_0x002d
            java.lang.String r10 = "villec2"
            boolean r10 = r10.equals(r11)     // Catch:{ Exception -> 0x039c }
            if (r10 != 0) goto L_0x002d
            java.lang.String r10 = "gee"
            boolean r10 = r11.startsWith(r10)     // Catch:{ Exception -> 0x039c }
            if (r10 != 0) goto L_0x002d
            java.lang.String r10 = "C6602"
            boolean r10 = r10.equals(r11)     // Catch:{ Exception -> 0x039c }
            if (r10 != 0) goto L_0x002d
            java.lang.String r10 = "C6603"
            boolean r10 = r10.equals(r11)     // Catch:{ Exception -> 0x039c }
            if (r10 != 0) goto L_0x002d
            java.lang.String r10 = "C6606"
            boolean r10 = r10.equals(r11)     // Catch:{ Exception -> 0x039c }
            if (r10 != 0) goto L_0x002d
            java.lang.String r10 = "C6616"
            boolean r10 = r10.equals(r11)     // Catch:{ Exception -> 0x039c }
            if (r10 != 0) goto L_0x002d
            java.lang.String r10 = "L36h"
            boolean r10 = r10.equals(r11)     // Catch:{ Exception -> 0x039c }
            if (r10 != 0) goto L_0x002d
            java.lang.String r10 = "SO-02E"
            boolean r10 = r10.equals(r11)     // Catch:{ Exception -> 0x039c }
            if (r10 != 0) goto L_0x002d
        L_0x0112:
            if (r7 != r5) goto L_0x013e
            java.lang.String r5 = "OMX.qcom.audio.decoder.aac"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x039c }
            if (r5 == 0) goto L_0x013e
            java.lang.String r5 = "C1504"
            java.lang.String r10 = com.google.android.gms.internal.ads.zzfn.zzb     // Catch:{ Exception -> 0x039c }
            boolean r5 = r5.equals(r10)     // Catch:{ Exception -> 0x039c }
            if (r5 != 0) goto L_0x002d
            java.lang.String r5 = "C1505"
            boolean r5 = r5.equals(r10)     // Catch:{ Exception -> 0x039c }
            if (r5 != 0) goto L_0x002d
            java.lang.String r5 = "C1604"
            boolean r5 = r5.equals(r10)     // Catch:{ Exception -> 0x039c }
            if (r5 != 0) goto L_0x002d
            java.lang.String r5 = "C1605"
            boolean r5 = r5.equals(r10)     // Catch:{ Exception -> 0x039c }
            if (r5 != 0) goto L_0x002d
        L_0x013e:
            r5 = 24
            java.lang.String r10 = "samsung"
            if (r7 >= r5) goto L_0x019e
            java.lang.String r5 = "OMX.SEC.aac.dec"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x039c }
            if (r5 != 0) goto L_0x0154
            java.lang.String r5 = "OMX.Exynos.AAC.Decoder"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x039c }
            if (r5 == 0) goto L_0x019e
        L_0x0154:
            java.lang.String r5 = com.google.android.gms.internal.ads.zzfn.zzc     // Catch:{ Exception -> 0x039c }
            boolean r5 = r10.equals(r5)     // Catch:{ Exception -> 0x039c }
            if (r5 == 0) goto L_0x019e
            java.lang.String r5 = com.google.android.gms.internal.ads.zzfn.zzb     // Catch:{ Exception -> 0x039c }
            java.lang.String r11 = "zeroflte"
            boolean r11 = r5.startsWith(r11)     // Catch:{ Exception -> 0x039c }
            if (r11 != 0) goto L_0x002d
            java.lang.String r11 = "zerolte"
            boolean r11 = r5.startsWith(r11)     // Catch:{ Exception -> 0x039c }
            if (r11 != 0) goto L_0x002d
            java.lang.String r11 = "zenlte"
            boolean r11 = r5.startsWith(r11)     // Catch:{ Exception -> 0x039c }
            if (r11 != 0) goto L_0x002d
            java.lang.String r11 = "SC-05G"
            boolean r11 = r11.equals(r5)     // Catch:{ Exception -> 0x039c }
            if (r11 != 0) goto L_0x002d
            java.lang.String r11 = "marinelteatt"
            boolean r11 = r11.equals(r5)     // Catch:{ Exception -> 0x039c }
            if (r11 != 0) goto L_0x002d
            java.lang.String r11 = "404SC"
            boolean r11 = r11.equals(r5)     // Catch:{ Exception -> 0x039c }
            if (r11 != 0) goto L_0x002d
            java.lang.String r11 = "SC-04G"
            boolean r11 = r11.equals(r5)     // Catch:{ Exception -> 0x039c }
            if (r11 != 0) goto L_0x002d
            java.lang.String r11 = "SCV31"
            boolean r5 = r11.equals(r5)     // Catch:{ Exception -> 0x039c }
            if (r5 != 0) goto L_0x002d
        L_0x019e:
            java.lang.String r5 = "jflte"
            r11 = 19
            if (r7 > r11) goto L_0x01dc
            java.lang.String r8 = "OMX.SEC.vp8.dec"
            boolean r8 = r8.equals(r12)     // Catch:{ Exception -> 0x039c }
            if (r8 == 0) goto L_0x01dc
            java.lang.String r8 = com.google.android.gms.internal.ads.zzfn.zzc     // Catch:{ Exception -> 0x039c }
            boolean r8 = r10.equals(r8)     // Catch:{ Exception -> 0x039c }
            if (r8 == 0) goto L_0x01dc
            java.lang.String r8 = com.google.android.gms.internal.ads.zzfn.zzb     // Catch:{ Exception -> 0x039c }
            java.lang.String r10 = "d2"
            boolean r10 = r8.startsWith(r10)     // Catch:{ Exception -> 0x039c }
            if (r10 != 0) goto L_0x002d
            java.lang.String r10 = "serrano"
            boolean r10 = r8.startsWith(r10)     // Catch:{ Exception -> 0x039c }
            if (r10 != 0) goto L_0x002d
            boolean r10 = r8.startsWith(r5)     // Catch:{ Exception -> 0x039c }
            if (r10 != 0) goto L_0x002d
            java.lang.String r10 = "santos"
            boolean r10 = r8.startsWith(r10)     // Catch:{ Exception -> 0x039c }
            if (r10 != 0) goto L_0x002d
            java.lang.String r10 = "t0"
            boolean r8 = r8.startsWith(r10)     // Catch:{ Exception -> 0x039c }
            if (r8 != 0) goto L_0x002d
        L_0x01dc:
            if (r7 > r11) goto L_0x01ee
            java.lang.String r7 = com.google.android.gms.internal.ads.zzfn.zzb     // Catch:{ Exception -> 0x039c }
            boolean r5 = r7.startsWith(r5)     // Catch:{ Exception -> 0x039c }
            if (r5 == 0) goto L_0x01ee
            java.lang.String r5 = "OMX.qcom.video.decoder.vp8"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x039c }
            if (r5 != 0) goto L_0x002d
        L_0x01ee:
            java.lang.String r5 = "audio/eac3-joc"
            boolean r5 = r5.equals(r15)     // Catch:{ Exception -> 0x039c }
            if (r5 == 0) goto L_0x01fe
            java.lang.String r5 = "OMX.MTK.AUDIO.DECODER.DSPAC3"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x039c }
            if (r5 != 0) goto L_0x002d
        L_0x01fe:
            java.lang.String[] r5 = r0.getSupportedTypes()     // Catch:{ Exception -> 0x039c }
            int r7 = r5.length     // Catch:{ Exception -> 0x039c }
            r8 = r17
        L_0x0205:
            if (r8 >= r7) goto L_0x0214
            r10 = r5[r8]     // Catch:{ Exception -> 0x039c }
            boolean r11 = r10.equalsIgnoreCase(r15)     // Catch:{ Exception -> 0x039c }
            if (r11 == 0) goto L_0x0211
        L_0x020f:
            r5 = r10
            goto L_0x0261
        L_0x0211:
            int r8 = r8 + 1
            goto L_0x0205
        L_0x0214:
            java.lang.String r5 = "video/dolby-vision"
            boolean r5 = r15.equals(r5)     // Catch:{ Exception -> 0x039c }
            if (r5 == 0) goto L_0x023a
            java.lang.String r5 = "OMX.MS.HEVCDV.Decoder"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x039c }
            if (r5 == 0) goto L_0x0227
            java.lang.String r10 = "video/hevcdv"
            goto L_0x020f
        L_0x0227:
            java.lang.String r5 = "OMX.RTK.video.decoder"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x039c }
            if (r5 != 0) goto L_0x0237
            java.lang.String r5 = "OMX.realtek.video.decoder.tunneled"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x039c }
            if (r5 == 0) goto L_0x0260
        L_0x0237:
            java.lang.String r10 = "video/dv_hevc"
            goto L_0x020f
        L_0x023a:
            java.lang.String r5 = "audio/alac"
            boolean r5 = r15.equals(r5)     // Catch:{ Exception -> 0x039c }
            if (r5 == 0) goto L_0x024d
            java.lang.String r5 = "OMX.lge.alac.decoder"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x039c }
            if (r5 == 0) goto L_0x024d
            java.lang.String r10 = "audio/x-lg-alac"
            goto L_0x020f
        L_0x024d:
            java.lang.String r5 = "audio/flac"
            boolean r5 = r15.equals(r5)     // Catch:{ Exception -> 0x039c }
            if (r5 == 0) goto L_0x0260
            java.lang.String r5 = "OMX.lge.flac.decoder"
            boolean r5 = r5.equals(r12)     // Catch:{ Exception -> 0x039c }
            if (r5 == 0) goto L_0x0260
            java.lang.String r10 = "audio/x-lg-flac"
            goto L_0x020f
        L_0x0260:
            r5 = 0
        L_0x0261:
            if (r5 == 0) goto L_0x002d
            android.media.MediaCodecInfo$CodecCapabilities r10 = r0.getCapabilitiesForType(r5)     // Catch:{ Exception -> 0x0323 }
            boolean r7 = r2.zzd(r4, r5, r10)     // Catch:{ Exception -> 0x0323 }
            boolean r8 = r2.zzc(r4, r5, r10)     // Catch:{ Exception -> 0x0323 }
            boolean r11 = r1.zzc     // Catch:{ Exception -> 0x0323 }
            if (r11 != 0) goto L_0x0276
            if (r8 != 0) goto L_0x002d
            goto L_0x027a
        L_0x0276:
            if (r7 != 0) goto L_0x027a
            goto L_0x002d
        L_0x027a:
            boolean r7 = r2.zzd(r3, r5, r10)     // Catch:{ Exception -> 0x0323 }
            boolean r8 = r2.zzc(r3, r5, r10)     // Catch:{ Exception -> 0x0323 }
            boolean r11 = r1.zzb     // Catch:{ Exception -> 0x0323 }
            r19 = 1
            if (r11 != 0) goto L_0x028b
            if (r8 != 0) goto L_0x002d
            goto L_0x028f
        L_0x028b:
            if (r7 == 0) goto L_0x002d
            r7 = r19
        L_0x028f:
            int r8 = com.google.android.gms.internal.ads.zzfn.zza     // Catch:{ Exception -> 0x0323 }
            r11 = 29
            if (r8 < r11) goto L_0x029a
            boolean r11 = r0.isHardwareAccelerated()     // Catch:{ Exception -> 0x0323 }
            goto L_0x02a5
        L_0x029a:
            boolean r11 = zzi(r0)     // Catch:{ Exception -> 0x0323 }
            if (r11 != 0) goto L_0x02a3
            r11 = r19
            goto L_0x02a5
        L_0x02a3:
            r11 = r17
        L_0x02a5:
            boolean r20 = zzi(r0)     // Catch:{ Exception -> 0x0323 }
            r2 = 29
            if (r8 < r2) goto L_0x02b2
            boolean r0 = r0.isVendor()     // Catch:{ Exception -> 0x0323 }
            goto L_0x02d7
        L_0x02b2:
            java.lang.String r0 = r0.getName()     // Catch:{ Exception -> 0x0323 }
            java.lang.String r0 = com.google.android.gms.internal.ads.zzfpn.zza(r0)     // Catch:{ Exception -> 0x0323 }
            java.lang.String r2 = "omx.google."
            boolean r2 = r0.startsWith(r2)     // Catch:{ Exception -> 0x0323 }
            if (r2 != 0) goto L_0x02d5
            java.lang.String r2 = "c2.android."
            boolean r2 = r0.startsWith(r2)     // Catch:{ Exception -> 0x0323 }
            if (r2 != 0) goto L_0x02d5
            java.lang.String r2 = "c2.google."
            boolean r0 = r0.startsWith(r2)     // Catch:{ Exception -> 0x0323 }
            if (r0 != 0) goto L_0x02d5
            r0 = r19
            goto L_0x02d7
        L_0x02d5:
            r0 = r17
        L_0x02d7:
            if (r16 == 0) goto L_0x02dd
            boolean r2 = r1.zzb     // Catch:{ Exception -> 0x0323 }
            if (r2 == r7) goto L_0x02e3
        L_0x02dd:
            if (r16 != 0) goto L_0x0301
            boolean r2 = r1.zzb     // Catch:{ Exception -> 0x0323 }
            if (r2 != 0) goto L_0x0301
        L_0x02e3:
            r2 = 0
            r18 = 0
            r7 = r12
            r8 = r15
            r9 = r5
            r19 = r12
            r12 = r20
            r21 = r13
            r13 = r0
            r22 = r14
            r14 = r2
            r2 = r15
            r15 = r18
            com.google.android.gms.internal.ads.zzoh r0 = com.google.android.gms.internal.ads.zzoh.zzc(r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x02ff }
            r6.add(r0)     // Catch:{ Exception -> 0x02ff }
            goto L_0x0392
        L_0x02ff:
            r0 = move-exception
            goto L_0x032b
        L_0x0301:
            r19 = r12
            r21 = r13
            r22 = r14
            r2 = r15
            if (r16 != 0) goto L_0x0392
            if (r7 == 0) goto L_0x0392
            java.lang.String r7 = java.lang.String.valueOf(r19)     // Catch:{ Exception -> 0x02ff }
            java.lang.String r7 = r7.concat(r9)     // Catch:{ Exception -> 0x02ff }
            r14 = 0
            r15 = 1
            r8 = r2
            r9 = r5
            r12 = r20
            r13 = r0
            com.google.android.gms.internal.ads.zzoh r0 = com.google.android.gms.internal.ads.zzoh.zzc(r7, r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x02ff }
            r6.add(r0)     // Catch:{ Exception -> 0x02ff }
            return r6
        L_0x0323:
            r0 = move-exception
            r19 = r12
            r21 = r13
            r22 = r14
            r2 = r15
        L_0x032b:
            int r7 = com.google.android.gms.internal.ads.zzfn.zza     // Catch:{ Exception -> 0x039c }
            r8 = 23
            java.lang.String r9 = "MediaCodecUtil"
            if (r7 > r8) goto L_0x035f
            boolean r7 = r6.isEmpty()     // Catch:{ Exception -> 0x039c }
            if (r7 != 0) goto L_0x035f
            java.lang.String r0 = java.lang.String.valueOf(r19)     // Catch:{ Exception -> 0x039c }
            int r0 = r0.length()     // Catch:{ Exception -> 0x039c }
            int r0 = r0 + 46
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x039c }
            r5.<init>(r0)     // Catch:{ Exception -> 0x039c }
            java.lang.String r0 = "Skipping codec "
            r5.append(r0)     // Catch:{ Exception -> 0x039c }
            r7 = r19
            r5.append(r7)     // Catch:{ Exception -> 0x039c }
            java.lang.String r0 = " (failed to query capabilities)"
            r5.append(r0)     // Catch:{ Exception -> 0x039c }
            java.lang.String r0 = r5.toString()     // Catch:{ Exception -> 0x039c }
            android.util.Log.e(r9, r0)     // Catch:{ Exception -> 0x039c }
            goto L_0x0392
        L_0x035f:
            r7 = r19
            java.lang.String r1 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x039c }
            int r1 = r1.length()     // Catch:{ Exception -> 0x039c }
            int r1 = r1 + 25
            int r2 = r5.length()     // Catch:{ Exception -> 0x039c }
            int r1 = r1 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x039c }
            r2.<init>(r1)     // Catch:{ Exception -> 0x039c }
            java.lang.String r1 = "Failed to query codec "
            r2.append(r1)     // Catch:{ Exception -> 0x039c }
            r2.append(r7)     // Catch:{ Exception -> 0x039c }
            java.lang.String r1 = " ("
            r2.append(r1)     // Catch:{ Exception -> 0x039c }
            r2.append(r5)     // Catch:{ Exception -> 0x039c }
            java.lang.String r1 = ")"
            r2.append(r1)     // Catch:{ Exception -> 0x039c }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x039c }
            android.util.Log.e(r9, r1)     // Catch:{ Exception -> 0x039c }
            throw r0     // Catch:{ Exception -> 0x039c }
        L_0x0392:
            int r13 = r21 + 1
            r15 = r2
            r14 = r22
            r2 = r24
            goto L_0x001b
        L_0x039b:
            return r6
        L_0x039c:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzos r1 = new com.google.android.gms.internal.ads.zzos
            r2 = 0
            r1.<init>(r0, r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzoy.zzg(com.google.android.gms.internal.ads.zzoq, com.google.android.gms.internal.ads.zzot):java.util.ArrayList");
    }

    private static <T> void zzh(List<T> list, zzox<T> zzox) {
        Collections.sort(list, new zzop(zzox));
    }

    private static boolean zzi(MediaCodecInfo mediaCodecInfo) {
        if (zzfn.zza >= 29) {
            return mediaCodecInfo.isSoftwareOnly();
        }
        String zza2 = zzfpn.zza(mediaCodecInfo.getName());
        if (zza2.startsWith("arc.")) {
            return false;
        }
        if (zza2.startsWith("omx.google.") || zza2.startsWith("omx.ffmpeg.") || ((zza2.startsWith("omx.sec.") && zza2.contains(".sw.")) || zza2.equals("omx.qcom.video.decoder.hevcswvdec") || zza2.startsWith("c2.android.") || zza2.startsWith("c2.google.") || (!zza2.startsWith("omx.") && !zza2.startsWith("c2.")))) {
            return true;
        }
        return false;
    }
}

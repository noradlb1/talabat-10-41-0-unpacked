package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.MimeTypes;
import io.flutter.plugin.platform.PlatformPlugin;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

public final class zzuv extends zzoj {
    private static final int[] zzb = {1920, 1600, 1440, PlatformPlugin.DEFAULT_SYSTEM_UI, 960, 854, 640, 540, 480};
    private static boolean zzc;
    private static boolean zzd;
    private long zzA;
    private int zzB;
    private int zzC = -1;
    private int zzD = -1;
    private int zzE;
    private float zzF = -1.0f;
    @Nullable
    private zzct zzG = null;
    private int zzH = 0;
    @Nullable
    private zzuw zzI;
    private final Context zze;
    private final zzvd zzf;
    private final zzvo zzg;
    private final boolean zzh = "NVIDIA".equals(zzfn.zzc);
    private zzuu zzi;
    private boolean zzj;
    private boolean zzk;
    @Nullable
    private Surface zzl;
    @Nullable
    private zzuq zzm;
    private boolean zzn;
    private int zzo = 1;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private long zzs;
    private long zzt = C.TIME_UNSET;
    private long zzu;
    private int zzv;
    private int zzw;
    private int zzx;
    private long zzy;
    private long zzz;

    public zzuv(Context context, zzoe zzoe, zzol zzol, long j11, boolean z11, @Nullable Handler handler, @Nullable zzvp zzvp, int i11) {
        super(2, zzoe, zzol, false, 30.0f);
        Context applicationContext = context.getApplicationContext();
        this.zze = applicationContext;
        this.zzf = new zzvd(applicationContext);
        this.zzg = new zzvo(handler, zzvp);
    }

    public static int zzS(zzoh zzoh, zzab zzab) {
        if (zzab.zzn == -1) {
            return zzaA(zzoh, zzab);
        }
        int size = zzab.zzo.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            i11 += zzab.zzo.get(i12).length;
        }
        return zzab.zzn + i11;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0021, code lost:
        r12 = ((java.lang.Integer) r12.first).intValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzaA(com.google.android.gms.internal.ads.zzoh r11, com.google.android.gms.internal.ads.zzab r12) {
        /*
            int r0 = r12.zzr
            int r1 = r12.zzs
            r2 = -1
            if (r0 == r2) goto L_0x00c4
            if (r1 != r2) goto L_0x000b
            goto L_0x00c4
        L_0x000b:
            java.lang.String r3 = r12.zzm
            java.lang.String r4 = "video/dolby-vision"
            boolean r4 = r4.equals(r3)
            java.lang.String r5 = "video/avc"
            java.lang.String r6 = "video/hevc"
            r7 = 1
            r8 = 2
            if (r4 == 0) goto L_0x0034
            android.util.Pair r12 = com.google.android.gms.internal.ads.zzoy.zzb(r12)
            if (r12 == 0) goto L_0x0033
            java.lang.Object r12 = r12.first
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
            r3 = 512(0x200, float:7.175E-43)
            if (r12 == r3) goto L_0x0031
            if (r12 == r7) goto L_0x0031
            if (r12 != r8) goto L_0x0033
        L_0x0031:
            r3 = r5
            goto L_0x0034
        L_0x0033:
            r3 = r6
        L_0x0034:
            int r12 = r3.hashCode()
            r4 = 5
            r9 = 4
            r10 = 3
            switch(r12) {
                case -1664118616: goto L_0x006d;
                case -1662541442: goto L_0x0065;
                case 1187890754: goto L_0x005b;
                case 1331836730: goto L_0x0053;
                case 1599127256: goto L_0x0049;
                case 1599127257: goto L_0x003f;
                default: goto L_0x003e;
            }
        L_0x003e:
            goto L_0x0077
        L_0x003f:
            java.lang.String r12 = "video/x-vnd.on2.vp9"
            boolean r12 = r3.equals(r12)
            if (r12 == 0) goto L_0x0077
            r12 = r4
            goto L_0x0078
        L_0x0049:
            java.lang.String r12 = "video/x-vnd.on2.vp8"
            boolean r12 = r3.equals(r12)
            if (r12 == 0) goto L_0x0077
            r12 = r10
            goto L_0x0078
        L_0x0053:
            boolean r12 = r3.equals(r5)
            if (r12 == 0) goto L_0x0077
            r12 = r8
            goto L_0x0078
        L_0x005b:
            java.lang.String r12 = "video/mp4v-es"
            boolean r12 = r3.equals(r12)
            if (r12 == 0) goto L_0x0077
            r12 = r7
            goto L_0x0078
        L_0x0065:
            boolean r12 = r3.equals(r6)
            if (r12 == 0) goto L_0x0077
            r12 = r9
            goto L_0x0078
        L_0x006d:
            java.lang.String r12 = "video/3gpp"
            boolean r12 = r3.equals(r12)
            if (r12 == 0) goto L_0x0077
            r12 = 0
            goto L_0x0078
        L_0x0077:
            r12 = r2
        L_0x0078:
            if (r12 == 0) goto L_0x00bf
            if (r12 == r7) goto L_0x00bf
            if (r12 == r8) goto L_0x0088
            if (r12 == r10) goto L_0x00bf
            if (r12 == r9) goto L_0x0085
            if (r12 == r4) goto L_0x0085
            return r2
        L_0x0085:
            int r0 = r0 * r1
            r8 = r9
            goto L_0x00c0
        L_0x0088:
            java.lang.String r12 = com.google.android.gms.internal.ads.zzfn.zzd
            java.lang.String r3 = "BRAVIA 4K 2015"
            boolean r3 = r3.equals(r12)
            if (r3 != 0) goto L_0x00be
            java.lang.String r3 = "Amazon"
            java.lang.String r4 = com.google.android.gms.internal.ads.zzfn.zzc
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x00b0
            java.lang.String r3 = "KFSOWI"
            boolean r3 = r3.equals(r12)
            if (r3 != 0) goto L_0x00be
            java.lang.String r3 = "AFTS"
            boolean r12 = r3.equals(r12)
            if (r12 == 0) goto L_0x00b0
            boolean r11 = r11.zzf
            if (r11 != 0) goto L_0x00be
        L_0x00b0:
            r11 = 16
            int r12 = com.google.android.gms.internal.ads.zzfn.zze(r0, r11)
            int r11 = com.google.android.gms.internal.ads.zzfn.zze(r1, r11)
            int r12 = r12 * r11
            int r0 = r12 * 256
            goto L_0x00c0
        L_0x00be:
            return r2
        L_0x00bf:
            int r0 = r0 * r1
        L_0x00c0:
            int r0 = r0 * r10
            int r8 = r8 + r8
            int r0 = r0 / r8
            return r0
        L_0x00c4:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzuv.zzaA(com.google.android.gms.internal.ads.zzoh, com.google.android.gms.internal.ads.zzab):int");
    }

    private static List<zzoh> zzaB(zzol zzol, zzab zzab, boolean z11, boolean z12) throws zzos {
        Pair<Integer, Integer> zzb2;
        String str = zzab.zzm;
        if (str == null) {
            return Collections.emptyList();
        }
        List<zzoh> zzf2 = zzoy.zzf(zzoy.zze(str, z11, z12), zzab);
        if (MimeTypes.VIDEO_DOLBY_VISION.equals(str) && (zzb2 = zzoy.zzb(zzab)) != null) {
            int intValue = ((Integer) zzb2.first).intValue();
            if (intValue == 16 || intValue == 256) {
                zzf2.addAll(zzoy.zze(MimeTypes.VIDEO_H265, z11, z12));
            } else if (intValue == 512) {
                zzf2.addAll(zzoy.zze(MimeTypes.VIDEO_H264, z11, z12));
            }
        }
        return Collections.unmodifiableList(zzf2);
    }

    private final void zzaC() {
        int i11 = this.zzC;
        if (i11 == -1) {
            if (this.zzD != -1) {
                i11 = -1;
            } else {
                return;
            }
        }
        zzct zzct = this.zzG;
        if (zzct == null || zzct.zzc != i11 || zzct.zzd != this.zzD || zzct.zze != this.zzE || zzct.zzf != this.zzF) {
            zzct zzct2 = new zzct(i11, this.zzD, this.zzE, this.zzF);
            this.zzG = zzct2;
            this.zzg.zzt(zzct2);
        }
    }

    private final void zzaD() {
        zzct zzct = this.zzG;
        if (zzct != null) {
            this.zzg.zzt(zzct);
        }
    }

    private final void zzaE() {
        Surface surface = this.zzl;
        zzuq zzuq = this.zzm;
        if (surface == zzuq) {
            this.zzl = null;
        }
        zzuq.release();
        this.zzm = null;
    }

    private static boolean zzaF(long j11) {
        return j11 < -30000;
    }

    private final boolean zzaG(zzoh zzoh) {
        if (zzfn.zza < 23 || zzaz(zzoh.zza)) {
            return false;
        }
        if (!zzoh.zzf) {
            return true;
        }
        if (!zzuq.zzb(this.zze)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x0351, code lost:
        if (r1.equals("602LV") != false) goto L_0x0710;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:487:0x074a, code lost:
        if (r7 != 2) goto L_0x074c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean zzaz(java.lang.String r13) {
        /*
            java.lang.String r0 = "OMX.google"
            boolean r13 = r13.startsWith(r0)
            r0 = 0
            if (r13 == 0) goto L_0x000a
            return r0
        L_0x000a:
            java.lang.Class<com.google.android.gms.internal.ads.zzuv> r13 = com.google.android.gms.internal.ads.zzuv.class
            monitor-enter(r13)
            boolean r1 = zzc     // Catch:{ all -> 0x0754 }
            if (r1 != 0) goto L_0x0750
            int r1 = com.google.android.gms.internal.ads.zzfn.zza     // Catch:{ all -> 0x0754 }
            r2 = 4
            r3 = 5
            r4 = 3
            r5 = 6
            r6 = 28
            r7 = -1
            r8 = 2
            r9 = 1
            if (r1 > r6) goto L_0x0076
            java.lang.String r10 = com.google.android.gms.internal.ads.zzfn.zzb     // Catch:{ all -> 0x0754 }
            int r11 = r10.hashCode()     // Catch:{ all -> 0x0754 }
            switch(r11) {
                case -1339091551: goto L_0x0064;
                case -1220081023: goto L_0x005a;
                case -1220066608: goto L_0x0050;
                case -1012436106: goto L_0x0046;
                case -64886864: goto L_0x003c;
                case 3415681: goto L_0x0032;
                case 825323514: goto L_0x0028;
                default: goto L_0x0027;
            }
        L_0x0027:
            goto L_0x006e
        L_0x0028:
            java.lang.String r11 = "machuca"
            boolean r10 = r10.equals(r11)
            if (r10 == 0) goto L_0x006e
            r10 = r2
            goto L_0x006f
        L_0x0032:
            java.lang.String r11 = "once"
            boolean r10 = r10.equals(r11)
            if (r10 == 0) goto L_0x006e
            r10 = r3
            goto L_0x006f
        L_0x003c:
            java.lang.String r11 = "magnolia"
            boolean r10 = r10.equals(r11)
            if (r10 == 0) goto L_0x006e
            r10 = r4
            goto L_0x006f
        L_0x0046:
            java.lang.String r11 = "oneday"
            boolean r10 = r10.equals(r11)
            if (r10 == 0) goto L_0x006e
            r10 = r5
            goto L_0x006f
        L_0x0050:
            java.lang.String r11 = "dangalUHD"
            boolean r10 = r10.equals(r11)
            if (r10 == 0) goto L_0x006e
            r10 = r9
            goto L_0x006f
        L_0x005a:
            java.lang.String r11 = "dangalFHD"
            boolean r10 = r10.equals(r11)
            if (r10 == 0) goto L_0x006e
            r10 = r8
            goto L_0x006f
        L_0x0064:
            java.lang.String r11 = "dangal"
            boolean r10 = r10.equals(r11)
            if (r10 == 0) goto L_0x006e
            r10 = r0
            goto L_0x006f
        L_0x006e:
            r10 = r7
        L_0x006f:
            switch(r10) {
                case 0: goto L_0x0073;
                case 1: goto L_0x0073;
                case 2: goto L_0x0073;
                case 3: goto L_0x0073;
                case 4: goto L_0x0073;
                case 5: goto L_0x0073;
                case 6: goto L_0x0073;
                default: goto L_0x0072;
            }
        L_0x0072:
            goto L_0x0076
        L_0x0073:
            r0 = r9
            goto L_0x074c
        L_0x0076:
            r10 = 27
            if (r1 > r10) goto L_0x0085
            java.lang.String r11 = "HWEML"
            java.lang.String r12 = com.google.android.gms.internal.ads.zzfn.zzb     // Catch:{ all -> 0x0754 }
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0754 }
            if (r11 == 0) goto L_0x0085
            goto L_0x0073
        L_0x0085:
            r11 = 26
            if (r1 > r11) goto L_0x074c
            java.lang.String r1 = com.google.android.gms.internal.ads.zzfn.zzb     // Catch:{ all -> 0x0754 }
            int r12 = r1.hashCode()     // Catch:{ all -> 0x0754 }
            switch(r12) {
                case -2144781245: goto L_0x0704;
                case -2144781185: goto L_0x06f9;
                case -2144781160: goto L_0x06ee;
                case -2097309513: goto L_0x06e3;
                case -2022874474: goto L_0x06d8;
                case -1978993182: goto L_0x06cd;
                case -1978990237: goto L_0x06c2;
                case -1936688988: goto L_0x06b7;
                case -1936688066: goto L_0x06ac;
                case -1936688065: goto L_0x06a0;
                case -1931988508: goto L_0x0694;
                case -1885099851: goto L_0x0688;
                case -1696512866: goto L_0x067c;
                case -1680025915: goto L_0x0670;
                case -1615810839: goto L_0x0664;
                case -1600724499: goto L_0x0658;
                case -1554255044: goto L_0x064c;
                case -1481772737: goto L_0x0640;
                case -1481772730: goto L_0x0634;
                case -1481772729: goto L_0x0628;
                case -1320080169: goto L_0x061c;
                case -1217592143: goto L_0x0610;
                case -1180384755: goto L_0x0604;
                case -1139198265: goto L_0x05f8;
                case -1052835013: goto L_0x05ec;
                case -993250464: goto L_0x05e1;
                case -993250458: goto L_0x05d6;
                case -965403638: goto L_0x05ca;
                case -958336948: goto L_0x05be;
                case -879245230: goto L_0x05b2;
                case -842500323: goto L_0x05a6;
                case -821392978: goto L_0x059a;
                case -797483286: goto L_0x058e;
                case -794946968: goto L_0x0582;
                case -788334647: goto L_0x0576;
                case -782144577: goto L_0x056a;
                case -575125681: goto L_0x055e;
                case -521118391: goto L_0x0552;
                case -430914369: goto L_0x0546;
                case -290434366: goto L_0x053a;
                case -282781963: goto L_0x052e;
                case -277133239: goto L_0x0522;
                case -173639913: goto L_0x0516;
                case -56598463: goto L_0x050a;
                case 2126: goto L_0x04fe;
                case 2564: goto L_0x04f2;
                case 2715: goto L_0x04e6;
                case 2719: goto L_0x04da;
                case 3091: goto L_0x04ce;
                case 3483: goto L_0x04c2;
                case 73405: goto L_0x04b6;
                case 75537: goto L_0x04aa;
                case 75739: goto L_0x049e;
                case 76779: goto L_0x0492;
                case 78669: goto L_0x0486;
                case 79305: goto L_0x047a;
                case 80618: goto L_0x046e;
                case 88274: goto L_0x0462;
                case 98846: goto L_0x0457;
                case 98848: goto L_0x044c;
                case 99329: goto L_0x0441;
                case 101481: goto L_0x0435;
                case 1513190: goto L_0x042a;
                case 1514184: goto L_0x041f;
                case 1514185: goto L_0x0414;
                case 2133089: goto L_0x0408;
                case 2133091: goto L_0x03fc;
                case 2133120: goto L_0x03f0;
                case 2133151: goto L_0x03e4;
                case 2133182: goto L_0x03d8;
                case 2133184: goto L_0x03cc;
                case 2436959: goto L_0x03c0;
                case 2463773: goto L_0x03b4;
                case 2464648: goto L_0x03a8;
                case 2689555: goto L_0x039c;
                case 3154429: goto L_0x0390;
                case 3284551: goto L_0x0384;
                case 3351335: goto L_0x0378;
                case 3386211: goto L_0x036c;
                case 41325051: goto L_0x0360;
                case 51349633: goto L_0x0355;
                case 51350594: goto L_0x034b;
                case 55178625: goto L_0x033f;
                case 61542055: goto L_0x0334;
                case 65355429: goto L_0x0328;
                case 66214468: goto L_0x031c;
                case 66214470: goto L_0x0310;
                case 66214473: goto L_0x0304;
                case 66215429: goto L_0x02f8;
                case 66215431: goto L_0x02ec;
                case 66215433: goto L_0x02e0;
                case 66216390: goto L_0x02d4;
                case 76402249: goto L_0x02c8;
                case 76404105: goto L_0x02bc;
                case 76404911: goto L_0x02b0;
                case 80963634: goto L_0x02a4;
                case 82882791: goto L_0x0298;
                case 98715550: goto L_0x028c;
                case 101370885: goto L_0x0280;
                case 102844228: goto L_0x0274;
                case 165221241: goto L_0x0268;
                case 182191441: goto L_0x025c;
                case 245388979: goto L_0x0250;
                case 287431619: goto L_0x0244;
                case 307593612: goto L_0x0238;
                case 308517133: goto L_0x022c;
                case 316215098: goto L_0x0220;
                case 316215116: goto L_0x0214;
                case 316246811: goto L_0x0208;
                case 316246818: goto L_0x01fc;
                case 407160593: goto L_0x01f0;
                case 507412548: goto L_0x01e4;
                case 793982701: goto L_0x01d8;
                case 794038622: goto L_0x01cc;
                case 794040393: goto L_0x01c0;
                case 835649806: goto L_0x01b4;
                case 917340916: goto L_0x01a8;
                case 958008161: goto L_0x019c;
                case 1060579533: goto L_0x0190;
                case 1150207623: goto L_0x0184;
                case 1176899427: goto L_0x0178;
                case 1280332038: goto L_0x016c;
                case 1306947716: goto L_0x0160;
                case 1349174697: goto L_0x0154;
                case 1522194893: goto L_0x0148;
                case 1691543273: goto L_0x013c;
                case 1691544261: goto L_0x0130;
                case 1709443163: goto L_0x0124;
                case 1865889110: goto L_0x0118;
                case 1906253259: goto L_0x010c;
                case 1977196784: goto L_0x0100;
                case 2006372676: goto L_0x00f4;
                case 2019281702: goto L_0x00e8;
                case 2029784656: goto L_0x00dc;
                case 2030379515: goto L_0x00d0;
                case 2033393791: goto L_0x00c4;
                case 2047190025: goto L_0x00b8;
                case 2047252157: goto L_0x00ac;
                case 2048319463: goto L_0x00a0;
                case 2048855701: goto L_0x0094;
                default: goto L_0x0092;
            }
        L_0x0092:
            goto L_0x070f
        L_0x0094:
            java.lang.String r2 = "HWWAS-H"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 66
            goto L_0x0710
        L_0x00a0:
            java.lang.String r2 = "HWVNS-H"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 65
            goto L_0x0710
        L_0x00ac:
            java.lang.String r2 = "ELUGA_Prim"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 33
            goto L_0x0710
        L_0x00b8:
            java.lang.String r2 = "ELUGA_Note"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 32
            goto L_0x0710
        L_0x00c4:
            java.lang.String r2 = "ASUS_X00AD_2"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 14
            goto L_0x0710
        L_0x00d0:
            java.lang.String r2 = "HWCAM-H"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 64
            goto L_0x0710
        L_0x00dc:
            java.lang.String r2 = "HWBLN-H"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 63
            goto L_0x0710
        L_0x00e8:
            java.lang.String r2 = "DM-01K"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 29
            goto L_0x0710
        L_0x00f4:
            java.lang.String r2 = "BRAVIA_ATV3_4K"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 19
            goto L_0x0710
        L_0x0100:
            java.lang.String r2 = "Infinix-X572"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 69
            goto L_0x0710
        L_0x010c:
            java.lang.String r2 = "PB2-670M"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 100
            goto L_0x0710
        L_0x0118:
            java.lang.String r2 = "santoni"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 117(0x75, float:1.64E-43)
            goto L_0x0710
        L_0x0124:
            java.lang.String r2 = "iball8735_9806"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 68
            goto L_0x0710
        L_0x0130:
            java.lang.String r2 = "CPH1715"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 24
            goto L_0x0710
        L_0x013c:
            java.lang.String r2 = "CPH1609"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 23
            goto L_0x0710
        L_0x0148:
            java.lang.String r2 = "woods_f"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 133(0x85, float:1.86E-43)
            goto L_0x0710
        L_0x0154:
            java.lang.String r2 = "htc_e56ml_dtul"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 61
            goto L_0x0710
        L_0x0160:
            java.lang.String r2 = "EverStar_S"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 35
            goto L_0x0710
        L_0x016c:
            java.lang.String r2 = "hwALE-H"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 62
            goto L_0x0710
        L_0x0178:
            java.lang.String r2 = "itel_S41"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 71
            goto L_0x0710
        L_0x0184:
            java.lang.String r2 = "LS-5017"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 78
            goto L_0x0710
        L_0x0190:
            java.lang.String r2 = "panell_d"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 96
            goto L_0x0710
        L_0x019c:
            java.lang.String r2 = "j2xlteins"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 72
            goto L_0x0710
        L_0x01a8:
            java.lang.String r2 = "A7000plus"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 10
            goto L_0x0710
        L_0x01b4:
            java.lang.String r2 = "manning"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 81
            goto L_0x0710
        L_0x01c0:
            java.lang.String r2 = "GIONEE_WBL7519"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 59
            goto L_0x0710
        L_0x01cc:
            java.lang.String r2 = "GIONEE_WBL7365"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 58
            goto L_0x0710
        L_0x01d8:
            java.lang.String r2 = "GIONEE_WBL5708"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 57
            goto L_0x0710
        L_0x01e4:
            java.lang.String r2 = "QM16XE_U"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 114(0x72, float:1.6E-43)
            goto L_0x0710
        L_0x01f0:
            java.lang.String r2 = "Pixi5-10_4G"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 106(0x6a, float:1.49E-43)
            goto L_0x0710
        L_0x01fc:
            java.lang.String r2 = "TB3-850M"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 125(0x7d, float:1.75E-43)
            goto L_0x0710
        L_0x0208:
            java.lang.String r2 = "TB3-850F"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 124(0x7c, float:1.74E-43)
            goto L_0x0710
        L_0x0214:
            java.lang.String r2 = "TB3-730X"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 123(0x7b, float:1.72E-43)
            goto L_0x0710
        L_0x0220:
            java.lang.String r2 = "TB3-730F"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 122(0x7a, float:1.71E-43)
            goto L_0x0710
        L_0x022c:
            java.lang.String r2 = "A7020a48"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 12
            goto L_0x0710
        L_0x0238:
            java.lang.String r2 = "A7010a48"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 11
            goto L_0x0710
        L_0x0244:
            java.lang.String r2 = "griffin"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 60
            goto L_0x0710
        L_0x0250:
            java.lang.String r2 = "marino_f"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 82
            goto L_0x0710
        L_0x025c:
            java.lang.String r2 = "CPY83_I00"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 25
            goto L_0x0710
        L_0x0268:
            java.lang.String r2 = "A2016a40"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 8
            goto L_0x0710
        L_0x0274:
            java.lang.String r2 = "le_x6"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 77
            goto L_0x0710
        L_0x0280:
            java.lang.String r2 = "l5460"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 76
            goto L_0x0710
        L_0x028c:
            java.lang.String r2 = "i9031"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 67
            goto L_0x0710
        L_0x0298:
            java.lang.String r2 = "X3_HK"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 135(0x87, float:1.89E-43)
            goto L_0x0710
        L_0x02a4:
            java.lang.String r2 = "V23GB"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 128(0x80, float:1.794E-43)
            goto L_0x0710
        L_0x02b0:
            java.lang.String r2 = "Q4310"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 112(0x70, float:1.57E-43)
            goto L_0x0710
        L_0x02bc:
            java.lang.String r2 = "Q4260"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 110(0x6e, float:1.54E-43)
            goto L_0x0710
        L_0x02c8:
            java.lang.String r2 = "PRO7S"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 108(0x6c, float:1.51E-43)
            goto L_0x0710
        L_0x02d4:
            java.lang.String r2 = "F3311"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 48
            goto L_0x0710
        L_0x02e0:
            java.lang.String r2 = "F3215"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 47
            goto L_0x0710
        L_0x02ec:
            java.lang.String r2 = "F3213"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 46
            goto L_0x0710
        L_0x02f8:
            java.lang.String r2 = "F3211"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 45
            goto L_0x0710
        L_0x0304:
            java.lang.String r2 = "F3116"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 44
            goto L_0x0710
        L_0x0310:
            java.lang.String r2 = "F3113"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 43
            goto L_0x0710
        L_0x031c:
            java.lang.String r2 = "F3111"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 42
            goto L_0x0710
        L_0x0328:
            java.lang.String r2 = "E5643"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 30
            goto L_0x0710
        L_0x0334:
            java.lang.String r2 = "A1601"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 7
            goto L_0x0710
        L_0x033f:
            java.lang.String r2 = "Aura_Note_2"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 15
            goto L_0x0710
        L_0x034b:
            java.lang.String r3 = "602LV"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x070f
            goto L_0x0710
        L_0x0355:
            java.lang.String r2 = "601LV"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = r4
            goto L_0x0710
        L_0x0360:
            java.lang.String r2 = "MEIZU_M5"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 83
            goto L_0x0710
        L_0x036c:
            java.lang.String r2 = "p212"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 92
            goto L_0x0710
        L_0x0378:
            java.lang.String r2 = "mido"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 85
            goto L_0x0710
        L_0x0384:
            java.lang.String r2 = "kate"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 75
            goto L_0x0710
        L_0x0390:
            java.lang.String r2 = "fugu"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 50
            goto L_0x0710
        L_0x039c:
            java.lang.String r2 = "XE2X"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 136(0x88, float:1.9E-43)
            goto L_0x0710
        L_0x03a8:
            java.lang.String r2 = "Q427"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 111(0x6f, float:1.56E-43)
            goto L_0x0710
        L_0x03b4:
            java.lang.String r2 = "Q350"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 109(0x6d, float:1.53E-43)
            goto L_0x0710
        L_0x03c0:
            java.lang.String r2 = "P681"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 93
            goto L_0x0710
        L_0x03cc:
            java.lang.String r2 = "F04J"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 41
            goto L_0x0710
        L_0x03d8:
            java.lang.String r2 = "F04H"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 40
            goto L_0x0710
        L_0x03e4:
            java.lang.String r2 = "F03H"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 39
            goto L_0x0710
        L_0x03f0:
            java.lang.String r2 = "F02H"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 38
            goto L_0x0710
        L_0x03fc:
            java.lang.String r2 = "F01J"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 37
            goto L_0x0710
        L_0x0408:
            java.lang.String r2 = "F01H"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 36
            goto L_0x0710
        L_0x0414:
            java.lang.String r2 = "1714"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = r8
            goto L_0x0710
        L_0x041f:
            java.lang.String r2 = "1713"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = r9
            goto L_0x0710
        L_0x042a:
            java.lang.String r2 = "1601"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = r0
            goto L_0x0710
        L_0x0435:
            java.lang.String r2 = "flo"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 49
            goto L_0x0710
        L_0x0441:
            java.lang.String r2 = "deb"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = r6
            goto L_0x0710
        L_0x044c:
            java.lang.String r2 = "cv3"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = r10
            goto L_0x0710
        L_0x0457:
            java.lang.String r2 = "cv1"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = r11
            goto L_0x0710
        L_0x0462:
            java.lang.String r2 = "Z80"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 139(0x8b, float:1.95E-43)
            goto L_0x0710
        L_0x046e:
            java.lang.String r2 = "QX1"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 115(0x73, float:1.61E-43)
            goto L_0x0710
        L_0x047a:
            java.lang.String r2 = "PLE"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 107(0x6b, float:1.5E-43)
            goto L_0x0710
        L_0x0486:
            java.lang.String r2 = "P85"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 94
            goto L_0x0710
        L_0x0492:
            java.lang.String r2 = "MX6"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 86
            goto L_0x0710
        L_0x049e:
            java.lang.String r2 = "M5c"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 80
            goto L_0x0710
        L_0x04aa:
            java.lang.String r2 = "M04"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 79
            goto L_0x0710
        L_0x04b6:
            java.lang.String r2 = "JGZ"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 73
            goto L_0x0710
        L_0x04c2:
            java.lang.String r2 = "mh"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 84
            goto L_0x0710
        L_0x04ce:
            java.lang.String r2 = "b5"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 16
            goto L_0x0710
        L_0x04da:
            java.lang.String r2 = "V5"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 129(0x81, float:1.81E-43)
            goto L_0x0710
        L_0x04e6:
            java.lang.String r2 = "V1"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 127(0x7f, float:1.78E-43)
            goto L_0x0710
        L_0x04f2:
            java.lang.String r2 = "Q5"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 113(0x71, float:1.58E-43)
            goto L_0x0710
        L_0x04fe:
            java.lang.String r2 = "C1"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 20
            goto L_0x0710
        L_0x050a:
            java.lang.String r2 = "woods_fn"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 134(0x86, float:1.88E-43)
            goto L_0x0710
        L_0x0516:
            java.lang.String r2 = "ELUGA_A3_Pro"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 31
            goto L_0x0710
        L_0x0522:
            java.lang.String r2 = "Z12_PRO"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 138(0x8a, float:1.93E-43)
            goto L_0x0710
        L_0x052e:
            java.lang.String r2 = "BLACK-1X"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 17
            goto L_0x0710
        L_0x053a:
            java.lang.String r2 = "taido_row"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 121(0x79, float:1.7E-43)
            goto L_0x0710
        L_0x0546:
            java.lang.String r2 = "Pixi4-7_3G"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 105(0x69, float:1.47E-43)
            goto L_0x0710
        L_0x0552:
            java.lang.String r2 = "GIONEE_GBL7360"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 53
            goto L_0x0710
        L_0x055e:
            java.lang.String r2 = "GiONEE_CBL7513"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 51
            goto L_0x0710
        L_0x056a:
            java.lang.String r2 = "OnePlus5T"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 91
            goto L_0x0710
        L_0x0576:
            java.lang.String r2 = "whyred"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 132(0x84, float:1.85E-43)
            goto L_0x0710
        L_0x0582:
            java.lang.String r2 = "watson"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 131(0x83, float:1.84E-43)
            goto L_0x0710
        L_0x058e:
            java.lang.String r2 = "SVP-DTV15"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 119(0x77, float:1.67E-43)
            goto L_0x0710
        L_0x059a:
            java.lang.String r2 = "A7000-a"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 9
            goto L_0x0710
        L_0x05a6:
            java.lang.String r2 = "nicklaus_f"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 88
            goto L_0x0710
        L_0x05b2:
            java.lang.String r2 = "tcl_eu"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 126(0x7e, float:1.77E-43)
            goto L_0x0710
        L_0x05be:
            java.lang.String r2 = "ELUGA_Ray_X"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 34
            goto L_0x0710
        L_0x05ca:
            java.lang.String r2 = "s905x018"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 120(0x78, float:1.68E-43)
            goto L_0x0710
        L_0x05d6:
            java.lang.String r2 = "A10-70L"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = r5
            goto L_0x0710
        L_0x05e1:
            java.lang.String r2 = "A10-70F"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = r3
            goto L_0x0710
        L_0x05ec:
            java.lang.String r2 = "namath"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 87
            goto L_0x0710
        L_0x05f8:
            java.lang.String r2 = "Slate_Pro"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 118(0x76, float:1.65E-43)
            goto L_0x0710
        L_0x0604:
            java.lang.String r2 = "iris60"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 70
            goto L_0x0710
        L_0x0610:
            java.lang.String r2 = "BRAVIA_ATV2"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 18
            goto L_0x0710
        L_0x061c:
            java.lang.String r2 = "GiONEE_GBL7319"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 52
            goto L_0x0710
        L_0x0628:
            java.lang.String r2 = "panell_dt"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 99
            goto L_0x0710
        L_0x0634:
            java.lang.String r2 = "panell_ds"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 98
            goto L_0x0710
        L_0x0640:
            java.lang.String r2 = "panell_dl"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 97
            goto L_0x0710
        L_0x064c:
            java.lang.String r2 = "vernee_M5"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 130(0x82, float:1.82E-43)
            goto L_0x0710
        L_0x0658:
            java.lang.String r2 = "pacificrim"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 95
            goto L_0x0710
        L_0x0664:
            java.lang.String r2 = "Phantom6"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 104(0x68, float:1.46E-43)
            goto L_0x0710
        L_0x0670:
            java.lang.String r2 = "ComioS1"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 21
            goto L_0x0710
        L_0x067c:
            java.lang.String r2 = "XT1663"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 137(0x89, float:1.92E-43)
            goto L_0x0710
        L_0x0688:
            java.lang.String r2 = "RAIJIN"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 116(0x74, float:1.63E-43)
            goto L_0x0710
        L_0x0694:
            java.lang.String r2 = "AquaPowerM"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 13
            goto L_0x0710
        L_0x06a0:
            java.lang.String r2 = "PGN611"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 103(0x67, float:1.44E-43)
            goto L_0x0710
        L_0x06ac:
            java.lang.String r2 = "PGN610"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 102(0x66, float:1.43E-43)
            goto L_0x0710
        L_0x06b7:
            java.lang.String r2 = "PGN528"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 101(0x65, float:1.42E-43)
            goto L_0x0710
        L_0x06c2:
            java.lang.String r2 = "NX573J"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 90
            goto L_0x0710
        L_0x06cd:
            java.lang.String r2 = "NX541J"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 89
            goto L_0x0710
        L_0x06d8:
            java.lang.String r2 = "CP8676_I02"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 22
            goto L_0x0710
        L_0x06e3:
            java.lang.String r2 = "K50a40"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 74
            goto L_0x0710
        L_0x06ee:
            java.lang.String r2 = "GIONEE_SWW1631"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 56
            goto L_0x0710
        L_0x06f9:
            java.lang.String r2 = "GIONEE_SWW1627"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 55
            goto L_0x0710
        L_0x0704:
            java.lang.String r2 = "GIONEE_SWW1609"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x070f
            r2 = 54
            goto L_0x0710
        L_0x070f:
            r2 = r7
        L_0x0710:
            switch(r2) {
                case 0: goto L_0x0073;
                case 1: goto L_0x0073;
                case 2: goto L_0x0073;
                case 3: goto L_0x0073;
                case 4: goto L_0x0073;
                case 5: goto L_0x0073;
                case 6: goto L_0x0073;
                case 7: goto L_0x0073;
                case 8: goto L_0x0073;
                case 9: goto L_0x0073;
                case 10: goto L_0x0073;
                case 11: goto L_0x0073;
                case 12: goto L_0x0073;
                case 13: goto L_0x0073;
                case 14: goto L_0x0073;
                case 15: goto L_0x0073;
                case 16: goto L_0x0073;
                case 17: goto L_0x0073;
                case 18: goto L_0x0073;
                case 19: goto L_0x0073;
                case 20: goto L_0x0073;
                case 21: goto L_0x0073;
                case 22: goto L_0x0073;
                case 23: goto L_0x0073;
                case 24: goto L_0x0073;
                case 25: goto L_0x0073;
                case 26: goto L_0x0073;
                case 27: goto L_0x0073;
                case 28: goto L_0x0073;
                case 29: goto L_0x0073;
                case 30: goto L_0x0073;
                case 31: goto L_0x0073;
                case 32: goto L_0x0073;
                case 33: goto L_0x0073;
                case 34: goto L_0x0073;
                case 35: goto L_0x0073;
                case 36: goto L_0x0073;
                case 37: goto L_0x0073;
                case 38: goto L_0x0073;
                case 39: goto L_0x0073;
                case 40: goto L_0x0073;
                case 41: goto L_0x0073;
                case 42: goto L_0x0073;
                case 43: goto L_0x0073;
                case 44: goto L_0x0073;
                case 45: goto L_0x0073;
                case 46: goto L_0x0073;
                case 47: goto L_0x0073;
                case 48: goto L_0x0073;
                case 49: goto L_0x0073;
                case 50: goto L_0x0073;
                case 51: goto L_0x0073;
                case 52: goto L_0x0073;
                case 53: goto L_0x0073;
                case 54: goto L_0x0073;
                case 55: goto L_0x0073;
                case 56: goto L_0x0073;
                case 57: goto L_0x0073;
                case 58: goto L_0x0073;
                case 59: goto L_0x0073;
                case 60: goto L_0x0073;
                case 61: goto L_0x0073;
                case 62: goto L_0x0073;
                case 63: goto L_0x0073;
                case 64: goto L_0x0073;
                case 65: goto L_0x0073;
                case 66: goto L_0x0073;
                case 67: goto L_0x0073;
                case 68: goto L_0x0073;
                case 69: goto L_0x0073;
                case 70: goto L_0x0073;
                case 71: goto L_0x0073;
                case 72: goto L_0x0073;
                case 73: goto L_0x0073;
                case 74: goto L_0x0073;
                case 75: goto L_0x0073;
                case 76: goto L_0x0073;
                case 77: goto L_0x0073;
                case 78: goto L_0x0073;
                case 79: goto L_0x0073;
                case 80: goto L_0x0073;
                case 81: goto L_0x0073;
                case 82: goto L_0x0073;
                case 83: goto L_0x0073;
                case 84: goto L_0x0073;
                case 85: goto L_0x0073;
                case 86: goto L_0x0073;
                case 87: goto L_0x0073;
                case 88: goto L_0x0073;
                case 89: goto L_0x0073;
                case 90: goto L_0x0073;
                case 91: goto L_0x0073;
                case 92: goto L_0x0073;
                case 93: goto L_0x0073;
                case 94: goto L_0x0073;
                case 95: goto L_0x0073;
                case 96: goto L_0x0073;
                case 97: goto L_0x0073;
                case 98: goto L_0x0073;
                case 99: goto L_0x0073;
                case 100: goto L_0x0073;
                case 101: goto L_0x0073;
                case 102: goto L_0x0073;
                case 103: goto L_0x0073;
                case 104: goto L_0x0073;
                case 105: goto L_0x0073;
                case 106: goto L_0x0073;
                case 107: goto L_0x0073;
                case 108: goto L_0x0073;
                case 109: goto L_0x0073;
                case 110: goto L_0x0073;
                case 111: goto L_0x0073;
                case 112: goto L_0x0073;
                case 113: goto L_0x0073;
                case 114: goto L_0x0073;
                case 115: goto L_0x0073;
                case 116: goto L_0x0073;
                case 117: goto L_0x0073;
                case 118: goto L_0x0073;
                case 119: goto L_0x0073;
                case 120: goto L_0x0073;
                case 121: goto L_0x0073;
                case 122: goto L_0x0073;
                case 123: goto L_0x0073;
                case 124: goto L_0x0073;
                case 125: goto L_0x0073;
                case 126: goto L_0x0073;
                case 127: goto L_0x0073;
                case 128: goto L_0x0073;
                case 129: goto L_0x0073;
                case 130: goto L_0x0073;
                case 131: goto L_0x0073;
                case 132: goto L_0x0073;
                case 133: goto L_0x0073;
                case 134: goto L_0x0073;
                case 135: goto L_0x0073;
                case 136: goto L_0x0073;
                case 137: goto L_0x0073;
                case 138: goto L_0x0073;
                case 139: goto L_0x0073;
                default: goto L_0x0713;
            }
        L_0x0713:
            java.lang.String r1 = com.google.android.gms.internal.ads.zzfn.zzd     // Catch:{ all -> 0x0754 }
            int r2 = r1.hashCode()     // Catch:{ all -> 0x0754 }
            r3 = -594534941(0xffffffffdc901de3, float:-3.2452206E17)
            if (r2 == r3) goto L_0x073d
            r3 = 2006354(0x1e9d52, float:2.811501E-39)
            if (r2 == r3) goto L_0x0733
            r3 = 2006367(0x1e9d5f, float:2.811519E-39)
            if (r2 == r3) goto L_0x0729
            goto L_0x0746
        L_0x0729:
            java.lang.String r2 = "AFTN"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0746
            r7 = r9
            goto L_0x0746
        L_0x0733:
            java.lang.String r2 = "AFTA"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0746
            r7 = r0
            goto L_0x0746
        L_0x073d:
            java.lang.String r2 = "JSN-L21"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0746
            r7 = r8
        L_0x0746:
            if (r7 == 0) goto L_0x0073
            if (r7 == r9) goto L_0x0073
            if (r7 == r8) goto L_0x0073
        L_0x074c:
            zzd = r0     // Catch:{ all -> 0x0754 }
            zzc = r9     // Catch:{ all -> 0x0754 }
        L_0x0750:
            monitor-exit(r13)     // Catch:{ all -> 0x0754 }
            boolean r13 = zzd
            return r13
        L_0x0754:
            r0 = move-exception
            monitor-exit(r13)     // Catch:{ all -> 0x0754 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzuv.zzaz(java.lang.String):boolean");
    }

    public final void zzC(float f11, float f12) throws zzgg {
        super.zzC(f11, f12);
        this.zzf.zzg(f11);
    }

    public final String zzJ() {
        return "MediaCodecVideoRenderer";
    }

    public final boolean zzM() {
        zzuq zzuq;
        if (super.zzM() && (this.zzp || (((zzuq = this.zzm) != null && this.zzl == zzuq) || zzai() == null))) {
            this.zzt = C.TIME_UNSET;
            return true;
        } else if (this.zzt == C.TIME_UNSET) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.zzt) {
                return true;
            }
            this.zzt = C.TIME_UNSET;
            return false;
        }
    }

    public final float zzO(float f11, zzab zzab, zzab[] zzabArr) {
        float f12 = -1.0f;
        for (zzab zzab2 : zzabArr) {
            float f13 = zzab2.zzt;
            if (f13 != -1.0f) {
                f12 = Math.max(f12, f13);
            }
        }
        if (f12 == -1.0f) {
            return -1.0f;
        }
        return f12 * f11;
    }

    public final int zzP(zzol zzol, zzab zzab) throws zzos {
        boolean z11;
        int i11;
        int i12;
        int i13 = 0;
        if (!zzbi.zzh(zzab.zzm)) {
            return 0;
        }
        if (zzab.zzp != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        List<zzoh> zzaB = zzaB(zzol, zzab, z11, false);
        if (z11 && zzaB.isEmpty()) {
            zzaB = zzaB(zzol, zzab, false, false);
        }
        if (zzaB.isEmpty()) {
            return 1;
        }
        if (!zzoj.zzau(zzab)) {
            return 2;
        }
        zzoh zzoh = zzaB.get(0);
        boolean zzd2 = zzoh.zzd(zzab);
        if (true != zzoh.zze(zzab)) {
            i11 = 8;
        } else {
            i11 = 16;
        }
        if (zzd2) {
            List<zzoh> zzaB2 = zzaB(zzol, zzab, z11, true);
            if (!zzaB2.isEmpty()) {
                zzoh zzoh2 = zzaB2.get(0);
                if (zzoh2.zzd(zzab) && zzoh2.zze(zzab)) {
                    i13 = 32;
                }
            }
        }
        if (true != zzd2) {
            i12 = 3;
        } else {
            i12 = 4;
        }
        return i12 | i11 | i13;
    }

    public final zzfz zzQ(zzoh zzoh, zzab zzab, zzab zzab2) {
        int i11;
        int i12;
        zzfz zzb2 = zzoh.zzb(zzab, zzab2);
        int i13 = zzb2.zze;
        int i14 = zzab2.zzr;
        zzuu zzuu = this.zzi;
        if (i14 > zzuu.zza || zzab2.zzs > zzuu.zzb) {
            i13 |= 256;
        }
        if (zzS(zzoh, zzab2) > this.zzi.zzc) {
            i13 |= 64;
        }
        String str = zzoh.zza;
        if (i13 != 0) {
            i12 = 0;
            i11 = i13;
        } else {
            i11 = 0;
            i12 = zzb2.zzd;
        }
        return new zzfz(str, zzab, zzab2, i12, i11);
    }

    @Nullable
    public final zzfz zzR(zzhr zzhr) throws zzgg {
        zzfz zzR = super.zzR(zzhr);
        this.zzg.zzf(zzhr.zza, zzR);
        return zzR;
    }

    public final void zzT() {
        this.zzr = true;
        if (!this.zzp) {
            this.zzp = true;
            this.zzg.zzq(this.zzl);
            this.zzn = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:65:0x012d, code lost:
        r20 = r9;
        r21 = r10;
     */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0134  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0213  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0236  */
    @android.annotation.TargetApi(17)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzod zzU(com.google.android.gms.internal.ads.zzoh r23, com.google.android.gms.internal.ads.zzab r24, @androidx.annotation.Nullable android.media.MediaCrypto r25, float r26) {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r26
            com.google.android.gms.internal.ads.zzuq r4 = r0.zzm
            if (r4 == 0) goto L_0x0015
            boolean r4 = r4.zza
            boolean r5 = r1.zzf
            if (r4 == r5) goto L_0x0015
            r22.zzaE()
        L_0x0015:
            java.lang.String r4 = r1.zzc
            com.google.android.gms.internal.ads.zzab[] r5 = r22.zzI()
            int r6 = r2.zzr
            int r7 = r2.zzs
            int r8 = zzS(r23, r24)
            int r9 = r5.length
            r10 = -1
            r13 = 1
            if (r9 != r13) goto L_0x0042
            if (r8 == r10) goto L_0x0039
            int r5 = zzaA(r23, r24)
            if (r5 == r10) goto L_0x0039
            float r8 = (float) r8
            r9 = 1069547520(0x3fc00000, float:1.5)
            float r8 = r8 * r9
            int r8 = (int) r8
            int r8 = java.lang.Math.min(r8, r5)
        L_0x0039:
            com.google.android.gms.internal.ads.zzuu r5 = new com.google.android.gms.internal.ads.zzuu
            r5.<init>(r6, r7, r8)
            r16 = r4
            goto L_0x017e
        L_0x0042:
            r14 = 0
            r15 = 0
        L_0x0044:
            if (r14 >= r9) goto L_0x0088
            r11 = r5[r14]
            com.google.android.gms.internal.ads.zzm r13 = r2.zzy
            if (r13 == 0) goto L_0x005d
            com.google.android.gms.internal.ads.zzm r13 = r11.zzy
            if (r13 != 0) goto L_0x005d
            com.google.android.gms.internal.ads.zzz r11 = r11.zzb()
            com.google.android.gms.internal.ads.zzm r13 = r2.zzy
            r11.zzy(r13)
            com.google.android.gms.internal.ads.zzab r11 = r11.zzY()
        L_0x005d:
            com.google.android.gms.internal.ads.zzfz r13 = r1.zzb(r2, r11)
            int r13 = r13.zzd
            if (r13 == 0) goto L_0x0084
            int r13 = r11.zzr
            if (r13 == r10) goto L_0x0070
            int r12 = r11.zzs
            if (r12 != r10) goto L_0x006e
            goto L_0x0070
        L_0x006e:
            r12 = 0
            goto L_0x0071
        L_0x0070:
            r12 = 1
        L_0x0071:
            r15 = r15 | r12
            int r6 = java.lang.Math.max(r6, r13)
            int r12 = r11.zzs
            int r7 = java.lang.Math.max(r7, r12)
            int r11 = zzS(r1, r11)
            int r8 = java.lang.Math.max(r8, r11)
        L_0x0084:
            int r14 = r14 + 1
            r13 = 1
            goto L_0x0044
        L_0x0088:
            if (r15 == 0) goto L_0x0177
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r9 = 66
            r5.<init>(r9)
            java.lang.String r9 = "Resolutions unknown. Codec max resolution: "
            r5.append(r9)
            r5.append(r6)
            java.lang.String r9 = "x"
            r5.append(r9)
            r5.append(r7)
            java.lang.String r5 = r5.toString()
            java.lang.String r10 = "MediaCodecVideoRenderer"
            android.util.Log.w(r10, r5)
            int r5 = r2.zzs
            int r11 = r2.zzr
            if (r5 <= r11) goto L_0x00b2
            r12 = r5
            goto L_0x00b3
        L_0x00b2:
            r12 = r11
        L_0x00b3:
            if (r5 > r11) goto L_0x00b7
            r13 = r5
            goto L_0x00b8
        L_0x00b7:
            r13 = r11
        L_0x00b8:
            float r14 = (float) r13
            float r15 = (float) r12
            float r14 = r14 / r15
            int[] r15 = zzb
            r16 = r4
            r3 = 0
        L_0x00c0:
            r4 = 9
            if (r3 >= r4) goto L_0x012d
            r4 = r15[r3]
            r17 = r15
            float r15 = (float) r4
            float r15 = r15 * r14
            int r15 = (int) r15
            if (r4 <= r12) goto L_0x012d
            if (r15 > r13) goto L_0x00d1
            goto L_0x012d
        L_0x00d1:
            r18 = r12
            int r12 = com.google.android.gms.internal.ads.zzfn.zza
            r19 = r13
            r13 = 21
            if (r12 < r13) goto L_0x00f9
            if (r5 > r11) goto L_0x00df
            r12 = r4
            goto L_0x00e0
        L_0x00df:
            r12 = r15
        L_0x00e0:
            if (r5 > r11) goto L_0x00e3
            r4 = r15
        L_0x00e3:
            android.graphics.Point r4 = r1.zza(r12, r4)
            float r12 = r2.zzt
            int r13 = r4.x
            int r15 = r4.y
            r20 = r9
            r21 = r10
            double r9 = (double) r12
            boolean r9 = r1.zzf(r13, r15, r9)
            if (r9 == 0) goto L_0x0120
            goto L_0x0132
        L_0x00f9:
            r20 = r9
            r21 = r10
            r9 = 16
            int r4 = com.google.android.gms.internal.ads.zzfn.zze(r4, r9)     // Catch:{ zzos -> 0x0131 }
            int r4 = r4 * r9
            int r10 = com.google.android.gms.internal.ads.zzfn.zze(r15, r9)     // Catch:{ zzos -> 0x0131 }
            int r10 = r10 * r9
            int r9 = r4 * r10
            int r12 = com.google.android.gms.internal.ads.zzoy.zza()     // Catch:{ zzos -> 0x0131 }
            if (r9 > r12) goto L_0x0120
            android.graphics.Point r3 = new android.graphics.Point     // Catch:{ zzos -> 0x0131 }
            if (r5 > r11) goto L_0x0117
            r9 = r4
            goto L_0x0118
        L_0x0117:
            r9 = r10
        L_0x0118:
            if (r5 > r11) goto L_0x011b
            r4 = r10
        L_0x011b:
            r3.<init>(r9, r4)     // Catch:{ zzos -> 0x0131 }
            r4 = r3
            goto L_0x0132
        L_0x0120:
            int r3 = r3 + 1
            r15 = r17
            r12 = r18
            r13 = r19
            r9 = r20
            r10 = r21
            goto L_0x00c0
        L_0x012d:
            r20 = r9
            r21 = r10
        L_0x0131:
            r4 = 0
        L_0x0132:
            if (r4 == 0) goto L_0x0179
            int r3 = r4.x
            int r6 = java.lang.Math.max(r6, r3)
            int r3 = r4.y
            int r7 = java.lang.Math.max(r7, r3)
            com.google.android.gms.internal.ads.zzz r3 = r24.zzb()
            r3.zzX(r6)
            r3.zzF(r7)
            com.google.android.gms.internal.ads.zzab r3 = r3.zzY()
            int r3 = zzaA(r1, r3)
            int r8 = java.lang.Math.max(r8, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r4 = 57
            r3.<init>(r4)
            java.lang.String r4 = "Codec max resolution adjusted to: "
            r3.append(r4)
            r3.append(r6)
            r4 = r20
            r3.append(r4)
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            r4 = r21
            android.util.Log.w(r4, r3)
            goto L_0x0179
        L_0x0177:
            r16 = r4
        L_0x0179:
            com.google.android.gms.internal.ads.zzuu r5 = new com.google.android.gms.internal.ads.zzuu
            r5.<init>(r6, r7, r8)
        L_0x017e:
            r0.zzi = r5
            boolean r3 = r0.zzh
            android.media.MediaFormat r4 = new android.media.MediaFormat
            r4.<init>()
            java.lang.String r6 = "mime"
            r7 = r16
            r4.setString(r6, r7)
            java.lang.String r6 = "width"
            int r7 = r2.zzr
            r4.setInteger(r6, r7)
            java.lang.String r6 = "height"
            int r7 = r2.zzs
            r4.setInteger(r6, r7)
            java.util.List<byte[]> r6 = r2.zzo
            com.google.android.gms.internal.ads.zzer.zzb(r4, r6)
            float r6 = r2.zzt
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r8 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r8 == 0) goto L_0x01ae
            java.lang.String r8 = "frame-rate"
            r4.setFloat(r8, r6)
        L_0x01ae:
            java.lang.String r6 = "rotation-degrees"
            int r8 = r2.zzu
            com.google.android.gms.internal.ads.zzer.zza(r4, r6, r8)
            com.google.android.gms.internal.ads.zzm r6 = r2.zzy
            if (r6 == 0) goto L_0x01db
            java.lang.String r8 = "color-transfer"
            int r9 = r6.zzd
            com.google.android.gms.internal.ads.zzer.zza(r4, r8, r9)
            java.lang.String r8 = "color-standard"
            int r9 = r6.zzb
            com.google.android.gms.internal.ads.zzer.zza(r4, r8, r9)
            java.lang.String r8 = "color-range"
            int r9 = r6.zzc
            com.google.android.gms.internal.ads.zzer.zza(r4, r8, r9)
            byte[] r6 = r6.zze
            if (r6 == 0) goto L_0x01db
            java.lang.String r8 = "hdr-static-info"
            java.nio.ByteBuffer r6 = java.nio.ByteBuffer.wrap(r6)
            r4.setByteBuffer(r8, r6)
        L_0x01db:
            java.lang.String r6 = "video/dolby-vision"
            java.lang.String r8 = r2.zzm
            boolean r6 = r6.equals(r8)
            if (r6 == 0) goto L_0x01f8
            android.util.Pair r6 = com.google.android.gms.internal.ads.zzoy.zzb(r24)
            if (r6 == 0) goto L_0x01f8
            java.lang.Object r6 = r6.first
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            java.lang.String r8 = "profile"
            com.google.android.gms.internal.ads.zzer.zza(r4, r8, r6)
        L_0x01f8:
            int r6 = r5.zza
            java.lang.String r8 = "max-width"
            r4.setInteger(r8, r6)
            java.lang.String r6 = "max-height"
            int r8 = r5.zzb
            r4.setInteger(r6, r8)
            java.lang.String r6 = "max-input-size"
            int r5 = r5.zzc
            com.google.android.gms.internal.ads.zzer.zza(r4, r6, r5)
            int r5 = com.google.android.gms.internal.ads.zzfn.zza
            r6 = 23
            if (r5 < r6) goto L_0x0224
            java.lang.String r5 = "priority"
            r6 = 0
            r4.setInteger(r5, r6)
            r5 = r26
            int r6 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r6 == 0) goto L_0x0224
            java.lang.String r6 = "operating-rate"
            r4.setFloat(r6, r5)
        L_0x0224:
            if (r3 == 0) goto L_0x0232
            java.lang.String r3 = "no-post-process"
            r5 = 1
            r4.setInteger(r3, r5)
            java.lang.String r3 = "auto-frc"
            r5 = 0
            r4.setInteger(r3, r5)
        L_0x0232:
            android.view.Surface r3 = r0.zzl
            if (r3 != 0) goto L_0x0255
            boolean r3 = r22.zzaG(r23)
            if (r3 == 0) goto L_0x024f
            com.google.android.gms.internal.ads.zzuq r3 = r0.zzm
            if (r3 != 0) goto L_0x024a
            android.content.Context r3 = r0.zze
            boolean r5 = r1.zzf
            com.google.android.gms.internal.ads.zzuq r3 = com.google.android.gms.internal.ads.zzuq.zza(r3, r5)
            r0.zzm = r3
        L_0x024a:
            com.google.android.gms.internal.ads.zzuq r3 = r0.zzm
            r0.zzl = r3
            goto L_0x0255
        L_0x024f:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x0255:
            android.view.Surface r3 = r0.zzl
            r5 = 0
            com.google.android.gms.internal.ads.zzod r1 = com.google.android.gms.internal.ads.zzod.zzb(r1, r4, r2, r3, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzuv.zzU(com.google.android.gms.internal.ads.zzoh, com.google.android.gms.internal.ads.zzab, android.media.MediaCrypto, float):com.google.android.gms.internal.ads.zzod");
    }

    public final List<zzoh> zzV(zzol zzol, zzab zzab, boolean z11) throws zzos {
        return zzaB(zzol, zzab, false, false);
    }

    public final void zzW(Exception exc) {
        zzep.zza("MediaCodecVideoRenderer", "Video codec error", exc);
        this.zzg.zzs(exc);
    }

    public final void zzX(String str, long j11, long j12) {
        this.zzg.zza(str, j11, j12);
        this.zzj = zzaz(str);
        zzoh zzak = zzak();
        zzak.getClass();
        boolean z11 = false;
        if (zzfn.zza >= 29 && MimeTypes.VIDEO_VP9.equals(zzak.zzb)) {
            MediaCodecInfo.CodecProfileLevel[] zzg2 = zzak.zzg();
            int length = zzg2.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                } else if (zzg2[i11].profile == 16384) {
                    z11 = true;
                    break;
                } else {
                    i11++;
                }
            }
        }
        this.zzk = z11;
    }

    public final void zzY(String str) {
        this.zzg.zzb(str);
    }

    public final void zzZ(zzab zzab, @Nullable MediaFormat mediaFormat) {
        int i11;
        int i12;
        zzof zzai = zzai();
        if (zzai != null) {
            zzai.zzq(this.zzo);
        }
        mediaFormat.getClass();
        boolean z11 = false;
        if (mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top")) {
            z11 = true;
        }
        if (z11) {
            i11 = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            i11 = mediaFormat.getInteger("width");
        }
        this.zzC = i11;
        if (z11) {
            i12 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            i12 = mediaFormat.getInteger("height");
        }
        this.zzD = i12;
        float f11 = zzab.zzv;
        this.zzF = f11;
        if (zzfn.zza >= 21) {
            int i13 = zzab.zzu;
            if (i13 == 90 || i13 == 270) {
                int i14 = this.zzC;
                this.zzC = i12;
                this.zzD = i14;
                this.zzF = 1.0f / f11;
            }
        } else {
            this.zzE = zzab.zzu;
        }
        this.zzf.zze(zzab.zzt);
    }

    public final void zzaa(zzof zzof, int i11, long j11) {
        zzaC();
        zzfl.zza("releaseOutputBuffer");
        zzof.zzn(i11, true);
        zzfl.zzb();
        this.zzz = SystemClock.elapsedRealtime() * 1000;
        this.zza.zze++;
        this.zzw = 0;
        zzT();
    }

    public final void zzab() {
        this.zzp = false;
        int i11 = zzfn.zza;
    }

    @CallSuper
    public final void zzac(zzda zzda) throws zzgg {
        this.zzx++;
        int i11 = zzfn.zza;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a0, code lost:
        if (r16 > 100000) goto L_0x00a2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:93:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzae(long r23, long r25, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzof r27, @androidx.annotation.Nullable java.nio.ByteBuffer r28, int r29, int r30, int r31, long r32, boolean r34, boolean r35, com.google.android.gms.internal.ads.zzab r36) throws com.google.android.gms.internal.ads.zzgg {
        /*
            r22 = this;
            r0 = r22
            r1 = r23
            r3 = r27
            r4 = r29
            r5 = r32
            r27.getClass()
            long r7 = r0.zzs
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 != 0) goto L_0x001a
            r0.zzs = r1
        L_0x001a:
            long r7 = r0.zzy
            int r7 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r7 == 0) goto L_0x0027
            com.google.android.gms.internal.ads.zzvd r7 = r0.zzf
            r7.zzf(r5)
            r0.zzy = r5
        L_0x0027:
            long r7 = r22.zzah()
            long r11 = r5 - r7
            r13 = 1
            if (r34 == 0) goto L_0x0037
            if (r35 == 0) goto L_0x0033
            goto L_0x0037
        L_0x0033:
            r0.zzaw(r3, r4, r11)
            return r13
        L_0x0037:
            float r14 = r22.zzag()
            int r15 = r22.zzbm()
            long r16 = android.os.SystemClock.elapsedRealtime()
            r18 = 1000(0x3e8, double:4.94E-321)
            long r16 = r16 * r18
            long r5 = r5 - r1
            double r5 = (double) r5
            double r9 = (double) r14
            double r5 = r5 / r9
            long r5 = (long) r5
            r9 = 2
            if (r15 != r9) goto L_0x0053
            long r20 = r16 - r25
            long r5 = r5 - r20
        L_0x0053:
            android.view.Surface r10 = r0.zzl
            com.google.android.gms.internal.ads.zzuq r14 = r0.zzm
            r9 = 0
            if (r10 != r14) goto L_0x0068
            boolean r1 = zzaF(r5)
            if (r1 == 0) goto L_0x0067
            r0.zzaw(r3, r4, r11)
            r0.zzay(r5)
            return r13
        L_0x0067:
            return r9
        L_0x0068:
            long r9 = r0.zzz
            long r16 = r16 - r9
            boolean r9 = r0.zzr
            if (r9 != 0) goto L_0x0078
            r9 = 2
            if (r15 == r9) goto L_0x007c
            boolean r9 = r0.zzq
            if (r9 == 0) goto L_0x007e
            goto L_0x007c
        L_0x0078:
            boolean r9 = r0.zzp
            if (r9 != 0) goto L_0x007e
        L_0x007c:
            r9 = r13
            goto L_0x007f
        L_0x007e:
            r9 = 0
        L_0x007f:
            long r13 = r0.zzt
            r20 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r13 = (r13 > r20 ? 1 : (r13 == r20 ? 0 : -1))
            r14 = 21
            if (r13 != 0) goto L_0x00c0
            int r7 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r7 < 0) goto L_0x00c0
            if (r9 != 0) goto L_0x00a2
            r7 = 2
            if (r15 != r7) goto L_0x00c1
            boolean r7 = zzaF(r5)
            if (r7 == 0) goto L_0x00c0
            r7 = 100000(0x186a0, double:4.94066E-319)
            int r7 = (r16 > r7 ? 1 : (r16 == r7 ? 0 : -1))
            if (r7 <= 0) goto L_0x00c0
        L_0x00a2:
            long r1 = java.lang.System.nanoTime()
            int r7 = com.google.android.gms.internal.ads.zzfn.zza
            if (r7 < r14) goto L_0x00b8
            r30 = r22
            r31 = r27
            r32 = r29
            r33 = r11
            r35 = r1
            r30.zzav(r31, r32, r33, r35)
            goto L_0x00bb
        L_0x00b8:
            r0.zzaa(r3, r4, r11)
        L_0x00bb:
            r0.zzay(r5)
            r1 = 1
            return r1
        L_0x00c0:
            r7 = 2
        L_0x00c1:
            if (r15 != r7) goto L_0x0181
            long r7 = r0.zzs
            int r7 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r7 != 0) goto L_0x00cb
            goto L_0x0181
        L_0x00cb:
            long r7 = java.lang.System.nanoTime()
            com.google.android.gms.internal.ads.zzvd r9 = r0.zzf
            long r5 = r5 * r18
            long r5 = r5 + r7
            long r5 = r9.zza(r5)
            long r7 = r5 - r7
            long r7 = r7 / r18
            long r14 = r0.zzt
            r16 = -500000(0xfffffffffff85ee0, double:NaN)
            int r9 = (r7 > r16 ? 1 : (r7 == r16 ? 0 : -1))
            if (r9 >= 0) goto L_0x0110
            if (r35 != 0) goto L_0x0110
            int r1 = r22.zzd(r23)
            if (r1 != 0) goto L_0x00ee
            goto L_0x0110
        L_0x00ee:
            com.google.android.gms.internal.ads.zzfy r2 = r0.zza
            int r3 = r2.zzi
            r4 = 1
            int r3 = r3 + r4
            r2.zzi = r3
            int r3 = r0.zzx
            int r3 = r3 + r1
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x0108
            int r1 = r2.zzf
            int r1 = r1 + r3
            r2.zzf = r1
            goto L_0x010b
        L_0x0108:
            r0.zzax(r3)
        L_0x010b:
            r22.zzar()
            r1 = 0
            return r1
        L_0x0110:
            boolean r1 = zzaF(r7)
            if (r1 == 0) goto L_0x013a
            if (r35 != 0) goto L_0x013a
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r14 > r1 ? 1 : (r14 == r1 ? 0 : -1))
            if (r1 == 0) goto L_0x0126
            r0.zzaw(r3, r4, r11)
            r1 = 1
            goto L_0x0136
        L_0x0126:
            java.lang.String r1 = "dropVideoBuffer"
            com.google.android.gms.internal.ads.zzfl.zza(r1)
            r1 = 0
            r3.zzn(r4, r1)
            com.google.android.gms.internal.ads.zzfl.zzb()
            r1 = 1
            r0.zzax(r1)
        L_0x0136:
            r0.zzay(r7)
            return r1
        L_0x013a:
            int r1 = com.google.android.gms.internal.ads.zzfn.zza
            r2 = 21
            if (r1 < r2) goto L_0x0159
            r1 = 50000(0xc350, double:2.47033E-319)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x017f
            r30 = r22
            r31 = r27
            r32 = r29
            r33 = r11
            r35 = r5
            r30.zzav(r31, r32, r33, r35)
            r0.zzay(r7)
            r1 = 1
            return r1
        L_0x0159:
            r1 = 30000(0x7530, double:1.4822E-319)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x017f
            r1 = 11000(0x2af8, double:5.4347E-320)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x0177
            r1 = -10000(0xffffffffffffd8f0, double:NaN)
            long r1 = r1 + r7
            long r1 = r1 / r18
            java.lang.Thread.sleep(r1)     // Catch:{ InterruptedException -> 0x016e }
            goto L_0x0177
        L_0x016e:
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            r1.interrupt()
            r1 = 0
            return r1
        L_0x0177:
            r0.zzaa(r3, r4, r11)
            r0.zzay(r7)
            r1 = 1
            return r1
        L_0x017f:
            r1 = 0
            return r1
        L_0x0181:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzuv.zzae(long, long, com.google.android.gms.internal.ads.zzof, java.nio.ByteBuffer, int, int, int, long, boolean, boolean, com.google.android.gms.internal.ads.zzab):boolean");
    }

    public final zzog zzaj(Throwable th2, @Nullable zzoh zzoh) {
        return new zzut(th2, zzoh, this.zzl);
    }

    @TargetApi(29)
    public final void zzal(zzda zzda) throws zzgg {
        if (this.zzk) {
            ByteBuffer byteBuffer = zzda.zze;
            byteBuffer.getClass();
            if (byteBuffer.remaining() >= 7) {
                byte b11 = byteBuffer.get();
                short s11 = byteBuffer.getShort();
                short s12 = byteBuffer.getShort();
                byte b12 = byteBuffer.get();
                byte b13 = byteBuffer.get();
                byteBuffer.position(0);
                if (b11 == -75 && s11 == 60 && s12 == 1 && b12 == 4 && b13 == 0) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    zzof zzai = zzai();
                    Bundle bundle = new Bundle();
                    bundle.putByteArray("hdr10-plus-info", bArr);
                    zzai.zzp(bundle);
                }
            }
        }
    }

    @CallSuper
    public final void zzan(long j11) {
        super.zzan(j11);
        this.zzx--;
    }

    @CallSuper
    public final void zzap() {
        super.zzap();
        this.zzx = 0;
    }

    public final boolean zzat(zzoh zzoh) {
        return this.zzl != null || zzaG(zzoh);
    }

    @RequiresApi(21)
    public final void zzav(zzof zzof, int i11, long j11, long j12) {
        zzaC();
        zzfl.zza("releaseOutputBuffer");
        zzof.zzm(i11, j12);
        zzfl.zzb();
        this.zzz = SystemClock.elapsedRealtime() * 1000;
        this.zza.zze++;
        this.zzw = 0;
        zzT();
    }

    public final void zzaw(zzof zzof, int i11, long j11) {
        zzfl.zza("skipVideoBuffer");
        zzof.zzn(i11, false);
        zzfl.zzb();
        this.zza.zzf++;
    }

    public final void zzax(int i11) {
        zzfy zzfy = this.zza;
        zzfy.zzg += i11;
        this.zzv += i11;
        int i12 = this.zzw + i11;
        this.zzw = i12;
        zzfy.zzh = Math.max(i12, zzfy.zzh);
    }

    public final void zzay(long j11) {
        zzfy zzfy = this.zza;
        zzfy.zzj += j11;
        zzfy.zzk++;
        this.zzA += j11;
        this.zzB++;
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzo(int r6, @androidx.annotation.Nullable java.lang.Object r7) throws com.google.android.gms.internal.ads.zzgg {
        /*
            r5 = this;
            r0 = 1
            if (r6 == r0) goto L_0x0044
            r0 = 7
            if (r6 == r0) goto L_0x003f
            r0 = 10
            if (r6 == r0) goto L_0x0032
            r0 = 4
            if (r6 == r0) goto L_0x001e
            r0 = 5
            if (r6 == r0) goto L_0x0012
            goto L_0x00cc
        L_0x0012:
            com.google.android.gms.internal.ads.zzvd r6 = r5.zzf
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r6.zzl(r7)
            return
        L_0x001e:
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r6 = r7.intValue()
            r5.zzo = r6
            com.google.android.gms.internal.ads.zzof r6 = r5.zzai()
            if (r6 == 0) goto L_0x00cc
            int r7 = r5.zzo
            r6.zzq(r7)
            return
        L_0x0032:
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r6 = r7.intValue()
            int r7 = r5.zzH
            if (r7 == r6) goto L_0x00cc
            r5.zzH = r6
            return
        L_0x003f:
            com.google.android.gms.internal.ads.zzuw r7 = (com.google.android.gms.internal.ads.zzuw) r7
            r5.zzI = r7
            return
        L_0x0044:
            boolean r6 = r7 instanceof android.view.Surface
            r0 = 0
            if (r6 == 0) goto L_0x004c
            android.view.Surface r7 = (android.view.Surface) r7
            goto L_0x004d
        L_0x004c:
            r7 = r0
        L_0x004d:
            if (r7 != 0) goto L_0x006b
            com.google.android.gms.internal.ads.zzuq r6 = r5.zzm
            if (r6 == 0) goto L_0x0055
            r7 = r6
            goto L_0x006b
        L_0x0055:
            com.google.android.gms.internal.ads.zzoh r6 = r5.zzak()
            if (r6 == 0) goto L_0x006b
            boolean r1 = r5.zzaG(r6)
            if (r1 == 0) goto L_0x006b
            android.content.Context r7 = r5.zze
            boolean r6 = r6.zzf
            com.google.android.gms.internal.ads.zzuq r7 = com.google.android.gms.internal.ads.zzuq.zza(r7, r6)
            r5.zzm = r7
        L_0x006b:
            android.view.Surface r6 = r5.zzl
            if (r6 == r7) goto L_0x00b8
            r5.zzl = r7
            com.google.android.gms.internal.ads.zzvd r6 = r5.zzf
            r6.zzk(r7)
            r6 = 0
            r5.zzn = r6
            int r1 = r5.zzbm()
            com.google.android.gms.internal.ads.zzof r2 = r5.zzai()
            if (r2 == 0) goto L_0x0099
            int r3 = com.google.android.gms.internal.ads.zzfn.zza
            r4 = 23
            if (r3 < r4) goto L_0x0093
            if (r7 == 0) goto L_0x0093
            boolean r3 = r5.zzj
            if (r3 != 0) goto L_0x0093
            r2.zzo(r7)
            goto L_0x0099
        L_0x0093:
            r5.zzao()
            r5.zzam()
        L_0x0099:
            if (r7 == 0) goto L_0x00b1
            com.google.android.gms.internal.ads.zzuq r2 = r5.zzm
            if (r7 == r2) goto L_0x00b1
            r5.zzaD()
            r5.zzp = r6
            int r6 = com.google.android.gms.internal.ads.zzfn.zza
            r6 = 2
            if (r1 != r6) goto L_0x00cc
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5.zzt = r6
            return
        L_0x00b1:
            r5.zzG = r0
            r5.zzp = r6
            int r6 = com.google.android.gms.internal.ads.zzfn.zza
            return
        L_0x00b8:
            if (r7 == 0) goto L_0x00cc
            com.google.android.gms.internal.ads.zzuq r6 = r5.zzm
            if (r7 == r6) goto L_0x00cc
            r5.zzaD()
            boolean r6 = r5.zzn
            if (r6 == 0) goto L_0x00cc
            com.google.android.gms.internal.ads.zzvo r6 = r5.zzg
            android.view.Surface r7 = r5.zzl
            r6.zzq(r7)
        L_0x00cc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzuv.zzo(int, java.lang.Object):void");
    }

    public final void zzq() {
        this.zzG = null;
        this.zzp = false;
        int i11 = zzfn.zza;
        this.zzn = false;
        this.zzf.zzc();
        try {
            super.zzq();
        } finally {
            this.zzg.zzc(this.zza);
        }
    }

    public final void zzr(boolean z11, boolean z12) throws zzgg {
        super.zzr(z11, z12);
        zzk();
        this.zzg.zze(this.zza);
        this.zzf.zzd();
        this.zzq = z12;
        this.zzr = false;
    }

    public final void zzs(long j11, boolean z11) throws zzgg {
        super.zzs(j11, z11);
        this.zzp = false;
        int i11 = zzfn.zza;
        this.zzf.zzh();
        this.zzy = C.TIME_UNSET;
        this.zzs = C.TIME_UNSET;
        this.zzw = 0;
        this.zzt = C.TIME_UNSET;
    }

    @TargetApi(17)
    public final void zzt() {
        try {
            super.zzt();
            if (this.zzm != null) {
                zzaE();
            }
        } catch (Throwable th2) {
            if (this.zzm != null) {
                zzaE();
            }
            throw th2;
        }
    }

    public final void zzu() {
        this.zzv = 0;
        this.zzu = SystemClock.elapsedRealtime();
        this.zzz = SystemClock.elapsedRealtime() * 1000;
        this.zzA = 0;
        this.zzB = 0;
        this.zzf.zzi();
    }

    public final void zzv() {
        this.zzt = C.TIME_UNSET;
        if (this.zzv > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzg.zzd(this.zzv, elapsedRealtime - this.zzu);
            this.zzv = 0;
            this.zzu = elapsedRealtime;
        }
        int i11 = this.zzB;
        if (i11 != 0) {
            this.zzg.zzr(this.zzA, i11);
            this.zzA = 0;
            this.zzB = 0;
        }
        this.zzf.zzj();
    }
}

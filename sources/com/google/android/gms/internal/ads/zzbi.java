package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.bytebuddy.jar.asm.Opcodes;

public final class zzbi {
    private static final ArrayList<zzbg> zza = new ArrayList<>();
    private static final Pattern zzb = Pattern.compile("^mp4a\\.([a-zA-Z0-9]{2})(?:\\.([0-9]{1,2}))?$");

    public static int zza(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (zzg(str)) {
            return 1;
        }
        if (zzh(str)) {
            return 2;
        }
        if ("text".equals(zzi(str)) || MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str) || MimeTypes.APPLICATION_MP4CEA608.equals(str) || MimeTypes.APPLICATION_SUBRIP.equals(str) || MimeTypes.APPLICATION_TTML.equals(str) || MimeTypes.APPLICATION_TX3G.equals(str) || MimeTypes.APPLICATION_MP4VTT.equals(str) || MimeTypes.APPLICATION_RAWCC.equals(str) || MimeTypes.APPLICATION_VOBSUB.equals(str) || MimeTypes.APPLICATION_PGS.equals(str) || MimeTypes.APPLICATION_DVBSUBS.equals(str)) {
            return 3;
        }
        if ("image".equals(zzi(str))) {
            return 4;
        }
        if (MimeTypes.APPLICATION_ID3.equals(str) || MimeTypes.APPLICATION_EMSG.equals(str) || MimeTypes.APPLICATION_SCTE35.equals(str)) {
            return 5;
        }
        if (MimeTypes.APPLICATION_CAMERA_MOTION.equals(str)) {
            return 6;
        }
        int size = zza.size();
        for (int i11 = 0; i11 < size; i11++) {
            String str2 = zza.get(i11).zza;
            if (str.equals((Object) null)) {
                return 0;
            }
        }
        return -1;
    }

    @VisibleForTesting
    @Nullable
    public static zzbh zzb(String str) {
        int i11;
        Matcher matcher = zzb.matcher(str);
        if (!matcher.matches()) {
            return null;
        }
        String group = matcher.group(1);
        group.getClass();
        String group2 = matcher.group(2);
        try {
            int parseInt = Integer.parseInt(group, 16);
            if (group2 != null) {
                i11 = Integer.parseInt(group2);
            } else {
                i11 = 0;
            }
            return new zzbh(parseInt, i11);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    @Nullable
    public static String zzc(@Nullable String str) {
        zzbh zzb2;
        String zza2 = zzfpn.zza(str.trim());
        if (zza2.startsWith("avc1") || zza2.startsWith("avc3")) {
            return MimeTypes.VIDEO_H264;
        }
        if (zza2.startsWith("hev1") || zza2.startsWith("hvc1")) {
            return MimeTypes.VIDEO_H265;
        }
        if (zza2.startsWith("dvav") || zza2.startsWith("dva1") || zza2.startsWith("dvhe") || zza2.startsWith("dvh1")) {
            return MimeTypes.VIDEO_DOLBY_VISION;
        }
        if (zza2.startsWith("av01")) {
            return MimeTypes.VIDEO_AV1;
        }
        if (zza2.startsWith("vp9") || zza2.startsWith("vp09")) {
            return MimeTypes.VIDEO_VP9;
        }
        if (zza2.startsWith("vp8") || zza2.startsWith("vp08")) {
            return MimeTypes.VIDEO_VP8;
        }
        String str2 = null;
        if (zza2.startsWith("mp4a")) {
            if (zza2.startsWith("mp4a.") && (zzb2 = zzb(zza2)) != null) {
                str2 = zzd(zzb2.zza);
            }
            if (str2 == null) {
                return MimeTypes.AUDIO_AAC;
            }
            return str2;
        } else if (zza2.startsWith("mha1")) {
            return MimeTypes.AUDIO_MPEGH_MHA1;
        } else {
            if (zza2.startsWith("mhm1")) {
                return MimeTypes.AUDIO_MPEGH_MHM1;
            }
            if (zza2.startsWith("ac-3") || zza2.startsWith("dac3")) {
                return MimeTypes.AUDIO_AC3;
            }
            if (zza2.startsWith("ec-3") || zza2.startsWith("dec3")) {
                return MimeTypes.AUDIO_E_AC3;
            }
            if (zza2.startsWith(MimeTypes.CODEC_E_AC3_JOC)) {
                return MimeTypes.AUDIO_E_AC3_JOC;
            }
            if (zza2.startsWith("ac-4") || zza2.startsWith("dac4")) {
                return MimeTypes.AUDIO_AC4;
            }
            if (zza2.startsWith("dtsc")) {
                return MimeTypes.AUDIO_DTS;
            }
            if (zza2.startsWith("dtse")) {
                return MimeTypes.AUDIO_DTS_EXPRESS;
            }
            if (zza2.startsWith("dtsh") || zza2.startsWith("dtsl")) {
                return MimeTypes.AUDIO_DTS_HD;
            }
            if (zza2.startsWith("dtsx")) {
                return MimeTypes.AUDIO_DTS_X;
            }
            if (zza2.startsWith("opus")) {
                return MimeTypes.AUDIO_OPUS;
            }
            if (zza2.startsWith("vorbis")) {
                return MimeTypes.AUDIO_VORBIS;
            }
            if (zza2.startsWith("flac")) {
                return MimeTypes.AUDIO_FLAC;
            }
            if (zza2.startsWith("stpp")) {
                return MimeTypes.APPLICATION_TTML;
            }
            if (zza2.startsWith("wvtt")) {
                return MimeTypes.TEXT_VTT;
            }
            if (zza2.contains("cea708")) {
                return MimeTypes.APPLICATION_CEA708;
            }
            if (zza2.contains("eia608") || zza2.contains("cea608")) {
                return MimeTypes.APPLICATION_CEA608;
            }
            int size = zza.size();
            for (int i11 = 0; i11 < size; i11++) {
                String str3 = zza.get(i11).zzb;
                if (zza2.startsWith((String) null)) {
                    break;
                }
            }
            return null;
        }
    }

    @Nullable
    public static String zzd(int i11) {
        if (i11 == 32) {
            return MimeTypes.VIDEO_MP4V;
        }
        if (i11 == 33) {
            return MimeTypes.VIDEO_H264;
        }
        if (i11 == 35) {
            return MimeTypes.VIDEO_H265;
        }
        if (i11 == 64) {
            return MimeTypes.AUDIO_AAC;
        }
        if (i11 == 163) {
            return MimeTypes.VIDEO_VC1;
        }
        if (i11 == 177) {
            return MimeTypes.VIDEO_VP9;
        }
        if (i11 == 165) {
            return MimeTypes.AUDIO_AC3;
        }
        if (i11 == 166) {
            return MimeTypes.AUDIO_E_AC3;
        }
        switch (i11) {
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
                return MimeTypes.VIDEO_MPEG2;
            case 102:
            case 103:
            case 104:
                return MimeTypes.AUDIO_AAC;
            case 105:
            case 107:
                return MimeTypes.AUDIO_MPEG;
            case 106:
                return MimeTypes.VIDEO_MPEG;
            default:
                switch (i11) {
                    case Opcodes.RET:
                    case 172:
                        return MimeTypes.AUDIO_DTS;
                    case Opcodes.TABLESWITCH:
                    case Opcodes.LOOKUPSWITCH:
                        return MimeTypes.AUDIO_DTS_HD;
                    case Opcodes.LRETURN:
                        return MimeTypes.AUDIO_OPUS;
                    case Opcodes.FRETURN:
                        return MimeTypes.AUDIO_AC4;
                    default:
                        return null;
                }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0042 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String zze(java.lang.String r4) {
        /*
            int r0 = r4.hashCode()
            r1 = -1007807498(0xffffffffc3ee13f6, float:-476.15594)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = -586683234(0xffffffffdd07ec9e, float:-6.1214856E17)
            if (r0 == r1) goto L_0x0020
            r1 = 187090231(0xb26c537, float:3.2118805E-32)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "audio/mp3"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0034
            r0 = r3
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "audio/x-wav"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0034
            r0 = r2
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "audio/x-flac"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0034
            r0 = 0
            goto L_0x0035
        L_0x0034:
            r0 = -1
        L_0x0035:
            if (r0 == 0) goto L_0x0042
            if (r0 == r3) goto L_0x003f
            if (r0 == r2) goto L_0x003c
            return r4
        L_0x003c:
            java.lang.String r4 = "audio/wav"
            return r4
        L_0x003f:
            java.lang.String r4 = "audio/mpeg"
            return r4
        L_0x0042:
            java.lang.String r4 = "audio/flac"
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbi.zze(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zzf(@androidx.annotation.Nullable java.lang.String r6, @androidx.annotation.Nullable java.lang.String r7) {
        /*
            r0 = 0
            if (r6 != 0) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = r6.hashCode()
            r2 = 5
            r3 = 10
            r4 = 2
            r5 = 1
            switch(r1) {
                case -2123537834: goto L_0x0079;
                case -432837260: goto L_0x006f;
                case -432837259: goto L_0x0065;
                case -53558318: goto L_0x005b;
                case 187078296: goto L_0x0051;
                case 187094639: goto L_0x0047;
                case 1504578661: goto L_0x003c;
                case 1504619009: goto L_0x0032;
                case 1504831518: goto L_0x0028;
                case 1903231877: goto L_0x001d;
                case 1903589369: goto L_0x0012;
                default: goto L_0x0010;
            }
        L_0x0010:
            goto L_0x0084
        L_0x0012:
            java.lang.String r1 = "audio/g711-mlaw"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x0084
            r6 = r2
            goto L_0x0085
        L_0x001d:
            java.lang.String r1 = "audio/g711-alaw"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x0084
            r6 = 4
            goto L_0x0085
        L_0x0028:
            java.lang.String r1 = "audio/mpeg"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x0084
            r6 = r0
            goto L_0x0085
        L_0x0032:
            java.lang.String r1 = "audio/flac"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x0084
            r6 = 6
            goto L_0x0085
        L_0x003c:
            java.lang.String r1 = "audio/eac3"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x0084
            r6 = 8
            goto L_0x0085
        L_0x0047:
            java.lang.String r1 = "audio/raw"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x0084
            r6 = 3
            goto L_0x0085
        L_0x0051:
            java.lang.String r1 = "audio/ac3"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x0084
            r6 = 7
            goto L_0x0085
        L_0x005b:
            java.lang.String r1 = "audio/mp4a-latm"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x0084
            r6 = r3
            goto L_0x0085
        L_0x0065:
            java.lang.String r1 = "audio/mpeg-L2"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x0084
            r6 = r4
            goto L_0x0085
        L_0x006f:
            java.lang.String r1 = "audio/mpeg-L1"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x0084
            r6 = r5
            goto L_0x0085
        L_0x0079:
            java.lang.String r1 = "audio/eac3-joc"
            boolean r6 = r6.equals(r1)
            if (r6 == 0) goto L_0x0084
            r6 = 9
            goto L_0x0085
        L_0x0084:
            r6 = -1
        L_0x0085:
            switch(r6) {
                case 0: goto L_0x00c0;
                case 1: goto L_0x00c0;
                case 2: goto L_0x00c0;
                case 3: goto L_0x00c0;
                case 4: goto L_0x00c0;
                case 5: goto L_0x00c0;
                case 6: goto L_0x00c0;
                case 7: goto L_0x00c0;
                case 8: goto L_0x00c0;
                case 9: goto L_0x00c0;
                case 10: goto L_0x0089;
                default: goto L_0x0088;
            }
        L_0x0088:
            return r0
        L_0x0089:
            if (r7 != 0) goto L_0x008c
            return r0
        L_0x008c:
            com.google.android.gms.internal.ads.zzbh r6 = zzb(r7)
            if (r6 != 0) goto L_0x0093
            return r0
        L_0x0093:
            int r6 = r6.zzb
            r7 = 16
            if (r6 == r4) goto L_0x00ba
            if (r6 == r2) goto L_0x00b8
            r1 = 29
            if (r6 == r1) goto L_0x00b5
            r1 = 42
            if (r6 == r1) goto L_0x00b3
            r1 = 22
            if (r6 == r1) goto L_0x00b0
            r1 = 23
            if (r6 == r1) goto L_0x00ad
            r3 = r0
            goto L_0x00ba
        L_0x00ad:
            r3 = 15
            goto L_0x00ba
        L_0x00b0:
            r3 = 1073741824(0x40000000, float:2.0)
            goto L_0x00ba
        L_0x00b3:
            r3 = r7
            goto L_0x00ba
        L_0x00b5:
            r3 = 12
            goto L_0x00ba
        L_0x00b8:
            r3 = 11
        L_0x00ba:
            if (r3 == 0) goto L_0x00bf
            if (r3 == r7) goto L_0x00bf
            return r5
        L_0x00bf:
            return r0
        L_0x00c0:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbi.zzf(java.lang.String, java.lang.String):boolean");
    }

    public static boolean zzg(@Nullable String str) {
        return MimeTypes.BASE_TYPE_AUDIO.equals(zzi(str));
    }

    public static boolean zzh(@Nullable String str) {
        return "video".equals(zzi(str));
    }

    @Nullable
    private static String zzi(@Nullable String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(47)) == -1) {
            return null;
        }
        return str.substring(0, indexOf);
    }
}

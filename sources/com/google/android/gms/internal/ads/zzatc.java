package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.util.Pair;
import com.google.android.exoplayer2.util.MimeTypes;
import com.huawei.hms.flutter.map.constants.Param;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

@TargetApi(16)
public final class zzatc {
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;
    public final boolean zzd;
    private final String zze;
    private final MediaCodecInfo.CodecCapabilities zzf;

    private zzatc(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z11, boolean z12) {
        boolean z13;
        boolean z14;
        str.getClass();
        this.zza = str;
        this.zze = str2;
        this.zzf = codecCapabilities;
        boolean z15 = true;
        if (z11 || codecCapabilities == null || zzaxb.zza < 19 || !codecCapabilities.isFeatureSupported("adaptive-playback")) {
            z13 = false;
        } else {
            z13 = true;
        }
        this.zzb = z13;
        if (codecCapabilities == null || zzaxb.zza < 21 || !codecCapabilities.isFeatureSupported("tunneled-playback")) {
            z14 = false;
        } else {
            z14 = true;
        }
        this.zzc = z14;
        if (!z12 && (codecCapabilities == null || zzaxb.zza < 21 || !codecCapabilities.isFeatureSupported("secure-playback"))) {
            z15 = false;
        }
        this.zzd = z15;
    }

    public static zzatc zza(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z11, boolean z12) {
        return new zzatc(str, str2, codecCapabilities, z11, z12);
    }

    public static zzatc zzb(String str) {
        return new zzatc("OMX.google.raw.decoder", (String) null, (MediaCodecInfo.CodecCapabilities) null, false, false);
    }

    private final void zzh(String str) {
        String str2 = this.zza;
        String str3 = this.zze;
        String str4 = zzaxb.zze;
        int length = String.valueOf(str2).length();
        int length2 = String.valueOf(str3).length();
        StringBuilder sb2 = new StringBuilder(str.length() + 20 + length + length2 + String.valueOf(str4).length());
        sb2.append("NoSupport [");
        sb2.append(str);
        sb2.append("] [");
        sb2.append(str2);
        sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb2.append(str3);
        sb2.append("] [");
        sb2.append(str4);
        sb2.append("]");
    }

    @TargetApi(21)
    private static boolean zzi(MediaCodecInfo.VideoCapabilities videoCapabilities, int i11, int i12, double d11) {
        if (d11 == -1.0d || d11 <= 0.0d) {
            return videoCapabilities.isSizeSupported(i11, i12);
        }
        return videoCapabilities.areSizeAndRateSupported(i11, i12, d11);
    }

    @TargetApi(21)
    public final boolean zzc(int i11) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzf;
        if (codecCapabilities == null) {
            zzh("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            zzh("channelCount.aCaps");
            return false;
        } else if (audioCapabilities.getMaxInputChannelCount() >= i11) {
            return true;
        } else {
            StringBuilder sb2 = new StringBuilder(33);
            sb2.append("channelCount.support, ");
            sb2.append(i11);
            zzh(sb2.toString());
            return false;
        }
    }

    @TargetApi(21)
    public final boolean zzd(int i11) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzf;
        if (codecCapabilities == null) {
            zzh("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            zzh("sampleRate.aCaps");
            return false;
        } else if (audioCapabilities.isSampleRateSupported(i11)) {
            return true;
        } else {
            StringBuilder sb2 = new StringBuilder(31);
            sb2.append("sampleRate.support, ");
            sb2.append(i11);
            zzh(sb2.toString());
            return false;
        }
    }

    public final boolean zze(String str) {
        String str2;
        if (str == null || this.zze == null) {
            return true;
        }
        String trim = str.trim();
        if (trim.startsWith("avc1") || trim.startsWith("avc3")) {
            str2 = MimeTypes.VIDEO_H264;
        } else if (trim.startsWith("hev1") || trim.startsWith("hvc1")) {
            str2 = MimeTypes.VIDEO_H265;
        } else if (trim.startsWith("vp9")) {
            str2 = MimeTypes.VIDEO_VP9;
        } else if (trim.startsWith("vp8")) {
            str2 = MimeTypes.VIDEO_VP8;
        } else if (trim.startsWith("mp4a")) {
            str2 = MimeTypes.AUDIO_AAC;
        } else if (trim.startsWith("ac-3") || trim.startsWith("dac3")) {
            str2 = MimeTypes.AUDIO_AC3;
        } else if (trim.startsWith("ec-3") || trim.startsWith("dec3")) {
            str2 = MimeTypes.AUDIO_E_AC3;
        } else if (trim.startsWith("dtsc") || trim.startsWith("dtse")) {
            str2 = MimeTypes.AUDIO_DTS;
        } else if (trim.startsWith("dtsh") || trim.startsWith("dtsl")) {
            str2 = MimeTypes.AUDIO_DTS_HD;
        } else if (trim.startsWith("opus")) {
            str2 = MimeTypes.AUDIO_OPUS;
        } else if (trim.startsWith("vorbis")) {
            str2 = MimeTypes.AUDIO_VORBIS;
        } else {
            str2 = null;
        }
        if (str2 == null) {
            return true;
        }
        if (!this.zze.equals(str2)) {
            StringBuilder sb2 = new StringBuilder(str.length() + 13 + str2.length());
            sb2.append("codec.mime ");
            sb2.append(str);
            sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            sb2.append(str2);
            zzh(sb2.toString());
            return false;
        }
        Pair<Integer, Integer> zzb2 = zzato.zzb(str);
        if (zzb2 == null) {
            return true;
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : zzg()) {
            if (codecProfileLevel.profile == ((Integer) zzb2.first).intValue() && codecProfileLevel.level >= ((Integer) zzb2.second).intValue()) {
                return true;
            }
        }
        StringBuilder sb3 = new StringBuilder(str.length() + 22 + str2.length());
        sb3.append("codec.profileLevel, ");
        sb3.append(str);
        sb3.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
        sb3.append(str2);
        zzh(sb3.toString());
        return false;
    }

    @TargetApi(21)
    public final boolean zzf(int i11, int i12, double d11) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzf;
        if (codecCapabilities == null) {
            zzh("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            zzh("sizeAndRate.vCaps");
            return false;
        } else if (zzi(videoCapabilities, i11, i12, d11)) {
            return true;
        } else {
            if (i11 >= i12 || !zzi(videoCapabilities, i12, i11, d11)) {
                StringBuilder sb2 = new StringBuilder(69);
                sb2.append("sizeAndRate.support, ");
                sb2.append(i11);
                sb2.append(Param.X);
                sb2.append(i12);
                sb2.append(Param.X);
                sb2.append(d11);
                zzh(sb2.toString());
                return false;
            }
            StringBuilder sb3 = new StringBuilder(69);
            sb3.append("sizeAndRate.rotated, ");
            sb3.append(i11);
            sb3.append(Param.X);
            sb3.append(i12);
            sb3.append(Param.X);
            sb3.append(d11);
            String sb4 = sb3.toString();
            String str = this.zza;
            String str2 = this.zze;
            String str3 = zzaxb.zze;
            int length = String.valueOf(str).length();
            int length2 = String.valueOf(str2).length();
            StringBuilder sb5 = new StringBuilder(sb4.length() + 25 + length + length2 + String.valueOf(str3).length());
            sb5.append("AssumedSupport [");
            sb5.append(sb4);
            sb5.append("] [");
            sb5.append(str);
            sb5.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            sb5.append(str2);
            sb5.append("] [");
            sb5.append(str3);
            sb5.append("]");
            return true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.profileLevels;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.media.MediaCodecInfo.CodecProfileLevel[] zzg() {
        /*
            r1 = this;
            android.media.MediaCodecInfo$CodecCapabilities r0 = r1.zzf
            if (r0 == 0) goto L_0x0008
            android.media.MediaCodecInfo$CodecProfileLevel[] r0 = r0.profileLevels
            if (r0 != 0) goto L_0x000b
        L_0x0008:
            r0 = 0
            android.media.MediaCodecInfo$CodecProfileLevel[] r0 = new android.media.MediaCodecInfo.CodecProfileLevel[r0]
        L_0x000b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzatc.zzg():android.media.MediaCodecInfo$CodecProfileLevel[]");
    }
}

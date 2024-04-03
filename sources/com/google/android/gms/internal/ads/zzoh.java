package com.google.android.gms.internal.ads;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.util.MimeTypes;
import com.huawei.hms.flutter.map.constants.Param;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class zzoh {
    public final String zza;
    public final String zzb;
    public final String zzc;
    @Nullable
    public final MediaCodecInfo.CodecCapabilities zzd;
    public final boolean zze;
    public final boolean zzf;
    private final boolean zzg;

    @VisibleForTesting
    public zzoh(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        str.getClass();
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = codecCapabilities;
        this.zze = z14;
        this.zzf = z16;
        this.zzg = zzbi.zzh(str2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
        if ("Nexus 10".equals(r3) == false) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003a, code lost:
        if ("OMX.Exynos.AVC.Decoder.secure".equals(r12) == false) goto L_0x003d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzoh zzc(java.lang.String r12, java.lang.String r13, java.lang.String r14, @androidx.annotation.Nullable android.media.MediaCodecInfo.CodecCapabilities r15, boolean r16, boolean r17, boolean r18, boolean r19, boolean r20) {
        /*
            r1 = r12
            r4 = r15
            com.google.android.gms.internal.ads.zzoh r11 = new com.google.android.gms.internal.ads.zzoh
            r0 = 1
            r2 = 0
            if (r4 == 0) goto L_0x003f
            int r3 = com.google.android.gms.internal.ads.zzfn.zza
            r5 = 19
            if (r3 < r5) goto L_0x003f
            java.lang.String r5 = "adaptive-playback"
            boolean r5 = r15.isFeatureSupported(r5)
            if (r5 == 0) goto L_0x003f
            r5 = 22
            if (r3 > r5) goto L_0x003d
            java.lang.String r3 = com.google.android.gms.internal.ads.zzfn.zzd
            java.lang.String r5 = "ODROID-XU3"
            boolean r5 = r5.equals(r3)
            if (r5 != 0) goto L_0x002c
            java.lang.String r5 = "Nexus 10"
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x003d
        L_0x002c:
            java.lang.String r3 = "OMX.Exynos.AVC.Decoder"
            boolean r3 = r3.equals(r12)
            if (r3 != 0) goto L_0x003f
            java.lang.String r3 = "OMX.Exynos.AVC.Decoder.secure"
            boolean r3 = r3.equals(r12)
            if (r3 == 0) goto L_0x003d
            goto L_0x003f
        L_0x003d:
            r8 = r0
            goto L_0x0040
        L_0x003f:
            r8 = r2
        L_0x0040:
            r3 = 21
            if (r4 == 0) goto L_0x0052
            int r5 = com.google.android.gms.internal.ads.zzfn.zza
            if (r5 < r3) goto L_0x0052
            java.lang.String r5 = "tunneled-playback"
            boolean r5 = r15.isFeatureSupported(r5)
            if (r5 == 0) goto L_0x0052
            r9 = r0
            goto L_0x0053
        L_0x0052:
            r9 = r2
        L_0x0053:
            if (r20 != 0) goto L_0x0066
            if (r4 == 0) goto L_0x0064
            int r5 = com.google.android.gms.internal.ads.zzfn.zza
            if (r5 < r3) goto L_0x0064
            java.lang.String r3 = "secure-playback"
            boolean r3 = r15.isFeatureSupported(r3)
            if (r3 == 0) goto L_0x0064
            goto L_0x0066
        L_0x0064:
            r10 = r2
            goto L_0x0067
        L_0x0066:
            r10 = r0
        L_0x0067:
            r0 = r11
            r1 = r12
            r2 = r13
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzoh.zzc(java.lang.String, java.lang.String, java.lang.String, android.media.MediaCodecInfo$CodecCapabilities, boolean, boolean, boolean, boolean, boolean):com.google.android.gms.internal.ads.zzoh");
    }

    @RequiresApi(21)
    private static Point zzh(MediaCodecInfo.VideoCapabilities videoCapabilities, int i11, int i12) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(zzfn.zze(i11, widthAlignment) * widthAlignment, zzfn.zze(i12, heightAlignment) * heightAlignment);
    }

    private final void zzi(String str) {
        String str2 = this.zza;
        String str3 = this.zzb;
        String str4 = zzfn.zze;
        int length = String.valueOf(str2).length();
        StringBuilder sb2 = new StringBuilder(str.length() + 20 + length + str3.length() + String.valueOf(str4).length());
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

    @RequiresApi(21)
    private static boolean zzj(MediaCodecInfo.VideoCapabilities videoCapabilities, int i11, int i12, double d11) {
        Point zzh = zzh(videoCapabilities, i11, i12);
        int i13 = zzh.x;
        int i14 = zzh.y;
        if (d11 == -1.0d || d11 < 1.0d) {
            return videoCapabilities.isSizeSupported(i13, i14);
        }
        return videoCapabilities.areSizeAndRateSupported(i13, i14, Math.floor(d11));
    }

    public final String toString() {
        return this.zza;
    }

    @RequiresApi(21)
    @Nullable
    public final Point zza(int i11, int i12) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return zzh(videoCapabilities, i11, i12);
    }

    public final zzfz zzb(zzab zzab, zzab zzab2) {
        int i11;
        int i12;
        if (true != zzfn.zzP(zzab.zzm, zzab2.zzm)) {
            i11 = 8;
        } else {
            i11 = 0;
        }
        if (this.zzg) {
            if (zzab.zzu != zzab2.zzu) {
                i11 |= 1024;
            }
            if (!this.zze && !(zzab.zzr == zzab2.zzr && zzab.zzs == zzab2.zzs)) {
                i11 |= 512;
            }
            if (!zzfn.zzP(zzab.zzy, zzab2.zzy)) {
                i11 |= 2048;
            }
            String str = this.zza;
            if (zzfn.zzd.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str) && !zzab.zzd(zzab2)) {
                i11 |= 2;
            }
            if (i11 == 0) {
                String str2 = this.zza;
                if (true != zzab.zzd(zzab2)) {
                    i12 = 2;
                } else {
                    i12 = 3;
                }
                return new zzfz(str2, zzab, zzab2, i12, 0);
            }
        } else {
            if (zzab.zzz != zzab2.zzz) {
                i11 |= 4096;
            }
            if (zzab.zzA != zzab2.zzA) {
                i11 |= 8192;
            }
            if (zzab.zzB != zzab2.zzB) {
                i11 |= 16384;
            }
            if (i11 == 0 && MimeTypes.AUDIO_AAC.equals(this.zzb)) {
                Pair<Integer, Integer> zzb2 = zzoy.zzb(zzab);
                Pair<Integer, Integer> zzb3 = zzoy.zzb(zzab2);
                if (!(zzb2 == null || zzb3 == null)) {
                    int intValue = ((Integer) zzb2.first).intValue();
                    int intValue2 = ((Integer) zzb3.first).intValue();
                    if (intValue == 42 && intValue2 == 42) {
                        return new zzfz(this.zza, zzab, zzab2, 3, 0);
                    }
                }
            }
            if (!zzab.zzd(zzab2)) {
                i11 |= 32;
            }
            if (MimeTypes.AUDIO_OPUS.equals(this.zzb)) {
                i11 |= 2;
            }
            if (i11 == 0) {
                return new zzfz(this.zza, zzab, zzab2, 1, 0);
            }
        }
        return new zzfz(this.zza, zzab, zzab2, 0, i11);
    }

    public final boolean zzd(zzab zzab) throws zzos {
        int i11;
        String zzc2;
        int i12;
        int i13;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        String str = zzab.zzj;
        int i14 = 16;
        boolean z11 = false;
        if (!(str == null || (zzc2 = zzbi.zzc(str)) == null)) {
            if (!this.zzb.equals(zzc2)) {
                String str2 = zzab.zzj;
                StringBuilder sb2 = new StringBuilder(String.valueOf(str2).length() + 13 + zzc2.length());
                sb2.append("codec.mime ");
                sb2.append(str2);
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                sb2.append(zzc2);
                zzi(sb2.toString());
            } else {
                Pair<Integer, Integer> zzb2 = zzoy.zzb(zzab);
                if (zzb2 != null) {
                    int intValue = ((Integer) zzb2.first).intValue();
                    int intValue2 = ((Integer) zzb2.second).intValue();
                    if (!this.zzg) {
                        if (intValue == 42) {
                            intValue = 42;
                        }
                    }
                    MediaCodecInfo.CodecProfileLevel[] zzg2 = zzg();
                    if (zzfn.zza <= 23 && MimeTypes.VIDEO_VP9.equals(this.zzb) && zzg2.length == 0) {
                        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
                        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
                            i12 = 0;
                        } else {
                            i12 = videoCapabilities.getBitrateRange().getUpper().intValue();
                        }
                        if (i12 >= 180000000) {
                            i13 = 1024;
                        } else if (i12 >= 120000000) {
                            i13 = 512;
                        } else if (i12 >= 60000000) {
                            i13 = 256;
                        } else if (i12 >= 30000000) {
                            i13 = 128;
                        } else if (i12 >= 18000000) {
                            i13 = 64;
                        } else if (i12 >= 12000000) {
                            i13 = 32;
                        } else if (i12 >= 7200000) {
                            i13 = 16;
                        } else if (i12 >= 3600000) {
                            i13 = 8;
                        } else if (i12 >= 1800000) {
                            i13 = 4;
                        } else if (i12 >= 800000) {
                            i13 = 2;
                        } else {
                            i13 = 1;
                        }
                        MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
                        codecProfileLevel.profile = 1;
                        codecProfileLevel.level = i13;
                        zzg2 = new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel};
                    }
                    int length = zzg2.length;
                    int i15 = 0;
                    while (i15 < length) {
                        MediaCodecInfo.CodecProfileLevel codecProfileLevel2 = zzg2[i15];
                        if (codecProfileLevel2.profile != intValue || codecProfileLevel2.level < intValue2) {
                            i15++;
                        }
                    }
                    String str3 = zzab.zzj;
                    StringBuilder sb3 = new StringBuilder(String.valueOf(str3).length() + 22 + zzc2.length());
                    sb3.append("codec.profileLevel, ");
                    sb3.append(str3);
                    sb3.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                    sb3.append(zzc2);
                    zzi(sb3.toString());
                }
            }
            return false;
        }
        if (this.zzg) {
            int i16 = zzab.zzr;
            if (i16 <= 0 || (i11 = zzab.zzs) <= 0) {
                return true;
            }
            if (zzfn.zza >= 21) {
                return zzf(i16, i11, (double) zzab.zzt);
            }
            if (i16 * i11 <= zzoy.zza()) {
                z11 = true;
            }
            if (!z11) {
                int i17 = zzab.zzr;
                int i18 = zzab.zzs;
                StringBuilder sb4 = new StringBuilder(40);
                sb4.append("legacyFrameSize, ");
                sb4.append(i17);
                sb4.append(Param.X);
                sb4.append(i18);
                zzi(sb4.toString());
            }
            return z11;
        }
        int i19 = zzfn.zza;
        if (i19 >= 21) {
            int i21 = zzab.zzA;
            if (i21 != -1) {
                MediaCodecInfo.CodecCapabilities codecCapabilities2 = this.zzd;
                if (codecCapabilities2 == null) {
                    zzi("sampleRate.caps");
                    return false;
                }
                MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities2.getAudioCapabilities();
                if (audioCapabilities == null) {
                    zzi("sampleRate.aCaps");
                    return false;
                } else if (!audioCapabilities.isSampleRateSupported(i21)) {
                    StringBuilder sb5 = new StringBuilder(31);
                    sb5.append("sampleRate.support, ");
                    sb5.append(i21);
                    zzi(sb5.toString());
                    return false;
                }
            }
            int i22 = zzab.zzz;
            if (i22 != -1) {
                MediaCodecInfo.CodecCapabilities codecCapabilities3 = this.zzd;
                if (codecCapabilities3 == null) {
                    zzi("channelCount.caps");
                } else {
                    MediaCodecInfo.AudioCapabilities audioCapabilities2 = codecCapabilities3.getAudioCapabilities();
                    if (audioCapabilities2 == null) {
                        zzi("channelCount.aCaps");
                    } else {
                        String str4 = this.zza;
                        String str5 = this.zzb;
                        int maxInputChannelCount = audioCapabilities2.getMaxInputChannelCount();
                        if (maxInputChannelCount <= 1 && ((i19 < 26 || maxInputChannelCount <= 0) && !MimeTypes.AUDIO_MPEG.equals(str5) && !MimeTypes.AUDIO_AMR_NB.equals(str5) && !MimeTypes.AUDIO_AMR_WB.equals(str5) && !MimeTypes.AUDIO_AAC.equals(str5) && !MimeTypes.AUDIO_VORBIS.equals(str5) && !MimeTypes.AUDIO_OPUS.equals(str5) && !MimeTypes.AUDIO_RAW.equals(str5) && !MimeTypes.AUDIO_FLAC.equals(str5) && !MimeTypes.AUDIO_ALAW.equals(str5) && !MimeTypes.AUDIO_MLAW.equals(str5) && !MimeTypes.AUDIO_MSGSM.equals(str5))) {
                            if (MimeTypes.AUDIO_AC3.equals(str5)) {
                                i14 = 6;
                            } else if (!MimeTypes.AUDIO_E_AC3.equals(str5)) {
                                i14 = 30;
                            }
                            StringBuilder sb6 = new StringBuilder(String.valueOf(str4).length() + 59);
                            sb6.append("AssumedMaxChannelAdjustment: ");
                            sb6.append(str4);
                            sb6.append(", [");
                            sb6.append(maxInputChannelCount);
                            sb6.append(" to ");
                            sb6.append(i14);
                            sb6.append("]");
                            Log.w(com.google.android.exoplayer2.mediacodec.MediaCodecInfo.TAG, sb6.toString());
                            maxInputChannelCount = i14;
                        }
                        if (maxInputChannelCount < i22) {
                            StringBuilder sb7 = new StringBuilder(33);
                            sb7.append("channelCount.support, ");
                            sb7.append(i22);
                            zzi(sb7.toString());
                        }
                    }
                }
                return false;
            }
        }
        return true;
    }

    public final boolean zze(zzab zzab) {
        if (this.zzg) {
            return this.zze;
        }
        Pair<Integer, Integer> zzb2 = zzoy.zzb(zzab);
        if (zzb2 == null || ((Integer) zzb2.first).intValue() != 42) {
            return false;
        }
        return true;
    }

    @RequiresApi(21)
    public final boolean zzf(int i11, int i12, double d11) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzd;
        if (codecCapabilities == null) {
            zzi("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            zzi("sizeAndRate.vCaps");
            return false;
        } else if (zzj(videoCapabilities, i11, i12, d11)) {
            return true;
        } else {
            if (i11 >= i12 || (("OMX.MTK.VIDEO.DECODER.HEVC".equals(this.zza) && "mcv5a".equals(zzfn.zzb)) || !zzj(videoCapabilities, i12, i11, d11))) {
                StringBuilder sb2 = new StringBuilder(69);
                sb2.append("sizeAndRate.support, ");
                sb2.append(i11);
                sb2.append(Param.X);
                sb2.append(i12);
                sb2.append(Param.X);
                sb2.append(d11);
                zzi(sb2.toString());
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
            String str2 = this.zzb;
            String str3 = zzfn.zze;
            int length = String.valueOf(str).length();
            StringBuilder sb5 = new StringBuilder(sb4.length() + 25 + length + str2.length() + String.valueOf(str3).length());
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
            android.media.MediaCodecInfo$CodecCapabilities r0 = r1.zzd
            if (r0 == 0) goto L_0x0008
            android.media.MediaCodecInfo$CodecProfileLevel[] r0 = r0.profileLevels
            if (r0 != 0) goto L_0x000b
        L_0x0008:
            r0 = 0
            android.media.MediaCodecInfo$CodecProfileLevel[] r0 = new android.media.MediaCodecInfo.CodecProfileLevel[r0]
        L_0x000b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzoh.zzg():android.media.MediaCodecInfo$CodecProfileLevel[]");
    }
}

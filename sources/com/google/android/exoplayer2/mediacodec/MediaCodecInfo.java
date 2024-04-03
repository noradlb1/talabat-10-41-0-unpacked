package com.google.android.exoplayer2.mediacodec;

import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Pair;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.List;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class MediaCodecInfo {
    private static final int COVERAGE_RESULT_NO = 1;
    private static final int COVERAGE_RESULT_NO_EMPTY_LIST = 0;
    private static final int COVERAGE_RESULT_YES = 2;
    public static final int MAX_SUPPORTED_INSTANCES_UNKNOWN = -1;
    public static final String TAG = "MediaCodecInfo";
    public final boolean adaptive;
    @Nullable
    public final MediaCodecInfo.CodecCapabilities capabilities;
    public final String codecMimeType;
    public final boolean hardwareAccelerated;
    private final boolean isVideo;
    public final String mimeType;

    /* renamed from: name  reason: collision with root package name */
    public final String f34956name;
    public final boolean secure;
    public final boolean softwareOnly;
    public final boolean tunneling;
    public final boolean vendor;

    @RequiresApi(29)
    public static final class Api29 {
        private Api29() {
        }

        @DoNotInline
        public static int areResolutionAndFrameRateCovered(MediaCodecInfo.VideoCapabilities videoCapabilities, int i11, int i12, double d11) {
            List a11 = videoCapabilities.getSupportedPerformancePoints();
            if (a11 == null || a11.isEmpty() || MediaCodecInfo.needsIgnorePerformancePointsWorkaround()) {
                return 0;
            }
            MediaCodecInfo.VideoCapabilities.PerformancePoint performancePoint = new MediaCodecInfo.VideoCapabilities.PerformancePoint(i11, i12, (int) d11);
            for (int i13 = 0; i13 < a11.size(); i13++) {
                if (((MediaCodecInfo.VideoCapabilities.PerformancePoint) a11.get(i13)).covers(performancePoint)) {
                    return 2;
                }
            }
            return 1;
        }
    }

    @VisibleForTesting
    public MediaCodecInfo(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        this.f34956name = (String) Assertions.checkNotNull(str);
        this.mimeType = str2;
        this.codecMimeType = str3;
        this.capabilities = codecCapabilities;
        this.hardwareAccelerated = z11;
        this.softwareOnly = z12;
        this.vendor = z13;
        this.adaptive = z14;
        this.tunneling = z15;
        this.secure = z16;
        this.isVideo = MimeTypes.isVideo(str2);
    }

    private static int adjustMaxInputChannelCount(String str, String str2, int i11) {
        int i12;
        if (i11 > 1 || ((Util.SDK_INT >= 26 && i11 > 0) || MimeTypes.AUDIO_MPEG.equals(str2) || MimeTypes.AUDIO_AMR_NB.equals(str2) || MimeTypes.AUDIO_AMR_WB.equals(str2) || MimeTypes.AUDIO_AAC.equals(str2) || MimeTypes.AUDIO_VORBIS.equals(str2) || MimeTypes.AUDIO_OPUS.equals(str2) || MimeTypes.AUDIO_RAW.equals(str2) || MimeTypes.AUDIO_FLAC.equals(str2) || MimeTypes.AUDIO_ALAW.equals(str2) || MimeTypes.AUDIO_MLAW.equals(str2) || MimeTypes.AUDIO_MSGSM.equals(str2))) {
            return i11;
        }
        if (MimeTypes.AUDIO_AC3.equals(str2)) {
            i12 = 6;
        } else if (MimeTypes.AUDIO_E_AC3.equals(str2)) {
            i12 = 16;
        } else {
            i12 = 30;
        }
        Log.w(TAG, "AssumedMaxChannelAdjustment: " + str + ", [" + i11 + " to " + i12 + "]");
        return i12;
    }

    @RequiresApi(21)
    private static boolean areSizeAndRateSupportedV21(MediaCodecInfo.VideoCapabilities videoCapabilities, int i11, int i12, double d11) {
        Point alignVideoSizeV21 = alignVideoSizeV21(videoCapabilities, i11, i12);
        int i13 = alignVideoSizeV21.x;
        int i14 = alignVideoSizeV21.y;
        if (d11 == -1.0d || d11 < 1.0d) {
            return videoCapabilities.isSizeSupported(i13, i14);
        }
        return videoCapabilities.areSizeAndRateSupported(i13, i14, Math.floor(d11));
    }

    private static MediaCodecInfo.CodecProfileLevel[] estimateLegacyVp9ProfileLevels(@Nullable MediaCodecInfo.CodecCapabilities codecCapabilities) {
        int i11;
        int i12;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            i11 = 0;
        } else {
            i11 = videoCapabilities.getBitrateRange().getUpper().intValue();
        }
        if (i11 >= 180000000) {
            i12 = 1024;
        } else if (i11 >= 120000000) {
            i12 = 512;
        } else if (i11 >= 60000000) {
            i12 = 256;
        } else if (i11 >= 30000000) {
            i12 = 128;
        } else if (i11 >= 18000000) {
            i12 = 64;
        } else if (i11 >= 12000000) {
            i12 = 32;
        } else if (i11 >= 7200000) {
            i12 = 16;
        } else if (i11 >= 3600000) {
            i12 = 8;
        } else if (i11 >= 1800000) {
            i12 = 4;
        } else if (i11 >= 800000) {
            i12 = 2;
        } else {
            i12 = 1;
        }
        MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
        codecProfileLevel.profile = 1;
        codecProfileLevel.level = i12;
        return new MediaCodecInfo.CodecProfileLevel[]{codecProfileLevel};
    }

    @RequiresApi(23)
    private static int getMaxSupportedInstancesV23(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.getMaxSupportedInstances();
    }

    private static boolean isAdaptive(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return Util.SDK_INT >= 19 && isAdaptiveV19(codecCapabilities);
    }

    @RequiresApi(19)
    private static boolean isAdaptiveV19(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    private boolean isCodecProfileAndLevelSupported(Format format, boolean z11) {
        Pair<Integer, Integer> codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format);
        if (codecProfileAndLevel == null) {
            return true;
        }
        int intValue = ((Integer) codecProfileAndLevel.first).intValue();
        int intValue2 = ((Integer) codecProfileAndLevel.second).intValue();
        if (MimeTypes.VIDEO_DOLBY_VISION.equals(format.sampleMimeType)) {
            if (MimeTypes.VIDEO_H264.equals(this.mimeType)) {
                intValue = 8;
            } else if (MimeTypes.VIDEO_H265.equals(this.mimeType)) {
                intValue = 2;
            }
            intValue2 = 0;
        }
        if (!this.isVideo && intValue != 42) {
            return true;
        }
        MediaCodecInfo.CodecProfileLevel[] profileLevels = getProfileLevels();
        if (Util.SDK_INT <= 23 && MimeTypes.VIDEO_VP9.equals(this.mimeType) && profileLevels.length == 0) {
            profileLevels = estimateLegacyVp9ProfileLevels(this.capabilities);
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : profileLevels) {
            if (codecProfileLevel.profile == intValue && ((codecProfileLevel.level >= intValue2 || !z11) && !needsProfileExcludedWorkaround(this.mimeType, intValue))) {
                return true;
            }
        }
        logNoSupport("codec.profileLevel, " + format.codecs + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.codecMimeType);
        return false;
    }

    private boolean isSampleMimeTypeSupported(Format format) {
        if (this.mimeType.equals(format.sampleMimeType) || this.mimeType.equals(MediaCodecUtil.getAlternativeCodecMimeType(format))) {
            return true;
        }
        return false;
    }

    private static boolean isSecure(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return Util.SDK_INT >= 21 && isSecureV21(codecCapabilities);
    }

    @RequiresApi(21)
    private static boolean isSecureV21(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    private static boolean isTunneling(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return Util.SDK_INT >= 21 && isTunnelingV21(codecCapabilities);
    }

    @RequiresApi(21)
    private static boolean isTunnelingV21(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    private void logAssumedSupport(String str) {
        Log.d(TAG, "AssumedSupport [" + str + "] [" + this.f34956name + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.mimeType + "] [" + Util.DEVICE_DEBUG_INFO + "]");
    }

    private void logNoSupport(String str) {
        Log.d(TAG, "NoSupport [" + str + "] [" + this.f34956name + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.mimeType + "] [" + Util.DEVICE_DEBUG_INFO + "]");
    }

    private static boolean needsAdaptationFlushWorkaround(String str) {
        return MimeTypes.AUDIO_OPUS.equals(str);
    }

    private static boolean needsAdaptationReconfigureWorkaround(String str) {
        return Util.MODEL.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str);
    }

    private static boolean needsDisableAdaptationWorkaround(String str) {
        if (Util.SDK_INT <= 22) {
            String str2 = Util.MODEL;
            if (("ODROID-XU3".equals(str2) || "Nexus 10".equals(str2)) && ("OMX.Exynos.AVC.Decoder".equals(str) || "OMX.Exynos.AVC.Decoder.secure".equals(str))) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static boolean needsIgnorePerformancePointsWorkaround() {
        String str = Util.DEVICE;
        if (!str.equals("sabrina") && !str.equals("boreal")) {
            String str2 = Util.MODEL;
            if (str2.startsWith("Lenovo TB-X605") || str2.startsWith("Lenovo TB-X606") || str2.startsWith("Lenovo TB-X616")) {
                return true;
            }
            return false;
        }
        return true;
    }

    private static boolean needsProfileExcludedWorkaround(String str, int i11) {
        if (MimeTypes.VIDEO_H265.equals(str) && 2 == i11) {
            String str2 = Util.DEVICE;
            if ("sailfish".equals(str2) || "marlin".equals(str2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean needsRotatedVerticalResolutionWorkaround(String str) {
        if (!"OMX.MTK.VIDEO.DECODER.HEVC".equals(str) || !"mcv5a".equals(Util.DEVICE)) {
            return true;
        }
        return false;
    }

    public static MediaCodecInfo newInstance(String str, String str2, String str3, @Nullable MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15) {
        boolean z16;
        boolean z17;
        boolean z18;
        if (z14 || codecCapabilities == null || !isAdaptive(codecCapabilities) || needsDisableAdaptationWorkaround(str)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (codecCapabilities == null || !isTunneling(codecCapabilities)) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z15 || (codecCapabilities != null && isSecure(codecCapabilities))) {
            z18 = true;
        } else {
            z18 = false;
        }
        return new MediaCodecInfo(str, str2, str3, codecCapabilities, z11, z12, z13, z16, z17, z18);
    }

    @RequiresApi(21)
    @Nullable
    public Point alignVideoSizeV21(int i11, int i12) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return alignVideoSizeV21(videoCapabilities, i11, i12);
    }

    public DecoderReuseEvaluation canReuseCodec(Format format, Format format2) {
        int i11;
        int i12;
        if (!Util.areEqual(format.sampleMimeType, format2.sampleMimeType)) {
            i11 = 8;
        } else {
            i11 = 0;
        }
        if (this.isVideo) {
            if (format.rotationDegrees != format2.rotationDegrees) {
                i11 |= 1024;
            }
            if (!this.adaptive && !(format.width == format2.width && format.height == format2.height)) {
                i11 |= 512;
            }
            if (!Util.areEqual(format.colorInfo, format2.colorInfo)) {
                i11 |= 2048;
            }
            if (needsAdaptationReconfigureWorkaround(this.f34956name) && !format.initializationDataEquals(format2)) {
                i11 |= 2;
            }
            if (i11 == 0) {
                String str = this.f34956name;
                if (format.initializationDataEquals(format2)) {
                    i12 = 3;
                } else {
                    i12 = 2;
                }
                return new DecoderReuseEvaluation(str, format, format2, i12, 0);
            }
        } else {
            if (format.channelCount != format2.channelCount) {
                i11 |= 4096;
            }
            if (format.sampleRate != format2.sampleRate) {
                i11 |= 8192;
            }
            if (format.pcmEncoding != format2.pcmEncoding) {
                i11 |= 16384;
            }
            if (i11 == 0 && MimeTypes.AUDIO_AAC.equals(this.mimeType)) {
                Pair<Integer, Integer> codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format);
                Pair<Integer, Integer> codecProfileAndLevel2 = MediaCodecUtil.getCodecProfileAndLevel(format2);
                if (!(codecProfileAndLevel == null || codecProfileAndLevel2 == null)) {
                    int intValue = ((Integer) codecProfileAndLevel.first).intValue();
                    int intValue2 = ((Integer) codecProfileAndLevel2.first).intValue();
                    if (intValue == 42 && intValue2 == 42) {
                        return new DecoderReuseEvaluation(this.f34956name, format, format2, 3, 0);
                    }
                }
            }
            if (!format.initializationDataEquals(format2)) {
                i11 |= 32;
            }
            if (needsAdaptationFlushWorkaround(this.mimeType)) {
                i11 |= 2;
            }
            if (i11 == 0) {
                return new DecoderReuseEvaluation(this.f34956name, format, format2, 1, 0);
            }
        }
        return new DecoderReuseEvaluation(this.f34956name, format, format2, 0, i11);
    }

    public int getMaxSupportedInstances() {
        MediaCodecInfo.CodecCapabilities codecCapabilities;
        if (Util.SDK_INT < 23 || (codecCapabilities = this.capabilities) == null) {
            return -1;
        }
        return getMaxSupportedInstancesV23(codecCapabilities);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.profileLevels;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.media.MediaCodecInfo.CodecProfileLevel[] getProfileLevels() {
        /*
            r1 = this;
            android.media.MediaCodecInfo$CodecCapabilities r0 = r1.capabilities
            if (r0 == 0) goto L_0x0008
            android.media.MediaCodecInfo$CodecProfileLevel[] r0 = r0.profileLevels
            if (r0 != 0) goto L_0x000b
        L_0x0008:
            r0 = 0
            android.media.MediaCodecInfo$CodecProfileLevel[] r0 = new android.media.MediaCodecInfo.CodecProfileLevel[r0]
        L_0x000b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecInfo.getProfileLevels():android.media.MediaCodecInfo$CodecProfileLevel[]");
    }

    @RequiresApi(21)
    public boolean isAudioChannelCountSupportedV21(int i11) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null) {
            logNoSupport("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            logNoSupport("channelCount.aCaps");
            return false;
        } else if (adjustMaxInputChannelCount(this.f34956name, this.mimeType, audioCapabilities.getMaxInputChannelCount()) >= i11) {
            return true;
        } else {
            logNoSupport("channelCount.support, " + i11);
            return false;
        }
    }

    @RequiresApi(21)
    public boolean isAudioSampleRateSupportedV21(int i11) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null) {
            logNoSupport("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            logNoSupport("sampleRate.aCaps");
            return false;
        } else if (audioCapabilities.isSampleRateSupported(i11)) {
            return true;
        } else {
            logNoSupport("sampleRate.support, " + i11);
            return false;
        }
    }

    public boolean isFormatFunctionallySupported(Format format) {
        if (!isSampleMimeTypeSupported(format) || !isCodecProfileAndLevelSupported(format, false)) {
            return false;
        }
        return true;
    }

    public boolean isFormatSupported(Format format) throws MediaCodecUtil.DecoderQueryException {
        int i11;
        boolean z11 = false;
        if (!isSampleMimeTypeSupported(format) || !isCodecProfileAndLevelSupported(format, true)) {
            return false;
        }
        if (this.isVideo) {
            int i12 = format.width;
            if (i12 <= 0 || (i11 = format.height) <= 0) {
                return true;
            }
            if (Util.SDK_INT >= 21) {
                return isVideoSizeAndRateSupportedV21(i12, i11, (double) format.frameRate);
            }
            if (i12 * i11 <= MediaCodecUtil.maxH264DecodableFrameSize()) {
                z11 = true;
            }
            if (!z11) {
                logNoSupport("legacyFrameSize, " + format.width + Param.X + format.height);
            }
            return z11;
        }
        if (Util.SDK_INT >= 21) {
            int i13 = format.sampleRate;
            if (i13 != -1 && !isAudioSampleRateSupportedV21(i13)) {
                return false;
            }
            int i14 = format.channelCount;
            if (i14 != -1 && !isAudioChannelCountSupportedV21(i14)) {
                return false;
            }
        }
        return true;
    }

    public boolean isHdr10PlusOutOfBandMetadataSupported() {
        if (Util.SDK_INT >= 29 && MimeTypes.VIDEO_VP9.equals(this.mimeType)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : getProfileLevels()) {
                if (codecProfileLevel.profile == 16384) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isSeamlessAdaptationSupported(Format format) {
        if (this.isVideo) {
            return this.adaptive;
        }
        Pair<Integer, Integer> codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format);
        return codecProfileAndLevel != null && ((Integer) codecProfileAndLevel.first).intValue() == 42;
    }

    @RequiresApi(21)
    public boolean isVideoSizeAndRateSupportedV21(int i11, int i12, double d11) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.capabilities;
        if (codecCapabilities == null) {
            logNoSupport("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            logNoSupport("sizeAndRate.vCaps");
            return false;
        }
        if (Util.SDK_INT >= 29) {
            int areResolutionAndFrameRateCovered = Api29.areResolutionAndFrameRateCovered(videoCapabilities, i11, i12, d11);
            if (areResolutionAndFrameRateCovered == 2) {
                return true;
            }
            if (areResolutionAndFrameRateCovered == 1) {
                logNoSupport("sizeAndRate.cover, " + i11 + Param.X + i12 + "@" + d11);
                return false;
            }
        }
        if (!areSizeAndRateSupportedV21(videoCapabilities, i11, i12, d11)) {
            if (i11 >= i12 || !needsRotatedVerticalResolutionWorkaround(this.f34956name) || !areSizeAndRateSupportedV21(videoCapabilities, i12, i11, d11)) {
                logNoSupport("sizeAndRate.support, " + i11 + Param.X + i12 + "@" + d11);
                return false;
            }
            logAssumedSupport("sizeAndRate.rotated, " + i11 + Param.X + i12 + "@" + d11);
        }
        return true;
    }

    public String toString() {
        return this.f34956name;
    }

    @RequiresApi(21)
    private static Point alignVideoSizeV21(MediaCodecInfo.VideoCapabilities videoCapabilities, int i11, int i12) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(Util.ceilDivide(i11, widthAlignment) * widthAlignment, Util.ceilDivide(i12, heightAlignment) * heightAlignment);
    }

    @Deprecated
    public boolean isSeamlessAdaptationSupported(Format format, Format format2, boolean z11) {
        if (!z11 && format.colorInfo != null && format2.colorInfo == null) {
            format2 = format2.buildUpon().setColorInfo(format.colorInfo).build();
        }
        int i11 = canReuseCodec(format, format2).result;
        return i11 == 2 || i11 == 3;
    }
}

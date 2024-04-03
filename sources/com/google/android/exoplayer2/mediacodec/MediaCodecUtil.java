package com.google.android.exoplayer2.mediacodec;

import android.annotation.SuppressLint;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import com.adjust.sdk.Constants;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.compress.archivers.tar.TarConstants;
import org.apache.commons.lang3.CharUtils;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

@SuppressLint({"InlinedApi"})
public final class MediaCodecUtil {
    private static final String CODEC_ID_AV01 = "av01";
    private static final String CODEC_ID_AVC1 = "avc1";
    private static final String CODEC_ID_AVC2 = "avc2";
    private static final String CODEC_ID_HEV1 = "hev1";
    private static final String CODEC_ID_HVC1 = "hvc1";
    private static final String CODEC_ID_MP4A = "mp4a";
    private static final String CODEC_ID_VP09 = "vp09";
    private static final Pattern PROFILE_PATTERN = Pattern.compile("^\\D?(\\d+)$");
    private static final String TAG = "MediaCodecUtil";
    @GuardedBy("MediaCodecUtil.class")
    private static final HashMap<CodecKey, List<MediaCodecInfo>> decoderInfosCache = new HashMap<>();
    private static int maxH264DecodableFrameSize = -1;

    public static final class CodecKey {
        public final String mimeType;
        public final boolean secure;
        public final boolean tunneling;

        public CodecKey(String str, boolean z11, boolean z12) {
            this.mimeType = str;
            this.secure = z11;
            this.tunneling = z12;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != CodecKey.class) {
                return false;
            }
            CodecKey codecKey = (CodecKey) obj;
            if (TextUtils.equals(this.mimeType, codecKey.mimeType) && this.secure == codecKey.secure && this.tunneling == codecKey.tunneling) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i11;
            int hashCode = (this.mimeType.hashCode() + 31) * 31;
            int i12 = 1231;
            if (this.secure) {
                i11 = 1231;
            } else {
                i11 = 1237;
            }
            int i13 = (hashCode + i11) * 31;
            if (!this.tunneling) {
                i12 = 1237;
            }
            return i13 + i12;
        }
    }

    public static class DecoderQueryException extends Exception {
        private DecoderQueryException(Throwable th2) {
            super("Failed to query underlying media codecs", th2);
        }
    }

    public interface MediaCodecListCompat {
        int getCodecCount();

        MediaCodecInfo getCodecInfoAt(int i11);

        boolean isFeatureRequired(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean isFeatureSupported(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean secureDecodersExplicit();
    }

    public static final class MediaCodecListCompatV16 implements MediaCodecListCompat {
        private MediaCodecListCompatV16() {
        }

        public int getCodecCount() {
            return MediaCodecList.getCodecCount();
        }

        public MediaCodecInfo getCodecInfoAt(int i11) {
            return MediaCodecList.getCodecInfoAt(i11);
        }

        public boolean isFeatureRequired(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return false;
        }

        public boolean isFeatureSupported(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            if (!"secure-playback".equals(str) || !MimeTypes.VIDEO_H264.equals(str2)) {
                return false;
            }
            return true;
        }

        public boolean secureDecodersExplicit() {
            return false;
        }
    }

    @RequiresApi(21)
    public static final class MediaCodecListCompatV21 implements MediaCodecListCompat {
        private final int codecKind;
        @Nullable
        private MediaCodecInfo[] mediaCodecInfos;

        public MediaCodecListCompatV21(boolean z11, boolean z12) {
            int i11;
            if (z11 || z12) {
                i11 = 1;
            } else {
                i11 = 0;
            }
            this.codecKind = i11;
        }

        @EnsuresNonNull({"mediaCodecInfos"})
        private void ensureMediaCodecInfosInitialized() {
            if (this.mediaCodecInfos == null) {
                this.mediaCodecInfos = new MediaCodecList(this.codecKind).getCodecInfos();
            }
        }

        public int getCodecCount() {
            ensureMediaCodecInfosInitialized();
            return this.mediaCodecInfos.length;
        }

        public MediaCodecInfo getCodecInfoAt(int i11) {
            ensureMediaCodecInfosInitialized();
            return this.mediaCodecInfos[i11];
        }

        public boolean isFeatureRequired(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureRequired(str);
        }

        public boolean isFeatureSupported(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(str);
        }

        public boolean secureDecodersExplicit() {
            return true;
        }
    }

    public interface ScoreProvider<T> {
        int getScore(T t11);
    }

    private MediaCodecUtil() {
    }

    private static void applyWorkarounds(String str, List<MediaCodecInfo> list) {
        if (MimeTypes.AUDIO_RAW.equals(str)) {
            if (Util.SDK_INT < 26 && Util.DEVICE.equals("R9") && list.size() == 1 && list.get(0).f34956name.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                list.add(MediaCodecInfo.newInstance("OMX.google.raw.decoder", MimeTypes.AUDIO_RAW, MimeTypes.AUDIO_RAW, (MediaCodecInfo.CodecCapabilities) null, false, true, false, false, false));
            }
            sortByScore(list, new d());
        }
        int i11 = Util.SDK_INT;
        if (i11 < 21 && list.size() > 1) {
            String str2 = list.get(0).f34956name;
            if ("OMX.SEC.mp3.dec".equals(str2) || "OMX.SEC.MP3.Decoder".equals(str2) || "OMX.brcm.audio.mp3.decoder".equals(str2)) {
                sortByScore(list, new e());
            }
        }
        if (i11 < 32 && list.size() > 1 && "OMX.qti.audio.decoder.flac".equals(list.get(0).f34956name)) {
            list.add(list.remove(0));
        }
    }

    private static int av1LevelNumberToConst(int i11) {
        switch (i11) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return 256;
            case 9:
                return 512;
            case 10:
                return 1024;
            case 11:
                return 2048;
            case 12:
                return 4096;
            case 13:
                return 8192;
            case 14:
                return 16384;
            case 15:
                return 32768;
            case 16:
                return 65536;
            case 17:
                return 131072;
            case 18:
                return 262144;
            case 19:
                return 524288;
            case 20:
                return 1048576;
            case 21:
                return 2097152;
            case 22:
                return 4194304;
            case 23:
                return 8388608;
            default:
                return -1;
        }
    }

    private static int avcLevelNumberToConst(int i11) {
        switch (i11) {
            case 10:
                return 1;
            case 11:
                return 4;
            case 12:
                return 8;
            case 13:
                return 16;
            default:
                switch (i11) {
                    case 20:
                        return 32;
                    case 21:
                        return 64;
                    case 22:
                        return 128;
                    default:
                        switch (i11) {
                            case 30:
                                return 256;
                            case 31:
                                return 512;
                            case 32:
                                return 1024;
                            default:
                                switch (i11) {
                                    case 40:
                                        return 2048;
                                    case 41:
                                        return 4096;
                                    case 42:
                                        return 8192;
                                    default:
                                        switch (i11) {
                                            case 50:
                                                return 16384;
                                            case 51:
                                                return 32768;
                                            case 52:
                                                return 65536;
                                            default:
                                                return -1;
                                        }
                                }
                        }
                }
        }
    }

    private static int avcLevelToMaxFrameSize(int i11) {
        if (i11 == 1 || i11 == 2) {
            return 25344;
        }
        switch (i11) {
            case 8:
            case 16:
            case 32:
                return 101376;
            case 64:
                return 202752;
            case 128:
            case 256:
                return 414720;
            case 512:
                return 921600;
            case 1024:
                return 1310720;
            case 2048:
            case 4096:
                return 2097152;
            case 8192:
                return 2228224;
            case 16384:
                return 5652480;
            case 32768:
            case 65536:
                return 9437184;
            case 131072:
            case 262144:
            case 524288:
                return 35651584;
            default:
                return -1;
        }
    }

    private static int avcProfileNumberToConst(int i11) {
        if (i11 == 66) {
            return 1;
        }
        if (i11 == 77) {
            return 2;
        }
        if (i11 == 88) {
            return 4;
        }
        if (i11 == 100) {
            return 8;
        }
        if (i11 == 110) {
            return 16;
        }
        if (i11 != 122) {
            return i11 != 244 ? -1 : 64;
        }
        return 32;
    }

    @VisibleForTesting
    public static synchronized void clearDecoderInfoCache() {
        synchronized (MediaCodecUtil.class) {
            decoderInfosCache.clear();
        }
    }

    @Nullable
    private static Integer dolbyVisionStringToLevel(@Nullable String str) {
        if (str == null) {
            return null;
        }
        char c11 = 65535;
        switch (str.hashCode()) {
            case 1537:
                if (str.equals(HiAnalyticsConstant.KeyAndValue.NUMBER_01)) {
                    c11 = 0;
                    break;
                }
                break;
            case 1538:
                if (str.equals("02")) {
                    c11 = 1;
                    break;
                }
                break;
            case 1539:
                if (str.equals("03")) {
                    c11 = 2;
                    break;
                }
                break;
            case 1540:
                if (str.equals("04")) {
                    c11 = 3;
                    break;
                }
                break;
            case 1541:
                if (str.equals("05")) {
                    c11 = 4;
                    break;
                }
                break;
            case 1542:
                if (str.equals("06")) {
                    c11 = 5;
                    break;
                }
                break;
            case 1543:
                if (str.equals("07")) {
                    c11 = 6;
                    break;
                }
                break;
            case 1544:
                if (str.equals("08")) {
                    c11 = 7;
                    break;
                }
                break;
            case 1545:
                if (str.equals("09")) {
                    c11 = 8;
                    break;
                }
                break;
            case 1567:
                if (str.equals("10")) {
                    c11 = 9;
                    break;
                }
                break;
            case 1568:
                if (str.equals("11")) {
                    c11 = 10;
                    break;
                }
                break;
            case 1569:
                if (str.equals("12")) {
                    c11 = 11;
                    break;
                }
                break;
            case 1570:
                if (str.equals("13")) {
                    c11 = 12;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return 256;
            case 9:
                return 512;
            case 10:
                return 1024;
            case 11:
                return 2048;
            case 12:
                return 4096;
            default:
                return null;
        }
    }

    @Nullable
    private static Integer dolbyVisionStringToProfile(@Nullable String str) {
        if (str == null) {
            return null;
        }
        char c11 = 65535;
        switch (str.hashCode()) {
            case 1536:
                if (str.equals(TarConstants.VERSION_POSIX)) {
                    c11 = 0;
                    break;
                }
                break;
            case 1537:
                if (str.equals(HiAnalyticsConstant.KeyAndValue.NUMBER_01)) {
                    c11 = 1;
                    break;
                }
                break;
            case 1538:
                if (str.equals("02")) {
                    c11 = 2;
                    break;
                }
                break;
            case 1539:
                if (str.equals("03")) {
                    c11 = 3;
                    break;
                }
                break;
            case 1540:
                if (str.equals("04")) {
                    c11 = 4;
                    break;
                }
                break;
            case 1541:
                if (str.equals("05")) {
                    c11 = 5;
                    break;
                }
                break;
            case 1542:
                if (str.equals("06")) {
                    c11 = 6;
                    break;
                }
                break;
            case 1543:
                if (str.equals("07")) {
                    c11 = 7;
                    break;
                }
                break;
            case 1544:
                if (str.equals("08")) {
                    c11 = 8;
                    break;
                }
                break;
            case 1545:
                if (str.equals("09")) {
                    c11 = 9;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return 256;
            case 9:
                return 512;
            default:
                return null;
        }
    }

    @Nullable
    private static Pair<Integer, Integer> getAacCodecProfileAndLevel(String str, String[] strArr) {
        int mp4aAudioObjectTypeToProfile;
        if (strArr.length != 3) {
            Log.w(TAG, "Ignoring malformed MP4A codec string: " + str);
            return null;
        }
        try {
            if (MimeTypes.AUDIO_AAC.equals(MimeTypes.getMimeTypeFromMp4ObjectType(Integer.parseInt(strArr[1], 16))) && (mp4aAudioObjectTypeToProfile = mp4aAudioObjectTypeToProfile(Integer.parseInt(strArr[2]))) != -1) {
                return new Pair<>(Integer.valueOf(mp4aAudioObjectTypeToProfile), 0);
            }
        } catch (NumberFormatException unused) {
            Log.w(TAG, "Ignoring malformed MP4A codec string: " + str);
        }
        return null;
    }

    @Nullable
    public static String getAlternativeCodecMimeType(Format format) {
        Pair<Integer, Integer> codecProfileAndLevel;
        if (MimeTypes.AUDIO_E_AC3_JOC.equals(format.sampleMimeType)) {
            return MimeTypes.AUDIO_E_AC3;
        }
        if (!MimeTypes.VIDEO_DOLBY_VISION.equals(format.sampleMimeType) || (codecProfileAndLevel = getCodecProfileAndLevel(format)) == null) {
            return null;
        }
        int intValue = ((Integer) codecProfileAndLevel.first).intValue();
        if (intValue == 16 || intValue == 256) {
            return MimeTypes.VIDEO_H265;
        }
        if (intValue == 512) {
            return MimeTypes.VIDEO_H264;
        }
        return null;
    }

    @Nullable
    private static Pair<Integer, Integer> getAv1ProfileAndLevel(String str, String[] strArr, @Nullable ColorInfo colorInfo) {
        int i11;
        if (strArr.length < 4) {
            Log.w(TAG, "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
        int i12 = 1;
        try {
            int parseInt = Integer.parseInt(strArr[1]);
            int parseInt2 = Integer.parseInt(strArr[2].substring(0, 2));
            int parseInt3 = Integer.parseInt(strArr[3]);
            if (parseInt != 0) {
                Log.w(TAG, "Unknown AV1 profile: " + parseInt);
                return null;
            } else if (parseInt3 == 8 || parseInt3 == 10) {
                if (parseInt3 != 8) {
                    if (colorInfo == null || !(colorInfo.hdrStaticInfo != null || (i11 = colorInfo.colorTransfer) == 7 || i11 == 6)) {
                        i12 = 2;
                    } else {
                        i12 = 4096;
                    }
                }
                int av1LevelNumberToConst = av1LevelNumberToConst(parseInt2);
                if (av1LevelNumberToConst != -1) {
                    return new Pair<>(Integer.valueOf(i12), Integer.valueOf(av1LevelNumberToConst));
                }
                Log.w(TAG, "Unknown AV1 level: " + parseInt2);
                return null;
            } else {
                Log.w(TAG, "Unknown AV1 bit depth: " + parseInt3);
                return null;
            }
        } catch (NumberFormatException unused) {
            Log.w(TAG, "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
    }

    @Nullable
    private static Pair<Integer, Integer> getAvcProfileAndLevel(String str, String[] strArr) {
        int i11;
        int i12;
        if (strArr.length < 2) {
            Log.w(TAG, "Ignoring malformed AVC codec string: " + str);
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                i12 = Integer.parseInt(strArr[1].substring(0, 2), 16);
                i11 = Integer.parseInt(strArr[1].substring(4), 16);
            } else if (strArr.length >= 3) {
                int parseInt = Integer.parseInt(strArr[1]);
                i11 = Integer.parseInt(strArr[2]);
                i12 = parseInt;
            } else {
                Log.w(TAG, "Ignoring malformed AVC codec string: " + str);
                return null;
            }
            int avcProfileNumberToConst = avcProfileNumberToConst(i12);
            if (avcProfileNumberToConst == -1) {
                Log.w(TAG, "Unknown AVC profile: " + i12);
                return null;
            }
            int avcLevelNumberToConst = avcLevelNumberToConst(i11);
            if (avcLevelNumberToConst != -1) {
                return new Pair<>(Integer.valueOf(avcProfileNumberToConst), Integer.valueOf(avcLevelNumberToConst));
            }
            Log.w(TAG, "Unknown AVC level: " + i11);
            return null;
        } catch (NumberFormatException unused) {
            Log.w(TAG, "Ignoring malformed AVC codec string: " + str);
            return null;
        }
    }

    @Nullable
    private static String getCodecMimeType(MediaCodecInfo mediaCodecInfo, String str, String str2) {
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals(MimeTypes.VIDEO_DOLBY_VISION)) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        } else if (str2.equals(MimeTypes.AUDIO_ALAC) && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        } else {
            if (str2.equals(MimeTypes.AUDIO_FLAC) && "OMX.lge.flac.decoder".equals(str)) {
                return "audio/x-lg-flac";
            }
            if (!str2.equals(MimeTypes.AUDIO_AC3) || !"OMX.lge.ac3.decoder".equals(str)) {
                return null;
            }
            return "audio/lg-ac3";
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0075, code lost:
        if (r3.equals(CODEC_ID_AV01) == false) goto L_0x002b;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> getCodecProfileAndLevel(com.google.android.exoplayer2.Format r6) {
        /*
            java.lang.String r0 = r6.codecs
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            java.lang.String r2 = "\\."
            java.lang.String[] r0 = r0.split(r2)
            java.lang.String r2 = "video/dolby-vision"
            java.lang.String r3 = r6.sampleMimeType
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x001d
            java.lang.String r6 = r6.codecs
            android.util.Pair r6 = getDolbyVisionProfileAndLevel(r6, r0)
            return r6
        L_0x001d:
            r2 = 0
            r3 = r0[r2]
            r3.hashCode()
            int r4 = r3.hashCode()
            r5 = -1
            switch(r4) {
                case 3004662: goto L_0x006f;
                case 3006243: goto L_0x0064;
                case 3006244: goto L_0x0059;
                case 3199032: goto L_0x004e;
                case 3214780: goto L_0x0043;
                case 3356560: goto L_0x0038;
                case 3624515: goto L_0x002d;
                default: goto L_0x002b;
            }
        L_0x002b:
            r2 = r5
            goto L_0x0078
        L_0x002d:
            java.lang.String r2 = "vp09"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x0036
            goto L_0x002b
        L_0x0036:
            r2 = 6
            goto L_0x0078
        L_0x0038:
            java.lang.String r2 = "mp4a"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x0041
            goto L_0x002b
        L_0x0041:
            r2 = 5
            goto L_0x0078
        L_0x0043:
            java.lang.String r2 = "hvc1"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x004c
            goto L_0x002b
        L_0x004c:
            r2 = 4
            goto L_0x0078
        L_0x004e:
            java.lang.String r2 = "hev1"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x0057
            goto L_0x002b
        L_0x0057:
            r2 = 3
            goto L_0x0078
        L_0x0059:
            java.lang.String r2 = "avc2"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x0062
            goto L_0x002b
        L_0x0062:
            r2 = 2
            goto L_0x0078
        L_0x0064:
            java.lang.String r2 = "avc1"
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x006d
            goto L_0x002b
        L_0x006d:
            r2 = 1
            goto L_0x0078
        L_0x006f:
            java.lang.String r4 = "av01"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0078
            goto L_0x002b
        L_0x0078:
            switch(r2) {
                case 0: goto L_0x009a;
                case 1: goto L_0x0093;
                case 2: goto L_0x0093;
                case 3: goto L_0x008a;
                case 4: goto L_0x008a;
                case 5: goto L_0x0083;
                case 6: goto L_0x007c;
                default: goto L_0x007b;
            }
        L_0x007b:
            return r1
        L_0x007c:
            java.lang.String r6 = r6.codecs
            android.util.Pair r6 = getVp9ProfileAndLevel(r6, r0)
            return r6
        L_0x0083:
            java.lang.String r6 = r6.codecs
            android.util.Pair r6 = getAacCodecProfileAndLevel(r6, r0)
            return r6
        L_0x008a:
            java.lang.String r1 = r6.codecs
            com.google.android.exoplayer2.video.ColorInfo r6 = r6.colorInfo
            android.util.Pair r6 = getHevcProfileAndLevel(r1, r0, r6)
            return r6
        L_0x0093:
            java.lang.String r6 = r6.codecs
            android.util.Pair r6 = getAvcProfileAndLevel(r6, r0)
            return r6
        L_0x009a:
            java.lang.String r1 = r6.codecs
            com.google.android.exoplayer2.video.ColorInfo r6 = r6.colorInfo
            android.util.Pair r6 = getAv1ProfileAndLevel(r1, r0, r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.getCodecProfileAndLevel(com.google.android.exoplayer2.Format):android.util.Pair");
    }

    @Nullable
    public static MediaCodecInfo getDecoderInfo(String str, boolean z11, boolean z12) throws DecoderQueryException {
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(str, z11, z12);
        if (decoderInfos.isEmpty()) {
            return null;
        }
        return decoderInfos.get(0);
    }

    public static synchronized List<MediaCodecInfo> getDecoderInfos(String str, boolean z11, boolean z12) throws DecoderQueryException {
        MediaCodecListCompat mediaCodecListCompat;
        synchronized (MediaCodecUtil.class) {
            CodecKey codecKey = new CodecKey(str, z11, z12);
            HashMap<CodecKey, List<MediaCodecInfo>> hashMap = decoderInfosCache;
            List<MediaCodecInfo> list = hashMap.get(codecKey);
            if (list != null) {
                return list;
            }
            int i11 = Util.SDK_INT;
            if (i11 >= 21) {
                mediaCodecListCompat = new MediaCodecListCompatV21(z11, z12);
            } else {
                mediaCodecListCompat = new MediaCodecListCompatV16();
            }
            ArrayList<MediaCodecInfo> decoderInfosInternal = getDecoderInfosInternal(codecKey, mediaCodecListCompat);
            if (z11 && decoderInfosInternal.isEmpty() && 21 <= i11 && i11 <= 23) {
                decoderInfosInternal = getDecoderInfosInternal(codecKey, new MediaCodecListCompatV16());
                if (!decoderInfosInternal.isEmpty()) {
                    Log.w(TAG, "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + decoderInfosInternal.get(0).f34956name);
                }
            }
            applyWorkarounds(str, decoderInfosInternal);
            ImmutableList<MediaCodecInfo> copyOf = ImmutableList.copyOf(decoderInfosInternal);
            hashMap.put(codecKey, copyOf);
            return copyOf;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007f, code lost:
        if (r1.secure == false) goto L_0x0081;
     */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0101 A[SYNTHETIC, Splitter:B:60:0x0101] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x012a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList<com.google.android.exoplayer2.mediacodec.MediaCodecInfo> getDecoderInfosInternal(com.google.android.exoplayer2.mediacodec.MediaCodecUtil.CodecKey r24, com.google.android.exoplayer2.mediacodec.MediaCodecUtil.MediaCodecListCompat r25) throws com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException {
        /*
            r1 = r24
            r2 = r25
            java.lang.String r3 = "secure-playback"
            java.lang.String r4 = "tunneled-playback"
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x014f }
            r5.<init>()     // Catch:{ Exception -> 0x014f }
            java.lang.String r15 = r1.mimeType     // Catch:{ Exception -> 0x014f }
            int r14 = r25.getCodecCount()     // Catch:{ Exception -> 0x014f }
            boolean r13 = r25.secureDecodersExplicit()     // Catch:{ Exception -> 0x014f }
            r0 = 0
            r12 = r0
        L_0x0019:
            if (r12 >= r14) goto L_0x014e
            android.media.MediaCodecInfo r0 = r2.getCodecInfoAt(r12)     // Catch:{ Exception -> 0x014f }
            boolean r6 = isAlias(r0)     // Catch:{ Exception -> 0x014f }
            if (r6 == 0) goto L_0x002d
        L_0x0025:
            r22 = r12
            r23 = r13
            r18 = r14
            goto L_0x0120
        L_0x002d:
            java.lang.String r11 = r0.getName()     // Catch:{ Exception -> 0x014f }
            boolean r6 = isCodecUsableDecoder(r0, r11, r13, r15)     // Catch:{ Exception -> 0x014f }
            if (r6 != 0) goto L_0x0038
            goto L_0x0025
        L_0x0038:
            java.lang.String r10 = getCodecMimeType(r0, r11, r15)     // Catch:{ Exception -> 0x014f }
            if (r10 != 0) goto L_0x003f
            goto L_0x0025
        L_0x003f:
            android.media.MediaCodecInfo$CodecCapabilities r9 = r0.getCapabilitiesForType(r10)     // Catch:{ Exception -> 0x00ef }
            boolean r6 = r2.isFeatureSupported(r4, r10, r9)     // Catch:{ Exception -> 0x00ef }
            boolean r7 = r2.isFeatureRequired(r4, r10, r9)     // Catch:{ Exception -> 0x00ef }
            boolean r8 = r1.tunneling     // Catch:{ Exception -> 0x00ef }
            if (r8 != 0) goto L_0x0051
            if (r7 != 0) goto L_0x0025
        L_0x0051:
            if (r8 == 0) goto L_0x0056
            if (r6 != 0) goto L_0x0056
            goto L_0x0025
        L_0x0056:
            boolean r6 = r2.isFeatureSupported(r3, r10, r9)     // Catch:{ Exception -> 0x00ef }
            boolean r7 = r2.isFeatureRequired(r3, r10, r9)     // Catch:{ Exception -> 0x00ef }
            boolean r8 = r1.secure     // Catch:{ Exception -> 0x00ef }
            if (r8 != 0) goto L_0x0064
            if (r7 != 0) goto L_0x0025
        L_0x0064:
            if (r8 == 0) goto L_0x0069
            if (r6 != 0) goto L_0x0069
            goto L_0x0025
        L_0x0069:
            boolean r16 = isHardwareAccelerated(r0, r15)     // Catch:{ Exception -> 0x00ef }
            boolean r17 = isSoftwareOnly(r0, r15)     // Catch:{ Exception -> 0x00ef }
            boolean r0 = isVendor(r0)     // Catch:{ Exception -> 0x00ef }
            if (r13 == 0) goto L_0x007b
            boolean r7 = r1.secure     // Catch:{ Exception -> 0x00ef }
            if (r7 == r6) goto L_0x0081
        L_0x007b:
            if (r13 != 0) goto L_0x00b3
            boolean r7 = r1.secure     // Catch:{ Exception -> 0x00a8 }
            if (r7 != 0) goto L_0x00b3
        L_0x0081:
            r18 = 0
            r19 = 0
            r6 = r11
            r7 = r15
            r8 = r10
            r20 = r10
            r10 = r16
            r21 = r11
            r11 = r17
            r22 = r12
            r12 = r0
            r23 = r13
            r13 = r18
            r18 = r14
            r14 = r19
            com.google.android.exoplayer2.mediacodec.MediaCodecInfo r0 = com.google.android.exoplayer2.mediacodec.MediaCodecInfo.newInstance(r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x00a4 }
            r5.add(r0)     // Catch:{ Exception -> 0x00a4 }
            goto L_0x0120
        L_0x00a4:
            r0 = move-exception
            r1 = r21
            goto L_0x00f9
        L_0x00a8:
            r0 = move-exception
            r20 = r10
            r22 = r12
            r23 = r13
            r18 = r14
            r1 = r11
            goto L_0x00f9
        L_0x00b3:
            r20 = r10
            r21 = r11
            r22 = r12
            r23 = r13
            r18 = r14
            if (r23 != 0) goto L_0x0120
            if (r6 == 0) goto L_0x0120
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a4 }
            r6.<init>()     // Catch:{ Exception -> 0x00a4 }
            r14 = r21
            r6.append(r14)     // Catch:{ Exception -> 0x00ec }
            java.lang.String r7 = ".secure"
            r6.append(r7)     // Catch:{ Exception -> 0x00ec }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x00ec }
            r13 = 0
            r19 = 1
            r7 = r15
            r8 = r20
            r10 = r16
            r11 = r17
            r12 = r0
            r1 = r14
            r14 = r19
            com.google.android.exoplayer2.mediacodec.MediaCodecInfo r0 = com.google.android.exoplayer2.mediacodec.MediaCodecInfo.newInstance(r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x00ea }
            r5.add(r0)     // Catch:{ Exception -> 0x00ea }
            return r5
        L_0x00ea:
            r0 = move-exception
            goto L_0x00f9
        L_0x00ec:
            r0 = move-exception
            r1 = r14
            goto L_0x00f9
        L_0x00ef:
            r0 = move-exception
            r20 = r10
            r1 = r11
            r22 = r12
            r23 = r13
            r18 = r14
        L_0x00f9:
            int r6 = com.google.android.exoplayer2.util.Util.SDK_INT     // Catch:{ Exception -> 0x014f }
            r7 = 23
            java.lang.String r8 = "MediaCodecUtil"
            if (r6 > r7) goto L_0x012a
            boolean r6 = r5.isEmpty()     // Catch:{ Exception -> 0x014f }
            if (r6 != 0) goto L_0x012a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x014f }
            r0.<init>()     // Catch:{ Exception -> 0x014f }
            java.lang.String r6 = "Skipping codec "
            r0.append(r6)     // Catch:{ Exception -> 0x014f }
            r0.append(r1)     // Catch:{ Exception -> 0x014f }
            java.lang.String r1 = " (failed to query capabilities)"
            r0.append(r1)     // Catch:{ Exception -> 0x014f }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x014f }
            com.google.android.exoplayer2.util.Log.e(r8, r0)     // Catch:{ Exception -> 0x014f }
        L_0x0120:
            int r12 = r22 + 1
            r1 = r24
            r14 = r18
            r13 = r23
            goto L_0x0019
        L_0x012a:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x014f }
            r2.<init>()     // Catch:{ Exception -> 0x014f }
            java.lang.String r3 = "Failed to query codec "
            r2.append(r3)     // Catch:{ Exception -> 0x014f }
            r2.append(r1)     // Catch:{ Exception -> 0x014f }
            java.lang.String r1 = " ("
            r2.append(r1)     // Catch:{ Exception -> 0x014f }
            r1 = r20
            r2.append(r1)     // Catch:{ Exception -> 0x014f }
            java.lang.String r1 = ")"
            r2.append(r1)     // Catch:{ Exception -> 0x014f }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x014f }
            com.google.android.exoplayer2.util.Log.e(r8, r1)     // Catch:{ Exception -> 0x014f }
            throw r0     // Catch:{ Exception -> 0x014f }
        L_0x014e:
            return r5
        L_0x014f:
            r0 = move-exception
            com.google.android.exoplayer2.mediacodec.MediaCodecUtil$DecoderQueryException r1 = new com.google.android.exoplayer2.mediacodec.MediaCodecUtil$DecoderQueryException
            r2 = 0
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.getDecoderInfosInternal(com.google.android.exoplayer2.mediacodec.MediaCodecUtil$CodecKey, com.google.android.exoplayer2.mediacodec.MediaCodecUtil$MediaCodecListCompat):java.util.ArrayList");
    }

    @CheckResult
    public static List<MediaCodecInfo> getDecoderInfosSortedByFormatSupport(List<MediaCodecInfo> list, Format format) {
        ArrayList arrayList = new ArrayList(list);
        sortByScore(arrayList, new f(format));
        return arrayList;
    }

    @Nullable
    public static MediaCodecInfo getDecryptOnlyDecoderInfo() throws DecoderQueryException {
        return getDecoderInfo(MimeTypes.AUDIO_RAW, false, false);
    }

    @Nullable
    private static Pair<Integer, Integer> getDolbyVisionProfileAndLevel(String str, String[] strArr) {
        if (strArr.length < 3) {
            Log.w(TAG, "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        Matcher matcher = PROFILE_PATTERN.matcher(strArr[1]);
        if (!matcher.matches()) {
            Log.w(TAG, "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        String group = matcher.group(1);
        Integer dolbyVisionStringToProfile = dolbyVisionStringToProfile(group);
        if (dolbyVisionStringToProfile == null) {
            Log.w(TAG, "Unknown Dolby Vision profile string: " + group);
            return null;
        }
        String str2 = strArr[2];
        Integer dolbyVisionStringToLevel = dolbyVisionStringToLevel(str2);
        if (dolbyVisionStringToLevel != null) {
            return new Pair<>(dolbyVisionStringToProfile, dolbyVisionStringToLevel);
        }
        Log.w(TAG, "Unknown Dolby Vision level string: " + str2);
        return null;
    }

    @Nullable
    private static Pair<Integer, Integer> getHevcProfileAndLevel(String str, String[] strArr, @Nullable ColorInfo colorInfo) {
        if (strArr.length < 4) {
            Log.w(TAG, "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        int i11 = 1;
        Matcher matcher = PROFILE_PATTERN.matcher(strArr[1]);
        if (!matcher.matches()) {
            Log.w(TAG, "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        String group = matcher.group(1);
        if (!"1".equals(group)) {
            if (!ExifInterface.GPS_MEASUREMENT_2D.equals(group)) {
                Log.w(TAG, "Unknown HEVC profile string: " + group);
                return null;
            } else if (colorInfo == null || colorInfo.colorTransfer != 6) {
                i11 = 2;
            } else {
                i11 = 4096;
            }
        }
        String str2 = strArr[3];
        Integer hevcCodecStringToProfileLevel = hevcCodecStringToProfileLevel(str2);
        if (hevcCodecStringToProfileLevel != null) {
            return new Pair<>(Integer.valueOf(i11), hevcCodecStringToProfileLevel);
        }
        Log.w(TAG, "Unknown HEVC level string: " + str2);
        return null;
    }

    @Nullable
    private static Pair<Integer, Integer> getVp9ProfileAndLevel(String str, String[] strArr) {
        if (strArr.length < 3) {
            Log.w(TAG, "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
        try {
            int parseInt = Integer.parseInt(strArr[1]);
            int parseInt2 = Integer.parseInt(strArr[2]);
            int vp9ProfileNumberToConst = vp9ProfileNumberToConst(parseInt);
            if (vp9ProfileNumberToConst == -1) {
                Log.w(TAG, "Unknown VP9 profile: " + parseInt);
                return null;
            }
            int vp9LevelNumberToConst = vp9LevelNumberToConst(parseInt2);
            if (vp9LevelNumberToConst != -1) {
                return new Pair<>(Integer.valueOf(vp9ProfileNumberToConst), Integer.valueOf(vp9LevelNumberToConst));
            }
            Log.w(TAG, "Unknown VP9 level: " + parseInt2);
            return null;
        } catch (NumberFormatException unused) {
            Log.w(TAG, "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
    }

    @Nullable
    private static Integer hevcCodecStringToProfileLevel(@Nullable String str) {
        if (str == null) {
            return null;
        }
        char c11 = 65535;
        switch (str.hashCode()) {
            case 70821:
                if (str.equals("H30")) {
                    c11 = 0;
                    break;
                }
                break;
            case 70914:
                if (str.equals("H60")) {
                    c11 = 1;
                    break;
                }
                break;
            case 70917:
                if (str.equals("H63")) {
                    c11 = 2;
                    break;
                }
                break;
            case 71007:
                if (str.equals("H90")) {
                    c11 = 3;
                    break;
                }
                break;
            case 71010:
                if (str.equals("H93")) {
                    c11 = 4;
                    break;
                }
                break;
            case 74665:
                if (str.equals("L30")) {
                    c11 = 5;
                    break;
                }
                break;
            case 74758:
                if (str.equals("L60")) {
                    c11 = 6;
                    break;
                }
                break;
            case 74761:
                if (str.equals("L63")) {
                    c11 = 7;
                    break;
                }
                break;
            case 74851:
                if (str.equals("L90")) {
                    c11 = 8;
                    break;
                }
                break;
            case 74854:
                if (str.equals("L93")) {
                    c11 = 9;
                    break;
                }
                break;
            case 2193639:
                if (str.equals("H120")) {
                    c11 = 10;
                    break;
                }
                break;
            case 2193642:
                if (str.equals("H123")) {
                    c11 = 11;
                    break;
                }
                break;
            case 2193732:
                if (str.equals("H150")) {
                    c11 = 12;
                    break;
                }
                break;
            case 2193735:
                if (str.equals("H153")) {
                    c11 = CharUtils.CR;
                    break;
                }
                break;
            case 2193738:
                if (str.equals("H156")) {
                    c11 = 14;
                    break;
                }
                break;
            case 2193825:
                if (str.equals("H180")) {
                    c11 = 15;
                    break;
                }
                break;
            case 2193828:
                if (str.equals("H183")) {
                    c11 = 16;
                    break;
                }
                break;
            case 2193831:
                if (str.equals("H186")) {
                    c11 = 17;
                    break;
                }
                break;
            case 2312803:
                if (str.equals("L120")) {
                    c11 = 18;
                    break;
                }
                break;
            case 2312806:
                if (str.equals("L123")) {
                    c11 = 19;
                    break;
                }
                break;
            case 2312896:
                if (str.equals("L150")) {
                    c11 = 20;
                    break;
                }
                break;
            case 2312899:
                if (str.equals("L153")) {
                    c11 = 21;
                    break;
                }
                break;
            case 2312902:
                if (str.equals("L156")) {
                    c11 = 22;
                    break;
                }
                break;
            case 2312989:
                if (str.equals("L180")) {
                    c11 = 23;
                    break;
                }
                break;
            case 2312992:
                if (str.equals("L183")) {
                    c11 = 24;
                    break;
                }
                break;
            case 2312995:
                if (str.equals("L186")) {
                    c11 = 25;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return 2;
            case 1:
                return 8;
            case 2:
                return 32;
            case 3:
                return 128;
            case 4:
                return 512;
            case 5:
                return 1;
            case 6:
                return 4;
            case 7:
                return 16;
            case 8:
                return 64;
            case 9:
                return 256;
            case 10:
                return 2048;
            case 11:
                return 8192;
            case 12:
                return 32768;
            case 13:
                return 131072;
            case 14:
                return 524288;
            case 15:
                return 2097152;
            case 16:
                return 8388608;
            case 17:
                return 33554432;
            case 18:
                return 1024;
            case 19:
                return 4096;
            case 20:
                return 16384;
            case 21:
                return 65536;
            case 22:
                return 262144;
            case 23:
                return 1048576;
            case 24:
                return 4194304;
            case 25:
                return 16777216;
            default:
                return null;
        }
    }

    private static boolean isAlias(MediaCodecInfo mediaCodecInfo) {
        return Util.SDK_INT >= 29 && isAliasV29(mediaCodecInfo);
    }

    @RequiresApi(29)
    private static boolean isAliasV29(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isAlias();
    }

    private static boolean isCodecUsableDecoder(MediaCodecInfo mediaCodecInfo, String str, boolean z11, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z11 && str.endsWith(".secure"))) {
            return false;
        }
        int i11 = Util.SDK_INT;
        if (i11 < 21 && ("CIPAACDecoder".equals(str) || "CIPMP3Decoder".equals(str) || "CIPVorbisDecoder".equals(str) || "CIPAMRNBDecoder".equals(str) || "AACDecoder".equals(str) || "MP3Decoder".equals(str))) {
            return false;
        }
        if (i11 < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(str)) {
            String str3 = Util.DEVICE;
            if ("a70".equals(str3) || ("Xiaomi".equals(Util.MANUFACTURER) && str3.startsWith("HM"))) {
                return false;
            }
        }
        if (i11 == 16 && "OMX.qcom.audio.decoder.mp3".equals(str)) {
            String str4 = Util.DEVICE;
            if ("dlxu".equals(str4) || "protou".equals(str4) || "ville".equals(str4) || "villeplus".equals(str4) || "villec2".equals(str4) || str4.startsWith("gee") || "C6602".equals(str4) || "C6603".equals(str4) || "C6606".equals(str4) || "C6616".equals(str4) || "L36h".equals(str4) || "SO-02E".equals(str4)) {
                return false;
            }
        }
        if (i11 == 16 && "OMX.qcom.audio.decoder.aac".equals(str)) {
            String str5 = Util.DEVICE;
            if ("C1504".equals(str5) || "C1505".equals(str5) || "C1604".equals(str5) || "C1605".equals(str5)) {
                return false;
            }
        }
        if (i11 < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && Constants.REFERRER_API_SAMSUNG.equals(Util.MANUFACTURER))) {
            String str6 = Util.DEVICE;
            if (str6.startsWith("zeroflte") || str6.startsWith("zerolte") || str6.startsWith("zenlte") || "SC-05G".equals(str6) || "marinelteatt".equals(str6) || "404SC".equals(str6) || "SC-04G".equals(str6) || "SCV31".equals(str6)) {
                return false;
            }
        }
        if (i11 <= 19 && "OMX.SEC.vp8.dec".equals(str) && Constants.REFERRER_API_SAMSUNG.equals(Util.MANUFACTURER)) {
            String str7 = Util.DEVICE;
            if (str7.startsWith("d2") || str7.startsWith("serrano") || str7.startsWith("jflte") || str7.startsWith("santos") || str7.startsWith("t0")) {
                return false;
            }
        }
        if (i11 <= 19 && Util.DEVICE.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(str)) {
            return false;
        }
        if (i11 > 23 || !MimeTypes.AUDIO_E_AC3_JOC.equals(str2) || !"OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) {
            return true;
        }
        return false;
    }

    private static boolean isHardwareAccelerated(MediaCodecInfo mediaCodecInfo, String str) {
        if (Util.SDK_INT >= 29) {
            return isHardwareAcceleratedV29(mediaCodecInfo);
        }
        return !isSoftwareOnly(mediaCodecInfo, str);
    }

    @RequiresApi(29)
    private static boolean isHardwareAcceleratedV29(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isHardwareAccelerated();
    }

    private static boolean isSoftwareOnly(MediaCodecInfo mediaCodecInfo, String str) {
        if (Util.SDK_INT >= 29) {
            return isSoftwareOnlyV29(mediaCodecInfo);
        }
        if (MimeTypes.isAudio(str)) {
            return true;
        }
        String lowerCase = Ascii.toLowerCase(mediaCodecInfo.getName());
        if (lowerCase.startsWith("arc.")) {
            return false;
        }
        if (lowerCase.startsWith("omx.google.") || lowerCase.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((lowerCase.startsWith("omx.sec.") && lowerCase.contains(".sw.")) || lowerCase.equals("omx.qcom.video.decoder.hevcswvdec") || lowerCase.startsWith("c2.android.") || lowerCase.startsWith("c2.google.")) {
            return true;
        }
        if (lowerCase.startsWith("omx.") || lowerCase.startsWith("c2.")) {
            return false;
        }
        return true;
    }

    @RequiresApi(29)
    private static boolean isSoftwareOnlyV29(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isSoftwareOnly();
    }

    private static boolean isVendor(MediaCodecInfo mediaCodecInfo) {
        if (Util.SDK_INT >= 29) {
            return isVendorV29(mediaCodecInfo);
        }
        String lowerCase = Ascii.toLowerCase(mediaCodecInfo.getName());
        if (lowerCase.startsWith("omx.google.") || lowerCase.startsWith("c2.android.") || lowerCase.startsWith("c2.google.")) {
            return false;
        }
        return true;
    }

    @RequiresApi(29)
    private static boolean isVendorV29(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isVendor();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int lambda$applyWorkarounds$1(MediaCodecInfo mediaCodecInfo) {
        String str = mediaCodecInfo.f34956name;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        if (Util.SDK_INT >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
            return 0;
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int lambda$applyWorkarounds$2(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.f34956name.startsWith("OMX.google") ? 1 : 0;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int lambda$getDecoderInfosSortedByFormatSupport$0(Format format, MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isFormatFunctionallySupported(format) ? 1 : 0;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int lambda$sortByScore$3(ScoreProvider scoreProvider, Object obj, Object obj2) {
        return scoreProvider.getScore(obj2) - scoreProvider.getScore(obj);
    }

    public static int maxH264DecodableFrameSize() throws DecoderQueryException {
        int i11;
        if (maxH264DecodableFrameSize == -1) {
            int i12 = 0;
            MediaCodecInfo decoderInfo = getDecoderInfo(MimeTypes.VIDEO_H264, false, false);
            if (decoderInfo != null) {
                MediaCodecInfo.CodecProfileLevel[] profileLevels = decoderInfo.getProfileLevels();
                int length = profileLevels.length;
                int i13 = 0;
                while (i12 < length) {
                    i13 = Math.max(avcLevelToMaxFrameSize(profileLevels[i12].level), i13);
                    i12++;
                }
                if (Util.SDK_INT >= 21) {
                    i11 = 345600;
                } else {
                    i11 = 172800;
                }
                i12 = Math.max(i13, i11);
            }
            maxH264DecodableFrameSize = i12;
        }
        return maxH264DecodableFrameSize;
    }

    private static int mp4aAudioObjectTypeToProfile(int i11) {
        int i12 = 17;
        if (i11 != 17) {
            i12 = 20;
            if (i11 != 20) {
                i12 = 23;
                if (i11 != 23) {
                    i12 = 29;
                    if (i11 != 29) {
                        i12 = 39;
                        if (i11 != 39) {
                            i12 = 42;
                            if (i11 != 42) {
                                switch (i11) {
                                    case 1:
                                        return 1;
                                    case 2:
                                        return 2;
                                    case 3:
                                        return 3;
                                    case 4:
                                        return 4;
                                    case 5:
                                        return 5;
                                    case 6:
                                        return 6;
                                    default:
                                        return -1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return i12;
    }

    private static <T> void sortByScore(List<T> list, ScoreProvider<T> scoreProvider) {
        Collections.sort(list, new c(scoreProvider));
    }

    private static int vp9LevelNumberToConst(int i11) {
        if (i11 == 10) {
            return 1;
        }
        if (i11 == 11) {
            return 2;
        }
        if (i11 == 20) {
            return 4;
        }
        if (i11 == 21) {
            return 8;
        }
        if (i11 == 30) {
            return 16;
        }
        if (i11 == 31) {
            return 32;
        }
        if (i11 == 40) {
            return 64;
        }
        if (i11 == 41) {
            return 128;
        }
        if (i11 == 50) {
            return 256;
        }
        if (i11 == 51) {
            return 512;
        }
        switch (i11) {
            case 60:
                return 2048;
            case 61:
                return 4096;
            case 62:
                return 8192;
            default:
                return -1;
        }
    }

    private static int vp9ProfileNumberToConst(int i11) {
        if (i11 == 0) {
            return 1;
        }
        if (i11 == 1) {
            return 2;
        }
        if (i11 != 2) {
            return i11 != 3 ? -1 : 8;
        }
        return 4;
    }

    public static void warmDecoderInfoCache(String str, boolean z11, boolean z12) {
        try {
            getDecoderInfos(str, z11, z12);
        } catch (DecoderQueryException e11) {
            Log.e(TAG, "Codec warming failed", e11);
        }
    }
}

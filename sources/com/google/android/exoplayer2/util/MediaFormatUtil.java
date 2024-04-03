package com.google.android.exoplayer2.util;

import android.annotation.SuppressLint;
import android.media.MediaFormat;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.video.ColorInfo;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import java.nio.ByteBuffer;
import java.util.List;

public final class MediaFormatUtil {
    public static final String KEY_MAX_BIT_RATE = "max-bitrate";
    public static final String KEY_PCM_ENCODING_EXTENDED = "exo-pcm-encoding-int";
    public static final String KEY_PIXEL_WIDTH_HEIGHT_RATIO_FLOAT = "exo-pixel-width-height-ratio-float";
    private static final int MAX_POWER_OF_TWO_INT = 1073741824;

    private MediaFormatUtil() {
    }

    @SuppressLint({"InlinedApi"})
    public static MediaFormat createMediaFormatFromFormat(Format format) {
        MediaFormat mediaFormat = new MediaFormat();
        maybeSetInteger(mediaFormat, "bitrate", format.bitrate);
        maybeSetInteger(mediaFormat, KEY_MAX_BIT_RATE, format.peakBitrate);
        maybeSetInteger(mediaFormat, "channel-count", format.channelCount);
        maybeSetColorInfo(mediaFormat, format.colorInfo);
        maybeSetString(mediaFormat, "mime", format.sampleMimeType);
        maybeSetString(mediaFormat, "codecs-string", format.codecs);
        maybeSetFloat(mediaFormat, "frame-rate", format.frameRate);
        maybeSetInteger(mediaFormat, "width", format.width);
        maybeSetInteger(mediaFormat, "height", format.height);
        setCsdBuffers(mediaFormat, format.initializationData);
        maybeSetPcmEncoding(mediaFormat, format.pcmEncoding);
        maybeSetString(mediaFormat, ConstantsKt.ADJUST_LANGUAGE, format.language);
        maybeSetInteger(mediaFormat, "max-input-size", format.maxInputSize);
        maybeSetInteger(mediaFormat, "sample-rate", format.sampleRate);
        maybeSetInteger(mediaFormat, "caption-service-number", format.accessibilityChannel);
        mediaFormat.setInteger("rotation-degrees", format.rotationDegrees);
        int i11 = format.selectionFlags;
        setBooleanAsInt(mediaFormat, "is-autoselect", i11 & 4);
        setBooleanAsInt(mediaFormat, "is-default", i11 & 1);
        setBooleanAsInt(mediaFormat, "is-forced-subtitle", i11 & 2);
        mediaFormat.setInteger("encoder-delay", format.encoderDelay);
        mediaFormat.setInteger("encoder-padding", format.encoderPadding);
        maybeSetPixelAspectRatio(mediaFormat, format.pixelWidthHeightRatio);
        return mediaFormat;
    }

    public static byte[] getArray(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return bArr;
    }

    @Nullable
    public static ColorInfo getColorInfo(MediaFormat mediaFormat) {
        byte[] bArr;
        if (Util.SDK_INT < 29) {
            return null;
        }
        int a11 = mediaFormat.getInteger("color-standard", -1);
        int a12 = mediaFormat.getInteger("color-range", -1);
        int a13 = mediaFormat.getInteger("color-transfer", -1);
        ByteBuffer byteBuffer = mediaFormat.getByteBuffer("hdr-static-info");
        if (byteBuffer != null) {
            bArr = getArray(byteBuffer);
        } else {
            bArr = null;
        }
        if (!isValidColorSpace(a11)) {
            a11 = -1;
        }
        if (!isValidColorRange(a12)) {
            a12 = -1;
        }
        if (!isValidColorTransfer(a13)) {
            a13 = -1;
        }
        if (a11 == -1 && a12 == -1 && a13 == -1 && bArr == null) {
            return null;
        }
        return new ColorInfo(a11, a12, a13, bArr);
    }

    private static boolean isValidColorRange(int i11) {
        return i11 == 2 || i11 == 1 || i11 == -1;
    }

    private static boolean isValidColorSpace(int i11) {
        return i11 == 2 || i11 == 1 || i11 == 6 || i11 == -1;
    }

    private static boolean isValidColorTransfer(int i11) {
        return i11 == 3 || i11 == 6 || i11 == 7 || i11 == -1;
    }

    public static void maybeSetByteBuffer(MediaFormat mediaFormat, String str, @Nullable byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
        }
    }

    public static void maybeSetColorInfo(MediaFormat mediaFormat, @Nullable ColorInfo colorInfo) {
        if (colorInfo != null) {
            maybeSetInteger(mediaFormat, "color-transfer", colorInfo.colorTransfer);
            maybeSetInteger(mediaFormat, "color-standard", colorInfo.colorSpace);
            maybeSetInteger(mediaFormat, "color-range", colorInfo.colorRange);
            maybeSetByteBuffer(mediaFormat, "hdr-static-info", colorInfo.hdrStaticInfo);
        }
    }

    public static void maybeSetFloat(MediaFormat mediaFormat, String str, float f11) {
        if (f11 != -1.0f) {
            mediaFormat.setFloat(str, f11);
        }
    }

    public static void maybeSetInteger(MediaFormat mediaFormat, String str, int i11) {
        if (i11 != -1) {
            mediaFormat.setInteger(str, i11);
        }
    }

    @SuppressLint({"InlinedApi"})
    private static void maybeSetPcmEncoding(MediaFormat mediaFormat, int i11) {
        int i12;
        if (i11 != -1) {
            maybeSetInteger(mediaFormat, KEY_PCM_ENCODING_EXTENDED, i11);
            if (i11 == 0) {
                i12 = 0;
            } else if (i11 == 536870912) {
                i12 = 21;
            } else if (i11 != 805306368) {
                i12 = 2;
                if (i11 != 2) {
                    i12 = 3;
                    if (i11 != 3) {
                        i12 = 4;
                        if (i11 != 4) {
                            return;
                        }
                    }
                }
            } else {
                i12 = 22;
            }
            mediaFormat.setInteger("pcm-encoding", i12);
        }
    }

    @SuppressLint({"InlinedApi"})
    private static void maybeSetPixelAspectRatio(MediaFormat mediaFormat, float f11) {
        int i11;
        mediaFormat.setFloat(KEY_PIXEL_WIDTH_HEIGHT_RATIO_FLOAT, f11);
        int i12 = 1073741824;
        if (f11 < 1.0f) {
            i12 = (int) (f11 * ((float) 1073741824));
            i11 = 1073741824;
        } else if (f11 > 1.0f) {
            i11 = (int) (((float) 1073741824) / f11);
        } else {
            i12 = 1;
            i11 = 1;
        }
        mediaFormat.setInteger("sar-width", i12);
        mediaFormat.setInteger("sar-height", i11);
    }

    public static void maybeSetString(MediaFormat mediaFormat, String str, @Nullable String str2) {
        if (str2 != null) {
            mediaFormat.setString(str, str2);
        }
    }

    private static void setBooleanAsInt(MediaFormat mediaFormat, String str, int i11) {
        mediaFormat.setInteger(str, i11 != 0 ? 1 : 0);
    }

    public static void setCsdBuffers(MediaFormat mediaFormat, List<byte[]> list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            mediaFormat.setByteBuffer("csd-" + i11, ByteBuffer.wrap(list.get(i11)));
        }
    }
}

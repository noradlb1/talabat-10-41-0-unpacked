package com.instabug.library.internal.video.customencoding;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.common.util.GmsVersion;
import com.instabug.library.internal.video.InstabugVideoUtils;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@TargetApi(21)
public class s {

    /* renamed from: a  reason: collision with root package name */
    private final int f51214a;

    /* renamed from: b  reason: collision with root package name */
    private final int f51215b;

    /* renamed from: c  reason: collision with root package name */
    private final int f51216c;

    /* renamed from: d  reason: collision with root package name */
    private final String f51217d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private MediaCodecInfo f51218e;

    public s(int i11, int i12, int i13) {
        String str;
        double[] a11 = a((double) i11, (double) i12);
        this.f51214a = (int) a11[0];
        this.f51215b = (int) a11[1];
        this.f51216c = i13;
        MediaCodecInfo b11 = b(MimeTypes.VIDEO_H264);
        if (b11 != null) {
            str = b11.getName();
        } else {
            str = "";
        }
        this.f51217d = str;
    }

    @Nullable
    private MediaCodecInfo b(String str) {
        if (str == null) {
            return null;
        }
        if (this.f51218e == null) {
            this.f51218e = a(MimeTypes.VIDEO_H264);
        }
        return this.f51218e;
    }

    public String a() {
        VideoEncoderConfig videoEncoderConfig = SettingsManager.getVideoEncoderConfig();
        return videoEncoderConfig != null ? videoEncoderConfig.getCodec() : this.f51217d;
    }

    public int c() {
        return this.f51215b;
    }

    public int d() {
        return this.f51214a;
    }

    public MediaFormat e() {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        VideoEncoderConfig videoEncoderConfig = SettingsManager.getVideoEncoderConfig();
        InstabugSDKLogger.d("IBG-Core", "Custom Video Encoder Config: " + videoEncoderConfig);
        if (videoEncoderConfig != null) {
            i12 = videoEncoderConfig.getWidth();
            i11 = videoEncoderConfig.getHeight();
        } else {
            i12 = this.f51214a;
            i11 = this.f51215b;
        }
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(MimeTypes.VIDEO_H264, i12, (i11 / 16) * 16);
        if (videoEncoderConfig != null) {
            i13 = videoEncoderConfig.getColorFormat();
        } else {
            i13 = 2130708361;
        }
        createVideoFormat.setInteger("color-format", i13);
        if (videoEncoderConfig != null) {
            i14 = videoEncoderConfig.getBitrate();
        } else {
            i14 = GmsVersion.VERSION_SAGA;
        }
        createVideoFormat.setInteger("bitrate", i14);
        if (videoEncoderConfig != null) {
            i15 = videoEncoderConfig.getFrameRate();
        } else {
            i15 = 30;
        }
        createVideoFormat.setInteger("frame-rate", i15);
        if (videoEncoderConfig != null) {
            i16 = videoEncoderConfig.getIFrameInterval();
        } else {
            i16 = 5;
        }
        createVideoFormat.setInteger("i-frame-interval", i16);
        return createVideoFormat;
    }

    @NonNull
    public String toString() {
        return "VideoEncodeConfig{width=" + this.f51214a + ", height=" + this.f51215b + ", bitrate=" + GmsVersion.VERSION_SAGA + ", framerate=" + 30 + ", iframeInterval=" + 5 + ", codecName='" + a() + '\'' + ", mimeType='" + MimeTypes.VIDEO_H264 + '\'' + AbstractJsonLexerKt.END_OBJ;
    }

    @Nullable
    private MediaCodecInfo a(String str) {
        for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(1).getCodecInfos()) {
            if (mediaCodecInfo.isEncoder()) {
                try {
                    if (mediaCodecInfo.getCapabilitiesForType(str) != null) {
                        return mediaCodecInfo;
                    }
                } catch (IllegalArgumentException unused) {
                    continue;
                }
            }
        }
        return null;
    }

    public int b() {
        return this.f51216c / 4;
    }

    @Size(2)
    private double[] a(double d11, double d12) {
        MediaCodecInfo b11 = b(MimeTypes.VIDEO_H264);
        if (b11 == null) {
            return new double[]{0.0d, 0.0d};
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = b11.getCapabilitiesForType(MimeTypes.VIDEO_H264).getVideoCapabilities();
        return InstabugVideoUtils.getDimensInBounded(d11, d12, (double) videoCapabilities.getSupportedWidths().getUpper().intValue(), (double) videoCapabilities.getSupportedHeights().getUpper().intValue());
    }
}

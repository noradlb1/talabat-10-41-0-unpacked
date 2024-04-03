package com.instabug.library.internal.video.customencoding;

import androidx.annotation.RequiresApi;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@RequiresApi(18)
public final class VideoEncoderConfig {
    private final int bitrate;
    @NotNull
    private final String codec;
    private final int colorFormat;
    private final int frameRate;
    private final int height;
    private final int iFrameInterval;
    private final int width;

    @JvmOverloads
    public VideoEncoderConfig(int i11, int i12) {
        this(i11, i12, 0, 0, 0, (String) null, 0, 124, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public VideoEncoderConfig(int i11, int i12, int i13) {
        this(i11, i12, i13, 0, 0, (String) null, 0, 120, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public VideoEncoderConfig(int i11, int i12, int i13, int i14) {
        this(i11, i12, i13, i14, 0, (String) null, 0, 112, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public VideoEncoderConfig(int i11, int i12, int i13, int i14, int i15) {
        this(i11, i12, i13, i14, i15, (String) null, 0, 96, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public VideoEncoderConfig(int r12, int r13, int r14, int r15, int r16, @org.jetbrains.annotations.NotNull java.lang.String r17) {
        /*
            r11 = this;
            java.lang.String r0 = "codec"
            r7 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r8 = 0
            r9 = 64
            r10 = 0
            r1 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r5 = r15
            r6 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.video.customencoding.VideoEncoderConfig.<init>(int, int, int, int, int, java.lang.String):void");
    }

    @JvmOverloads
    public VideoEncoderConfig(int i11, int i12, int i13, int i14, int i15, @NotNull String str, int i16) {
        Intrinsics.checkNotNullParameter(str, "codec");
        this.height = i11;
        this.width = i12;
        this.bitrate = i13;
        this.iFrameInterval = i14;
        this.frameRate = i15;
        this.codec = str;
        this.colorFormat = i16;
    }

    public static /* synthetic */ VideoEncoderConfig copy$default(VideoEncoderConfig videoEncoderConfig, int i11, int i12, int i13, int i14, int i15, String str, int i16, int i17, Object obj) {
        if ((i17 & 1) != 0) {
            i11 = videoEncoderConfig.height;
        }
        if ((i17 & 2) != 0) {
            i12 = videoEncoderConfig.width;
        }
        int i18 = i12;
        if ((i17 & 4) != 0) {
            i13 = videoEncoderConfig.bitrate;
        }
        int i19 = i13;
        if ((i17 & 8) != 0) {
            i14 = videoEncoderConfig.iFrameInterval;
        }
        int i21 = i14;
        if ((i17 & 16) != 0) {
            i15 = videoEncoderConfig.frameRate;
        }
        int i22 = i15;
        if ((i17 & 32) != 0) {
            str = videoEncoderConfig.codec;
        }
        String str2 = str;
        if ((i17 & 64) != 0) {
            i16 = videoEncoderConfig.colorFormat;
        }
        return videoEncoderConfig.copy(i11, i18, i19, i21, i22, str2, i16);
    }

    public final int component1() {
        return this.height;
    }

    public final int component2() {
        return this.width;
    }

    public final int component3() {
        return this.bitrate;
    }

    public final int component4() {
        return this.iFrameInterval;
    }

    public final int component5() {
        return this.frameRate;
    }

    @NotNull
    public final String component6() {
        return this.codec;
    }

    public final int component7() {
        return this.colorFormat;
    }

    @NotNull
    public final VideoEncoderConfig copy(int i11, int i12, int i13, int i14, int i15, @NotNull String str, int i16) {
        Intrinsics.checkNotNullParameter(str, "codec");
        return new VideoEncoderConfig(i11, i12, i13, i14, i15, str, i16);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoEncoderConfig)) {
            return false;
        }
        VideoEncoderConfig videoEncoderConfig = (VideoEncoderConfig) obj;
        return this.height == videoEncoderConfig.height && this.width == videoEncoderConfig.width && this.bitrate == videoEncoderConfig.bitrate && this.iFrameInterval == videoEncoderConfig.iFrameInterval && this.frameRate == videoEncoderConfig.frameRate && Intrinsics.areEqual((Object) this.codec, (Object) videoEncoderConfig.codec) && this.colorFormat == videoEncoderConfig.colorFormat;
    }

    public final int getBitrate() {
        return this.bitrate;
    }

    @NotNull
    public final String getCodec() {
        return this.codec;
    }

    public final int getColorFormat() {
        return this.colorFormat;
    }

    public final int getFrameRate() {
        return this.frameRate;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getIFrameInterval() {
        return this.iFrameInterval;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((((((((((this.height * 31) + this.width) * 31) + this.bitrate) * 31) + this.iFrameInterval) * 31) + this.frameRate) * 31) + this.codec.hashCode()) * 31) + this.colorFormat;
    }

    @NotNull
    public String toString() {
        return "VideoEncoderConfig(height=" + this.height + ", width=" + this.width + ", bitrate=" + this.bitrate + ", iFrameInterval=" + this.iFrameInterval + ", frameRate=" + this.frameRate + ", codec=" + this.codec + ", colorFormat=" + this.colorFormat + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VideoEncoderConfig(int i11, int i12, int i13, int i14, int i15, String str, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, i12, (i17 & 4) != 0 ? 8000000 : i13, (i17 & 8) != 0 ? 5 : i14, (i17 & 16) != 0 ? 30 : i15, (i17 & 32) != 0 ? "OMX.MTK.VIDEO.ENCODER.AVC" : str, (i17 & 64) != 0 ? 2130708361 : i16);
    }
}

package com.google.android.exoplayer2;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.facebook.share.internal.ShareConstants;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.BundleableUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.common.base.Joiner;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.huawei.hms.flutter.map.constants.Param;
import g7.n0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import net.bytebuddy.utility.JavaConstant;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public final class Format implements Bundleable {
    public static final Bundleable.Creator<Format> CREATOR = new n0();
    private static final Format DEFAULT = new Builder().build();
    private static final String FIELD_ACCESSIBILITY_CHANNEL = Util.intToStringMaxRadix(28);
    private static final String FIELD_AVERAGE_BITRATE = Util.intToStringMaxRadix(5);
    private static final String FIELD_CHANNEL_COUNT = Util.intToStringMaxRadix(23);
    private static final String FIELD_CODECS = Util.intToStringMaxRadix(7);
    private static final String FIELD_COLOR_INFO = Util.intToStringMaxRadix(22);
    private static final String FIELD_CONTAINER_MIME_TYPE = Util.intToStringMaxRadix(9);
    private static final String FIELD_CRYPTO_TYPE = Util.intToStringMaxRadix(29);
    private static final String FIELD_DRM_INIT_DATA = Util.intToStringMaxRadix(13);
    private static final String FIELD_ENCODER_DELAY = Util.intToStringMaxRadix(26);
    private static final String FIELD_ENCODER_PADDING = Util.intToStringMaxRadix(27);
    private static final String FIELD_FRAME_RATE = Util.intToStringMaxRadix(17);
    private static final String FIELD_HEIGHT = Util.intToStringMaxRadix(16);
    private static final String FIELD_ID = Util.intToStringMaxRadix(0);
    private static final String FIELD_INITIALIZATION_DATA = Util.intToStringMaxRadix(12);
    private static final String FIELD_LABEL = Util.intToStringMaxRadix(1);
    private static final String FIELD_LANGUAGE = Util.intToStringMaxRadix(2);
    private static final String FIELD_MAX_INPUT_SIZE = Util.intToStringMaxRadix(11);
    private static final String FIELD_METADATA = Util.intToStringMaxRadix(8);
    private static final String FIELD_PCM_ENCODING = Util.intToStringMaxRadix(25);
    private static final String FIELD_PEAK_BITRATE = Util.intToStringMaxRadix(6);
    private static final String FIELD_PIXEL_WIDTH_HEIGHT_RATIO = Util.intToStringMaxRadix(19);
    private static final String FIELD_PROJECTION_DATA = Util.intToStringMaxRadix(20);
    private static final String FIELD_ROLE_FLAGS = Util.intToStringMaxRadix(4);
    private static final String FIELD_ROTATION_DEGREES = Util.intToStringMaxRadix(18);
    private static final String FIELD_SAMPLE_MIME_TYPE = Util.intToStringMaxRadix(10);
    private static final String FIELD_SAMPLE_RATE = Util.intToStringMaxRadix(24);
    private static final String FIELD_SELECTION_FLAGS = Util.intToStringMaxRadix(3);
    private static final String FIELD_STEREO_MODE = Util.intToStringMaxRadix(21);
    private static final String FIELD_SUBSAMPLE_OFFSET_US = Util.intToStringMaxRadix(14);
    private static final String FIELD_TILE_COUNT_HORIZONTAL = Util.intToStringMaxRadix(30);
    private static final String FIELD_TILE_COUNT_VERTICAL = Util.intToStringMaxRadix(31);
    private static final String FIELD_WIDTH = Util.intToStringMaxRadix(15);
    public static final int NO_VALUE = -1;
    public static final long OFFSET_SAMPLE_RELATIVE = Long.MAX_VALUE;
    public final int accessibilityChannel;
    public final int averageBitrate;
    public final int bitrate;
    public final int channelCount;
    @Nullable
    public final String codecs;
    @Nullable
    public final ColorInfo colorInfo;
    @Nullable
    public final String containerMimeType;
    public final int cryptoType;
    @Nullable
    public final DrmInitData drmInitData;
    public final int encoderDelay;
    public final int encoderPadding;
    public final float frameRate;
    private int hashCode;
    public final int height;
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    public final String f34900id;
    public final List<byte[]> initializationData;
    @Nullable
    public final String label;
    @Nullable
    public final String language;
    public final int maxInputSize;
    @Nullable
    public final Metadata metadata;
    public final int pcmEncoding;
    public final int peakBitrate;
    public final float pixelWidthHeightRatio;
    @Nullable
    public final byte[] projectionData;
    public final int roleFlags;
    public final int rotationDegrees;
    @Nullable
    public final String sampleMimeType;
    public final int sampleRate;
    public final int selectionFlags;
    public final int stereoMode;
    public final long subsampleOffsetUs;
    public final int tileCountHorizontal;
    public final int tileCountVertical;
    public final int width;

    public static final class Builder {
        /* access modifiers changed from: private */
        public int accessibilityChannel;
        /* access modifiers changed from: private */
        public int averageBitrate;
        /* access modifiers changed from: private */
        public int channelCount;
        /* access modifiers changed from: private */
        @Nullable
        public String codecs;
        /* access modifiers changed from: private */
        @Nullable
        public ColorInfo colorInfo;
        /* access modifiers changed from: private */
        @Nullable
        public String containerMimeType;
        /* access modifiers changed from: private */
        public int cryptoType;
        /* access modifiers changed from: private */
        @Nullable
        public DrmInitData drmInitData;
        /* access modifiers changed from: private */
        public int encoderDelay;
        /* access modifiers changed from: private */
        public int encoderPadding;
        /* access modifiers changed from: private */
        public float frameRate;
        /* access modifiers changed from: private */
        public int height;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: id  reason: collision with root package name */
        public String f34901id;
        /* access modifiers changed from: private */
        @Nullable
        public List<byte[]> initializationData;
        /* access modifiers changed from: private */
        @Nullable
        public String label;
        /* access modifiers changed from: private */
        @Nullable
        public String language;
        /* access modifiers changed from: private */
        public int maxInputSize;
        /* access modifiers changed from: private */
        @Nullable
        public Metadata metadata;
        /* access modifiers changed from: private */
        public int pcmEncoding;
        /* access modifiers changed from: private */
        public int peakBitrate;
        /* access modifiers changed from: private */
        public float pixelWidthHeightRatio;
        /* access modifiers changed from: private */
        @Nullable
        public byte[] projectionData;
        /* access modifiers changed from: private */
        public int roleFlags;
        /* access modifiers changed from: private */
        public int rotationDegrees;
        /* access modifiers changed from: private */
        @Nullable
        public String sampleMimeType;
        /* access modifiers changed from: private */
        public int sampleRate;
        /* access modifiers changed from: private */
        public int selectionFlags;
        /* access modifiers changed from: private */
        public int stereoMode;
        /* access modifiers changed from: private */
        public long subsampleOffsetUs;
        /* access modifiers changed from: private */
        public int tileCountHorizontal;
        /* access modifiers changed from: private */
        public int tileCountVertical;
        /* access modifiers changed from: private */
        public int width;

        public Format build() {
            return new Format(this);
        }

        @CanIgnoreReturnValue
        public Builder setAccessibilityChannel(int i11) {
            this.accessibilityChannel = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setAverageBitrate(int i11) {
            this.averageBitrate = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setChannelCount(int i11) {
            this.channelCount = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setCodecs(@Nullable String str) {
            this.codecs = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setColorInfo(@Nullable ColorInfo colorInfo2) {
            this.colorInfo = colorInfo2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setContainerMimeType(@Nullable String str) {
            this.containerMimeType = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setCryptoType(int i11) {
            this.cryptoType = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setDrmInitData(@Nullable DrmInitData drmInitData2) {
            this.drmInitData = drmInitData2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setEncoderDelay(int i11) {
            this.encoderDelay = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setEncoderPadding(int i11) {
            this.encoderPadding = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setFrameRate(float f11) {
            this.frameRate = f11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setHeight(int i11) {
            this.height = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setId(@Nullable String str) {
            this.f34901id = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setInitializationData(@Nullable List<byte[]> list) {
            this.initializationData = list;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setLabel(@Nullable String str) {
            this.label = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setLanguage(@Nullable String str) {
            this.language = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setMaxInputSize(int i11) {
            this.maxInputSize = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setMetadata(@Nullable Metadata metadata2) {
            this.metadata = metadata2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setPcmEncoding(int i11) {
            this.pcmEncoding = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setPeakBitrate(int i11) {
            this.peakBitrate = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setPixelWidthHeightRatio(float f11) {
            this.pixelWidthHeightRatio = f11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setProjectionData(@Nullable byte[] bArr) {
            this.projectionData = bArr;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setRoleFlags(int i11) {
            this.roleFlags = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setRotationDegrees(int i11) {
            this.rotationDegrees = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setSampleMimeType(@Nullable String str) {
            this.sampleMimeType = str;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setSampleRate(int i11) {
            this.sampleRate = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setSelectionFlags(int i11) {
            this.selectionFlags = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setStereoMode(int i11) {
            this.stereoMode = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setSubsampleOffsetUs(long j11) {
            this.subsampleOffsetUs = j11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setTileCountHorizontal(int i11) {
            this.tileCountHorizontal = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setTileCountVertical(int i11) {
            this.tileCountVertical = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setWidth(int i11) {
            this.width = i11;
            return this;
        }

        public Builder() {
            this.averageBitrate = -1;
            this.peakBitrate = -1;
            this.maxInputSize = -1;
            this.subsampleOffsetUs = Long.MAX_VALUE;
            this.width = -1;
            this.height = -1;
            this.frameRate = -1.0f;
            this.pixelWidthHeightRatio = 1.0f;
            this.stereoMode = -1;
            this.channelCount = -1;
            this.sampleRate = -1;
            this.pcmEncoding = -1;
            this.accessibilityChannel = -1;
            this.tileCountHorizontal = -1;
            this.tileCountVertical = -1;
            this.cryptoType = 0;
        }

        @CanIgnoreReturnValue
        public Builder setId(int i11) {
            this.f34901id = Integer.toString(i11);
            return this;
        }

        private Builder(Format format) {
            this.f34901id = format.f34900id;
            this.label = format.label;
            this.language = format.language;
            this.selectionFlags = format.selectionFlags;
            this.roleFlags = format.roleFlags;
            this.averageBitrate = format.averageBitrate;
            this.peakBitrate = format.peakBitrate;
            this.codecs = format.codecs;
            this.metadata = format.metadata;
            this.containerMimeType = format.containerMimeType;
            this.sampleMimeType = format.sampleMimeType;
            this.maxInputSize = format.maxInputSize;
            this.initializationData = format.initializationData;
            this.drmInitData = format.drmInitData;
            this.subsampleOffsetUs = format.subsampleOffsetUs;
            this.width = format.width;
            this.height = format.height;
            this.frameRate = format.frameRate;
            this.rotationDegrees = format.rotationDegrees;
            this.pixelWidthHeightRatio = format.pixelWidthHeightRatio;
            this.projectionData = format.projectionData;
            this.stereoMode = format.stereoMode;
            this.colorInfo = format.colorInfo;
            this.channelCount = format.channelCount;
            this.sampleRate = format.sampleRate;
            this.pcmEncoding = format.pcmEncoding;
            this.encoderDelay = format.encoderDelay;
            this.encoderPadding = format.encoderPadding;
            this.accessibilityChannel = format.accessibilityChannel;
            this.tileCountHorizontal = format.tileCountHorizontal;
            this.tileCountVertical = format.tileCountVertical;
            this.cryptoType = format.cryptoType;
        }
    }

    @Deprecated
    public static Format createAudioSampleFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, int i11, int i12, int i13, int i14, @Nullable List<byte[]> list, @Nullable DrmInitData drmInitData2, int i15, @Nullable String str4) {
        return new Builder().setId(str).setLanguage(str4).setSelectionFlags(i15).setAverageBitrate(i11).setPeakBitrate(i11).setCodecs(str3).setSampleMimeType(str2).setMaxInputSize(i12).setInitializationData(list).setDrmInitData(drmInitData2).setChannelCount(i13).setSampleRate(i14).build();
    }

    @Deprecated
    public static Format createContainerFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, int i11, int i12, int i13, @Nullable String str6) {
        return new Builder().setId(str).setLabel(str2).setLanguage(str6).setSelectionFlags(i12).setRoleFlags(i13).setAverageBitrate(i11).setPeakBitrate(i11).setCodecs(str5).setContainerMimeType(str3).setSampleMimeType(str4).build();
    }

    @Deprecated
    public static Format createSampleFormat(@Nullable String str, @Nullable String str2) {
        return new Builder().setId(str).setSampleMimeType(str2).build();
    }

    @Deprecated
    public static Format createVideoSampleFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, int i11, int i12, int i13, int i14, float f11, @Nullable List<byte[]> list, @Nullable DrmInitData drmInitData2) {
        return new Builder().setId(str).setAverageBitrate(i11).setPeakBitrate(i11).setCodecs(str3).setSampleMimeType(str2).setMaxInputSize(i12).setInitializationData(list).setDrmInitData(drmInitData2).setWidth(i13).setHeight(i14).setFrameRate(f11).build();
    }

    @Nullable
    private static <T> T defaultIfNull(@Nullable T t11, @Nullable T t12) {
        return t11 != null ? t11 : t12;
    }

    /* access modifiers changed from: private */
    public static Format fromBundle(Bundle bundle) {
        Builder builder = new Builder();
        BundleableUtil.ensureClassLoader(bundle);
        String string = bundle.getString(FIELD_ID);
        Format format = DEFAULT;
        builder.setId((String) defaultIfNull(string, format.f34900id)).setLabel((String) defaultIfNull(bundle.getString(FIELD_LABEL), format.label)).setLanguage((String) defaultIfNull(bundle.getString(FIELD_LANGUAGE), format.language)).setSelectionFlags(bundle.getInt(FIELD_SELECTION_FLAGS, format.selectionFlags)).setRoleFlags(bundle.getInt(FIELD_ROLE_FLAGS, format.roleFlags)).setAverageBitrate(bundle.getInt(FIELD_AVERAGE_BITRATE, format.averageBitrate)).setPeakBitrate(bundle.getInt(FIELD_PEAK_BITRATE, format.peakBitrate)).setCodecs((String) defaultIfNull(bundle.getString(FIELD_CODECS), format.codecs)).setMetadata((Metadata) defaultIfNull((Metadata) bundle.getParcelable(FIELD_METADATA), format.metadata)).setContainerMimeType((String) defaultIfNull(bundle.getString(FIELD_CONTAINER_MIME_TYPE), format.containerMimeType)).setSampleMimeType((String) defaultIfNull(bundle.getString(FIELD_SAMPLE_MIME_TYPE), format.sampleMimeType)).setMaxInputSize(bundle.getInt(FIELD_MAX_INPUT_SIZE, format.maxInputSize));
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        while (true) {
            byte[] byteArray = bundle.getByteArray(keyForInitializationData(i11));
            if (byteArray == null) {
                break;
            }
            arrayList.add(byteArray);
            i11++;
        }
        Builder drmInitData2 = builder.setInitializationData(arrayList).setDrmInitData((DrmInitData) bundle.getParcelable(FIELD_DRM_INIT_DATA));
        String str = FIELD_SUBSAMPLE_OFFSET_US;
        Format format2 = DEFAULT;
        drmInitData2.setSubsampleOffsetUs(bundle.getLong(str, format2.subsampleOffsetUs)).setWidth(bundle.getInt(FIELD_WIDTH, format2.width)).setHeight(bundle.getInt(FIELD_HEIGHT, format2.height)).setFrameRate(bundle.getFloat(FIELD_FRAME_RATE, format2.frameRate)).setRotationDegrees(bundle.getInt(FIELD_ROTATION_DEGREES, format2.rotationDegrees)).setPixelWidthHeightRatio(bundle.getFloat(FIELD_PIXEL_WIDTH_HEIGHT_RATIO, format2.pixelWidthHeightRatio)).setProjectionData(bundle.getByteArray(FIELD_PROJECTION_DATA)).setStereoMode(bundle.getInt(FIELD_STEREO_MODE, format2.stereoMode));
        Bundle bundle2 = bundle.getBundle(FIELD_COLOR_INFO);
        if (bundle2 != null) {
            builder.setColorInfo(ColorInfo.CREATOR.fromBundle(bundle2));
        }
        builder.setChannelCount(bundle.getInt(FIELD_CHANNEL_COUNT, format2.channelCount)).setSampleRate(bundle.getInt(FIELD_SAMPLE_RATE, format2.sampleRate)).setPcmEncoding(bundle.getInt(FIELD_PCM_ENCODING, format2.pcmEncoding)).setEncoderDelay(bundle.getInt(FIELD_ENCODER_DELAY, format2.encoderDelay)).setEncoderPadding(bundle.getInt(FIELD_ENCODER_PADDING, format2.encoderPadding)).setAccessibilityChannel(bundle.getInt(FIELD_ACCESSIBILITY_CHANNEL, format2.accessibilityChannel)).setTileCountHorizontal(bundle.getInt(FIELD_TILE_COUNT_HORIZONTAL, format2.tileCountHorizontal)).setTileCountVertical(bundle.getInt(FIELD_TILE_COUNT_VERTICAL, format2.tileCountVertical)).setCryptoType(bundle.getInt(FIELD_CRYPTO_TYPE, format2.cryptoType));
        return builder.build();
    }

    private static String keyForInitializationData(int i11) {
        return FIELD_INITIALIZATION_DATA + JavaConstant.Dynamic.DEFAULT_NAME + Integer.toString(i11, 36);
    }

    public static String toLogString(@Nullable Format format) {
        if (format == null) {
            return "null";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("id=");
        sb2.append(format.f34900id);
        sb2.append(", mimeType=");
        sb2.append(format.sampleMimeType);
        if (format.bitrate != -1) {
            sb2.append(", bitrate=");
            sb2.append(format.bitrate);
        }
        if (format.codecs != null) {
            sb2.append(", codecs=");
            sb2.append(format.codecs);
        }
        if (format.drmInitData != null) {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int i11 = 0;
            while (true) {
                DrmInitData drmInitData2 = format.drmInitData;
                if (i11 >= drmInitData2.schemeDataCount) {
                    break;
                }
                UUID uuid = drmInitData2.get(i11).uuid;
                if (uuid.equals(C.COMMON_PSSH_UUID)) {
                    linkedHashSet.add(C.CENC_TYPE_cenc);
                } else if (uuid.equals(C.CLEARKEY_UUID)) {
                    linkedHashSet.add("clearkey");
                } else if (uuid.equals(C.PLAYREADY_UUID)) {
                    linkedHashSet.add("playready");
                } else if (uuid.equals(C.WIDEVINE_UUID)) {
                    linkedHashSet.add("widevine");
                } else if (uuid.equals(C.UUID_NIL)) {
                    linkedHashSet.add("universal");
                } else {
                    linkedHashSet.add("unknown (" + uuid + ")");
                }
                i11++;
            }
            sb2.append(", drm=[");
            Joiner.on((char) AbstractJsonLexerKt.COMMA).appendTo(sb2, (Iterable<? extends Object>) linkedHashSet);
            sb2.append(AbstractJsonLexerKt.END_LIST);
        }
        if (!(format.width == -1 || format.height == -1)) {
            sb2.append(", res=");
            sb2.append(format.width);
            sb2.append(Param.X);
            sb2.append(format.height);
        }
        if (format.frameRate != -1.0f) {
            sb2.append(", fps=");
            sb2.append(format.frameRate);
        }
        if (format.channelCount != -1) {
            sb2.append(", channels=");
            sb2.append(format.channelCount);
        }
        if (format.sampleRate != -1) {
            sb2.append(", sample_rate=");
            sb2.append(format.sampleRate);
        }
        if (format.language != null) {
            sb2.append(", language=");
            sb2.append(format.language);
        }
        if (format.label != null) {
            sb2.append(", label=");
            sb2.append(format.label);
        }
        if (format.selectionFlags != 0) {
            ArrayList arrayList = new ArrayList();
            if ((format.selectionFlags & 4) != 0) {
                arrayList.add("auto");
            }
            if ((format.selectionFlags & 1) != 0) {
                arrayList.add("default");
            }
            if ((format.selectionFlags & 2) != 0) {
                arrayList.add("forced");
            }
            sb2.append(", selectionFlags=[");
            Joiner.on((char) AbstractJsonLexerKt.COMMA).appendTo(sb2, (Iterable<? extends Object>) arrayList);
            sb2.append("]");
        }
        if (format.roleFlags != 0) {
            ArrayList arrayList2 = new ArrayList();
            if ((format.roleFlags & 1) != 0) {
                arrayList2.add("main");
            }
            if ((format.roleFlags & 2) != 0) {
                arrayList2.add("alt");
            }
            if ((format.roleFlags & 4) != 0) {
                arrayList2.add("supplementary");
            }
            if ((format.roleFlags & 8) != 0) {
                arrayList2.add("commentary");
            }
            if ((format.roleFlags & 16) != 0) {
                arrayList2.add("dub");
            }
            if ((format.roleFlags & 32) != 0) {
                arrayList2.add("emergency");
            }
            if ((format.roleFlags & 64) != 0) {
                arrayList2.add(ShareConstants.FEED_CAPTION_PARAM);
            }
            if ((format.roleFlags & 128) != 0) {
                arrayList2.add("subtitle");
            }
            if ((format.roleFlags & 256) != 0) {
                arrayList2.add("sign");
            }
            if ((format.roleFlags & 512) != 0) {
                arrayList2.add("describes-video");
            }
            if ((format.roleFlags & 1024) != 0) {
                arrayList2.add("describes-music");
            }
            if ((format.roleFlags & 2048) != 0) {
                arrayList2.add("enhanced-intelligibility");
            }
            if ((format.roleFlags & 4096) != 0) {
                arrayList2.add("transcribes-dialog");
            }
            if ((format.roleFlags & 8192) != 0) {
                arrayList2.add("easy-read");
            }
            if ((format.roleFlags & 16384) != 0) {
                arrayList2.add("trick-play");
            }
            sb2.append(", roleFlags=[");
            Joiner.on((char) AbstractJsonLexerKt.COMMA).appendTo(sb2, (Iterable<? extends Object>) arrayList2);
            sb2.append("]");
        }
        return sb2.toString();
    }

    public Builder buildUpon() {
        return new Builder();
    }

    @Deprecated
    public Format copyWithBitrate(int i11) {
        return buildUpon().setAverageBitrate(i11).setPeakBitrate(i11).build();
    }

    public Format copyWithCryptoType(int i11) {
        return buildUpon().setCryptoType(i11).build();
    }

    @Deprecated
    public Format copyWithDrmInitData(@Nullable DrmInitData drmInitData2) {
        return buildUpon().setDrmInitData(drmInitData2).build();
    }

    @Deprecated
    public Format copyWithFrameRate(float f11) {
        return buildUpon().setFrameRate(f11).build();
    }

    @Deprecated
    public Format copyWithGaplessInfo(int i11, int i12) {
        return buildUpon().setEncoderDelay(i11).setEncoderPadding(i12).build();
    }

    @Deprecated
    public Format copyWithLabel(@Nullable String str) {
        return buildUpon().setLabel(str).build();
    }

    @Deprecated
    public Format copyWithManifestFormatInfo(Format format) {
        return withManifestFormatInfo(format);
    }

    @Deprecated
    public Format copyWithMaxInputSize(int i11) {
        return buildUpon().setMaxInputSize(i11).build();
    }

    @Deprecated
    public Format copyWithMetadata(@Nullable Metadata metadata2) {
        return buildUpon().setMetadata(metadata2).build();
    }

    @Deprecated
    public Format copyWithSubsampleOffsetUs(long j11) {
        return buildUpon().setSubsampleOffsetUs(j11).build();
    }

    @Deprecated
    public Format copyWithVideoSize(int i11, int i12) {
        return buildUpon().setWidth(i11).setHeight(i12).build();
    }

    public boolean equals(@Nullable Object obj) {
        int i11;
        if (this == obj) {
            return true;
        }
        if (obj == null || Format.class != obj.getClass()) {
            return false;
        }
        Format format = (Format) obj;
        int i12 = this.hashCode;
        if (i12 != 0 && (i11 = format.hashCode) != 0 && i12 != i11) {
            return false;
        }
        if (this.selectionFlags == format.selectionFlags && this.roleFlags == format.roleFlags && this.averageBitrate == format.averageBitrate && this.peakBitrate == format.peakBitrate && this.maxInputSize == format.maxInputSize && this.subsampleOffsetUs == format.subsampleOffsetUs && this.width == format.width && this.height == format.height && this.rotationDegrees == format.rotationDegrees && this.stereoMode == format.stereoMode && this.channelCount == format.channelCount && this.sampleRate == format.sampleRate && this.pcmEncoding == format.pcmEncoding && this.encoderDelay == format.encoderDelay && this.encoderPadding == format.encoderPadding && this.accessibilityChannel == format.accessibilityChannel && this.tileCountHorizontal == format.tileCountHorizontal && this.tileCountVertical == format.tileCountVertical && this.cryptoType == format.cryptoType && Float.compare(this.frameRate, format.frameRate) == 0 && Float.compare(this.pixelWidthHeightRatio, format.pixelWidthHeightRatio) == 0 && Util.areEqual(this.f34900id, format.f34900id) && Util.areEqual(this.label, format.label) && Util.areEqual(this.codecs, format.codecs) && Util.areEqual(this.containerMimeType, format.containerMimeType) && Util.areEqual(this.sampleMimeType, format.sampleMimeType) && Util.areEqual(this.language, format.language) && Arrays.equals(this.projectionData, format.projectionData) && Util.areEqual(this.metadata, format.metadata) && Util.areEqual(this.colorInfo, format.colorInfo) && Util.areEqual(this.drmInitData, format.drmInitData) && initializationDataEquals(format)) {
            return true;
        }
        return false;
    }

    public int getPixelCount() {
        int i11;
        int i12 = this.width;
        if (i12 == -1 || (i11 = this.height) == -1) {
            return -1;
        }
        return i12 * i11;
    }

    public int hashCode() {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        if (this.hashCode == 0) {
            String str = this.f34900id;
            int i17 = 0;
            if (str == null) {
                i11 = 0;
            } else {
                i11 = str.hashCode();
            }
            int i18 = (527 + i11) * 31;
            String str2 = this.label;
            if (str2 != null) {
                i12 = str2.hashCode();
            } else {
                i12 = 0;
            }
            int i19 = (i18 + i12) * 31;
            String str3 = this.language;
            if (str3 == null) {
                i13 = 0;
            } else {
                i13 = str3.hashCode();
            }
            int i21 = (((((((((i19 + i13) * 31) + this.selectionFlags) * 31) + this.roleFlags) * 31) + this.averageBitrate) * 31) + this.peakBitrate) * 31;
            String str4 = this.codecs;
            if (str4 == null) {
                i14 = 0;
            } else {
                i14 = str4.hashCode();
            }
            int i22 = (i21 + i14) * 31;
            Metadata metadata2 = this.metadata;
            if (metadata2 == null) {
                i15 = 0;
            } else {
                i15 = metadata2.hashCode();
            }
            int i23 = (i22 + i15) * 31;
            String str5 = this.containerMimeType;
            if (str5 == null) {
                i16 = 0;
            } else {
                i16 = str5.hashCode();
            }
            int i24 = (i23 + i16) * 31;
            String str6 = this.sampleMimeType;
            if (str6 != null) {
                i17 = str6.hashCode();
            }
            this.hashCode = ((((((((((((((((((((((((((((((((((i24 + i17) * 31) + this.maxInputSize) * 31) + ((int) this.subsampleOffsetUs)) * 31) + this.width) * 31) + this.height) * 31) + Float.floatToIntBits(this.frameRate)) * 31) + this.rotationDegrees) * 31) + Float.floatToIntBits(this.pixelWidthHeightRatio)) * 31) + this.stereoMode) * 31) + this.channelCount) * 31) + this.sampleRate) * 31) + this.pcmEncoding) * 31) + this.encoderDelay) * 31) + this.encoderPadding) * 31) + this.accessibilityChannel) * 31) + this.tileCountHorizontal) * 31) + this.tileCountVertical) * 31) + this.cryptoType;
        }
        return this.hashCode;
    }

    public boolean initializationDataEquals(Format format) {
        if (this.initializationData.size() != format.initializationData.size()) {
            return false;
        }
        for (int i11 = 0; i11 < this.initializationData.size(); i11++) {
            if (!Arrays.equals(this.initializationData.get(i11), format.initializationData.get(i11))) {
                return false;
            }
        }
        return true;
    }

    public Bundle toBundle() {
        return toBundle(false);
    }

    public String toString() {
        return "Format(" + this.f34900id + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.label + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.containerMimeType + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.sampleMimeType + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.codecs + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.bitrate + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.language + ", [" + this.width + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.height + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.frameRate + "], [" + this.channelCount + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.sampleRate + "])";
    }

    public Format withManifestFormatInfo(Format format) {
        Metadata metadata2;
        String str;
        if (this == format) {
            return this;
        }
        int trackType = MimeTypes.getTrackType(this.sampleMimeType);
        String str2 = format.f34900id;
        String str3 = format.label;
        if (str3 == null) {
            str3 = this.label;
        }
        String str4 = this.language;
        if ((trackType == 3 || trackType == 1) && (str = format.language) != null) {
            str4 = str;
        }
        int i11 = this.averageBitrate;
        if (i11 == -1) {
            i11 = format.averageBitrate;
        }
        int i12 = this.peakBitrate;
        if (i12 == -1) {
            i12 = format.peakBitrate;
        }
        String str5 = this.codecs;
        if (str5 == null) {
            String codecsOfType = Util.getCodecsOfType(format.codecs, trackType);
            if (Util.splitCodecs(codecsOfType).length == 1) {
                str5 = codecsOfType;
            }
        }
        Metadata metadata3 = this.metadata;
        if (metadata3 == null) {
            metadata2 = format.metadata;
        } else {
            metadata2 = metadata3.copyWithAppendedEntriesFrom(format.metadata);
        }
        float f11 = this.frameRate;
        if (f11 == -1.0f && trackType == 2) {
            f11 = format.frameRate;
        }
        int i13 = this.selectionFlags | format.selectionFlags;
        int i14 = this.roleFlags | format.roleFlags;
        return buildUpon().setId(str2).setLabel(str3).setLanguage(str4).setSelectionFlags(i13).setRoleFlags(i14).setAverageBitrate(i11).setPeakBitrate(i12).setCodecs(str5).setMetadata(metadata2).setDrmInitData(DrmInitData.createSessionCreationData(format.drmInitData, this.drmInitData)).setFrameRate(f11).build();
    }

    private Format(Builder builder) {
        this.f34900id = builder.f34901id;
        this.label = builder.label;
        this.language = Util.normalizeLanguageCode(builder.language);
        this.selectionFlags = builder.selectionFlags;
        this.roleFlags = builder.roleFlags;
        int access$600 = builder.averageBitrate;
        this.averageBitrate = access$600;
        int access$700 = builder.peakBitrate;
        this.peakBitrate = access$700;
        this.bitrate = access$700 != -1 ? access$700 : access$600;
        this.codecs = builder.codecs;
        this.metadata = builder.metadata;
        this.containerMimeType = builder.containerMimeType;
        this.sampleMimeType = builder.sampleMimeType;
        this.maxInputSize = builder.maxInputSize;
        this.initializationData = builder.initializationData == null ? Collections.emptyList() : builder.initializationData;
        DrmInitData access$1400 = builder.drmInitData;
        this.drmInitData = access$1400;
        this.subsampleOffsetUs = builder.subsampleOffsetUs;
        this.width = builder.width;
        this.height = builder.height;
        this.frameRate = builder.frameRate;
        int i11 = 0;
        this.rotationDegrees = builder.rotationDegrees == -1 ? 0 : builder.rotationDegrees;
        this.pixelWidthHeightRatio = builder.pixelWidthHeightRatio == -1.0f ? 1.0f : builder.pixelWidthHeightRatio;
        this.projectionData = builder.projectionData;
        this.stereoMode = builder.stereoMode;
        this.colorInfo = builder.colorInfo;
        this.channelCount = builder.channelCount;
        this.sampleRate = builder.sampleRate;
        this.pcmEncoding = builder.pcmEncoding;
        this.encoderDelay = builder.encoderDelay == -1 ? 0 : builder.encoderDelay;
        this.encoderPadding = builder.encoderPadding != -1 ? builder.encoderPadding : i11;
        this.accessibilityChannel = builder.accessibilityChannel;
        this.tileCountHorizontal = builder.tileCountHorizontal;
        this.tileCountVertical = builder.tileCountVertical;
        if (builder.cryptoType != 0 || access$1400 == null) {
            this.cryptoType = builder.cryptoType;
        } else {
            this.cryptoType = 1;
        }
    }

    public Bundle toBundle(boolean z11) {
        Bundle bundle = new Bundle();
        bundle.putString(FIELD_ID, this.f34900id);
        bundle.putString(FIELD_LABEL, this.label);
        bundle.putString(FIELD_LANGUAGE, this.language);
        bundle.putInt(FIELD_SELECTION_FLAGS, this.selectionFlags);
        bundle.putInt(FIELD_ROLE_FLAGS, this.roleFlags);
        bundle.putInt(FIELD_AVERAGE_BITRATE, this.averageBitrate);
        bundle.putInt(FIELD_PEAK_BITRATE, this.peakBitrate);
        bundle.putString(FIELD_CODECS, this.codecs);
        if (!z11) {
            bundle.putParcelable(FIELD_METADATA, this.metadata);
        }
        bundle.putString(FIELD_CONTAINER_MIME_TYPE, this.containerMimeType);
        bundle.putString(FIELD_SAMPLE_MIME_TYPE, this.sampleMimeType);
        bundle.putInt(FIELD_MAX_INPUT_SIZE, this.maxInputSize);
        for (int i11 = 0; i11 < this.initializationData.size(); i11++) {
            bundle.putByteArray(keyForInitializationData(i11), this.initializationData.get(i11));
        }
        bundle.putParcelable(FIELD_DRM_INIT_DATA, this.drmInitData);
        bundle.putLong(FIELD_SUBSAMPLE_OFFSET_US, this.subsampleOffsetUs);
        bundle.putInt(FIELD_WIDTH, this.width);
        bundle.putInt(FIELD_HEIGHT, this.height);
        bundle.putFloat(FIELD_FRAME_RATE, this.frameRate);
        bundle.putInt(FIELD_ROTATION_DEGREES, this.rotationDegrees);
        bundle.putFloat(FIELD_PIXEL_WIDTH_HEIGHT_RATIO, this.pixelWidthHeightRatio);
        bundle.putByteArray(FIELD_PROJECTION_DATA, this.projectionData);
        bundle.putInt(FIELD_STEREO_MODE, this.stereoMode);
        ColorInfo colorInfo2 = this.colorInfo;
        if (colorInfo2 != null) {
            bundle.putBundle(FIELD_COLOR_INFO, colorInfo2.toBundle());
        }
        bundle.putInt(FIELD_CHANNEL_COUNT, this.channelCount);
        bundle.putInt(FIELD_SAMPLE_RATE, this.sampleRate);
        bundle.putInt(FIELD_PCM_ENCODING, this.pcmEncoding);
        bundle.putInt(FIELD_ENCODER_DELAY, this.encoderDelay);
        bundle.putInt(FIELD_ENCODER_PADDING, this.encoderPadding);
        bundle.putInt(FIELD_ACCESSIBILITY_CHANNEL, this.accessibilityChannel);
        bundle.putInt(FIELD_TILE_COUNT_HORIZONTAL, this.tileCountHorizontal);
        bundle.putInt(FIELD_TILE_COUNT_VERTICAL, this.tileCountVertical);
        bundle.putInt(FIELD_CRYPTO_TYPE, this.cryptoType);
        return bundle;
    }

    @Deprecated
    public static Format createVideoSampleFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, int i11, int i12, int i13, int i14, float f11, @Nullable List<byte[]> list, int i15, float f12, @Nullable DrmInitData drmInitData2) {
        return new Builder().setId(str).setAverageBitrate(i11).setPeakBitrate(i11).setCodecs(str3).setSampleMimeType(str2).setMaxInputSize(i12).setInitializationData(list).setDrmInitData(drmInitData2).setWidth(i13).setHeight(i14).setFrameRate(f11).setRotationDegrees(i15).setPixelWidthHeightRatio(f12).build();
    }

    @Deprecated
    public static Format createAudioSampleFormat(@Nullable String str, @Nullable String str2, @Nullable String str3, int i11, int i12, int i13, int i14, int i15, @Nullable List<byte[]> list, @Nullable DrmInitData drmInitData2, int i16, @Nullable String str4) {
        return new Builder().setId(str).setLanguage(str4).setSelectionFlags(i16).setAverageBitrate(i11).setPeakBitrate(i11).setCodecs(str3).setSampleMimeType(str2).setMaxInputSize(i12).setInitializationData(list).setDrmInitData(drmInitData2).setChannelCount(i13).setSampleRate(i14).setPcmEncoding(i15).build();
    }
}

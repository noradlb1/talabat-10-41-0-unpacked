package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.util.Util;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.RoundingMode;

public class DefaultAudioTrackBufferSizeProvider implements DefaultAudioSink.AudioTrackBufferSizeProvider {
    private static final int AC3_BUFFER_MULTIPLICATION_FACTOR = 2;
    private static final int MAX_PCM_BUFFER_DURATION_US = 750000;
    private static final int MIN_PCM_BUFFER_DURATION_US = 250000;
    private static final int OFFLOAD_BUFFER_DURATION_US = 50000000;
    private static final int PASSTHROUGH_BUFFER_DURATION_US = 250000;
    private static final int PCM_BUFFER_MULTIPLICATION_FACTOR = 4;
    public final int ac3BufferMultiplicationFactor;
    protected final int maxPcmBufferDurationUs;
    protected final int minPcmBufferDurationUs;
    protected final int offloadBufferDurationUs;
    protected final int passthroughBufferDurationUs;
    protected final int pcmBufferMultiplicationFactor;

    public static class Builder {
        /* access modifiers changed from: private */
        public int ac3BufferMultiplicationFactor = 2;
        /* access modifiers changed from: private */
        public int maxPcmBufferDurationUs = DefaultAudioTrackBufferSizeProvider.MAX_PCM_BUFFER_DURATION_US;
        /* access modifiers changed from: private */
        public int minPcmBufferDurationUs = 250000;
        /* access modifiers changed from: private */
        public int offloadBufferDurationUs = DefaultAudioTrackBufferSizeProvider.OFFLOAD_BUFFER_DURATION_US;
        /* access modifiers changed from: private */
        public int passthroughBufferDurationUs = 250000;
        /* access modifiers changed from: private */
        public int pcmBufferMultiplicationFactor = 4;

        public DefaultAudioTrackBufferSizeProvider build() {
            return new DefaultAudioTrackBufferSizeProvider(this);
        }

        @CanIgnoreReturnValue
        public Builder setAc3BufferMultiplicationFactor(int i11) {
            this.ac3BufferMultiplicationFactor = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setMaxPcmBufferDurationUs(int i11) {
            this.maxPcmBufferDurationUs = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setMinPcmBufferDurationUs(int i11) {
            this.minPcmBufferDurationUs = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setOffloadBufferDurationUs(int i11) {
            this.offloadBufferDurationUs = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setPassthroughBufferDurationUs(int i11) {
            this.passthroughBufferDurationUs = i11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setPcmBufferMultiplicationFactor(int i11) {
            this.pcmBufferMultiplicationFactor = i11;
            return this;
        }
    }

    public DefaultAudioTrackBufferSizeProvider(Builder builder) {
        this.minPcmBufferDurationUs = builder.minPcmBufferDurationUs;
        this.maxPcmBufferDurationUs = builder.maxPcmBufferDurationUs;
        this.pcmBufferMultiplicationFactor = builder.pcmBufferMultiplicationFactor;
        this.passthroughBufferDurationUs = builder.passthroughBufferDurationUs;
        this.offloadBufferDurationUs = builder.offloadBufferDurationUs;
        this.ac3BufferMultiplicationFactor = builder.ac3BufferMultiplicationFactor;
    }

    public static int durationUsToBytes(int i11, int i12, int i13) {
        return Ints.checkedCast(((((long) i11) * ((long) i12)) * ((long) i13)) / 1000000);
    }

    public static int getMaximumEncodedRateBytesPerSecond(int i11) {
        switch (i11) {
            case 5:
                return Ac3Util.AC3_MAX_RATE_BYTES_PER_SECOND;
            case 6:
            case 18:
                return Ac3Util.E_AC3_MAX_RATE_BYTES_PER_SECOND;
            case 7:
                return DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND;
            case 8:
                return DtsUtil.DTS_HD_MAX_RATE_BYTES_PER_SECOND;
            case 9:
                return MpegAudioUtil.MAX_RATE_BYTES_PER_SECOND;
            case 10:
                return 100000;
            case 11:
                return AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND;
            case 12:
                return AacUtil.AAC_HE_V2_MAX_RATE_BYTES_PER_SECOND;
            case 14:
                return Ac3Util.TRUEHD_MAX_RATE_BYTES_PER_SECOND;
            case 15:
                return 8000;
            case 16:
                return AacUtil.AAC_XHE_MAX_RATE_BYTES_PER_SECOND;
            case 17:
                return Ac4Util.MAX_RATE_BYTES_PER_SECOND;
            case 20:
                return OpusUtil.MAX_BYTES_PER_SECOND;
            default:
                throw new IllegalArgumentException();
        }
    }

    public int get1xBufferSizeInBytes(int i11, int i12, int i13, int i14, int i15, int i16) {
        if (i13 == 0) {
            return getPcmBufferSizeInBytes(i11, i15, i14);
        }
        if (i13 == 1) {
            return getOffloadBufferSizeInBytes(i12);
        }
        if (i13 == 2) {
            return getPassthroughBufferSizeInBytes(i12, i16);
        }
        throw new IllegalArgumentException();
    }

    public int getBufferSizeInBytes(int i11, int i12, int i13, int i14, int i15, int i16, double d11) {
        return (((Math.max(i11, (int) (((double) get1xBufferSizeInBytes(i11, i12, i13, i14, i15, i16)) * d11)) + i14) - 1) / i14) * i14;
    }

    public int getOffloadBufferSizeInBytes(int i11) {
        return Ints.checkedCast((((long) this.offloadBufferDurationUs) * ((long) getMaximumEncodedRateBytesPerSecond(i11))) / 1000000);
    }

    public int getPassthroughBufferSizeInBytes(int i11, int i12) {
        int i13;
        int i14 = this.passthroughBufferDurationUs;
        if (i11 == 5) {
            i14 *= this.ac3BufferMultiplicationFactor;
        }
        if (i12 != -1) {
            i13 = IntMath.divide(i12, 8, RoundingMode.CEILING);
        } else {
            i13 = getMaximumEncodedRateBytesPerSecond(i11);
        }
        return Ints.checkedCast((((long) i14) * ((long) i13)) / 1000000);
    }

    public int getPcmBufferSizeInBytes(int i11, int i12, int i13) {
        return Util.constrainValue(i11 * this.pcmBufferMultiplicationFactor, durationUsToBytes(this.minPcmBufferDurationUs, i12, i13), durationUsToBytes(this.maxPcmBufferDurationUs, i12, i13));
    }
}

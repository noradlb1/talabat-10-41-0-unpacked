package com.google.android.exoplayer2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

public class DefaultLoadControl implements LoadControl {
    public static final int DEFAULT_AUDIO_BUFFER_SIZE = 13107200;
    public static final int DEFAULT_BACK_BUFFER_DURATION_MS = 0;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS = 5000;
    public static final int DEFAULT_BUFFER_FOR_PLAYBACK_MS = 2500;
    public static final int DEFAULT_CAMERA_MOTION_BUFFER_SIZE = 131072;
    public static final int DEFAULT_IMAGE_BUFFER_SIZE = 131072;
    public static final int DEFAULT_MAX_BUFFER_MS = 50000;
    public static final int DEFAULT_METADATA_BUFFER_SIZE = 131072;
    public static final int DEFAULT_MIN_BUFFER_MS = 50000;
    public static final int DEFAULT_MIN_BUFFER_SIZE = 13107200;
    public static final int DEFAULT_MUXED_BUFFER_SIZE = 144310272;
    public static final boolean DEFAULT_PRIORITIZE_TIME_OVER_SIZE_THRESHOLDS = false;
    public static final boolean DEFAULT_RETAIN_BACK_BUFFER_FROM_KEYFRAME = false;
    public static final int DEFAULT_TARGET_BUFFER_BYTES = -1;
    public static final int DEFAULT_TEXT_BUFFER_SIZE = 131072;
    public static final int DEFAULT_VIDEO_BUFFER_SIZE = 131072000;
    private final DefaultAllocator allocator;
    private final long backBufferDurationUs;
    private final long bufferForPlaybackAfterRebufferUs;
    private final long bufferForPlaybackUs;
    private boolean isLoading;
    private final long maxBufferUs;
    private final long minBufferUs;
    private final boolean prioritizeTimeOverSizeThresholds;
    private final boolean retainBackBufferFromKeyframe;
    private int targetBufferBytes;
    private final int targetBufferBytesOverwrite;

    public static final class Builder {
        @Nullable
        private DefaultAllocator allocator;
        private int backBufferDurationMs = 0;
        private int bufferForPlaybackAfterRebufferMs = 5000;
        private int bufferForPlaybackMs = 2500;
        private boolean buildCalled;
        private int maxBufferMs = 50000;
        private int minBufferMs = 50000;
        private boolean prioritizeTimeOverSizeThresholds = false;
        private boolean retainBackBufferFromKeyframe = false;
        private int targetBufferBytes = -1;

        public DefaultLoadControl build() {
            Assertions.checkState(!this.buildCalled);
            this.buildCalled = true;
            if (this.allocator == null) {
                this.allocator = new DefaultAllocator(true, 65536);
            }
            return new DefaultLoadControl(this.allocator, this.minBufferMs, this.maxBufferMs, this.bufferForPlaybackMs, this.bufferForPlaybackAfterRebufferMs, this.targetBufferBytes, this.prioritizeTimeOverSizeThresholds, this.backBufferDurationMs, this.retainBackBufferFromKeyframe);
        }

        @Deprecated
        public DefaultLoadControl createDefaultLoadControl() {
            return build();
        }

        @CanIgnoreReturnValue
        public Builder setAllocator(DefaultAllocator defaultAllocator) {
            Assertions.checkState(!this.buildCalled);
            this.allocator = defaultAllocator;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setBackBuffer(int i11, boolean z11) {
            Assertions.checkState(!this.buildCalled);
            DefaultLoadControl.assertGreaterOrEqual(i11, 0, "backBufferDurationMs", "0");
            this.backBufferDurationMs = i11;
            this.retainBackBufferFromKeyframe = z11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setBufferDurationsMs(int i11, int i12, int i13, int i14) {
            Assertions.checkState(!this.buildCalled);
            DefaultLoadControl.assertGreaterOrEqual(i13, 0, "bufferForPlaybackMs", "0");
            DefaultLoadControl.assertGreaterOrEqual(i14, 0, "bufferForPlaybackAfterRebufferMs", "0");
            DefaultLoadControl.assertGreaterOrEqual(i11, i13, "minBufferMs", "bufferForPlaybackMs");
            DefaultLoadControl.assertGreaterOrEqual(i11, i14, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
            DefaultLoadControl.assertGreaterOrEqual(i12, i11, "maxBufferMs", "minBufferMs");
            this.minBufferMs = i11;
            this.maxBufferMs = i12;
            this.bufferForPlaybackMs = i13;
            this.bufferForPlaybackAfterRebufferMs = i14;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setPrioritizeTimeOverSizeThresholds(boolean z11) {
            Assertions.checkState(!this.buildCalled);
            this.prioritizeTimeOverSizeThresholds = z11;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder setTargetBufferBytes(int i11) {
            Assertions.checkState(!this.buildCalled);
            this.targetBufferBytes = i11;
            return this;
        }
    }

    public DefaultLoadControl() {
        this(new DefaultAllocator(true, 65536), 50000, 50000, 2500, 5000, -1, false, 0, false);
    }

    /* access modifiers changed from: private */
    public static void assertGreaterOrEqual(int i11, int i12, String str, String str2) {
        boolean z11 = i11 >= i12;
        Assertions.checkArgument(z11, str + " cannot be less than " + str2);
    }

    private static int getDefaultBufferSize(int i11) {
        switch (i11) {
            case -2:
                return 0;
            case 0:
                return DEFAULT_MUXED_BUFFER_SIZE;
            case 1:
                return 13107200;
            case 2:
                return DEFAULT_VIDEO_BUFFER_SIZE;
            case 3:
            case 4:
            case 5:
            case 6:
                return 131072;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void reset(boolean z11) {
        int i11 = this.targetBufferBytesOverwrite;
        if (i11 == -1) {
            i11 = 13107200;
        }
        this.targetBufferBytes = i11;
        this.isLoading = false;
        if (z11) {
            this.allocator.reset();
        }
    }

    public int calculateTargetBufferBytes(Renderer[] rendererArr, ExoTrackSelection[] exoTrackSelectionArr) {
        int i11 = 0;
        for (int i12 = 0; i12 < rendererArr.length; i12++) {
            if (exoTrackSelectionArr[i12] != null) {
                i11 += getDefaultBufferSize(rendererArr[i12].getTrackType());
            }
        }
        return Math.max(13107200, i11);
    }

    public Allocator getAllocator() {
        return this.allocator;
    }

    public long getBackBufferDurationUs() {
        return this.backBufferDurationUs;
    }

    public void onPrepared() {
        reset(false);
    }

    public void onReleased() {
        reset(true);
    }

    public void onStopped() {
        reset(true);
    }

    public void onTracksSelected(Renderer[] rendererArr, TrackGroupArray trackGroupArray, ExoTrackSelection[] exoTrackSelectionArr) {
        int i11 = this.targetBufferBytesOverwrite;
        if (i11 == -1) {
            i11 = calculateTargetBufferBytes(rendererArr, exoTrackSelectionArr);
        }
        this.targetBufferBytes = i11;
        this.allocator.setTargetBufferSize(i11);
    }

    public boolean retainBackBufferFromKeyframe() {
        return this.retainBackBufferFromKeyframe;
    }

    public boolean shouldContinueLoading(long j11, long j12, float f11) {
        boolean z11;
        boolean z12 = true;
        if (this.allocator.getTotalBytesAllocated() >= this.targetBufferBytes) {
            z11 = true;
        } else {
            z11 = false;
        }
        long j13 = this.minBufferUs;
        if (f11 > 1.0f) {
            j13 = Math.min(Util.getMediaDurationForPlayoutDuration(j13, f11), this.maxBufferUs);
        }
        if (j12 < Math.max(j13, 500000)) {
            if (!this.prioritizeTimeOverSizeThresholds && z11) {
                z12 = false;
            }
            this.isLoading = z12;
            if (!z12 && j12 < 500000) {
                Log.w("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j12 >= this.maxBufferUs || z11) {
            this.isLoading = false;
        }
        return this.isLoading;
    }

    public boolean shouldStartPlayback(long j11, float f11, boolean z11, long j12) {
        long j13;
        long playoutDurationForMediaDuration = Util.getPlayoutDurationForMediaDuration(j11, f11);
        if (z11) {
            j13 = this.bufferForPlaybackAfterRebufferUs;
        } else {
            j13 = this.bufferForPlaybackUs;
        }
        if (j12 != C.TIME_UNSET) {
            j13 = Math.min(j12 / 2, j13);
        }
        if (j13 <= 0 || playoutDurationForMediaDuration >= j13 || (!this.prioritizeTimeOverSizeThresholds && this.allocator.getTotalBytesAllocated() >= this.targetBufferBytes)) {
            return true;
        }
        return false;
    }

    public DefaultLoadControl(DefaultAllocator defaultAllocator, int i11, int i12, int i13, int i14, int i15, boolean z11, int i16, boolean z12) {
        assertGreaterOrEqual(i13, 0, "bufferForPlaybackMs", "0");
        assertGreaterOrEqual(i14, 0, "bufferForPlaybackAfterRebufferMs", "0");
        assertGreaterOrEqual(i11, i13, "minBufferMs", "bufferForPlaybackMs");
        assertGreaterOrEqual(i11, i14, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        assertGreaterOrEqual(i12, i11, "maxBufferMs", "minBufferMs");
        assertGreaterOrEqual(i16, 0, "backBufferDurationMs", "0");
        this.allocator = defaultAllocator;
        this.minBufferUs = Util.msToUs((long) i11);
        this.maxBufferUs = Util.msToUs((long) i12);
        this.bufferForPlaybackUs = Util.msToUs((long) i13);
        this.bufferForPlaybackAfterRebufferUs = Util.msToUs((long) i14);
        this.targetBufferBytesOverwrite = i15;
        this.targetBufferBytes = i15 == -1 ? 13107200 : i15;
        this.prioritizeTimeOverSizeThresholds = z11;
        this.backBufferDurationUs = Util.msToUs((long) i16);
        this.retainBackBufferFromKeyframe = z12;
    }
}

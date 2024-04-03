package com.google.android.exoplayer2.video;

import android.os.Bundle;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.util.Util;
import o8.r;

public final class VideoSize implements Bundleable {
    public static final Bundleable.Creator<VideoSize> CREATOR = new r();
    private static final int DEFAULT_HEIGHT = 0;
    private static final float DEFAULT_PIXEL_WIDTH_HEIGHT_RATIO = 1.0f;
    private static final int DEFAULT_UNAPPLIED_ROTATION_DEGREES = 0;
    private static final int DEFAULT_WIDTH = 0;
    private static final String FIELD_HEIGHT = Util.intToStringMaxRadix(1);
    private static final String FIELD_PIXEL_WIDTH_HEIGHT_RATIO = Util.intToStringMaxRadix(3);
    private static final String FIELD_UNAPPLIED_ROTATION_DEGREES = Util.intToStringMaxRadix(2);
    private static final String FIELD_WIDTH = Util.intToStringMaxRadix(0);
    public static final VideoSize UNKNOWN = new VideoSize(0, 0);
    @IntRange(from = 0)
    public final int height;
    @FloatRange(from = 0.0d, fromInclusive = false)
    public final float pixelWidthHeightRatio;
    @IntRange(from = 0, to = 359)
    public final int unappliedRotationDegrees;
    @IntRange(from = 0)
    public final int width;

    public VideoSize(@IntRange(from = 0) int i11, @IntRange(from = 0) int i12) {
        this(i11, i12, 0, 1.0f);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ VideoSize lambda$static$0(Bundle bundle) {
        return new VideoSize(bundle.getInt(FIELD_WIDTH, 0), bundle.getInt(FIELD_HEIGHT, 0), bundle.getInt(FIELD_UNAPPLIED_ROTATION_DEGREES, 0), bundle.getFloat(FIELD_PIXEL_WIDTH_HEIGHT_RATIO, 1.0f));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoSize)) {
            return false;
        }
        VideoSize videoSize = (VideoSize) obj;
        if (this.width == videoSize.width && this.height == videoSize.height && this.unappliedRotationDegrees == videoSize.unappliedRotationDegrees && this.pixelWidthHeightRatio == videoSize.pixelWidthHeightRatio) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((((217 + this.width) * 31) + this.height) * 31) + this.unappliedRotationDegrees) * 31) + Float.floatToRawIntBits(this.pixelWidthHeightRatio);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(FIELD_WIDTH, this.width);
        bundle.putInt(FIELD_HEIGHT, this.height);
        bundle.putInt(FIELD_UNAPPLIED_ROTATION_DEGREES, this.unappliedRotationDegrees);
        bundle.putFloat(FIELD_PIXEL_WIDTH_HEIGHT_RATIO, this.pixelWidthHeightRatio);
        return bundle;
    }

    public VideoSize(@IntRange(from = 0) int i11, @IntRange(from = 0) int i12, @IntRange(from = 0, to = 359) int i13, @FloatRange(from = 0.0d, fromInclusive = false) float f11) {
        this.width = i11;
        this.height = i12;
        this.unappliedRotationDegrees = i13;
        this.pixelWidthHeightRatio = f11;
    }
}

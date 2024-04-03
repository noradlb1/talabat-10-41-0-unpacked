package com.google.android.exoplayer2.util;

public class FrameInfo {
    public final int height;
    public final float pixelWidthHeightRatio;
    public final long streamOffsetUs;
    public final int width;

    public FrameInfo(int i11, int i12, float f11, long j11) {
        boolean z11;
        boolean z12 = true;
        if (i11 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkArgument(z11, "width must be positive, but is: " + i11);
        Assertions.checkArgument(i12 <= 0 ? false : z12, "height must be positive, but is: " + i12);
        this.width = i11;
        this.height = i12;
        this.pixelWidthHeightRatio = f11;
        this.streamOffsetUs = j11;
    }
}

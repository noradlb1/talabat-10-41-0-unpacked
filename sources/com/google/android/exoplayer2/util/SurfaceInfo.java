package com.google.android.exoplayer2.util;

import android.view.Surface;
import androidx.annotation.Nullable;

public final class SurfaceInfo {
    public final int height;
    public final int orientationDegrees;
    public final Surface surface;
    public final int width;

    public SurfaceInfo(Surface surface2, int i11, int i12) {
        this(surface2, i11, i12, 0);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SurfaceInfo)) {
            return false;
        }
        SurfaceInfo surfaceInfo = (SurfaceInfo) obj;
        if (this.width == surfaceInfo.width && this.height == surfaceInfo.height && this.orientationDegrees == surfaceInfo.orientationDegrees && this.surface.equals(surfaceInfo.surface)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.surface.hashCode() * 31) + this.width) * 31) + this.height) * 31) + this.orientationDegrees;
    }

    public SurfaceInfo(Surface surface2, int i11, int i12, int i13) {
        Assertions.checkArgument(i13 == 0 || i13 == 90 || i13 == 180 || i13 == 270, "orientationDegrees must be 0, 90, 180, or 270");
        this.surface = surface2;
        this.width = i11;
        this.height = i12;
        this.orientationDegrees = i13;
    }
}

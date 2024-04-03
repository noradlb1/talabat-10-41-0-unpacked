package com.google.android.exoplayer2.util;

import android.view.SurfaceView;
import androidx.annotation.Nullable;
import n8.a;

public interface DebugViewProvider {
    public static final DebugViewProvider NONE = new a();

    @Nullable
    SurfaceView getDebugPreviewSurfaceView(int i11, int i12);
}

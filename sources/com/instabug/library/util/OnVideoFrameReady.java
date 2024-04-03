package com.instabug.library.util;

import android.graphics.Bitmap;
import org.jetbrains.annotations.Nullable;

public interface OnVideoFrameReady {
    void onReady(@Nullable Bitmap bitmap);
}

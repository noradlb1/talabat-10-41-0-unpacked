package com.instabug.library.internal.layer;

import android.graphics.Bitmap;
import androidx.annotation.Size;

public interface CapturableView {

    public interface SnapshotPreparationCallback {
        void onSnapshotFailed();

        void onSnapshotReady(Bitmap bitmap);
    }

    void getLocationOnScreen(@Size(2) int[] iArr);

    boolean isVisible();

    void snapshot(SnapshotPreparationCallback snapshotPreparationCallback);
}

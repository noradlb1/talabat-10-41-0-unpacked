package com.instabug.library.internal.video;

import android.net.Uri;
import androidx.annotation.Nullable;

public interface ScreenRecordingContract {
    void clear();

    void delete();

    @Nullable
    Uri getAutoScreenRecordingFileUri();

    boolean isEnabled();
}

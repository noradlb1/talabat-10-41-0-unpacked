package com.instabug.library.internal.video;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.File;

public class ScreenRecordingFileHolder {
    private static final ScreenRecordingFileHolder INSTANCE = new ScreenRecordingFileHolder();
    @Nullable
    private File autoScreenRecordingFile;

    public static ScreenRecordingFileHolder getInstance() {
        return INSTANCE;
    }

    public void clear() {
        this.autoScreenRecordingFile = null;
    }

    public boolean delete() {
        File file = this.autoScreenRecordingFile;
        if (file == null) {
            return true;
        }
        if (!file.delete()) {
            return false;
        }
        InstabugSDKLogger.d("IBG-Core", "Screen recording file deleted");
        return true;
    }

    @Nullable
    public Uri getAutoScreenRecordingFileUri() {
        File file = this.autoScreenRecordingFile;
        if (file != null) {
            return Uri.fromFile(file);
        }
        return null;
    }

    public void setAutoScreenRecordingFile(@Nullable File file) {
        this.autoScreenRecordingFile = file;
    }
}

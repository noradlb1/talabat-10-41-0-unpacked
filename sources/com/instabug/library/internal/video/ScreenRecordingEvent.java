package com.instabug.library.internal.video;

import android.net.Uri;
import androidx.annotation.Nullable;

public class ScreenRecordingEvent {
    public static final int RECORDING_CANCELED = 3;
    public static final int RECORDING_ERROR = 4;
    public static final int RECORDING_FILE_READY = 2;
    public static final int RECORDING_FINISHED = 1;
    public static final int RECORDING_PERMISSION_DENIED = 0;
    private final int status;
    private int videoDuration;
    @Nullable
    private final Uri videoUri;

    public ScreenRecordingEvent(int i11, @Nullable Uri uri, int i12) {
        this(i11, uri);
        this.videoDuration = i12;
    }

    public int getStatus() {
        return this.status;
    }

    public int getVideoDuration() {
        return this.videoDuration;
    }

    @Nullable
    public Uri getVideoUri() {
        return this.videoUri;
    }

    public ScreenRecordingEvent(int i11, @Nullable Uri uri) {
        this.videoDuration = -1;
        this.status = i11;
        this.videoUri = uri;
    }
}

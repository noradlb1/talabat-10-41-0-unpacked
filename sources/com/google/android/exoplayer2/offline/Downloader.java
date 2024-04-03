package com.google.android.exoplayer2.offline;

import androidx.annotation.Nullable;
import java.io.IOException;

public interface Downloader {

    public interface ProgressListener {
        void onProgress(long j11, long j12, float f11);
    }

    void cancel();

    void download(@Nullable ProgressListener progressListener) throws IOException, InterruptedException;

    void remove();
}

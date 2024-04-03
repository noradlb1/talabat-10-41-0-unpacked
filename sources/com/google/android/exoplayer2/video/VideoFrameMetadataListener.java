package com.google.android.exoplayer2.video;

import android.media.MediaFormat;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;

public interface VideoFrameMetadataListener {
    void onVideoFrameAboutToBeRendered(long j11, long j12, Format format, @Nullable MediaFormat mediaFormat);
}

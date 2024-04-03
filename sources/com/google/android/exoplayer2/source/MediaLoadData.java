package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;

public final class MediaLoadData {
    public final int dataType;
    public final long mediaEndTimeMs;
    public final long mediaStartTimeMs;
    @Nullable
    public final Format trackFormat;
    @Nullable
    public final Object trackSelectionData;
    public final int trackSelectionReason;
    public final int trackType;

    public MediaLoadData(int i11) {
        this(i11, -1, (Format) null, 0, (Object) null, C.TIME_UNSET, C.TIME_UNSET);
    }

    public MediaLoadData(int i11, int i12, @Nullable Format format, int i13, @Nullable Object obj, long j11, long j12) {
        this.dataType = i11;
        this.trackType = i12;
        this.trackFormat = format;
        this.trackSelectionReason = i13;
        this.trackSelectionData = obj;
        this.mediaStartTimeMs = j11;
        this.mediaEndTimeMs = j12;
    }
}

package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

final class UnexpectedSampleTimestampException extends IOException {
    public final long lastAcceptedSampleTimeUs;
    public final MediaChunk mediaChunk;
    public final long rejectedSampleTimeUs;

    public UnexpectedSampleTimestampException(MediaChunk mediaChunk2, long j11, long j12) {
        super("Unexpected sample timestamp: " + Util.usToMs(j12) + " in chunk [" + mediaChunk2.startTimeUs + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + mediaChunk2.endTimeUs + "]");
        this.mediaChunk = mediaChunk2;
        this.lastAcceptedSampleTimeUs = j11;
        this.rejectedSampleTimeUs = j12;
    }
}

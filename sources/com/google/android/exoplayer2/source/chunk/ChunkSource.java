package com.google.android.exoplayer2.source.chunk;

import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import java.io.IOException;
import java.util.List;

public interface ChunkSource {
    long getAdjustedSeekPositionUs(long j11, SeekParameters seekParameters);

    void getNextChunk(long j11, long j12, List<? extends MediaChunk> list, ChunkHolder chunkHolder);

    int getPreferredQueueSize(long j11, List<? extends MediaChunk> list);

    void maybeThrowError() throws IOException;

    void onChunkLoadCompleted(Chunk chunk);

    boolean onChunkLoadError(Chunk chunk, boolean z11, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo, LoadErrorHandlingPolicy loadErrorHandlingPolicy);

    void release();

    boolean shouldCancelLoad(long j11, Chunk chunk, List<? extends MediaChunk> list);
}

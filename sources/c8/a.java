package c8;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.chunk.BundledChunkExtractor;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import java.util.List;

public final /* synthetic */ class a implements ChunkExtractor.Factory {
    public final ChunkExtractor createProgressiveMediaExtractor(int i11, Format format, boolean z11, List list, TrackOutput trackOutput, PlayerId playerId) {
        return BundledChunkExtractor.lambda$static$0(i11, format, z11, list, trackOutput, playerId);
    }
}

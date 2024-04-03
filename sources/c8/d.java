package c8;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.source.chunk.MediaParserChunkExtractor;
import java.util.List;

public final /* synthetic */ class d implements ChunkExtractor.Factory {
    public final ChunkExtractor createProgressiveMediaExtractor(int i11, Format format, boolean z11, List list, TrackOutput trackOutput, PlayerId playerId) {
        return MediaParserChunkExtractor.lambda$static$0(i11, format, z11, list, trackOutput, playerId);
    }
}

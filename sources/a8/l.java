package a8;

import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.source.MediaParserExtractorAdapter;
import com.google.android.exoplayer2.source.ProgressiveMediaExtractor;

public final /* synthetic */ class l implements ProgressiveMediaExtractor.Factory {
    public final ProgressiveMediaExtractor createProgressiveMediaExtractor(PlayerId playerId) {
        return new MediaParserExtractorAdapter(playerId);
    }
}

package a8;

import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ProgressiveMediaExtractor;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;

public final /* synthetic */ class v implements ProgressiveMediaExtractor.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ExtractorsFactory f34897a;

    public /* synthetic */ v(ExtractorsFactory extractorsFactory) {
        this.f34897a = extractorsFactory;
    }

    public final ProgressiveMediaExtractor createProgressiveMediaExtractor(PlayerId playerId) {
        return ProgressiveMediaSource.Factory.lambda$new$0(this.f34897a, playerId);
    }
}

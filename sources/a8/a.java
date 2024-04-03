package a8;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.CompositeMediaSource;
import com.google.android.exoplayer2.source.MediaSource;

public final /* synthetic */ class a implements MediaSource.MediaSourceCaller {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CompositeMediaSource f34867b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f34868c;

    public /* synthetic */ a(CompositeMediaSource compositeMediaSource, Object obj) {
        this.f34867b = compositeMediaSource;
        this.f34868c = obj;
    }

    public final void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline) {
        this.f34867b.lambda$prepareChildSource$0(this.f34868c, mediaSource, timeline);
    }
}

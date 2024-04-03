package j8;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.common.base.Predicate;

public final /* synthetic */ class e implements Predicate {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultTrackSelector f35484b;

    public /* synthetic */ e(DefaultTrackSelector defaultTrackSelector) {
        this.f35484b = defaultTrackSelector;
    }

    public final boolean apply(Object obj) {
        return this.f35484b.isAudioFormatWithinAudioChannelCountConstraints((Format) obj);
    }
}

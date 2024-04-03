package r7;

import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.mp4.Track;
import com.google.common.base.Function;

public final /* synthetic */ class a implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FragmentedMp4Extractor f35574b;

    public /* synthetic */ a(FragmentedMp4Extractor fragmentedMp4Extractor) {
        this.f35574b = fragmentedMp4Extractor;
    }

    public final Object apply(Object obj) {
        return this.f35574b.modifyTrack((Track) obj);
    }
}

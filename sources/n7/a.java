package n7;

import com.google.android.exoplayer2.extractor.BinarySearchSeeker;
import com.google.android.exoplayer2.extractor.FlacStreamMetadata;

public final /* synthetic */ class a implements BinarySearchSeeker.SeekTimestampConverter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FlacStreamMetadata f35528a;

    public /* synthetic */ a(FlacStreamMetadata flacStreamMetadata) {
        this.f35528a = flacStreamMetadata;
    }

    public final long timeUsToTargetTime(long j11) {
        return this.f35528a.getSampleNumber(j11);
    }
}

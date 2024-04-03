package q7;

import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;

public final /* synthetic */ class b implements Id3Decoder.FramePredicate {
    public final boolean evaluate(int i11, int i12, int i13, int i14, int i15) {
        return Mp3Extractor.lambda$static$1(i11, i12, i13, i14, i15);
    }
}

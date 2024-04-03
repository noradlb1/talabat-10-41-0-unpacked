package t7;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import java.util.Map;

public final /* synthetic */ class e implements ExtractorsFactory {
    public final Extractor[] createExtractors() {
        return TsExtractor.lambda$static$0();
    }

    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        return l7.e.a(this, uri, map);
    }
}

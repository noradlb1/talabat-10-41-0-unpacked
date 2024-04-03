package t7;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.ts.Ac4Extractor;
import java.util.Map;
import l7.e;

public final /* synthetic */ class b implements ExtractorsFactory {
    public final Extractor[] createExtractors() {
        return Ac4Extractor.lambda$static$0();
    }

    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        return e.a(this, uri, map);
    }
}

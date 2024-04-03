package l7;

import android.net.Uri;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import java.util.Map;

public final /* synthetic */ class d implements ExtractorsFactory {
    public final Extractor[] createExtractors() {
        return e.b();
    }

    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        return e.a(this, uri, map);
    }
}

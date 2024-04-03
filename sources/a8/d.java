package a8;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import java.util.Map;
import l7.e;

public final /* synthetic */ class d implements ExtractorsFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Format f34871a;

    public /* synthetic */ d(Format format) {
        this.f34871a = format;
    }

    public final Extractor[] createExtractors() {
        return DefaultMediaSourceFactory.lambda$createMediaSource$0(this.f34871a);
    }

    public /* synthetic */ Extractor[] createExtractors(Uri uri, Map map) {
        return e.a(this, uri, map);
    }
}

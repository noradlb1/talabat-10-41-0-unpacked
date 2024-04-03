package com.google.android.exoplayer2.extractor;

import android.net.Uri;
import java.util.List;
import java.util.Map;
import l7.d;

public interface ExtractorsFactory {
    public static final ExtractorsFactory EMPTY = new d();

    Extractor[] createExtractors();

    Extractor[] createExtractors(Uri uri, Map<String, List<String>> map);
}

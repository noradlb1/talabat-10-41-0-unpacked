package m8;

import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.cache.CacheKeyFactory;

public final /* synthetic */ class b {
    static {
        CacheKeyFactory cacheKeyFactory = CacheKeyFactory.DEFAULT;
    }

    public static /* synthetic */ String a(DataSpec dataSpec) {
        String str = dataSpec.key;
        return str != null ? str : dataSpec.uri.toString();
    }
}

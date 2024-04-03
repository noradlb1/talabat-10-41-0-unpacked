package m8;

import com.google.android.exoplayer2.upstream.cache.CacheSpan;
import com.google.android.exoplayer2.upstream.cache.LeastRecentlyUsedCacheEvictor;
import java.util.Comparator;

public final /* synthetic */ class d implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return LeastRecentlyUsedCacheEvictor.compare((CacheSpan) obj, (CacheSpan) obj2);
    }
}

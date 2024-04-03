package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.upstream.DataSpec;
import m8.a;

public interface CacheKeyFactory {
    public static final CacheKeyFactory DEFAULT = new a();

    String buildCacheKey(DataSpec dataSpec);
}

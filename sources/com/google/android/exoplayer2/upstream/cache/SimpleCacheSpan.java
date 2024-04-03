package com.google.android.exoplayer2.upstream.cache;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class SimpleCacheSpan extends CacheSpan {
    private static final Pattern CACHE_FILE_PATTERN_V1 = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", 32);
    private static final Pattern CACHE_FILE_PATTERN_V2 = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", 32);
    private static final Pattern CACHE_FILE_PATTERN_V3 = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", 32);
    static final String COMMON_SUFFIX = ".exo";
    private static final String SUFFIX = ".v3.exo";

    private SimpleCacheSpan(String str, long j11, long j12, long j13, @Nullable File file) {
        super(str, j11, j12, j13, file);
    }

    @Nullable
    public static SimpleCacheSpan createCacheEntry(File file, long j11, CachedContentIndex cachedContentIndex) {
        return createCacheEntry(file, j11, C.TIME_UNSET, cachedContentIndex);
    }

    public static SimpleCacheSpan createHole(String str, long j11, long j12) {
        return new SimpleCacheSpan(str, j11, j12, C.TIME_UNSET, (File) null);
    }

    public static SimpleCacheSpan createLookup(String str, long j11) {
        return new SimpleCacheSpan(str, j11, -1, C.TIME_UNSET, (File) null);
    }

    public static File getCacheFile(File file, int i11, long j11, long j12) {
        return new File(file, i11 + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + j11 + RealDiscoveryConfigurationRepository.VERSION_DELIMETER + j12 + SUFFIX);
    }

    @Nullable
    private static File upgradeFile(File file, CachedContentIndex cachedContentIndex) {
        String str;
        String name2 = file.getName();
        Matcher matcher = CACHE_FILE_PATTERN_V2.matcher(name2);
        if (matcher.matches()) {
            str = Util.unescapeFileName((String) Assertions.checkNotNull(matcher.group(1)));
        } else {
            matcher = CACHE_FILE_PATTERN_V1.matcher(name2);
            if (matcher.matches()) {
                str = (String) Assertions.checkNotNull(matcher.group(1));
            } else {
                str = null;
            }
        }
        if (str == null) {
            return null;
        }
        File cacheFile = getCacheFile((File) Assertions.checkStateNotNull(file.getParentFile()), cachedContentIndex.assignIdForKey(str), Long.parseLong((String) Assertions.checkNotNull(matcher.group(2))), Long.parseLong((String) Assertions.checkNotNull(matcher.group(3))));
        if (!file.renameTo(cacheFile)) {
            return null;
        }
        return cacheFile;
    }

    public SimpleCacheSpan copyWithFileAndLastTouchTimestamp(File file, long j11) {
        Assertions.checkState(this.isCached);
        return new SimpleCacheSpan(this.key, this.position, this.length, j11, file);
    }

    @Nullable
    public static SimpleCacheSpan createCacheEntry(File file, long j11, long j12, CachedContentIndex cachedContentIndex) {
        File file2;
        String keyForId;
        CachedContentIndex cachedContentIndex2 = cachedContentIndex;
        String name2 = file.getName();
        if (!name2.endsWith(SUFFIX)) {
            File file3 = file;
            File upgradeFile = upgradeFile(file, cachedContentIndex2);
            if (upgradeFile == null) {
                return null;
            }
            file2 = upgradeFile;
            name2 = upgradeFile.getName();
        } else {
            file2 = file;
        }
        Matcher matcher = CACHE_FILE_PATTERN_V3.matcher(name2);
        if (!matcher.matches() || (keyForId = cachedContentIndex2.getKeyForId(Integer.parseInt((String) Assertions.checkNotNull(matcher.group(1))))) == null) {
            return null;
        }
        long length = j11 == -1 ? file2.length() : j11;
        if (length == 0) {
            return null;
        }
        return new SimpleCacheSpan(keyForId, Long.parseLong((String) Assertions.checkNotNull(matcher.group(2))), length, j12 == C.TIME_UNSET ? Long.parseLong((String) Assertions.checkNotNull(matcher.group(3))) : j12, file2);
    }
}

package com.google.android.exoplayer2.upstream.cache;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import java.io.File;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class CacheSpan implements Comparable<CacheSpan> {
    @Nullable
    public final File file;
    public final boolean isCached;
    public final String key;
    public final long lastTouchTimestamp;
    public final long length;
    public final long position;

    public CacheSpan(String str, long j11, long j12) {
        this(str, j11, j12, C.TIME_UNSET, (File) null);
    }

    public boolean isHoleSpan() {
        return !this.isCached;
    }

    public boolean isOpenEnded() {
        return this.length == -1;
    }

    public String toString() {
        return "[" + this.position + IndicativeSentencesGeneration.DEFAULT_SEPARATOR + this.length + "]";
    }

    public CacheSpan(String str, long j11, long j12, long j13, @Nullable File file2) {
        this.key = str;
        this.position = j11;
        this.length = j12;
        this.isCached = file2 != null;
        this.file = file2;
        this.lastTouchTimestamp = j13;
    }

    public int compareTo(CacheSpan cacheSpan) {
        if (!this.key.equals(cacheSpan.key)) {
            return this.key.compareTo(cacheSpan.key);
        }
        int i11 = ((this.position - cacheSpan.position) > 0 ? 1 : ((this.position - cacheSpan.position) == 0 ? 0 : -1));
        if (i11 == 0) {
            return 0;
        }
        return i11 < 0 ? -1 : 1;
    }
}

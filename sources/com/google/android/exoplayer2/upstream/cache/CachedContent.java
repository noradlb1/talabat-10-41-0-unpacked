package com.google.android.exoplayer2.upstream.cache;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.TreeSet;

final class CachedContent {
    private static final String TAG = "CachedContent";
    private final TreeSet<SimpleCacheSpan> cachedSpans;

    /* renamed from: id  reason: collision with root package name */
    public final int f35064id;
    public final String key;
    private final ArrayList<Range> lockedRanges;
    private DefaultContentMetadata metadata;

    public static final class Range {
        public final long length;
        public final long position;

        public Range(long j11, long j12) {
            this.position = j11;
            this.length = j12;
        }

        public boolean contains(long j11, long j12) {
            long j13 = this.length;
            if (j13 == -1) {
                if (j11 >= this.position) {
                    return true;
                }
                return false;
            } else if (j12 == -1) {
                return false;
            } else {
                long j14 = this.position;
                if (j14 > j11 || j11 + j12 > j14 + j13) {
                    return false;
                }
                return true;
            }
        }

        public boolean intersects(long j11, long j12) {
            long j13 = this.position;
            if (j13 <= j11) {
                long j14 = this.length;
                if (j14 == -1 || j13 + j14 > j11) {
                    return true;
                }
                return false;
            } else if (j12 == -1 || j11 + j12 > j13) {
                return true;
            } else {
                return false;
            }
        }
    }

    public CachedContent(int i11, String str) {
        this(i11, str, DefaultContentMetadata.EMPTY);
    }

    public void addSpan(SimpleCacheSpan simpleCacheSpan) {
        this.cachedSpans.add(simpleCacheSpan);
    }

    public boolean applyMetadataMutations(ContentMetadataMutations contentMetadataMutations) {
        DefaultContentMetadata defaultContentMetadata = this.metadata;
        DefaultContentMetadata copyWithMutationsApplied = defaultContentMetadata.copyWithMutationsApplied(contentMetadataMutations);
        this.metadata = copyWithMutationsApplied;
        return !copyWithMutationsApplied.equals(defaultContentMetadata);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || CachedContent.class != obj.getClass()) {
            return false;
        }
        CachedContent cachedContent = (CachedContent) obj;
        if (this.f35064id != cachedContent.f35064id || !this.key.equals(cachedContent.key) || !this.cachedSpans.equals(cachedContent.cachedSpans) || !this.metadata.equals(cachedContent.metadata)) {
            return false;
        }
        return true;
    }

    public long getCachedBytesLength(long j11, long j12) {
        boolean z11;
        boolean z12 = true;
        if (j11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Assertions.checkArgument(z11);
        if (j12 < 0) {
            z12 = false;
        }
        Assertions.checkArgument(z12);
        SimpleCacheSpan span = getSpan(j11, j12);
        long j13 = Long.MAX_VALUE;
        if (span.isHoleSpan()) {
            if (!span.isOpenEnded()) {
                j13 = span.length;
            }
            return -Math.min(j13, j12);
        }
        long j14 = j11 + j12;
        if (j14 >= 0) {
            j13 = j14;
        }
        long j15 = span.position + span.length;
        if (j15 < j13) {
            for (SimpleCacheSpan next : this.cachedSpans.tailSet(span, false)) {
                long j16 = next.position;
                if (j16 <= j15) {
                    j15 = Math.max(j15, j16 + next.length);
                    if (j15 >= j13) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        return Math.min(j15 - j11, j12);
    }

    public DefaultContentMetadata getMetadata() {
        return this.metadata;
    }

    public SimpleCacheSpan getSpan(long j11, long j12) {
        SimpleCacheSpan createLookup = SimpleCacheSpan.createLookup(this.key, j11);
        SimpleCacheSpan floor = this.cachedSpans.floor(createLookup);
        if (floor != null && floor.position + floor.length > j11) {
            return floor;
        }
        SimpleCacheSpan ceiling = this.cachedSpans.ceiling(createLookup);
        if (ceiling != null) {
            long j13 = ceiling.position - j11;
            if (j12 == -1) {
                j12 = j13;
            } else {
                j12 = Math.min(j13, j12);
            }
        }
        return SimpleCacheSpan.createHole(this.key, j11, j12);
    }

    public TreeSet<SimpleCacheSpan> getSpans() {
        return this.cachedSpans;
    }

    public int hashCode() {
        return (((this.f35064id * 31) + this.key.hashCode()) * 31) + this.metadata.hashCode();
    }

    public boolean isEmpty() {
        return this.cachedSpans.isEmpty();
    }

    public boolean isFullyLocked(long j11, long j12) {
        for (int i11 = 0; i11 < this.lockedRanges.size(); i11++) {
            if (this.lockedRanges.get(i11).contains(j11, j12)) {
                return true;
            }
        }
        return false;
    }

    public boolean isFullyUnlocked() {
        return this.lockedRanges.isEmpty();
    }

    public boolean lockRange(long j11, long j12) {
        for (int i11 = 0; i11 < this.lockedRanges.size(); i11++) {
            if (this.lockedRanges.get(i11).intersects(j11, j12)) {
                return false;
            }
        }
        this.lockedRanges.add(new Range(j11, j12));
        return true;
    }

    public boolean removeSpan(CacheSpan cacheSpan) {
        if (!this.cachedSpans.remove(cacheSpan)) {
            return false;
        }
        File file = cacheSpan.file;
        if (file == null) {
            return true;
        }
        file.delete();
        return true;
    }

    public SimpleCacheSpan setLastTouchTimestamp(SimpleCacheSpan simpleCacheSpan, long j11, boolean z11) {
        Assertions.checkState(this.cachedSpans.remove(simpleCacheSpan));
        File file = (File) Assertions.checkNotNull(simpleCacheSpan.file);
        if (z11) {
            File cacheFile = SimpleCacheSpan.getCacheFile((File) Assertions.checkNotNull(file.getParentFile()), this.f35064id, simpleCacheSpan.position, j11);
            if (file.renameTo(cacheFile)) {
                file = cacheFile;
            } else {
                Log.w(TAG, "Failed to rename " + file + " to " + cacheFile);
            }
        }
        SimpleCacheSpan copyWithFileAndLastTouchTimestamp = simpleCacheSpan.copyWithFileAndLastTouchTimestamp(file, j11);
        this.cachedSpans.add(copyWithFileAndLastTouchTimestamp);
        return copyWithFileAndLastTouchTimestamp;
    }

    public void unlockRange(long j11) {
        for (int i11 = 0; i11 < this.lockedRanges.size(); i11++) {
            if (this.lockedRanges.get(i11).position == j11) {
                this.lockedRanges.remove(i11);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public CachedContent(int i11, String str, DefaultContentMetadata defaultContentMetadata) {
        this.f35064id = i11;
        this.key = str;
        this.metadata = defaultContentMetadata;
        this.cachedSpans = new TreeSet<>();
        this.lockedRanges = new ArrayList<>();
    }
}

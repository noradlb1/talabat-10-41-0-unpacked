package com.google.firebase.database.core.persistence;

public class LRUCachePolicy implements CachePolicy {
    private static final long MAX_NUMBER_OF_PRUNABLE_QUERIES_TO_KEEP = 1000;
    private static final float PERCENT_OF_QUERIES_TO_PRUNE_AT_ONCE = 0.2f;
    private static final long SERVER_UPDATES_BETWEEN_CACHE_SIZE_CHECKS = 1000;
    public final long maxSizeBytes;

    public LRUCachePolicy(long j11) {
        this.maxSizeBytes = j11;
    }

    public long getMaxNumberOfQueriesToKeep() {
        return 1000;
    }

    public float getPercentOfQueriesToPruneAtOnce() {
        return 0.2f;
    }

    public boolean shouldCheckCacheSize(long j11) {
        return j11 > 1000;
    }

    public boolean shouldPrune(long j11, long j12) {
        return j11 > this.maxSizeBytes || j12 > 1000;
    }
}

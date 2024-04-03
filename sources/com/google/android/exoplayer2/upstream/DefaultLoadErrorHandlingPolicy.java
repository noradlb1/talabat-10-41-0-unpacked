package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.Loader;
import java.io.FileNotFoundException;
import java.io.IOException;
import l8.g;

public class DefaultLoadErrorHandlingPolicy implements LoadErrorHandlingPolicy {
    private static final int DEFAULT_BEHAVIOR_MIN_LOADABLE_RETRY_COUNT = -1;
    public static final long DEFAULT_LOCATION_EXCLUSION_MS = 300000;
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT = 3;
    public static final int DEFAULT_MIN_LOADABLE_RETRY_COUNT_PROGRESSIVE_LIVE = 6;
    @Deprecated
    public static final long DEFAULT_TRACK_BLACKLIST_MS = 60000;
    public static final long DEFAULT_TRACK_EXCLUSION_MS = 60000;
    private final int minimumLoadableRetryCount;

    public DefaultLoadErrorHandlingPolicy() {
        this(-1);
    }

    @Nullable
    public LoadErrorHandlingPolicy.FallbackSelection getFallbackSelectionFor(LoadErrorHandlingPolicy.FallbackOptions fallbackOptions, LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo) {
        if (!isEligibleForFallback(loadErrorInfo.exception)) {
            return null;
        }
        if (fallbackOptions.isFallbackAvailable(1)) {
            return new LoadErrorHandlingPolicy.FallbackSelection(1, 300000);
        }
        if (fallbackOptions.isFallbackAvailable(2)) {
            return new LoadErrorHandlingPolicy.FallbackSelection(2, 60000);
        }
        return null;
    }

    public int getMinimumLoadableRetryCount(int i11) {
        int i12 = this.minimumLoadableRetryCount;
        return i12 == -1 ? i11 == 7 ? 6 : 3 : i12;
    }

    public long getRetryDelayMsFor(LoadErrorHandlingPolicy.LoadErrorInfo loadErrorInfo) {
        IOException iOException = loadErrorInfo.exception;
        if ((iOException instanceof ParserException) || (iOException instanceof FileNotFoundException) || (iOException instanceof HttpDataSource.CleartextNotPermittedException) || (iOException instanceof Loader.UnexpectedLoaderException) || DataSourceException.isCausedByPositionOutOfRange(iOException)) {
            return C.TIME_UNSET;
        }
        return (long) Math.min((loadErrorInfo.errorCount - 1) * 1000, 5000);
    }

    public boolean isEligibleForFallback(IOException iOException) {
        if (!(iOException instanceof HttpDataSource.InvalidResponseCodeException)) {
            return false;
        }
        int i11 = ((HttpDataSource.InvalidResponseCodeException) iOException).responseCode;
        if (i11 == 403 || i11 == 404 || i11 == 410 || i11 == 416 || i11 == 500 || i11 == 503) {
            return true;
        }
        return false;
    }

    public /* synthetic */ void onLoadTaskConcluded(long j11) {
        g.a(this, j11);
    }

    public DefaultLoadErrorHandlingPolicy(int i11) {
        this.minimumLoadableRetryCount = i11;
    }
}

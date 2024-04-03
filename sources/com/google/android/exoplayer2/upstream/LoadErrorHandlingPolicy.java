package com.google.android.exoplayer2.upstream;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public interface LoadErrorHandlingPolicy {
    public static final int FALLBACK_TYPE_LOCATION = 1;
    public static final int FALLBACK_TYPE_TRACK = 2;

    public static final class FallbackOptions {
        public final int numberOfExcludedLocations;
        public final int numberOfExcludedTracks;
        public final int numberOfLocations;
        public final int numberOfTracks;

        public FallbackOptions(int i11, int i12, int i13, int i14) {
            this.numberOfLocations = i11;
            this.numberOfExcludedLocations = i12;
            this.numberOfTracks = i13;
            this.numberOfExcludedTracks = i14;
        }

        public boolean isFallbackAvailable(int i11) {
            if (i11 == 1) {
                if (this.numberOfLocations - this.numberOfExcludedLocations <= 1) {
                    return false;
                }
            } else if (this.numberOfTracks - this.numberOfExcludedTracks <= 1) {
                return false;
            }
            return true;
        }
    }

    public static final class FallbackSelection {
        public final long exclusionDurationMs;
        public final int type;

        public FallbackSelection(int i11, long j11) {
            boolean z11;
            if (j11 >= 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            Assertions.checkArgument(z11);
            this.type = i11;
            this.exclusionDurationMs = j11;
        }
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface FallbackType {
    }

    public static final class LoadErrorInfo {
        public final int errorCount;
        public final IOException exception;
        public final LoadEventInfo loadEventInfo;
        public final MediaLoadData mediaLoadData;

        public LoadErrorInfo(LoadEventInfo loadEventInfo2, MediaLoadData mediaLoadData2, IOException iOException, int i11) {
            this.loadEventInfo = loadEventInfo2;
            this.mediaLoadData = mediaLoadData2;
            this.exception = iOException;
            this.errorCount = i11;
        }
    }

    @Nullable
    FallbackSelection getFallbackSelectionFor(FallbackOptions fallbackOptions, LoadErrorInfo loadErrorInfo);

    int getMinimumLoadableRetryCount(int i11);

    long getRetryDelayMsFor(LoadErrorInfo loadErrorInfo);

    void onLoadTaskConcluded(long j11);
}

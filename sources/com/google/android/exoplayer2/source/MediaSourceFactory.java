package com.google.android.exoplayer2.source;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;

@Deprecated
public interface MediaSourceFactory extends MediaSource.Factory {
    public static final MediaSourceFactory UNSUPPORTED = new MediaSourceFactory() {
        public MediaSource createMediaSource(MediaItem mediaItem) {
            throw new UnsupportedOperationException();
        }

        public int[] getSupportedTypes() {
            throw new UnsupportedOperationException();
        }

        public MediaSourceFactory setDrmSessionManagerProvider(@Nullable DrmSessionManagerProvider drmSessionManagerProvider) {
            return this;
        }

        public MediaSourceFactory setLoadErrorHandlingPolicy(@Nullable LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            return this;
        }
    };
}

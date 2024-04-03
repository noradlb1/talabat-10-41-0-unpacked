package com.bumptech.glide.request.transition;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;

public class DrawableCrossFadeFactory implements TransitionFactory<Drawable> {
    private final int duration;
    private final boolean isCrossFadeEnabled;
    private DrawableCrossFadeTransition resourceTransition;

    public static class Builder {
        private static final int DEFAULT_DURATION_MS = 300;
        private final int durationMillis;
        private boolean isCrossFadeEnabled;

        public Builder() {
            this(300);
        }

        public DrawableCrossFadeFactory build() {
            return new DrawableCrossFadeFactory(this.durationMillis, this.isCrossFadeEnabled);
        }

        public Builder setCrossFadeEnabled(boolean z11) {
            this.isCrossFadeEnabled = z11;
            return this;
        }

        public Builder(int i11) {
            this.durationMillis = i11;
        }
    }

    public DrawableCrossFadeFactory(int i11, boolean z11) {
        this.duration = i11;
        this.isCrossFadeEnabled = z11;
    }

    private Transition<Drawable> getResourceTransition() {
        if (this.resourceTransition == null) {
            this.resourceTransition = new DrawableCrossFadeTransition(this.duration, this.isCrossFadeEnabled);
        }
        return this.resourceTransition;
    }

    public Transition<Drawable> build(DataSource dataSource, boolean z11) {
        if (dataSource == DataSource.MEMORY_CACHE) {
            return NoTransition.get();
        }
        return getResourceTransition();
    }
}

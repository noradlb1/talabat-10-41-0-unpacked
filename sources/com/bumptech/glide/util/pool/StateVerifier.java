package com.bumptech.glide.util.pool;

import androidx.annotation.NonNull;

public abstract class StateVerifier {
    private static final boolean DEBUG = false;

    public static class DebugStateVerifier extends StateVerifier {
        private volatile RuntimeException recycledAtStackTraceException;

        public DebugStateVerifier() {
            super();
        }

        public void setRecycled(boolean z11) {
            if (z11) {
                this.recycledAtStackTraceException = new RuntimeException("Released");
            } else {
                this.recycledAtStackTraceException = null;
            }
        }

        public void throwIfRecycled() {
            if (this.recycledAtStackTraceException != null) {
                throw new IllegalStateException("Already released", this.recycledAtStackTraceException);
            }
        }
    }

    public static class DefaultStateVerifier extends StateVerifier {
        private volatile boolean isReleased;

        public DefaultStateVerifier() {
            super();
        }

        public void setRecycled(boolean z11) {
            this.isReleased = z11;
        }

        public void throwIfRecycled() {
            if (this.isReleased) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    private StateVerifier() {
    }

    @NonNull
    public static StateVerifier newInstance() {
        return new DefaultStateVerifier();
    }

    public abstract void setRecycled(boolean z11);

    public abstract void throwIfRecycled();
}

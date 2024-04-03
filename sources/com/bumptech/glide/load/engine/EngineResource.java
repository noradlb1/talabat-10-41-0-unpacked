package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.util.Preconditions;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

class EngineResource<Z> implements Resource<Z> {
    private int acquired;
    private final boolean isMemoryCacheable;
    private final boolean isRecyclable;
    private boolean isRecycled;
    private final Key key;
    private final ResourceListener listener;
    private final Resource<Z> resource;

    public interface ResourceListener {
        void onResourceReleased(Key key, EngineResource<?> engineResource);
    }

    public EngineResource(Resource<Z> resource2, boolean z11, boolean z12, Key key2, ResourceListener resourceListener) {
        this.resource = (Resource) Preconditions.checkNotNull(resource2);
        this.isMemoryCacheable = z11;
        this.isRecyclable = z12;
        this.key = key2;
        this.listener = (ResourceListener) Preconditions.checkNotNull(resourceListener);
    }

    public synchronized void acquire() {
        if (!this.isRecycled) {
            this.acquired++;
        } else {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    @NonNull
    public Z get() {
        return this.resource.get();
    }

    public Resource<Z> getResource() {
        return this.resource;
    }

    @NonNull
    public Class<Z> getResourceClass() {
        return this.resource.getResourceClass();
    }

    public int getSize() {
        return this.resource.getSize();
    }

    public boolean isMemoryCacheable() {
        return this.isMemoryCacheable;
    }

    public synchronized void recycle() {
        if (this.acquired > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (!this.isRecycled) {
            this.isRecycled = true;
            if (this.isRecyclable) {
                this.resource.recycle();
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
    }

    public void release() {
        boolean z11;
        synchronized (this) {
            int i11 = this.acquired;
            if (i11 > 0) {
                z11 = true;
                int i12 = i11 - 1;
                this.acquired = i12;
                if (i12 != 0) {
                    z11 = false;
                }
            } else {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
        }
        if (z11) {
            this.listener.onResourceReleased(this.key, this);
        }
    }

    public synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.isMemoryCacheable + ", listener=" + this.listener + ", key=" + this.key + ", acquired=" + this.acquired + ", isRecycled=" + this.isRecycled + ", resource=" + this.resource + AbstractJsonLexerKt.END_OBJ;
    }
}

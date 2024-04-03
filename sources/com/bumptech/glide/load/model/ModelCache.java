package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.util.Queue;

public class ModelCache<A, B> {
    private static final int DEFAULT_SIZE = 250;
    private final LruCache<ModelKey<A>, B> cache;

    @VisibleForTesting
    public static final class ModelKey<A> {
        private static final Queue<ModelKey<?>> KEY_QUEUE = Util.createQueue(0);
        private int height;
        private A model;
        private int width;

        private ModelKey() {
        }

        public static <A> ModelKey<A> get(A a11, int i11, int i12) {
            ModelKey<A> poll;
            Queue<ModelKey<?>> queue = KEY_QUEUE;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new ModelKey<>();
            }
            poll.init(a11, i11, i12);
            return poll;
        }

        private void init(A a11, int i11, int i12) {
            this.model = a11;
            this.width = i11;
            this.height = i12;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof ModelKey)) {
                return false;
            }
            ModelKey modelKey = (ModelKey) obj;
            if (this.width == modelKey.width && this.height == modelKey.height && this.model.equals(modelKey.model)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((this.height * 31) + this.width) * 31) + this.model.hashCode();
        }

        public void release() {
            Queue<ModelKey<?>> queue = KEY_QUEUE;
            synchronized (queue) {
                queue.offer(this);
            }
        }
    }

    public ModelCache() {
        this(250);
    }

    public void clear() {
        this.cache.clearMemory();
    }

    @Nullable
    public B get(A a11, int i11, int i12) {
        ModelKey modelKey = ModelKey.get(a11, i11, i12);
        B b11 = this.cache.get(modelKey);
        modelKey.release();
        return b11;
    }

    public void put(A a11, int i11, int i12, B b11) {
        this.cache.put(ModelKey.get(a11, i11, i12), b11);
    }

    public ModelCache(long j11) {
        this.cache = new LruCache<ModelKey<A>, B>(j11) {
            public void onItemEvicted(@NonNull ModelKey<A> modelKey, @Nullable B b11) {
                modelKey.release();
            }
        };
    }
}

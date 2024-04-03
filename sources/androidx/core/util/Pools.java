package androidx.core.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class Pools {

    public interface Pool<T> {
        @Nullable
        T acquire();

        boolean release(@NonNull T t11);
    }

    public static class SimplePool<T> implements Pool<T> {
        private final Object[] mPool;
        private int mPoolSize;

        public SimplePool(int i11) {
            if (i11 > 0) {
                this.mPool = new Object[i11];
                return;
            }
            throw new IllegalArgumentException("The max pool size must be > 0");
        }

        private boolean isInPool(@NonNull T t11) {
            for (int i11 = 0; i11 < this.mPoolSize; i11++) {
                if (this.mPool[i11] == t11) {
                    return true;
                }
            }
            return false;
        }

        public T acquire() {
            int i11 = this.mPoolSize;
            if (i11 <= 0) {
                return null;
            }
            int i12 = i11 - 1;
            T[] tArr = this.mPool;
            T t11 = tArr[i12];
            tArr[i12] = null;
            this.mPoolSize = i11 - 1;
            return t11;
        }

        public boolean release(@NonNull T t11) {
            if (!isInPool(t11)) {
                int i11 = this.mPoolSize;
                Object[] objArr = this.mPool;
                if (i11 >= objArr.length) {
                    return false;
                }
                objArr[i11] = t11;
                this.mPoolSize = i11 + 1;
                return true;
            }
            throw new IllegalStateException("Already in the pool!");
        }
    }

    public static class SynchronizedPool<T> extends SimplePool<T> {
        private final Object mLock = new Object();

        public SynchronizedPool(int i11) {
            super(i11);
        }

        public T acquire() {
            T acquire;
            synchronized (this.mLock) {
                acquire = super.acquire();
            }
            return acquire;
        }

        public boolean release(@NonNull T t11) {
            boolean release;
            synchronized (this.mLock) {
                release = super.release(t11);
            }
            return release;
        }
    }

    private Pools() {
    }
}

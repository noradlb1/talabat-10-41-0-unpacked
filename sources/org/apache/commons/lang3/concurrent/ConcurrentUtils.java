package org.apache.commons.lang3.concurrent;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ConcurrentUtils {

    public static final class ConstantFuture<T> implements Future<T> {
        private final T value;

        public ConstantFuture(T t11) {
            this.value = t11;
        }

        public boolean cancel(boolean z11) {
            return false;
        }

        public T get() {
            return this.value;
        }

        public boolean isCancelled() {
            return false;
        }

        public boolean isDone() {
            return true;
        }

        public T get(long j11, TimeUnit timeUnit) {
            return this.value;
        }
    }

    private ConcurrentUtils() {
    }

    public static Throwable checkedException(Throwable th2) {
        if (th2 != null && !(th2 instanceof RuntimeException) && !(th2 instanceof Error)) {
            return th2;
        }
        throw new IllegalArgumentException("Not a checked exception: " + th2);
    }

    public static <T> Future<T> constantFuture(T t11) {
        return new ConstantFuture(t11);
    }

    public static <K, V> V createIfAbsent(ConcurrentMap<K, V> concurrentMap, K k11, ConcurrentInitializer<V> concurrentInitializer) throws ConcurrentException {
        if (concurrentMap == null || concurrentInitializer == null) {
            return null;
        }
        V v11 = concurrentMap.get(k11);
        if (v11 == null) {
            return putIfAbsent(concurrentMap, k11, concurrentInitializer.get());
        }
        return v11;
    }

    public static <K, V> V createIfAbsentUnchecked(ConcurrentMap<K, V> concurrentMap, K k11, ConcurrentInitializer<V> concurrentInitializer) {
        try {
            return createIfAbsent(concurrentMap, k11, concurrentInitializer);
        } catch (ConcurrentException e11) {
            throw new ConcurrentRuntimeException(e11.getCause());
        }
    }

    public static ConcurrentException extractCause(ExecutionException executionException) {
        if (executionException == null || executionException.getCause() == null) {
            return null;
        }
        throwCause(executionException);
        return new ConcurrentException(executionException.getMessage(), executionException.getCause());
    }

    public static ConcurrentRuntimeException extractCauseUnchecked(ExecutionException executionException) {
        if (executionException == null || executionException.getCause() == null) {
            return null;
        }
        throwCause(executionException);
        return new ConcurrentRuntimeException(executionException.getMessage(), executionException.getCause());
    }

    public static void handleCause(ExecutionException executionException) throws ConcurrentException {
        ConcurrentException extractCause = extractCause(executionException);
        if (extractCause != null) {
            throw extractCause;
        }
    }

    public static void handleCauseUnchecked(ExecutionException executionException) {
        ConcurrentRuntimeException extractCauseUnchecked = extractCauseUnchecked(executionException);
        if (extractCauseUnchecked != null) {
            throw extractCauseUnchecked;
        }
    }

    public static <T> T initialize(ConcurrentInitializer<T> concurrentInitializer) throws ConcurrentException {
        if (concurrentInitializer != null) {
            return concurrentInitializer.get();
        }
        return null;
    }

    public static <T> T initializeUnchecked(ConcurrentInitializer<T> concurrentInitializer) {
        try {
            return initialize(concurrentInitializer);
        } catch (ConcurrentException e11) {
            throw new ConcurrentRuntimeException(e11.getCause());
        }
    }

    public static <K, V> V putIfAbsent(ConcurrentMap<K, V> concurrentMap, K k11, V v11) {
        if (concurrentMap == null) {
            return null;
        }
        V putIfAbsent = concurrentMap.putIfAbsent(k11, v11);
        return putIfAbsent != null ? putIfAbsent : v11;
    }

    private static void throwCause(ExecutionException executionException) {
        if (executionException.getCause() instanceof RuntimeException) {
            throw ((RuntimeException) executionException.getCause());
        } else if (executionException.getCause() instanceof Error) {
            throw ((Error) executionException.getCause());
        }
    }
}

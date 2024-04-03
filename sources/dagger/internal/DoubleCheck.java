package dagger.internal;

import dagger.Lazy;
import javax.inject.Provider;

public final class DoubleCheck<T> implements Provider<T>, Lazy<T> {
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile Provider<T> provider;

    private DoubleCheck(Provider<T> provider2) {
        this.provider = provider2;
    }

    public static <P extends Provider<T>, T> Lazy<T> lazy(P p11) {
        if (p11 instanceof Lazy) {
            return (Lazy) p11;
        }
        return new DoubleCheck((Provider) Preconditions.checkNotNull(p11));
    }

    public static <P extends Provider<T>, T> Provider<T> provider(P p11) {
        Preconditions.checkNotNull(p11);
        if (p11 instanceof DoubleCheck) {
            return p11;
        }
        return new DoubleCheck(p11);
    }

    private static Object reentrantCheck(Object obj, Object obj2) {
        boolean z11;
        if (obj != UNINITIALIZED) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    public T get() {
        T t11 = this.instance;
        T t12 = UNINITIALIZED;
        if (t11 == t12) {
            synchronized (this) {
                t11 = this.instance;
                if (t11 == t12) {
                    t11 = this.provider.get();
                    this.instance = reentrantCheck(this.instance, t11);
                    this.provider = null;
                }
            }
        }
        return t11;
    }
}

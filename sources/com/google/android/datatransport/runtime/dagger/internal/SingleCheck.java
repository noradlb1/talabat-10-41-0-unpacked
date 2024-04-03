package com.google.android.datatransport.runtime.dagger.internal;

import javax.inject.Provider;

public final class SingleCheck<T> implements Provider<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile Provider<T> provider;

    private SingleCheck(Provider<T> provider2) {
        this.provider = provider2;
    }

    public static <P extends Provider<T>, T> Provider<T> provider(P p11) {
        if ((p11 instanceof SingleCheck) || (p11 instanceof DoubleCheck)) {
            return p11;
        }
        return new SingleCheck((Provider) Preconditions.checkNotNull(p11));
    }

    public T get() {
        T t11 = this.instance;
        if (t11 != UNINITIALIZED) {
            return t11;
        }
        Provider<T> provider2 = this.provider;
        if (provider2 == null) {
            return this.instance;
        }
        T t12 = provider2.get();
        this.instance = t12;
        this.provider = null;
        return t12;
    }
}

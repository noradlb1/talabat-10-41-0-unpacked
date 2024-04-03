package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.lang.ref.WeakReference;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
public abstract class FinalizableWeakReference<T> extends WeakReference<T> implements FinalizableReference {
    public FinalizableWeakReference(@CheckForNull T t11, FinalizableReferenceQueue finalizableReferenceQueue) {
        super(t11, finalizableReferenceQueue.queue);
        finalizableReferenceQueue.cleanUp();
    }
}

package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import java.lang.ref.SoftReference;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
@J2ktIncompatible
public abstract class FinalizableSoftReference<T> extends SoftReference<T> implements FinalizableReference {
    public FinalizableSoftReference(@CheckForNull T t11, FinalizableReferenceQueue finalizableReferenceQueue) {
        super(t11, finalizableReferenceQueue.queue);
        finalizableReferenceQueue.cleanUp();
    }
}

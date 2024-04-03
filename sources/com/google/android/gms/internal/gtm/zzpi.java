package com.google.android.gms.internal.gtm;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class zzpi extends WeakReference<Throwable> {
    private final int zzavn;

    public zzpi(Throwable th2, ReferenceQueue<Throwable> referenceQueue) {
        super(th2, (ReferenceQueue) null);
        if (th2 != null) {
            this.zzavn = System.identityHashCode(th2);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzpi.class) {
            if (this == obj) {
                return true;
            }
            zzpi zzpi = (zzpi) obj;
            if (this.zzavn == zzpi.zzavn && get() == zzpi.get()) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return this.zzavn;
    }
}

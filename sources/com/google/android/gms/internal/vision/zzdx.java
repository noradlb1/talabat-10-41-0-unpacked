package com.google.android.gms.internal.vision;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class zzdx extends WeakReference<Throwable> {
    private final int zzmi;

    public zzdx(Throwable th2, ReferenceQueue<Throwable> referenceQueue) {
        super(th2, referenceQueue);
        if (th2 != null) {
            this.zzmi = System.identityHashCode(th2);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzdx.class) {
            if (this == obj) {
                return true;
            }
            zzdx zzdx = (zzdx) obj;
            if (this.zzmi == zzdx.zzmi && get() == zzdx.get()) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return this.zzmi;
    }
}

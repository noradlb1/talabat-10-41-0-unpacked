package com.google.android.gms.internal.consent_sdk;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

final class zzck extends WeakReference<Throwable> {
    private final int zza;

    public zzck(Throwable th2, ReferenceQueue<Throwable> referenceQueue) {
        super(th2, referenceQueue);
        if (th2 != null) {
            this.zza = System.identityHashCode(th2);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzck.class) {
            if (this == obj) {
                return true;
            }
            zzck zzck = (zzck) obj;
            if (this.zza == zzck.zza && get() == zzck.get()) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return this.zza;
    }
}

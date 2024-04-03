package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

public final class zzfaq {
    public static <T> void zza(AtomicReference<T> atomicReference, zzfap<T> zzfap) {
        T t11 = atomicReference.get();
        if (t11 != null) {
            try {
                zzfap.zza(t11);
            } catch (RemoteException e11) {
                zzciz.zzl("#007 Could not call remote method.", e11);
            } catch (NullPointerException e12) {
                zzciz.zzk("NullPointerException occurs when invoking a method from a delegating listener.", e12);
            }
        }
    }
}

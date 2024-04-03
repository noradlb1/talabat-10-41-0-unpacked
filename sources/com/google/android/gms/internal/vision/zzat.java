package com.google.android.gms.internal.vision;

import android.os.Binder;

public final /* synthetic */ class zzat {
    public static <V> V zza(zzaw<V> zzaw) {
        long clearCallingIdentity;
        try {
            return zzaw.zzt();
        } catch (SecurityException unused) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            V zzt = zzaw.zzt();
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return zzt;
        } catch (Throwable th2) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th2;
        }
    }
}

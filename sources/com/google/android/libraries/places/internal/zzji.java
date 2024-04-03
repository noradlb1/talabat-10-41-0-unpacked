package com.google.android.libraries.places.internal;

final class zzji implements zzjh {
    public final StackTraceElement zza(Class<?> cls, int i11) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        String name2 = cls.getName();
        int i12 = 3;
        boolean z11 = false;
        while (true) {
            if (i12 >= stackTrace.length) {
                i12 = -1;
                break;
            }
            if (stackTrace[i12].getClassName().equals(name2)) {
                z11 = true;
            } else if (z11) {
                break;
            } else {
                z11 = false;
            }
            i12++;
        }
        if (i12 != -1) {
            return stackTrace[i12];
        }
        return null;
    }
}

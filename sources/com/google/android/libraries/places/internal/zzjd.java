package com.google.android.libraries.places.internal;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class zzjd {
    private static final String[] zza;
    private static final zzjh zzb;

    static {
        zzjh zzji;
        String[] strArr = {"com.google.common.flogger.util.StackWalkerStackGetter", "com.google.common.flogger.util.JavaLangAccessStackGetter"};
        zza = strArr;
        int i11 = 0;
        while (true) {
            if (i11 >= 2) {
                zzji = new zzji();
                break;
            }
            try {
                zzji = (zzjh) Class.forName(strArr[i11]).asSubclass(zzjh.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable unused) {
                zzji = null;
            }
            if (zzji != null) {
                break;
            }
            i11++;
        }
        zzb = zzji;
    }

    @NullableDecl
    public static StackTraceElement zza(Class<?> cls, int i11) {
        zzje.zza(cls, "target");
        return zzb.zza(cls, 2);
    }
}

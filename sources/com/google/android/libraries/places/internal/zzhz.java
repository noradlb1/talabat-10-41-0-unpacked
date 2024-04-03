package com.google.android.libraries.places.internal;

import java.lang.reflect.InvocationTargetException;

final class zzhz {
    /* access modifiers changed from: private */
    public static final zzib zza = zzb(zzib.zzd);

    private static zzib zzb(String[] strArr) {
        zzib zzib;
        try {
            zzib = zzic.zza();
        } catch (NoClassDefFoundError unused) {
            zzib = null;
        }
        if (zzib != null) {
            return zzib;
        }
        StringBuilder sb2 = new StringBuilder();
        int length = strArr.length;
        int i11 = 0;
        while (i11 < length) {
            String str = strArr[i11];
            try {
                return (zzib) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (Throwable th2) {
                th = th2;
                if (th instanceof InvocationTargetException) {
                    th = th.getCause();
                }
                sb2.append(10);
                sb2.append(str);
                sb2.append(": ");
                sb2.append(th);
                i11++;
            }
        }
        throw new IllegalStateException(sb2.insert(0, "No logging platforms found:").toString());
    }
}

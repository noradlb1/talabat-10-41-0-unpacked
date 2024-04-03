package com.google.android.recaptcha.internal;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class zzbg {
    @NotNull
    public static final zzbg zza = new zzbg();

    private zzbg() {
    }

    @NotNull
    public static final Class zza(@Nullable Object obj) {
        Class cls;
        if (obj instanceof Class) {
            return (Class) obj;
        }
        if (obj instanceof Integer) {
            int intValue = ((Number) obj).intValue();
            if (intValue == 1) {
                cls = Integer.TYPE;
            } else if (intValue == 2) {
                cls = Short.TYPE;
            } else if (intValue == 3) {
                cls = Byte.TYPE;
            } else if (intValue == 4) {
                cls = Long.TYPE;
            } else if (intValue == 5) {
                cls = Character.TYPE;
            } else if (intValue == 6) {
                cls = Float.TYPE;
            } else if (intValue == 7) {
                cls = Double.TYPE;
            } else if (intValue == 8) {
                cls = Boolean.TYPE;
            } else {
                cls = null;
            }
            if (cls != null) {
                return cls;
            }
            throw new zzs(4, 6, (Throwable) null);
        } else if (obj instanceof String) {
            String str = (String) obj;
            if (zzaz.zzc(str)) {
                try {
                    return Class.forName(str);
                } catch (Exception e11) {
                    throw new zzs(6, 8, e11);
                }
            } else {
                throw new zzs(6, 47, (Throwable) null);
            }
        } else {
            throw new zzs(6, 8, (Throwable) null);
        }
    }
}

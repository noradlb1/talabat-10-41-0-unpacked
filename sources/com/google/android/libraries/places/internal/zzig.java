package com.google.android.libraries.places.internal;

import android.os.Build;
import dalvik.system.VMStack;

public final class zzig extends zzib {
    /* access modifiers changed from: private */
    public static final boolean zza = zza.zza();
    /* access modifiers changed from: private */
    public static final boolean zzb;
    private static final zzia zzc = new zzia() {
        public zzhg zza(Class<?> cls, int i11) {
            return zzhg.zza;
        }

        public String zzb(Class cls) {
            StackTraceElement zza;
            if (zzig.zza) {
                try {
                    if (cls.equals(zzig.zzp())) {
                        return VMStack.getStackClass2().getName();
                    }
                } catch (Throwable unused) {
                }
            }
            if (!zzig.zzb || (zza = zzjd.zza(cls, 1)) == null) {
                return null;
            }
            return zza.getClassName();
        }
    };

    final class zza {
        public static boolean zza() {
            return zzig.zzt();
        }
    }

    static {
        String str = Build.FINGERPRINT;
        boolean z11 = true;
        if (str != null && !"robolectric".equals(str)) {
            z11 = false;
        }
        zzb = z11;
    }

    public static Class<?> zzp() {
        return VMStack.getStackClass2();
    }

    public static String zzq() {
        try {
            return VMStack.getStackClass2().getName();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean zzt() {
        try {
            Class.forName("dalvik.system.VMStack").getMethod("getStackClass2", new Class[0]);
            return zza.class.getName().equals(zzq());
        } catch (Throwable unused) {
            return false;
        }
    }

    public zzhl zze(String str) {
        return zzij.zzb(str);
    }

    public zzia zzh() {
        return zzc;
    }

    public zzip zzj() {
        return zzik.zzb();
    }

    public String zzm() {
        return "platform: Android";
    }
}

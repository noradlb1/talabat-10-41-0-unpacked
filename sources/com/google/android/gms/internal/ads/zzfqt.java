package com.google.android.gms.internal.ads;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import javax.annotation.CheckForNull;

public final class zzfqt {
    @CheckForNull
    private static final Object zza;
    @CheckForNull
    private static final Method zzb;
    @CheckForNull
    private static final Method zzc;

    static {
        Method method;
        Object zzc2 = zzc();
        zza = zzc2;
        Method method2 = null;
        if (zzc2 == null) {
            method = null;
        } else {
            method = zzd("getStackTraceElement", Throwable.class, Integer.TYPE);
        }
        zzb = method;
        if (zzc2 != null) {
            method2 = zze(zzc2);
        }
        zzc = method2;
    }

    public static String zza(Throwable th2) {
        StringWriter stringWriter = new StringWriter();
        th2.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public static void zzb(Throwable th2) {
        if (th2 instanceof RuntimeException) {
            throw ((RuntimeException) th2);
        } else if (th2 instanceof Error) {
            throw ((Error) th2);
        }
    }

    @CheckForNull
    private static Object zzc() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, (ClassLoader) null).getMethod("getJavaLangAccess", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (ThreadDeath e11) {
            throw e11;
        } catch (Throwable unused) {
            return null;
        }
    }

    @CheckForNull
    private static Method zzd(String str, Class<?>... clsArr) throws ThreadDeath {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, (ClassLoader) null).getMethod(str, clsArr);
        } catch (ThreadDeath e11) {
            throw e11;
        } catch (Throwable unused) {
            return null;
        }
    }

    @CheckForNull
    private static Method zze(Object obj) {
        try {
            Method zzd = zzd("getStackTraceDepth", Throwable.class);
            if (zzd == null) {
                return null;
            }
            zzd.invoke(obj, new Object[]{new Throwable()});
            return zzd;
        } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            return null;
        }
    }
}

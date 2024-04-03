package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.tagmanager.ModuleDescriptor;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.HashMap;
import java.util.Map;

final class zzbf {
    private static volatile DynamiteModule zzagl;
    private static volatile zzcp zzagm;
    /* access modifiers changed from: private */
    public static final Map<String, CustomTagProvider> zzagn = new HashMap();
    /* access modifiers changed from: private */
    public static final Map<String, CustomVariableProvider> zzago = new HashMap();

    private zzbf() {
    }

    public static void zza(Intent intent, Context context) {
        zzcp zzj = zzj(context);
        synchronized (zzbf.class) {
            try {
                zzj.previewIntent(intent, ObjectWrapper.wrap(context), ObjectWrapper.wrap(zzagl.getModuleContext()), zzl(context), new zzbj());
            } catch (RemoteException e11) {
                throw new IllegalStateException(e11);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static IBinder zzh(Context context) {
        try {
            return zzct.asInterface(zzk(context).instantiate("com.google.android.gms.tagmanager.TagManagerServiceProviderImpl")).getService(ObjectWrapper.wrap(context), zzl(context), new zzbj()).asBinder();
        } catch (RemoteException e11) {
            throw new IllegalStateException(e11);
        } catch (DynamiteModule.LoadingException e12) {
            throw new RuntimeException(e12);
        }
    }

    public static void zzi(Context context) {
        zzcp zzj = zzj(context);
        synchronized (zzbf.class) {
            try {
                zzj.initialize(ObjectWrapper.wrap(context), zzl(context), new zzbj());
            } catch (RemoteException e11) {
                throw new IllegalStateException(e11);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static zzcp zzj(Context context) {
        zzcp zzcp = zzagm;
        if (zzcp == null) {
            synchronized (zzbf.class) {
                zzcp = zzagm;
                if (zzcp == null) {
                    try {
                        zzcp asInterface = zzcq.asInterface(zzk(context).instantiate("com.google.android.gms.tagmanager.TagManagerApiImpl"));
                        zzagm = asInterface;
                        zzcp = asInterface;
                    } catch (DynamiteModule.LoadingException e11) {
                        throw new RuntimeException(e11);
                    }
                }
            }
        }
        return zzcp;
    }

    private static DynamiteModule zzk(Context context) throws DynamiteModule.LoadingException {
        DynamiteModule dynamiteModule = zzagl;
        if (dynamiteModule == null) {
            synchronized (zzbf.class) {
                dynamiteModule = zzagl;
                if (zzagl == null) {
                    DynamiteModule load = DynamiteModule.load(context, DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION, ModuleDescriptor.MODULE_ID);
                    zzagl = load;
                    dynamiteModule = load;
                }
            }
        }
        return dynamiteModule;
    }

    private static zzcm zzl(Context context) {
        return new zzbg(AppMeasurement.getInstance(context));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0062 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object zza(java.lang.String r8, java.lang.Class<?> r9) {
        /*
            java.lang.String r0 = " doesn't have an accessible no-arg constructor"
            java.lang.String r1 = "GoogleTagManagerAPI"
            java.lang.Class r2 = java.lang.Class.forName(r8)     // Catch:{ ClassNotFoundException -> 0x00a4 }
            java.lang.Class[] r3 = r2.getInterfaces()     // Catch:{ ClassNotFoundException -> 0x00a4 }
            int r4 = r3.length     // Catch:{ ClassNotFoundException -> 0x00a4 }
            r5 = 0
            r6 = r5
        L_0x000f:
            if (r6 >= r4) goto L_0x001e
            r7 = r3[r6]     // Catch:{ ClassNotFoundException -> 0x00a4 }
            boolean r7 = r7.equals(r9)     // Catch:{ ClassNotFoundException -> 0x00a4 }
            if (r7 == 0) goto L_0x001b
            r3 = 1
            goto L_0x001f
        L_0x001b:
            int r6 = r6 + 1
            goto L_0x000f
        L_0x001e:
            r3 = r5
        L_0x001f:
            if (r3 != 0) goto L_0x0055
            java.lang.String r9 = r9.getCanonicalName()     // Catch:{ ClassNotFoundException -> 0x00a4 }
            java.lang.String r0 = java.lang.String.valueOf(r8)     // Catch:{ ClassNotFoundException -> 0x00a4 }
            int r0 = r0.length()     // Catch:{ ClassNotFoundException -> 0x00a4 }
            int r0 = r0 + 30
            java.lang.String r2 = java.lang.String.valueOf(r9)     // Catch:{ ClassNotFoundException -> 0x00a4 }
            int r2 = r2.length()     // Catch:{ ClassNotFoundException -> 0x00a4 }
            int r0 = r0 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ ClassNotFoundException -> 0x00a4 }
            r2.<init>(r0)     // Catch:{ ClassNotFoundException -> 0x00a4 }
            r2.append(r8)     // Catch:{ ClassNotFoundException -> 0x00a4 }
            java.lang.String r0 = " doesn't implement "
            r2.append(r0)     // Catch:{ ClassNotFoundException -> 0x00a4 }
            r2.append(r9)     // Catch:{ ClassNotFoundException -> 0x00a4 }
            java.lang.String r9 = " interface."
            r2.append(r9)     // Catch:{ ClassNotFoundException -> 0x00a4 }
            java.lang.String r9 = r2.toString()     // Catch:{ ClassNotFoundException -> 0x00a4 }
            android.util.Log.e(r1, r9)     // Catch:{ ClassNotFoundException -> 0x00a4 }
            goto L_0x00b1
        L_0x0055:
            java.lang.Class[] r9 = new java.lang.Class[r5]     // Catch:{ NoSuchMethodException -> 0x0096, SecurityException -> 0x008a, InvocationTargetException -> 0x007c, InstantiationException -> 0x006e, IllegalAccessException -> 0x0062 }
            java.lang.reflect.Constructor r9 = r2.getConstructor(r9)     // Catch:{ NoSuchMethodException -> 0x0096, SecurityException -> 0x008a, InvocationTargetException -> 0x007c, InstantiationException -> 0x006e, IllegalAccessException -> 0x0062 }
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ NoSuchMethodException -> 0x0096, SecurityException -> 0x008a, InvocationTargetException -> 0x007c, InstantiationException -> 0x006e, IllegalAccessException -> 0x0062 }
            java.lang.Object r8 = r9.newInstance(r2)     // Catch:{ NoSuchMethodException -> 0x0096, SecurityException -> 0x008a, InvocationTargetException -> 0x007c, InstantiationException -> 0x006e, IllegalAccessException -> 0x0062 }
            goto L_0x00b2
        L_0x0062:
            java.lang.String r9 = java.lang.String.valueOf(r8)     // Catch:{ ClassNotFoundException -> 0x00a4 }
            java.lang.String r9 = r9.concat(r0)     // Catch:{ ClassNotFoundException -> 0x00a4 }
            android.util.Log.e(r1, r9)     // Catch:{ ClassNotFoundException -> 0x00a4 }
            goto L_0x00b1
        L_0x006e:
            java.lang.String r9 = java.lang.String.valueOf(r8)     // Catch:{ ClassNotFoundException -> 0x00a4 }
            java.lang.String r0 = " is an abstract class."
            java.lang.String r9 = r9.concat(r0)     // Catch:{ ClassNotFoundException -> 0x00a4 }
            android.util.Log.e(r1, r9)     // Catch:{ ClassNotFoundException -> 0x00a4 }
            goto L_0x00b1
        L_0x007c:
            java.lang.String r9 = java.lang.String.valueOf(r8)     // Catch:{ ClassNotFoundException -> 0x00a4 }
            java.lang.String r0 = " construction threw an exception."
            java.lang.String r9 = r9.concat(r0)     // Catch:{ ClassNotFoundException -> 0x00a4 }
            android.util.Log.e(r1, r9)     // Catch:{ ClassNotFoundException -> 0x00a4 }
            goto L_0x00b1
        L_0x008a:
            java.lang.String r9 = java.lang.String.valueOf(r8)     // Catch:{ ClassNotFoundException -> 0x00a4 }
            java.lang.String r9 = r9.concat(r0)     // Catch:{ ClassNotFoundException -> 0x00a4 }
            android.util.Log.e(r1, r9)     // Catch:{ ClassNotFoundException -> 0x00a4 }
            goto L_0x00b1
        L_0x0096:
            java.lang.String r9 = java.lang.String.valueOf(r8)     // Catch:{ ClassNotFoundException -> 0x00a4 }
            java.lang.String r0 = " doesn't have a valid no-arg constructor"
            java.lang.String r9 = r9.concat(r0)     // Catch:{ ClassNotFoundException -> 0x00a4 }
            android.util.Log.e(r1, r9)     // Catch:{ ClassNotFoundException -> 0x00a4 }
            goto L_0x00b1
        L_0x00a4:
            java.lang.String r8 = java.lang.String.valueOf(r8)
            java.lang.String r9 = " can't be found in the application."
            java.lang.String r8 = r8.concat(r9)
            android.util.Log.e(r1, r8)
        L_0x00b1:
            r8 = 0
        L_0x00b2:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzbf.zza(java.lang.String, java.lang.Class):java.lang.Object");
    }
}

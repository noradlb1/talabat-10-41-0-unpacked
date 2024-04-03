package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@KeepForSdk
public class WorkSourceUtil {
    private static final int zza = Process.myUid();
    private static final Method zzb;
    private static final Method zzc;
    private static final Method zzd;
    private static final Method zze;
    private static final Method zzf;
    private static final Method zzg;
    private static final Method zzh;
    private static final Method zzi;
    @GuardedBy("WorkSourceUtil.class")
    private static Boolean zzj = null;

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00aa  */
    static {
        /*
            java.lang.String r0 = "add"
            java.lang.Class<android.os.WorkSource> r1 = android.os.WorkSource.class
            int r2 = android.os.Process.myUid()
            zza = r2
            r2 = 1
            r3 = 0
            r4 = 0
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0018 }
            java.lang.Class r6 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0018 }
            r5[r3] = r6     // Catch:{ Exception -> 0x0018 }
            java.lang.reflect.Method r5 = r1.getMethod(r0, r5)     // Catch:{ Exception -> 0x0018 }
            goto L_0x0019
        L_0x0018:
            r5 = r4
        L_0x0019:
            zzb = r5
            boolean r5 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR2()
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r7 = 2
            if (r5 == 0) goto L_0x0031
            java.lang.Class[] r5 = new java.lang.Class[r7]     // Catch:{ Exception -> 0x0031 }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0031 }
            r5[r3] = r8     // Catch:{ Exception -> 0x0031 }
            r5[r2] = r6     // Catch:{ Exception -> 0x0031 }
            java.lang.reflect.Method r0 = r1.getMethod(r0, r5)     // Catch:{ Exception -> 0x0031 }
            goto L_0x0032
        L_0x0031:
            r0 = r4
        L_0x0032:
            zzc = r0
            java.lang.String r0 = "size"
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x003d }
            java.lang.reflect.Method r0 = r1.getMethod(r0, r5)     // Catch:{ Exception -> 0x003d }
            goto L_0x003e
        L_0x003d:
            r0 = r4
        L_0x003e:
            zzd = r0
            java.lang.String r0 = "get"
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x004d }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x004d }
            r5[r3] = r8     // Catch:{ Exception -> 0x004d }
            java.lang.reflect.Method r0 = r1.getMethod(r0, r5)     // Catch:{ Exception -> 0x004d }
            goto L_0x004e
        L_0x004d:
            r0 = r4
        L_0x004e:
            zze = r0
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR2()
            if (r0 == 0) goto L_0x0063
            java.lang.String r0 = "getName"
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0063 }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0063 }
            r5[r3] = r8     // Catch:{ Exception -> 0x0063 }
            java.lang.reflect.Method r0 = r1.getMethod(r0, r5)     // Catch:{ Exception -> 0x0063 }
            goto L_0x0064
        L_0x0063:
            r0 = r4
        L_0x0064:
            zzf = r0
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            java.lang.String r5 = "WorkSourceUtil"
            if (r0 == 0) goto L_0x007d
            java.lang.String r0 = "createWorkChain"
            java.lang.Class[] r8 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x0077 }
            java.lang.reflect.Method r0 = r1.getMethod(r0, r8)     // Catch:{ Exception -> 0x0077 }
            goto L_0x007e
        L_0x0077:
            r0 = move-exception
            java.lang.String r8 = "Missing WorkChain API createWorkChain"
            android.util.Log.w(r5, r8, r0)
        L_0x007d:
            r0 = r4
        L_0x007e:
            zzg = r0
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            if (r0 == 0) goto L_0x00a1
            java.lang.String r0 = "android.os.WorkSource$WorkChain"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ Exception -> 0x009b }
            java.lang.String r8 = "addNode"
            java.lang.Class[] r7 = new java.lang.Class[r7]     // Catch:{ Exception -> 0x009b }
            java.lang.Class r9 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x009b }
            r7[r3] = r9     // Catch:{ Exception -> 0x009b }
            r7[r2] = r6     // Catch:{ Exception -> 0x009b }
            java.lang.reflect.Method r0 = r0.getMethod(r8, r7)     // Catch:{ Exception -> 0x009b }
            goto L_0x00a2
        L_0x009b:
            r0 = move-exception
            java.lang.String r6 = "Missing WorkChain class"
            android.util.Log.w(r5, r6, r0)
        L_0x00a1:
            r0 = r4
        L_0x00a2:
            zzh = r0
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastP()
            if (r0 == 0) goto L_0x00b6
            java.lang.String r0 = "isEmpty"
            java.lang.Class[] r3 = new java.lang.Class[r3]     // Catch:{ Exception -> 0x00b6 }
            java.lang.reflect.Method r0 = r1.getMethod(r0, r3)     // Catch:{ Exception -> 0x00b6 }
            r0.setAccessible(r2)     // Catch:{ Exception -> 0x00b7 }
            goto L_0x00b7
        L_0x00b6:
            r0 = r4
        L_0x00b7:
            zzi = r0
            zzj = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.WorkSourceUtil.<clinit>():void");
    }

    private WorkSourceUtil() {
    }

    @KeepForSdk
    public static void add(@NonNull WorkSource workSource, int i11, @NonNull String str) {
        Method method = zzc;
        if (method != null) {
            if (str == null) {
                str = "";
            }
            try {
                method.invoke(workSource, new Object[]{Integer.valueOf(i11), str});
            } catch (Exception e11) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e11);
            }
        } else {
            Method method2 = zzb;
            if (method2 != null) {
                try {
                    method2.invoke(workSource, new Object[]{Integer.valueOf(i11)});
                } catch (Exception e12) {
                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e12);
                }
            }
        }
    }

    @NonNull
    @KeepForSdk
    public static WorkSource fromPackage(@NonNull Context context, @NonNull String str) {
        if (!(context == null || context.getPackageManager() == null || str == null)) {
            try {
                ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
                if (applicationInfo == null) {
                    Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(str));
                    return null;
                }
                int i11 = applicationInfo.uid;
                WorkSource workSource = new WorkSource();
                add(workSource, i11, str);
                return workSource;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("WorkSourceUtil", "Could not find package: ".concat(str));
            }
        }
        return null;
    }

    @NonNull
    @KeepForSdk
    public static WorkSource fromPackageAndModuleExperimentalPi(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        Method method;
        if (context == null || context.getPackageManager() == null || str2 == null || str == null) {
            Log.w("WorkSourceUtil", "Unexpected null arguments");
            return null;
        }
        int i11 = -1;
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(context).getApplicationInfo(str, 0);
            if (applicationInfo == null) {
                Log.e("WorkSourceUtil", "Could not get applicationInfo from package: ".concat(str));
            } else {
                i11 = applicationInfo.uid;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            Log.e("WorkSourceUtil", "Could not find package: ".concat(str));
        }
        if (i11 < 0) {
            return null;
        }
        WorkSource workSource = new WorkSource();
        Method method2 = zzg;
        if (method2 == null || (method = zzh) == null) {
            add(workSource, i11, str);
        } else {
            try {
                Object invoke = method2.invoke(workSource, new Object[0]);
                int i12 = zza;
                if (i11 != i12) {
                    method.invoke(invoke, new Object[]{Integer.valueOf(i11), str});
                }
                method.invoke(invoke, new Object[]{Integer.valueOf(i12), str2});
            } catch (Exception e11) {
                Log.w("WorkSourceUtil", "Unable to assign chained blame through WorkSource", e11);
            }
        }
        return workSource;
    }

    @KeepForSdk
    public static int get(@NonNull WorkSource workSource, int i11) {
        Method method = zze;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, new Object[]{Integer.valueOf(i11)});
                Preconditions.checkNotNull(invoke);
                return ((Integer) invoke).intValue();
            } catch (Exception e11) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e11);
            }
        }
        return 0;
    }

    @NonNull
    @KeepForSdk
    public static String getName(@NonNull WorkSource workSource, int i11) {
        Method method = zzf;
        if (method == null) {
            return null;
        }
        try {
            return (String) method.invoke(workSource, new Object[]{Integer.valueOf(i11)});
        } catch (Exception e11) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e11);
            return null;
        }
    }

    @NonNull
    @KeepForSdk
    public static List<String> getNames(@NonNull WorkSource workSource) {
        int i11;
        ArrayList arrayList = new ArrayList();
        if (workSource == null) {
            i11 = 0;
        } else {
            i11 = size(workSource);
        }
        if (i11 != 0) {
            for (int i12 = 0; i12 < i11; i12++) {
                String name2 = getName(workSource, i12);
                if (!Strings.isEmptyOrWhitespace(name2)) {
                    Preconditions.checkNotNull(name2);
                    arrayList.add(name2);
                }
            }
        }
        return arrayList;
    }

    @KeepForSdk
    public static synchronized boolean hasWorkSourcePermission(@NonNull Context context) {
        synchronized (WorkSourceUtil.class) {
            Boolean bool = zzj;
            if (bool != null) {
                boolean booleanValue = bool.booleanValue();
                return booleanValue;
            }
            boolean z11 = false;
            if (context == null) {
                return false;
            }
            if (ContextCompat.checkSelfPermission(context, "android.permission.UPDATE_DEVICE_STATS") == 0) {
                z11 = true;
            }
            Boolean valueOf = Boolean.valueOf(z11);
            zzj = valueOf;
            boolean booleanValue2 = valueOf.booleanValue();
            return booleanValue2;
        }
    }

    @KeepForSdk
    public static boolean isEmpty(@NonNull WorkSource workSource) {
        Method method = zzi;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, new Object[0]);
                Preconditions.checkNotNull(invoke);
                return ((Boolean) invoke).booleanValue();
            } catch (Exception e11) {
                Log.e("WorkSourceUtil", "Unable to check WorkSource emptiness", e11);
            }
        }
        if (size(workSource) == 0) {
            return true;
        }
        return false;
    }

    @KeepForSdk
    public static int size(@NonNull WorkSource workSource) {
        Method method = zzd;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, new Object[0]);
                Preconditions.checkNotNull(invoke);
                return ((Integer) invoke).intValue();
            } catch (Exception e11) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e11);
            }
        }
        return 0;
    }
}

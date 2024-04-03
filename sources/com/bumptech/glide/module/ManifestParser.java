package com.bumptech.glide.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

@Deprecated
public final class ManifestParser {
    private static final String GLIDE_MODULE_VALUE = "GlideModule";
    private static final String TAG = "ManifestParser";
    private final Context context;

    public ManifestParser(Context context2) {
        this.context = context2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.bumptech.glide.module.GlideModule parseModule(java.lang.String r3) {
        /*
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ ClassNotFoundException -> 0x0044 }
            r0 = 0
            java.lang.Class[] r1 = new java.lang.Class[r0]     // Catch:{ InstantiationException -> 0x0021, IllegalAccessException -> 0x001c, NoSuchMethodException -> 0x0017, InvocationTargetException -> 0x0012 }
            java.lang.reflect.Constructor r1 = r3.getDeclaredConstructor(r1)     // Catch:{ InstantiationException -> 0x0021, IllegalAccessException -> 0x001c, NoSuchMethodException -> 0x0017, InvocationTargetException -> 0x0012 }
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ InstantiationException -> 0x0021, IllegalAccessException -> 0x001c, NoSuchMethodException -> 0x0017, InvocationTargetException -> 0x0012 }
            java.lang.Object r3 = r1.newInstance(r0)     // Catch:{ InstantiationException -> 0x0021, IllegalAccessException -> 0x001c, NoSuchMethodException -> 0x0017, InvocationTargetException -> 0x0012 }
            goto L_0x0026
        L_0x0012:
            r0 = move-exception
            throwInstantiateGlideModuleException(r3, r0)
            goto L_0x0025
        L_0x0017:
            r0 = move-exception
            throwInstantiateGlideModuleException(r3, r0)
            goto L_0x0025
        L_0x001c:
            r0 = move-exception
            throwInstantiateGlideModuleException(r3, r0)
            goto L_0x0025
        L_0x0021:
            r0 = move-exception
            throwInstantiateGlideModuleException(r3, r0)
        L_0x0025:
            r3 = 0
        L_0x0026:
            boolean r0 = r3 instanceof com.bumptech.glide.module.GlideModule
            if (r0 == 0) goto L_0x002d
            com.bumptech.glide.module.GlideModule r3 = (com.bumptech.glide.module.GlideModule) r3
            return r3
        L_0x002d:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected instanceof GlideModule, but found: "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r0.<init>(r3)
            throw r0
        L_0x0044:
            r3 = move-exception
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Unable to find GlideModule implementation"
            r0.<init>(r1, r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.module.ManifestParser.parseModule(java.lang.String):com.bumptech.glide.module.GlideModule");
    }

    private static void throwInstantiateGlideModuleException(Class<?> cls, Exception exc) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, exc);
    }

    public List<GlideModule> parse() {
        Log.isLoggable(TAG, 3);
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.context.getPackageManager().getApplicationInfo(this.context.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                Log.isLoggable(TAG, 3);
                return arrayList;
            }
            if (Log.isLoggable(TAG, 2)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Got app info metadata: ");
                sb2.append(applicationInfo.metaData);
            }
            for (String next : applicationInfo.metaData.keySet()) {
                if (GLIDE_MODULE_VALUE.equals(applicationInfo.metaData.get(next))) {
                    arrayList.add(parseModule(next));
                    if (Log.isLoggable(TAG, 3)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Loaded Glide module: ");
                        sb3.append(next);
                    }
                }
            }
            Log.isLoggable(TAG, 3);
            return arrayList;
        } catch (PackageManager.NameNotFoundException e11) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e11);
        }
    }
}

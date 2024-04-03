package com.huawei.hms.feature.dynamic;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.common.util.FileUtils;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.feature.dynamic.IDynamicInstall;
import com.huawei.hms.feature.dynamic.IDynamicLoader;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class DynamicModule {
    public static final int MODULE_INTER_ERROR = 3;
    public static final int MODULE_NEED_UPDATE = 2;
    public static final int MODULE_NORMAL = 0;
    public static final int MODULE_NOT_EXIST = 1;
    public static final int MODULE_NOT_PRESET_HSF = 5;
    public static final int MODULE_NOT_READY = 4;
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new com.huawei.hms.feature.dynamic.e.c();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new com.huawei.hms.feature.dynamic.e.e();
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new com.huawei.hms.feature.dynamic.e.d();
    public static final VersionPolicy PREFER_REMOTE = new com.huawei.hms.feature.dynamic.e.e();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f48705a = DynamicModule.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private static final int f48706b = 256;

    /* renamed from: c  reason: collision with root package name */
    private static final int f48707c = -100;

    /* renamed from: d  reason: collision with root package name */
    private static final ThreadLocal<HashMap<String, Boolean>> f48708d = new ThreadLocal<>();

    /* renamed from: e  reason: collision with root package name */
    private static final ThreadLocal<HashMap<String, String>> f48709e = new ThreadLocal<>();

    /* renamed from: f  reason: collision with root package name */
    private static final ThreadLocal<HashMap<String, IDynamicLoader>> f48710f = new ThreadLocal<>();

    /* renamed from: g  reason: collision with root package name */
    private static final ThreadLocal<HashMap<String, ClassLoader>> f48711g = new ThreadLocal<>();

    /* renamed from: h  reason: collision with root package name */
    private static final String f48712h = "com.huawei.hms.min_api_level:dynamic-api:huawei_module_dynamicloader";

    /* renamed from: i  reason: collision with root package name */
    private static final String f48713i = "com.huawei.hms.kit.api_level:huawei_module_dynamicloader";

    /* renamed from: j  reason: collision with root package name */
    private static final int f48714j = -1;

    /* renamed from: k  reason: collision with root package name */
    private static int f48715k = 0;

    /* renamed from: l  reason: collision with root package name */
    private static final int f48716l = 1;

    /* renamed from: m  reason: collision with root package name */
    private static final int f48717m = 2;

    /* renamed from: n  reason: collision with root package name */
    private static int f48718n;

    /* renamed from: o  reason: collision with root package name */
    private static HashMap<String, Boolean> f48719o = new HashMap<>();

    /* renamed from: p  reason: collision with root package name */
    private static HashMap<String, Boolean> f48720p = new HashMap<>();

    /* renamed from: q  reason: collision with root package name */
    private Context f48721q;

    public static class DynamicLoaderClassLoader {

        /* renamed from: a  reason: collision with root package name */
        private static HashMap<String, ClassLoader> f48722a = new HashMap<>();

        public static ClassLoader getsClassLoader(String str) {
            return f48722a.get(str);
        }

        public static void setsClassLoader(String str, ClassLoader classLoader) {
            f48722a.put(str, classLoader);
        }
    }

    public static class LoadingException extends Exception {

        /* renamed from: a  reason: collision with root package name */
        private Bundle f48723a;

        public LoadingException(String str) {
            super(str);
        }

        public LoadingException(String str, Bundle bundle) {
            super(str);
            this.f48723a = bundle;
        }

        public Bundle getBundle() {
            return this.f48723a;
        }
    }

    public interface VersionPolicy {
        Bundle getModuleInfo(Context context, String str) throws LoadingException;
    }

    public class a extends HashMap<String, ClassLoader> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48724a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ClassLoader f48725b;

        public a(String str, ClassLoader classLoader) {
            this.f48724a = str;
            this.f48725b = classLoader;
            put(str, classLoader);
        }
    }

    public class b extends HashMap<String, ClassLoader> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48726a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ClassLoader f48727b;

        public b(String str, ClassLoader classLoader) {
            this.f48726a = str;
            this.f48727b = classLoader;
            put(str, classLoader);
        }
    }

    public class c implements Callable<Bundle> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f48728a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Bundle f48729b;

        public c(Context context, Bundle bundle) {
            this.f48728a = context;
            this.f48729b = bundle;
        }

        /* renamed from: a */
        public Bundle call() {
            try {
                return DynamicModule.queryHMSModuleBundle(this.f48728a, b.f48762e, this.f48729b);
            } catch (Exception e11) {
                Logger.w(DynamicModule.f48705a, "Query provider error.", (Throwable) e11);
                return new Bundle();
            }
        }
    }

    public class d extends HashMap<String, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48730a;

        public d(String str) {
            this.f48730a = str;
            put(str, Boolean.TRUE);
        }
    }

    public class e extends HashMap<String, String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48731a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f48732b;

        public e(String str, String str2) {
            this.f48731a = str;
            this.f48732b = str2;
            put(str, str2);
        }
    }

    public class f extends HashMap<String, IDynamicLoader> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48733a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ IBinder f48734b;

        public f(String str, IBinder iBinder) {
            this.f48733a = str;
            this.f48734b = iBinder;
            put(str, IDynamicLoader.Stub.asInterface(iBinder));
        }
    }

    public static class g extends Exception {
        private g(String str) {
            super(str);
        }

        public /* synthetic */ g(String str, a aVar) {
            this(str);
        }
    }

    private DynamicModule(Context context) {
        this.f48721q = context;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x008c A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0119  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int a(android.content.Context r10, java.lang.String r11, android.os.Bundle r12) throws com.huawei.hms.feature.dynamic.DynamicModule.LoadingException {
        /*
            java.lang.String r0 = "huawei_module_dynamicloader"
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            r2 = 0
            r3 = 0
            android.os.Bundle r1 = queryHMSModuleBundle(r10, r0, r12)     // Catch:{ LoadingException -> 0x0040, Exception -> 0x0022 }
            java.lang.String r4 = "module_version"
            int r4 = r1.getInt(r4)     // Catch:{ LoadingException -> 0x0040, Exception -> 0x0022 }
            java.lang.String r5 = "copy_type"
            int r5 = r1.getInt(r5)     // Catch:{ LoadingException -> 0x0020, Exception -> 0x001e }
            boolean r11 = a((java.lang.String) r11, (int) r5)     // Catch:{ LoadingException -> 0x0020, Exception -> 0x001e }
            goto L_0x007a
        L_0x001e:
            r11 = move-exception
            goto L_0x0024
        L_0x0020:
            r11 = move-exception
            goto L_0x0042
        L_0x0022:
            r11 = move-exception
            r4 = r2
        L_0x0024:
            java.lang.String r5 = f48705a
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Get hms loader info failed:"
            r6.append(r7)
            java.lang.String r11 = r11.getMessage()
            r6.append(r11)
            java.lang.String r11 = r6.toString()
            com.huawei.hms.common.util.Logger.w(r5, r11)
        L_0x003e:
            r11 = r2
            goto L_0x007a
        L_0x0040:
            r11 = move-exception
            r4 = r2
        L_0x0042:
            java.lang.String r3 = f48705a
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Get loader in HMS failed:"
            r5.append(r6)
            java.lang.String r6 = r11.getMessage()
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            com.huawei.hms.common.util.Logger.w(r3, r5)
            android.os.Bundle r3 = r11.getBundle()
            if (r3 == 0) goto L_0x0070
            com.huawei.hms.feature.dynamic.DynamicModule$LoadingException r3 = new com.huawei.hms.feature.dynamic.DynamicModule$LoadingException
            java.lang.String r5 = r11.getMessage()
            android.os.Bundle r11 = r11.getBundle()
            r3.<init>(r5, r11)
            goto L_0x003e
        L_0x0070:
            com.huawei.hms.feature.dynamic.DynamicModule$LoadingException r3 = new com.huawei.hms.feature.dynamic.DynamicModule$LoadingException
            java.lang.String r11 = r11.getMessage()
            r3.<init>(r11)
            goto L_0x003e
        L_0x007a:
            android.os.Bundle r0 = com.huawei.hms.feature.dynamic.AssetLoadManager.getAssetModuleInfo(r10, r0)
            java.lang.String r5 = "local_asset_module_version"
            int r5 = r0.getInt(r5)
            java.lang.String r6 = "module_path"
            java.lang.String r0 = r0.getString(r6)
            if (r4 != 0) goto L_0x0099
            if (r5 != 0) goto L_0x0099
            java.lang.String r10 = f48705a
            java.lang.String r11 = "No available dynamic loader in HMS and asset."
            com.huawei.hms.common.util.Logger.w(r10, r11)
            if (r3 != 0) goto L_0x0098
            return r2
        L_0x0098:
            throw r3
        L_0x0099:
            java.lang.String r7 = f48705a
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "HMS loader version:"
            r8.append(r9)
            r8.append(r4)
            java.lang.String r9 = ", asset loader version:"
            r8.append(r9)
            r8.append(r5)
            java.lang.String r8 = r8.toString()
            com.huawei.hms.common.util.Logger.i(r7, r8)
            r8 = 1
            if (r4 <= r5) goto L_0x00f5
            java.lang.String r9 = "Choose dynamicLoader in HMS."
            com.huawei.hms.common.util.Logger.i(r7, r9)
            if (r11 == 0) goto L_0x00c9
            java.lang.String r11 = "Need to copy HMS dynamicLoader to local dir."
            com.huawei.hms.common.util.Logger.i(r7, r11)
            com.huawei.hms.feature.dynamic.ModuleCopy.copyModule(r10, r1)
        L_0x00c9:
            java.lang.String r11 = r1.getString(r6)
            boolean r1 = android.text.TextUtils.isEmpty(r11)
            if (r1 != 0) goto L_0x00ef
            java.io.File r1 = new java.io.File
            r1.<init>(r11)
            boolean r1 = r1.exists()
            if (r1 == 0) goto L_0x00ef
            boolean r1 = com.huawei.hms.feature.dynamic.ModuleCopy.isLocalModuleFile(r10, r11)
            if (r1 != 0) goto L_0x00ed
            boolean r1 = com.huawei.hms.feature.dynamic.f.c.a(r10, r11)
            if (r1 != 0) goto L_0x00ed
            java.lang.String r11 = "checkPathValidity failed, choose assets loader as default."
            goto L_0x00f1
        L_0x00ed:
            r0 = r11
            goto L_0x0100
        L_0x00ef:
            java.lang.String r11 = "HMS dynamicloader is not available, choose assets loader as default."
        L_0x00f1:
            com.huawei.hms.common.util.Logger.i(r7, r11)
            goto L_0x00fc
        L_0x00f5:
            java.lang.String r11 = "Choose dynamicLoader in asset."
            com.huawei.hms.common.util.Logger.i(r7, r11)
            if (r4 != 0) goto L_0x00ff
        L_0x00fc:
            r4 = r5
            r2 = r8
            goto L_0x0100
        L_0x00ff:
            r4 = r5
        L_0x0100:
            boolean r11 = a((boolean) r2)
            if (r11 == 0) goto L_0x0119
            boolean r10 = a((android.content.Context) r10, (android.os.Bundle) r12, (java.lang.String) r0)
            if (r10 != 0) goto L_0x0119
            java.lang.String r10 = "The apiLeveL version of the loader is lower than the required apiLeveL version."
            com.huawei.hms.common.util.Logger.i(r7, r10)
            if (r3 != 0) goto L_0x0118
            com.huawei.hms.feature.dynamic.DynamicModule$LoadingException r3 = new com.huawei.hms.feature.dynamic.DynamicModule$LoadingException
            r3.<init>(r10)
        L_0x0118:
            throw r3
        L_0x0119:
            java.lang.String r10 = "loader_path"
            r12.putString(r10, r0)
            java.lang.String r10 = "loader_version"
            r12.putInt(r10, r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.feature.dynamic.DynamicModule.a(android.content.Context, java.lang.String, android.os.Bundle):int");
    }

    private static int a(Bundle bundle) {
        if (bundle.containsKey(f48712h)) {
            return bundle.getInt(f48712h, -1);
        }
        return -1;
    }

    private static int a(VersionPolicy versionPolicy) {
        if (versionPolicy instanceof com.huawei.hms.feature.dynamic.e.e) {
            return 1;
        }
        if (versionPolicy instanceof com.huawei.hms.feature.dynamic.e.d) {
            return 2;
        }
        return versionPolicy instanceof com.huawei.hms.feature.dynamic.e.c ? 3 : 0;
    }

    private static Context a(Context context, String str, Bundle bundle, IDynamicLoader iDynamicLoader) throws LoadingException {
        try {
            IObjectWrapper load = iDynamicLoader.load(ObjectWrapper.wrap(context), str, bundle.getInt(b.f48768k), ObjectWrapper.wrap(bundle));
            Object unwrap = ObjectWrapper.unwrap(load);
            if (unwrap == null) {
                String str2 = f48705a;
                Logger.w(str2, "Get remote context is null, module:" + str);
                return null;
            } else if (unwrap instanceof Context) {
                String str3 = f48705a;
                Logger.i(str3, "Get context for module:" + str + " success.");
                return (Context) unwrap;
            } else if (unwrap instanceof Bundle) {
                String str4 = f48705a;
                Logger.i(str4, "Get module info bundle for " + str);
                return a(context, str, bundle, iDynamicLoader, (Bundle) unwrap);
            } else if (!unwrap.getClass().getName().equals(LoadingException.class.getName())) {
                String str5 = f48705a;
                Logger.w(str5, "Get remote context is null, module:" + str);
                return null;
            } else {
                Logger.w(f48705a, "Successfully get the bundle in exception.");
                throw new LoadingException("Failed to load, please check the bundle in exception.", (Bundle) ObjectWrapper.unwrap(load).getClass().getDeclaredMethod("getBundle", new Class[0]).invoke(ObjectWrapper.unwrap(load), new Object[0]));
            }
        } catch (LoadingException e11) {
            throw e11;
        } catch (Exception e12) {
            String str6 = f48705a;
            Logger.w(str6, "Failed to get module context for:" + str, (Throwable) e12);
            return null;
        }
    }

    private static Context a(Context context, String str, Bundle bundle, IDynamicLoader iDynamicLoader, Bundle bundle2) throws LoadingException {
        Object obj;
        bundle.putInt(b.f48780w, 4);
        if (AssetLoadManager.getAssetModuleInfo(context, str).getInt(b.f48770m, 0) > 0) {
            try {
                obj = ObjectWrapper.unwrap(iDynamicLoader.load(ObjectWrapper.wrap(context), str, bundle.getInt(b.f48768k), ObjectWrapper.wrap(bundle)));
            } catch (RemoteException e11) {
                Logger.w(f48705a, "tryWithAssetsModule RemoteException.", (Throwable) e11);
                obj = null;
            }
            if (obj instanceof Context) {
                String str2 = f48705a;
                Logger.i(str2, "get dynamic module context for:" + str + " from assets fallback success.");
                return (Context) obj;
            }
            Logger.w(f48705a, "tryWithAssetsModule get dynamicContext failed: null or wrong type.");
            throw new LoadingException("Load exception, please check the bundle in exception.", bundle2);
        }
        Logger.i(f48705a, "No fallback module in assets.");
        throw new LoadingException("Load exception, please check the bundle in exception.", bundle2);
    }

    private static Bundle a(Context context, Bundle bundle) throws g {
        try {
            ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
            FutureTask futureTask = new FutureTask(new c(context, bundle));
            newSingleThreadExecutor.execute(futureTask);
            Bundle bundle2 = (Bundle) futureTask.get((long) f48718n, TimeUnit.MILLISECONDS);
            String string = bundle2.getString(b.f48775r);
            if (TextUtils.isEmpty(string) || !new File(string).exists()) {
                String str = f48705a;
                Logger.w(str, "The loader_path:" + string + " is not available.");
                throw new g("The loader_path in queryBundle is empty or not exist.", (a) null);
            }
            Logger.i(f48705a, "Query HMS module:huawei_module_dynamicloader info success.");
            return bundle2;
        } catch (TimeoutException unused) {
            String str2 = f48705a;
            Logger.w(str2, "Query hms provider timeout: over " + f48718n + " ms, choose the local loader fallback.");
            return new Bundle();
        } catch (Exception e11) {
            Logger.w(f48705a, "FutureTask: query provider exception.", (Throwable) e11);
            throw new g("failed to get :huawei_module_dynamicloader info.", (a) null);
        }
    }

    private static DynamicModule a(Context context, String str, VersionPolicy versionPolicy) throws LoadingException {
        Bundle moduleInfo = versionPolicy.getModuleInfo(context, str);
        if (moduleInfo.getInt(b.f48768k) > 0) {
            try {
                return c(context, str, moduleInfo);
            } catch (LoadingException e11) {
                Logger.w(f48705a, "Failed to load remote module.", (Throwable) e11);
                if (getLocalVersion(context, str) > 0) {
                    Logger.d(f48705a, "Local module version is valid, use local fallback.");
                    return new DynamicModule(context.getApplicationContext());
                }
                throw e11;
            }
        } else if (moduleInfo.getInt(b.f48769l) > 0) {
            Logger.i(f48705a, "Remote version is invalid, use local context.");
            return new DynamicModule(context.getApplicationContext());
        } else {
            throw new LoadingException("Query remote version and local version failed.");
        }
    }

    private static DynamicModule a(Context context, String str, VersionPolicy versionPolicy, Bundle bundle) throws LoadingException {
        int a11 = a(versionPolicy);
        String string = bundle.getString(b.f48775r);
        String str2 = f48705a;
        Logger.i(str2, "The loader path for module:" + str + " is:" + string + ", and versionType is:" + a11);
        if (!ModuleCopy.isPathInvalid(string)) {
            File file = new File(string);
            if (file.exists()) {
                if (ModuleCopy.isLocalModuleFile(context, string) && !FileUtils.a(file)) {
                    Logger.w(str2, "To set loader readOnly, isReadOnly: false.");
                }
                Boolean bool = f48720p.get(str);
                Boolean bool2 = f48719o.get(str);
                bundle.putString("module_name", str);
                bundle.putInt(b.f48780w, a11);
                boolean z11 = false;
                bundle.putBoolean(b.f48781x, bool != null ? bool.booleanValue() : false);
                if (bool2 != null) {
                    z11 = bool2.booleanValue();
                }
                bundle.putBoolean(b.f48782y, z11);
                try {
                    return b(context, str, bundle);
                } catch (LoadingException e11) {
                    throw e11;
                } catch (Exception e12) {
                    Logger.e(f48705a, "Other exception,", (Throwable) e12);
                    if (context.getApplicationContext() != null) {
                        context = context.getApplicationContext();
                    }
                    return new DynamicModule(context);
                }
            } else {
                throw new LoadingException("dynamic loader does not exist.");
            }
        } else {
            throw new LoadingException("Cannot find a valid dynamic loader in HMS or local.");
        }
    }

    private static IDynamicInstall a(Context context, String str) throws LoadingException {
        if (str != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (com.huawei.hms.feature.dynamic.f.c.a(context, str)) {
                        return IDynamicInstall.Stub.asInterface((IBinder) new com.huawei.hms.feature.dynamic.e.a(str, ClassLoader.getSystemClassLoader()).loadClass(b.f48764g).getConstructor(new Class[0]).newInstance(new Object[0]));
                    }
                    Logger.w(f48705a, "check path failed: invalid.");
                    throw new LoadingException("getHMSDynamicInstaller: checkPathValidity failed.");
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e11) {
                throw new LoadingException("getHMSDynamicInstaller: failed to instantiate dynamic loader:" + e11.getMessage());
            }
        }
        throw new LoadingException("Failed to get dynamicLoader path.");
    }

    private static IDynamicLoader a(Context context, String str, String str2, ClassLoader classLoader) {
        if (classLoader == null) {
            try {
                classLoader = new com.huawei.hms.feature.dynamic.e.a(str2, ClassLoader.getSystemClassLoader());
                f48711g.set(new b(str, classLoader));
            } catch (Exception e11) {
                Logger.w(f48705a, "Get iDynamicLoader failed.", (Throwable) e11);
                return null;
            }
        }
        return IDynamicLoader.Stub.asInterface((IBinder) classLoader.loadClass(b.f48763f).getConstructor(new Class[0]).newInstance(new Object[0]));
    }

    private static Class<?> a(Context context) throws LoadingException {
        Class<?> cls;
        Class<DynamicLoaderClassLoader> cls2 = DynamicLoaderClassLoader.class;
        try {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            cls = context.getClassLoader().loadClass(cls2.getName());
        } catch (ClassNotFoundException unused) {
            Logger.w(f48705a, "ClassLoader class not found when use client context.");
            cls = null;
        }
        if (cls == null) {
            try {
                ClassLoader classLoader = DynamicModule.class.getClassLoader();
                Objects.requireNonNull(classLoader);
                cls = classLoader.loadClass(cls2.getName());
                if (cls == null) {
                    throw new LoadingException("ClassLoader class is null.");
                }
            } catch (ClassNotFoundException unused2) {
                throw new LoadingException("ClassLoader class not found when use DynamicModule's classLoader.");
            }
        }
        return cls;
    }

    private static void a(Context context, VersionPolicy versionPolicy, String str, Bundle bundle) throws LoadingException {
        boolean z11 = false;
        if (((context == null || versionPolicy == null || str == null) || str.length() == 0 || str.length() > 256) || bundle == null) {
            z11 = true;
        }
        if (z11) {
            throw new LoadingException("Null param, please check it.");
        }
    }

    private static void a(String str, ClassLoader classLoader) throws LoadingException {
        try {
            f48710f.set(new f(str, (IBinder) classLoader.loadClass(b.f48763f).getConstructor(new Class[0]).newInstance(new Object[0])));
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e11) {
            throw new LoadingException("Failed to get loader interface:" + e11.getMessage());
        }
    }

    private static boolean a(Context context, Bundle bundle, String str) {
        int c11 = c(context, str);
        int a11 = a(bundle);
        if (a11 == -1) {
            a11 = c(context);
        }
        String str2 = f48705a;
        Logger.i(str2, "Required api_level: " + a11 + ",  dynamicloader api_level : " + c11);
        return a11 <= c11 && a11 != -1;
    }

    private static boolean a(String str, int i11) {
        String str2 = f48705a;
        Logger.i(str2, "copyType: " + i11);
        if (i11 == 1) {
            Boolean bool = f48720p.get(str);
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        } else if (i11 != 2) {
            return i11 == 3 || i11 == 4;
        } else {
            Boolean bool2 = f48719o.get(str);
            if (bool2 != null) {
                return bool2.booleanValue();
            }
            return false;
        }
    }

    private static boolean a(boolean z11) {
        return Build.VERSION.SDK_INT >= 34 && z11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0043, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
        com.huawei.hms.common.util.Logger.w(f48705a, "Get loader interface failed.", (java.lang.Throwable) r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0079, code lost:
        if (com.huawei.hms.feature.dynamic.f.c.a(r10, r8) == false) goto L_0x009b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007b, code lost:
        r10 = new com.huawei.hms.feature.dynamic.e.a(r8, java.lang.ClassLoader.getSystemClassLoader());
        a(r11, (java.lang.ClassLoader) r10);
        r1.invoke((java.lang.Object) null, new java.lang.Object[]{r11, r10});
        f48708d.set(new com.huawei.hms.feature.dynamic.DynamicModule.d(r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009a, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x009b, code lost:
        com.huawei.hms.common.util.Logger.w(r2, "The loaderPath is invalid.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a7, code lost:
        throw new com.huawei.hms.feature.dynamic.DynamicModule.LoadingException("getHMSModuleInfo: checkPathValidity failed.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ab, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ac, code lost:
        com.huawei.hms.common.util.Logger.w(f48705a, "failed to load.", (java.lang.Throwable) r10);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ab A[ExcHandler: Exception (r10v4 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:1:0x0001] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.os.Bundle b(android.content.Context r10, java.lang.String r11) throws com.huawei.hms.feature.dynamic.DynamicModule.LoadingException {
        /*
            r0 = 0
            java.lang.Class r1 = a((android.content.Context) r10)     // Catch:{ LoadingException -> 0x00ca, Exception -> 0x00ab }
            java.lang.String r2 = "getsClassLoader"
            r3 = 1
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch:{ LoadingException -> 0x00ca, Exception -> 0x00ab }
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r4[r0] = r5     // Catch:{ LoadingException -> 0x00ca, Exception -> 0x00ab }
            java.lang.reflect.Method r2 = r1.getDeclaredMethod(r2, r4)     // Catch:{ LoadingException -> 0x00ca, Exception -> 0x00ab }
            java.lang.String r4 = "setsClassLoader"
            r5 = 2
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch:{ LoadingException -> 0x00ca, Exception -> 0x00ab }
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r6[r0] = r7     // Catch:{ LoadingException -> 0x00ca, Exception -> 0x00ab }
            java.lang.Class<java.lang.ClassLoader> r7 = java.lang.ClassLoader.class
            r6[r3] = r7     // Catch:{ LoadingException -> 0x00ca, Exception -> 0x00ab }
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r4, r6)     // Catch:{ LoadingException -> 0x00ca, Exception -> 0x00ab }
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ LoadingException -> 0x00ca, Exception -> 0x00ab }
            r4[r0] = r11     // Catch:{ LoadingException -> 0x00ca, Exception -> 0x00ab }
            r6 = 0
            java.lang.Object r2 = r2.invoke(r6, r4)     // Catch:{ LoadingException -> 0x00ca, Exception -> 0x00ab }
            java.lang.ClassLoader r2 = (java.lang.ClassLoader) r2     // Catch:{ LoadingException -> 0x00ca, Exception -> 0x00ab }
            if (r2 == 0) goto L_0x004d
            java.lang.ClassLoader r10 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x00ca, Exception -> 0x00ab }
            if (r2 != r10) goto L_0x0038
            goto L_0x00b3
        L_0x0038:
            java.lang.String r10 = f48705a     // Catch:{ LoadingException -> 0x00ca, Exception -> 0x00ab }
            java.lang.String r1 = "Cached loader is available, ready to use it."
            com.huawei.hms.common.util.Logger.i(r10, r1)     // Catch:{ LoadingException -> 0x00ca, Exception -> 0x00ab }
            a((java.lang.String) r11, (java.lang.ClassLoader) r2)     // Catch:{ LoadingException -> 0x0043, Exception -> 0x00ab }
            goto L_0x004b
        L_0x0043:
            r10 = move-exception
            java.lang.String r1 = f48705a     // Catch:{ LoadingException -> 0x00ca, Exception -> 0x00ab }
            java.lang.String r2 = "Get loader interface failed."
            com.huawei.hms.common.util.Logger.w((java.lang.String) r1, (java.lang.String) r2, (java.lang.Throwable) r10)     // Catch:{ LoadingException -> 0x00ca, Exception -> 0x00ab }
        L_0x004b:
            r0 = r3
            goto L_0x00b3
        L_0x004d:
            java.lang.String r2 = f48705a     // Catch:{ g -> 0x00b3 }
            java.lang.String r4 = "No available cached loader, query remote."
            com.huawei.hms.common.util.Logger.i(r2, r4)     // Catch:{ g -> 0x00b3 }
            android.os.Bundle r4 = d(r10, r11)     // Catch:{ g -> 0x00b3 }
            java.lang.Class<com.huawei.hms.feature.dynamic.DynamicModule> r7 = com.huawei.hms.feature.dynamic.DynamicModule.class
            monitor-enter(r7)     // Catch:{ g -> 0x00b3 }
            java.lang.ThreadLocal<java.util.HashMap<java.lang.String, java.lang.String>> r8 = f48709e     // Catch:{ all -> 0x00a8 }
            java.lang.Object r8 = r8.get()     // Catch:{ all -> 0x00a8 }
            java.util.HashMap r8 = (java.util.HashMap) r8     // Catch:{ all -> 0x00a8 }
            java.util.Objects.requireNonNull(r8)     // Catch:{ all -> 0x00a8 }
            java.lang.Object r8 = r8.get(r11)     // Catch:{ all -> 0x00a8 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x00a8 }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ all -> 0x00a8 }
            if (r9 == 0) goto L_0x0074
            monitor-exit(r7)     // Catch:{ all -> 0x00a8 }
            return r4
        L_0x0074:
            monitor-exit(r7)     // Catch:{ all -> 0x00a8 }
            boolean r10 = com.huawei.hms.feature.dynamic.f.c.a(r10, r8)     // Catch:{ g -> 0x00b3 }
            if (r10 == 0) goto L_0x009b
            com.huawei.hms.feature.dynamic.e.a r10 = new com.huawei.hms.feature.dynamic.e.a     // Catch:{ g -> 0x00b3 }
            java.lang.ClassLoader r2 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ g -> 0x00b3 }
            r10.<init>(r8, r2)     // Catch:{ g -> 0x00b3 }
            a((java.lang.String) r11, (java.lang.ClassLoader) r10)     // Catch:{ g -> 0x00b3 }
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ g -> 0x00b3 }
            r2[r0] = r11     // Catch:{ g -> 0x00b3 }
            r2[r3] = r10     // Catch:{ g -> 0x00b3 }
            r1.invoke(r6, r2)     // Catch:{ g -> 0x00b3 }
            java.lang.ThreadLocal<java.util.HashMap<java.lang.String, java.lang.Boolean>> r10 = f48708d     // Catch:{ g -> 0x00b3 }
            com.huawei.hms.feature.dynamic.DynamicModule$d r1 = new com.huawei.hms.feature.dynamic.DynamicModule$d     // Catch:{ g -> 0x00b3 }
            r1.<init>(r11)     // Catch:{ g -> 0x00b3 }
            r10.set(r1)     // Catch:{ g -> 0x00b3 }
            return r4
        L_0x009b:
            java.lang.String r10 = "The loaderPath is invalid."
            com.huawei.hms.common.util.Logger.w(r2, r10)     // Catch:{ g -> 0x00b3 }
            com.huawei.hms.feature.dynamic.DynamicModule$LoadingException r10 = new com.huawei.hms.feature.dynamic.DynamicModule$LoadingException     // Catch:{ g -> 0x00b3 }
            java.lang.String r1 = "getHMSModuleInfo: checkPathValidity failed."
            r10.<init>(r1)     // Catch:{ g -> 0x00b3 }
            throw r10     // Catch:{ g -> 0x00b3 }
        L_0x00a8:
            r10 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x00a8 }
            throw r10     // Catch:{ g -> 0x00b3 }
        L_0x00ab:
            r10 = move-exception
            java.lang.String r1 = f48705a
            java.lang.String r2 = "failed to load."
            com.huawei.hms.common.util.Logger.w((java.lang.String) r1, (java.lang.String) r2, (java.lang.Throwable) r10)
        L_0x00b3:
            java.util.HashMap r10 = new java.util.HashMap
            r10.<init>()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r10.put(r11, r0)
            java.lang.ThreadLocal<java.util.HashMap<java.lang.String, java.lang.Boolean>> r11 = f48708d
            r11.set(r10)
            android.os.Bundle r10 = new android.os.Bundle
            r10.<init>()
            return r10
        L_0x00ca:
            r10 = move-exception
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.feature.dynamic.DynamicModule.b(android.content.Context, java.lang.String):android.os.Bundle");
    }

    private static DynamicModule b(Context context, VersionPolicy versionPolicy, String str, Bundle bundle) throws LoadingException {
        String str2 = f48705a;
        Logger.i(str2, "dynamic-api version: 10025300");
        a(context, versionPolicy, str, bundle);
        try {
            int a11 = a(context, str, bundle);
            if (a11 >= 10015300) {
                Logger.i(str2, "Load start in new-version-policy.");
                return a(context, str, versionPolicy, bundle);
            } else if (a11 > 0) {
                Logger.i(str2, "Load start in old-version-policy.");
                return a(context, str, versionPolicy);
            } else {
                throw new LoadingException("Cannot find a valid dynamicLoader in HMS and local.");
            }
        } catch (LoadingException e11) {
            throw e11;
        } catch (Exception e12) {
            String str3 = f48705a;
            Logger.e(str3, "Other exception:" + e12);
            throw new LoadingException("Load failed.");
        }
    }

    private static DynamicModule b(Context context, String str, Bundle bundle) throws LoadingException {
        ClassLoader classLoader;
        synchronized (DynamicModule.class) {
            ThreadLocal<HashMap<String, ClassLoader>> threadLocal = f48711g;
            if (threadLocal.get() != null) {
                if (threadLocal.get().get(str) != null) {
                    Logger.i(f48705a, "Cached loader for module is available, ready to use it.");
                    classLoader = (ClassLoader) threadLocal.get().get(str);
                }
            }
            String str2 = f48705a;
            Logger.i(str2, "No available cached loader for module:" + str);
            classLoader = null;
        }
        IDynamicLoader a11 = a(context, str, bundle.getString(b.f48775r), classLoader);
        if (a11 != null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            Context a12 = a(context, str, bundle, a11);
            if (a12 != null) {
                return new DynamicModule(a12);
            }
            throw new LoadingException("New version policy: Failed to get module context: null.");
        }
        throw new LoadingException("Failed to get iDynamicLoader: null.");
    }

    private static IDynamicInstall b(Context context) throws LoadingException {
        int i11;
        String str = null;
        int i12 = 0;
        try {
            Bundle a11 = a(context, (Bundle) null);
            str = a11.getString(b.f48775r);
            i11 = a11.getInt(b.f48774q);
        } catch (Exception e11) {
            Logger.w(f48705a, "Cannot get remote HMS dynamicLoader.", (Throwable) e11);
            i11 = 0;
        }
        try {
            i12 = getLocalVersion(context, b.f48762e);
        } catch (Exception e12) {
            Logger.w(f48705a, "Cannot find local dynamicLoader fallback.", (Throwable) e12);
        }
        String str2 = f48705a;
        Logger.i(str2, "DynamicLoader remoteHMSVersion:" + i11 + ", hmsLoaderPath:" + str + ", localLoaderVersion:" + i12);
        int max = Math.max(i11, i12);
        if (max <= 10009300) {
            Logger.w(str2, "The current version:" + max + " is too low.");
            throw new LoadingException("The loader version:" + max + " is too low to support HFF.");
        } else if (i11 > i12) {
            Logger.i(str2, "Choose hms dynamicLoader: " + str);
            f48715k = 1;
            return a(context, str);
        } else {
            Logger.i(str2, "Choose local dynamicLoader fallback: ");
            f48715k = 2;
            return d(context);
        }
    }

    private static int c(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                Bundle bundle = applicationInfo.metaData;
                if (bundle != null) {
                    return bundle.getInt(f48712h, -1);
                }
            }
            Logger.w(f48705a, "applicationInfo or metaData is null.");
            return -1;
        } catch (Throwable unused) {
            Logger.w(f48705a, "failed to getLoaderMinApiLevel.");
            return -1;
        }
    }

    private static int c(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 128);
            if (!(packageArchiveInfo == null || (applicationInfo = packageArchiveInfo.applicationInfo) == null)) {
                Bundle bundle = applicationInfo.metaData;
                if (bundle != null) {
                    return bundle.getInt(f48713i, -1);
                }
            }
            Logger.w(f48705a, "packageInfo or applicationInfo or metaData is null.");
            return -1;
        } catch (Throwable th2) {
            String str2 = f48705a;
            Logger.w(str2, "failed to getLoaderApiLevel: " + th2.getMessage());
            return -1;
        }
    }

    private static DynamicModule c(Context context, String str, Bundle bundle) throws LoadingException {
        Boolean bool;
        IDynamicLoader iDynamicLoader;
        try {
            synchronized (DynamicModule.class) {
                HashMap hashMap = f48708d.get();
                Objects.requireNonNull(hashMap);
                bool = (Boolean) hashMap.get(str);
                HashMap hashMap2 = f48710f.get();
                Objects.requireNonNull(hashMap2);
                iDynamicLoader = (IDynamicLoader) hashMap2.get(str);
            }
            if (bool == null || iDynamicLoader == null) {
                throw new LoadingException("The loader for " + str + " was not prepared.");
            }
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            Context a11 = a(context, str, bundle, iDynamicLoader);
            if (a11 != null) {
                return new DynamicModule(a11);
            }
            throw new LoadingException("Failed to get remote module context: null");
        } catch (LoadingException e11) {
            throw e11;
        } catch (Exception unused) {
            throw new LoadingException("Load Module Error.");
        }
    }

    private static Bundle d(Context context, String str) throws LoadingException, g {
        try {
            Bundle queryHMSModuleBundle = queryHMSModuleBundle(context, str);
            String string = queryHMSModuleBundle.getString(b.f48775r);
            if (!TextUtils.isEmpty(string)) {
                if (new File(string).exists()) {
                    f48709e.set(new e(str, string));
                    String str2 = f48705a;
                    Logger.i(str2, "Query remote version by module name:" + str + " success.");
                    return queryHMSModuleBundle;
                }
            }
            String str3 = f48705a;
            Logger.w(str3, "The loader_path:" + string + " in query bundle is not available,change the module version to:" + -100);
            queryHMSModuleBundle.putInt(b.f48768k, -100);
            return queryHMSModuleBundle;
        } catch (LoadingException e11) {
            throw e11;
        } catch (Exception unused) {
            throw new g("failed to Query remote version.", (a) null);
        }
    }

    private static IDynamicInstall d(Context context) throws LoadingException {
        try {
            return (IDynamicInstall) context.getClassLoader().loadClass(b.f48764g).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e11) {
            throw new LoadingException("getLocalLoaderFallback: failed to instantiate dynamic loader: " + e11.getMessage());
        }
    }

    public static void enable3rdPhone(String str, boolean z11) {
        f48719o.put(str, Boolean.valueOf(z11));
    }

    public static void enableLowEMUI(String str, boolean z11) {
        f48720p.put(str, Boolean.valueOf(z11));
    }

    public static Set<String> getInstalledModuleInfo() {
        return d.a().f48791c;
    }

    public static Bundle getLocalModuleInfo(Context context, String str) {
        int localVersion = getLocalVersion(context, str);
        Bundle bundle = new Bundle();
        bundle.putString("module_name", str);
        bundle.putInt(b.f48769l, localVersion);
        return bundle;
    }

    public static int getLocalVersion(Context context, String str) {
        if (context == null || str.length() == 0 || str.length() > 256) {
            Logger.e(f48705a, "Invalid context or moduleName.");
            return 0;
        }
        try {
            String str2 = "com.huawei.hms.feature.dynamic.descriptors." + str + ".ModuleDescriptor";
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            return context.getClassLoader().loadClass(str2).getDeclaredField("MODULE_VERSION").getInt((Object) null);
        } catch (ClassNotFoundException unused) {
            Logger.w(f48705a, "Cannot find the class of module descriptor for " + str);
            return 0;
        } catch (Exception e11) {
            Logger.w(f48705a, "Get local module info failed.", (Throwable) e11);
            return 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0048, code lost:
        if (((java.lang.Boolean) r1.get().get(r5)).booleanValue() == false) goto L_0x0077;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004e, code lost:
        return d(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004f, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        com.huawei.hms.common.util.Logger.w(f48705a, "Query remote module info in HMS failed.", (java.lang.Throwable) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007c, code lost:
        return new android.os.Bundle();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.os.Bundle getRemoteModuleInfo(android.content.Context r4, java.lang.String r5) throws com.huawei.hms.feature.dynamic.DynamicModule.LoadingException {
        /*
            java.lang.Class<com.huawei.hms.feature.dynamic.DynamicModule> r0 = com.huawei.hms.feature.dynamic.DynamicModule.class
            monitor-enter(r0)     // Catch:{ LoadingException -> 0x007d, Exception -> 0x005b }
            java.lang.ThreadLocal<java.util.HashMap<java.lang.String, java.lang.Boolean>> r1 = f48708d     // Catch:{ all -> 0x0058 }
            java.lang.Object r2 = r1.get()     // Catch:{ all -> 0x0058 }
            if (r2 == 0) goto L_0x0029
            java.lang.Object r2 = r1.get()     // Catch:{ all -> 0x0058 }
            java.util.HashMap r2 = (java.util.HashMap) r2     // Catch:{ all -> 0x0058 }
            java.lang.Object r2 = r2.get(r5)     // Catch:{ all -> 0x0058 }
            if (r2 == 0) goto L_0x0029
            java.lang.Object r2 = r1.get()     // Catch:{ all -> 0x0058 }
            java.util.HashMap r2 = (java.util.HashMap) r2     // Catch:{ all -> 0x0058 }
            java.lang.Object r2 = r2.get(r5)     // Catch:{ all -> 0x0058 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x0058 }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x0058 }
            if (r2 != 0) goto L_0x0037
        L_0x0029:
            android.os.Bundle r2 = b(r4, r5)     // Catch:{ all -> 0x0058 }
            java.lang.String r3 = "module_version"
            int r3 = r2.getInt(r3)     // Catch:{ all -> 0x0058 }
            if (r3 <= 0) goto L_0x0037
            monitor-exit(r0)     // Catch:{ all -> 0x0058 }
            return r2
        L_0x0037:
            monitor-exit(r0)     // Catch:{ all -> 0x0058 }
            java.lang.Object r0 = r1.get()     // Catch:{ LoadingException -> 0x007d, Exception -> 0x005b }
            java.util.HashMap r0 = (java.util.HashMap) r0     // Catch:{ LoadingException -> 0x007d, Exception -> 0x005b }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ LoadingException -> 0x007d, Exception -> 0x005b }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ LoadingException -> 0x007d, Exception -> 0x005b }
            boolean r0 = r0.booleanValue()     // Catch:{ LoadingException -> 0x007d, Exception -> 0x005b }
            if (r0 == 0) goto L_0x0077
            android.os.Bundle r4 = d(r4, r5)     // Catch:{ g -> 0x004f }
            return r4
        L_0x004f:
            r4 = move-exception
            java.lang.String r0 = f48705a     // Catch:{ LoadingException -> 0x007d, Exception -> 0x005b }
            java.lang.String r1 = "Query remote module info in HMS failed."
            com.huawei.hms.common.util.Logger.w((java.lang.String) r0, (java.lang.String) r1, (java.lang.Throwable) r4)     // Catch:{ LoadingException -> 0x007d, Exception -> 0x005b }
            goto L_0x0077
        L_0x0058:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0058 }
            throw r4     // Catch:{ LoadingException -> 0x007d, Exception -> 0x005b }
        L_0x005b:
            r4 = move-exception
            java.lang.String r0 = f48705a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Get remote module info for "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = " failed."
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            com.huawei.hms.common.util.Logger.w((java.lang.String) r0, (java.lang.String) r5, (java.lang.Throwable) r4)
        L_0x0077:
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>()
            return r4
        L_0x007d:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.feature.dynamic.DynamicModule.getRemoteModuleInfo(android.content.Context, java.lang.String):android.os.Bundle");
    }

    public static int getRemoteVersion(Context context, String str) throws LoadingException {
        try {
            Bundle d11 = d(context, str);
            if (d11 != null && !d11.isEmpty()) {
                return d11.getInt(b.f48768k);
            }
            String str2 = f48705a;
            Logger.w(str2, "Query remote module:" + str + " info failed.");
            throw new LoadingException("Query remote module info failed: null or empty.");
        } catch (g e11) {
            String str3 = f48705a;
            Logger.w(str3, "Query remote module:" + str + " exception:" + e11);
            return 0;
        }
    }

    public static void install(Context context, int i11) {
        String str = f48705a;
        Logger.i(str, "dynamic-api version: 10025300");
        if (context == null) {
            Logger.e(str, "The input context is null.");
            return;
        }
        try {
            f48718n = i11;
            Logger.i(str, "Query HMS provider timeOut is set to:" + f48718n + " ms.");
            IDynamicInstall b11 = b(context);
            if (b11 != null) {
                Bundle install = b11.install(ObjectWrapper.wrap(context), new Bundle());
                if (install != null) {
                    d.a().a(install);
                    Logger.i(str, "Install module success.");
                    return;
                }
                throw new LoadingException("Get install info failed: moduleBundle is null.");
            }
            throw new LoadingException("Get dynamicInstaller failed.");
        } catch (RemoteException | LoadingException | NullPointerException e11) {
            if (f48715k == 2 || getLocalVersion(context, b.f48762e) <= 0) {
                Logger.w(f48705a, "Install module failed.", e11);
                return;
            }
            String str2 = f48705a;
            Logger.i(str2, "Ready to use local loader-fallback to retry:");
            Bundle install2 = d(context).install(ObjectWrapper.wrap(context), new Bundle());
            if (install2 != null) {
                d.a().a(install2);
                Logger.i(str2, "Retry install module with local loader-fallback success.");
                return;
            }
            throw new LoadingException("Retry: get install info failed: moduleBundle is null.");
        } catch (RemoteException | LoadingException | NullPointerException e12) {
            Logger.w(f48705a, "Retry failed with local loader-fallback.", e12);
        }
    }

    public static DynamicModule load(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        return b(context, versionPolicy, str, new Bundle());
    }

    public static DynamicModule loadV2(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        Bundle bundle = new Bundle();
        bundle.putString(b.f48776s, b.f48777t);
        return b(context, versionPolicy, str, bundle);
    }

    public static DynamicModule loadV3(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        return loadV3(context, versionPolicy, str, new Bundle());
    }

    public static DynamicModule loadV3(Context context, VersionPolicy versionPolicy, String str, Bundle bundle) throws LoadingException {
        bundle.putString(b.f48776s, "v3");
        return b(context, versionPolicy, str, bundle);
    }

    public static Bundle queryHMSModuleBundle(Context context, String str) throws LoadingException, g {
        return queryHMSModuleBundle(context, str, (Bundle) null);
    }

    public static Bundle queryHMSModuleBundle(Context context, String str, Bundle bundle) throws LoadingException, g {
        try {
            if (com.huawei.hms.feature.dynamic.f.c.a(context)) {
                ContentResolver contentResolver = context.getContentResolver();
                if (contentResolver != null) {
                    Bundle call = contentResolver.call(Uri.parse(b.f48758a), str, (String) null, bundle);
                    if (call != null) {
                        int i11 = call.getInt(b.f48765h);
                        String string = call.getString(b.f48775r);
                        String str2 = f48705a;
                        Logger.i(str2, "bundle info: errorCode:" + i11 + ", moduleVersion:" + call.getInt(b.f48768k) + ", modulePath:" + call.getString(b.f48771n) + ", loader_version:" + call.getInt(b.f48774q) + ", loaderPath:" + string + ", armeabiType:" + call.getInt(b.f48779v));
                        if (i11 == 0) {
                            return call;
                        }
                        Logger.w(str2, "Failed to get " + str + " bundle info, errcode:" + i11);
                        throw new LoadingException("Query " + str + " unavailable, errorCode:" + i11, call);
                    }
                    Logger.w(f48705a, "Failed to get bundle info:null.");
                    throw new g("Query remote version failed: null bundle info.", (a) null);
                }
                throw new g("Query remote version failed: null contentResolver.", (a) null);
            }
            Logger.w(f48705a, "No valid HMS Core in this device.");
            throw new g("HMS Core is not installed.", (a) null);
        } catch (LoadingException e11) {
            throw e11;
        } catch (Exception unused) {
            throw new g("failed to get :" + str + " info from HMS Core.", (a) null);
        }
    }

    public final Context getModuleContext() {
        return this.f48721q;
    }
}

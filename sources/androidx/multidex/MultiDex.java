package androidx.multidex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.zip.ZipFile;

public final class MultiDex {
    private static final String CODE_CACHE_NAME = "code_cache";
    private static final String CODE_CACHE_SECONDARY_FOLDER_NAME = "secondary-dexes";
    private static final boolean IS_VM_MULTIDEX_CAPABLE = d(System.getProperty("java.vm.version"));
    private static final int MAX_SUPPORTED_SDK_VERSION = 20;
    private static final int MIN_SDK_VERSION = 4;
    private static final String NO_KEY_PREFIX = "";
    private static final String OLD_SECONDARY_FOLDER_NAME = "secondary-dexes";
    private static final int VM_WITH_MULTIDEX_VERSION_MAJOR = 2;
    private static final int VM_WITH_MULTIDEX_VERSION_MINOR = 1;

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f36294a = 0;
    private static final Set<File> installedApk = new HashSet();

    public static final class V14 {
        private static final int EXTRACTED_SUFFIX_LENGTH = 4;
        private final ElementConstructor elementConstructor;

        public interface ElementConstructor {
            Object newInstance(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException;
        }

        public static class ICSElementConstructor implements ElementConstructor {
            private final Constructor<?> elementConstructor;

            public ICSElementConstructor(Class<?> cls) throws SecurityException, NoSuchMethodException {
                Constructor<?> constructor = cls.getConstructor(new Class[]{File.class, ZipFile.class, DexFile.class});
                this.elementConstructor = constructor;
                constructor.setAccessible(true);
            }

            public Object newInstance(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException {
                return this.elementConstructor.newInstance(new Object[]{file, new ZipFile(file), dexFile});
            }
        }

        public static class JBMR11ElementConstructor implements ElementConstructor {
            private final Constructor<?> elementConstructor;

            public JBMR11ElementConstructor(Class<?> cls) throws SecurityException, NoSuchMethodException {
                Class<File> cls2 = File.class;
                Constructor<?> constructor = cls.getConstructor(new Class[]{cls2, cls2, DexFile.class});
                this.elementConstructor = constructor;
                constructor.setAccessible(true);
            }

            public Object newInstance(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
                return this.elementConstructor.newInstance(new Object[]{file, file, dexFile});
            }
        }

        public static class JBMR2ElementConstructor implements ElementConstructor {
            private final Constructor<?> elementConstructor;

            public JBMR2ElementConstructor(Class<?> cls) throws SecurityException, NoSuchMethodException {
                Class<File> cls2 = File.class;
                Constructor<?> constructor = cls.getConstructor(new Class[]{cls2, Boolean.TYPE, cls2, DexFile.class});
                this.elementConstructor = constructor;
                constructor.setAccessible(true);
            }

            public Object newInstance(File file, DexFile dexFile) throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
                return this.elementConstructor.newInstance(new Object[]{file, Boolean.FALSE, file, dexFile});
            }
        }

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private V14() throws java.lang.ClassNotFoundException, java.lang.SecurityException, java.lang.NoSuchMethodException {
            /*
                r2 = this;
                r2.<init>()
                java.lang.String r0 = "dalvik.system.DexPathList$Element"
                java.lang.Class r0 = java.lang.Class.forName(r0)
                androidx.multidex.MultiDex$V14$ICSElementConstructor r1 = new androidx.multidex.MultiDex$V14$ICSElementConstructor     // Catch:{ NoSuchMethodException -> 0x000f }
                r1.<init>(r0)     // Catch:{ NoSuchMethodException -> 0x000f }
                goto L_0x001a
            L_0x000f:
                androidx.multidex.MultiDex$V14$JBMR11ElementConstructor r1 = new androidx.multidex.MultiDex$V14$JBMR11ElementConstructor     // Catch:{ NoSuchMethodException -> 0x0015 }
                r1.<init>(r0)     // Catch:{ NoSuchMethodException -> 0x0015 }
                goto L_0x001a
            L_0x0015:
                androidx.multidex.MultiDex$V14$JBMR2ElementConstructor r1 = new androidx.multidex.MultiDex$V14$JBMR2ElementConstructor
                r1.<init>(r0)
            L_0x001a:
                r2.elementConstructor = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.multidex.MultiDex.V14.<init>():void");
        }

        private Object[] makeDexElements(List<? extends File> list) throws IOException, SecurityException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException {
            int size = list.size();
            Object[] objArr = new Object[size];
            for (int i11 = 0; i11 < size; i11++) {
                File file = (File) list.get(i11);
                objArr[i11] = this.elementConstructor.newInstance(file, DexFile.loadDex(file.getPath(), optimizedPathFor(file), 0));
            }
            return objArr;
        }

        private static String optimizedPathFor(File file) {
            File parentFile = file.getParentFile();
            String name2 = file.getName();
            return new File(parentFile, name2.substring(0, name2.length() - EXTRACTED_SUFFIX_LENGTH) + ".dex").getPath();
        }
    }

    public static final class V19 {
        private V19() {
        }

        public static void a(ClassLoader classLoader, List<? extends File> list, File file) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException {
            IOException[] iOExceptionArr;
            Object obj = MultiDex.findField(classLoader, "pathList").get(classLoader);
            ArrayList arrayList = new ArrayList();
            MultiDex.expandFieldArray(obj, "dexElements", makeDexElements(obj, new ArrayList(list), file, arrayList));
            if (arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Log.w("MultiDex", "Exception in makeDexElement", (IOException) it.next());
                }
                Field a11 = MultiDex.findField(obj, "dexElementsSuppressedExceptions");
                IOException[] iOExceptionArr2 = (IOException[]) a11.get(obj);
                if (iOExceptionArr2 == null) {
                    iOExceptionArr = (IOException[]) arrayList.toArray(new IOException[arrayList.size()]);
                } else {
                    IOException[] iOExceptionArr3 = new IOException[(arrayList.size() + iOExceptionArr2.length)];
                    arrayList.toArray(iOExceptionArr3);
                    System.arraycopy(iOExceptionArr2, 0, iOExceptionArr3, arrayList.size(), iOExceptionArr2.length);
                    iOExceptionArr = iOExceptionArr3;
                }
                a11.set(obj, iOExceptionArr);
                IOException iOException = new IOException("I/O exception during makeDexElement");
                iOException.initCause((Throwable) arrayList.get(0));
                throw iOException;
            }
        }

        private static Object[] makeDexElements(Object obj, ArrayList<File> arrayList, File file, ArrayList<IOException> arrayList2) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
            Class<ArrayList> cls = ArrayList.class;
            return (Object[]) MultiDex.findMethod(obj, "makeDexElements", cls, File.class, cls).invoke(obj, new Object[]{arrayList, file, arrayList2});
        }
    }

    public static final class V4 {
        private V4() {
        }
    }

    private MultiDex() {
    }

    private static void clearOldDexDir(Context context) throws Exception {
        File file = new File(context.getFilesDir(), "secondary-dexes");
        if (file.isDirectory()) {
            Log.i("MultiDex", "Clearing old secondary dex dir (" + file.getPath() + ").");
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                Log.w("MultiDex", "Failed to list secondary dex dir content (" + file.getPath() + ").");
                return;
            }
            for (File file2 : listFiles) {
                Log.i("MultiDex", "Trying to delete old file " + file2.getPath() + " of size " + file2.length());
                if (!file2.delete()) {
                    Log.w("MultiDex", "Failed to delete old file " + file2.getPath());
                } else {
                    Log.i("MultiDex", "Deleted old file " + file2.getPath());
                }
            }
            if (!file.delete()) {
                Log.w("MultiDex", "Failed to delete secondary dex dir " + file.getPath());
                return;
            }
            Log.i("MultiDex", "Deleted old secondary dex dir " + file.getPath());
        }
    }

    public static boolean d(String str) {
        String str2;
        String str3;
        boolean z11 = false;
        if (str != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
            String str4 = null;
            if (stringTokenizer.hasMoreTokens()) {
                str3 = stringTokenizer.nextToken();
            } else {
                str3 = null;
            }
            if (stringTokenizer.hasMoreTokens()) {
                str4 = stringTokenizer.nextToken();
            }
            if (!(str3 == null || str4 == null)) {
                try {
                    int parseInt = Integer.parseInt(str3);
                    int parseInt2 = Integer.parseInt(str4);
                    if (parseInt > 2 || (parseInt == 2 && parseInt2 >= 1)) {
                        z11 = true;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("VM with version ");
        sb2.append(str);
        if (z11) {
            str2 = " has multidex support";
        } else {
            str2 = " does not have multidex support";
        }
        sb2.append(str2);
        Log.i("MultiDex", sb2.toString());
        return z11;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:39|40|41|42|43) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:42:0x0095 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void doInstallation(android.content.Context r5, java.io.File r6, java.io.File r7, java.lang.String r8, java.lang.String r9, boolean r10) throws java.io.IOException, java.lang.IllegalArgumentException, java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.reflect.InvocationTargetException, java.lang.NoSuchMethodException, java.lang.SecurityException, java.lang.ClassNotFoundException, java.lang.InstantiationException {
        /*
            java.util.Set<java.io.File> r0 = installedApk
            monitor-enter(r0)
            boolean r1 = r0.contains(r6)     // Catch:{ all -> 0x0096 }
            if (r1 == 0) goto L_0x000b
            monitor-exit(r0)     // Catch:{ all -> 0x0096 }
            return
        L_0x000b:
            r0.add(r6)     // Catch:{ all -> 0x0096 }
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0096 }
            java.lang.String r2 = "MultiDex"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0096 }
            r3.<init>()     // Catch:{ all -> 0x0096 }
            java.lang.String r4 = "MultiDex is not guaranteed to work in SDK version "
            r3.append(r4)     // Catch:{ all -> 0x0096 }
            r3.append(r1)     // Catch:{ all -> 0x0096 }
            java.lang.String r1 = ": SDK version higher than "
            r3.append(r1)     // Catch:{ all -> 0x0096 }
            r1 = 20
            r3.append(r1)     // Catch:{ all -> 0x0096 }
            java.lang.String r1 = " should be backed by "
            r3.append(r1)     // Catch:{ all -> 0x0096 }
            java.lang.String r1 = "runtime with built-in multidex capabilty but it's not the "
            r3.append(r1)     // Catch:{ all -> 0x0096 }
            java.lang.String r1 = "case here: java.vm.version=\""
            r3.append(r1)     // Catch:{ all -> 0x0096 }
            java.lang.String r1 = "java.vm.version"
            java.lang.String r1 = java.lang.System.getProperty(r1)     // Catch:{ all -> 0x0096 }
            r3.append(r1)     // Catch:{ all -> 0x0096 }
            java.lang.String r1 = "\""
            r3.append(r1)     // Catch:{ all -> 0x0096 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0096 }
            android.util.Log.w(r2, r1)     // Catch:{ all -> 0x0096 }
            java.lang.ClassLoader r1 = getDexClassloader(r5)     // Catch:{ all -> 0x0096 }
            if (r1 != 0) goto L_0x0055
            monitor-exit(r0)     // Catch:{ all -> 0x0096 }
            return
        L_0x0055:
            clearOldDexDir(r5)     // Catch:{ all -> 0x0059 }
            goto L_0x0061
        L_0x0059:
            r2 = move-exception
            java.lang.String r3 = "MultiDex"
            java.lang.String r4 = "Something went wrong when trying to clear old MultiDex extraction, continuing without cleaning."
            android.util.Log.w(r3, r4, r2)     // Catch:{ all -> 0x0096 }
        L_0x0061:
            java.io.File r7 = getDexDir(r5, r7, r8)     // Catch:{ all -> 0x0096 }
            androidx.multidex.MultiDexExtractor r8 = new androidx.multidex.MultiDexExtractor     // Catch:{ all -> 0x0096 }
            r8.<init>(r6, r7)     // Catch:{ all -> 0x0096 }
            r6 = 0
            java.util.List r6 = r8.a(r5, r9, r6)     // Catch:{ all -> 0x0091 }
            installSecondaryDexes(r1, r7, r6)     // Catch:{ IOException -> 0x0073 }
            goto L_0x0085
        L_0x0073:
            r6 = move-exception
            if (r10 == 0) goto L_0x0090
            java.lang.String r10 = "MultiDex"
            java.lang.String r2 = "Failed to install extracted secondary dex files, retrying with forced extraction"
            android.util.Log.w(r10, r2, r6)     // Catch:{ all -> 0x0091 }
            r6 = 1
            java.util.List r5 = r8.a(r5, r9, r6)     // Catch:{ all -> 0x0091 }
            installSecondaryDexes(r1, r7, r5)     // Catch:{ all -> 0x0091 }
        L_0x0085:
            r8.close()     // Catch:{ IOException -> 0x008a }
            r5 = 0
            goto L_0x008b
        L_0x008a:
            r5 = move-exception
        L_0x008b:
            if (r5 != 0) goto L_0x008f
            monitor-exit(r0)     // Catch:{ all -> 0x0096 }
            return
        L_0x008f:
            throw r5     // Catch:{ all -> 0x0096 }
        L_0x0090:
            throw r6     // Catch:{ all -> 0x0091 }
        L_0x0091:
            r5 = move-exception
            r8.close()     // Catch:{ IOException -> 0x0095 }
        L_0x0095:
            throw r5     // Catch:{ all -> 0x0096 }
        L_0x0096:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0096 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.multidex.MultiDex.doInstallation(android.content.Context, java.io.File, java.io.File, java.lang.String, java.lang.String, boolean):void");
    }

    /* access modifiers changed from: private */
    public static void expandFieldArray(Object obj, String str, Object[] objArr) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field findField = findField(obj, str);
        Object[] objArr2 = (Object[]) findField.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr2, 0, objArr3, 0, objArr2.length);
        System.arraycopy(objArr, 0, objArr3, objArr2.length, objArr.length);
        findField.set(obj, objArr3);
    }

    /* access modifiers changed from: private */
    public static Field findField(Object obj, String str) throws NoSuchFieldException {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    /* access modifiers changed from: private */
    public static Method findMethod(Object obj, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }

    private static ApplicationInfo getApplicationInfo(Context context) {
        try {
            return context.getApplicationInfo();
        } catch (RuntimeException e11) {
            Log.w("MultiDex", "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", e11);
            return null;
        }
    }

    private static ClassLoader getDexClassloader(Context context) {
        try {
            ClassLoader classLoader = context.getClassLoader();
            if (classLoader instanceof BaseDexClassLoader) {
                return classLoader;
            }
            Log.e("MultiDex", "Context class loader is null or not dex-capable. Must be running in test mode. Skip patching.");
            return null;
        } catch (RuntimeException e11) {
            Log.w("MultiDex", "Failure while trying to obtain Context class loader. Must be running in test mode. Skip patching.", e11);
            return null;
        }
    }

    private static File getDexDir(Context context, File file, String str) throws IOException {
        File file2 = new File(file, CODE_CACHE_NAME);
        try {
            mkdirChecked(file2);
        } catch (IOException unused) {
            file2 = new File(context.getFilesDir(), CODE_CACHE_NAME);
            mkdirChecked(file2);
        }
        File file3 = new File(file2, str);
        mkdirChecked(file3);
        return file3;
    }

    public static void install(Context context) {
        Log.i("MultiDex", "Installing application");
        if (IS_VM_MULTIDEX_CAPABLE) {
            Log.i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
            return;
        }
        try {
            ApplicationInfo applicationInfo = getApplicationInfo(context);
            if (applicationInfo == null) {
                Log.i("MultiDex", "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
                return;
            }
            doInstallation(context, new File(applicationInfo.sourceDir), new File(applicationInfo.dataDir), "secondary-dexes", "", true);
            Log.i("MultiDex", "install done");
        } catch (Exception e11) {
            Log.e("MultiDex", "MultiDex installation failure", e11);
            throw new RuntimeException("MultiDex installation failed (" + e11.getMessage() + ").");
        }
    }

    public static void installInstrumentation(Context context, Context context2) {
        Log.i("MultiDex", "Installing instrumentation");
        if (IS_VM_MULTIDEX_CAPABLE) {
            Log.i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
            return;
        }
        try {
            ApplicationInfo applicationInfo = getApplicationInfo(context);
            if (applicationInfo == null) {
                Log.i("MultiDex", "No ApplicationInfo available for instrumentation, i.e. running on a test Context: MultiDex support library is disabled.");
                return;
            }
            ApplicationInfo applicationInfo2 = getApplicationInfo(context2);
            if (applicationInfo2 == null) {
                Log.i("MultiDex", "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
                return;
            }
            String str = context.getPackageName() + RealDiscoveryConfigurationRepository.VERSION_DELIMETER;
            File file = new File(applicationInfo2.dataDir);
            doInstallation(context2, new File(applicationInfo.sourceDir), file, str + "secondary-dexes", str, false);
            doInstallation(context2, new File(applicationInfo2.sourceDir), file, "secondary-dexes", "", false);
            Log.i("MultiDex", "Installation done");
        } catch (Exception e11) {
            Log.e("MultiDex", "MultiDex installation failure", e11);
            throw new RuntimeException("MultiDex installation failed (" + e11.getMessage() + ").");
        }
    }

    private static void installSecondaryDexes(ClassLoader classLoader, File file, List<? extends File> list) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException, SecurityException, ClassNotFoundException, InstantiationException {
        if (!list.isEmpty()) {
            V19.a(classLoader, list, file);
        }
    }

    private static void mkdirChecked(File file) throws IOException {
        file.mkdir();
        if (!file.isDirectory()) {
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                Log.e("MultiDex", "Failed to create dir " + file.getPath() + ". Parent file is null.");
            } else {
                Log.e("MultiDex", "Failed to create dir " + file.getPath() + ". parent file is a dir " + parentFile.isDirectory() + ", a file " + parentFile.isFile() + ", exists " + parentFile.exists() + ", readable " + parentFile.canRead() + ", writable " + parentFile.canWrite());
            }
            throw new IOException("Failed to create directory " + file.getPath());
        }
    }
}

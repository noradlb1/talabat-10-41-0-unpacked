package com.instabug.library.internal.storage.cache;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.internal.security.CertificateUtil;
import com.instabug.library.Instabug;
import com.instabug.library.internal.storage.cache.Cacheable;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.memory.Action;
import com.instabug.library.util.memory.MemoryGuard;
import com.instabug.library.util.memory.predicate.CacheFileMemoryAvailablePredicate;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class OnDiskCache<V extends Cacheable> extends Cache<String, V> {
    public static final String TAG = "OnDiskCache";
    /* access modifiers changed from: private */
    public Class<V> VClass;
    private final File cacheDir;
    /* access modifiers changed from: private */
    public final File cacheFile;
    /* access modifiers changed from: private */
    public final Charset charset;

    public class a implements Action {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f51027a;

        public a(List list) {
            this.f51027a = list;
        }

        /* JADX WARNING: Removed duplicated region for block: B:29:0x0079 A[Catch:{ all -> 0x0068 }] */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0081 A[Catch:{ all -> 0x0068 }] */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x00b0 A[SYNTHETIC, Splitter:B:41:0x00b0] */
        /* JADX WARNING: Removed duplicated region for block: B:50:0x00c0 A[SYNTHETIC, Splitter:B:50:0x00c0] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onAffirmed() throws java.lang.Throwable {
            /*
                r8 = this;
                com.instabug.library.internal.storage.cache.OnDiskCache r0 = com.instabug.library.internal.storage.cache.OnDiskCache.this
                java.io.File r0 = r0.cacheFile
                monitor-enter(r0)
                r1 = 0
                java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0071, all -> 0x006c }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0071, all -> 0x006c }
                java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0071, all -> 0x006c }
                com.instabug.library.internal.storage.cache.OnDiskCache r5 = com.instabug.library.internal.storage.cache.OnDiskCache.this     // Catch:{ Exception -> 0x0071, all -> 0x006c }
                java.io.File r5 = r5.cacheFile     // Catch:{ Exception -> 0x0071, all -> 0x006c }
                r4.<init>(r5)     // Catch:{ Exception -> 0x0071, all -> 0x006c }
                com.instabug.library.internal.storage.cache.OnDiskCache r5 = com.instabug.library.internal.storage.cache.OnDiskCache.this     // Catch:{ Exception -> 0x0071, all -> 0x006c }
                java.nio.charset.Charset r5 = r5.charset     // Catch:{ Exception -> 0x0071, all -> 0x006c }
                r3.<init>(r4, r5)     // Catch:{ Exception -> 0x0071, all -> 0x006c }
                r2.<init>(r3)     // Catch:{ Exception -> 0x0071, all -> 0x006c }
            L_0x0023:
                java.lang.String r1 = r2.readLine()     // Catch:{ Exception -> 0x006a }
                com.instabug.library.internal.storage.cache.OnDiskCache r3 = com.instabug.library.internal.storage.cache.OnDiskCache.this     // Catch:{ Exception -> 0x006a }
                java.lang.String r3 = r3.getValue(r1)     // Catch:{ Exception -> 0x006a }
                if (r3 == 0) goto L_0x005b
                boolean r4 = r3.isEmpty()     // Catch:{ Exception -> 0x006a }
                if (r4 != 0) goto L_0x005b
                com.instabug.library.internal.storage.cache.OnDiskCache r4 = com.instabug.library.internal.storage.cache.OnDiskCache.this     // Catch:{ Exception -> 0x006a }
                java.lang.Class r4 = r4.VClass     // Catch:{ Exception -> 0x006a }
                java.lang.Object r4 = r4.newInstance()     // Catch:{ Exception -> 0x006a }
                com.instabug.library.internal.storage.cache.Cacheable r4 = (com.instabug.library.internal.storage.cache.Cacheable) r4     // Catch:{ Exception -> 0x006a }
                com.instabug.library.e0 r5 = com.instabug.library.e0.c()     // Catch:{ Exception -> 0x006a }
                com.instabug.library.Feature$State r5 = r5.b()     // Catch:{ Exception -> 0x006a }
                com.instabug.library.Feature$State r6 = com.instabug.library.Feature.State.ENABLED     // Catch:{ Exception -> 0x006a }
                if (r5 != r6) goto L_0x0051
                java.lang.String r3 = com.instabug.library.encryption.EncryptionManager.decrypt((java.lang.String) r3)     // Catch:{ Exception -> 0x006a }
            L_0x0051:
                if (r3 == 0) goto L_0x005b
                r4.fromJson(r3)     // Catch:{ Exception -> 0x006a }
                java.util.List r3 = r8.f51027a     // Catch:{ Exception -> 0x006a }
                r3.add(r4)     // Catch:{ Exception -> 0x006a }
            L_0x005b:
                if (r1 != 0) goto L_0x0023
                r2.close()     // Catch:{ IOException -> 0x0062 }
                goto L_0x00bc
            L_0x0062:
                r1 = move-exception
                java.lang.String r2 = "OnDiskCache"
                java.lang.String r3 = "Failed to close file reader"
                goto L_0x00b9
            L_0x0068:
                r1 = move-exception
                goto L_0x00be
            L_0x006a:
                r1 = move-exception
                goto L_0x0075
            L_0x006c:
                r2 = move-exception
                r7 = r2
                r2 = r1
                r1 = r7
                goto L_0x00be
            L_0x0071:
                r2 = move-exception
                r7 = r2
                r2 = r1
                r1 = r7
            L_0x0075:
                boolean r3 = r1 instanceof java.lang.InstantiationException     // Catch:{ all -> 0x0068 }
                if (r3 == 0) goto L_0x0081
                java.lang.String r3 = "OnDiskCache"
                java.lang.String r4 = "InstantiationException happened while fetching values"
                com.instabug.library.util.InstabugSDKLogger.e(r3, r4, r1)     // Catch:{ all -> 0x0068 }
                goto L_0x00ae
            L_0x0081:
                boolean r3 = r1 instanceof java.lang.IllegalAccessException     // Catch:{ all -> 0x0068 }
                if (r3 == 0) goto L_0x008d
                java.lang.String r3 = "OnDiskCache"
                java.lang.String r4 = "IllegalAccessException went wrong while fetching"
                com.instabug.library.util.InstabugSDKLogger.e(r3, r4, r1)     // Catch:{ all -> 0x0068 }
                goto L_0x00ae
            L_0x008d:
                boolean r3 = r1 instanceof java.io.IOException     // Catch:{ all -> 0x0068 }
                if (r3 == 0) goto L_0x0099
                java.lang.String r3 = "OnDiskCache"
                java.lang.String r4 = "IOException went wrong while fetching values"
                com.instabug.library.util.InstabugSDKLogger.e(r3, r4, r1)     // Catch:{ all -> 0x0068 }
                goto L_0x00ae
            L_0x0099:
                boolean r3 = r1 instanceof org.json.JSONException     // Catch:{ all -> 0x0068 }
                if (r3 == 0) goto L_0x00a5
                java.lang.String r3 = "OnDiskCache"
                java.lang.String r4 = "JSONException went wrong while fetching values"
                com.instabug.library.util.InstabugSDKLogger.e(r3, r4, r1)     // Catch:{ all -> 0x0068 }
                goto L_0x00ae
            L_0x00a5:
                java.lang.String r3 = "OnDiskCache"
                java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x0068 }
                com.instabug.library.util.InstabugSDKLogger.e(r3, r4, r1)     // Catch:{ all -> 0x0068 }
            L_0x00ae:
                if (r2 == 0) goto L_0x00bc
                r2.close()     // Catch:{ IOException -> 0x00b4 }
                goto L_0x00bc
            L_0x00b4:
                r1 = move-exception
                java.lang.String r2 = "OnDiskCache"
                java.lang.String r3 = "Failed to close file reader"
            L_0x00b9:
                com.instabug.library.util.InstabugSDKLogger.e(r2, r3, r1)     // Catch:{ all -> 0x00cd }
            L_0x00bc:
                monitor-exit(r0)     // Catch:{ all -> 0x00cd }
                return
            L_0x00be:
                if (r2 == 0) goto L_0x00cc
                r2.close()     // Catch:{ IOException -> 0x00c4 }
                goto L_0x00cc
            L_0x00c4:
                r2 = move-exception
                java.lang.String r3 = "OnDiskCache"
                java.lang.String r4 = "Failed to close file reader"
                com.instabug.library.util.InstabugSDKLogger.e(r3, r4, r2)     // Catch:{ all -> 0x00cd }
            L_0x00cc:
                throw r1     // Catch:{ all -> 0x00cd }
            L_0x00cd:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x00cd }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.storage.cache.OnDiskCache.a.onAffirmed():void");
        }

        public void onDenied() throws Throwable {
            InstabugSDKLogger.e(OnDiskCache.TAG, "Failed to read cache values");
        }
    }

    public OnDiskCache(Context context, String str, String str2, Class<V> cls) {
        super(str);
        this.VClass = cls;
        File cacheDir2 = context.getCacheDir();
        this.cacheDir = cacheDir2;
        File file = new File(cacheDir2 + str2);
        this.cacheFile = file;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        if (!file.exists()) {
            try {
                atomicBoolean.set(file.createNewFile());
            } catch (IOException e11) {
                InstabugSDKLogger.e(TAG, "Failed to create", e11);
            }
        } else {
            atomicBoolean.set(true);
        }
        if (Charset.isSupported("UTF-8")) {
            this.charset = Charset.forName("UTF-8");
        } else {
            this.charset = Charset.defaultCharset();
        }
        if (atomicBoolean.get() && !checkCacheValidity()) {
            invalidate();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x007e A[SYNTHETIC, Splitter:B:40:0x007e] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0092 A[SYNTHETIC, Splitter:B:49:0x0092] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00aa A[SYNTHETIC, Splitter:B:62:0x00aa] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00bc A[SYNTHETIC, Splitter:B:72:0x00bc] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean checkCacheValidity() {
        /*
            r8 = this;
            java.io.File r0 = r8.cacheFile
            r1 = 0
            if (r0 == 0) goto L_0x00cc
            boolean r0 = r0.exists()
            if (r0 != 0) goto L_0x0013
            java.lang.String r0 = "OnDiskCache"
            java.lang.String r2 = "Cache file doesn't exist"
            com.instabug.library.util.InstabugSDKLogger.d(r0, r2)
            return r1
        L_0x0013:
            java.io.File r0 = r8.cacheFile
            monitor-enter(r0)
            r2 = 0
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00a0, JSONException -> 0x0088, OutOfMemoryError -> 0x006d }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00a0, JSONException -> 0x0088, OutOfMemoryError -> 0x006d }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ IOException -> 0x00a0, JSONException -> 0x0088, OutOfMemoryError -> 0x006d }
            java.io.File r6 = r8.cacheFile     // Catch:{ IOException -> 0x00a0, JSONException -> 0x0088, OutOfMemoryError -> 0x006d }
            r5.<init>(r6)     // Catch:{ IOException -> 0x00a0, JSONException -> 0x0088, OutOfMemoryError -> 0x006d }
            java.nio.charset.Charset r6 = r8.charset     // Catch:{ IOException -> 0x00a0, JSONException -> 0x0088, OutOfMemoryError -> 0x006d }
            r4.<init>(r5, r6)     // Catch:{ IOException -> 0x00a0, JSONException -> 0x0088, OutOfMemoryError -> 0x006d }
            r3.<init>(r4)     // Catch:{ IOException -> 0x00a0, JSONException -> 0x0088, OutOfMemoryError -> 0x006d }
            java.lang.String r2 = r3.readLine()     // Catch:{ IOException -> 0x0068, JSONException -> 0x0063, OutOfMemoryError -> 0x0060, all -> 0x005e }
            if (r2 == 0) goto L_0x0053
            java.lang.String r2 = r8.getValue(r2)     // Catch:{ IOException -> 0x0068, JSONException -> 0x0063, OutOfMemoryError -> 0x0060, all -> 0x005e }
            if (r2 == 0) goto L_0x0053
            boolean r4 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IOException -> 0x0068, JSONException -> 0x0063, OutOfMemoryError -> 0x0060, all -> 0x005e }
            if (r4 != 0) goto L_0x0053
            com.instabug.library.e0 r4 = com.instabug.library.e0.c()     // Catch:{ IOException -> 0x0068, JSONException -> 0x0063, OutOfMemoryError -> 0x0060, all -> 0x005e }
            com.instabug.library.Feature$State r4 = r4.b()     // Catch:{ IOException -> 0x0068, JSONException -> 0x0063, OutOfMemoryError -> 0x0060, all -> 0x005e }
            com.instabug.library.Feature$State r5 = com.instabug.library.Feature.State.ENABLED     // Catch:{ IOException -> 0x0068, JSONException -> 0x0063, OutOfMemoryError -> 0x0060, all -> 0x005e }
            if (r4 != r5) goto L_0x004c
            java.lang.String r2 = com.instabug.library.encryption.EncryptionManager.decrypt((java.lang.String) r2)     // Catch:{ IOException -> 0x0068, JSONException -> 0x0063, OutOfMemoryError -> 0x0060, all -> 0x005e }
        L_0x004c:
            if (r2 == 0) goto L_0x0053
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ IOException -> 0x0068, JSONException -> 0x0063, OutOfMemoryError -> 0x0060, all -> 0x005e }
            r4.<init>((java.lang.String) r2)     // Catch:{ IOException -> 0x0068, JSONException -> 0x0063, OutOfMemoryError -> 0x0060, all -> 0x005e }
        L_0x0053:
            r3.close()     // Catch:{ IOException -> 0x0058 }
            goto L_0x00b6
        L_0x0058:
            r1 = move-exception
            java.lang.String r2 = "OnDiskCache"
            java.lang.String r3 = "Failed to close file reader"
            goto L_0x00b3
        L_0x005e:
            r1 = move-exception
            goto L_0x00ba
        L_0x0060:
            r1 = move-exception
            r2 = r3
            goto L_0x006e
        L_0x0063:
            r2 = move-exception
            r7 = r3
            r3 = r2
            r2 = r7
            goto L_0x0089
        L_0x0068:
            r1 = move-exception
            r2 = r3
            goto L_0x00a1
        L_0x006b:
            r1 = move-exception
            goto L_0x00b9
        L_0x006d:
            r1 = move-exception
        L_0x006e:
            java.lang.String r3 = "OOM while fetching values from disk cache"
            com.instabug.library.core.InstabugCore.reportError(r1, r3)     // Catch:{ all -> 0x006b }
            java.lang.String r3 = "OOM while fetching values "
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x006b }
            com.instabug.library.util.InstabugSDKLogger.e(r3, r1)     // Catch:{ all -> 0x006b }
            if (r2 == 0) goto L_0x00b6
            r2.close()     // Catch:{ IOException -> 0x0082 }
            goto L_0x00b6
        L_0x0082:
            r1 = move-exception
            java.lang.String r2 = "OnDiskCache"
            java.lang.String r3 = "Failed to close file reader"
            goto L_0x00b3
        L_0x0088:
            r3 = move-exception
        L_0x0089:
            java.lang.String r4 = "OnDiskCache"
            java.lang.String r5 = "JSONException went wrong while fetching values"
            com.instabug.library.util.InstabugSDKLogger.e(r4, r5, r3)     // Catch:{ all -> 0x006b }
            if (r2 == 0) goto L_0x009e
            r2.close()     // Catch:{ IOException -> 0x0096 }
            goto L_0x009e
        L_0x0096:
            r2 = move-exception
            java.lang.String r3 = "OnDiskCache"
            java.lang.String r4 = "Failed to close file reader"
            com.instabug.library.util.InstabugSDKLogger.e(r3, r4, r2)     // Catch:{ all -> 0x00c9 }
        L_0x009e:
            monitor-exit(r0)     // Catch:{ all -> 0x00c9 }
            return r1
        L_0x00a0:
            r1 = move-exception
        L_0x00a1:
            java.lang.String r3 = "OnDiskCache"
            java.lang.String r4 = "IOException went wrong while fetching values"
            com.instabug.library.util.InstabugSDKLogger.e(r3, r4, r1)     // Catch:{ all -> 0x006b }
            if (r2 == 0) goto L_0x00b6
            r2.close()     // Catch:{ IOException -> 0x00ae }
            goto L_0x00b6
        L_0x00ae:
            r1 = move-exception
            java.lang.String r2 = "OnDiskCache"
            java.lang.String r3 = "Failed to close file reader"
        L_0x00b3:
            com.instabug.library.util.InstabugSDKLogger.e(r2, r3, r1)     // Catch:{ all -> 0x00c9 }
        L_0x00b6:
            monitor-exit(r0)     // Catch:{ all -> 0x00c9 }
            r0 = 1
            return r0
        L_0x00b9:
            r3 = r2
        L_0x00ba:
            if (r3 == 0) goto L_0x00c8
            r3.close()     // Catch:{ IOException -> 0x00c0 }
            goto L_0x00c8
        L_0x00c0:
            r2 = move-exception
            java.lang.String r3 = "OnDiskCache"
            java.lang.String r4 = "Failed to close file reader"
            com.instabug.library.util.InstabugSDKLogger.e(r3, r4, r2)     // Catch:{ all -> 0x00c9 }
        L_0x00c8:
            throw r1     // Catch:{ all -> 0x00c9 }
        L_0x00c9:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00c9 }
            throw r1
        L_0x00cc:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.storage.cache.OnDiskCache.checkCacheValidity():boolean");
    }

    @NonNull
    private Action getReadValuesAction(List<V> list) {
        return new a(list);
    }

    @Nullable
    public String getKey(String str) {
        if (str == null || str.isEmpty() || !str.contains(CertificateUtil.DELIMITER)) {
            return null;
        }
        return str.substring(0, str.indexOf(CertificateUtil.DELIMITER));
    }

    @Nullable
    public String getValue(String str) {
        if (str == null || str.isEmpty() || !str.contains(CertificateUtil.DELIMITER)) {
            return null;
        }
        return str.substring(str.indexOf(CertificateUtil.DELIMITER) + 1);
    }

    public List<V> getValues() {
        ArrayList arrayList = new ArrayList();
        if (this.cacheFile.exists() && Instabug.isBuilt() && Instabug.getApplicationContext() != null) {
            MemoryGuard.from(Instabug.getApplicationContext()).withPredicate(new CacheFileMemoryAvailablePredicate(this.cacheFile)).forOperation("reading cache values").doAction(getReadValuesAction(arrayList));
        }
        return arrayList;
    }

    public void invalidate() {
        if (this.cacheFile.exists()) {
            InstabugSDKLogger.d(TAG, "Cache file  exist");
            synchronized (this.cacheFile) {
                this.cacheFile.delete();
            }
        }
        try {
            this.cacheFile.createNewFile();
        } catch (IOException e11) {
            InstabugSDKLogger.e(TAG, "Failed to create cache file", e11);
        }
    }

    public long size() {
        long totalSpace;
        if (!this.cacheFile.exists()) {
            InstabugSDKLogger.d(TAG, "Cache file doesn't exist");
            return -1;
        }
        synchronized (this.cacheFile) {
            totalSpace = this.cacheFile.getTotalSpace();
        }
        return totalSpace;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.io.BufferedWriter} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v5, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r1v6, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r1v7, types: [java.io.BufferedReader] */
    /* JADX WARNING: type inference failed for: r1v8 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v16 */
    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processHandlersOutBlocks(RegionMaker.java:1008)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:978)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01b6 A[SYNTHETIC, Splitter:B:105:0x01b6] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01c0 A[Catch:{ IOException -> 0x01bc }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0143 A[SYNTHETIC, Splitter:B:63:0x0143] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x014b A[Catch:{ IOException -> 0x0147 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0170 A[SYNTHETIC, Splitter:B:77:0x0170] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0178 A[Catch:{ IOException -> 0x0174 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x019d A[SYNTHETIC, Splitter:B:91:0x019d] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01a5 A[Catch:{ IOException -> 0x01a1 }] */
    @android.annotation.SuppressLint({"RESOURCE_LEAK"})
    @androidx.annotation.Nullable
    public V delete(java.lang.String r10) {
        /*
            r9 = this;
            java.io.File r0 = r9.cacheFile
            boolean r0 = r0.exists()
            r1 = 0
            if (r0 != 0) goto L_0x0011
            java.lang.String r10 = "OnDiskCache"
            java.lang.String r0 = "Cache file doesn't exist"
            com.instabug.library.util.InstabugSDKLogger.d(r10, r0)
            return r1
        L_0x0011:
            java.io.File r0 = new java.io.File
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.io.File r3 = r9.cacheDir
            r2.append(r3)
            java.lang.String r3 = "/cache.tmp"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2)
            java.lang.Class<V> r2 = r9.VClass     // Catch:{ InstantiationException -> 0x004a, IllegalAccessException -> 0x0032 }
            java.lang.Object r2 = r2.newInstance()     // Catch:{ InstantiationException -> 0x004a, IllegalAccessException -> 0x0032 }
            com.instabug.library.internal.storage.cache.Cacheable r2 = (com.instabug.library.internal.storage.cache.Cacheable) r2     // Catch:{ InstantiationException -> 0x004a, IllegalAccessException -> 0x0032 }
            goto L_0x0062
        L_0x0032:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "IllegalAccessException went wrong while deleting value for key "
            r3.append(r4)
            r3.append(r10)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "OnDiskCache"
            com.instabug.library.util.InstabugSDKLogger.e(r4, r3, r2)
            goto L_0x0061
        L_0x004a:
            r2 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "InstantiationException happened while deleting value for key "
            r3.append(r4)
            r3.append(r10)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "OnDiskCache"
            com.instabug.library.util.InstabugSDKLogger.e(r4, r3, r2)
        L_0x0061:
            r2 = r1
        L_0x0062:
            java.io.File r3 = r9.cacheFile
            monitor-enter(r3)
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0183, JSONException -> 0x0156, OutOfMemoryError -> 0x0113, all -> 0x010f }
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0183, JSONException -> 0x0156, OutOfMemoryError -> 0x0113, all -> 0x010f }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0183, JSONException -> 0x0156, OutOfMemoryError -> 0x0113, all -> 0x010f }
            java.io.File r7 = r9.cacheFile     // Catch:{ IOException -> 0x0183, JSONException -> 0x0156, OutOfMemoryError -> 0x0113, all -> 0x010f }
            r6.<init>(r7)     // Catch:{ IOException -> 0x0183, JSONException -> 0x0156, OutOfMemoryError -> 0x0113, all -> 0x010f }
            java.nio.charset.Charset r7 = r9.charset     // Catch:{ IOException -> 0x0183, JSONException -> 0x0156, OutOfMemoryError -> 0x0113, all -> 0x010f }
            r5.<init>(r6, r7)     // Catch:{ IOException -> 0x0183, JSONException -> 0x0156, OutOfMemoryError -> 0x0113, all -> 0x010f }
            r4.<init>(r5)     // Catch:{ IOException -> 0x0183, JSONException -> 0x0156, OutOfMemoryError -> 0x0113, all -> 0x010f }
            java.io.BufferedWriter r5 = new java.io.BufferedWriter     // Catch:{ IOException -> 0x010a, JSONException -> 0x0106, OutOfMemoryError -> 0x0102, all -> 0x00ff }
            java.io.OutputStreamWriter r6 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x010a, JSONException -> 0x0106, OutOfMemoryError -> 0x0102, all -> 0x00ff }
            java.io.FileOutputStream r7 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x010a, JSONException -> 0x0106, OutOfMemoryError -> 0x0102, all -> 0x00ff }
            r8 = 1
            r7.<init>(r0, r8)     // Catch:{ IOException -> 0x010a, JSONException -> 0x0106, OutOfMemoryError -> 0x0102, all -> 0x00ff }
            java.nio.charset.Charset r8 = r9.charset     // Catch:{ IOException -> 0x010a, JSONException -> 0x0106, OutOfMemoryError -> 0x0102, all -> 0x00ff }
            r6.<init>(r7, r8)     // Catch:{ IOException -> 0x010a, JSONException -> 0x0106, OutOfMemoryError -> 0x0102, all -> 0x00ff }
            r5.<init>(r6)     // Catch:{ IOException -> 0x010a, JSONException -> 0x0106, OutOfMemoryError -> 0x0102, all -> 0x00ff }
        L_0x008a:
            java.lang.String r1 = r4.readLine()     // Catch:{ IOException -> 0x00fd, JSONException -> 0x00fb, OutOfMemoryError -> 0x00f9, all -> 0x00f6 }
            java.lang.String r6 = r9.getKey(r1)     // Catch:{ IOException -> 0x00fd, JSONException -> 0x00fb, OutOfMemoryError -> 0x00f9, all -> 0x00f6 }
            java.lang.String r7 = r9.getValue(r1)     // Catch:{ IOException -> 0x00fd, JSONException -> 0x00fb, OutOfMemoryError -> 0x00f9, all -> 0x00f6 }
            if (r6 == 0) goto L_0x00cc
            boolean r6 = r6.equals(r10)     // Catch:{ IOException -> 0x00fd, JSONException -> 0x00fb, OutOfMemoryError -> 0x00f9, all -> 0x00f6 }
            if (r6 == 0) goto L_0x00b8
            if (r2 == 0) goto L_0x00b8
            if (r7 == 0) goto L_0x00b8
            com.instabug.library.e0 r6 = com.instabug.library.e0.c()     // Catch:{ IOException -> 0x00fd, JSONException -> 0x00fb, OutOfMemoryError -> 0x00f9, all -> 0x00f6 }
            com.instabug.library.Feature$State r6 = r6.b()     // Catch:{ IOException -> 0x00fd, JSONException -> 0x00fb, OutOfMemoryError -> 0x00f9, all -> 0x00f6 }
            com.instabug.library.Feature$State r8 = com.instabug.library.Feature.State.ENABLED     // Catch:{ IOException -> 0x00fd, JSONException -> 0x00fb, OutOfMemoryError -> 0x00f9, all -> 0x00f6 }
            if (r6 != r8) goto L_0x00b2
            java.lang.String r7 = com.instabug.library.encryption.EncryptionManager.decrypt((java.lang.String) r7)     // Catch:{ IOException -> 0x00fd, JSONException -> 0x00fb, OutOfMemoryError -> 0x00f9, all -> 0x00f6 }
        L_0x00b2:
            if (r7 == 0) goto L_0x00cc
            r2.fromJson(r7)     // Catch:{ IOException -> 0x00fd, JSONException -> 0x00fb, OutOfMemoryError -> 0x00f9, all -> 0x00f6 }
            goto L_0x00cc
        L_0x00b8:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00fd, JSONException -> 0x00fb, OutOfMemoryError -> 0x00f9, all -> 0x00f6 }
            r6.<init>()     // Catch:{ IOException -> 0x00fd, JSONException -> 0x00fb, OutOfMemoryError -> 0x00f9, all -> 0x00f6 }
            r6.append(r1)     // Catch:{ IOException -> 0x00fd, JSONException -> 0x00fb, OutOfMemoryError -> 0x00f9, all -> 0x00f6 }
            java.lang.String r7 = "\n"
            r6.append(r7)     // Catch:{ IOException -> 0x00fd, JSONException -> 0x00fb, OutOfMemoryError -> 0x00f9, all -> 0x00f6 }
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x00fd, JSONException -> 0x00fb, OutOfMemoryError -> 0x00f9, all -> 0x00f6 }
            r5.write(r6)     // Catch:{ IOException -> 0x00fd, JSONException -> 0x00fb, OutOfMemoryError -> 0x00f9, all -> 0x00f6 }
        L_0x00cc:
            if (r1 != 0) goto L_0x008a
            java.io.File r1 = r9.cacheFile     // Catch:{ IOException -> 0x00fd, JSONException -> 0x00fb, OutOfMemoryError -> 0x00f9, all -> 0x00f6 }
            boolean r1 = r1.delete()     // Catch:{ IOException -> 0x00fd, JSONException -> 0x00fb, OutOfMemoryError -> 0x00f9, all -> 0x00f6 }
            if (r1 == 0) goto L_0x00e5
            java.io.File r1 = r9.cacheFile     // Catch:{ IOException -> 0x00fd, JSONException -> 0x00fb, OutOfMemoryError -> 0x00f9, all -> 0x00f6 }
            boolean r0 = r0.renameTo(r1)     // Catch:{ IOException -> 0x00fd, JSONException -> 0x00fb, OutOfMemoryError -> 0x00f9, all -> 0x00f6 }
            if (r0 != 0) goto L_0x00e5
            java.lang.String r0 = "OnDiskCache"
            java.lang.String r1 = "Couldn't rename temp cache file"
            com.instabug.library.util.InstabugSDKLogger.e(r0, r1)     // Catch:{ IOException -> 0x00fd, JSONException -> 0x00fb, OutOfMemoryError -> 0x00f9, all -> 0x00f6 }
        L_0x00e5:
            r4.close()     // Catch:{ IOException -> 0x00f0 }
            r5.flush()     // Catch:{ IOException -> 0x00f0 }
            r5.close()     // Catch:{ IOException -> 0x00f0 }
            goto L_0x01af
        L_0x00f0:
            r10 = move-exception
            r10.printStackTrace()     // Catch:{ all -> 0x01ba }
            goto L_0x01af
        L_0x00f6:
            r10 = move-exception
            goto L_0x01b3
        L_0x00f9:
            r0 = move-exception
            goto L_0x0104
        L_0x00fb:
            r0 = move-exception
            goto L_0x0108
        L_0x00fd:
            r0 = move-exception
            goto L_0x010c
        L_0x00ff:
            r10 = move-exception
            goto L_0x01b4
        L_0x0102:
            r0 = move-exception
            r5 = r1
        L_0x0104:
            r1 = r4
            goto L_0x0115
        L_0x0106:
            r0 = move-exception
            r5 = r1
        L_0x0108:
            r1 = r4
            goto L_0x0158
        L_0x010a:
            r0 = move-exception
            r5 = r1
        L_0x010c:
            r1 = r4
            goto L_0x0185
        L_0x010f:
            r10 = move-exception
            r5 = r1
            goto L_0x01b2
        L_0x0113:
            r0 = move-exception
            r5 = r1
        L_0x0115:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b1 }
            r4.<init>()     // Catch:{ all -> 0x01b1 }
            java.lang.String r6 = "OOM while deleting value for key "
            r4.append(r6)     // Catch:{ all -> 0x01b1 }
            r4.append(r10)     // Catch:{ all -> 0x01b1 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x01b1 }
            com.instabug.library.core.InstabugCore.reportError(r0, r4)     // Catch:{ all -> 0x01b1 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b1 }
            r4.<init>()     // Catch:{ all -> 0x01b1 }
            java.lang.String r6 = "OOM while deleting value for key "
            r4.append(r6)     // Catch:{ all -> 0x01b1 }
            r4.append(r10)     // Catch:{ all -> 0x01b1 }
            java.lang.String r10 = r4.toString()     // Catch:{ all -> 0x01b1 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x01b1 }
            com.instabug.library.util.InstabugSDKLogger.e(r10, r0)     // Catch:{ all -> 0x01b1 }
            if (r1 == 0) goto L_0x0149
            r1.close()     // Catch:{ IOException -> 0x0147 }
            goto L_0x0149
        L_0x0147:
            r10 = move-exception
            goto L_0x0152
        L_0x0149:
            if (r5 == 0) goto L_0x01af
            r5.flush()     // Catch:{ IOException -> 0x0147 }
            r5.close()     // Catch:{ IOException -> 0x0147 }
            goto L_0x01af
        L_0x0152:
            r10.printStackTrace()     // Catch:{ all -> 0x01ba }
            goto L_0x01af
        L_0x0156:
            r0 = move-exception
            r5 = r1
        L_0x0158:
            java.lang.String r4 = "OnDiskCache"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b1 }
            r6.<init>()     // Catch:{ all -> 0x01b1 }
            java.lang.String r7 = "JSONException went wrong while deleting value for key "
            r6.append(r7)     // Catch:{ all -> 0x01b1 }
            r6.append(r10)     // Catch:{ all -> 0x01b1 }
            java.lang.String r10 = r6.toString()     // Catch:{ all -> 0x01b1 }
            com.instabug.library.util.InstabugSDKLogger.e(r4, r10, r0)     // Catch:{ all -> 0x01b1 }
            if (r1 == 0) goto L_0x0176
            r1.close()     // Catch:{ IOException -> 0x0174 }
            goto L_0x0176
        L_0x0174:
            r10 = move-exception
            goto L_0x017f
        L_0x0176:
            if (r5 == 0) goto L_0x01af
            r5.flush()     // Catch:{ IOException -> 0x0174 }
            r5.close()     // Catch:{ IOException -> 0x0174 }
            goto L_0x01af
        L_0x017f:
            r10.printStackTrace()     // Catch:{ all -> 0x01ba }
            goto L_0x01af
        L_0x0183:
            r0 = move-exception
            r5 = r1
        L_0x0185:
            java.lang.String r4 = "OnDiskCache"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b1 }
            r6.<init>()     // Catch:{ all -> 0x01b1 }
            java.lang.String r7 = "IOException went wrong while deleting value for key "
            r6.append(r7)     // Catch:{ all -> 0x01b1 }
            r6.append(r10)     // Catch:{ all -> 0x01b1 }
            java.lang.String r10 = r6.toString()     // Catch:{ all -> 0x01b1 }
            com.instabug.library.util.InstabugSDKLogger.e(r4, r10, r0)     // Catch:{ all -> 0x01b1 }
            if (r1 == 0) goto L_0x01a3
            r1.close()     // Catch:{ IOException -> 0x01a1 }
            goto L_0x01a3
        L_0x01a1:
            r10 = move-exception
            goto L_0x01ac
        L_0x01a3:
            if (r5 == 0) goto L_0x01af
            r5.flush()     // Catch:{ IOException -> 0x01a1 }
            r5.close()     // Catch:{ IOException -> 0x01a1 }
            goto L_0x01af
        L_0x01ac:
            r10.printStackTrace()     // Catch:{ all -> 0x01ba }
        L_0x01af:
            monitor-exit(r3)     // Catch:{ all -> 0x01ba }
            return r2
        L_0x01b1:
            r10 = move-exception
        L_0x01b2:
            r4 = r1
        L_0x01b3:
            r1 = r5
        L_0x01b4:
            if (r4 == 0) goto L_0x01be
            r4.close()     // Catch:{ IOException -> 0x01bc }
            goto L_0x01be
        L_0x01ba:
            r10 = move-exception
            goto L_0x01cb
        L_0x01bc:
            r0 = move-exception
            goto L_0x01c7
        L_0x01be:
            if (r1 == 0) goto L_0x01ca
            r1.flush()     // Catch:{ IOException -> 0x01bc }
            r1.close()     // Catch:{ IOException -> 0x01bc }
            goto L_0x01ca
        L_0x01c7:
            r0.printStackTrace()     // Catch:{ all -> 0x01ba }
        L_0x01ca:
            throw r10     // Catch:{ all -> 0x01ba }
        L_0x01cb:
            monitor-exit(r3)     // Catch:{ all -> 0x01ba }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.storage.cache.OnDiskCache.delete(java.lang.String):com.instabug.library.internal.storage.cache.Cacheable");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processHandlersOutBlocks(RegionMaker.java:1008)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:978)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ef A[SYNTHETIC, Splitter:B:54:0x00ef] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0113 A[SYNTHETIC, Splitter:B:64:0x0113] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0137 A[SYNTHETIC, Splitter:B:74:0x0137] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0165 A[SYNTHETIC, Splitter:B:87:0x0165] */
    @androidx.annotation.Nullable
    public V get(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 0
            if (r9 != 0) goto L_0x000b
            java.lang.String r9 = "OnDiskCache"
            java.lang.String r1 = "Key equal null"
            com.instabug.library.util.InstabugSDKLogger.d(r9, r1)
            return r0
        L_0x000b:
            java.io.File r1 = r8.cacheFile
            boolean r1 = r1.exists()
            if (r1 != 0) goto L_0x001b
            java.lang.String r9 = "OnDiskCache"
            java.lang.String r1 = "Cache file doesn't exist"
            com.instabug.library.util.InstabugSDKLogger.d(r9, r1)
            return r0
        L_0x001b:
            java.lang.Class<V> r1 = r8.VClass     // Catch:{ InstantiationException -> 0x003c, IllegalAccessException -> 0x0024 }
            java.lang.Object r1 = r1.newInstance()     // Catch:{ InstantiationException -> 0x003c, IllegalAccessException -> 0x0024 }
            com.instabug.library.internal.storage.cache.Cacheable r1 = (com.instabug.library.internal.storage.cache.Cacheable) r1     // Catch:{ InstantiationException -> 0x003c, IllegalAccessException -> 0x0024 }
            goto L_0x0054
        L_0x0024:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "IllegalAccessException went wrong while fetching value for key "
            r2.append(r3)
            r2.append(r9)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "OnDiskCache"
            com.instabug.library.util.InstabugSDKLogger.e(r3, r2, r1)
            goto L_0x0053
        L_0x003c:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "InstantiationException happened while fetching value for key "
            r2.append(r3)
            r2.append(r9)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "OnDiskCache"
            com.instabug.library.util.InstabugSDKLogger.e(r3, r2, r1)
        L_0x0053:
            r1 = r0
        L_0x0054:
            java.io.File r2 = r8.cacheFile
            monitor-enter(r2)
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x011d, JSONException -> 0x00f9, OutOfMemoryError -> 0x00bf, all -> 0x00bc }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x011d, JSONException -> 0x00f9, OutOfMemoryError -> 0x00bf, all -> 0x00bc }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ IOException -> 0x011d, JSONException -> 0x00f9, OutOfMemoryError -> 0x00bf, all -> 0x00bc }
            java.io.File r6 = r8.cacheFile     // Catch:{ IOException -> 0x011d, JSONException -> 0x00f9, OutOfMemoryError -> 0x00bf, all -> 0x00bc }
            r5.<init>(r6)     // Catch:{ IOException -> 0x011d, JSONException -> 0x00f9, OutOfMemoryError -> 0x00bf, all -> 0x00bc }
            java.nio.charset.Charset r6 = r8.charset     // Catch:{ IOException -> 0x011d, JSONException -> 0x00f9, OutOfMemoryError -> 0x00bf, all -> 0x00bc }
            r4.<init>(r5, r6)     // Catch:{ IOException -> 0x011d, JSONException -> 0x00f9, OutOfMemoryError -> 0x00bf, all -> 0x00bc }
            r3.<init>(r4)     // Catch:{ IOException -> 0x011d, JSONException -> 0x00f9, OutOfMemoryError -> 0x00bf, all -> 0x00bc }
        L_0x006a:
            java.lang.String r4 = r3.readLine()     // Catch:{ IOException -> 0x00ba, JSONException -> 0x00b8, OutOfMemoryError -> 0x00b6, all -> 0x00b3 }
            java.lang.String r5 = r8.getKey(r4)     // Catch:{ IOException -> 0x00ba, JSONException -> 0x00b8, OutOfMemoryError -> 0x00b6, all -> 0x00b3 }
            java.lang.String r6 = r8.getValue(r4)     // Catch:{ IOException -> 0x00ba, JSONException -> 0x00b8, OutOfMemoryError -> 0x00b6, all -> 0x00b3 }
            if (r5 == 0) goto L_0x00a5
            boolean r5 = r5.equals(r9)     // Catch:{ IOException -> 0x00ba, JSONException -> 0x00b8, OutOfMemoryError -> 0x00b6, all -> 0x00b3 }
            if (r5 == 0) goto L_0x00a5
            if (r1 == 0) goto L_0x00a5
            if (r6 == 0) goto L_0x00a5
            com.instabug.library.e0 r5 = com.instabug.library.e0.c()     // Catch:{ IOException -> 0x00ba, JSONException -> 0x00b8, OutOfMemoryError -> 0x00b6, all -> 0x00b3 }
            com.instabug.library.Feature$State r5 = r5.b()     // Catch:{ IOException -> 0x00ba, JSONException -> 0x00b8, OutOfMemoryError -> 0x00b6, all -> 0x00b3 }
            com.instabug.library.Feature$State r7 = com.instabug.library.Feature.State.ENABLED     // Catch:{ IOException -> 0x00ba, JSONException -> 0x00b8, OutOfMemoryError -> 0x00b6, all -> 0x00b3 }
            if (r5 != r7) goto L_0x0092
            java.lang.String r6 = com.instabug.library.encryption.EncryptionManager.decrypt((java.lang.String) r6)     // Catch:{ IOException -> 0x00ba, JSONException -> 0x00b8, OutOfMemoryError -> 0x00b6, all -> 0x00b3 }
        L_0x0092:
            if (r6 == 0) goto L_0x00a5
            r1.fromJson(r6)     // Catch:{ IOException -> 0x00ba, JSONException -> 0x00b8, OutOfMemoryError -> 0x00b6, all -> 0x00b3 }
            r3.close()     // Catch:{ IOException -> 0x009b }
            goto L_0x00a3
        L_0x009b:
            r9 = move-exception
            java.lang.String r0 = "OnDiskCache"
            java.lang.String r3 = "Failed to close file reader"
            com.instabug.library.util.InstabugSDKLogger.e(r0, r3, r9)     // Catch:{ all -> 0x0172 }
        L_0x00a3:
            monitor-exit(r2)     // Catch:{ all -> 0x0172 }
            return r1
        L_0x00a5:
            if (r4 != 0) goto L_0x006a
            r3.close()     // Catch:{ IOException -> 0x00ac }
            goto L_0x0143
        L_0x00ac:
            r1 = move-exception
            java.lang.String r3 = "OnDiskCache"
            java.lang.String r4 = "Failed to close file reader"
            goto L_0x0140
        L_0x00b3:
            r9 = move-exception
            goto L_0x0163
        L_0x00b6:
            r1 = move-exception
            goto L_0x00c1
        L_0x00b8:
            r1 = move-exception
            goto L_0x00fb
        L_0x00ba:
            r1 = move-exception
            goto L_0x011f
        L_0x00bc:
            r9 = move-exception
            goto L_0x0162
        L_0x00bf:
            r1 = move-exception
            r3 = r0
        L_0x00c1:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0160 }
            r4.<init>()     // Catch:{ all -> 0x0160 }
            java.lang.String r5 = "OOM while fetching value for key "
            r4.append(r5)     // Catch:{ all -> 0x0160 }
            r4.append(r9)     // Catch:{ all -> 0x0160 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0160 }
            com.instabug.library.core.InstabugCore.reportError(r1, r4)     // Catch:{ all -> 0x0160 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0160 }
            r4.<init>()     // Catch:{ all -> 0x0160 }
            java.lang.String r5 = "OOM while fetching value for key "
            r4.append(r5)     // Catch:{ all -> 0x0160 }
            r4.append(r9)     // Catch:{ all -> 0x0160 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0160 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0160 }
            com.instabug.library.util.InstabugSDKLogger.e(r4, r1)     // Catch:{ all -> 0x0160 }
            if (r3 == 0) goto L_0x0143
            r3.close()     // Catch:{ IOException -> 0x00f3 }
            goto L_0x0143
        L_0x00f3:
            r1 = move-exception
            java.lang.String r3 = "OnDiskCache"
            java.lang.String r4 = "Failed to close file reader"
            goto L_0x0140
        L_0x00f9:
            r1 = move-exception
            r3 = r0
        L_0x00fb:
            java.lang.String r4 = "OnDiskCache"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0160 }
            r5.<init>()     // Catch:{ all -> 0x0160 }
            java.lang.String r6 = "JSONException went wrong while fetching value for key "
            r5.append(r6)     // Catch:{ all -> 0x0160 }
            r5.append(r9)     // Catch:{ all -> 0x0160 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0160 }
            com.instabug.library.util.InstabugSDKLogger.e(r4, r5, r1)     // Catch:{ all -> 0x0160 }
            if (r3 == 0) goto L_0x0143
            r3.close()     // Catch:{ IOException -> 0x0117 }
            goto L_0x0143
        L_0x0117:
            r1 = move-exception
            java.lang.String r3 = "OnDiskCache"
            java.lang.String r4 = "Failed to close file reader"
            goto L_0x0140
        L_0x011d:
            r1 = move-exception
            r3 = r0
        L_0x011f:
            java.lang.String r4 = "OnDiskCache"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0160 }
            r5.<init>()     // Catch:{ all -> 0x0160 }
            java.lang.String r6 = "IOException went wrong while fetching value for key "
            r5.append(r6)     // Catch:{ all -> 0x0160 }
            r5.append(r9)     // Catch:{ all -> 0x0160 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0160 }
            com.instabug.library.util.InstabugSDKLogger.e(r4, r5, r1)     // Catch:{ all -> 0x0160 }
            if (r3 == 0) goto L_0x0143
            r3.close()     // Catch:{ IOException -> 0x013b }
            goto L_0x0143
        L_0x013b:
            r1 = move-exception
            java.lang.String r3 = "OnDiskCache"
            java.lang.String r4 = "Failed to close file reader"
        L_0x0140:
            com.instabug.library.util.InstabugSDKLogger.e(r3, r4, r1)     // Catch:{ all -> 0x0172 }
        L_0x0143:
            java.lang.String r1 = "OnDiskCache"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0172 }
            r3.<init>()     // Catch:{ all -> 0x0172 }
            java.lang.String r4 = "No value found for key "
            r3.append(r4)     // Catch:{ all -> 0x0172 }
            r3.append(r9)     // Catch:{ all -> 0x0172 }
            java.lang.String r9 = ", returning null"
            r3.append(r9)     // Catch:{ all -> 0x0172 }
            java.lang.String r9 = r3.toString()     // Catch:{ all -> 0x0172 }
            com.instabug.library.util.InstabugSDKLogger.d(r1, r9)     // Catch:{ all -> 0x0172 }
            monitor-exit(r2)     // Catch:{ all -> 0x0172 }
            return r0
        L_0x0160:
            r9 = move-exception
            r0 = r3
        L_0x0162:
            r3 = r0
        L_0x0163:
            if (r3 == 0) goto L_0x0171
            r3.close()     // Catch:{ IOException -> 0x0169 }
            goto L_0x0171
        L_0x0169:
            r0 = move-exception
            java.lang.String r1 = "OnDiskCache"
            java.lang.String r3 = "Failed to close file reader"
            com.instabug.library.util.InstabugSDKLogger.e(r1, r3, r0)     // Catch:{ all -> 0x0172 }
        L_0x0171:
            throw r9     // Catch:{ all -> 0x0172 }
        L_0x0172:
            r9 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0172 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.storage.cache.OnDiskCache.get(java.lang.String):com.instabug.library.internal.storage.cache.Cacheable");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0074, code lost:
        r9 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00c4, code lost:
        if (r0 != null) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ce, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d0, code lost:
        r3 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00d3, code lost:
        com.instabug.library.util.g.a(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00d8, code lost:
        throw r9;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:20:0x005f, B:31:0x0077] */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a5 A[Catch:{ all -> 0x0074, all -> 0x00ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ac A[Catch:{ all -> 0x0074, all -> 0x00ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00cc A[Catch:{ all -> 0x0074, all -> 0x00ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d3 A[Catch:{ all -> 0x0074, all -> 0x00ce }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[Catch:{  }, RETURN, SYNTHETIC] */
    @android.annotation.SuppressLint({"RESOURCE_LEAK"})
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V put(java.lang.String r9, V r10) {
        /*
            r8 = this;
            r0 = 0
            if (r9 != 0) goto L_0x000b
            java.lang.String r9 = "OnDiskCache"
            java.lang.String r10 = "Key equal null"
            com.instabug.library.util.InstabugSDKLogger.d(r9, r10)
            return r0
        L_0x000b:
            if (r10 != 0) goto L_0x0015
            java.lang.String r9 = "OnDiskCache"
            java.lang.String r10 = "Value equal null"
            com.instabug.library.util.InstabugSDKLogger.d(r9, r10)
            return r0
        L_0x0015:
            java.io.File r1 = r8.cacheFile
            boolean r1 = r1.exists()
            if (r1 != 0) goto L_0x0025
            java.lang.String r9 = "OnDiskCache"
            java.lang.String r10 = "Cache file doesn't exist"
            com.instabug.library.util.InstabugSDKLogger.d(r9, r10)
            return r0
        L_0x0025:
            com.instabug.library.internal.storage.cache.Cacheable r1 = r8.get((java.lang.String) r9)
            if (r1 == 0) goto L_0x002e
            r8.delete((java.lang.String) r9)
        L_0x002e:
            java.io.File r2 = r8.cacheFile
            monitor-enter(r2)
            java.io.OutputStreamWriter r3 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x00ad, JSONException -> 0x00a6, OutOfMemoryError -> 0x0076 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00ad, JSONException -> 0x00a6, OutOfMemoryError -> 0x0076 }
            java.io.File r5 = r8.cacheFile     // Catch:{ IOException -> 0x00ad, JSONException -> 0x00a6, OutOfMemoryError -> 0x0076 }
            r6 = 1
            r4.<init>(r5, r6)     // Catch:{ IOException -> 0x00ad, JSONException -> 0x00a6, OutOfMemoryError -> 0x0076 }
            java.nio.charset.Charset r5 = r8.charset     // Catch:{ IOException -> 0x00ad, JSONException -> 0x00a6, OutOfMemoryError -> 0x0076 }
            r3.<init>(r4, r5)     // Catch:{ IOException -> 0x00ad, JSONException -> 0x00a6, OutOfMemoryError -> 0x0076 }
            java.io.BufferedWriter r0 = new java.io.BufferedWriter     // Catch:{ IOException -> 0x006f, JSONException -> 0x006c, OutOfMemoryError -> 0x0067, all -> 0x0064 }
            r0.<init>(r3)     // Catch:{ IOException -> 0x006f, JSONException -> 0x006c, OutOfMemoryError -> 0x0067, all -> 0x0064 }
            java.io.Writer r4 = r0.append(r9)     // Catch:{ IOException -> 0x006f, JSONException -> 0x006c, OutOfMemoryError -> 0x0067, all -> 0x0064 }
            java.lang.String r5 = ":"
            java.io.Writer r4 = r4.append(r5)     // Catch:{ IOException -> 0x006f, JSONException -> 0x006c, OutOfMemoryError -> 0x0067, all -> 0x0064 }
            java.lang.String r5 = r10.toJson()     // Catch:{ IOException -> 0x006f, JSONException -> 0x006c, OutOfMemoryError -> 0x0067, all -> 0x0064 }
            java.io.Writer r4 = r4.append(r5)     // Catch:{ IOException -> 0x006f, JSONException -> 0x006c, OutOfMemoryError -> 0x0067, all -> 0x0064 }
            java.lang.String r5 = "\n"
            r4.append(r5)     // Catch:{ IOException -> 0x006f, JSONException -> 0x006c, OutOfMemoryError -> 0x0067, all -> 0x0064 }
            r0.close()     // Catch:{ IOException -> 0x006f, JSONException -> 0x006c, OutOfMemoryError -> 0x0067, all -> 0x0064 }
            com.instabug.library.util.g.a(r3)     // Catch:{ all -> 0x00ce }
            goto L_0x00c9
        L_0x0064:
            r9 = move-exception
            goto L_0x00d1
        L_0x0067:
            r0 = move-exception
            r7 = r3
            r3 = r0
            r0 = r7
            goto L_0x0077
        L_0x006c:
            r9 = move-exception
            r0 = r3
            goto L_0x00a7
        L_0x006f:
            r0 = move-exception
            r7 = r3
            r3 = r0
            r0 = r7
            goto L_0x00ae
        L_0x0074:
            r9 = move-exception
            goto L_0x00d0
        L_0x0076:
            r3 = move-exception
        L_0x0077:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0074 }
            r4.<init>()     // Catch:{ all -> 0x0074 }
            java.lang.String r5 = "OOM while while setting value for key "
            r4.append(r5)     // Catch:{ all -> 0x0074 }
            r4.append(r9)     // Catch:{ all -> 0x0074 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0074 }
            com.instabug.library.core.InstabugCore.reportError(r3, r4)     // Catch:{ all -> 0x0074 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0074 }
            r4.<init>()     // Catch:{ all -> 0x0074 }
            java.lang.String r5 = "OOM while while setting value for key "
            r4.append(r5)     // Catch:{ all -> 0x0074 }
            r4.append(r9)     // Catch:{ all -> 0x0074 }
            java.lang.String r9 = r4.toString()     // Catch:{ all -> 0x0074 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0074 }
            com.instabug.library.util.InstabugSDKLogger.e(r9, r3)     // Catch:{ all -> 0x0074 }
            if (r0 == 0) goto L_0x00c9
            goto L_0x00c6
        L_0x00a6:
            r9 = move-exception
        L_0x00a7:
            r9.printStackTrace()     // Catch:{ all -> 0x0074 }
            if (r0 == 0) goto L_0x00c9
            goto L_0x00c6
        L_0x00ad:
            r3 = move-exception
        L_0x00ae:
            java.lang.String r4 = "OnDiskCache"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0074 }
            r5.<init>()     // Catch:{ all -> 0x0074 }
            java.lang.String r6 = "Something went wrong while setting value for key "
            r5.append(r6)     // Catch:{ all -> 0x0074 }
            r5.append(r9)     // Catch:{ all -> 0x0074 }
            java.lang.String r9 = r5.toString()     // Catch:{ all -> 0x0074 }
            com.instabug.library.util.InstabugSDKLogger.e(r4, r9, r3)     // Catch:{ all -> 0x0074 }
            if (r0 == 0) goto L_0x00c9
        L_0x00c6:
            com.instabug.library.util.g.a(r0)     // Catch:{ all -> 0x00ce }
        L_0x00c9:
            monitor-exit(r2)     // Catch:{ all -> 0x00ce }
            if (r1 == 0) goto L_0x00cd
            r10 = r1
        L_0x00cd:
            return r10
        L_0x00ce:
            r9 = move-exception
            goto L_0x00d7
        L_0x00d0:
            r3 = r0
        L_0x00d1:
            if (r3 == 0) goto L_0x00d6
            com.instabug.library.util.g.a(r3)     // Catch:{ all -> 0x00ce }
        L_0x00d6:
            throw r9     // Catch:{ all -> 0x00ce }
        L_0x00d7:
            monitor-exit(r2)     // Catch:{ all -> 0x00ce }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.storage.cache.OnDiskCache.put(java.lang.String, com.instabug.library.internal.storage.cache.Cacheable):com.instabug.library.internal.storage.cache.Cacheable");
    }

    public void delete() {
        File file = this.cacheFile;
        if (file != null && file.exists()) {
            InstabugSDKLogger.d(TAG, "Cache file  exist");
            synchronized (this.cacheFile) {
                this.cacheFile.delete();
            }
        }
    }
}

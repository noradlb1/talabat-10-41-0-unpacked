package com.google.android.gms.dynamite;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import com.huawei.hms.framework.common.ExceptionCode;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public final class DynamiteModule {
    @KeepForSdk
    public static final int LOCAL = -1;
    @KeepForSdk
    public static final int NONE = 0;
    @KeepForSdk
    public static final int NO_SELECTION = 0;
    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzi();
    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zzj();
    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzk();
    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_LOCAL = new zzg();
    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_REMOTE = new zzf();
    @NonNull
    @KeepForSdk
    public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new zzh();
    @KeepForSdk
    public static final int REMOTE = 1;
    @NonNull
    public static final VersionPolicy zza = new zzl();
    @GuardedBy("DynamiteModule.class")
    @Nullable
    private static Boolean zzb = null;
    @GuardedBy("DynamiteModule.class")
    @Nullable
    private static String zzc = null;
    @GuardedBy("DynamiteModule.class")
    private static boolean zzd = false;
    @GuardedBy("DynamiteModule.class")
    private static int zze = -1;
    @GuardedBy("DynamiteModule.class")
    @Nullable
    private static Boolean zzf;
    private static final ThreadLocal zzg = new ThreadLocal();
    private static final ThreadLocal zzh = new zzd();
    private static final VersionPolicy.IVersions zzi = new zze();
    @GuardedBy("DynamiteModule.class")
    @Nullable
    private static zzq zzk;
    @GuardedBy("DynamiteModule.class")
    @Nullable
    private static zzr zzl;
    private final Context zzj;

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        @GuardedBy("DynamiteLoaderClassLoader.class")
        @Nullable
        public static ClassLoader sClassLoader;
    }

    @KeepForSdk
    public static class LoadingException extends Exception {
        public /* synthetic */ LoadingException(String str, zzp zzp) {
            super(str);
        }

        public /* synthetic */ LoadingException(String str, Throwable th2, zzp zzp) {
            super(str, th2);
        }
    }

    public interface VersionPolicy {

        @KeepForSdk
        public interface IVersions {
            int zza(@NonNull Context context, @NonNull String str);

            int zzb(@NonNull Context context, @NonNull String str, boolean z11) throws LoadingException;
        }

        @KeepForSdk
        public static class SelectionResult {
            @KeepForSdk
            public int localVersion = 0;
            @KeepForSdk
            public int remoteVersion = 0;
            @KeepForSdk
            public int selection = 0;
        }

        @NonNull
        @KeepForSdk
        SelectionResult selectModule(@NonNull Context context, @NonNull String str, @NonNull IVersions iVersions) throws LoadingException;
    }

    private DynamiteModule(Context context) {
        Preconditions.checkNotNull(context);
        this.zzj = context;
    }

    @KeepForSdk
    public static int getLocalVersion(@NonNull Context context, @NonNull String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            Class<?> loadClass = classLoader.loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (Objects.equal(declaredField.get((Object) null), str)) {
                return declaredField2.getInt((Object) null);
            }
            String valueOf = String.valueOf(declaredField.get((Object) null));
            Log.e("DynamiteModule", "Module descriptor id '" + valueOf + "' didn't match expected id '" + str + "'");
            return 0;
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e11) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e11.getMessage())));
            return 0;
        }
    }

    @KeepForSdk
    public static int getRemoteVersion(@NonNull Context context, @NonNull String str) {
        return zza(context, str, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01c5, code lost:
        android.util.Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
        r4 = r4.zzh(com.google.android.gms.dynamic.ObjectWrapper.wrap(r20), r3, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01d4, code lost:
        r4 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01d8, code lost:
        if (r4 == null) goto L_0x01fd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01da, code lost:
        r5 = new com.google.android.gms.dynamite.DynamiteModule((android.content.Context) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01e5, code lost:
        if (r9 != 0) goto L_0x01eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01e7, code lost:
        r8.remove();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01eb, code lost:
        r8.set(java.lang.Long.valueOf(r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01f2, code lost:
        r1 = r7.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01f4, code lost:
        if (r1 == null) goto L_0x01f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01f6, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x01f9, code lost:
        r0.set(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01fc, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0205, code lost:
        throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException("Failed to load remote module.", (com.google.android.gms.dynamite.zzp) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x020e, code lost:
        throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException("Failed to create IDynamiteLoader.", (com.google.android.gms.dynamite.zzp) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x020f, code lost:
        r19 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0219, code lost:
        throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException("Failed to determine which loading route to use.", (com.google.android.gms.dynamite.zzp) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x022c, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x022e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0230, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b1, code lost:
        if (r17 == null) goto L_0x020f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b8, code lost:
        if (r17.booleanValue() == false) goto L_0x0166;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ba, code lost:
        android.util.Log.i("DynamiteModule", "Selected remote version of " + r3 + ", version >= " + r14);
        r5 = com.google.android.gms.dynamite.DynamiteModule.class;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00da, code lost:
        monitor-enter(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        r11 = zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00dd, code lost:
        monitor-exit(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00de, code lost:
        if (r11 == null) goto L_0x0154;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r5 = (com.google.android.gms.dynamite.zzn) r0.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00e6, code lost:
        if (r5 == null) goto L_0x0149;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ea, code lost:
        if (r5.zza == null) goto L_0x0149;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00ec, code lost:
        r15 = r20.getApplicationContext();
        r5 = r5.zza;
        com.google.android.gms.dynamic.ObjectWrapper.wrap(null);
        r18 = com.google.android.gms.dynamite.DynamiteModule.class;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f9, code lost:
        monitor-enter(r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00fa, code lost:
        r19 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00fe, code lost:
        if (zze < 2) goto L_0x0102;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0100, code lost:
        r12 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0102, code lost:
        r12 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0103, code lost:
        r4 = java.lang.Boolean.valueOf(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0107, code lost:
        monitor-exit(r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x010c, code lost:
        if (r4.booleanValue() == false) goto L_0x011b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x010e, code lost:
        r4 = r11.zzf(com.google.android.gms.dynamic.ObjectWrapper.wrap(r15), r3, r14, com.google.android.gms.dynamic.ObjectWrapper.wrap(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x011b, code lost:
        android.util.Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
        r4 = r11.zze(com.google.android.gms.dynamic.ObjectWrapper.wrap(r15), r3, r14, com.google.android.gms.dynamic.ObjectWrapper.wrap(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x012e, code lost:
        r4 = (android.content.Context) com.google.android.gms.dynamic.ObjectWrapper.unwrap(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0134, code lost:
        if (r4 == null) goto L_0x013d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0136, code lost:
        r5 = new com.google.android.gms.dynamite.DynamiteModule(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0145, code lost:
        throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException("Failed to get module context", (com.google.android.gms.dynamite.zzp) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0149, code lost:
        r19 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0153, code lost:
        throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException("No result cursor", (com.google.android.gms.dynamite.zzp) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0154, code lost:
        r19 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x015e, code lost:
        throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException("DynamiteLoaderV2 was not cached.", (com.google.android.gms.dynamite.zzp) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x015f, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0160, code lost:
        r19 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0164, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0166, code lost:
        r19 = r4;
        android.util.Log.i("DynamiteModule", "Selected remote version of " + r3 + ", version >= " + r14);
        r4 = zzg(r20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x018a, code lost:
        if (r4 == null) goto L_0x0206;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x018c, code lost:
        r5 = r4.zze();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0191, code lost:
        if (r5 < 3) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0193, code lost:
        r5 = (com.google.android.gms.dynamite.zzn) r0.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0199, code lost:
        if (r5 == null) goto L_0x01aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x019b, code lost:
        r4 = r4.zzi(com.google.android.gms.dynamic.ObjectWrapper.wrap(r20), r3, r14, com.google.android.gms.dynamic.ObjectWrapper.wrap(r5.zza));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01b2, code lost:
        throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException("No cached result cursor holder", (com.google.android.gms.dynamite.zzp) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01b3, code lost:
        if (r5 != 2) goto L_0x01c5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01b5, code lost:
        android.util.Log.w("DynamiteModule", "IDynamite loader version = 2");
        r4 = r4.zzj(com.google.android.gms.dynamic.ObjectWrapper.wrap(r20), r3, r14);
     */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x0283 A[Catch:{ all -> 0x02fd }] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x02ab A[SYNTHETIC, Splitter:B:165:0x02ab] */
    @com.google.errorprone.annotations.ResultIgnorabilityUnspecified
    @androidx.annotation.NonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.dynamite.DynamiteModule load(@androidx.annotation.NonNull android.content.Context r20, @androidx.annotation.NonNull com.google.android.gms.dynamite.DynamiteModule.VersionPolicy r21, @androidx.annotation.NonNull java.lang.String r22) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r1 = r20
            r2 = r21
            r3 = r22
            android.content.Context r4 = r20.getApplicationContext()
            r5 = 0
            if (r4 == 0) goto L_0x0320
            java.lang.ThreadLocal r0 = zzg
            java.lang.Object r6 = r0.get()
            com.google.android.gms.dynamite.zzn r6 = (com.google.android.gms.dynamite.zzn) r6
            com.google.android.gms.dynamite.zzn r7 = new com.google.android.gms.dynamite.zzn
            r7.<init>(r5)
            r0.set(r7)
            java.lang.ThreadLocal r8 = zzh
            java.lang.Object r9 = r8.get()
            java.lang.Long r9 = (java.lang.Long) r9
            long r9 = r9.longValue()
            long r13 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x02fd }
            java.lang.Long r13 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x02fd }
            r8.set(r13)     // Catch:{ all -> 0x02fd }
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$IVersions r13 = zzi     // Catch:{ all -> 0x02fd }
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$SelectionResult r13 = r2.selectModule(r1, r3, r13)     // Catch:{ all -> 0x02fd }
            java.lang.String r14 = "DynamiteModule"
            int r15 = r13.localVersion     // Catch:{ all -> 0x02fd }
            int r5 = r13.remoteVersion     // Catch:{ all -> 0x02fd }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x02fd }
            r11.<init>()     // Catch:{ all -> 0x02fd }
            java.lang.String r12 = "Considering local module "
            r11.append(r12)     // Catch:{ all -> 0x02fd }
            r11.append(r3)     // Catch:{ all -> 0x02fd }
            java.lang.String r12 = ":"
            r11.append(r12)     // Catch:{ all -> 0x02fd }
            r11.append(r15)     // Catch:{ all -> 0x02fd }
            java.lang.String r12 = " and remote module "
            r11.append(r12)     // Catch:{ all -> 0x02fd }
            r11.append(r3)     // Catch:{ all -> 0x02fd }
            java.lang.String r12 = ":"
            r11.append(r12)     // Catch:{ all -> 0x02fd }
            r11.append(r5)     // Catch:{ all -> 0x02fd }
            java.lang.String r5 = r11.toString()     // Catch:{ all -> 0x02fd }
            android.util.Log.i(r14, r5)     // Catch:{ all -> 0x02fd }
            int r5 = r13.selection     // Catch:{ all -> 0x02fd }
            if (r5 == 0) goto L_0x02cc
            r11 = -1
            if (r5 != r11) goto L_0x0078
            int r5 = r13.localVersion     // Catch:{ all -> 0x02fd }
            if (r5 == 0) goto L_0x02cc
            r5 = r11
        L_0x0078:
            r12 = 1
            if (r5 != r12) goto L_0x007f
            int r14 = r13.remoteVersion     // Catch:{ all -> 0x02fd }
            if (r14 == 0) goto L_0x02cc
        L_0x007f:
            if (r5 != r11) goto L_0x00a1
            com.google.android.gms.dynamite.DynamiteModule r1 = zzc(r4, r3)     // Catch:{ all -> 0x02fd }
            r2 = 0
            int r2 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x008f
            r8.remove()
            goto L_0x0096
        L_0x008f:
            java.lang.Long r2 = java.lang.Long.valueOf(r9)
            r8.set(r2)
        L_0x0096:
            android.database.Cursor r2 = r7.zza
            if (r2 == 0) goto L_0x009d
            r2.close()
        L_0x009d:
            r0.set(r6)
            return r1
        L_0x00a1:
            if (r5 != r12) goto L_0x02b4
            int r14 = r13.remoteVersion     // Catch:{ LoadingException -> 0x0253 }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r15 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r15)     // Catch:{ RemoteException -> 0x0245, LoadingException -> 0x0241, all -> 0x0232 }
            boolean r17 = zzf(r20)     // Catch:{ all -> 0x0227 }
            if (r17 == 0) goto L_0x021a
            java.lang.Boolean r17 = zzb     // Catch:{ all -> 0x0227 }
            monitor-exit(r15)     // Catch:{ all -> 0x0227 }
            if (r17 == 0) goto L_0x020f
            boolean r15 = r17.booleanValue()     // Catch:{ RemoteException -> 0x0245, LoadingException -> 0x0241, all -> 0x0232 }
            r12 = 2
            if (r15 == 0) goto L_0x0166
            java.lang.String r15 = "DynamiteModule"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x0245, LoadingException -> 0x0241, all -> 0x0232 }
            r11.<init>()     // Catch:{ RemoteException -> 0x0245, LoadingException -> 0x0241, all -> 0x0232 }
            java.lang.String r5 = "Selected remote version of "
            r11.append(r5)     // Catch:{ RemoteException -> 0x0245, LoadingException -> 0x0241, all -> 0x0232 }
            r11.append(r3)     // Catch:{ RemoteException -> 0x0245, LoadingException -> 0x0241, all -> 0x0232 }
            java.lang.String r5 = ", version >= "
            r11.append(r5)     // Catch:{ RemoteException -> 0x0245, LoadingException -> 0x0241, all -> 0x0232 }
            r11.append(r14)     // Catch:{ RemoteException -> 0x0245, LoadingException -> 0x0241, all -> 0x0232 }
            java.lang.String r5 = r11.toString()     // Catch:{ RemoteException -> 0x0245, LoadingException -> 0x0241, all -> 0x0232 }
            android.util.Log.i(r15, r5)     // Catch:{ RemoteException -> 0x0245, LoadingException -> 0x0241, all -> 0x0232 }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r5 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r5)     // Catch:{ RemoteException -> 0x0245, LoadingException -> 0x0241, all -> 0x0232 }
            com.google.android.gms.dynamite.zzr r11 = zzl     // Catch:{ all -> 0x015f }
            monitor-exit(r5)     // Catch:{ all -> 0x015f }
            if (r11 == 0) goto L_0x0154
            java.lang.Object r5 = r0.get()     // Catch:{ RemoteException -> 0x0245, LoadingException -> 0x0241, all -> 0x0232 }
            com.google.android.gms.dynamite.zzn r5 = (com.google.android.gms.dynamite.zzn) r5     // Catch:{ RemoteException -> 0x0245, LoadingException -> 0x0241, all -> 0x0232 }
            if (r5 == 0) goto L_0x0149
            android.database.Cursor r15 = r5.zza     // Catch:{ RemoteException -> 0x0245, LoadingException -> 0x0241, all -> 0x0232 }
            if (r15 == 0) goto L_0x0149
            android.content.Context r15 = r20.getApplicationContext()     // Catch:{ RemoteException -> 0x0245, LoadingException -> 0x0241, all -> 0x0232 }
            android.database.Cursor r5 = r5.zza     // Catch:{ RemoteException -> 0x0245, LoadingException -> 0x0241, all -> 0x0232 }
            r16 = 0
            com.google.android.gms.dynamic.ObjectWrapper.wrap(r16)     // Catch:{ RemoteException -> 0x0245, LoadingException -> 0x0241, all -> 0x0232 }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r18 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r18)     // Catch:{ RemoteException -> 0x0245, LoadingException -> 0x0241, all -> 0x0232 }
            r19 = r4
            int r4 = zze     // Catch:{ all -> 0x0146 }
            if (r4 < r12) goto L_0x0102
            r12 = 1
            goto L_0x0103
        L_0x0102:
            r12 = 0
        L_0x0103:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r12)     // Catch:{ all -> 0x0146 }
            monitor-exit(r18)     // Catch:{ all -> 0x0146 }
            boolean r4 = r4.booleanValue()     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            if (r4 == 0) goto L_0x011b
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r15)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r5)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            com.google.android.gms.dynamic.IObjectWrapper r4 = r11.zzf(r4, r3, r14, r5)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            goto L_0x012e
        L_0x011b:
            java.lang.String r4 = "DynamiteModule"
            java.lang.String r12 = "Dynamite loader version < 2, falling back to loadModule2"
            android.util.Log.w(r4, r12)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r15)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r5)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            com.google.android.gms.dynamic.IObjectWrapper r4 = r11.zze(r4, r3, r14, r5)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
        L_0x012e:
            java.lang.Object r4 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r4)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            android.content.Context r4 = (android.content.Context) r4     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            if (r4 == 0) goto L_0x013d
            com.google.android.gms.dynamite.DynamiteModule r5 = new com.google.android.gms.dynamite.DynamiteModule     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            r5.<init>(r4)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            goto L_0x01e1
        L_0x013d:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            java.lang.String r4 = "Failed to get module context"
            r5 = 0
            r0.<init>(r4, r5)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            throw r0     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
        L_0x0146:
            r0 = move-exception
            monitor-exit(r18)     // Catch:{ all -> 0x0146 }
            throw r0     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
        L_0x0149:
            r19 = r4
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            java.lang.String r4 = "No result cursor"
            r5 = 0
            r0.<init>(r4, r5)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            throw r0     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
        L_0x0154:
            r19 = r4
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            java.lang.String r4 = "DynamiteLoaderV2 was not cached."
            r5 = 0
            r0.<init>(r4, r5)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            throw r0     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
        L_0x015f:
            r0 = move-exception
            r19 = r4
        L_0x0162:
            monitor-exit(r5)     // Catch:{ all -> 0x0164 }
            throw r0     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
        L_0x0164:
            r0 = move-exception
            goto L_0x0162
        L_0x0166:
            r19 = r4
            java.lang.String r4 = "DynamiteModule"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            r5.<init>()     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            java.lang.String r11 = "Selected remote version of "
            r5.append(r11)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            r5.append(r3)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            java.lang.String r11 = ", version >= "
            r5.append(r11)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            r5.append(r14)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            java.lang.String r5 = r5.toString()     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            android.util.Log.i(r4, r5)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            com.google.android.gms.dynamite.zzq r4 = zzg(r20)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            if (r4 == 0) goto L_0x0206
            int r5 = r4.zze()     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            r11 = 3
            if (r5 < r11) goto L_0x01b3
            java.lang.Object r5 = r0.get()     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            com.google.android.gms.dynamite.zzn r5 = (com.google.android.gms.dynamite.zzn) r5     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            if (r5 == 0) goto L_0x01aa
            com.google.android.gms.dynamic.IObjectWrapper r11 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r20)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            android.database.Cursor r5 = r5.zza     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r5)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            com.google.android.gms.dynamic.IObjectWrapper r4 = r4.zzi(r11, r3, r14, r5)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            goto L_0x01d4
        L_0x01aa:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            java.lang.String r4 = "No cached result cursor holder"
            r5 = 0
            r0.<init>(r4, r5)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            throw r0     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
        L_0x01b3:
            if (r5 != r12) goto L_0x01c5
            java.lang.String r5 = "DynamiteModule"
            java.lang.String r11 = "IDynamite loader version = 2"
            android.util.Log.w(r5, r11)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r20)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            com.google.android.gms.dynamic.IObjectWrapper r4 = r4.zzj(r5, r3, r14)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            goto L_0x01d4
        L_0x01c5:
            java.lang.String r5 = "DynamiteModule"
            java.lang.String r11 = "Dynamite loader version < 2, falling back to createModuleContext"
            android.util.Log.w(r5, r11)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r20)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            com.google.android.gms.dynamic.IObjectWrapper r4 = r4.zzh(r5, r3, r14)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
        L_0x01d4:
            java.lang.Object r4 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r4)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            if (r4 == 0) goto L_0x01fd
            com.google.android.gms.dynamite.DynamiteModule r5 = new com.google.android.gms.dynamite.DynamiteModule     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            android.content.Context r4 = (android.content.Context) r4     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            r5.<init>(r4)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
        L_0x01e1:
            r1 = 0
            int r1 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x01eb
            r8.remove()
            goto L_0x01f2
        L_0x01eb:
            java.lang.Long r1 = java.lang.Long.valueOf(r9)
            r8.set(r1)
        L_0x01f2:
            android.database.Cursor r1 = r7.zza
            if (r1 == 0) goto L_0x01f9
            r1.close()
        L_0x01f9:
            r0.set(r6)
            return r5
        L_0x01fd:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            java.lang.String r4 = "Failed to load remote module."
            r5 = 0
            r0.<init>(r4, r5)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            throw r0     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
        L_0x0206:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            java.lang.String r4 = "Failed to create IDynamiteLoader."
            r5 = 0
            r0.<init>(r4, r5)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            throw r0     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
        L_0x020f:
            r19 = r4
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            java.lang.String r4 = "Failed to determine which loading route to use."
            r5 = 0
            r0.<init>(r4, r5)     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
            throw r0     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
        L_0x021a:
            r19 = r4
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x0225 }
            java.lang.String r4 = "Remote loading disabled"
            r5 = 0
            r0.<init>(r4, r5)     // Catch:{ all -> 0x0225 }
            throw r0     // Catch:{ all -> 0x0225 }
        L_0x0225:
            r0 = move-exception
            goto L_0x022a
        L_0x0227:
            r0 = move-exception
            r19 = r4
        L_0x022a:
            monitor-exit(r15)     // Catch:{ all -> 0x0225 }
            throw r0     // Catch:{ RemoteException -> 0x0230, LoadingException -> 0x022e, all -> 0x022c }
        L_0x022c:
            r0 = move-exception
            goto L_0x0235
        L_0x022e:
            r0 = move-exception
            goto L_0x0244
        L_0x0230:
            r0 = move-exception
            goto L_0x0248
        L_0x0232:
            r0 = move-exception
            r19 = r4
        L_0x0235:
            com.google.android.gms.common.util.CrashUtils.addDynamiteErrorToDropBox(r1, r0)     // Catch:{ LoadingException -> 0x0251 }
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r4 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ LoadingException -> 0x0251 }
            java.lang.String r5 = "Failed to load remote module."
            r8 = 0
            r4.<init>(r5, r0, r8)     // Catch:{ LoadingException -> 0x0251 }
            throw r4     // Catch:{ LoadingException -> 0x0251 }
        L_0x0241:
            r0 = move-exception
            r19 = r4
        L_0x0244:
            throw r0     // Catch:{ LoadingException -> 0x0251 }
        L_0x0245:
            r0 = move-exception
            r19 = r4
        L_0x0248:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r4 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ LoadingException -> 0x0251 }
            java.lang.String r5 = "Failed to load remote module."
            r8 = 0
            r4.<init>(r5, r0, r8)     // Catch:{ LoadingException -> 0x0251 }
            throw r4     // Catch:{ LoadingException -> 0x0251 }
        L_0x0251:
            r0 = move-exception
            goto L_0x0256
        L_0x0253:
            r0 = move-exception
            r19 = r4
        L_0x0256:
            java.lang.String r4 = "DynamiteModule"
            java.lang.String r5 = r0.getMessage()     // Catch:{ all -> 0x02fd }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x02fd }
            r8.<init>()     // Catch:{ all -> 0x02fd }
            java.lang.String r11 = "Failed to load remote module: "
            r8.append(r11)     // Catch:{ all -> 0x02fd }
            r8.append(r5)     // Catch:{ all -> 0x02fd }
            java.lang.String r5 = r8.toString()     // Catch:{ all -> 0x02fd }
            android.util.Log.w(r4, r5)     // Catch:{ all -> 0x02fd }
            int r4 = r13.localVersion     // Catch:{ all -> 0x02fd }
            if (r4 == 0) goto L_0x02ab
            com.google.android.gms.dynamite.zzo r5 = new com.google.android.gms.dynamite.zzo     // Catch:{ all -> 0x02fd }
            r8 = 0
            r5.<init>(r4, r8)     // Catch:{ all -> 0x02fd }
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$SelectionResult r1 = r2.selectModule(r1, r3, r5)     // Catch:{ all -> 0x02fd }
            int r1 = r1.selection     // Catch:{ all -> 0x02fd }
            r2 = -1
            if (r1 != r2) goto L_0x02ab
            r1 = r19
            com.google.android.gms.dynamite.DynamiteModule r0 = zzc(r1, r3)     // Catch:{ all -> 0x02fd }
            r1 = 0
            int r1 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x0295
            java.lang.ThreadLocal r1 = zzh
            r1.remove()
            goto L_0x029e
        L_0x0295:
            java.lang.ThreadLocal r1 = zzh
            java.lang.Long r2 = java.lang.Long.valueOf(r9)
            r1.set(r2)
        L_0x029e:
            android.database.Cursor r1 = r7.zza
            if (r1 == 0) goto L_0x02a5
            r1.close()
        L_0x02a5:
            java.lang.ThreadLocal r1 = zzg
            r1.set(r6)
            return r0
        L_0x02ab:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r1 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x02fd }
            java.lang.String r2 = "Remote load failed. No local fallback found."
            r3 = 0
            r1.<init>(r2, r0, r3)     // Catch:{ all -> 0x02fd }
            throw r1     // Catch:{ all -> 0x02fd }
        L_0x02b4:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x02fd }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x02fd }
            r1.<init>()     // Catch:{ all -> 0x02fd }
            java.lang.String r2 = "VersionPolicy returned invalid code:"
            r1.append(r2)     // Catch:{ all -> 0x02fd }
            r1.append(r5)     // Catch:{ all -> 0x02fd }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x02fd }
            r2 = 0
            r0.<init>(r1, r2)     // Catch:{ all -> 0x02fd }
            throw r0     // Catch:{ all -> 0x02fd }
        L_0x02cc:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x02fd }
            int r1 = r13.localVersion     // Catch:{ all -> 0x02fd }
            int r2 = r13.remoteVersion     // Catch:{ all -> 0x02fd }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x02fd }
            r4.<init>()     // Catch:{ all -> 0x02fd }
            java.lang.String r5 = "No acceptable module "
            r4.append(r5)     // Catch:{ all -> 0x02fd }
            r4.append(r3)     // Catch:{ all -> 0x02fd }
            java.lang.String r3 = " found. Local version is "
            r4.append(r3)     // Catch:{ all -> 0x02fd }
            r4.append(r1)     // Catch:{ all -> 0x02fd }
            java.lang.String r1 = " and remote version is "
            r4.append(r1)     // Catch:{ all -> 0x02fd }
            r4.append(r2)     // Catch:{ all -> 0x02fd }
            java.lang.String r1 = "."
            r4.append(r1)     // Catch:{ all -> 0x02fd }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x02fd }
            r2 = 0
            r0.<init>(r1, r2)     // Catch:{ all -> 0x02fd }
            throw r0     // Catch:{ all -> 0x02fd }
        L_0x02fd:
            r0 = move-exception
            r1 = 0
            int r1 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x030a
            java.lang.ThreadLocal r1 = zzh
            r1.remove()
            goto L_0x0313
        L_0x030a:
            java.lang.ThreadLocal r1 = zzh
            java.lang.Long r2 = java.lang.Long.valueOf(r9)
            r1.set(r2)
        L_0x0313:
            android.database.Cursor r1 = r7.zza
            if (r1 == 0) goto L_0x031a
            r1.close()
        L_0x031a:
            java.lang.ThreadLocal r1 = zzg
            r1.set(r6)
            throw r0
        L_0x0320:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException
            java.lang.String r1 = "null application Context"
            r2 = 0
            r0.<init>(r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.load(android.content.Context, com.google.android.gms.dynamite.DynamiteModule$VersionPolicy, java.lang.String):com.google.android.gms.dynamite.DynamiteModule");
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:31:0x0056=Splitter:B:31:0x0056, B:50:0x009a=Splitter:B:50:0x009a, B:17:0x003b=Splitter:B:17:0x003b} */
    public static int zza(@androidx.annotation.NonNull android.content.Context r10, @androidx.annotation.NonNull java.lang.String r11, boolean r12) {
        /*
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r0 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r0)     // Catch:{ all -> 0x01c2 }
            java.lang.Boolean r1 = zzb     // Catch:{ all -> 0x01bf }
            r2 = 0
            r3 = 0
            if (r1 != 0) goto L_0x00d8
            android.content.Context r1 = r10.getApplicationContext()     // Catch:{ ClassNotFoundException -> 0x00b9, IllegalAccessException -> 0x00b7, NoSuchFieldException -> 0x00b5 }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x00b9, IllegalAccessException -> 0x00b7, NoSuchFieldException -> 0x00b5 }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule$DynamiteLoaderClassLoader> r4 = com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class
            java.lang.String r4 = r4.getName()     // Catch:{ ClassNotFoundException -> 0x00b9, IllegalAccessException -> 0x00b7, NoSuchFieldException -> 0x00b5 }
            java.lang.Class r1 = r1.loadClass(r4)     // Catch:{ ClassNotFoundException -> 0x00b9, IllegalAccessException -> 0x00b7, NoSuchFieldException -> 0x00b5 }
            java.lang.String r4 = "sClassLoader"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r4)     // Catch:{ ClassNotFoundException -> 0x00b9, IllegalAccessException -> 0x00b7, NoSuchFieldException -> 0x00b5 }
            java.lang.Class r4 = r1.getDeclaringClass()     // Catch:{ ClassNotFoundException -> 0x00b9, IllegalAccessException -> 0x00b7, NoSuchFieldException -> 0x00b5 }
            monitor-enter(r4)     // Catch:{ ClassNotFoundException -> 0x00b9, IllegalAccessException -> 0x00b7, NoSuchFieldException -> 0x00b5 }
            java.lang.Object r5 = r1.get(r2)     // Catch:{ all -> 0x00b2 }
            java.lang.ClassLoader r5 = (java.lang.ClassLoader) r5     // Catch:{ all -> 0x00b2 }
            java.lang.ClassLoader r6 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00b2 }
            if (r5 != r6) goto L_0x0036
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00b2 }
            goto L_0x00b0
        L_0x0036:
            if (r5 == 0) goto L_0x003f
            zzd(r5)     // Catch:{ LoadingException -> 0x003b }
        L_0x003b:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00b2 }
            goto L_0x00b0
        L_0x003f:
            boolean r5 = zzf(r10)     // Catch:{ all -> 0x00b2 }
            if (r5 != 0) goto L_0x0048
            monitor-exit(r4)     // Catch:{ all -> 0x00b2 }
            monitor-exit(r0)     // Catch:{ all -> 0x01bf }
            return r3
        L_0x0048:
            boolean r5 = zzd     // Catch:{ all -> 0x00b2 }
            if (r5 != 0) goto L_0x00a7
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00b2 }
            boolean r6 = r5.equals(r2)     // Catch:{ all -> 0x00b2 }
            if (r6 == 0) goto L_0x0055
            goto L_0x00a7
        L_0x0055:
            r6 = 1
            int r6 = zzb(r10, r11, r12, r6)     // Catch:{ LoadingException -> 0x009d }
            java.lang.String r7 = zzc     // Catch:{ LoadingException -> 0x009d }
            if (r7 == 0) goto L_0x009a
            boolean r7 = r7.isEmpty()     // Catch:{ LoadingException -> 0x009d }
            if (r7 == 0) goto L_0x0065
            goto L_0x009a
        L_0x0065:
            java.lang.ClassLoader r7 = com.google.android.gms.dynamite.zzb.zza()     // Catch:{ LoadingException -> 0x009d }
            if (r7 == 0) goto L_0x006c
            goto L_0x008f
        L_0x006c:
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch:{ LoadingException -> 0x009d }
            r8 = 29
            if (r7 < r8) goto L_0x0081
            dalvik.system.DelegateLastClassLoader r7 = new dalvik.system.DelegateLastClassLoader     // Catch:{ LoadingException -> 0x009d }
            java.lang.String r8 = zzc     // Catch:{ LoadingException -> 0x009d }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ LoadingException -> 0x009d }
            java.lang.ClassLoader r9 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x009d }
            r7.<init>(r8, r9)     // Catch:{ LoadingException -> 0x009d }
            goto L_0x008f
        L_0x0081:
            com.google.android.gms.dynamite.zzc r7 = new com.google.android.gms.dynamite.zzc     // Catch:{ LoadingException -> 0x009d }
            java.lang.String r8 = zzc     // Catch:{ LoadingException -> 0x009d }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)     // Catch:{ LoadingException -> 0x009d }
            java.lang.ClassLoader r9 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x009d }
            r7.<init>(r8, r9)     // Catch:{ LoadingException -> 0x009d }
        L_0x008f:
            zzd(r7)     // Catch:{ LoadingException -> 0x009d }
            r1.set(r2, r7)     // Catch:{ LoadingException -> 0x009d }
            zzb = r5     // Catch:{ LoadingException -> 0x009d }
            monitor-exit(r4)     // Catch:{ all -> 0x00b2 }
            monitor-exit(r0)     // Catch:{ all -> 0x01bf }
            return r6
        L_0x009a:
            monitor-exit(r4)     // Catch:{ all -> 0x00b2 }
            monitor-exit(r0)     // Catch:{ all -> 0x01bf }
            return r6
        L_0x009d:
            java.lang.ClassLoader r5 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00b2 }
            r1.set(r2, r5)     // Catch:{ all -> 0x00b2 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00b2 }
            goto L_0x00b0
        L_0x00a7:
            java.lang.ClassLoader r5 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00b2 }
            r1.set(r2, r5)     // Catch:{ all -> 0x00b2 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00b2 }
        L_0x00b0:
            monitor-exit(r4)     // Catch:{ all -> 0x00b2 }
            goto L_0x00d6
        L_0x00b2:
            r1 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00b2 }
            throw r1     // Catch:{ ClassNotFoundException -> 0x00b9, IllegalAccessException -> 0x00b7, NoSuchFieldException -> 0x00b5 }
        L_0x00b5:
            r1 = move-exception
            goto L_0x00ba
        L_0x00b7:
            r1 = move-exception
            goto L_0x00ba
        L_0x00b9:
            r1 = move-exception
        L_0x00ba:
            java.lang.String r4 = "DynamiteModule"
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01bf }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01bf }
            r5.<init>()     // Catch:{ all -> 0x01bf }
            java.lang.String r6 = "Failed to load module via V2: "
            r5.append(r6)     // Catch:{ all -> 0x01bf }
            r5.append(r1)     // Catch:{ all -> 0x01bf }
            java.lang.String r1 = r5.toString()     // Catch:{ all -> 0x01bf }
            android.util.Log.w(r4, r1)     // Catch:{ all -> 0x01bf }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x01bf }
        L_0x00d6:
            zzb = r1     // Catch:{ all -> 0x01bf }
        L_0x00d8:
            monitor-exit(r0)     // Catch:{ all -> 0x01bf }
            boolean r0 = r1.booleanValue()     // Catch:{ all -> 0x01c2 }
            if (r0 == 0) goto L_0x0100
            int r10 = zzb(r10, r11, r12, r3)     // Catch:{ LoadingException -> 0x00e4 }
            return r10
        L_0x00e4:
            r11 = move-exception
            java.lang.String r12 = "DynamiteModule"
            java.lang.String r11 = r11.getMessage()     // Catch:{ all -> 0x01c2 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c2 }
            r0.<init>()     // Catch:{ all -> 0x01c2 }
            java.lang.String r1 = "Failed to retrieve remote module version: "
            r0.append(r1)     // Catch:{ all -> 0x01c2 }
            r0.append(r11)     // Catch:{ all -> 0x01c2 }
            java.lang.String r11 = r0.toString()     // Catch:{ all -> 0x01c2 }
            android.util.Log.w(r12, r11)     // Catch:{ all -> 0x01c2 }
            return r3
        L_0x0100:
            com.google.android.gms.dynamite.zzq r4 = zzg(r10)     // Catch:{ all -> 0x01c2 }
            if (r4 != 0) goto L_0x0108
            goto L_0x01b6
        L_0x0108:
            int r0 = r4.zze()     // Catch:{ RemoteException -> 0x0195 }
            r1 = 3
            if (r0 < r1) goto L_0x0170
            java.lang.ThreadLocal r0 = zzg     // Catch:{ RemoteException -> 0x0195 }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x0195 }
            com.google.android.gms.dynamite.zzn r0 = (com.google.android.gms.dynamite.zzn) r0     // Catch:{ RemoteException -> 0x0195 }
            if (r0 == 0) goto L_0x0123
            android.database.Cursor r0 = r0.zza     // Catch:{ RemoteException -> 0x0195 }
            if (r0 == 0) goto L_0x0123
            int r3 = r0.getInt(r3)     // Catch:{ RemoteException -> 0x0195 }
            goto L_0x01b6
        L_0x0123:
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x0195 }
            java.lang.ThreadLocal r0 = zzh     // Catch:{ RemoteException -> 0x0195 }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x0195 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ RemoteException -> 0x0195 }
            long r8 = r0.longValue()     // Catch:{ RemoteException -> 0x0195 }
            r6 = r11
            r7 = r12
            com.google.android.gms.dynamic.IObjectWrapper r11 = r4.zzk(r5, r6, r7, r8)     // Catch:{ RemoteException -> 0x0195 }
            java.lang.Object r11 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r11)     // Catch:{ RemoteException -> 0x0195 }
            android.database.Cursor r11 = (android.database.Cursor) r11     // Catch:{ RemoteException -> 0x0195 }
            if (r11 == 0) goto L_0x015d
            boolean r12 = r11.moveToFirst()     // Catch:{ RemoteException -> 0x016d, all -> 0x016a }
            if (r12 != 0) goto L_0x0148
            goto L_0x015d
        L_0x0148:
            int r12 = r11.getInt(r3)     // Catch:{ RemoteException -> 0x016d, all -> 0x016a }
            if (r12 <= 0) goto L_0x0155
            boolean r0 = zze(r11)     // Catch:{ RemoteException -> 0x016d, all -> 0x016a }
            if (r0 == 0) goto L_0x0155
            goto L_0x0156
        L_0x0155:
            r2 = r11
        L_0x0156:
            if (r2 == 0) goto L_0x015b
            r2.close()     // Catch:{ all -> 0x01c2 }
        L_0x015b:
            r3 = r12
            goto L_0x01b6
        L_0x015d:
            java.lang.String r12 = "DynamiteModule"
            java.lang.String r0 = "Failed to retrieve remote module version."
            android.util.Log.w(r12, r0)     // Catch:{ RemoteException -> 0x016d, all -> 0x016a }
            if (r11 == 0) goto L_0x01b6
            r11.close()     // Catch:{ all -> 0x01c2 }
            goto L_0x01b6
        L_0x016a:
            r12 = move-exception
            r2 = r11
            goto L_0x01b9
        L_0x016d:
            r12 = move-exception
            r2 = r11
            goto L_0x0197
        L_0x0170:
            r1 = 2
            if (r0 != r1) goto L_0x0183
            java.lang.String r0 = "DynamiteModule"
            java.lang.String r1 = "IDynamite loader version = 2, no high precision latency measurement."
            android.util.Log.w(r0, r1)     // Catch:{ RemoteException -> 0x0195 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x0195 }
            int r3 = r4.zzg(r0, r11, r12)     // Catch:{ RemoteException -> 0x0195 }
            goto L_0x01b6
        L_0x0183:
            java.lang.String r0 = "DynamiteModule"
            java.lang.String r1 = "IDynamite loader version < 2, falling back to getModuleVersion2"
            android.util.Log.w(r0, r1)     // Catch:{ RemoteException -> 0x0195 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x0195 }
            int r3 = r4.zzf(r0, r11, r12)     // Catch:{ RemoteException -> 0x0195 }
            goto L_0x01b6
        L_0x0193:
            r12 = r11
            goto L_0x01b9
        L_0x0195:
            r11 = move-exception
            r12 = r11
        L_0x0197:
            java.lang.String r11 = "DynamiteModule"
            java.lang.String r12 = r12.getMessage()     // Catch:{ all -> 0x01b7 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b7 }
            r0.<init>()     // Catch:{ all -> 0x01b7 }
            java.lang.String r1 = "Failed to retrieve remote module version: "
            r0.append(r1)     // Catch:{ all -> 0x01b7 }
            r0.append(r12)     // Catch:{ all -> 0x01b7 }
            java.lang.String r12 = r0.toString()     // Catch:{ all -> 0x01b7 }
            android.util.Log.w(r11, r12)     // Catch:{ all -> 0x01b7 }
            if (r2 == 0) goto L_0x01b6
            r2.close()     // Catch:{ all -> 0x01c2 }
        L_0x01b6:
            return r3
        L_0x01b7:
            r11 = move-exception
            goto L_0x0193
        L_0x01b9:
            if (r2 == 0) goto L_0x01be
            r2.close()     // Catch:{ all -> 0x01c2 }
        L_0x01be:
            throw r12     // Catch:{ all -> 0x01c2 }
        L_0x01bf:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x01bf }
            throw r11     // Catch:{ all -> 0x01c2 }
        L_0x01c2:
            r11 = move-exception
            com.google.android.gms.common.util.CrashUtils.addDynamiteErrorToDropBox(r10, r11)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zza(android.content.Context, java.lang.String, boolean):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x00bc A[Catch:{ all -> 0x00d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00bd A[Catch:{ all -> 0x00d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00dc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzb(android.content.Context r10, java.lang.String r11, boolean r12, boolean r13) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r0 = 0
            java.lang.ThreadLocal r1 = zzh     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            long r1 = r1.longValue()     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.String r10 = "api_force_staging"
            java.lang.String r4 = "api"
            r9 = 1
            if (r9 == r12) goto L_0x0019
            r10 = r4
        L_0x0019:
            android.net.Uri$Builder r12 = new android.net.Uri$Builder     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            r12.<init>()     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.String r4 = "content"
            android.net.Uri$Builder r12 = r12.scheme(r4)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.String r4 = "com.google.android.gms.chimera"
            android.net.Uri$Builder r12 = r12.authority(r4)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            android.net.Uri$Builder r10 = r12.path(r10)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            android.net.Uri$Builder r10 = r10.appendPath(r11)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.String r11 = "requestStartTime"
            java.lang.String r12 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            android.net.Uri$Builder r10 = r10.appendQueryParameter(r11, r12)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            android.net.Uri r4 = r10.build()     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            if (r10 == 0) goto L_0x00a3
            boolean r11 = r10.moveToFirst()     // Catch:{ Exception -> 0x009b }
            if (r11 == 0) goto L_0x00a3
            r11 = 0
            int r12 = r10.getInt(r11)     // Catch:{ Exception -> 0x009b }
            if (r12 <= 0) goto L_0x008e
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r1 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r1)     // Catch:{ Exception -> 0x009b }
            r2 = 2
            java.lang.String r2 = r10.getString(r2)     // Catch:{ all -> 0x008b }
            zzc = r2     // Catch:{ all -> 0x008b }
            java.lang.String r2 = "loaderVersion"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x008b }
            if (r2 < 0) goto L_0x006f
            int r2 = r10.getInt(r2)     // Catch:{ all -> 0x008b }
            zze = r2     // Catch:{ all -> 0x008b }
        L_0x006f:
            java.lang.String r2 = "disableStandaloneDynamiteLoader2"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x008b }
            if (r2 < 0) goto L_0x0082
            int r2 = r10.getInt(r2)     // Catch:{ all -> 0x008b }
            if (r2 == 0) goto L_0x007e
            goto L_0x007f
        L_0x007e:
            r9 = r11
        L_0x007f:
            zzd = r9     // Catch:{ all -> 0x008b }
            r11 = r9
        L_0x0082:
            monitor-exit(r1)     // Catch:{ all -> 0x008b }
            boolean r1 = zze(r10)     // Catch:{ Exception -> 0x009b }
            if (r1 == 0) goto L_0x008e
            r10 = r0
            goto L_0x008e
        L_0x008b:
            r11 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x008b }
            throw r11     // Catch:{ Exception -> 0x009b }
        L_0x008e:
            if (r13 == 0) goto L_0x009d
            if (r11 != 0) goto L_0x0093
            goto L_0x009d
        L_0x0093:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r11 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x009b }
            java.lang.String r12 = "forcing fallback to container DynamiteLoader impl"
            r11.<init>(r12, r0)     // Catch:{ Exception -> 0x009b }
            throw r11     // Catch:{ Exception -> 0x009b }
        L_0x009b:
            r11 = move-exception
            goto L_0x00b8
        L_0x009d:
            if (r10 == 0) goto L_0x00a2
            r10.close()
        L_0x00a2:
            return r12
        L_0x00a3:
            java.lang.String r11 = "DynamiteModule"
            java.lang.String r12 = "Failed to retrieve remote module version."
            android.util.Log.w(r11, r12)     // Catch:{ Exception -> 0x009b }
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r11 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x009b }
            java.lang.String r12 = "Failed to connect to dynamite module ContentResolver."
            r11.<init>(r12, r0)     // Catch:{ Exception -> 0x009b }
            throw r11     // Catch:{ Exception -> 0x009b }
        L_0x00b2:
            r10 = move-exception
            r11 = r10
            goto L_0x00da
        L_0x00b5:
            r10 = move-exception
            r11 = r10
            r10 = r0
        L_0x00b8:
            boolean r12 = r11 instanceof com.google.android.gms.dynamite.DynamiteModule.LoadingException     // Catch:{ all -> 0x00d8 }
            if (r12 == 0) goto L_0x00bd
            throw r11     // Catch:{ all -> 0x00d8 }
        L_0x00bd:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r12 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x00d8 }
            java.lang.String r13 = r11.getMessage()     // Catch:{ all -> 0x00d8 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d8 }
            r1.<init>()     // Catch:{ all -> 0x00d8 }
            java.lang.String r2 = "V2 version check failed: "
            r1.append(r2)     // Catch:{ all -> 0x00d8 }
            r1.append(r13)     // Catch:{ all -> 0x00d8 }
            java.lang.String r13 = r1.toString()     // Catch:{ all -> 0x00d8 }
            r12.<init>(r13, r11, r0)     // Catch:{ all -> 0x00d8 }
            throw r12     // Catch:{ all -> 0x00d8 }
        L_0x00d8:
            r11 = move-exception
            r0 = r10
        L_0x00da:
            if (r0 == 0) goto L_0x00df
            r0.close()
        L_0x00df:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzb(android.content.Context, java.lang.String, boolean, boolean):int");
    }

    private static DynamiteModule zzc(Context context, String str) {
        Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
        return new DynamiteModule(context);
    }

    @GuardedBy("DynamiteModule.class")
    private static void zzd(ClassLoader classLoader) throws LoadingException {
        zzr zzr;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzr = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof zzr) {
                    zzr = (zzr) queryLocalInterface;
                } else {
                    zzr = new zzr(iBinder);
                }
            }
            zzl = zzr;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e11) {
            throw new LoadingException("Failed to instantiate dynamite loader", e11, (zzp) null);
        }
    }

    private static boolean zze(Cursor cursor) {
        zzn zzn = (zzn) zzg.get();
        if (zzn == null || zzn.zza != null) {
            return false;
        }
        zzn.zza = cursor;
        return true;
    }

    @GuardedBy("DynamiteModule.class")
    private static boolean zzf(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals((Object) null) || bool.equals(zzf)) {
            return true;
        }
        boolean z11 = false;
        if (zzf == null) {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, ExceptionCode.CRASH_EXCEPTION) == 0 && resolveContentProvider != null && "com.google.android.gms".equals(resolveContentProvider.packageName)) {
                z11 = true;
            }
            Boolean valueOf = Boolean.valueOf(z11);
            zzf = valueOf;
            z11 = valueOf.booleanValue();
            if (z11 && (applicationInfo = resolveContentProvider.applicationInfo) != null && (applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                zzd = true;
            }
        }
        if (!z11) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z11;
    }

    @Nullable
    private static zzq zzg(Context context) {
        zzq zzq;
        synchronized (DynamiteModule.class) {
            zzq zzq2 = zzk;
            if (zzq2 != null) {
                return zzq2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzq = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    if (queryLocalInterface instanceof zzq) {
                        zzq = (zzq) queryLocalInterface;
                    } else {
                        zzq = new zzq(iBinder);
                    }
                }
                if (zzq != null) {
                    zzk = zzq;
                    return zzq;
                }
            } catch (Exception e11) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e11.getMessage());
            }
        }
        return null;
    }

    @ResultIgnorabilityUnspecified
    @NonNull
    @KeepForSdk
    public Context getModuleContext() {
        return this.zzj;
    }

    @NonNull
    @KeepForSdk
    public IBinder instantiate(@NonNull String str) throws LoadingException {
        try {
            return (IBinder) this.zzj.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e11) {
            throw new LoadingException("Failed to instantiate module class: ".concat(String.valueOf(str)), e11, (zzp) null);
        }
    }
}

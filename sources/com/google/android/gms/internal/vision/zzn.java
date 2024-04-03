package com.google.android.gms.internal.vision;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import javax.annotation.concurrent.GuardedBy;

public abstract class zzn<T> {
    private static String PREFIX = "com.google.android.gms.vision.dynamite";
    private final Object lock = new Object();
    private final String tag;
    private final String zzde;
    private final String zzdf;
    private final boolean zzdg;
    private boolean zzdh;
    private boolean zzdi;
    @GuardedBy("lock")
    private T zzdj;
    private final Context zze;

    public zzn(Context context, String str, String str2) {
        boolean z11;
        boolean z12 = false;
        this.zzdh = false;
        this.zzdi = false;
        this.zze = context;
        this.tag = str;
        String str3 = PREFIX;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + 1 + String.valueOf(str2).length());
        sb2.append(str3);
        sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
        sb2.append(str2);
        this.zzde = sb2.toString();
        this.zzdf = str2;
        if (context != null) {
            zzbe.maybeInit(context);
            Boolean valueOf = Boolean.valueOf(zzkv.zzjp());
            Boolean bool = Boolean.TRUE;
            zzdg zza = zzdg.zza("barcode", valueOf, "face", bool, "ica", Boolean.valueOf(zzkv.zzjq()), "ocr", bool);
            if (!zza.containsKey(str2) || !((Boolean) zza.get(str2)).booleanValue()) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                z12 = true;
            }
        }
        this.zzdg = z12;
    }

    public final boolean isOperational() {
        return zzp() != null;
    }

    public abstract T zza(DynamiteModule dynamiteModule, Context context) throws RemoteException, DynamiteModule.LoadingException;

    public abstract void zzn() throws RemoteException;

    public final void zzo() {
        synchronized (this.lock) {
            if (this.zzdj != null) {
                try {
                    zzn();
                } catch (RemoteException e11) {
                    Log.e(this.tag, "Could not finalize native handle", e11);
                }
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:10|11|(3:17|(1:19)|20)) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r2 = com.google.android.gms.internal.vision.zzr.zza(r7.zze, r7.zzdf, r7.zzdg);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0029, code lost:
        r4 = java.lang.String.valueOf(r7.zzdf);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
        if (r4.length() != 0) goto L_0x0037;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0037, code lost:
        "Broadcasting download intent for dependency ".concat(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003a, code lost:
        r3 = r7.zzdf;
        r4 = new android.content.Intent();
        r4.setClassName("com.google.android.gms", "com.google.android.gms.vision.DependencyBroadcastReceiverProxy");
        r4.putExtra("com.google.android.gms.vision.DEPENDENCIES", r3);
        r4.setAction("com.google.android.gms.vision.DEPENDENCY");
        r7.zze.sendBroadcast(r4);
        r7.zzdh = true;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0015 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T zzp() {
        /*
            r7 = this;
            java.lang.Object r0 = r7.lock
            monitor-enter(r0)
            T r1 = r7.zzdj     // Catch:{ all -> 0x0091 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0091 }
            return r1
        L_0x0009:
            r1 = 1
            android.content.Context r2 = r7.zze     // Catch:{ LoadingException -> 0x0015 }
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy r3 = com.google.android.gms.dynamite.DynamiteModule.PREFER_HIGHEST_OR_REMOTE_VERSION     // Catch:{ LoadingException -> 0x0015 }
            java.lang.String r4 = r7.zzde     // Catch:{ LoadingException -> 0x0015 }
            com.google.android.gms.dynamite.DynamiteModule r2 = com.google.android.gms.dynamite.DynamiteModule.load(r2, r3, r4)     // Catch:{ LoadingException -> 0x0015 }
            goto L_0x0059
        L_0x0015:
            android.content.Context r2 = r7.zze     // Catch:{ all -> 0x0091 }
            java.lang.String r3 = r7.zzdf     // Catch:{ all -> 0x0091 }
            boolean r4 = r7.zzdg     // Catch:{ all -> 0x0091 }
            com.google.android.gms.dynamite.DynamiteModule r2 = com.google.android.gms.internal.vision.zzr.zza(r2, r3, r4)     // Catch:{ all -> 0x0091 }
            if (r2 != 0) goto L_0x0059
            boolean r3 = r7.zzdg     // Catch:{ all -> 0x0091 }
            if (r3 == 0) goto L_0x0059
            boolean r3 = r7.zzdh     // Catch:{ all -> 0x0091 }
            if (r3 != 0) goto L_0x0059
            java.lang.String r3 = "Broadcasting download intent for dependency "
            java.lang.String r4 = r7.zzdf     // Catch:{ all -> 0x0091 }
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0091 }
            int r5 = r4.length()     // Catch:{ all -> 0x0091 }
            if (r5 == 0) goto L_0x003a
            r3.concat(r4)     // Catch:{ all -> 0x0091 }
        L_0x003a:
            java.lang.String r3 = r7.zzdf     // Catch:{ all -> 0x0091 }
            android.content.Intent r4 = new android.content.Intent     // Catch:{ all -> 0x0091 }
            r4.<init>()     // Catch:{ all -> 0x0091 }
            java.lang.String r5 = "com.google.android.gms"
            java.lang.String r6 = "com.google.android.gms.vision.DependencyBroadcastReceiverProxy"
            r4.setClassName(r5, r6)     // Catch:{ all -> 0x0091 }
            java.lang.String r5 = "com.google.android.gms.vision.DEPENDENCIES"
            r4.putExtra(r5, r3)     // Catch:{ all -> 0x0091 }
            java.lang.String r3 = "com.google.android.gms.vision.DEPENDENCY"
            r4.setAction(r3)     // Catch:{ all -> 0x0091 }
            android.content.Context r3 = r7.zze     // Catch:{ all -> 0x0091 }
            r3.sendBroadcast(r4)     // Catch:{ all -> 0x0091 }
            r7.zzdh = r1     // Catch:{ all -> 0x0091 }
        L_0x0059:
            if (r2 == 0) goto L_0x006e
            android.content.Context r3 = r7.zze     // Catch:{ LoadingException -> 0x0066, RemoteException -> 0x0064 }
            java.lang.Object r2 = r7.zza(r2, r3)     // Catch:{ LoadingException -> 0x0066, RemoteException -> 0x0064 }
            r7.zzdj = r2     // Catch:{ LoadingException -> 0x0066, RemoteException -> 0x0064 }
            goto L_0x006e
        L_0x0064:
            r2 = move-exception
            goto L_0x0067
        L_0x0066:
            r2 = move-exception
        L_0x0067:
            java.lang.String r3 = r7.tag     // Catch:{ all -> 0x0091 }
            java.lang.String r4 = "Error creating remote native handle"
            android.util.Log.e(r3, r4, r2)     // Catch:{ all -> 0x0091 }
        L_0x006e:
            boolean r2 = r7.zzdi     // Catch:{ all -> 0x0091 }
            if (r2 != 0) goto L_0x0080
            T r3 = r7.zzdj     // Catch:{ all -> 0x0091 }
            if (r3 != 0) goto L_0x0080
            java.lang.String r2 = r7.tag     // Catch:{ all -> 0x0091 }
            java.lang.String r3 = "Native handle not yet available. Reverting to no-op handle."
            android.util.Log.w(r2, r3)     // Catch:{ all -> 0x0091 }
            r7.zzdi = r1     // Catch:{ all -> 0x0091 }
            goto L_0x008d
        L_0x0080:
            if (r2 == 0) goto L_0x008d
            T r1 = r7.zzdj     // Catch:{ all -> 0x0091 }
            if (r1 == 0) goto L_0x008d
            java.lang.String r1 = r7.tag     // Catch:{ all -> 0x0091 }
            java.lang.String r2 = "Native handle is now available."
            android.util.Log.w(r1, r2)     // Catch:{ all -> 0x0091 }
        L_0x008d:
            T r1 = r7.zzdj     // Catch:{ all -> 0x0091 }
            monitor-exit(r0)     // Catch:{ all -> 0x0091 }
            return r1
        L_0x0091:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0091 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzn.zzp():java.lang.Object");
    }
}

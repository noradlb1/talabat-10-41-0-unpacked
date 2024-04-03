package com.google.android.gms.maps;

import android.content.Context;
import androidx.annotation.NonNull;

public final class MapsInitializer {
    private static final String zza = "MapsInitializer";
    private static boolean zzb = false;
    private static Renderer zzc = Renderer.LEGACY;

    public enum Renderer {
        LEGACY,
        LATEST
    }

    private MapsInitializer() {
    }

    public static synchronized int initialize(@NonNull Context context) {
        int initialize;
        synchronized (MapsInitializer.class) {
            initialize = initialize(context, (Renderer) null, (OnMapsSdkInitializedCallback) null);
        }
        return initialize;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0070, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001e, code lost:
        return 0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0049 A[Catch:{ RemoteException -> 0x0071, RemoteException -> 0x0055 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006a A[Catch:{ RemoteException -> 0x0071, RemoteException -> 0x0055 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized int initialize(@androidx.annotation.NonNull android.content.Context r5, @androidx.annotation.Nullable com.google.android.gms.maps.MapsInitializer.Renderer r6, @androidx.annotation.Nullable com.google.android.gms.maps.OnMapsSdkInitializedCallback r7) {
        /*
            java.lang.Class<com.google.android.gms.maps.MapsInitializer> r0 = com.google.android.gms.maps.MapsInitializer.class
            monitor-enter(r0)
            java.lang.String r1 = "Context is null"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r5, r1)     // Catch:{ all -> 0x007d }
            java.lang.String r1 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x007d }
            java.lang.String r2 = "preferredRenderer: "
            r2.concat(r1)     // Catch:{ all -> 0x007d }
            boolean r1 = zzb     // Catch:{ all -> 0x007d }
            r2 = 0
            if (r1 == 0) goto L_0x001f
            if (r7 == 0) goto L_0x001d
            com.google.android.gms.maps.MapsInitializer$Renderer r5 = zzc     // Catch:{ all -> 0x007d }
            r7.onMapsSdkInitialized(r5)     // Catch:{ all -> 0x007d }
        L_0x001d:
            monitor-exit(r0)
            return r2
        L_0x001f:
            com.google.android.gms.maps.internal.zzf r1 = com.google.android.gms.maps.internal.zzcc.zza(r5, r6)     // Catch:{ GooglePlayServicesNotAvailableException -> 0x0078 }
            com.google.android.gms.maps.internal.ICameraUpdateFactoryDelegate r3 = r1.zze()     // Catch:{ RemoteException -> 0x0071 }
            com.google.android.gms.maps.CameraUpdateFactory.zza(r3)     // Catch:{ RemoteException -> 0x0071 }
            com.google.android.gms.internal.maps.zzi r3 = r1.zzj()     // Catch:{ RemoteException -> 0x0071 }
            com.google.android.gms.maps.model.BitmapDescriptorFactory.zza(r3)     // Catch:{ RemoteException -> 0x0071 }
            r3 = 1
            zzb = r3     // Catch:{ all -> 0x007d }
            r4 = 2
            if (r6 == 0) goto L_0x0042
            int r6 = r6.ordinal()     // Catch:{ all -> 0x007d }
            if (r6 == 0) goto L_0x0043
            if (r6 == r3) goto L_0x0040
            goto L_0x0042
        L_0x0040:
            r3 = r4
            goto L_0x0043
        L_0x0042:
            r3 = r2
        L_0x0043:
            int r6 = r1.zzd()     // Catch:{ RemoteException -> 0x0055 }
            if (r6 != r4) goto L_0x004d
            com.google.android.gms.maps.MapsInitializer$Renderer r6 = com.google.android.gms.maps.MapsInitializer.Renderer.LATEST     // Catch:{ RemoteException -> 0x0055 }
            zzc = r6     // Catch:{ RemoteException -> 0x0055 }
        L_0x004d:
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r5)     // Catch:{ RemoteException -> 0x0055 }
            r1.zzl(r5, r3)     // Catch:{ RemoteException -> 0x0055 }
            goto L_0x005d
        L_0x0055:
            r5 = move-exception
            java.lang.String r6 = zza     // Catch:{ all -> 0x007d }
            java.lang.String r1 = "Failed to retrieve renderer type or log initialization."
            android.util.Log.e(r6, r1, r5)     // Catch:{ all -> 0x007d }
        L_0x005d:
            com.google.android.gms.maps.MapsInitializer$Renderer r5 = zzc     // Catch:{ all -> 0x007d }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x007d }
            java.lang.String r6 = "loadedRenderer: "
            r6.concat(r5)     // Catch:{ all -> 0x007d }
            if (r7 == 0) goto L_0x006f
            com.google.android.gms.maps.MapsInitializer$Renderer r5 = zzc     // Catch:{ all -> 0x007d }
            r7.onMapsSdkInitialized(r5)     // Catch:{ all -> 0x007d }
        L_0x006f:
            monitor-exit(r0)
            return r2
        L_0x0071:
            r5 = move-exception
            com.google.android.gms.maps.model.RuntimeRemoteException r6 = new com.google.android.gms.maps.model.RuntimeRemoteException     // Catch:{ all -> 0x007d }
            r6.<init>(r5)     // Catch:{ all -> 0x007d }
            throw r6     // Catch:{ all -> 0x007d }
        L_0x0078:
            r5 = move-exception
            int r5 = r5.errorCode     // Catch:{ all -> 0x007d }
            monitor-exit(r0)
            return r5
        L_0x007d:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.MapsInitializer.initialize(android.content.Context, com.google.android.gms.maps.MapsInitializer$Renderer, com.google.android.gms.maps.OnMapsSdkInitializedCallback):int");
    }
}

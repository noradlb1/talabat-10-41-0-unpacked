package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zzfmt implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    private final zzfno zza;
    private final zzfni zzb;
    private final Object zzc = new Object();
    private boolean zzd = false;
    private boolean zze = false;

    public zzfmt(@NonNull Context context, @NonNull Looper looper, @NonNull zzfni zzfni) {
        this.zzb = zzfni;
        this.zza = new zzfno(context, looper, this, this, 12800000);
    }

    private final void zzb() {
        synchronized (this.zzc) {
            if (this.zza.isConnected() || this.zza.isConnecting()) {
                this.zza.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0020 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onConnected(@androidx.annotation.Nullable android.os.Bundle r4) {
        /*
            r3 = this;
            java.lang.Object r4 = r3.zzc
            monitor-enter(r4)
            boolean r0 = r3.zze     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r4)     // Catch:{ all -> 0x002b }
            return
        L_0x0009:
            r0 = 1
            r3.zze = r0     // Catch:{ all -> 0x002b }
            com.google.android.gms.internal.ads.zzfno r0 = r3.zza     // Catch:{ Exception -> 0x0020, all -> 0x0024 }
            com.google.android.gms.internal.ads.zzfnt r0 = r0.zzp()     // Catch:{ Exception -> 0x0020, all -> 0x0024 }
            com.google.android.gms.internal.ads.zzfnm r1 = new com.google.android.gms.internal.ads.zzfnm     // Catch:{ Exception -> 0x0020, all -> 0x0024 }
            com.google.android.gms.internal.ads.zzfni r2 = r3.zzb     // Catch:{ Exception -> 0x0020, all -> 0x0024 }
            byte[] r2 = r2.zzar()     // Catch:{ Exception -> 0x0020, all -> 0x0024 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0020, all -> 0x0024 }
            r0.zzg(r1)     // Catch:{ Exception -> 0x0020, all -> 0x0024 }
        L_0x0020:
            r3.zzb()     // Catch:{ all -> 0x002b }
            goto L_0x0029
        L_0x0024:
            r0 = move-exception
            r3.zzb()     // Catch:{ all -> 0x002b }
            throw r0     // Catch:{ all -> 0x002b }
        L_0x0029:
            monitor-exit(r4)     // Catch:{ all -> 0x002b }
            return
        L_0x002b:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x002b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfmt.onConnected(android.os.Bundle):void");
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }

    public final void onConnectionSuspended(int i11) {
    }

    public final void zza() {
        synchronized (this.zzc) {
            if (!this.zzd) {
                this.zzd = true;
                this.zza.checkAvailabilityAndConnect();
            }
        }
    }
}

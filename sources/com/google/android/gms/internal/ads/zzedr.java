package com.google.android.gms.internal.ads;

import android.os.Binder;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.io.InputStream;

public abstract class zzedr implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    protected final zzcjr<InputStream> zza = new zzcjr<>();
    protected final Object zzb = new Object();
    protected boolean zzc = false;
    protected boolean zzd = false;
    protected zzcdq zze;
    @VisibleForTesting(otherwise = 3)
    @GuardedBy("mLock")
    protected zzcdb zzf;

    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zzciz.zze("Disconnected from remote ad request service.");
        this.zza.zze(new zzeeg(1));
    }

    public final void onConnectionSuspended(int i11) {
        zzciz.zze("Cannot connect to remote service, fallback to local instance.");
    }

    public final void zza() {
        synchronized (this.zzb) {
            this.zzd = true;
            if (this.zzf.isConnected() || this.zzf.isConnecting()) {
                this.zzf.disconnect();
            }
            Binder.flushPendingCommands();
        }
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.ConnectionResult;

public final class zzedp extends zzedr {
    public zzedp(Context context) {
        this.zzf = new zzcdb(context, zzt.zzt().zzb(), this, this);
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zzb) {
            if (!this.zzd) {
                this.zzd = true;
                try {
                    this.zzf.zzp().zzg(this.zze, new zzedq(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zza.zze(new zzeeg(1));
                } catch (Throwable th2) {
                    zzt.zzo().zzs(th2, "RemoteAdRequestClientTask.onConnected");
                    this.zza.zze(new zzeeg(1));
                }
            }
        }
    }

    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zzciz.zze("Cannot connect to remote service, fallback to local instance.");
        this.zza.zze(new zzeeg(1));
    }
}

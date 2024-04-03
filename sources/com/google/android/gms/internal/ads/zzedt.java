package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzt;

public final class zzedt extends zzedr {
    public zzedt(Context context) {
        this.zzf = new zzcdb(context, zzt.zzt().zzb(), this, this);
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zzb) {
            if (!this.zzd) {
                this.zzd = true;
                try {
                    this.zzf.zzp().zzf(this.zze, new zzedq(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zza.zze(new zzeeg(1));
                } catch (Throwable th2) {
                    zzt.zzo().zzs(th2, "RemoteSignalsClientTask.onConnected");
                    this.zza.zze(new zzeeg(1));
                }
            }
        }
    }
}

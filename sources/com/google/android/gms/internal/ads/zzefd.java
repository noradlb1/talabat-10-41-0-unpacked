package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzbd;
import com.google.android.gms.ads.internal.util.zze;

final class zzefd implements zzfwm<ParcelFileDescriptor> {
    final /* synthetic */ zzcdm zza;

    public zzefd(zzefh zzefh, zzcdm zzcdm) {
        this.zza = zzcdm;
    }

    public final void zza(Throwable th2) {
        try {
            this.zza.zze(zzbd.zza(th2));
        } catch (RemoteException e11) {
            zze.zzb("Service can't call client", e11);
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        try {
            this.zza.zzf((ParcelFileDescriptor) obj);
        } catch (RemoteException e11) {
            zze.zzb("Service can't call client", e11);
        }
    }
}

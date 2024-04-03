package com.google.firebase.appindexing.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.icing.zzaa;
import com.google.android.gms.internal.icing.zzak;

final class zzq extends zzs {
    final /* synthetic */ zzc[] zza;

    public zzq(zzt zzt, zzc[] zzcArr) {
        this.zza = zzcArr;
    }

    public final void zza(zzaa zzaa) throws RemoteException {
        zzaa.zze(new zzak(this), this.zza);
    }
}

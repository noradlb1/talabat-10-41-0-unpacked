package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzbnu extends zzboh {
    private final Drawable zza;
    private final Uri zzb;
    private final double zzc;
    private final int zzd;
    private final int zze;

    public zzbnu(Drawable drawable, Uri uri, double d11, int i11, int i12) {
        this.zza = drawable;
        this.zzb = uri;
        this.zzc = d11;
        this.zzd = i11;
        this.zze = i12;
    }

    public final double zzb() {
        return this.zzc;
    }

    public final int zzc() {
        return this.zze;
    }

    public final int zzd() {
        return this.zzd;
    }

    public final Uri zze() throws RemoteException {
        return this.zzb;
    }

    public final IObjectWrapper zzf() throws RemoteException {
        return ObjectWrapper.wrap(this.zza);
    }
}

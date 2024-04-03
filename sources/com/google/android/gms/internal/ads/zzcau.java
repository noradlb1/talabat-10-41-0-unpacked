package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzcau extends NativeAd.Image {
    private final zzboi zza;
    @Nullable
    private final Drawable zzb;
    @Nullable
    private final Uri zzc;
    private final double zzd;

    public zzcau(zzboi zzboi) {
        Drawable drawable;
        double d11;
        this.zza = zzboi;
        Uri uri = null;
        try {
            IObjectWrapper zzf = zzboi.zzf();
            if (zzf != null) {
                drawable = (Drawable) ObjectWrapper.unwrap(zzf);
                this.zzb = drawable;
                uri = this.zza.zze();
                this.zzc = uri;
                d11 = this.zza.zzb();
                this.zzd = d11;
                this.zza.zzd();
                this.zza.zzc();
            }
        } catch (RemoteException e11) {
            zzciz.zzh("", e11);
        }
        drawable = null;
        this.zzb = drawable;
        try {
            uri = this.zza.zze();
        } catch (RemoteException e12) {
            zzciz.zzh("", e12);
        }
        this.zzc = uri;
        try {
            d11 = this.zza.zzb();
        } catch (RemoteException e13) {
            zzciz.zzh("", e13);
            d11 = 1.0d;
        }
        this.zzd = d11;
        try {
            this.zza.zzd();
        } catch (RemoteException e14) {
            zzciz.zzh("", e14);
        }
        try {
            this.zza.zzc();
        } catch (RemoteException e15) {
            zzciz.zzh("", e15);
        }
    }

    @Nullable
    public final Drawable getDrawable() {
        return this.zzb;
    }

    public final double getScale() {
        return this.zzd;
    }

    @Nullable
    public final Uri getUri() {
        return this.zzc;
    }
}

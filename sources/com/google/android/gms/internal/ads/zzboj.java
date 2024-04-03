package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzboj extends NativeAd.Image {
    private final zzboi zza;
    private final Drawable zzb;
    private final Uri zzc;
    private final double zzd;
    private final int zze;
    private final int zzf;

    public zzboj(zzboi zzboi) {
        Drawable drawable;
        double d11;
        int i11;
        this.zza = zzboi;
        Uri uri = null;
        try {
            IObjectWrapper zzf2 = zzboi.zzf();
            if (zzf2 != null) {
                drawable = (Drawable) ObjectWrapper.unwrap(zzf2);
                this.zzb = drawable;
                uri = this.zza.zze();
                this.zzc = uri;
                d11 = this.zza.zzb();
                this.zzd = d11;
                int i12 = -1;
                i11 = this.zza.zzd();
                this.zze = i11;
                i12 = this.zza.zzc();
                this.zzf = i12;
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
        int i122 = -1;
        try {
            i11 = this.zza.zzd();
        } catch (RemoteException e14) {
            zzciz.zzh("", e14);
            i11 = -1;
        }
        this.zze = i11;
        try {
            i122 = this.zza.zzc();
        } catch (RemoteException e15) {
            zzciz.zzh("", e15);
        }
        this.zzf = i122;
    }

    public final Drawable getDrawable() {
        return this.zzb;
    }

    public final double getScale() {
        return this.zzd;
    }

    public final Uri getUri() {
        return this.zzc;
    }

    public final int zza() {
        return this.zzf;
    }

    public final int zzb() {
        return this.zze;
    }
}

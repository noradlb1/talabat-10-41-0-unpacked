package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzbju implements MediaContent {
    private final zzbof zza;
    private final VideoController zzb = new VideoController();

    public zzbju(zzbof zzbof) {
        this.zza = zzbof;
    }

    public final float getAspectRatio() {
        try {
            return this.zza.zze();
        } catch (RemoteException e11) {
            zzciz.zzh("", e11);
            return 0.0f;
        }
    }

    public final float getCurrentTime() {
        try {
            return this.zza.zzf();
        } catch (RemoteException e11) {
            zzciz.zzh("", e11);
            return 0.0f;
        }
    }

    public final float getDuration() {
        try {
            return this.zza.zzg();
        } catch (RemoteException e11) {
            zzciz.zzh("", e11);
            return 0.0f;
        }
    }

    public final Drawable getMainImage() {
        try {
            IObjectWrapper zzi = this.zza.zzi();
            if (zzi != null) {
                return (Drawable) ObjectWrapper.unwrap(zzi);
            }
            return null;
        } catch (RemoteException e11) {
            zzciz.zzh("", e11);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            if (this.zza.zzh() != null) {
                this.zzb.zzb(this.zza.zzh());
            }
        } catch (RemoteException e11) {
            zzciz.zzh("Exception occurred while getting video controller", e11);
        }
        return this.zzb;
    }

    public final boolean hasVideoContent() {
        try {
            return this.zza.zzk();
        } catch (RemoteException e11) {
            zzciz.zzh("", e11);
            return false;
        }
    }

    public final void setMainImage(Drawable drawable) {
        try {
            this.zza.zzj(ObjectWrapper.wrap(drawable));
        } catch (RemoteException e11) {
            zzciz.zzh("", e11);
        }
    }

    public final zzbof zza() {
        return this.zza;
    }
}

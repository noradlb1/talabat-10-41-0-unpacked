package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

public final class zzbpd implements NativeCustomTemplateAd {
    private final zzbpc zza;
    private final MediaView zzb;
    private final VideoController zzc = new VideoController();
    private NativeCustomTemplateAd.DisplayOpenMeasurement zzd;

    @VisibleForTesting
    public zzbpd(zzbpc zzbpc) {
        Context context;
        this.zza = zzbpc;
        MediaView mediaView = null;
        try {
            context = (Context) ObjectWrapper.unwrap(zzbpc.zzg());
        } catch (RemoteException | NullPointerException e11) {
            zzciz.zzh("", e11);
            context = null;
        }
        if (context != null) {
            MediaView mediaView2 = new MediaView(context);
            try {
                if (true == this.zza.zzq(ObjectWrapper.wrap(mediaView2))) {
                    mediaView = mediaView2;
                }
            } catch (RemoteException e12) {
                zzciz.zzh("", e12);
            }
        }
        this.zzb = mediaView;
    }

    public final void destroy() {
        try {
            this.zza.zzk();
        } catch (RemoteException e11) {
            zzciz.zzh("", e11);
        }
    }

    public final List<String> getAvailableAssetNames() {
        try {
            return this.zza.zzj();
        } catch (RemoteException e11) {
            zzciz.zzh("", e11);
            return null;
        }
    }

    public final String getCustomTemplateId() {
        try {
            return this.zza.zzh();
        } catch (RemoteException e11) {
            zzciz.zzh("", e11);
            return null;
        }
    }

    public final NativeCustomTemplateAd.DisplayOpenMeasurement getDisplayOpenMeasurement() {
        try {
            if (this.zzd == null && this.zza.zzp()) {
                this.zzd = new zzboc(this.zza);
            }
        } catch (RemoteException e11) {
            zzciz.zzh("", e11);
        }
        return this.zzd;
    }

    public final NativeAd.Image getImage(String str) {
        try {
            zzboi zzf = this.zza.zzf(str);
            if (zzf != null) {
                return new zzboj(zzf);
            }
            return null;
        } catch (RemoteException e11) {
            zzciz.zzh("", e11);
            return null;
        }
    }

    public final CharSequence getText(String str) {
        try {
            return this.zza.zzi(str);
        } catch (RemoteException e11) {
            zzciz.zzh("", e11);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            zzbiz zze = this.zza.zze();
            if (zze != null) {
                this.zzc.zzb(zze);
            }
        } catch (RemoteException e11) {
            zzciz.zzh("Exception occurred while getting video controller", e11);
        }
        return this.zzc;
    }

    public final MediaView getVideoMediaView() {
        return this.zzb;
    }

    public final void performClick(String str) {
        try {
            this.zza.zzm(str);
        } catch (RemoteException e11) {
            zzciz.zzh("", e11);
        }
    }

    public final void recordImpression() {
        try {
            this.zza.zzn();
        } catch (RemoteException e11) {
            zzciz.zzh("", e11);
        }
    }

    public final zzbpc zza() {
        return this.zza;
    }
}

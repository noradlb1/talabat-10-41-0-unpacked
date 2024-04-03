package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

public final class zzdty extends zzbub implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzbnt {
    private View zza;
    private zzbiz zzb;
    private zzdpx zzc;
    private boolean zzd = false;
    private boolean zze = false;

    public zzdty(zzdpx zzdpx, zzdqc zzdqc) {
        this.zza = zzdqc.zzf();
        this.zzb = zzdqc.zzj();
        this.zzc = zzdpx;
        if (zzdqc.zzr() != null) {
            zzdqc.zzr().zzao(this);
        }
    }

    private final void zzg() {
        View view;
        zzdpx zzdpx = this.zzc;
        if (zzdpx != null && (view = this.zza) != null) {
            zzdpx.zzv(view, Collections.emptyMap(), Collections.emptyMap(), zzdpx.zzP(this.zza));
        }
    }

    private final void zzh() {
        View view = this.zza;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.zza);
            }
        }
    }

    private static final void zzi(zzbuf zzbuf, int i11) {
        try {
            zzbuf.zze(i11);
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onGlobalLayout() {
        zzg();
    }

    public final void onScrollChanged() {
        zzg();
    }

    public final zzbiz zzb() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (!this.zzd) {
            return this.zzb;
        }
        zzciz.zzg("getVideoController: Instream ad should not be used after destroyed");
        return null;
    }

    public final zzbof zzc() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzd) {
            zzciz.zzg("getVideoController: Instream ad should not be used after destroyed");
            return null;
        }
        zzdpx zzdpx = this.zzc;
        if (zzdpx == null || zzdpx.zza() == null) {
            return null;
        }
        return this.zzc.zza().zza();
    }

    public final void zzd() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzh();
        zzdpx zzdpx = this.zzc;
        if (zzdpx != null) {
            zzdpx.zzT();
        }
        this.zzc = null;
        this.zza = null;
        this.zzb = null;
        this.zzd = true;
    }

    public final void zze(IObjectWrapper iObjectWrapper) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzf(iObjectWrapper, new zzdtx(this));
    }

    public final void zzf(IObjectWrapper iObjectWrapper, zzbuf zzbuf) throws RemoteException {
        String str;
        String str2;
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzd) {
            zzciz.zzg("Instream ad can not be shown after destroy().");
            zzi(zzbuf, 2);
            return;
        }
        View view = this.zza;
        if (view == null || this.zzb == null) {
            if (view == null) {
                str = "can not get video view.";
            } else {
                str = "can not get video controller.";
            }
            if (str.length() != 0) {
                str2 = "Instream internal error: ".concat(str);
            } else {
                str2 = new String("Instream internal error: ");
            }
            zzciz.zzg(str2);
            zzi(zzbuf, 0);
        } else if (this.zze) {
            zzciz.zzg("Instream ad should not be used again.");
            zzi(zzbuf, 1);
        } else {
            this.zze = true;
            zzh();
            ((ViewGroup) ObjectWrapper.unwrap(iObjectWrapper)).addView(this.zza, new ViewGroup.LayoutParams(-1, -1));
            zzt.zzx();
            zzcjz.zza(this.zza, this);
            zzt.zzx();
            zzcjz.zzb(this.zza, this);
            zzg();
            try {
                zzbuf.zzf();
            } catch (RemoteException e11) {
                zzciz.zzl("#007 Could not call remote method.", e11);
            }
        }
    }
}

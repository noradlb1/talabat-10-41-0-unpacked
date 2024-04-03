package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.common.internal.Preconditions;

@RequiresApi(api = 21)
public final class zzbsv {
    private final Context zza;
    private final OnH5AdsEventListener zzb;
    @Nullable
    private zzbsr zzc;

    public zzbsv(Context context, OnH5AdsEventListener onH5AdsEventListener) {
        Preconditions.checkState(true, "Android version must be Lollipop or higher");
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(onH5AdsEventListener);
        this.zza = context;
        this.zzb = onH5AdsEventListener;
        zzblj.zzc(context);
    }

    public static final boolean zzc(String str) {
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzgU)).booleanValue()) {
            return false;
        }
        Preconditions.checkNotNull(str);
        if (str.length() > ((Integer) zzbgq.zzc().zzb(zzblj.zzgW)).intValue()) {
            zzciz.zze("H5 GMSG exceeds max length");
            return false;
        }
        Uri parse = Uri.parse(str);
        if (!"gmsg".equals(parse.getScheme()) || !"mobileads.google.com".equals(parse.getHost()) || !"/h5ads".equals(parse.getPath())) {
            return false;
        }
        return true;
    }

    private final void zzd() {
        if (this.zzc == null) {
            this.zzc = zzbgo.zza().zzk(this.zza, new zzbxe(), this.zzb);
        }
    }

    public final void zza() {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgU)).booleanValue()) {
            zzd();
            zzbsr zzbsr = this.zzc;
            if (zzbsr != null) {
                try {
                    zzbsr.zze();
                } catch (RemoteException e11) {
                    zzciz.zzl("#007 Could not call remote method.", e11);
                }
            }
        }
    }

    public final boolean zzb(String str) {
        if (!zzc(str)) {
            return false;
        }
        zzd();
        zzbsr zzbsr = this.zzc;
        if (zzbsr == null) {
            return false;
        }
        try {
            zzbsr.zzf(str);
            return true;
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
            return true;
        }
    }
}

package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.nativead.NativeAd;
import java.util.ArrayList;
import java.util.List;

public final class zzcas extends NativeAd.AdChoicesInfo {
    private final List<NativeAd.Image> zza = new ArrayList();
    private String zzb;

    public zzcas(zzboa zzboa) {
        zzboi zzboi;
        try {
            this.zzb = zzboa.zzg();
        } catch (RemoteException e11) {
            zzciz.zzh("", e11);
            this.zzb = "";
        }
        try {
            for (zzboi next : zzboa.zzh()) {
                if (next instanceof IBinder) {
                    zzboi = zzboh.zzg((IBinder) next);
                } else {
                    zzboi = null;
                }
                if (zzboi != null) {
                    this.zza.add(new zzcau(zzboi));
                }
            }
        } catch (RemoteException e12) {
            zzciz.zzh("", e12);
        }
    }

    public final List<NativeAd.Image> getImages() {
        return this.zza;
    }

    public final CharSequence getText() {
        return this.zzb;
    }
}

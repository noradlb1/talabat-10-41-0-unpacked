package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Collections;
import java.util.List;

public final class zzbkd extends zzbia {
    private zzbtu zza;

    public final /* synthetic */ void zzb() {
        zzbtu zzbtu = this.zza;
        if (zzbtu != null) {
            try {
                zzbtu.zzb(Collections.emptyList());
            } catch (RemoteException e11) {
                zzciz.zzk("Could not notify onComplete event.", e11);
            }
        }
    }

    public final float zze() throws RemoteException {
        return 1.0f;
    }

    public final String zzf() {
        return "";
    }

    public final List<zzbtn> zzg() throws RemoteException {
        return Collections.emptyList();
    }

    public final void zzh(@Nullable String str) throws RemoteException {
    }

    public final void zzi() {
    }

    public final void zzj() throws RemoteException {
        zzciz.zzg("The initialization is not processed because MobileAdsSettingsManager is not created successfully.");
        zzcis.zza.post(new zzbkc(this));
    }

    public final void zzk(@Nullable String str, IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzl(zzbin zzbin) {
    }

    public final void zzm(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
    }

    public final void zzn(zzbxh zzbxh) throws RemoteException {
    }

    public final void zzo(boolean z11) throws RemoteException {
    }

    public final void zzp(float f11) throws RemoteException {
    }

    public final void zzq(String str) throws RemoteException {
    }

    public final void zzr(zzbtu zzbtu) throws RemoteException {
        this.zza = zzbtu;
    }

    public final void zzs(zzbkk zzbkk) throws RemoteException {
    }

    public final boolean zzt() throws RemoteException {
        return false;
    }
}

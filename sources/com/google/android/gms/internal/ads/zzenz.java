package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

public final class zzenz extends zzbhj {
    private final Context zza;
    private final zzbgx zzb;
    private final zzfef zzc;
    private final zzcyw zzd;
    private final ViewGroup zze;

    public zzenz(Context context, @Nullable zzbgx zzbgx, zzfef zzfef, zzcyw zzcyw) {
        this.zza = context;
        this.zzb = zzbgx;
        this.zzc = zzfef;
        this.zzd = zzcyw;
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.removeAllViews();
        frameLayout.addView(zzcyw.zzc(), zzt.zzq().zzj());
        frameLayout.setMinimumHeight(zzg().zzc);
        frameLayout.setMinimumWidth(zzg().zzf);
        this.zze = frameLayout;
    }

    public final void zzA() throws RemoteException {
        this.zzd.zzg();
    }

    public final void zzB() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzd.zzm().zzc((Context) null);
    }

    public final void zzC(zzbgu zzbgu) throws RemoteException {
        zzciz.zzi("setAdClickListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzD(zzbgx zzbgx) throws RemoteException {
        zzciz.zzi("setAdListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzE(zzbho zzbho) throws RemoteException {
        zzciz.zzi("setAdMetadataListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzF(zzbfi zzbfi) throws RemoteException {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        zzcyw zzcyw = this.zzd;
        if (zzcyw != null) {
            zzcyw.zzh(this.zze, zzbfi);
        }
    }

    public final void zzG(zzbhr zzbhr) throws RemoteException {
        zzeox zzeox = this.zzc.zzc;
        if (zzeox != null) {
            zzeox.zzs(zzbhr);
        }
    }

    public final void zzH(zzazw zzazw) throws RemoteException {
    }

    public final void zzI(zzbfo zzbfo) throws RemoteException {
    }

    public final void zzJ(zzbhy zzbhy) {
    }

    public final void zzK(zzbjd zzbjd) throws RemoteException {
    }

    public final void zzL(boolean z11) throws RemoteException {
    }

    public final void zzM(zzccb zzccb) throws RemoteException {
    }

    public final void zzN(boolean z11) throws RemoteException {
        zzciz.zzi("setManualImpressionsEnabled is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzO(zzbme zzbme) throws RemoteException {
        zzciz.zzi("setOnCustomRenderedAdLoadedListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzP(zzbit zzbit) {
        zzciz.zzi("setOnPaidEventListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzQ(zzcce zzcce, String str) throws RemoteException {
    }

    public final void zzR(String str) throws RemoteException {
    }

    public final void zzS(zzcem zzcem) throws RemoteException {
    }

    public final void zzT(String str) throws RemoteException {
    }

    public final void zzU(zzbkq zzbkq) throws RemoteException {
        zzciz.zzi("setVideoOptions is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final void zzW(IObjectWrapper iObjectWrapper) {
    }

    public final void zzX() throws RemoteException {
    }

    public final boolean zzY() throws RemoteException {
        return false;
    }

    public final boolean zzZ() throws RemoteException {
        return false;
    }

    public final boolean zzaa(zzbfd zzbfd) throws RemoteException {
        zzciz.zzi("loadAd is not supported for an Ad Manager AdView returned from AdLoader.");
        return false;
    }

    public final void zzab(zzbhv zzbhv) throws RemoteException {
        zzciz.zzi("setCorrelationIdProvider is not supported in Ad Manager AdView returned by AdLoader.");
    }

    public final Bundle zzd() throws RemoteException {
        zzciz.zzi("getAdMetadata is not supported in Ad Manager AdView returned by AdLoader.");
        return new Bundle();
    }

    public final zzbfi zzg() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        return zzfej.zza(this.zza, Collections.singletonList(this.zzd.zze()));
    }

    public final zzbgx zzi() throws RemoteException {
        return this.zzb;
    }

    public final zzbhr zzj() throws RemoteException {
        return this.zzc.zzn;
    }

    public final zzbiw zzk() {
        return this.zzd.zzl();
    }

    public final zzbiz zzl() throws RemoteException {
        return this.zzd.zzd();
    }

    public final IObjectWrapper zzn() throws RemoteException {
        return ObjectWrapper.wrap(this.zze);
    }

    public final String zzr() throws RemoteException {
        return this.zzc.zzf;
    }

    public final String zzs() throws RemoteException {
        if (this.zzd.zzl() != null) {
            return this.zzd.zzl().zze();
        }
        return null;
    }

    public final String zzt() throws RemoteException {
        if (this.zzd.zzl() != null) {
            return this.zzd.zzl().zze();
        }
        return null;
    }

    public final void zzx() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzd.zzT();
    }

    public final void zzy(zzbfd zzbfd, zzbha zzbha) {
    }

    public final void zzz() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzd.zzm().zzb((Context) null);
    }
}

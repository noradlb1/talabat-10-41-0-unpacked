package com.google.android.gms.internal.ads;

import android.os.RemoteException;

public final class zzead {
    private final zzbso zza;

    public zzead(zzbso zzbso) {
        this.zza = zzbso;
    }

    private final void zzs(zzeac zzeac) throws RemoteException {
        String str;
        String zza2 = zzeac.zza(zzeac);
        if (zza2.length() != 0) {
            str = "Dispatching AFMA event on publisher webview: ".concat(zza2);
        } else {
            str = new String("Dispatching AFMA event on publisher webview: ");
        }
        zzciz.zzi(str);
        this.zza.zzb(zza2);
    }

    public final void zza() throws RemoteException {
        zzs(new zzeac("initialize", (zzeab) null));
    }

    public final void zzb(long j11) throws RemoteException {
        zzeac zzeac = new zzeac("interstitial", (zzeab) null);
        zzeac.zza = Long.valueOf(j11);
        zzeac.zzc = "onAdClicked";
        this.zza.zzb(zzeac.zza(zzeac));
    }

    public final void zzc(long j11) throws RemoteException {
        zzeac zzeac = new zzeac("interstitial", (zzeab) null);
        zzeac.zza = Long.valueOf(j11);
        zzeac.zzc = "onAdClosed";
        zzs(zzeac);
    }

    public final void zzd(long j11, int i11) throws RemoteException {
        zzeac zzeac = new zzeac("interstitial", (zzeab) null);
        zzeac.zza = Long.valueOf(j11);
        zzeac.zzc = "onAdFailedToLoad";
        zzeac.zzd = Integer.valueOf(i11);
        zzs(zzeac);
    }

    public final void zze(long j11) throws RemoteException {
        zzeac zzeac = new zzeac("interstitial", (zzeab) null);
        zzeac.zza = Long.valueOf(j11);
        zzeac.zzc = "onAdLoaded";
        zzs(zzeac);
    }

    public final void zzf(long j11) throws RemoteException {
        zzeac zzeac = new zzeac("interstitial", (zzeab) null);
        zzeac.zza = Long.valueOf(j11);
        zzeac.zzc = "onNativeAdObjectNotAvailable";
        zzs(zzeac);
    }

    public final void zzg(long j11) throws RemoteException {
        zzeac zzeac = new zzeac("interstitial", (zzeab) null);
        zzeac.zza = Long.valueOf(j11);
        zzeac.zzc = "onAdOpened";
        zzs(zzeac);
    }

    public final void zzh(long j11) throws RemoteException {
        zzeac zzeac = new zzeac("creation", (zzeab) null);
        zzeac.zza = Long.valueOf(j11);
        zzeac.zzc = "nativeObjectCreated";
        zzs(zzeac);
    }

    public final void zzi(long j11) throws RemoteException {
        zzeac zzeac = new zzeac("creation", (zzeab) null);
        zzeac.zza = Long.valueOf(j11);
        zzeac.zzc = "nativeObjectNotCreated";
        zzs(zzeac);
    }

    public final void zzj(long j11) throws RemoteException {
        zzeac zzeac = new zzeac("rewarded", (zzeab) null);
        zzeac.zza = Long.valueOf(j11);
        zzeac.zzc = "onAdClicked";
        zzs(zzeac);
    }

    public final void zzk(long j11) throws RemoteException {
        zzeac zzeac = new zzeac("rewarded", (zzeab) null);
        zzeac.zza = Long.valueOf(j11);
        zzeac.zzc = "onRewardedAdClosed";
        zzs(zzeac);
    }

    public final void zzl(long j11, zzcew zzcew) throws RemoteException {
        zzeac zzeac = new zzeac("rewarded", (zzeab) null);
        zzeac.zza = Long.valueOf(j11);
        zzeac.zzc = "onUserEarnedReward";
        zzeac.zze = zzcew.zzf();
        zzeac.zzf = Integer.valueOf(zzcew.zze());
        zzs(zzeac);
    }

    public final void zzm(long j11, int i11) throws RemoteException {
        zzeac zzeac = new zzeac("rewarded", (zzeab) null);
        zzeac.zza = Long.valueOf(j11);
        zzeac.zzc = "onRewardedAdFailedToLoad";
        zzeac.zzd = Integer.valueOf(i11);
        zzs(zzeac);
    }

    public final void zzn(long j11, int i11) throws RemoteException {
        zzeac zzeac = new zzeac("rewarded", (zzeab) null);
        zzeac.zza = Long.valueOf(j11);
        zzeac.zzc = "onRewardedAdFailedToShow";
        zzeac.zzd = Integer.valueOf(i11);
        zzs(zzeac);
    }

    public final void zzo(long j11) throws RemoteException {
        zzeac zzeac = new zzeac("rewarded", (zzeab) null);
        zzeac.zza = Long.valueOf(j11);
        zzeac.zzc = "onAdImpression";
        zzs(zzeac);
    }

    public final void zzp(long j11) throws RemoteException {
        zzeac zzeac = new zzeac("rewarded", (zzeab) null);
        zzeac.zza = Long.valueOf(j11);
        zzeac.zzc = "onRewardedAdLoaded";
        zzs(zzeac);
    }

    public final void zzq(long j11) throws RemoteException {
        zzeac zzeac = new zzeac("rewarded", (zzeab) null);
        zzeac.zza = Long.valueOf(j11);
        zzeac.zzc = "onNativeAdObjectNotAvailable";
        zzs(zzeac);
    }

    public final void zzr(long j11) throws RemoteException {
        zzeac zzeac = new zzeac("rewarded", (zzeab) null);
        zzeac.zza = Long.valueOf(j11);
        zzeac.zzc = "onRewardedAdOpened";
        zzs(zzeac);
    }
}

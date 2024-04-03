package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;

public final class zzbyx<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    /* access modifiers changed from: private */
    public final zzbxn zza;

    public zzbyx(zzbxn zzbxn) {
        this.zza = zzbxn;
    }

    public final void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzciz.zze("Adapter called onClick.");
        zzbgo.zzb();
        if (!zzcis.zzp()) {
            zzciz.zzl("#008 Must be called on the main UI thread.", (Throwable) null);
            zzcis.zza.post(new zzbyo(this));
            return;
        }
        try {
            this.zza.zze();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzciz.zze("Adapter called onDismissScreen.");
        zzbgo.zzb();
        if (!zzcis.zzp()) {
            zzciz.zzj("#008 Must be called on the main UI thread.");
            zzcis.zza.post(new zzbyp(this));
            return;
        }
        try {
            this.zza.zzf();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, AdRequest.ErrorCode errorCode) {
        zzciz.zze("Adapter called onFailedToReceiveAd with error. ".concat(String.valueOf(errorCode)));
        zzbgo.zzb();
        if (!zzcis.zzp()) {
            zzciz.zzl("#008 Must be called on the main UI thread.", (Throwable) null);
            zzcis.zza.post(new zzbyq(this, errorCode));
            return;
        }
        try {
            this.zza.zzg(zzbyy.zza(errorCode));
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzciz.zze("Adapter called onLeaveApplication.");
        zzbgo.zzb();
        if (!zzcis.zzp()) {
            zzciz.zzl("#008 Must be called on the main UI thread.", (Throwable) null);
            zzcis.zza.post(new zzbyr(this));
            return;
        }
        try {
            this.zza.zzn();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzciz.zze("Adapter called onPresentScreen.");
        zzbgo.zzb();
        if (!zzcis.zzp()) {
            zzciz.zzl("#008 Must be called on the main UI thread.", (Throwable) null);
            zzcis.zza.post(new zzbys(this));
            return;
        }
        try {
            this.zza.zzp();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzciz.zze("Adapter called onReceivedAd.");
        zzbgo.zzb();
        if (!zzcis.zzp()) {
            zzciz.zzl("#008 Must be called on the main UI thread.", (Throwable) null);
            zzcis.zza.post(new zzbyt(this));
            return;
        }
        try {
            this.zza.zzo();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzciz.zze("Adapter called onDismissScreen.");
        zzbgo.zzb();
        if (!zzcis.zzp()) {
            zzciz.zzl("#008 Must be called on the main UI thread.", (Throwable) null);
            zzcis.zza.post(new zzbyu(this));
            return;
        }
        try {
            this.zza.zzf();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, AdRequest.ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 47);
        sb2.append("Adapter called onFailedToReceiveAd with error ");
        sb2.append(valueOf);
        sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
        zzciz.zze(sb2.toString());
        zzbgo.zzb();
        if (!zzcis.zzp()) {
            zzciz.zzl("#008 Must be called on the main UI thread.", (Throwable) null);
            zzcis.zza.post(new zzbyv(this, errorCode));
            return;
        }
        try {
            this.zza.zzg(zzbyy.zza(errorCode));
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzciz.zze("Adapter called onLeaveApplication.");
        zzbgo.zzb();
        if (!zzcis.zzp()) {
            zzciz.zzl("#008 Must be called on the main UI thread.", (Throwable) null);
            zzcis.zza.post(new zzbyw(this));
            return;
        }
        try {
            this.zza.zzn();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzciz.zze("Adapter called onPresentScreen.");
        zzbgo.zzb();
        if (!zzcis.zzp()) {
            zzciz.zzl("#008 Must be called on the main UI thread.", (Throwable) null);
            zzcis.zza.post(new zzbym(this));
            return;
        }
        try {
            this.zza.zzp();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzciz.zze("Adapter called onReceivedAd.");
        zzbgo.zzb();
        if (!zzcis.zzp()) {
            zzciz.zzl("#008 Must be called on the main UI thread.", (Throwable) null);
            zzcis.zza.post(new zzbyn(this));
            return;
        }
        try {
            this.zza.zzo();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }
}

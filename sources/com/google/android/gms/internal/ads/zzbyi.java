package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.common.internal.Preconditions;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;

public final class zzbyi implements MediationBannerListener, MediationInterstitialListener, MediationNativeListener {
    private final zzbxn zza;
    private UnifiedNativeAdMapper zzb;
    private NativeCustomTemplateAd zzc;

    public zzbyi(zzbxn zzbxn) {
        this.zza = zzbxn;
    }

    public final void onAdClicked(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzciz.zze("Adapter called onAdClicked.");
        try {
            this.zza.zze();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onAdClosed(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzciz.zze("Adapter called onAdClosed.");
        try {
            this.zza.zzf();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onAdFailedToLoad(MediationBannerAdapter mediationBannerAdapter, int i11) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        StringBuilder sb2 = new StringBuilder(55);
        sb2.append("Adapter called onAdFailedToLoad with error. ");
        sb2.append(i11);
        zzciz.zze(sb2.toString());
        try {
            this.zza.zzg(i11);
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onAdImpression(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        UnifiedNativeAdMapper unifiedNativeAdMapper = this.zzb;
        if (this.zzc == null) {
            if (unifiedNativeAdMapper == null) {
                zzciz.zzl("#007 Could not call remote method.", (Throwable) null);
                return;
            } else if (!unifiedNativeAdMapper.getOverrideImpressionRecording()) {
                zzciz.zze("Could not call onAdImpression since setOverrideImpressionRecording is not set to true");
                return;
            }
        }
        zzciz.zze("Adapter called onAdImpression.");
        try {
            this.zza.zzm();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onAdLeftApplication(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzciz.zze("Adapter called onAdLeftApplication.");
        try {
            this.zza.zzn();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onAdLoaded(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzciz.zze("Adapter called onAdLoaded.");
        try {
            this.zza.zzo();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onAdOpened(MediationBannerAdapter mediationBannerAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzciz.zze("Adapter called onAdOpened.");
        try {
            this.zza.zzp();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onVideoEnd(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzciz.zze("Adapter called onVideoEnd.");
        try {
            this.zza.zzv();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final NativeCustomTemplateAd zza() {
        return this.zzc;
    }

    public final UnifiedNativeAdMapper zzb() {
        return this.zzb;
    }

    public final void zzc(MediationNativeAdapter mediationNativeAdapter, NativeCustomTemplateAd nativeCustomTemplateAd) {
        String str;
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        String valueOf = String.valueOf(nativeCustomTemplateAd.getCustomTemplateId());
        if (valueOf.length() != 0) {
            str = "Adapter called onAdLoaded with template id ".concat(valueOf);
        } else {
            str = new String("Adapter called onAdLoaded with template id ");
        }
        zzciz.zze(str);
        this.zzc = nativeCustomTemplateAd;
        try {
            this.zza.zzo();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void zzd(MediationBannerAdapter mediationBannerAdapter, String str, String str2) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzciz.zze("Adapter called onAppEvent.");
        try {
            this.zza.zzq(str, str2);
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void zze(MediationNativeAdapter mediationNativeAdapter, NativeCustomTemplateAd nativeCustomTemplateAd, String str) {
        if (nativeCustomTemplateAd instanceof zzbpd) {
            try {
                this.zza.zzr(((zzbpd) nativeCustomTemplateAd).zza(), str);
            } catch (RemoteException e11) {
                zzciz.zzl("#007 Could not call remote method.", e11);
            }
        } else {
            zzciz.zzj("Unexpected native custom template ad type.");
        }
    }

    public final void onAdClicked(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzciz.zze("Adapter called onAdClicked.");
        try {
            this.zza.zze();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onAdClosed(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzciz.zze("Adapter called onAdClosed.");
        try {
            this.zza.zzf();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onAdFailedToLoad(MediationBannerAdapter mediationBannerAdapter, AdError adError) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        int code = adError.getCode();
        String message = adError.getMessage();
        String domain = adError.getDomain();
        StringBuilder sb2 = new StringBuilder(String.valueOf(message).length() + 97 + String.valueOf(domain).length());
        sb2.append("Adapter called onAdFailedToLoad with error. ErrorCode: ");
        sb2.append(code);
        sb2.append(". ErrorMessage: ");
        sb2.append(message);
        sb2.append(". ErrorDomain: ");
        sb2.append(domain);
        zzciz.zze(sb2.toString());
        try {
            this.zza.zzh(adError.zza());
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onAdLeftApplication(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzciz.zze("Adapter called onAdLeftApplication.");
        try {
            this.zza.zzn();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onAdLoaded(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzciz.zze("Adapter called onAdLoaded.");
        try {
            this.zza.zzo();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onAdOpened(MediationInterstitialAdapter mediationInterstitialAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzciz.zze("Adapter called onAdOpened.");
        try {
            this.zza.zzp();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onAdClicked(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        UnifiedNativeAdMapper unifiedNativeAdMapper = this.zzb;
        if (this.zzc == null) {
            if (unifiedNativeAdMapper == null) {
                zzciz.zzl("#007 Could not call remote method.", (Throwable) null);
                return;
            } else if (!unifiedNativeAdMapper.getOverrideClickHandling()) {
                zzciz.zze("Could not call onAdClicked since setOverrideClickHandling is not set to true");
                return;
            }
        }
        zzciz.zze("Adapter called onAdClicked.");
        try {
            this.zza.zze();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onAdClosed(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzciz.zze("Adapter called onAdClosed.");
        try {
            this.zza.zzf();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onAdLeftApplication(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzciz.zze("Adapter called onAdLeftApplication.");
        try {
            this.zza.zzn();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onAdLoaded(MediationNativeAdapter mediationNativeAdapter, UnifiedNativeAdMapper unifiedNativeAdMapper) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzciz.zze("Adapter called onAdLoaded.");
        this.zzb = unifiedNativeAdMapper;
        if (!(mediationNativeAdapter instanceof AdMobAdapter)) {
            VideoController videoController = new VideoController();
            videoController.zzb(new zzbxx());
            if (unifiedNativeAdMapper != null && unifiedNativeAdMapper.hasVideoContent()) {
                unifiedNativeAdMapper.zze(videoController);
            }
        }
        try {
            this.zza.zzo();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onAdOpened(MediationNativeAdapter mediationNativeAdapter) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzciz.zze("Adapter called onAdOpened.");
        try {
            this.zza.zzp();
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onAdFailedToLoad(MediationInterstitialAdapter mediationInterstitialAdapter, int i11) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        StringBuilder sb2 = new StringBuilder(55);
        sb2.append("Adapter called onAdFailedToLoad with error ");
        sb2.append(i11);
        sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
        zzciz.zze(sb2.toString());
        try {
            this.zza.zzg(i11);
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onAdFailedToLoad(MediationInterstitialAdapter mediationInterstitialAdapter, AdError adError) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        int code = adError.getCode();
        String message = adError.getMessage();
        String domain = adError.getDomain();
        StringBuilder sb2 = new StringBuilder(String.valueOf(message).length() + 97 + String.valueOf(domain).length());
        sb2.append("Adapter called onAdFailedToLoad with error. ErrorCode: ");
        sb2.append(code);
        sb2.append(". ErrorMessage: ");
        sb2.append(message);
        sb2.append(". ErrorDomain: ");
        sb2.append(domain);
        zzciz.zze(sb2.toString());
        try {
            this.zza.zzh(adError.zza());
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onAdFailedToLoad(MediationNativeAdapter mediationNativeAdapter, int i11) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        StringBuilder sb2 = new StringBuilder(55);
        sb2.append("Adapter called onAdFailedToLoad with error ");
        sb2.append(i11);
        sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
        zzciz.zze(sb2.toString());
        try {
            this.zza.zzg(i11);
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void onAdFailedToLoad(MediationNativeAdapter mediationNativeAdapter, AdError adError) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        int code = adError.getCode();
        String message = adError.getMessage();
        String domain = adError.getDomain();
        StringBuilder sb2 = new StringBuilder(String.valueOf(message).length() + 97 + String.valueOf(domain).length());
        sb2.append("Adapter called onAdFailedToLoad with error. ErrorCode: ");
        sb2.append(code);
        sb2.append(". ErrorMessage: ");
        sb2.append(message);
        sb2.append(". ErrorDomain: ");
        sb2.append(domain);
        zzciz.zze(sb2.toString());
        try {
            this.zza.zzh(adError.zza());
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }
}

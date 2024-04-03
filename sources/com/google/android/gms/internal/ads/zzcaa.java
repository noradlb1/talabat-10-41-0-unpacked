package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardItem;

final class zzcaa implements MediationBannerAdCallback, MediationInterstitialAdCallback, MediationRewardedAdCallback, MediationNativeAdCallback {
    final zzbxn zza;

    public zzcaa(zzbxn zzbxn) {
        this.zza = zzbxn;
    }

    public final void onAdClosed() {
        try {
            this.zza.zzf();
        } catch (RemoteException unused) {
        }
    }

    public final void onAdFailedToShow(AdError adError) {
        try {
            int code = adError.getCode();
            String message = adError.getMessage();
            String domain = adError.getDomain();
            StringBuilder sb2 = new StringBuilder(String.valueOf(message).length() + 86 + String.valueOf(domain).length());
            sb2.append("Mediated ad failed to show: Error Code = ");
            sb2.append(code);
            sb2.append(". Error Message = ");
            sb2.append(message);
            sb2.append(" Error Domain = ");
            sb2.append(domain);
            zzciz.zzj(sb2.toString());
            this.zza.zzk(adError.zza());
        } catch (RemoteException unused) {
        }
    }

    public final void onAdLeftApplication() {
        try {
            this.zza.zzn();
        } catch (RemoteException unused) {
        }
    }

    public final void onAdOpened() {
        try {
            this.zza.zzp();
        } catch (RemoteException unused) {
        }
    }

    public final void onUserEarnedReward(RewardItem rewardItem) {
        try {
            this.zza.zzt(new zzcfq(rewardItem));
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoComplete() {
        try {
            this.zza.zzv();
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoMute() {
    }

    public final void onVideoPause() {
        try {
            this.zza.zzw();
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoPlay() {
        try {
            this.zza.zzx();
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoStart() {
        try {
            this.zza.zzy();
        } catch (RemoteException unused) {
        }
    }

    public final void onVideoUnmute() {
    }

    public final void reportAdClicked() {
        try {
            this.zza.zze();
        } catch (RemoteException unused) {
        }
    }

    public final void reportAdImpression() {
        try {
            this.zza.zzm();
        } catch (RemoteException unused) {
        }
    }

    public final void onAdFailedToShow(String str) {
        String str2;
        try {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2 = "Mediated ad failed to show: ".concat(valueOf);
            } else {
                str2 = new String("Mediated ad failed to show: ");
            }
            zzciz.zzj(str2);
            this.zza.zzl(str);
        } catch (RemoteException unused) {
        }
    }
}

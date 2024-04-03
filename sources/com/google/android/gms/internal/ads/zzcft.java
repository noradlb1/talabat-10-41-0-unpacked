package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd;
import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzcft extends RewardedInterstitialAd {
    private final String zza;
    private final zzcez zzb;
    private final Context zzc;
    private final zzcfr zzd = new zzcfr();
    @Nullable
    private FullScreenContentCallback zze;
    @Nullable
    private OnAdMetadataChangedListener zzf;
    @Nullable
    private OnPaidEventListener zzg;

    public zzcft(Context context, String str) {
        this.zza = str;
        this.zzc = context.getApplicationContext();
        this.zzb = zzbgo.zza().zzp(context, str, new zzbxe());
    }

    public final Bundle getAdMetadata() {
        try {
            zzcez zzcez = this.zzb;
            if (zzcez != null) {
                return zzcez.zzb();
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
        return new Bundle();
    }

    public final String getAdUnitId() {
        return this.zza;
    }

    @Nullable
    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zze;
    }

    @Nullable
    public final OnAdMetadataChangedListener getOnAdMetadataChangedListener() {
        return this.zzf;
    }

    @Nullable
    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zzg;
    }

    @NonNull
    public final ResponseInfo getResponseInfo() {
        zzbiw zzbiw = null;
        try {
            zzcez zzcez = this.zzb;
            if (zzcez != null) {
                zzbiw = zzcez.zzc();
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
        return ResponseInfo.zzb(zzbiw);
    }

    @NonNull
    public final RewardItem getRewardItem() {
        zzcew zzcew;
        try {
            zzcez zzcez = this.zzb;
            if (zzcez != null) {
                zzcew = zzcez.zzd();
            } else {
                zzcew = null;
            }
            if (zzcew != null) {
                return new zzcfj(zzcew);
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
        return RewardItem.DEFAULT_REWARD;
    }

    public final void setFullScreenContentCallback(@Nullable FullScreenContentCallback fullScreenContentCallback) {
        this.zze = fullScreenContentCallback;
        this.zzd.zzb(fullScreenContentCallback);
    }

    public final void setImmersiveMode(boolean z11) {
        try {
            zzcez zzcez = this.zzb;
            if (zzcez != null) {
                zzcez.zzh(z11);
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void setOnAdMetadataChangedListener(@Nullable OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.zzf = onAdMetadataChangedListener;
        try {
            zzcez zzcez = this.zzb;
            if (zzcez != null) {
                zzcez.zzi(new zzbki(onAdMetadataChangedListener));
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        this.zzg = onPaidEventListener;
        try {
            zzcez zzcez = this.zzb;
            if (zzcez != null) {
                zzcez.zzj(new zzbkj(onPaidEventListener));
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        try {
            zzcez zzcez = this.zzb;
            if (zzcez != null) {
                zzcez.zzl(new zzcfn(serverSideVerificationOptions));
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void show(@NonNull Activity activity, @NonNull OnUserEarnedRewardListener onUserEarnedRewardListener) {
        this.zzd.zzc(onUserEarnedRewardListener);
        try {
            zzcez zzcez = this.zzb;
            if (zzcez != null) {
                zzcez.zzk(this.zzd);
                this.zzb.zzm(ObjectWrapper.wrap(activity));
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void zza(zzbjg zzbjg, RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback) {
        try {
            zzcez zzcez = this.zzb;
            if (zzcez != null) {
                zzcez.zzg(zzbfh.zza.zza(this.zzc, zzbjg), new zzcfs(rewardedInterstitialAdLoadCallback, this));
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }
}

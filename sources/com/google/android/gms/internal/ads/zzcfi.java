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
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzcfi extends RewardedAd {
    private final String zza;
    private final zzcez zzb;
    private final Context zzc;
    private final zzcfr zzd = new zzcfr();
    @Nullable
    private OnAdMetadataChangedListener zze;
    @Nullable
    private OnPaidEventListener zzf;
    @Nullable
    private FullScreenContentCallback zzg;

    public zzcfi(Context context, String str) {
        this.zzc = context.getApplicationContext();
        this.zza = str;
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

    @NonNull
    public final String getAdUnitId() {
        return this.zza;
    }

    @Nullable
    public final FullScreenContentCallback getFullScreenContentCallback() {
        return this.zzg;
    }

    @Nullable
    public final OnAdMetadataChangedListener getOnAdMetadataChangedListener() {
        return this.zze;
    }

    @Nullable
    public final OnPaidEventListener getOnPaidEventListener() {
        return this.zzf;
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
            if (zzcew == null) {
                return RewardItem.DEFAULT_REWARD;
            }
            return new zzcfj(zzcew);
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
            return RewardItem.DEFAULT_REWARD;
        }
    }

    public final void setFullScreenContentCallback(@Nullable FullScreenContentCallback fullScreenContentCallback) {
        this.zzg = fullScreenContentCallback;
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
        try {
            this.zze = onAdMetadataChangedListener;
            zzcez zzcez = this.zzb;
            if (zzcez != null) {
                zzcez.zzi(new zzbki(onAdMetadataChangedListener));
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        try {
            this.zzf = onPaidEventListener;
            zzcez zzcez = this.zzb;
            if (zzcez != null) {
                zzcez.zzj(new zzbkj(onPaidEventListener));
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }

    public final void setServerSideVerificationOptions(@Nullable ServerSideVerificationOptions serverSideVerificationOptions) {
        if (serverSideVerificationOptions != null) {
            try {
                zzcez zzcez = this.zzb;
                if (zzcez != null) {
                    zzcez.zzl(new zzcfn(serverSideVerificationOptions));
                }
            } catch (RemoteException e11) {
                zzciz.zzl("#007 Could not call remote method.", e11);
            }
        }
    }

    public final void show(@NonNull Activity activity, @NonNull OnUserEarnedRewardListener onUserEarnedRewardListener) {
        this.zzd.zzc(onUserEarnedRewardListener);
        if (activity == null) {
            zzciz.zzj("The activity for show is null, will proceed with show using the context provided when loading the ad.");
        }
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

    public final void zza(zzbjg zzbjg, RewardedAdLoadCallback rewardedAdLoadCallback) {
        try {
            zzcez zzcez = this.zzb;
            if (zzcez != null) {
                zzcez.zzf(zzbfh.zza.zza(this.zzc, zzbjg), new zzcfm(rewardedAdLoadCallback, this));
            }
        } catch (RemoteException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
        }
    }
}

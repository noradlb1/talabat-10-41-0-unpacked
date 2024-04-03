package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

public final class zzdog implements zzder, zzdlo {
    private final zzcgq zza;
    private final Context zzb;
    private final zzchh zzc;
    @Nullable
    private final View zzd;
    private String zze;
    private final zzbbg zzf;

    public zzdog(zzcgq zzcgq, Context context, zzchh zzchh, @Nullable View view, zzbbg zzbbg) {
        this.zza = zzcgq;
        this.zzb = context;
        this.zzc = zzchh;
        this.zzd = view;
        this.zzf = zzbbg;
    }

    public final void zzbD() {
    }

    public final void zze() {
    }

    public final void zzf() {
        String str;
        String str2;
        String zzd2 = this.zzc.zzd(this.zzb);
        this.zze = zzd2;
        String valueOf = String.valueOf(zzd2);
        if (this.zzf == zzbbg.REWARD_BASED_VIDEO_AD) {
            str = "/Rewarded";
        } else {
            str = "/Interstitial";
        }
        if (str.length() != 0) {
            str2 = valueOf.concat(str);
        } else {
            str2 = new String(valueOf);
        }
        this.zze = str2;
    }

    public final void zzj() {
        this.zza.zzb(false);
    }

    public final void zzm() {
    }

    public final void zzo() {
        View view = this.zzd;
        if (!(view == null || this.zze == null)) {
            this.zzc.zzs(view.getContext(), this.zze);
        }
        this.zza.zzb(true);
    }

    @ParametersAreNonnullByDefault
    public final void zzp(zzceg zzceg, String str, String str2) {
        if (this.zzc.zzu(this.zzb)) {
            try {
                zzchh zzchh = this.zzc;
                Context context = this.zzb;
                zzchh.zzo(context, zzchh.zza(context), this.zza.zza(), zzceg.zzc(), zzceg.zzb());
            } catch (RemoteException e11) {
                zzciz.zzk("Remote Exception to get reward item.", e11);
            }
        }
    }

    public final void zzr() {
    }
}

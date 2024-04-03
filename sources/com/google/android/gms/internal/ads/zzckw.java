package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.Preconditions;

public final class zzckw {
    private final Context zza;
    private final zzclh zzb;
    private final ViewGroup zzc;
    private zzckv zzd;

    public zzckw(Context context, ViewGroup viewGroup, zzcop zzcop) {
        this.zza = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzc = viewGroup;
        this.zzb = zzcop;
        this.zzd = null;
    }

    public final zzckv zza() {
        Preconditions.checkMainThread("getAdVideoUnderlay must be called from the UI thread.");
        return this.zzd;
    }

    public final void zzb(int i11, int i12, int i13, int i14) {
        Preconditions.checkMainThread("The underlay may only be modified from the UI thread.");
        zzckv zzckv = this.zzd;
        if (zzckv != null) {
            zzckv.zzD(i11, i12, i13, i14);
        }
    }

    public final void zzc(int i11, int i12, int i13, int i14, int i15, boolean z11, zzclg zzclg) {
        if (this.zzd == null) {
            zzblq.zza(this.zzb.zzo().zza(), this.zzb.zzn(), "vpr2");
            Context context = this.zza;
            zzclh zzclh = this.zzb;
            zzckv zzckv = new zzckv(context, zzclh, i15, z11, zzclh.zzo().zza(), zzclg);
            this.zzd = zzckv;
            this.zzc.addView(zzckv, 0, new ViewGroup.LayoutParams(-1, -1));
            int i16 = i11;
            int i17 = i12;
            int i18 = i13;
            int i19 = i14;
            this.zzd.zzD(i11, i12, i13, i14);
            this.zzb.zzB(false);
        }
    }

    public final void zzd() {
        Preconditions.checkMainThread("onDestroy must be called from the UI thread.");
        zzckv zzckv = this.zzd;
        if (zzckv != null) {
            zzckv.zzn();
            this.zzc.removeView(this.zzd);
            this.zzd = null;
        }
    }

    public final void zze() {
        Preconditions.checkMainThread("onPause must be called from the UI thread.");
        zzckv zzckv = this.zzd;
        if (zzckv != null) {
            zzckv.zzs();
        }
    }

    public final void zzf(int i11) {
        Preconditions.checkMainThread("setPlayerBackgroundColor must be called from the UI thread.");
        zzckv zzckv = this.zzd;
        if (zzckv != null) {
            zzckv.zzA(i11);
        }
    }
}

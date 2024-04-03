package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzcop;

@VisibleForTesting
public final class zzh {
    public final int zza;
    public final ViewGroup.LayoutParams zzb;
    public final ViewGroup zzc;
    public final Context zzd;

    public zzh(zzcop zzcop) throws zzf {
        this.zzb = zzcop.getLayoutParams();
        ViewParent parent = zzcop.getParent();
        this.zzd = zzcop.zzG();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new zzf("Could not get the parent of the WebView for an overlay.");
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        this.zzc = viewGroup;
        this.zza = viewGroup.indexOfChild(zzcop.zzH());
        viewGroup.removeView(zzcop.zzH());
        zzcop.zzap(true);
    }
}

package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzbes;
import com.google.android.gms.internal.ads.zzdmd;

public final class zzm {
    public static final void zza(Context context, AdOverlayInfoParcel adOverlayInfoParcel, boolean z11) {
        zzu zzu;
        if (adOverlayInfoParcel.zzk == 4 && adOverlayInfoParcel.zzc == null) {
            zzbes zzbes = adOverlayInfoParcel.zzb;
            if (zzbes != null) {
                zzbes.onAdClicked();
            }
            zzdmd zzdmd = adOverlayInfoParcel.zzy;
            if (zzdmd != null) {
                zzdmd.zzq();
            }
            Activity zzk = adOverlayInfoParcel.zzd.zzk();
            zzc zzc = adOverlayInfoParcel.zza;
            if (!(zzc == null || !zzc.zzj || zzk == null)) {
                context = zzk;
            }
            zzt.zzi();
            zzc zzc2 = adOverlayInfoParcel.zza;
            zzw zzw = adOverlayInfoParcel.zzi;
            if (zzc2 != null) {
                zzu = zzc2.zzi;
            } else {
                zzu = null;
            }
            zza.zzb(context, zzc2, zzw, zzu);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.zzm.zzd);
        intent.putExtra("shouldCallOnOverlayOpened", z11);
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
        if (!PlatformVersion.isAtLeastLollipop()) {
            intent.addFlags(524288);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        zzt.zzp();
        com.google.android.gms.ads.internal.util.zzt.zzQ(context, intent);
    }
}

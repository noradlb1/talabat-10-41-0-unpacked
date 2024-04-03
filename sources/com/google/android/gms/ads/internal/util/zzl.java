package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.internal.ads.zzbmf;
import com.google.android.gms.internal.ads.zzbmh;
import com.google.android.gms.internal.ads.zzgqf;

final class zzl implements zzbmf {
    final /* synthetic */ zzbmh zza;
    final /* synthetic */ Context zzb;
    final /* synthetic */ Uri zzc;

    public zzl(zzt zzt, zzbmh zzbmh, Context context, Uri uri) {
        this.zza = zzbmh;
        this.zzb = context;
        this.zzc = uri;
    }

    public final void zza() {
        CustomTabsIntent build = new CustomTabsIntent.Builder(this.zza.zza()).build();
        build.intent.setPackage(zzgqf.zza(this.zzb));
        build.launchUrl(this.zzb, this.zzc);
        this.zza.zzf((Activity) this.zzb);
    }
}
